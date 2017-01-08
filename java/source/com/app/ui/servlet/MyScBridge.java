package com.app.ui.servlet;

import com.kodemore.servlet.ScServletData;
import com.kodemore.servlet.control.ScControlIF;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScTransitionType;
import com.kodemore.servlet.script.ScBlockScript;
import com.kodemore.servlet.script.ScReplaceContentsScript;
import com.kodemore.servlet.utility.ScBridge;
import com.kodemore.servlet.utility.ScPageLayoutBridge;

import com.app.model.MyCssConstantsIF;
import com.app.ui.core.MyServletData;
import com.app.ui.layout.MyPageErrorDialog;
import com.app.utility.MyGlobals;
import com.app.utility.MyInstaller;

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
    //# variables
    //##################################################

    private MyPageErrorDialog _errorDialog;

    //##################################################
    //# constructor
    //##################################################

    private MyScBridge()
    {
        _errorDialog = new MyPageErrorDialog();
    }

    //##################################################
    //# errors
    //##################################################

    @Override
    public void displayError(Throwable ex)
    {
        _errorDialog.ajaxOpenException(ex);
    }

    @Override
    public void warnIfInstalled()
    {
        MyInstaller.warnIfInstalled();
    }

    //##################################################
    //# debug
    //##################################################

    @Override
    public boolean getRenderDebugDomComments()
    {
        return MyGlobals.getProperties().getRenderDebugDomComments();
    }

    //##################################################
    //# page transition
    //##################################################

    @Override
    public int getPageTransitionSlideMs()
    {
        return MyCssConstantsIF.PAGE_TRANSITION_SLIDE_MS;
    }

    @Override
    public int getPageTransitionFadeMs()
    {
        return MyCssConstantsIF.PAGE_TRANSITION_FADE_MS;
    }

    //##################################################
    //# card frame transition
    //##################################################

    @Override
    public ScTransitionType getCardFrameTransitionType()
    {
        return MyCssConstantsIF.CARD_FRAME_TRANSITION_TYPE;
    }

    @Override
    public int getCardFrameTransitionSpeedMs()
    {
        return MyCssConstantsIF.CARD_FRAME_TRANSITION_SPEED_MS;
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
        int fadeMs = bridge.getPageTransitionFadeMs();
        int slideMs = bridge.getPageTransitionSlideMs();

        r.setTransition(ScTransitionType.Fade, fadeMs);

        ScServletData data = ScServletData.getLocal();
        if ( data.isNavigateForward() )
        {
            ScTransitionType effect = ScTransitionType.SlideLeft;
            r.setTransition(effect, slideMs);
        }

        if ( data.isNavigateBack() )
        {
            ScTransitionType effect = ScTransitionType.SlideRight;
            r.setTransition(effect, slideMs);
        }
    }

    private void printMainPostRender(ScReplaceContentsScript r, ScControlIF e, boolean focus)
    {
        ScBlockScript postRender;
        postRender = r.getPostRenderScript();

        if ( focus )
            postRender.focus(e);
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
