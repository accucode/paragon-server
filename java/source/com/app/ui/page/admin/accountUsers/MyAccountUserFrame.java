package com.app.ui.page.admin.accountUsers;

import com.app.ui.control.MyCardFrame;

public class MyAccountUserFrame
    extends MyCardFrame
{
    //##################################################
    //# variables
    //##################################################

    private MyAccountUserViewCard   _viewCard;
    private MyAccountUserEditCard   _editCard;
    private MyAccountUserRemoveCard _removeCard;

    //##################################################
    //# constructor
    //##################################################

    @Override
    public void install()
    {
        super.install();

        useFlipAnimation();

        _viewCard = addCard(new MyAccountUserViewCard());
        _editCard = addCard(new MyAccountUserEditCard());
        _removeCard = addCard(new MyAccountUserRemoveCard());
    }

    //##################################################
    //# accessing
    //##################################################

    public MyAccountUserViewCard getViewCard()
    {
        return _viewCard;
    }

    public MyAccountUserEditCard getEditCard()
    {
        return _editCard;
    }

    public MyAccountUserRemoveCard getRemoveCard()
    {
        return _removeCard;
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

    public void printRemoveCard()
    {
        _removeCard.ajaxPrint();
    }
}
