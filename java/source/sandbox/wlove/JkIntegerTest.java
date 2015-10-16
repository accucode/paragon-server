package sandbox.wlove;

public class JkIntegerTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        System.out.println("--------------------");
        new JkIntegerTest().run();
        System.out.println("--------------------");
        System.out.println("ok.");
    }

    private void run()
    {
        System.out.println("hello");

        System.out.println(Long.MAX_VALUE);

        long a = System.nanoTime();
        System.out.println();
        long b = System.nanoTime();
        System.out.println();
        long c = System.nanoTime();
        System.out.println();
        long d = System.nanoTime();
        System.out.println();
        long e = System.nanoTime();

        a >>= 32;
        b >>= 32;
        c >>= 32;
        d >>= 32;
        e >>= 32;

        long mask = 0x000000007FFFFFFF;

        long aa = a & mask;
        long bb = b & mask;
        long cc = c & mask;
        long dd = d & mask;
        long ee = e & mask;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);

        System.out.println();

        System.out.println((int)a);
        System.out.println((int)b);
        System.out.println((int)c);
        System.out.println((int)d);
        System.out.println((int)e);

        System.out.println();

        System.out.println(aa);
        System.out.println(bb);
        System.out.println(cc);
        System.out.println(dd);
        System.out.println(ee);

        System.out.println();

        long w = Integer.MAX_VALUE;
        long x = w + 2;
        long y = x & 0x000000007FFFFFFF;

        System.out.println(w);
        System.out.println(x);
        System.out.println(y);
        System.out.println((int)y);
    }
}
