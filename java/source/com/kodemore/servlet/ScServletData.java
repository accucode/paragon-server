/*
  Copyright (c) 2005-2018 www.kodemore.com

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in
  all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  THE SOFTWARE.
 */

package com.kodemore.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileCleaningTracker;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.file.KmFile;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.json.KmJsonObjectIF;
import com.kodemore.log.KmLog;
import com.kodemore.log.KmLogger;
import com.kodemore.servlet.ajax.ScAjaxResult;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.encoder.ScDecoder;
import com.kodemore.servlet.result.ScByteResult;
import com.kodemore.servlet.result.ScResultIF;
import com.kodemore.servlet.result.ScStringResult;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.utility.ScBridge;
import com.kodemore.servlet.utility.ScControlRegistry;
import com.kodemore.thread.KmThreadLocalManager;
import com.kodemore.time.KmDate;
import com.kodemore.utility.KmConstantsIF;
import com.kodemore.utility.KmVirtualOptions;
import com.kodemore.utility.Kmu;

/**
 * I provide a convenient wrapper for holding onto the servlet, http request,
 * and http response.  In addition to the various convenience methods implemented
 * here, this wrapper also provided a more convenient way to pass the servlet,
 * request, and reponse through the method call stack; this help clean up the code
 * when applying a thread safe implementation of servlets and page handlers.
 */
public class ScServletData
    implements ScConstantsIF, KmConstantsIF
{
    //##################################################
    //# static
    //##################################################

    private static final KmLogger logger = KmLogger.create(ScServletData.class);

    //##################################################
    //# instance creation
    //##################################################

    public static void _install(ScServletData data)
    {
        data.setLocal();
        data.reset();
    }

    //##################################################
    //# variables (delgates)
    //##################################################

    private HttpServlet         _servlet;
    private HttpServletRequest  _request;
    private HttpServletResponse _response;

    //##################################################
    //# variables (setup)
    //##################################################

    /**
     * The time when I was created.  Used for logging.
     */
    private long _creationTimeNanos;

    /**
     * Determines if parameters values should be normalized.
     * Normalized values strip non-printable characters, and
     * trim leading and trailing whitespace.  This is normally
     * desireable as it helps avoid a large number of potential
     * problems.
     */
    private boolean _normalizeParameterValues;

    /**
     * The list of parameters extracted from the http request so that
     * values can be overridden during processing.
     */
    private ScParameterList _parameters;

    /**
     * This is the value submitted in the form's argument parameter.
     * The argument is assumed to have been formatted using ScEncoder.
     * This object is the result of decoding the argument upon initialization.
     * If the argument cannot be parsed it is set to null and an warning
     * is logged.
     */
    private Object _argument;

    /**
     * The persistent session information that is propogated through
     * the page's http request cycle, rather than being stored in the
     * server side http session.  Most session information should
     * be stored here.
     */
    private ScPageSession _pageSession;

    //##################################################
    //# variables (response)
    //##################################################

    /**
     * The result that we intend to write to the http response.
     * We store the result in this manner so that we can defer
     * writing the http response until after we have confirmed
     * that the database transaction successfully committed.
     */
    private ScResultIF _result;

    /**
     * The number of bytes written to the http response.
     * This value is only set when the http response is written.
     * Setting the "result" does not immediately affect this value.
     */
    private int _responseSize;

    /**
     * I provide a copy of the cookies that are set into the response.
     * This is so that the value can be retrieved within the same
     * http request cycle.
     */
    private KmMap<String,Cookie> _setCookies;

    //##################################################
    //# constructor
    //##################################################

    protected ScServletData(
        HttpServlet servlet,
        HttpServletRequest request,
        HttpServletResponse response)
    {
        _servlet = servlet;
        _request = request;
        _response = response;

        _normalizeParameterValues = true;
        _creationTimeNanos = System.nanoTime();
    }

    /**
     * If a database transaction fails, then the transient changes to
     * to the servlet data should be reset.  This method resets the
     * appropriate data.
     */
    public void reset()
    {
        installVariables();
        installParameters();
        installArgument();
        installPageSession();
        installForm();
    }

    private void installVariables()
    {
        _setCookies = new KmMap<>();
        _result = null;
    }

    private void installParameters()
    {
        _parameters = new ScParameterList();

        Enumeration<String> e = getParameterNames();
        while ( e.hasMoreElements() )
        {
            String key = e.nextElement();
            String[] values = _request.getParameterValues(key);

            for ( String value : values )
            {
                value = _normalize(value);
                _parameters.addValue(key, value);
            }
        }
    }

    private Enumeration<String> getParameterNames()
    {
        return _request.getParameterNames();
    }

    private void installArgument()
    {
        String s = getParameter(PARAMETER_ARGUMENT);
        try
        {
            _argument = ScDecoder.staticDecode(s);
        }
        catch ( RuntimeException e )
        {
            logger.error("Cannot decode argument(%s).", s);
            _argument = null;
        }
    }

    private void installForm()
    {
        String token = getParameter(PARAMETER_FORM_TOKEN);
        if ( Kmu.isEmpty(token) )
            return;

        ScControl c;
        c = ScControlRegistry.getInstance().findToken(token);
        c.readParameters();
    }

    //##################################################
    //# accessing
    //##################################################

    public HttpServlet _getServlet()
    {
        return _servlet;
    }

    public HttpServletRequest _getRequest()
    {
        return _request;
    }

    public HttpServletResponse _getResponse()
    {
        return _response;
    }

    public boolean getNormalizeParameterValues()
    {
        return _normalizeParameterValues;
    }

    public void setNormalizeParameterValues(boolean e)
    {
        _normalizeParameterValues = e;
    }

    public long getCreationTimeNanos()
    {
        return _creationTimeNanos;
    }

    //##################################################
    //# request (misc)
    //##################################################

    /**
     * Determine if a query string was provided to specify parameters.
     * Query strings are the parameters on the GET, not on the POST.
     */
    public boolean hasQueryString()
    {
        return Kmu.hasValue(_getRequest().getQueryString());
    }

    public String getQueryString()
    {
        return _getRequest().getQueryString();
    }

    /**
     * Request: http://localhost:8080/app/servlet/account/test?key=value
     *       => http://localhost:8080/app/servlet/account/test
     */
    public String getRequestUri()
    {
        return _getRequest().getRequestURI();
    }

    public String getRequestUriAndQueryString()
    {
        String uri = getRequestUri();
        return addQueryString(uri);
    }

    public String getRequestUrlWithoutQueryString()
    {
        return _getRequest().getRequestURL().toString();
    }

    public String getFullRequestUrl()
    {
        String url = _getRequest().getRequestURL().toString();
        return addQueryString(url);
    }

    private String addQueryString(String uri)
    {
        String query = _getRequest().getQueryString();
        if ( query == null )
            return uri;

        return uri + "?" + query;
    }

    /**
     * E.g.: HTTP/1.1
     */
    public String getProtocol()
    {
        return _getRequest().getProtocol();
    }

    /**
     * E.g.: http
     */
    public String getRequestScheme()
    {
        return _getRequest().getScheme();
    }

    public String getRequestServerHostName()
    {
        return _getRequest().getServerName();
    }

    public int getRequestServerPort()
    {
        return _getRequest().getServerPort();
    }

    public Iterator<String> getHeaderNames()
    {
        KmList<String> v = new KmList<>();
        v.addAllUnchecked(_getRequest().getHeaderNames());
        v.sort();
        return v.iterator();
    }

    public String getHeader(String name)
    {
        return _getRequest().getHeader(name);
    }

    public InputStream getInputStream()
    {
        try
        {
            return _getRequest().getInputStream();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public HttpSession _getHttpSession()
    {
        HttpSession e;
        e = _getRequest().getSession();
        e.setMaxInactiveInterval(getSessionTimeoutSeconds());
        return e;
    }

    public String getRemoteIpAddress()
    {
        return _request.getRemoteAddr();
    }

    //##################################################
    //# multi part
    //##################################################

    /**
     * Get the uploaded files from a multi-part upload.
     *
     * This relies on the Apache Commons DiskFileItemFactory and may introduce some
     * architectural considerations.
     *
     * 1) deletion of (Apache's) temporary files
     * 2) clean shutdown of servlet container
     * 3) security
     *
     * For additional info see here... http://goo.gl/q93J27
     *
     * Security Review
     *     Local untrusted users could change the contents of the
     *     temp files causing unknown an probable malicous behavior.  This is not
     *     a problem if you use an isolated web server which does not allow local
     *     logins for users.  Our users are considered trusted and already have root
     *     privileges.  I see no issue for us.
     *
     * Temp file deleteion
     *     We need to implement a FileCleaningTracker (thread?) which cleans up the
     *     files when the File object is garbage collected.
     *
     * Shutdown
     *      This thread needs to add terminated during shutdown of the servlet
     *      container( web application).
     *      See http://bit.ly/1rmDy1f for additional information.
     *
     *       Adding the following the web.xml should shutdown the thread.
     *       <web-app>
     *         ...
     *         <listener>
     *           <listener-class>
     *             org.apache.commons.fileupload.servlet.FileCleanerCleanup
     *           </listener-class>
     *         </listener>
     *         ...
     *       </web-app>
     *
     */
    public KmList<FileItem> getUploadedFiles()
    {
        try
        {
            DiskFileItemFactory factory = createDiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> items = upload.parseRequest(_getRequest());
            return new KmList<>(items);
        }
        catch ( FileUploadException ex )
        {
            KmLog.error(ex, "Cannot get uploaded files.");
            return new KmList<>();
        }
    }

    private DiskFileItemFactory createDiskFileItemFactory()
    {
        DiskFileItemFactory x = new DiskFileItemFactory();
        x.setFileCleaningTracker(new FileCleaningTracker());
        return x;

    }

    //##################################################
    //# request paths
    //##################################################

    /**
     * Returns the portion of the path that identifies the application
     * context.   Any leading or trailing slashes are removed.
     *
     * Request... http://localhost:8080/app/servlet/main/test?key=value
     *         => app
     */
    public String getContextPath()
    {
        return Kmu.trimSlashes(_getRequest().getContextPath());
    }

    /**
     * Returns the portion of the path that identifies the specific servlet
     * based on the configuration of the web.xml file. Any leading or trailing
     * slashes are removed.
     *
     * Request... http://localhost:8080/app/servlet/main/test?key=value
     *         => servlet/main
     */
    public String getServletPath()
    {
        return Kmu.trimSlashes(_getRequest().getServletPath());
    }

    /**
     * Returns the portion of the path AFTER the servlet path.
     * Any leading or trailing slashes are removed.
     *
     * Request... http://localhost:8080/app/servlet/main/test?key=value
     *         => test
     */
    public String getExtraPath()
    {
        return Kmu.trimSlashes(_getRequest().getPathInfo());
    }

    /**
     * Returns the entire path; everything after the machine
     * and before the query parameters.
     *
     * Request... http://localhost:8080/app/servlet/main/test?key=value
     *         => /app/servlet/main/test
     */
    public String getFullPath()
    {
        return getRequestUri();
    }

    //##################################################
    //# request (user agent)
    //##################################################

    public String getUserAgent()
    {
        return _request.getHeader("User-Agent");
    }

    public boolean isUserAgentFirefox()
    {
        return userAgentContains("firefox");
    }

    public boolean isUserAgentFirefox3()
    {
        return userAgentContains("firefox/3");
    }

    public boolean isUserAgentGoogleChrome()
    {
        return userAgentContains("chrome");
    }

    public boolean isUserAgentInternetExplorer()
    {
        return userAgentContains("msie");
    }

    public boolean isUserAgentMobile()
    {
        return isUserAgentWindowsCe() || isUserAgentWindowsPocketPc();
    }

    public boolean isUserAgentWindowsCe()
    {
        return userAgentContains("Windows CE");
    }

    public boolean isUserAgentWindowsPocketPc()
    {
        return userAgentContains("PPC");
    }

    public boolean userAgentContains(String s)
    {
        return getUserAgent().toLowerCase().indexOf(s.toLowerCase()) >= 0;
    }

    //##################################################
    //# request (parameters)
    //##################################################

    public String getParameter(String key)
    {
        return _parameters.getString(key);
    }

    public boolean hasParameters()
    {
        return _parameters.isNotEmpty();
    }

    public boolean hasParameter(String key)
    {
        return _parameters.hasKey(key);
    }

    public ScParameterList getParameterList()
    {
        return _parameters;
    }

    public KmList<String> getParameterKeys()
    {
        return _parameters.getKeys();
    }

    public void setParameter(String key, String value)
    {
        _parameters.setString(key, value);
    }

    public void clearParameter(String key)
    {
        _parameters.removeKey(key);
    }

    public KmList<String> getParameterKeysStartingWith(String prefix)
    {
        KmList<String> v = new KmList<>();
        for ( String s : getParameterKeys() )
            if ( s.startsWith(prefix) )
                v.add(s);
        return v;
    }

    public KmList<String> getParametersStartingWith(String prefix)
    {
        KmList<String> v = new KmList<>();
        KmList<String> keys = getParameterKeysStartingWith(prefix);
        for ( String key : keys )
            v.add(getParameter(key));
        return v;
    }

    public KmList<String> getParameters(String key)
    {
        return _parameters.getValues(key);
    }

    public String formatParametersAsQueryString()
    {
        return getParameterList().formatQueryString();
    }

    //##################################################
    //# debug
    //##################################################

    public void printParameters()
    {
        KmList<String> keys;
        keys = getParameterKeys();
        keys.sort();

        System.out.println("Parameters: " + keys.size());
        for ( String key : keys )
        {
            KmList<String> values = getParameters(key);
            System.out.printf("    %s = %s%n", key, values.join());
        }
    }

    public void printHexParameters()
    {
        KmList<String> keys;
        keys = getParameterKeys();
        keys.sort();

        System.out.println("Parameters: " + keys.size());
        for ( String key : keys )
        {
            KmList<String> values = getParameters(key).collect(e -> Kmu.formatHexDisplayString(e));
            System.out.printf("    %s = %s%n", key, values.join());
        }
    }

    public void printRequestCookies()
    {
        System.out.println("printRequestCookies...");

        Cookie[] arr = _getRequest().getCookies();
        if ( arr == null )
        {
            System.out.println("    " + KmVirtualOptions.NONE);
            return;
        }

        for ( Cookie e : arr )
            System.out.printf("    %s = %s%n", e.getName(), Kmu.decodeUtf8(e.getValue()));
    }

    //##################################################
    //# cookies
    //##################################################

    public void setCookie(String key, String value)
    {
        setCookie(key, value, null, false);
    }

    public void setCookie(String key, String value, Integer expireSeconds, boolean secure)
    {
        Cookie cookie;
        cookie = newCookie(key, value);

        if ( expireSeconds != null )
            cookie.setMaxAge(expireSeconds);

        if ( secure )
            cookie.setSecure(true);

        _setCookie(cookie);
    }

    public String getCookie(String key)
    {
        Cookie c = _getCookie(key);
        return c == null
            ? null
            : Kmu.decodeUtf8(c.getValue());
    }

    public boolean hasCookie(String key)
    {
        return _getCookie(key) != null;
    }

    public void clearCookie(String key)
    {
        Cookie e = newCookie(key, null);
        _clearCookie(e);
    }

    //##################################################
    //# cookie (support)
    //##################################################

    private KmList<Cookie> _getCookies()
    {
        KmMap<String,Cookie> m = new KmMap<>();

        Cookie[] cookies = _getRequest().getCookies();
        if ( cookies != null )
            for ( Cookie e : cookies )
                m.put(e.getName(), e);

        for ( Cookie e : _setCookies.getValues() )
            m.put(e.getName(), e);

        KmList<Cookie> v = new KmList<>();
        for ( Cookie e : m.getValues() )
            if ( Kmu.isNotEqual(e.getValue(), REMOVED_COOKIE_VALUE) )
                v.add(e);

        return v;
    }

    private Cookie _getCookie(String name)
    {
        for ( Cookie e : _getCookies() )
            if ( e.getName().equals(name) )
                return e;

        return null;
    }

    /**
     * The cookie should be a new instance that contains the correct
     * values for name, domain, and path.
     */
    public void _clearCookie(Cookie e)
    {
        e.setValue(REMOVED_COOKIE_VALUE);
        e.setMaxAge(0);
        _setCookie(e);
    }

    /**
     * The cookie should be a new instance that contains the correct
     * values for name, domain, and path.
     */
    public void _setCookie(Cookie c)
    {
        // Note: the http response is updated in flushResult()
        _setCookies.put(c.getName(), c);
    }

    public void setTimeoutCookie(String name, String value, int seconds)
    {
        Cookie c;
        c = newCookie(name, value);
        c.setMaxAge(seconds);

        _setCookie(c);
    }

    private Cookie newCookie(String name, String value)
    {
        Cookie e;
        e = new Cookie(name, Kmu.encodeUtf8(value));
        e.setPath("/");
        return e;
    }

    //##################################################
    //# request (attributes)
    //##################################################

    public boolean hasAttribute(String key)
    {
        return getAttribute(key) != null;
    }

    public Object getAttribute(String key)
    {
        return _getRequest().getAttribute(key);
    }

    public void setAttribute(String key, Object e)
    {
        _getRequest().setAttribute(key, e);
    }

    public void setAttribute(String key, int i)
    {
        Integer ii = Integer.valueOf(i);
        setAttribute(key, ii);
    }

    public String getStringAttribute(String key)
    {
        return (String)getAttribute(key);
    }

    public int getIntegerAttribute(String key)
    {
        return getIntegerAttribute(key, 0);
    }

    public int getIntegerAttribute(String key, int def)
    {
        try
        {
            return ((Integer)getAttribute(key)).intValue();
        }
        catch ( Exception ex )
        {
            return def;
        }
    }

    public KmDate getDateAttribute(String key)
    {
        return getDateAttribute(key, null);
    }

    public KmDate getDateAttribute(String key, KmDate def)
    {
        if ( !hasAttribute(key) )
            return def;

        return (KmDate)getAttribute(key);
    }

    //##################################################
    //# response
    //##################################################

    public void setContentType(ScContentType e)
    {
        _getResponse().setContentType(e.getHttpValue());
    }

    public void setCharset(Charset e)
    {
        _getResponse().setCharacterEncoding(e.name());
    }

    public void setContentLength(int i)
    {
        _getResponse().setContentLength(i);
    }

    //==================================================
    //= response :: headers
    //==================================================

    public void setHeader(String key, String value)
    {
        _getResponse().setHeader(key, value);
    }

    public void setHeader(String key, int value)
    {
        _getResponse().setIntHeader(key, value);
    }

    public void setNoCacheHeaders()
    {
        setHeader("Cache-Control", "no-cache");
        setHeader("Expires", 0);
    }

    //==================================================
    //= response :: frame options
    //==================================================

    /**
     * The X-Frame-Options HTTP response header can be used to indicate
     * whether or not a browser should be allowed to render a page in a
     * <frame>, <iframe> or <object> . Sites can use this to avoid
     * clickjacking attacks, by ensuring that their content is not embedded
     * into other sites.
     */
    public void setFrameOptions(String value)
    {
        setHeader("X-Frame-Options", value);
    }

    public void setFrameOptionsDeny()
    {
        setFrameOptions("DENY");
    }

    public void setFrameOptionsSameOrigin()
    {
        setFrameOptions("SAMEORIGIN");
    }

    //==================================================
    //= response :: disposition
    //==================================================

    public void setContentDisposition(String s)
    {
        setHeader("content-disposition", s);
    }

    public void setAttachmentDisposition(String name)
    {
        setContentDisposition("attachment;filename=" + name);
    }

    //==================================================
    //= response :: writer/stream
    //==================================================

    public PrintWriter getWriter()
    {
        try
        {
            return _getResponse().getWriter();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public OutputStream getOutputStream()
    {
        try
        {
            return _getResponse().getOutputStream();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    //##################################################
    //# result
    //##################################################

    public void setResult(ScResultIF e)
    {
        _result = e;
    }

    public boolean hasResult()
    {
        return _result != null;
    }

    public void flushResult()
    {
        for ( Cookie e : _setCookies.getValues() )
            _getResponse().addCookie(e);

        if ( _result == null )
            return;

        _result.applyTo(this);
        _responseSize += _result.getLength();
    }

    public void logResults(String e)
    {
        KmLog.debug("Servlet Results: %s bytes.", e.length());
    }

    //##################################################
    //# results (convenience)
    //##################################################

    public final void setHtmlResult(CharSequence value)
    {
        boolean noCache = false;
        setHtmlResult(value, noCache);
    }

    public final void setHtmlResult(CharSequence value, boolean noCache)
    {
        ScStringResult r;
        r = new ScStringResult();
        r.setValue(value);
        r.setHttpNoCache(noCache);
        r.setContentType(ScContentType.Html);

        setResult(r);
        writeLastResults(value, "css");
    }

    public final void setEmptyHtmlResult()
    {
        setHtmlResult("");
    }

    public final void setTextResult(CharSequence value)
    {
        ScStringResult r;
        r = new ScStringResult();
        r.setValue(value);
        r.setContentType(ScContentType.Text);

        setResult(r);
        writeLastResults(value, "txt");
    }

    public final void setCssResult(CharSequence value)
    {
        ScStringResult r;
        r = new ScStringResult();
        r.setValue(value);
        r.setContentType(ScContentType.Css);

        setResult(r);
        writeLastResults(value, "css");
    }

    public final void setXmlResult(CharSequence value)
    {
        ScStringResult r;
        r = new ScStringResult();
        r.setValue(value);
        r.setContentType(ScContentType.Xml);
        setResult(r);

        writeLastResults(value, "xml");
    }

    public final void setJsonResult(KmJsonObjectIF e)
    {
        setJsonResult(e.formatJson());
    }

    public final void setJsonResult(CharSequence value)
    {
        ScStringResult r;
        r = new ScStringResult();
        r.setValue(value);
        r.setContentType(ScContentType.Json);
        setResult(r);
    }

    public final void setOctetResult(byte[] value)
    {
        ScByteResult r;
        r = new ScByteResult();
        r.setValue(value);
        r.setContentType(ScContentType.Octet);
        setResult(r);
    }

    public final void setPdfResult(byte[] value)
    {
        ScByteResult r;
        r = new ScByteResult();
        r.setValue(value);
        r.setContentType(ScContentType.Pdf);
        setResult(r);
    }

    public final void setAttachmentResult(String name, String value)
    {
        ScStringResult r;
        r = new ScStringResult();
        r.setValue(value);
        r.setAttachmentName(name);
        setResult(r);
    }

    public final void setAttachmentResult(String name, byte[] value)
    {
        ScByteResult r;
        r = new ScByteResult();
        r.setAttachmentName(name);
        r.setValue(value);
        setResult(r);
    }

    /**
     * @param value The value written to the response.
     * @param ext The file type/extension.
     */
    protected void writeLastResults(CharSequence value, String ext)
    {
        // subclass
    }

    //##################################################
    //# ajax (convenience)
    //##################################################

    public ScBlockScript ajax()
    {
        return getAjaxResult().getScript();
    }

    public ScAjaxResult getAjaxResult()
    {
        if ( _result == null )
            _result = new ScAjaxResult();

        return (ScAjaxResult)_result;
    }

    //##################################################
    //# redirect
    //##################################################

    public void redirectTo(ScBookmark b)
    {
        redirectTo(b.formatQueryString());
    }

    public void redirectTo(String url)
    {
        try
        {
            _getResponse().sendRedirect(url);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void redirectWithPost()
    {
        redirectWithPost(getParameterList());
    }

    public void redirectWithPost(String formUri)
    {
        redirectWithPost(formUri, null);
    }

    public void redirectWithPost(ScParameterList params)
    {
        redirectWithPost(getRequestUri(), params);
    }

    private void redirectWithPost(String formUri, ScParameterList params)
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.printDocType();

        out.beginHtml();

        out.beginHead();
        out.printMetaContentTypeHtml();
        out.printMetaNoCache();
        out.printTitle(getLoadingTabTitle());
        out.endHead();

        out.openBody();
        out.printAttribute("onload", "document.f.submit();");
        out.close();

        out.openForm();
        out.printAttribute("name", "f");
        out.printAttribute("action", formUri);
        out.printAttribute("method", "post");
        out.close();

        if ( params != null )
        {
            KmList<String> keys = params.getKeys();
            for ( String key : keys )
            {
                KmList<String> values = params.getValues(key);
                for ( String value : values )
                    out.printHiddenField(key, value);
            }
        }

        out.endForm();
        out.endBody();
        out.endHtml();

        String html = out.toString();
        boolean noCache = true;
        setHtmlResult(html, noCache);
    }

    //##################################################
    //# forward
    //##################################################

    public void forwardTo(String url)
    {
        try
        {
            _getRequest().getRequestDispatcher(url).forward(_getRequest(), _getResponse());
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    //##################################################
    //# misc
    //##################################################

    public boolean hasSecureRequest()
    {
        return _request.isSecure();
    }

    public void flushBuffer()
    {
        try
        {
            _response.flushBuffer();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    //##################################################
    //# resources
    //##################################################

    public String readStringResource(String path)
    {
        try (InputStream is = _servlet.getServletContext().getResourceAsStream(path);
            StringWriter sw = new StringWriter();)
        {
            while ( true )
            {
                int i = is.read();
                if ( i < 0 )
                    break;
                sw.write((char)i);
            }

            return sw.toString();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    /**
     * See HttpServlet.getResource
     * http://tomcat.apache.org/tomcat-5.5-doc/servletapi/javax/servlet/ServletContext.html#getResource(java.lang.String)
     */
    public boolean resourceExists(String path)
    {
        try
        {
            URL url = _getServlet().getServletContext().getResource(path);
            return url != null;
        }
        catch ( MalformedURLException ex )
        {
            return false;
        }
    }

    //##################################################
    //# log
    //##################################################

    public void logServletPerformance()
    {
        long now = System.nanoTime();
        _logServletPerformance(now);
    }

    private void _logServletPerformance(long now)
    {
        int size = _responseSize;
        long totalNs = now - _creationTimeNanos;
        int totalMs = (int)(totalNs / 1000000);

        boolean debug = ScPerformanceLogger.isDebugEnabled();
        if ( debug )
        {
            String msg = _composeTotalMessage(size, totalMs);
            ScPerformanceLogger.debug(msg);
        }
    }

    private String _composeTotalMessage(int size, int totalMs)
    {
        StringBuilder out;
        out = new StringBuilder();

        appendLogIdentification(out);

        out.append(" : TOTAL");
        out.append("=");
        out.append(totalMs);
        out.append("ms");
        out.append(", ");
        out.append("size=");
        out.append(Kmu.formatDouble(1.0 * size / 1024, 1));
        out.append("kb");

        return out.toString();
    }

    /**
     * @param out unused, but defined for consistency and subclasses.
     */
    public void appendLogIdentification(StringBuilder out)
    {
        // none
    }

    //##################################################
    //# private
    //##################################################

    private String _normalize(String s)
    {
        return _normalizeParameterValues
            ? ScCharsets.normalizeMultiLineString(s)
            : s;
    }

    //##################################################
    //# page session
    //##################################################

    public ScPageSession getPageSession()
    {
        return _pageSession;
    }

    private void installPageSession()
    {
        String ps = getParameter(PARAMETER_PAGE_SESSION);
        _pageSession = new ScPageSession(ps);
    }

    //##################################################
    //# current page
    //##################################################

    public ScPage getCurrentPage()
    {
        String key = getCurrentPageKey();

        if ( Kmu.isEmpty(key) )
            return null;

        return ScPageRegistry.getInstance().findKey(key);
    }

    public String getCurrentPageKey()
    {
        return getParameter(ScConstantsIF.PARAMETER_CURRENT_PAGE_KEY);
    }

    //##################################################
    //# current page
    //##################################################

    public ScPage getRequestedPage()
    {
        String key = getRequestedPageKey();

        if ( Kmu.isEmpty(key) )
            return null;

        return ScPageRegistry.getInstance().findKey(key);
    }

    public String getRequestedPageKey()
    {
        return getWindowParameters().getString(ScConstantsIF.PARAMETER_REQUESTED_PAGE_KEY);
    }

    //##################################################
    //# action
    //##################################################

    public String getActionParameter()
    {
        return getParameter(PARAMETER_ACTION);
    }

    //##################################################
    //# argument
    //##################################################

    public Object getArgument()
    {
        return _argument;
    }

    public boolean hasArgument()
    {
        return _argument != null;
    }

    @SuppressWarnings("unchecked")
    public KmList<String> getStringListArgument()
    {
        try
        {
            return (KmList<String>)_argument;
        }
        catch ( Exception ex )
        {
            throw newArgumentCastException(ex, "KmList<String>");
        }
    }

    public String getStringArgument()
    {
        try
        {
            return (String)_argument;
        }
        catch ( Exception ex )
        {
            throw newArgumentCastException(ex, "String");
        }
    }

    public Integer getIntegerArgument()
    {
        return getIntegerArgument(null);
    }

    public Integer getIntegerArgument(Integer def)
    {
        try
        {
            if ( hasArgument() )
                return (Integer)_argument;

            return def;
        }
        catch ( Exception ex )
        {
            throw newArgumentCastException(ex, "Integer");
        }
    }

    public Boolean getBooleanArgument()
    {
        return getBooleanArgument(null);
    }

    public Boolean getBooleanArgument(Boolean def)
    {
        try
        {
            if ( hasArgument() )
                return (Boolean)_argument;

            return def;
        }
        catch ( Exception ex )
        {
            throw newArgumentCastException(ex, "Boolean");
        }
    }

    //##################################################
    //# extra value
    //##################################################

    public String getExtraParameter()
    {
        return getParameter(PARAMETER_EXTRA_VALUE);
    }

    //##################################################
    //# window location
    //##################################################

    public String getApplicationVersion()
    {
        return getParameter(PARAMETER_APPLICATION_VERSION);
    }

    /**
     * Return the window's location url.  For ajax, this is frequently
     * (usually) NOT the same as the request's url.
     */
    public String getWindowLocation()
    {
        return getParameter(PARAMETER_WINDOW_LOCATION);
    }

    public String getWindowQuery()
    {
        String s = getWindowLocation();
        int i = s.indexOf("?");

        if ( i < 0 )
            return null;

        return s.substring(i);
    }

    public ScParameterList getWindowParameters()
    {
        String url = getWindowLocation();
        return ScParameterList.createFromUrl(url);
    }

    /**
     * Return the portion of the window location AFTER the last hash (#).
     */
    public String getWindowLocationHash()
    {
        String s = getWindowLocation();
        if ( Kmu.isEmpty(s) )
            return null;

        int i = s.lastIndexOf("#");
        if ( i < 0 )
            return null;

        return s.substring(i + 1);
    }

    public boolean hasWindowLocationHash(String hash)
    {
        return Kmu.isEqual(getWindowLocationHash(), hash);
    }

    //##################################################
    //# layout visibility
    //##################################################

    public boolean isAppHeaderVisible()
    {
        String s = getParameter(PARAMETER_IS_PAGE_HEADER_VISIBLE);
        return Kmu.parse_boolean(s);
    }

    public boolean isAppFooterVisible()
    {
        String s = getParameter(PARAMETER_IS_PAGE_FOOTER_VISIBLE);
        return Kmu.parse_boolean(s);
    }

    public boolean isPageMenuVisible()
    {
        String s = getParameter(PARAMETER_IS_PAGE_MENU_VISIBLE);
        return Kmu.parse_boolean(s);
    }

    public boolean isPageTitleVisible()
    {
        String s = getParameter(PARAMETER_IS_PAGE_TITLE_VISIBLE);
        return Kmu.parse_boolean(s);
    }

    public boolean isAppContentVisible()
    {
        String s = getParameter(PARAMETER_IS_PAGE_CONTENT_VISIBLE);
        return Kmu.parse_boolean(s);
    }

    //##################################################
    //# navigation direction
    //##################################################

    public boolean isNavigateForward()
    {
        String s = getParameter(PARAMETER_DIRECTION);
        return "forward".equals(s);
    }

    public boolean isNavigateBack()
    {
        String s = getParameter(PARAMETER_DIRECTION);
        return "back".equals(s);
    }

    //##################################################
    //# abstract
    //##################################################

    public int getSessionTimeoutSeconds()
    {
        return 600;
    }

    public void releaseResources()
    {
        releaseLocal();
    }

    //##################################################
    //# static (thread local)
    //##################################################

    public static final ThreadLocal<ScServletData> _threadLocal = KmThreadLocalManager.newLocal();

    public static ScServletData getLocal()
    {
        return _threadLocal.get();
    }

    private static void setLocal(ScServletData data)
    {
        _threadLocal.set(data);
    }

    public static boolean hasLocal()
    {
        return getLocal() != null;
    }

    public static void releaseLocal()
    {
        _threadLocal.remove();
    }

    private void setLocal()
    {
        setLocal(this);
    }

    //##################################################
    //# private
    //##################################################

    private RuntimeException newArgumentCastException(Exception ex, String type)
    {
        return Kmu.newFatal(
            ex,
            "Cannot cast argument(%s) to (%s). Argument parameter was(%s).",
            _argument,
            type,
            _getArgumentParameter());
    }

    public String _getArgumentParameter()
    {
        return getParameter(PARAMETER_ARGUMENT);
    }

    //##################################################
    //# write
    //##################################################

    public void writeString(String value)
    {
        // Do NOT setContentLength(), it is handled by write().
        // Also, value.length() is NOT correct for multi-byte UTF-8 encoding.
        // setContentLength(value.length());

        getWriter().write(value);
    }

    public void writeBytes(byte[] value)
    {
        try (OutputStream out = getOutputStream())
        {
            setContentLength(value.length);
            out.write(value);
        }
        catch ( IOException ex )
        {
            KmLog.warn(ex, "Error writing http response.");
        }
    }

    public void writeFile(KmFile file)
    {
        try (OutputStream out = getOutputStream())
        {
            setContentLength((int)file.getLength());
            file.writeTo(out);
        }
        catch ( IOException ex )
        {
            KmLog.warn(ex, "Error writing http response.");
        }
    }

    public void writeAttachment(String name, byte[] value)
    {
        setAttachmentDisposition(name);
        writeBytes(value);
    }

    public void writeAttachmentFile(String name, KmFile file)
    {
        setAttachmentDisposition(name);
        writeFile(file);
    }

    //##################################################
    //# miscellaneous
    //##################################################

    public boolean supportsCopy()
    {
        return isUserAgentInternetExplorer();
    }

    private String getLoadingTabTitle()
    {
        return ScBridge.getInstance().getLoadingTabTitle();
    }
}
