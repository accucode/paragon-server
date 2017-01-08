package sandbox.wlove;

import com.kodemore.console.KmConsoleInput;
import com.kodemore.utility.Kmu;

import com.app.utility.MyInstaller;

public class JkTestUiMemory
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        long used1 = Kmu.getUsedMemory();
        MyInstaller.installUserInterface();
        long used2 = Kmu.getUsedMemory();
        System.out.println("--------------------");
        System.out.println("Memory: " + Kmu.formatInteger(used2 - used1));
        KmConsoleInput.waitForReturn();
    }
}
