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

    /**
     * The ID style sheet selectors.  E.g.: #someId.
     */
    private KmList<KmgCssSelector>  _idSelectors;

    /**
     * The CLASS style sheet selectors.  E.g.: .someClass.
     */
    private KmList<KmgCssSelector>  _cssSelectors;
    private KmList<KmgCssComposite> _cssComposites;

    //##################################################
    //# constructor
    //##################################################

    public KmgCssBundle()
    {
        _idSelectors = new KmList<>();

        _cssSelectors = new KmList<>();
        _cssComposites = new KmList<>();
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

    //==================================================
    //= id selectors
    //==================================================

    public KmList<KmgCssSelector> getIdSelectors()
    {
        return _idSelectors;
    }

    public void setIdSelectors(KmList<KmgCssSelector> v)
    {
        _idSelectors = v;
    }

    public void addIdSelector(String e)
    {
        KmgCssSelector s;
        s = new KmgCssSelector();
        s.setName(e);

        _idSelectors.add(s);
    }

    public void addIdSelectors(KmList<String> v)
    {
        for ( String e : v )
            addIdSelector(e);
    }

    //==================================================
    //= css selectors
    //==================================================

    public KmList<KmgCssSelector> getCssSelectors()
    {
        return _cssSelectors;
    }

    public void setCssSelectors(KmList<KmgCssSelector> v)
    {
        _cssSelectors = v;
    }

    public void addCssSelector(String e)
    {
        KmgCssSelector s;
        s = new KmgCssSelector();
        s.setName(e);

        _cssSelectors.add(s);
    }

    public void addCssSelectors(KmList<String> v)
    {
        for ( String e : v )
            addCssSelector(e);
    }

    //==================================================
    //= css composites
    //==================================================

    public KmList<KmgCssComposite> getCssComposites()
    {
        return _cssComposites;
    }

    public void installCssComposites()
    {
        KmMap<String,KmgCssComposite> map = new KmMap<>();

        KmList<KmgCssSelector> sels = getCssSelectors();
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

        _cssComposites = map.getValues();
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
