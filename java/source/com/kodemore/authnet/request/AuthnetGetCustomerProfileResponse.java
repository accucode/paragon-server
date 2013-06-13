package com.kodemore.authnet.request;

import java.io.PrintWriter;

import com.kodemore.authnet.model.AuthnetAddress;
import com.kodemore.authnet.model.AuthnetCreditCard;
import com.kodemore.authnet.model.AuthnetCustomerProfile;
import com.kodemore.authnet.model.AuthnetPaymentProfile;
import com.kodemore.collection.KmList;
import com.kodemore.xml.KmXmlElement;

public class AuthnetGetCustomerProfileResponse
    extends AuthnetAbstractResponse
{
    //##################################################
    //# variables
    //##################################################

    private AuthnetCustomerProfile _profile;

    //##################################################
    //# constructor
    //##################################################

    public AuthnetGetCustomerProfileResponse()
    {
        // noop
    }

    //##################################################
    //# accessing
    //##################################################

    public AuthnetCustomerProfile getProfile()
    {
        return _profile;
    }

    public void setProfile(AuthnetCustomerProfile profile)
    {
        _profile = profile;
    }

    public boolean hasProfile()
    {
        return _profile != null;
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

        KmXmlElement eProfile = getElementAt("profile");

        parseHeader(eProfile);
        parsePaymentProfiles(eProfile);
    }

    private void parseHeader(KmXmlElement eProfile)
    {
        String customerIdString = eProfile.collectTextAt("customerProfileId");
        Integer customerId = Integer.parseInt(customerIdString);
        String merchantId = eProfile.collectTextAt("merchantCustomerId");
        String desc = eProfile.collectTextAt("description");
        String email = eProfile.collectTextAt("email");

        _profile = new AuthnetCustomerProfile();
        _profile.setCustomerProfileId(customerId);
        _profile.setMerchantCustomerId(merchantId);
        _profile.setDescription(desc);
        _profile.setEmail(email);
    }

    private void parsePaymentProfiles(KmXmlElement eProfile)
    {
        KmList<KmXmlElement> ePayments = eProfile.getElementsAt("paymentProfiles");
        for ( KmXmlElement ePayment : ePayments )
            parsePaymentProfile(ePayment);
    }

    private void parsePaymentProfile(KmXmlElement ePayment)
    {
        String paymentIdString = ePayment.collectTextAt("customerPaymentProfileId");
        Integer paymentId = Integer.parseInt(paymentIdString);
        String customerType = ePayment.collectTextAt("customerType");

        AuthnetPaymentProfile pp;
        pp = _profile.addPaymentProfile();
        pp.setCustomerPaymentProfileId(paymentId);
        pp.setCustomerType(customerType);

        parseBillTo(pp, ePayment);
        parseCreditCard(pp, ePayment);
    }

    private void parseCreditCard(AuthnetPaymentProfile pp, KmXmlElement ePayment)
    {
        KmXmlElement eCard = ePayment.getElementAt("payment/creditCard");
        if ( eCard == null )
            return;

        String cardNumber = eCard.collectTextAt("cardNumber");

        AuthnetCreditCard cc;
        cc = pp.addCreditCard();
        cc.setCardNumber(cardNumber);
        // do not set exp as we don't get it back
    }

    private void parseBillTo(AuthnetPaymentProfile pp, KmXmlElement ePayment)
    {
        KmXmlElement e = ePayment.getChildElement("billTo");
        if ( e == null )
            return;

        String firstName = e.collectTextAt("firstName");
        String lastName = e.collectTextAt("lastName");
        String company = e.collectTextAt("company");
        String street = e.collectTextAt("address");
        String city = e.collectTextAt("city");
        String state = e.collectTextAt("state");
        String zip = e.collectTextAt("zip");
        String country = e.collectTextAt("country");
        String phone = e.collectTextAt("phoneNumber");
        String fax = e.collectTextAt("faxNumber");

        AuthnetAddress a;
        a = pp.addBillTo();
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

    //##################################################
    //# print
    //##################################################

    @Override
    public void printFieldsOn(PrintWriter out)
    {
        super.printFieldsOn(out);
        out.println("======= Get Customer Profile Response =======");
        if ( _profile == null )
            out.println("No customer profile.");
        else
            _profile.printFieldsOn(out);
    }
}
