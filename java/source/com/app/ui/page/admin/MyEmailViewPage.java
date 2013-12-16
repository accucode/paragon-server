package com.app.ui.page.admin;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScArray;
import com.kodemore.servlet.control.ScButton;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScGroupArray;
import com.kodemore.servlet.control.ScLiteral;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScStyledText;

import com.app.model.MyEmail;
import com.app.model.MyEmailPart;
import com.app.model.meta.MyMetaEmail;
import com.app.model.meta.MyMetaEmailPart;

public class MyEmailViewPage
    extends MyAdminPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyEmailViewPage instance = new MyEmailViewPage();

    private MyEmailViewPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScStyledText _errorText;
    private ScLiteral    _partsHtml;
    private ScButton     _editButton;

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
        ScArray arr;
        arr = root.addArray();

        ScGroupArray row;
        row = arr.addGroupArray();

        installSummaryGroup(row);
        installStatusGroup(row);

        installParts(arr);

        _editButton = arr.addRow().addButton("Edit", newEditAction());
        _editButton.hide();
    }

    private void installSummaryGroup(ScGroupArray root)
    {
        MyMetaEmail x = MyEmail.Meta;

        ScGroup group;
        group = root.addGroup("Summary");

        ScContainer fields;
        fields = group.addFields();
        fields.addText(x.Uid);
        fields.addText(x.ToAddressesLabel);
        fields.addText(x.CcAddressesLabel);
        fields.addText(x.FromAddress);
        fields.addText(x.Subject);
    }

    private void installStatusGroup(ScGroupArray root)
    {
        MyMetaEmail x = MyEmail.Meta;

        ScGroup group;
        group = root.addGroup("Status");

        ScFieldTable fields;
        fields = group.addFields();
        fields.addText(x.StatusName);
        fields.addText(x.CreatedLocalTs);
        fields.addText(x.SentLocalTs);

        _errorText = fields.addStyledText(x.ErrorNotes);
        _errorText.hide();

        ScContainer buttons;
        buttons = group.addRow();
        buttons.addButton("Re-Send", newResendAction());
        buttons.addButton("Ignore", newIgnoreAction());
    }

    private void installParts(ScContainer root)
    {
        _partsHtml = new ScLiteral();
        root.add(_partsHtml);
    }

    //##################################################
    //# actions
    //##################################################

    private ScActionIF newResendAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleResend();
            }
        };
    }

    private ScActionIF newIgnoreAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleIgnore();
            }
        };
    }

    private ScActionIF newEditAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleEdit();
            }
        };
    }

    //##################################################
    //# navigation
    //##################################################

    public void startEmail(String uid)
    {
        getPageSession().setEmailUid(uid);
        push();
    }

    //##################################################
    //# print
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        _editButton.show();

        MyEmail email;
        email = getEmail();
        email.applyTo(this);

        if ( email.hasErrorNotes() )
            _errorText.show();

        _partsHtml.setValue(formatParts(email));
    }

    private String formatParts(MyEmail email)
    {
        KmList<MyEmailPart> parts;
        parts = email.getParts().toList();
        parts.sortOn(MyMetaEmailPart.Sequence);

        ScArray root;
        root = new ScArray();

        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.render(root);

        // todo_wyatt: null?
        return null;
    }

    //##################################################
    //# handle
    //##################################################

    private void handleIgnore()
    {
        getEmail().markIgnored();
        //        print();
    }

    private void handleResend()
    {
        getEmail().markReady();
        //        print();
    }

    private void handleEdit()
    {
        //        MyEmailEditPage.instance.print();
    }

    //##################################################
    //# support
    //##################################################

    private MyEmail getEmail()
    {
        String uid = getPageSession().getEmailUid();
        return getAccess().getEmailDao().findUid(uid);
    }
}
