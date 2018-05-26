package com.kodemore.utility;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class MyAesUtility
{
    //##################################################
    //# instance
    //##################################################

    public static final MyAesUtility instance = new MyAesUtility();

    //##################################################
    //# variables
    //##################################################

    private byte[]        _key;
    private SecretKeySpec _keySpec;
    private Cipher        _encryptCypher;
    private Cipher        _decryptCipher;

    //##################################################
    //# constructor
    //##################################################

    public MyAesUtility()
    {
        try
        {
            _key = "databasePassword".getBytes();
            _keySpec = new SecretKeySpec(_key, "AES");

            _encryptCypher = Cipher.getInstance("AES");
            _encryptCypher.init(Cipher.ENCRYPT_MODE, _keySpec);

            _decryptCipher = Cipher.getInstance("AES");
            _decryptCipher.init(Cipher.DECRYPT_MODE, _keySpec);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    //##################################################
    //# accessing
    //##################################################

    public String encrypt(String value)
    {
        try
        {
            if ( value == null )
                return null;

            byte[] bytes = value.getBytes();
            byte[] encrypted = _encryptCypher.doFinal(bytes);
            return Kmu.formatHexString(encrypted);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public String decrypt(String hex)
    {
        try
        {
            if ( hex == null )
                return null;

            byte[] bytes = Kmu.parseHexBytes(hex);
            byte[] decrypted = _decryptCipher.doFinal(bytes);
            return new String(decrypted);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    //##################################################
    //# test
    //##################################################

    public static void main(String[] args)
    {
        new MyAesUtility().runTest();
    }

    private void runTest()
    {
        test("abc");
        test("def");
        test("xyz");
        test("12345678901234567890");

        int n = 1;
        for ( int i = 0; i < n; i++ )
            test(KmRandom.getInstance().getPrintableString(100));
    }

    private void test(String original)
    {
        String hex = MyAesUtility.instance.encrypt(original);
        String result = MyAesUtility.instance.decrypt(hex);

        boolean brief = false;

        if ( brief )
            System.out.printf("%s: %s\n", original, original.equals(result));
        else
        {
            System.out.printf("Original: %s (%s)\n", original, original.length());
            System.out.printf("Hex:      %s (%s)\n", hex, hex.length());
            System.out.printf("Result:   %s\n", result);
            System.out.println(
                original.equals(result)
                    ? "ok"
                    : "FAILED");
        }

    }

}
