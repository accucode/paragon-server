package sandbox.wlove;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.kodemore.utility.Kmu;

public class JkAesTest
{
    //##################################################
    //# constants
    //##################################################

    private static final String CIPHER = "AES";

    //##################################################
    //# main
    //##################################################

    public static void main(String[] args) throws Exception
    {
        new JkAesTest().run();
    }

    public void run() throws Exception
    {
        // Original message

        String message = "This is just an example";
        String messageHex = Kmu.formatHexString(message);

        System.out.println("Message");
        System.out.println("    string: " + message);
        System.out.println("    hex:    " + messageHex);

        // Generate key

        KeyGenerator keyGen;
        keyGen = KeyGenerator.getInstance(CIPHER);
        keyGen.init(128);

        SecretKey secret;
        secret = keyGen.generateKey();

        byte[] rawSecret;
        rawSecret = secret.getEncoded();

        SecretKeySpec secretKeySpec;
        secretKeySpec = new SecretKeySpec(rawSecret, CIPHER);

        // Encrypt

        Cipher cipher;
        cipher = Cipher.getInstance(CIPHER);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

        byte[] encrypted = cipher.doFinal(message.getBytes());
        String encryptedHex = Kmu.formatHexString(encrypted);

        System.out.println("Encrypted");
        System.out.println("    hex:    " + encryptedHex);

        // Decrypt

        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] result = cipher.doFinal(encrypted);
        String resultString = new String(result);
        String resultHex = Kmu.formatHexString(result);

        System.out.println("Result");
        System.out.println("    string: " + resultString);
        System.out.println("    hex:    " + resultHex);
    }
}
