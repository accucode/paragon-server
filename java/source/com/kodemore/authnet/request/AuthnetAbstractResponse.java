package com.kodemore.authnet.request;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.kodemore.authnet.model.AuthnetResponseMessage;
import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;
import com.kodemore.xml.KmXmlDocument;
import com.kodemore.xml.KmXmlElement;
import com.kodemore.xml.KmXmlParser;

public class AuthnetAbstractResponse
{
    //##################################################
    //# constants
    //##################################################

    public static final String             RESULT_CODE_OK             = "Ok";
    public static final String             RESULT_CODE_DECLINED       = "Declined";
    public static final String             RESULT_CODE_ERROR          = "Error";

    /**
     * Used for error codes generated in the application rather than by authnet.
     */
    public static final String             RESULT_CODE_INTERNAL_ERROR = "Internal";

    //##################################################
    //# variables
    //##################################################

    private String                         _refId;
    private String                         _resultCode;
    private KmList<AuthnetResponseMessage> _responseMessages;

    private String                         _xmlSource;
    private KmXmlDocument                  _xmlDocument;

    //##################################################
    //# constructor
    //##################################################

    public AuthnetAbstractResponse()
    {
        _responseMessages = new KmList<AuthnetResponseMessage>();
    }

    //##################################################
    //# refId
    //##################################################

    public String getRefId()
    {
        return _refId;
    }

    public void setRefId(String refId)
    {
        _refId = refId;
    }

    public boolean hasRefId()
    {
        return _refId != null;
    }

    //##################################################
    //# result code
    //##################################################

    public String getResultCode()
    {
        return _resultCode;
    }

    public void setResultCode(String resultCode)
    {
        _resultCode = resultCode;
    }

    public boolean hasResultCode()
    {
        return _resultCode != null;
    }

    public boolean hasResultCode(String e)
    {
        return Kmu.isEqual(getResultCode(), e);
    }

    public boolean isOk()
    {
        return hasResultCode(RESULT_CODE_OK);
    }

    public boolean isNotOk()
    {
        return !isOk();
    }

    public boolean isDeclined()
    {
        return hasResultCode(RESULT_CODE_ERROR);
    }

    public boolean isError()
    {
        return hasResultCode(RESULT_CODE_ERROR);
    }

    public boolean hasKnownResultCode()
    {
        if ( hasResultCode(RESULT_CODE_OK) )
            return true;

        if ( hasResultCode(RESULT_CODE_DECLINED) )
            return true;

        if ( hasResultCode(RESULT_CODE_ERROR) )
            return true;

        return false;
    }

    public boolean hasUnknownResultCode()
    {
        return !hasKnownResultCode();
    }

    //##################################################
    //# messages
    //##################################################

    public KmList<AuthnetResponseMessage> getResponseMessages()
    {
        return _responseMessages;
    }

    public void addResponseMessage(String code, String text)
    {
        AuthnetResponseMessage msg;
        msg = new AuthnetResponseMessage();
        msg.setCode(code);
        msg.setText(text);
        _responseMessages.add(msg);
    }

    public boolean hasResponseMessage()
    {
        return _responseMessages.isNotEmpty();
    }

    public AuthnetResponseMessage getResponseMessage()
    {
        return _responseMessages.getFirstSafe();
    }

    public String getResponseCode()
    {
        if ( hasResponseMessage() )
            return getResponseMessage().getCode();
        return null;
    }

    public String getResponseText()
    {
        if ( hasResponseMessage() )
            return getResponseMessage().getText();
        return null;
    }

    public String formatMessages()
    {
        StringBuilder sb = new StringBuilder();
        for ( AuthnetResponseMessage e : _responseMessages )
        {
            String s = e.format();
            sb.append(s);
            if ( !s.endsWith(".") )
                sb.append(".");
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    //##################################################
    //# xml
    //##################################################

    public String getXml()
    {
        return _xmlSource;
    }

    public void setXml(String xmlSource)
    {
        _xmlSource = xmlSource;
        _xmlDocument = KmXmlParser.parse(_xmlSource);
        parseXml();
    }

    public KmXmlDocument getXmlDocument()
    {
        return _xmlDocument;
    }

    protected void parseXml()
    {
        _refId = getStringAt("refId");
        _resultCode = getStringAt("messages/resultCode");

        KmList<KmXmlElement> v = getElementsAt("messages/message");
        for ( KmXmlElement e : v )
        {
            String code = e.collectTextAt("code");
            String text = e.collectTextAt("text");
            addResponseMessage(code, text);
        }
    }

    //##################################################
    //# printing
    //##################################################

    public void printPrettyXml()
    {
        _xmlDocument.prettyPrint();
    }

    public String printPrettyXmlToString()
    {
        return _xmlDocument.getPrettyPrint();
    }

    //##################################################
    //# print fields
    //##################################################

    public final void printFields()
    {
        PrintWriter out = new PrintWriter(System.out);
        printFieldsOn(out);
        out.flush();
    }

    public final String printFieldsToString()
    {
        StringWriter sw = new StringWriter();
        PrintWriter out = new PrintWriter(sw);
        printFieldsOn(out);
        out.close();
        return sw.toString();
    }

    public void printFieldsOn(PrintWriter out)
    {
        out.println("======= Response Base =======");
        out.println("resultCode: " + getResultCode());
        out.println("refId:      " + getRefId());
        for ( AuthnetResponseMessage e : _responseMessages )
            out.println("message:    " + e);
    }

    //##################################################
    //# protected
    //##################################################

    protected KmXmlElement getElementAt(String path)
    {
        return _xmlDocument.getRoot().getElementAt(path);
    }

    protected KmList<KmXmlElement> getElementsAt(String path)
    {
        return _xmlDocument.getRoot().getElementsAt(path);
    }

    protected String getStringAt(String path)
    {
        return _xmlDocument.getRoot().collectTextAt(path);
    }

    protected Integer getIntegerAt(String path)
    {
        return Kmu.parseInteger(getStringAt(path));
    }
}
