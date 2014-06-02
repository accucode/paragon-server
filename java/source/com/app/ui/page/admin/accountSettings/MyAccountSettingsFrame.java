package com.app.ui.page.admin.accountSettings;

import com.app.ui.control.MyCardFrame;

public class MyAccountSettingsFrame
    extends MyCardFrame
{
    //##################################################
    //# variables
    //##################################################

    private MyAccountSettingsViewCard     _viewCard;
    private MyAccountSettingsEditCard     _editCard;
    private MyAccountSettingsTransferCard _transferCard;

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
        _transferCard = addCard(new MyAccountSettingsTransferCard());
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

    public MyAccountSettingsTransferCard getTransferCard()
    {
        return _transferCard;
    }

    //##################################################
    //# navigation
    //##################################################

    public void printViewCard()
    {
        _viewCard.ajaxPrint();
    }

    public void printEditCard()
    {
        _editCard.ajaxPrint();
    }

    public void printTransferCard()
    {
        _transferCard.ajaxPrint();
    }
}
