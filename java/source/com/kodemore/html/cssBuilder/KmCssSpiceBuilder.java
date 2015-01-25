//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################


package com.kodemore.html.cssBuilder;

import com.kodemore.html.KmCssBuilder;
import com.kodemore.utility.KmValueHolderIF;

public class KmCssSpiceBuilder
    extends KmCssBuilder
{
    //##################################################
    //# constructor
    //##################################################

    public KmCssSpiceBuilder()
    {
        super();
    }

    public KmCssSpiceBuilder(KmValueHolderIF<String> holder)
    {
        super(holder);
    }

    //##################################################
    //# chain
    //##################################################

    @Override
    public KmCssSpiceBuilder clear()
    {
        return (KmCssSpiceBuilder) super.clear();
    }

    @Override
    public KmCssSpiceBuilder add()
    {
        return (KmCssSpiceBuilder) super.add();
    }

    @Override
    public KmCssSpiceBuilder add(String e)
    {
        return (KmCssSpiceBuilder) super.add(e);
    }

    @Override
    public KmCssSpiceBuilder add(String prefix, String part, String flavor)
    {
        return (KmCssSpiceBuilder) super.add(prefix, part, flavor);
    }

    @Override
    public KmCssSpiceBuilder remove()
    {
        return (KmCssSpiceBuilder) super.remove();
    }

    @Override
    public KmCssSpiceBuilder remove(String e)
    {
        return (KmCssSpiceBuilder) super.remove(e);
    }
    
    @Override
    public KmCssSpiceBuilder remove(String prefix, String part, String flavor)
    {
        return (KmCssSpiceBuilder) super.remove(prefix, part, flavor);
    }

    @Override
    public KmCssSpiceBuilder toggle()
    {
        return (KmCssSpiceBuilder) super.toggle();
    }

    @Override
    public KmCssSpiceBuilder toggle(String e)
    {
        return (KmCssSpiceBuilder) super.toggle(e);
    }

    @Override
    public KmCssSpiceBuilder toggle(String prefix, String part, String flavor)
    {
        return (KmCssSpiceBuilder) super.toggle(prefix, part, flavor);
    }

    @Override
    public KmCssSpiceBuilder apply(String e)
    {
        return (KmCssSpiceBuilder) super.apply(e);
    }

    @Override
    public KmCssSpiceBuilder apply(String prefix, String part, String flavor)
    {
        return (KmCssSpiceBuilder) super.apply(prefix, part, flavor);
    }

    //##################################################
    //# copy
    //##################################################

    @Override
    public KmCssSpiceBuilder getCopy()
    {
        KmCssSpiceBuilder copy;
        copy = new KmCssSpiceBuilder();
        copy.setValue(getValue());
        return copy;
    }

    //##################################################
    //# selectors
    //##################################################

    public KmCssSpiceBuilder shadow()
    {
        return apply(KmCssSpiceConstantsIF.shadow);
    }
    
}
