package com.app.ui.page.crud.transfer;

import com.kodemore.domain.KmUidDomainIF;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.utility.Kmu;

import com.app.ui.control.MyFormDialog;

public abstract class MyAbstractTransferDialog<T extends KmUidDomainIF>
    extends MyFormDialog
{
    //##################################################
    //# constructor
    //##################################################

    public MyAbstractTransferDialog()
    {
        setWidth(800);
        setHeight(600);

        MyAbstractTransferView<T> view;
        view = newTransferView();
        view.css().fillOffset20();

        ScForm form;
        form = getDialogRoot();
        form.add(view);

        String s;
        s = view.getClass().getSimpleName();
        s = Kmu.removePrefix(s, "My");
        s = Kmu.removeSuffix(s, "TransferView");
        s = Kmu.formatCamelCaseAsCapitalizedWords(s);
        s = "Transfer " + Kmu.pluralize(s);
        setLabel(s);
    }

    //##################################################
    //# install
    //##################################################

    protected abstract MyAbstractTransferView<T> newTransferView();

}
