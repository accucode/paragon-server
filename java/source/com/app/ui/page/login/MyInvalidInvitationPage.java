package com.app.ui.page.login;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScStyledText;
import com.kodemore.servlet.control.ScUrlLink;

import com.app.ui.page.MyPage;
import com.app.utility.MyUrls;

public class MyInvalidInvitationPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyInvalidInvitationPage instance = new MyInvalidInvitationPage();

    private MyInvalidInvitationPage()
    {
        // singleton
    }

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
        root.css().gap();

        ScGroup group;
        group = root.addGroup();
        group.setTitle("Invalid Link");
        group.style().width(300).marginTop(100).marginCenter();

        ScContainer body = group.getBody();

        installMessageBox(body);
    }

    private void installMessageBox(ScContainer root)
    {
        ScBox box;
        box = root.addBox();
        box.css().pad10();

        ScStyledText text;
        text = box.addStyledText();
        text.style().bold().italic().size(16);
        text.setValue(""
            + "Oops! Looks like this is a broken link! "
            + "Please try again, or click the link below to return to the Sign In "
            + "page to log in.");

        box.addBreaks(2);

        String url = MyUrls.getEntryUrl();

        ScUrlLink link;
        link = box.addUrlLink("Sign In", url);
        link.css().link();
    }
}
