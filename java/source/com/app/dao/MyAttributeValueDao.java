package com.app.dao;

import com.kodemore.utility.Kmu;

import com.app.criteria.MyAttributeValueCriteria;
import com.app.dao.base.MyAttributeValueDaoBase;
import com.app.model.MyAttributeField;
import com.app.model.MyAttributeValue;
import com.app.model.MyProduct;

public class MyAttributeValueDao
    extends MyAttributeValueDaoBase
{
    public void delete(MyProduct product, MyAttributeField field)
    {
        MyAttributeValueCriteria c;
        c = createCriteria();
        c.whereProductIs(product);
        c.whereFieldIs(field);
        deleteAll(c);
    }

    public void setText(MyProduct product, MyAttributeField field, String text)
    {
        if ( !field.isCategoryProduct() )
            throw Kmu.newError("Not a valid product attribute.");

        MyAttributeValueCriteria c;
        c = createCriteria();
        c.whereProductIs(product);
        c.whereFieldIs(field);

        MyAttributeValue value = c.findFirst();

        if ( Kmu.isEmpty(text) )
        {
            if ( value != null )
                value.deleteDao();
            return;
        }

        if ( value == null )
        {
            value = new MyAttributeValue();
            value.setProduct(product);
            value.setField(field);
            value.setTextValue(text);
            value.attachDao();
            return;
        }

        value.setTextValue(text);
    }
}
