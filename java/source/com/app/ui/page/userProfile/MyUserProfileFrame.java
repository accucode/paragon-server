package com.app.ui.page.userProfile;

import com.kodemore.servlet.control.ScCard;
import com.kodemore.servlet.control.ScCardFrame;

public class MyUserProfileFrame
    extends ScCardFrame
{
    //##################################################
    //# variables
    //##################################################

    private ScCard _viewCard;
    private ScCard _editCard;
    private ScCard _changePasswordCard;

    //##################################################
    //# install
    //##################################################

    @Override
    protected void install()
    {
        super.install();

        css().width400();

        setShowFlip();
        setHideFlip();

        _viewCard = addCard(new MyUserProfileViewCard());
        _viewCard.beDefault();

        _editCard = addCard(new MyUserProfileEditCard());
        _changePasswordCard = addCard(new MyUserProfileChangePasswordCard());
    }

    //##################################################
    //# convenience
    //##################################################

    public void printEditCard()
    {
        _editCard.ajaxPrint();
    }

    public void printChangePasswordCard()
    {
        _changePasswordCard.ajaxPrint();
    }

}
