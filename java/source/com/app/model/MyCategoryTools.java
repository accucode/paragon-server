package com.app.model;

import com.kodemore.filter.KmFilterFactoryIF;
import com.kodemore.filter.KmFilterIF;
import com.kodemore.servlet.field.ScDomainDropdownField;

import com.app.filter.MyCategoryFilter;
import com.app.model.base.MyCategoryToolsBase;
import com.app.model.meta.MyMetaProduct;
import com.app.utility.MyGlobals;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyCategoryTools
    extends MyCategoryToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyCategoryTools instance = new MyCategoryTools();

    //##################################################
    //# constructor
    //##################################################

    private MyCategoryTools()
    {
        // singleton
    }

    //##################################################
    //# dropdown (current project)
    //##################################################

    public ScDomainDropdownField<MyCategory,String> newDomainDropdownForCurrentProject()
    {
        MyMetaProduct x = MyProduct.Meta;

        ScDomainDropdownField<MyCategory,String> e;
        e = newDomainDropdown();
        e.setValueAdaptor(x.Category);
        e.setFilterFactory(createCategoryFilterFactory());
        e.setOptionLabelAdaptor(Meta.Name);
        return e;
    }

    private KmFilterFactoryIF<MyCategory> createCategoryFilterFactory()
    {
        return new KmFilterFactoryIF<MyCategory>()
        {
            @Override
            public KmFilterIF<MyCategory> createFilter()
            {
                return createCategoryFilter();
            }
        };
    }

    private MyCategoryFilter createCategoryFilter()
    {
        MyProject p;
        p = MyGlobals.getServerSession().getCurrentProject();

        MyCategoryFilter f;
        f = new MyCategoryFilter();
        f.setProject(p);
        f.sortOnName();
        return f;
    }
}
