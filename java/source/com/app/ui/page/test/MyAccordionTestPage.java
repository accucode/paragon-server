package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScPageRoot;

public class MyAccordionTestPage
    extends MyAbstractTestPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyAccordionTestPage instance = new MyAccordionTestPage();

    private MyAccordionTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScDiv _div;

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().gap();

        _div = root.addDiv();

        _div.addHeader1("Yummy1");
        addGrayBox(_div, "Bonbon jelly gummies marshmallow tiramisu topping. Sesame snaps tart "
            + "tart sugar plum. Bear claw donut halvah unerdwear.com lollipop candy "
            + "sweet roll.");
        _div.addHeader1("Yummy2");
        addGrayBox(_div, "Cookie soufflé sweet toffee chocolate bar sesame "
            + "snaps lollipop. Dessert gummies sugar plum candy cookie tart "
            + "apple pie. Sweet roll applicake pie cookie soufflé. Unerdwear."
            + "com oat cake chupa chups chocolate.");
        _div.addHeader1("Yummy3");
        addGrayBox(_div, "Fruitcake tootsie roll macaroon dragée bonbon. "
            + "Powder sesame snaps gummi bears donut pastry applicake. "
            + "Lollipop gummies candy sweet roll. Pudding dessert apple pie "
            + "halvah sweet roll croissant tootsie roll topping cake.");
        _div.addHeader1("Yummy4");
        addGrayBox(_div, "Oat cake wafer soufflé marzipan cheesecake biscuit. "
            + "Cheesecake applicake candy bonbon chupa chups. Jelly beans "
            + "soufflé gummi bears danish chocolate carrot cake pastry apple "
            + "pie jelly-o.");
    }

    public ScDiv addGrayBox(ScDiv root, String text)
    {
        ScDiv grayDiv;
        grayDiv = root.addBox();
        grayDiv.css().boxGray().pad();
        grayDiv.css().gap();
        grayDiv.addParagraph(text);
        return grayDiv;
    }

    //##################################################
    //# navigation
    //##################################################

    @Override
    public ScParameterList composeQueryParameters()
    {
        return null;
    }

    @Override
    public void applyQueryParameters(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();
        _div.ajax().accordionCollapsible();
    }
}
