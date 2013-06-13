package com.kodemore.authnet.request;

import java.io.PrintWriter;

import com.kodemore.utility.Kmu;

public class AuthnetCreateTransactionResponse
    extends AuthnetAbstractResponse
{
    //##################################################
    //# constants
    //##################################################

    public static final String DIRECT_RESPONSE_CODE_APPROVED = "1";
    public static final String DIRECT_RESPONSE_CODE_DECLINED = "2";
    public static final String DIRECT_RESPONSE_CODE_ERROR    = "3";
    public static final String DIRECT_RESPONSE_CODE_HELD     = "4";

    public static final String DIRECT_RESPONSE_NAME_APPROVED = "Approved";
    public static final String DIRECT_RESPONSE_NAME_DECLINED = "Declined";
    public static final String DIRECT_RESPONSE_NAME_ERROR    = "Error";
    public static final String DIRECT_RESPONSE_NAME_HELD     = "Held";

    //##################################################
    //# variables
    //##################################################

    private String             _directResponse;
    private String[]           _directResponseFields;

    //##################################################
    //# direct
    //##################################################

    public String getDirectResponse()
    {
        return _directResponse;
    }

    public boolean hasDirectResponse()
    {
        return _directResponse != null;
    }

    //##################################################
    //# status
    //##################################################

    public boolean isDirectResponseApproved()
    {
        return hasDirectResponseCode(DIRECT_RESPONSE_CODE_APPROVED);
    }

    public boolean isDirectResponseDeclined()
    {
        return hasDirectResponseCode(DIRECT_RESPONSE_CODE_DECLINED);
    }

    public boolean isDirectResponseError()
    {
        return hasDirectResponseCode(DIRECT_RESPONSE_CODE_ERROR);
    }

    public boolean isDirectResponseHeldForReview()
    {
        return hasDirectResponseCode(DIRECT_RESPONSE_CODE_HELD);
    }

    public String getDirectResponseCode()
    {
        return getDirectResponseField(0);
    }

    private boolean hasDirectResponseCode(String e)
    {
        return Kmu.isEqual(getDirectResponseCode(), e);
    }

    public String getDirectResponseName()
    {
        return getDirectResponseNameFor(getDirectResponseCode());
    }

    public static String getDirectResponseNameFor(String code)
    {
        if ( Kmu.isEmpty(code) )
            return "";

        if ( code.equals(DIRECT_RESPONSE_CODE_APPROVED) )
            return DIRECT_RESPONSE_NAME_APPROVED;

        if ( code.equals(DIRECT_RESPONSE_CODE_DECLINED) )
            return DIRECT_RESPONSE_NAME_DECLINED;

        if ( code.equals(DIRECT_RESPONSE_CODE_ERROR) )
            return DIRECT_RESPONSE_NAME_ERROR;

        if ( code.equals(DIRECT_RESPONSE_CODE_HELD) )
            return DIRECT_RESPONSE_NAME_HELD;

        return code;
    }

    //##################################################
    //# other
    //##################################################

    public String getDirectResponseText()
    {
        return getDirectResponseField(3);
    }

    public String getAuthorizationCode()
    {
        return getDirectResponseField(4);
    }

    public String getGatewayTransactionId()
    {
        return getDirectResponseField(6);
    }

    //##################################################
    //# parse
    //##################################################

    @Override
    protected void parseXml()
    {
        super.parseXml();
        _directResponse = getStringAt("directResponse");
        if ( _directResponse != null )
            _directResponseFields = _directResponse.split(",");
    }

    private String getDirectResponseField(int i)
    {
        if ( _directResponseFields == null )
            return "";

        if ( _directResponseFields.length <= i )
            return "";

        return _directResponseFields[i];
    }

    //##################################################
    //# print
    //##################################################

    @Override
    public void printFieldsOn(PrintWriter out)
    {
        super.printFieldsOn(out);
        out.println("======= Response Create Customer Profile Transaction =======");
        out.println("direct response code: " + getDirectResponseCode());
        out.println("direct response text: " + getDirectResponseText());
        out.println("authorization code:   " + getAuthorizationCode());
        out.println("gateway trans id:     " + getGatewayTransactionId());
        out.println("raw direct response:  " + getDirectResponse());
    }

}
