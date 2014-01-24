package com.app.ui.page.tools;

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
import com.kodemore.servlet.control.ScLiteral;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScTextSpan;

import com.app.model.MyEmail;
import com.app.model.MyEmailPart;
import com.app.model.meta.MyMetaEmail;
import com.app.model.meta.MyMetaEmailPart;
import com.app.ui.page.MyPage;

public class MyDevEmailViewPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyDevEmailViewPage instance = new MyDevEmailViewPage();

    private MyDevEmailViewPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScTextSpan _errorText;
    private ScLiteral  _partsHtml;
    private ScButton   _editButton;

    //##################################################
    //# navigation
    //##################################################

    public void pushEmail(String uid)
    {
        getPageSession().setEmailUid(uid);

        _push();
    }

    @Override
    public ScParameterList composeQueryParameters()
    {
        String uid = getPageSession().getEmailUid();

        ScParameterList v;
        v = new ScParameterList();
        v.setValue("email", uid);
        return v;
    }

    @Override
    public void applyQueryParameters(ScParameterList v)
    {
        String uid = v.getValue("email");

        getPageSession().setEmailUid(uid);
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        ScArray arr;
        arr = root.addArray();

        installSummaryGroup(arr);
        installStatusGroup(arr);

        installParts(arr);

        _editButton = arr.addRow().addButton("Edit", newEditAction());
        _editButton.hide();
    }

    private void installSummaryGroup(ScContainer root)
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

    private void installStatusGroup(ScContainer root)
    {
        MyMetaEmail x = MyEmail.Meta;

        ScGroup group;
        group = root.addGroup("Status");

        ScFieldTable fields;
        fields = group.addFields();
        fields.addText(x.StatusName);
        fields.addText(x.CreatedLocalTs);
        fields.addText(x.SentLocalTs);

        _errorText = fields.addTextSpan(x.ErrorNotes);
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
