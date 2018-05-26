package com.app.model;

import com.kodemore.servlet.control.ScTransitionType;

public interface MyCssConstantsIF
{
    //##################################################
    //# page title
    //##################################################

    String PAGE_TITLE_BUTTON      = "pageTitleButton";
    String PAGE_TITLE_BUTTON_CELL = "pageTitleButtonCell";

    //##################################################
    //# animation speeds
    //##################################################

    int PAGE_TRANSITION_SLIDE_MS = 350;
    int PAGE_TRANSITION_FADE_MS  = 150;

    ScTransitionType CARD_FRAME_TRANSITION_TYPE     = ScTransitionType.Flip;
    int              CARD_FRAME_TRANSITION_SPEED_MS = 300;
}
