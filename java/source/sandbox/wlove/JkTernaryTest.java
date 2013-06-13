package sandbox.wlove;

public class JkTernaryTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        new JkTernaryTest().run();
    }

    //##################################################
    //# variables
    //##################################################

    private boolean _condition;
    private Integer _value;

    //##################################################
    //# run
    //##################################################

    public void run()
    {
        _condition = false;
        _value = null;

        Integer result = condition()
            ? 1
            : value();

        System.out.println(result);
    }

    private boolean condition()
    {
        return _condition;
    }

    private Integer value()
    {
        return _value;
    }

}
