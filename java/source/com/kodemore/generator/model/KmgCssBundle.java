package com.kodemore.generator.model;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.utility.Kmu;

/**
 * A bundle generally refers to a .css file.  However, in some
 * cases, it may make sense to 'bundle' the css selectors from
 * multiple .css files into a single grouping.
 */
public class KmgCssBundle
{
    //##################################################
    //# variables
    //##################################################

    private String                  _name;
    private KmList<KmgCssSelector>  _selectors;
    private KmList<KmgCssComposite> _composites;

    //##################################################
    //# constructor
    //##################################################

    public KmgCssBundle()
    {
        _selectors = new KmList<>();
        _composites = new KmList<>();
    }

    //##################################################
    //# accessing
    //##################################################

    public String getName()
    {
        return _name;
    }

    public void setName(String e)
    {
        _name = e;
    }

    public KmList<KmgCssSelector> getSelectors()
    {
        return _selectors;
    }

    public void setSelectors(KmList<KmgCssSelector> v)
    {
        _selectors = v;
    }

    public void addSelector(String e)
    {
        KmgCssSelector s;
        s = new KmgCssSelector();
        s.setName(e);

        _selectors.add(s);
    }

    public void addSelectors(KmList<String> v)
    {
        for ( String e : v )
            addSelector(e);
    }

    public KmList<KmgCssComposite> getComposites()
    {
        return _composites;
    }

    public void installComposites()
    {
        KmMap<String,KmgCssComposite> map = new KmMap<>();

        KmList<KmgCssSelector> sels = getSelectors();
        for ( KmgCssSelector sel : sels )
        {
            if ( !sel.isComposite() )
                continue;

            String prefix = sel.getCompositePrefix();
            String part = sel.getCompositePart();
            String flavor = sel.getCompositeFlavor();

            KmgCssComposite c = map.get(prefix);
            if ( c == null )
            {
                c = new KmgCssComposite();
                c.setPrefix(prefix);
                map.put(prefix, c);
            }

            c.addPart(part);
            c.addFlavor(flavor);
        }

        _composites = map.getValues();
    }

    //##################################################
    //# format
    //##################################################

    public String getf_name()
    {
        return getName();
    }

    public String getf_Name()
    {
        return Kmu.capitalizeFirstLetter(getf_name());
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return Kmu.format("cssBundle(%s)", getName());
    }

}
