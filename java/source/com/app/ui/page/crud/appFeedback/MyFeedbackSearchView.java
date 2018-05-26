package com.app.ui.page.crud.appFeedback;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.field.ScDropdownField;
import com.kodemore.servlet.field.ScStaticDropdownField;
import com.kodemore.utility.Kmu;

import com.app.criteria.MyFeedbackCriteria;
import com.app.model.MyFeedback;
import com.app.model.base.MyFeedbackStatus;
import com.app.model.core.MyNullDomain;
import com.app.ui.page.crud.abstractBase.MyCrudBuilder;
import com.app.ui.page.crud.abstractBase.MyCrudGeneralCriteriaSearchView;

public class MyFeedbackSearchView
    extends MyCrudGeneralCriteriaSearchView<MyNullDomain,MyFeedback,MyFeedbackCriteria>
{
    //##################################################
    //# constants
    //##################################################

    private static final String STATUS_CODE_OPEN   = Kmu.formatMetaValue("open");
    private static final String STATUS_CODE_CLOSED = Kmu.formatMetaValue("closed");

    //##################################################
    //# variables
    //##################################################

    private ScDropdownField<String> _statusField;

    //##################################################
    //# constructor
    //##################################################

    public MyFeedbackSearchView(MyCrudBuilder<MyNullDomain,MyFeedback> e)
    {
        super(e);
    }

    //##################################################
    //# fields
    //##################################################

    @Override
    protected void installBasicFieldsOn(ScDiv root)
    {
        ScFieldTable fields;
        fields = root.addFieldTable();
        fields.add(createStatusField());
    }

    private ScControl createStatusField()
    {
        ScStaticDropdownField<String> e;
        e = new ScStaticDropdownField<>();
        e.setLabel(MyFeedback.Meta.StatusCode);
        e.setHelp(MyFeedback.Meta.StatusCode);
        e.disableChangeTracking();

        e.addOption(STATUS_CODE_OPEN);
        e.addOption(STATUS_CODE_CLOSED);
        e.setValue(STATUS_CODE_OPEN);
        e.setNullAnyPrefix();

        for ( MyFeedbackStatus status : MyFeedbackStatus.values() )
            e.addOption(status.getCode(), status.getLabel());

        _statusField = e;
        return e;
    }

    //==================================================
    //= fields :: extended
    //==================================================

    @Override
    protected void installExtendedFieldsOn(ScDiv root)
    {
        // none
    }

    @Override
    protected void addExtendedMessagesTo(KmList<String> v)
    {
        // none
    }

    //##################################################
    //# criteria
    //##################################################

    @Override
    protected MyFeedbackCriteria createCriteria()
    {
        return getAccess().getFeedbackDao().createCriteria();
    }

    @Override
    protected void filter(MyFeedbackCriteria c)
    {
        applyStatusCodeTo(c);
    }

    private void applyStatusCodeTo(MyFeedbackCriteria c)
    {
        if ( !_statusField.hasValue() )
            return;

        String code = _statusField.getValue();

        if ( code.equals(STATUS_CODE_OPEN) )
        {
            c.whereOpen().is(true);
            return;
        }

        if ( code.equals(STATUS_CODE_CLOSED) )
        {
            c.whereOpen().is(false);
            return;
        }

        MyFeedbackStatus status = MyFeedbackStatus.findCode(code);
        c.whereStatusIs(status);
    }

    @Override
    protected void sort(MyFeedbackCriteria c)
    {
        c.sortOnUid();
    }
}
