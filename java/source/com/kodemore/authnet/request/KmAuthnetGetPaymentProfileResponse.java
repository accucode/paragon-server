package com.kodemore.authnet.request;

import java.io.PrintWriter;

import com.kodemore.authnet.model.KmAuthnetAddress;
import com.kodemore.authnet.model.KmAuthnetCreditCard;
import com.kodemore.authnet.model.KmAuthnetPaymentProfile;
import com.kodemore.xml.KmXmlElement;

public class KmAuthnetGetPaymentProfileResponse
    extends KmAuthnetAbstractResponse
{
    //##################################################
    //# variables
    //##################################################

    private KmAuthnetPaymentProfile _paymentProfile;

    //##################################################
    //# accessing
    //##################################################

    public KmAuthnetPaymentProfile getPaymentProfile()
    {
        return _paymentProfile;
    }

    public boolean hasPaymentProfile()
    {
        return _paymentProfile != null;
    }

    //##################################################
    //# parse
    //##################################################

    @Override
    protected void parseXml()
    {
        super.parseXml();
        if ( isNotOk() )
            return;

        KmXmlElement eProfile = getElementAt("paymentProfile");

        parseHeader(eProfile);
        parseBillTo(eProfile);
        parseCreditCard(eProfile);
    }

    private void parseHeader(KmXmlElement eProfile)
    {
        String paymentIdString = eProfile.collectTextAt("customerPaymentProfileId");
        Integer paymentId = Integer.parseInt(paymentIdString);
        String customerType = eProfile.collectTextAt("customerType");

        _paymentProfile = new KmAuthnetPaymentProfile();
        _paymentProfile.setCustomerPaymentProfileId(paymentId);
        _paymentProfile.setCustomerType(customerType);
    }

    private void parseBillTo(KmXmlElement eProfile)
    {
        KmXmlElement eBillTo = eProfile.getChildElement("billTo");
        if ( eBillTo == null )
            return;

        String firstName = eBillTo.collectTextAt("firstName");
        String lastName = eBillTo.collectTextAt("lastName");
        String company = eBillTo.collectTextAt("company");
        String street = eBillTo.collectTextAt("address");
        String city = eBillTo.collectTextAt("city");
        String state = eBillTo.collectTextAt("state");
        String zip = eBillTo.collectTextAt("zip");
        String country = eBillTo.collectTextAt("country");
        String phone = eBillTo.collectTextAt("phoneNumber");
        String fax = eBillTo.collectTextAt("faxNumber");

        KmAuthnetAddress a;
        a = _paymentProfile.addBillTo();
        a.setFirstName(firstName);
        a.setLastName(lastName);
        a.setCompany(company);
        a.setStreet(street);
        a.setCity(city);
        a.setState(state);
        a.setZip(zip);
        a.setCountry(country);
        a.setPhoneNumber(phone);
        a.setFaxNumber(fax);
    }

    private void parseCreditCard(KmXmlElement eProfile)
    {
        KmXmlElement eCard = eProfile.getElementAt("payment/creditCard");
        if ( eCard == null )
            return;

        String cardNumber = eCard.collectTextAt("cardNumber");

        KmAuthnetCreditCard cc;
        cc = _paymentProfile.addCreditCard();
        cc.setCardNumber(cardNumber);
        // do not set exp as we don't get it back
    }

    //##################################################
    //# print
    //##################################################

    @Override
    public void printFieldsOn(PrintWriter out)
    {
        super.printFieldsOn(out);
        out.println("======= Get Customer Payment Profile Response =======");
        _paymentProfile.printFieldsOn(out);
    }
}
