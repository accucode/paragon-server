package com.app.ui.activity.test;

import com.kodemore.servlet.control.ScLiteral;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.utility.Kmu;

import com.app.file.MyFilePaths;
import com.app.ui.activity.MyPage;

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
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        _literal = root.addLiteral();
    }

    //##################################################
    //# start
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
