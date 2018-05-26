package com.app.filter.core;

import com.kodemore.collection.KmList;
import com.kodemore.log.KmLog;
import com.kodemore.utility.KmEnumIF;

import com.app.filter.value.MyFilterBooleanValue;
import com.app.filter.value.MyFilterCustomerValue;
import com.app.filter.value.MyFilterChoiceValue;
import com.app.filter.value.MyFilterProjectValue;
import com.app.filter.value.MyFilterStringValue;
import com.app.filter.value.MyFilterValue;
import com.app.model.MyFilterTemplate;
import com.app.model.MyFilterTemplateItem;
import com.app.model.MyProject;
import com.app.model.base.MyFilterTemplateContextType;

public abstract class MyLoadableFilter<T>
    extends MyBasicFilter<T>
    implements MyLoadableFilterIF<T>
{
    //##################################################
    //# variables
    //##################################################

    KmList<MyFilterValue<?>> _values;

    //##################################################
    //# constructor
    //##################################################

    public MyLoadableFilter()
    {
        _values = new KmList<>();
        installValues();
    }

    protected abstract void installValues();

    protected final <E extends MyFilterValue<?>> E addValue(E e)
    {
        _values.add(e);
        return e;
    }

    //##################################################
    //# convenience
    //##################################################

    protected MyFilterStringValue addStringValue(KmEnumIF e)
    {
        return addValue(new MyFilterStringValue(e));
    }

    protected MyFilterBooleanValue addBooleanValue(KmEnumIF e)
    {
        return addValue(new MyFilterBooleanValue(e));
    }

    protected MyFilterProjectValue addProjectValue(KmEnumIF e)
    {
        return addValue(new MyFilterProjectValue(e));
    }

    protected MyFilterChoiceValue addProjectOptionValue(KmEnumIF e)
    {
        return addValue(new MyFilterChoiceValue(e));
    }

    protected MyFilterCustomerValue addCustomerValue(KmEnumIF e)
    {
        return addValue(new MyFilterCustomerValue(e));
    }

    //##################################################
    //# templates
    //##################################################

    @Override
    public abstract MyProject getTemplateProject();

    @Override
    public abstract MyFilterTemplateContextType getTemplateContextType();

    //==================================================
    //= template :: load
    //==================================================

    @Override
    public final void loadFromTemplate(MyFilterTemplate template)
    {
        for ( MyFilterTemplateItem item : template.getUsedItems() )
            loadFromItem(item);
    }

    private void loadFromItem(MyFilterTemplateItem item)
    {
        MyFilterValue<?> value = getValueFor(item);
        if ( value == null )
        {
            KmLog.error(
                "Cannot load filter (%s), attribute (%s) not found for item (%s).",
                getClass().getSimpleName(),
                item.getAttributeCode(),
                item.getValue());
            return;
        }

        value.setStringValue(item.getValue());
    }

    protected MyFilterValue<?> getValueFor(MyFilterTemplateItem item)
    {
        String code = item.getAttributeCode();
        return _values.selectFirst(e -> e.hasAttributeCode(code));
    }

    //==================================================
    //= template :: save
    //==================================================

    @Override
    public final void saveToTemplate(MyFilterTemplate template)
    {
        for ( MyFilterValue<?> value : _values )
        {
            MyFilterTemplateItem item;
            item = template.lazyGetItem(value.getAttributeCode());
            item.setValue(value.getStringValue());
            item.setUsed(value.isUsed());
        }
    }

}
