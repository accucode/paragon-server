package com.app.ui.servlet;

import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.control.ScControlIF;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScTransition;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.script.ScReplaceContentsScript;
import com.kodemore.servlet.utility.ScBridge;
import com.kodemore.servlet.utility.ScPageLayoutBridge;

import com.app.model.MyCssConstantsIF;
import com.app.ui.core.MyServletData;
import com.app.ui.layout.MyPageErrorDialog;
import com.app.ui.layout.MyPageLayout;

public class MyScBridge
    extends ScBridge
{
    //##################################################
    //# install
    //##################################################

    public static void install()
    {
        ScBridge.install(new MyScBridge());
    }

    //##################################################
    //# constructor
    //##################################################

    private MyScBridge()
    {
        // private
    }

    //##################################################
    //# overrides
    //##################################################

    @Override
    public void displayError(Throwable ex)
    {
        MyPageErrorDialog e;
        e = new MyPageErrorDialog();
        e.ajaxOpenException(ex);
    }

    @Override
    public int getTransitionSlideMs()
    {
        return MyCssConstantsIF.PAGE_TRANSITION_SLIDE_MS;
    }

    @Override
    public int getTransitionFadeMs()
    {
        return 100;
    }

    //##################################################
    //# main
    //##################################################

    @Override
    public void printMain(ScPageRoot root, boolean focus)
    {
        ScReplaceContentsScript r;
        r = ajax().setContents(getMainSelector(), root);

        printMainTransition(r);
        printMainPostRender(r, root, focus);
    }

    @Override
    public void clearMain()
    {
        ajax().clearContents(getMainSelector());
    }

    private void printMainTransition(ScReplaceContentsScript r)
    {
        ScBridge bridge = ScBridge.getInstance();

        int fadeMs = bridge.getTransitionFadeMs();
        int slideMs = bridge.getTransitionSlideMs();

        r.setTransition(ScTransition.Fade, fadeMs);

        ScServletData data = ScServletData.getLocal();
        if ( data.isNavigateForward() )
        {
            ScTransition effect = ScTransition.SlideLeft;
            r.setTransition(effect, slideMs);
        }

        if ( data.isNavigateBack() )
        {
            ScTransition effect = ScTransition.SlideRight;
            r.setTransition(effect, slideMs);
        }
    }

    private void printMainPostRender(ScReplaceContentsScript r, ScControlIF e, boolean focus)
    {
        ScBlockScript postRender;
        postRender = r.getPostRenderScript();

        if ( focus )
            postRender.focus(e.getFocusTarget());

        MyPageLayout layout;
        layout = MyPageLayout.getInstance();
        layout.glowTitleOn(postRender);
    }

    private String getMainSelector()
    {
        return ScPageLayoutBridge.getInstance().getMainSelector();
    }

    //##################################################
    //# support
    //##################################################

    private ScBlockScript ajax()
    {
        return data().ajax();
    }

    private MyServletData data()
    {
        return MyServletData.getLocal();
    }
}
