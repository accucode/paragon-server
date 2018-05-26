package com.app.ui.page.crud.appFeedback;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.layout.ScLayout;
import com.kodemore.servlet.field.ScDateField;
import com.kodemore.servlet.field.ScDynamicEnumDropdownField;
import com.kodemore.time.KmClock;

import com.app.model.MyFeedback;
import com.app.model.MyTenant;
import com.app.model.MyUser;
import com.app.model.meta.MyMetaFeedback;
import com.app.ui.page.crud.abstractBase.MyCrudEditCard;
import com.app.ui.page.crud.abstractBase.MyCrudLayout;
import com.app.ui.selector.MyUserSelector;
import com.app.utility.MyGlobals;

public class MyFeedbackEditCard
    extends MyCrudEditCard<MyFeedback>
{
    //##################################################
    //# variables
    //##################################################

    private MyUserSelector _closedByField;
    private ScDateField    _closedDateField;

    //##################################################
    //# constructor
    //##################################################

    public MyFeedbackEditCard()
    {
        super(new MyFeedbackBuilder());
    }

    public MyFeedbackEditCard(MyFeedbackBuilder e)
    {
        super(e);
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected MyCrudLayout getDetailLayout()
    {
        return MyCrudLayout.scroll;
    }

    @Override
    protected void installDetailsOn(ScDiv root)
    {
        ScLayout e;
        e = root.addLayout();
        e.setTypeFieldset();
        e.css().fill().auto();
        e.add(createGeneralSection());
        e.add(createDescriptionSection());
        e.add(createDetailsSection());
        e.add(createResolutionSection());
    }

    //==================================================
    //= install :: general
    //==================================================

    private ScControl createGeneralSection()
    {
        MyMetaFeedback x = MyFeedback.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("General");
        e.addFieldText(x.StatusName);
        e.addFieldText(x.CreatedByFullName, "Submitted By");
        e.addSpace();
        e.addFieldText(x.TenantName);
        e.addFieldText(x.ProjectName);
        e.addFieldText(x.PageName);
        e.addSpace();
        e.add(createSeverityField());
        return e;
    }

    private ScControl createSeverityField()
    {
        MyMetaFeedback x = MyFeedback.Meta;

        ScDynamicEnumDropdownField e;
        e = x.TypeCode.newDropdown();
        return e;
    }

    //==================================================
    //= install :: description
    //==================================================

    private ScControl createDescriptionSection()
    {
        MyMetaFeedback x = MyFeedback.Meta;

        return x.Description.newFieldText();
    }

    //==================================================
    //= install :: details section
    //==================================================

    private ScControl createDetailsSection()
    {
        MyMetaFeedback x = MyFeedback.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setLabel("Details");
        e.addFieldText(x.PageKey);
        e.addFieldText(x.WindowLocation);
        e.addFieldText(x.RequestUrl);
        e.addFieldText(x.QueryString);
        return e;
    }

    //==================================================
    //= install :: resolution section
    //==================================================

    private ScControl createResolutionSection()
    {
        MyMetaFeedback x = MyFeedback.Meta;

        ScFieldTable e;
        e = new ScFieldTable();
        e.setFullWidth();
        e.setLabel("Resolution");
        e.add(x.StatusCode.newDropdown());
        e.add(createClosedByRow());
        e.add(createClosedOnRow());
        e.add(x.Notes.newMultilineField());
        return e;
    }

    private ScControl createClosedByRow()
    {
        ScDiv e;
        e = new ScDiv();
        e.css().flexRow().rowSpacer5();
        e.setLabel("Closed by");
        e.add(createClosedByField());
        e.addLink("Me", newUncheckedAction(this::handleMe));
        return e;
    }

    private ScControl createClosedByField()
    {
        MyMetaFeedback x = MyFeedback.Meta;

        MyUserSelector e;
        e = new MyUserSelector();
        e.setMeta(x.ClosedBy);
        e.setChildrenFunction(this::findDevelopers);
        _closedByField = e;
        return e;
    }

    private KmList<MyUser> findDevelopers(MyTenant tenant, boolean all)
    {
        KmList<MyUser> v;
        v = tenant.getUsersByFullName();
        v.retainIf(e -> e.isRoleDeveloper());

        if ( !all )
            v.retainIf(e -> e.isDomainEnabled());

        return v;
    }

    private ScControl createClosedOnRow()
    {
        ScDiv e;
        e = new ScDiv();
        e.css().flexRow().rowSpacer5();
        e.setLabel("Closed on");
        e.add(createClosedOnField());
        e.addLink("Today", newUncheckedAction(this::handleToday));
        return e;
    }

    private ScControl createClosedOnField()
    {
        MyMetaFeedback x = MyFeedback.Meta;

        ScDateField e;
        e = x.ClosedDate.newField();
        _closedDateField = e;
        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRenderDetails(MyFeedback e)
    {
        super.preRenderDetails(e);

        _closedByField.setTenant(e.getTenant());
    }

    //##################################################
    //# handle
    //##################################################

    private void handleMe()
    {
        MyUser me = MyGlobals.getCurrentUser();
        _closedByField.ajaxSetFieldValue(me);
    }

    private void handleToday()
    {
        _closedDateField.ajaxSetFieldValue(KmClock.getLocalDate());
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected void saveDomainChild(MyFeedback e)
    {
        e.applyFrom(this);
    }
}
