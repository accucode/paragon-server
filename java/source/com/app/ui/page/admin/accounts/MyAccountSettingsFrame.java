package com.app.ui.page.admin.accounts;

import com.app.ui.control.MyCardFrame;

public class MyAccountSettingsFrame
    extends MyCardFrame
{
    //##################################################
    //# variables
    //##################################################

    private MyAccountSettingsViewCard _viewCard;
    private MyAccountSettingsEditCard _editCard;

    //##################################################
    //# constructor
    //##################################################

    @Override
    public void install()
    {
        super.install();

        useFlipAnimation();

        _viewCard = addCard(new MyAccountSettingsViewCard());
        _editCard = addCard(new MyAccountSettingsEditCard());
    }

    //##################################################
    //# accessing
    //##################################################

    public MyAccountSettingsViewCard getViewCard()
    {
        return _viewCard;
    }

    public MyAccountSettingsEditCard getEditCard()
    {
        return _editCard;
    }

    //##################################################
    //# navigation
    //##################################################

    public void printViewCard()
    {
        _viewCard.print();
    }

    public void printEditCard()
    {
        _editCard.print();
    }
}
