package sandbox.wlove;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

public class JkTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        new JkTest().run();
    }

    private void run()
    {
        Integer i = i();
        Integer j = j();
        int k = i + j;
        System.out.println(k);
    }

    private @NotNull Integer i()
    {
        return null;
    }

    private @Nullable Integer j()
    {
        return 5;
    }

}
