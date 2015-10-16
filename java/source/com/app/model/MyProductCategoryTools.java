package com.app.model;

import com.kodemore.filter.KmFilterFactoryIF;
import com.kodemore.filter.KmFilterIF;
import com.kodemore.servlet.field.ScDomainDropdownField;

import com.app.filter.MyProductCategoryFilter;
import com.app.model.base.MyProductCategoryToolsBase;
import com.app.model.meta.MyMetaProduct;
import com.app.utility.MyGlobals;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyProductCategoryTools
    extends MyProductCategoryToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyProductCategoryTools instance = new MyProductCategoryTools();

    //##################################################
    //# constructor
    //##################################################

    private MyProductCategoryTools()
    {
        // singleton
    }

    //##################################################
    //# dropdown (current project)
    //##################################################

    public ScDomainDropdownField<MyProductCategory,String> newDomainDropdownForCurrentProject()
    {
        MyMetaProduct x = MyProduct.Meta;

        ScDomainDropdownField<MyProductCategory,String> e;
        e = newDomainDropdown();
        e.setValueAdaptor(x.Category);
        e.setFilterFactory(createCategoryFilterFactory());
        e.setOptionLabelAdaptor(Meta.Name);
        return e;
    }

    private KmFilterFactoryIF<MyProductCategory> createCategoryFilterFactory()
    {
        return new KmFilterFactoryIF<MyProductCategory>()
        {
            @Override
            public KmFilterIF<MyProductCategory> createFilter()
            {
                return createCategoryFilter();
            }
        };
    }

    private MyProductCategoryFilter createCategoryFilter()
    {
        MyProject p;
        p = MyGlobals.getServerSession().getCurrentProject();

        MyProductCategoryFilter f;
        f = new MyProductCategoryFilter();
        f.setProject(p);
        f.sortOnName();
        return f;
    }

}
