/*
  Copyright (c) 2005-2016 www.kodemore.com

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

package com.kodemore.intacct;

import com.kodemore.collection.KmList;
import com.kodemore.xml.utility.KmXmlBuilder;

/**
 * A single Intacct request.
 *
 * Although Intacct support multiple operations/functions per request,
 * we currently support only one. This makes reconciling the response
 * very simple. If necessary, we may add support for multi-operation
 * requests at a later date.
 *
 * @see KmIntacctNode
 */
public class KmIntacctRequest
    extends KmIntacctNode
{
    //##################################################
    //# variables
    //##################################################

    //==================================================
    //= variables :: control
    //==================================================

    /**
     * The <senderid> and <password> tags contain the authentication credentials
     * for the XML gateway.
     *
     * Any company (Intacct instance) can be called on by anyone who has credentials
     * for the XML gateway, but the caller must also have authentication credentials
     * for the target company. Each Intacct partner and/or Intacct customer should
     * have their own set of credentials for the XML gateway. To obtain credentials
     * for the XML gateway, submit a support ticket via the Intacct partner/customer
     * portal.
     *
     * Required.
     */
    private String                    _senderId;
    private String                    _senderPassword;

    /**
     * The controlid contains an arbitrary string you make up.
     * The system passes the controlid back to you in the reply.
     * You can use the controlid to match requests and replies.
     *
     * The controlid could be a globally unique identifier (GUID), a sequence number,
     * or anything you like. The server does not process the <controlid> in any way.
     *
     * Intacct logs all XML gateway activity and the senderid and controlid
     * are logged with each request.
     *
     * Required.
     */
    private String                    _controlId;

    /**
     * The <uniqueid> tag has a value of either “true” or “false” (without quotes).
     *
     * When set to true, the <uniqueid> tag works together with the <controlid> tag
     * to check to see if the operation has previously executed and completed.
     *
     * When set to false, the system allows the operation to execute any number of times.
     *
     * Generally, read operations have no meaningful side effects on the state of the system.
     * On the other hand, financial transaction create and update requests do cause a meaningful
     * change in the state of the system. It is common to set <uniqueid> to false for operations
     * that contain exclusively read functions, whereas <uniqueid> is typically set to true for
     * operations that contain create (and perhaps update) functions.
     *
     * Default = true.
     */
    private boolean                   _controlIdUnique;

    /**
     * Intacct currently supports two method libraries and will continue backwards
     * compatibility regardless of the method you choose. API 2.1 contains hundreds
     * of object-based methods backed by a rigorous DTD. Each call is specific to
     * the action and object to which it applies. For example, to create a bill,
     * you would use the <create_bill> method. To update a customer, you would use
     * the <update_customer> method. The advantage of the rigorous DTD that accompanies
     * this system is that it tells you exactly what is missing when a request fails.
     *
     * When working with standard objects, it’s best to use the available 2.1 methods.
     *
     * Default = 2.1.
     */
    private String                    _dtdVersion;

    /**
     * When you provide the element debug(true) in your control element, Intacct returns
     * additional information about the call, such as time for the call to be processed.
     *
     * Default = false.
     */
    private boolean                   _debug;

    //==================================================
    //= variables :: company/user
    //==================================================

    /**
     * The company being accessing. This must correspond to the user.
     */
    private String                    _companyId;

    /**
     * The user login.
     * The sender id/password grants access to web services.
     * But user id/password grants access to specific data within the company.
     */
    private String                    _userId;
    private String                    _userPassword;

    //==================================================
    //= variables :: action
    //==================================================

    /**
     * The functions to perform (e.g.: a GetList).
     */
    private KmList<KmIntacctFunction> _functions;

    //##################################################
    //# constructor
    //##################################################

    public KmIntacctRequest()
    {
        setControlIdUnique(true);
        setDtdVersion("2.1");
        setDebug(false);
        _functions = new KmList<>();
    }

    //##################################################
    //# accessing :: control
    //##################################################

    //==================================================
    //= sender
    //==================================================

    public String getSenderId()
    {
        return _senderId;
    }

    public void setSenderId(String e)
    {
        _senderId = e;
    }

    //==================================================
    //= password
    //==================================================

    public String getSenderPassword()
    {
        return _senderPassword;
    }

    public void setSenderPassword(String e)
    {
        _senderPassword = e;
    }

    //==================================================
    //= control id
    //==================================================

    public String getControlId()
    {
        return _controlId;
    }

    public void setControlId(String e)
    {
        _controlId = e;
    }

    /**
     * By default, the control id must be unique. This helps to ensure
     * against accidentally posting duplicate updates to the accounting
     * system. However, we mostly perform non-updating reads which can
     * be safely repeated. For example GetCustomerList. For these 'safe'
     * operations we can simply ignore the control id. Although the control
     * id is still a required field, we can use an arbitrary non-unique
     * value as long as the 'uniqueId' is set to false.
     */
    public void ignoreControlId()
    {
        setControlId("ignored");
        setControlIdUnique(false);
    }

    //==================================================
    //= unique id
    //==================================================

    public boolean getControlIdUnique()
    {
        return _controlIdUnique;
    }

    public void setControlIdUnique(boolean e)
    {
        _controlIdUnique = e;
    }

    //==================================================
    //= dtd version
    //==================================================

    public String getDtdVersion()
    {
        return _dtdVersion;
    }

    public void setDtdVersion(String e)
    {
        _dtdVersion = e;
    }

    //==================================================
    //= debug
    //==================================================

    public boolean getDebug()
    {
        return _debug;
    }

    public void setDebug(boolean e)
    {
        _debug = e;
    }

    //##################################################
    //# company/user
    //##################################################

    //==================================================
    //= company
    //==================================================

    public String getCompanyId()
    {
        return _companyId;
    }

    public void setCompanyId(String e)
    {
        _companyId = e;
    }

    //==================================================
    //= user
    //==================================================

    public String getUserId()
    {
        return _userId;
    }

    public void setUserId(String e)
    {
        _userId = e;
    }

    //==================================================
    //= password
    //==================================================

    public String getUserPassword()
    {
        return _userPassword;
    }

    public void setUserPassword(String e)
    {
        _userPassword = e;
    }

    //##################################################
    //# accessing :: functions
    //##################################################

    public KmList<KmIntacctFunction> getFunctions()
    {
        return _functions;
    }

    public void addFunction(KmIntacctFunction e)
    {
        _functions.add(e);
    }

    //##################################################
    //# compose
    //##################################################

    /*
     * <request>
     *      <control>...</>
     *      <operation>...</>
     * </request>
     */
    @Override
    public void composeOn(KmXmlBuilder out)
    {
        out.begin("request");
        composeControlOn(out);
        composeOperationOn(out);
        out.end();
    }

    /*
     * <control>
     *      <senderid>???</>
     *      <password>???</>
     *      <controlid>???</>
     *      <uniqueid>???</>
     *      <dtdversion>???</>
     *      <debug>???</>
     * </control>
     */
    private void composeControlOn(KmXmlBuilder out)
    {
        out.begin("control");
        out.value("senderid", getSenderId());
        out.value("password", getSenderPassword());
        out.value("controlid", getControlId());
        out.value("uniqueid", getControlIdUnique());
        out.value("dtdversion", getDtdVersion());
        out.value("debug", getDebug());
        out.end();
    }

    /*
     * <operation>
     *      <authentication>...</>
     *      <content>...</>
     * </operation>
     */
    private void composeOperationOn(KmXmlBuilder out)
    {
        out.begin("operation");
        composeAuthenticationOn(out);
        composeContentOn(out);
        out.end();
    }

    /*
     * <authentication>
     *      <login>...</>
     * </authentication>
     */
    private void composeAuthenticationOn(KmXmlBuilder out)
    {
        out.begin("authentication");
        composeLoginOn(out);
        out.end();
    }

    /*
     * <login>
     *      <userid>johnsmith</>
     *      <companyid>acmeInc</>
     *      <password>123</>
     * </login>
     */
    private void composeLoginOn(KmXmlBuilder out)
    {
        out.begin("login");
        out.value("userid", getUserId());
        out.value("companyid", getCompanyId());
        out.value("password", getUserPassword());
        out.end();
    }

    /*
     * <content>
     *      <function>...</>
     * </content>
     */
    private void composeContentOn(KmXmlBuilder out)
    {
        out.begin("content");
        composeFunctionsOn(out);
        out.end();
    }

    /*
     * <function controlid='???'>
     *      ...
     * </function>
     */
    private void composeFunctionsOn(KmXmlBuilder out)
    {
        for ( KmIntacctFunction e : _functions )
            e.composeOn(out);
    }

    //##################################################
    //# send
    //##################################################

    public KmIntacctConnection send()
    {
        KmIntacctConnection con;
        con = createConnection();
        con.send();
        return con;
    }

    public KmIntacctConnection createConnection()
    {
        KmIntacctConnection con;
        con = new KmIntacctConnection();
        con.setHttpRequestForXml(composeXml());
        return con;
    }
}
