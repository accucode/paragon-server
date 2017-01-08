package sandbox.sgranado;

public class JkSteveTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        new JkSteveTest().run();
    }

    //##################################################
    //# run
    //##################################################

    private void run()
    {
        for ( int i = 0; i < 100; i++ )
        {
            String name = "Element" + i;

            System.out.println("            <li id='" + name + "' class='boxGray pad'>");
            System.out.println("                <div class='dragHandle'><p>" + name + "</p></div>");
            System.out.println("                <p>" + name + "</p>");
            System.out.println("            </li>");
            System.out.println("");
        }
    }
}
