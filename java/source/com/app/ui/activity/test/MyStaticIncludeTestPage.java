package com.app.ui.activity.test;

import com.app.file.MyFilePaths;
import com.app.ui.activity.MyActivity;

import com.kodemore.servlet.control.ScLiteral;
import com.kodemore.utility.Kmu;

/**
 * Include the content found at /web/test/staticInclude.html
 */
public class MyStaticIncludeTestPage
    extends MyActivity
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
    protected void install()
    {
        _literal = new ScLiteral();
    }

    //##################################################
    //# start
    //##################################################

    @Override
    public void start()
    {
        String path = MyFilePaths.getWebPath("test/staticInclude.html");
        String html = Kmu.readTextFile(path);
        _literal.setValue(html);

        ajax().printMain(_literal);
    }
}
