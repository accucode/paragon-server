package com.kodemore.authnet.test;

import com.kodemore.authnet.KmAuthnetConfiguration;
import com.kodemore.authnet.model.KmAuthnetCreditCard;
import com.kodemore.authnet.model.KmAuthnetCustomerProfile;
import com.kodemore.authnet.model.KmAuthnetPaymentProfile;
import com.kodemore.authnet.model.KmAuthnetTransaction;
import com.kodemore.authnet.request.KmAuthnetCreateCustomerProfileRequest;
import com.kodemore.authnet.request.KmAuthnetCreateCustomerProfileResponse;
import com.kodemore.authnet.request.KmAuthnetCreatePaymentProfileRequest;
import com.kodemore.authnet.request.KmAuthnetCreatePaymentProfileResponse;
import com.kodemore.authnet.request.KmAuthnetCreateTransactionRequest;
import com.kodemore.authnet.request.KmAuthnetCreateTransactionResponse;
import com.kodemore.authnet.request.KmAuthnetDeleteCustomerProfileRequest;
import com.kodemore.authnet.request.KmAuthnetDeleteCustomerProfileResponse;
import com.kodemore.authnet.request.KmAuthnetDeletePaymentProfileRequest;
import com.kodemore.authnet.request.KmAuthnetDeletePaymentProfileResponse;
import com.kodemore.authnet.request.KmAuthnetGetCustomerProfileRequest;
import com.kodemore.authnet.request.KmAuthnetGetCustomerProfileResponse;
import com.kodemore.authnet.request.KmAuthnetGetPaymentProfileRequest;
import com.kodemore.authnet.request.KmAuthnetGetPaymentProfileResponse;
import com.kodemore.authnet.request.KmAuthnetUpdateCustomerProfileRequest;
import com.kodemore.authnet.request.KmAuthnetUpdateCustomerProfileResponse;
import com.kodemore.authnet.request.KmAuthnetUpdatePaymentProfileRequest;
import com.kodemore.authnet.request.KmAuthnetUpdatePaymentProfileResponse;
import com.kodemore.types.KmMoney;

@SuppressWarnings("unused")
public class KmAuthnetTest
{
    //##################################################
    //# constants
    //##################################################

    private static boolean PRINT_WARNING = true;

    private static final String apiLogin       = null;
    private static final String transactionKey = null;
    private static final String refId          = null;

    private static final Integer customerProfileId = null;
    private static final Integer paymentProfileId  = null;

    private static final String cardNumber = "4111111111111111";
    private static final String cardExpiry = "2020-12";

    private static final boolean USE_PRODUCTION = false;

    //##################################################
    //# main
    //##################################################

    public static void main(String args[])
    {
        new KmAuthnetTest().run();
    }

    private void run()
    {
        if ( PRINT_WARNING )
        {
            printWarning();
            return;
        }

        KmAuthnetConfiguration.useProductionUrl(USE_PRODUCTION);

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
        KmAuthnetCreateCustomerProfileRequest req;
        req = new KmAuthnetCreateCustomerProfileRequest();
        req.setAuthorization(apiLogin, transactionKey);
        req.setRefId(refId);

        KmAuthnetCustomerProfile profile;
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

        KmAuthnetCreateCustomerProfileResponse res;
        res = req.post();
        res.printFields();
        res.printPrettyXml();
    }

    private void getCustomerProfile()
    {
        KmAuthnetGetCustomerProfileRequest req;
        req = new KmAuthnetGetCustomerProfileRequest();
        req.setAuthorization(apiLogin, transactionKey);
        req.setRefId(refId);
        req.setCustomerProfileId(customerProfileId);

        KmAuthnetGetCustomerProfileResponse res;
        res = req.post();
        res.printFields();
        res.printPrettyXml();
    }

    private void updateCustomerProfile()
    {
        KmAuthnetUpdateCustomerProfileRequest req;
        req = new KmAuthnetUpdateCustomerProfileRequest();
        req.setAuthorization(apiLogin, transactionKey);
        req.setRefId(refId);

        KmAuthnetCustomerProfile profile;
        profile = req.addProfile();
        profile.setCustomerProfileId(customerProfileId);
        profile.setMerchantCustomerId("newMerchantId");
        profile.setDescription("newDescription");
        profile.setEmail("newEmail@email.com");

        KmAuthnetUpdateCustomerProfileResponse res;
        res = req.post();
        res.printFields();
        res.printPrettyXml();
    }

    private void deleteCustomerProfile()
    {
        KmAuthnetDeleteCustomerProfileRequest req;
        req = new KmAuthnetDeleteCustomerProfileRequest();
        req.setAuthorization(apiLogin, transactionKey);
        req.setRefId(refId);
        req.setCustomerProfileId(customerProfileId);

        KmAuthnetDeleteCustomerProfileResponse res;
        res = req.post();
        res.printFields();
        res.printPrettyXml();
    }

    //##################################################
    //# payment profile
    //##################################################

    private void createPaymentProfile()
    {
        KmAuthnetCreatePaymentProfileRequest req;
        req = new KmAuthnetCreatePaymentProfileRequest();
        req.setCustomerProfileId(customerProfileId);
        req.setAuthorization(apiLogin, transactionKey);
        req.setRefId(refId);

        KmAuthnetPaymentProfile payment;
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

        KmAuthnetCreditCard cc;
        cc = payment.addCreditCard();
        cc.setCardNumber(cardNumber);
        cc.setExpiry(cardExpiry);

        KmAuthnetCreatePaymentProfileResponse res;
        res = req.post();
        res.printFields();
        res.printPrettyXml();
    }

    private void getPaymentProfile()
    {
        KmAuthnetGetPaymentProfileRequest req;
        req = new KmAuthnetGetPaymentProfileRequest();
        req.setAuthorization(apiLogin, transactionKey);
        req.setRefId(refId);
        req.setCustomerProfileId(customerProfileId);
        req.setPaymentProfileId(paymentProfileId);

        KmAuthnetGetPaymentProfileResponse res;
        res = req.post();
        res.printFields();
        res.printPrettyXml();
    }

    private void updatePaymentProfile()
    {
        KmAuthnetGetPaymentProfileRequest getRequest;
        getRequest = new KmAuthnetGetPaymentProfileRequest();
        getRequest.setAuthorization(apiLogin, transactionKey);
        getRequest.setRefId(refId);
        getRequest.setCustomerProfileId(customerProfileId);
        getRequest.setPaymentProfileId(paymentProfileId);

        KmAuthnetGetPaymentProfileResponse getResponse;
        getResponse = getRequest.post();

        KmAuthnetPaymentProfile payment = getResponse.getPaymentProfile();

        System.out.println("PAYMENT PROFILE WAS:");
        payment.printFields();
        System.out.println(
            "======================================================================================");

        // change some stuff...
        payment.getBillTo().setStreet("new address 123 street");
        payment.setCustomerTypeBusiness();

        KmAuthnetCreditCard cc;
        cc = payment.addCreditCard();
        cc.setCardNumber(cardNumber);
        cc.setExpiry(cardExpiry);

        KmAuthnetUpdatePaymentProfileRequest req;
        req = new KmAuthnetUpdatePaymentProfileRequest();
        req.setAuthorization(apiLogin, transactionKey);
        req.setRefId(refId);
        req.setCustomerProfileId(customerProfileId);
        req.setCustomerPaymentProfile(payment);

        KmAuthnetUpdatePaymentProfileResponse res;
        res = req.post();
        res.printPrettyXml();
        res.printFields();

        getResponse = getRequest.post();

        System.out.println("UPDATED PROFILE IS:");
        getResponse.getPaymentProfile().printFields();
        System.out.println(
            "======================================================================================");
    }

    private void deletePaymentProfile()
    {
        KmAuthnetDeletePaymentProfileRequest req;
        req = new KmAuthnetDeletePaymentProfileRequest();
        req.setAuthorization(apiLogin, transactionKey);
        req.setRefId(refId);
        req.setCustomerProfileId(customerProfileId);
        req.setPaymentProfileId(paymentProfileId);

        KmAuthnetDeletePaymentProfileResponse res;
        res = req.post();
        res.printFields();
        res.printPrettyXml();
    }

    //##################################################
    //# transaction
    //##################################################

    private void createTransaction()
    {
        KmAuthnetCreateTransactionRequest req;
        req = new KmAuthnetCreateTransactionRequest();
        req.setAuthorization(apiLogin, transactionKey);
        req.setRefId(refId);

        KmAuthnetTransaction txn;
        txn = req.setCreditCardTransaction();
        txn.setCustomerProfileId(customerProfileId);
        txn.setPaymentProfileId(paymentProfileId);
        txn.setAmount(new KmMoney(10.00));

        KmAuthnetCreateTransactionResponse res;
        res = req.post();
        res.printFields();
        res.printPrettyXml();
    }

}
