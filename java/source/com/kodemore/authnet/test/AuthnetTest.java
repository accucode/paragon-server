package com.kodemore.authnet.test;

import com.kodemore.authnet.AuthnetConfiguration;
import com.kodemore.authnet.model.AuthnetCreditCard;
import com.kodemore.authnet.model.AuthnetCustomerProfile;
import com.kodemore.authnet.model.AuthnetPaymentProfile;
import com.kodemore.authnet.model.AuthnetTransaction;
import com.kodemore.authnet.request.AuthnetCreateCustomerProfileRequest;
import com.kodemore.authnet.request.AuthnetCreateCustomerProfileResponse;
import com.kodemore.authnet.request.AuthnetCreatePaymentProfileRequest;
import com.kodemore.authnet.request.AuthnetCreatePaymentProfileResponse;
import com.kodemore.authnet.request.AuthnetCreateTransactionRequest;
import com.kodemore.authnet.request.AuthnetCreateTransactionResponse;
import com.kodemore.authnet.request.AuthnetDeleteCustomerProfileRequest;
import com.kodemore.authnet.request.AuthnetDeleteCustomerProfileResponse;
import com.kodemore.authnet.request.AuthnetDeletePaymentProfileRequest;
import com.kodemore.authnet.request.AuthnetDeletePaymentProfileResponse;
import com.kodemore.authnet.request.AuthnetGetCustomerProfileRequest;
import com.kodemore.authnet.request.AuthnetGetCustomerProfileResponse;
import com.kodemore.authnet.request.AuthnetGetPaymentProfileRequest;
import com.kodemore.authnet.request.AuthnetGetPaymentProfileResponse;
import com.kodemore.authnet.request.AuthnetUpdateCustomerProfileRequest;
import com.kodemore.authnet.request.AuthnetUpdateCustomerProfileResponse;
import com.kodemore.authnet.request.AuthnetUpdatePaymentProfileRequest;
import com.kodemore.authnet.request.AuthnetUpdatePaymentProfileResponse;
import com.kodemore.types.KmMoney;

@SuppressWarnings("unused")
public class AuthnetTest
{
    //##################################################
    //# constants
    //##################################################

    private static boolean       PRINT_WARNING     = true;

    private static final String  apiLogin          = null;
    private static final String  transactionKey    = null;
    private static final String  refId             = null;

    private static final Integer customerProfileId = null;
    private static final Integer paymentProfileId  = null;

    private static final String  cardNumber        = "4111111111111111";
    private static final String  cardExpiry        = "2020-12";

    private static final boolean USE_PRODUCTION    = false;

    //##################################################
    //# main
    //##################################################

    public static void main(String args[])
    {
        new AuthnetTest().run();
    }

    private void run()
    {
        if ( PRINT_WARNING )
        {
            printWarning();
            return;
        }

        AuthnetConfiguration.useProductionUrl(USE_PRODUCTION);

        // createCustomerProfile();
        // getCustomerProfile();
        // updateCustomerProfile();
        // deleteCustomerProfile();
        //
        // createPaymentProfile();
        // getPaymentProfile();
        // updatePaymentProfile();
        // deletePaymentProfile();
        //
        // createTransaction();
    }

    private void printWarning()
    {
        System.out.println("WARNING - This tool can be used to process REAL payment transactions.");
        System.out.println("Make sure you know what you are doing BEFORE using.");
    }

    //##################################################
    //# customer profile
    //##################################################

    private void createCustomerProfile()
    {
        AuthnetCreateCustomerProfileRequest req;
        req = new AuthnetCreateCustomerProfileRequest();
        req.setAuthorization(apiLogin, transactionKey);
        req.setRefId(refId);

        AuthnetCustomerProfile profile;
        profile = req.addProfile();
        profile.setDescription("description");
        profile.setEmail("email@email.com");
        profile.setMerchantCustomerId("merchantcustomerid");

        //        AuthnetPaymentProfile payment;
        //        payment = profile.addPaymentProfile();
        //        payment.setCustomerTypeIndividual();
        //
        //        AuthnetAddress billAddress;
        //        billAddress = payment.addBillTo();
        //        billAddress.setFirstName("firstname");
        //        billAddress.setLastName("lastname");
        //        billAddress.setCompany("company");
        //        billAddress.setStreet("123 address st");
        //        billAddress.setCity("city");
        //        billAddress.setState("CO");
        //        billAddress.setZip("zip");
        //        billAddress.setPhoneNumber("phone number");
        //        billAddress.setFaxNumber("fax number");
        //
        //        AuthnetCreditCard cc;
        //        cc = payment.addCreditCard();
        //        cc.setCardNumber(cardNumber);
        //        cc.setExpiry(cardExpiry);
        //
        //        AuthnetShipToAddress shipAddress;
        //        shipAddress = profile.addShipTo();
        //        shipAddress.setFirstName("firstname");
        //        shipAddress.setLastName("lastname");
        //        shipAddress.setCompany("company");
        //        shipAddress.setStreet("123 address st");
        //        shipAddress.setCity("city");
        //        shipAddress.setState("CO");
        //        shipAddress.setZip("zip");
        //        shipAddress.setPhoneNumber("phone number");
        //        shipAddress.setFaxNumber("fax number");

        AuthnetCreateCustomerProfileResponse res;
        res = req.post();
        res.printFields();
        res.printPrettyXml();
    }

    private void getCustomerProfile()
    {
        AuthnetGetCustomerProfileRequest req;
        req = new AuthnetGetCustomerProfileRequest();
        req.setAuthorization(apiLogin, transactionKey);
        req.setRefId(refId);
        req.setCustomerProfileId(customerProfileId);

        AuthnetGetCustomerProfileResponse res;
        res = req.post();
        res.printFields();
        res.printPrettyXml();
    }

    private void updateCustomerProfile()
    {
        AuthnetUpdateCustomerProfileRequest req;
        req = new AuthnetUpdateCustomerProfileRequest();
        req.setAuthorization(apiLogin, transactionKey);
        req.setRefId(refId);

        AuthnetCustomerProfile profile;
        profile = req.addProfile();
        profile.setCustomerProfileId(customerProfileId);
        profile.setMerchantCustomerId("newMerchantId");
        profile.setDescription("newDescription");
        profile.setEmail("newEmail@email.com");

        AuthnetUpdateCustomerProfileResponse res;
        res = req.post();
        res.printFields();
        res.printPrettyXml();
    }

    private void deleteCustomerProfile()
    {
        AuthnetDeleteCustomerProfileRequest req;
        req = new AuthnetDeleteCustomerProfileRequest();
        req.setAuthorization(apiLogin, transactionKey);
        req.setRefId(refId);
        req.setCustomerProfileId(customerProfileId);

        AuthnetDeleteCustomerProfileResponse res;
        res = req.post();
        res.printFields();
        res.printPrettyXml();
    }

    //##################################################
    //# payment profile
    //##################################################

    private void createPaymentProfile()
    {
        AuthnetCreatePaymentProfileRequest req;
        req = new AuthnetCreatePaymentProfileRequest();
        req.setCustomerProfileId(customerProfileId);
        req.setAuthorization(apiLogin, transactionKey);
        req.setRefId(refId);

        AuthnetPaymentProfile payment;
        payment = req.addPaymentProfile();
        payment.setCustomerTypeIndividual();

        //        AuthnetAddress address;
        //        address = payment.addBillTo();
        //        address.setFirstName("firstname");
        //        address.setLastName("lastname");
        //        address.setCompany("company");
        //        address.setStreet("123 address st");
        //        address.setCity("city");
        //        address.setState("CO");
        //        address.setZip("zip");
        //        address.setPhoneNumber("phone number");
        //        address.setFaxNumber("fax number");

        AuthnetCreditCard cc;
        cc = payment.addCreditCard();
        cc.setCardNumber(cardNumber);
        cc.setExpiry(cardExpiry);

        AuthnetCreatePaymentProfileResponse res;
        res = req.post();
        res.printFields();
        res.printPrettyXml();
    }

    private void getPaymentProfile()
    {
        AuthnetGetPaymentProfileRequest req;
        req = new AuthnetGetPaymentProfileRequest();
        req.setAuthorization(apiLogin, transactionKey);
        req.setRefId(refId);
        req.setCustomerProfileId(customerProfileId);
        req.setPaymentProfileId(paymentProfileId);

        AuthnetGetPaymentProfileResponse res;
        res = req.post();
        res.printFields();
        res.printPrettyXml();
    }

    private void updatePaymentProfile()
    {
        AuthnetGetPaymentProfileRequest getRequest;
        getRequest = new AuthnetGetPaymentProfileRequest();
        getRequest.setAuthorization(apiLogin, transactionKey);
        getRequest.setRefId(refId);
        getRequest.setCustomerProfileId(customerProfileId);
        getRequest.setPaymentProfileId(paymentProfileId);

        AuthnetGetPaymentProfileResponse getResponse;
        getResponse = getRequest.post();

        AuthnetPaymentProfile payment = getResponse.getPaymentProfile();

        System.out.println("PAYMENT PROFILE WAS:");
        payment.printFields();
        System.out.println("======================================================================================");

        // change some stuff...
        payment.getBillTo().setStreet("new address 123 street");
        payment.setCustomerTypeBusiness();

        AuthnetCreditCard cc;
        cc = payment.addCreditCard();
        cc.setCardNumber(cardNumber);
        cc.setExpiry(cardExpiry);

        AuthnetUpdatePaymentProfileRequest req;
        req = new AuthnetUpdatePaymentProfileRequest();
        req.setAuthorization(apiLogin, transactionKey);
        req.setRefId(refId);
        req.setCustomerProfileId(customerProfileId);
        req.setCustomerPaymentProfile(payment);

        AuthnetUpdatePaymentProfileResponse res;
        res = req.post();
        res.printPrettyXml();
        res.printFields();

        getResponse = getRequest.post();

        System.out.println("UPDATED PROFILE IS:");
        getResponse.getPaymentProfile().printFields();
        System.out.println("======================================================================================");
    }

    private void deletePaymentProfile()
    {
        AuthnetDeletePaymentProfileRequest req;
        req = new AuthnetDeletePaymentProfileRequest();
        req.setAuthorization(apiLogin, transactionKey);
        req.setRefId(refId);
        req.setCustomerProfileId(customerProfileId);
        req.setPaymentProfileId(paymentProfileId);

        AuthnetDeletePaymentProfileResponse res;
        res = req.post();
        res.printFields();
        res.printPrettyXml();
    }

    //##################################################
    //# transaction
    //##################################################

    private void createTransaction()
    {
        AuthnetCreateTransactionRequest req;
        req = new AuthnetCreateTransactionRequest();
        req.setAuthorization(apiLogin, transactionKey);
        req.setRefId(refId);

        AuthnetTransaction txn;
        txn = req.setCreditCardTransaction();
        txn.setCustomerProfileId(customerProfileId);
        txn.setPaymentProfileId(paymentProfileId);
        txn.setAmount(new KmMoney(10.00));

        AuthnetCreateTransactionResponse res;
        res = req.post();
        res.printFields();
        res.printPrettyXml();
    }

}
