package com.app.ui.page.test;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScLiteral;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.utility.Kmu;

import com.app.file.MyFilePaths;
import com.app.ui.page.MyPage;

/**
 * Include the content found at /web/test/staticInclude.html
 */
public class MyStaticIncludeTestPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyStaticIncludeTestPage instance = new MyStaticIncludeTestPage();

    private MyStaticIncludeTestPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScLiteral _literal;

    //##################################################
    //# navigation
    //##################################################

    @Override
    public ScParameterList composeLocalQueryParameters()
    {
        return null;
    }

    @Override
    public void applyLocalQueryParameters(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        _literal = root.addLiteral();
    }

    //##################################################
    //# navigation
    //##################################################

    @Override
    public void preRender()
    {
        super.preRender();

        String path = MyFilePaths.getWebPath("test/staticInclude.html");
        String html = Kmu.readTextFile(path);
        _literal.setValue(html);
    }

}
