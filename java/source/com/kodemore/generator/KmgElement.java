package com.kodemore.generator;

import java.util.Collection;
import java.util.Iterator;

import com.kodemore.collection.KmList;
import com.kodemore.generator.model.KmgModel;
import com.kodemore.generator.model.KmgModelConstantsIF;
import com.kodemore.proto.KmProtoType;
import com.kodemore.stf.KmStfElement;
import com.kodemore.utility.Kmu;

public abstract class KmgElement
    implements KmgModelConstantsIF
{
    //##################################################
    //# variables
    //##################################################

    private KmgElement _parent;

    //##################################################
    //# constructor
    //##################################################

    public KmgElement(KmgElement parent)
    {
        _parent = parent;
    }

    //##################################################
    //# accessing
    //##################################################

    public KmgElement getParent()
    {
        return _parent;
    }

    public void setParent(KmgElement e)
    {
        _parent = e;
    }

    public boolean hasParent()
    {
        return _parent != null;
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public KmgRoot getRoot()
    {
        return _parent.getRoot();
    }

    public KmgModel getModel()
    {
        return _parent.getModel();
    }

    //##################################################
    //# meta
    //##################################################

    public boolean isMeta()
    {
        return false;
    }

    public boolean hasMetaLabel()
    {
        return false;
    }

    public boolean hasMetaComparator()
    {
        return false;
    }

    //##################################################
    //# parse
    //##################################################

    public abstract void parse(KmStfElement e);

    public void checkAttributeKeys(KmStfElement p, String... optionsArr)
    {
        KmList<String> options = Kmu.toStringList(optionsArr);

        for ( String key : p.getKeys() )
            if ( !options.contains(key) )
                throw newError(p, "(%s) must match one of [%s]", key, options.join());
    }

    public void checkChildrenNames(KmStfElement p, String... namesArr)
    {
        KmList<String> names = Kmu.toStringList(namesArr);

        for ( KmStfElement child : p.getChildren() )
        {
            String name = child.getName();
            if ( !names.contains(name) )
                throw newError(p, "(%s) must match one of [%s]", name, names.join());
        }
    }

    public void checkAttributeValues(KmStfElement p, String attr, String... optionsArr)
    {
        KmList<String> options = Kmu.toStringList(optionsArr);
        checkAttributeValues(p, attr, options);
    }

    public void checkAttributeValues(KmStfElement p, String attr, Collection<String> options)
    {
        KmList<String> values = p.getValues(attr);
        for ( String value : values )
            if ( !options.contains(value) )
                throw newError(p, "(%s) must match one of [%s]", attr, Kmu.join(options));
    }

    public void checkDuplicates(String key, KmList<String> values)
    {
        KmList<String> dups = values.getDuplicates();

        if ( dups.isNotEmpty() )
            throw newError("(%s) cannot contain duplicates: [%s]", key, dups.join());
    }

    public String parseStringAttribute(KmStfElement p, String attr, String def)
    {
        String s = p.getValue(attr);

        if ( s == null )
            return def;

        return s;
    }

    public String parseRequiredNameAttribute(KmStfElement p)
    {
        String s = p.getValue("name");

        if ( s == null )
            throw newError(p, "Required attribute (name) is missing");

        if ( s.length() == 0 )
            throw newError(p, "Required attribute (name) is empty.");

        if ( !Kmu.isAllAlphaNumeric(s) )
            throw newError("Names must only contain letters(%s).", s);

        return Kmu.lowercaseFirstLetter(s);
    }

    public String parseRequiredName(KmStfElement p, String tag)
    {
        String s = parseRequiredString(p, tag);

        if ( !Kmu.isAllAlphaNumeric(s) )
            throw newError("Names must only contain letters(%s).", s);

        return Kmu.lowercaseFirstLetter(s);
    }

    public String parseName(KmStfElement p, String tag)
    {
        String s = parseString(p, tag, null);

        if ( s == null )
            return null;

        if ( !Kmu.isAllAlphaNumeric(s) )
            throw newError("Names must only contain letters(%s).", s);

        return s;
    }

    public String parseRequiredString(KmStfElement p, String tag)
    {
        String s = parseString(p, tag, null);

        if ( s == null )
            throw newError(p, "Required field (%s) is missing", tag);

        if ( s.length() == 0 )
            throw newError(p, "Required field (%s) is empty.", tag);

        return s;
    }

    public String parseString(KmStfElement p, String attr, String def)
    {
        KmList<String> v = parseStrings(p, attr);

        if ( v.isEmpty() )
            return def;

        return v.getFirst();
    }

    public KmList<String> parseStrings(KmStfElement p, String attr)
    {
        if ( p == null )
            return new KmList<>();

        return p.getValues(attr);
    }

    public KmProtoType parseRequiredBaseType(KmStfElement p, String tag)
    {
        String name = parseRequiredString(p, tag);
        KmProtoType e = getRoot().getBaseType(name);

        if ( e == null )
            throw newError(p, "Unknown base type (%s).", name);

        return e;
    }

    /**
     * If the attribute is NOT present, or has no value, generate an error.
     */
    public Boolean parseRequiredBoolean(KmStfElement p, String attr)
    {
        if ( !p.hasAttribute(attr) )
            throw newError(p, "Cannot parse required boolean (%s).", attr);

        return parseBoolean(p, attr);
    }

    /**
     * If the attribute is NOT present, return false.
     * If the attribute IS present, but has no value, return true.
     * Otherwise, return the specified value.
     */
    public Boolean parseBoolean(KmStfElement p, String attr)
    {
        return parseBoolean(p, attr, false);
    }

    /**
     * If the attribute is NOT present, return the default.
     * If the attribute IS present, but has no value, return true.
     * Otherwise, return the specified value.
     */
    public Boolean parseBoolean(KmStfElement p, String attr, boolean def)
    {
        if ( !p.hasAttribute(attr) )
            return def;

        String value = p.getValue(attr);
        if ( value == null )
            return true;

        if ( value.equals(attr) )
            return true;

        Boolean b = Kmu.parseBoolean(value);
        if ( b == null )
            throw newError(p, "Cannot parse boolean (%s).", value);

        return b;
    }

    public Integer parseInteger(KmStfElement p, String tag, Integer def)
    {
        String s = parseString(p, tag, null);
        if ( s == null )
            return def;

        Integer i = Kmu.parseInteger(s);
        if ( i == null )
            throw newError(p, "Cannot parse integer (%s).", tag);

        return i;
    }

    public Integer parseRequiredInteger(KmStfElement p, String tag)
    {
        Integer i = parseInteger(p, tag, null);
        if ( i == null )
            throw newError(p, "Cannot parse required integer (%s).", tag);
        return i;
    }

    //##################################################
    //# validate
    //##################################################

    /**
     * Make sure that the parsed object is valid.  In many
     * cases full validation cannot be performed until
     * the entire graph has been parsed.
     */
    public abstract void validate();

    /**
     * Finish any actions that should be defered until after
     * graph has been validated.
     */
    public abstract void postValidate();

    protected void _validate(KmgElement e)
    {
        if ( e != null )
            e.validate();
    }

    protected void _validate(KmList<? extends KmgElement> v)
    {
        if ( v == null )
            return;

        for ( KmgElement e : v )
            e.validate();
    }

    protected void _postValidate(KmgElement e)
    {
        if ( e != null )
            e.postValidate();
    }

    protected void _postValidate(KmList<? extends KmgElement> v)
    {
        if ( v == null )
            return;

        for ( KmgElement e : v )
            e.postValidate();
    }

    //##################################################
    //# utility
    //##################################################

    public RuntimeException newError(KmStfElement x, String msg, Object... args)
    {
        String error = "Error: " + Kmu.format(msg, args);
        String path = "xPath: " + formatPath();

        System.out.println("=======================================================");
        System.out.println("\n");
        System.out.println(error);
        System.out.println(path);
        if ( x != null )
        {
            System.out.println();
            System.out.println("Location: " + x.getLocation());
        }
        System.out.println("=======================================================");
        System.out.println();

        return Kmu.newError(error + " " + path);
    }

    public RuntimeException newError(String msg, Object... args)
    {
        return newError(null, msg, args);
    }

    //##################################################
    //# path
    //##################################################

    public KmList<KmgElement> getPath()
    {
        KmList<KmgElement> v;
        if ( hasParent() )
            v = getParent().getPath();
        else
            v = new KmList<>();
        v.add(this);
        return v;
    }

    public String formatPath()
    {
        StringBuilder sb = new StringBuilder();
        Iterator<KmgElement> i = getPath().iterator();
        while ( i.hasNext() )
        {
            KmgElement e = i.next();
            sb.append(e);
            if ( i.hasNext() )
                sb.append(" > ");
        }
        return sb.toString();
    }

    public void printPath()
    {
        System.out.println(formatPath());
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public String formatServiceType(String s)
    {
        s = Kmu.replaceAll(s, "(", "<");
        s = Kmu.replaceAll(s, ")", ">");
        return s;
    }

    //##################################################
    //# convenience
    //##################################################

    public String capitalize(String s)
    {
        return Kmu.capitalizeFirstLetter(s);
    }

    public String pluralize(String s)
    {
        return Kmu.pluralize(s);
    }

    public String toConstant(String s)
    {
        StringBuilder out = new StringBuilder();

        Iterator<String> i = toWords(s).iterator();
        while ( i.hasNext() )
        {
            out.append(i.next().toUpperCase());
            if ( i.hasNext() )
                out.append("_");
        }

        return out.toString();
    }

    public KmList<String> toWords(String s)
    {
        KmList<String> v = new KmList<>();
        StringBuilder sb = new StringBuilder();
        if ( Kmu.isEmpty(s) )
            return v;
        s = s.trim();
        int n = s.length();
        for ( int i = 0; i < n; i++ )
        {
            char c = s.charAt(i);
            if ( !Character.isLetter(c) )
                continue;
            if ( Character.isUpperCase(c) )
            {
                if ( sb.length() > 0 )
                    v.add(sb.toString());
                sb.setLength(0);
                c = Character.toLowerCase(c);
            }
            sb.append(c);
        }
        if ( sb.length() > 0 )
            v.add(sb.toString());
        return v;
    }

    protected String formatClassName(Class<?> c)
    {
        return Kmu.getSimpleClassName(c);
    }

    //##################################################
    //# context
    //##################################################

    public String getf_prefix()
    {
        return getRoot().getApplicationPrefix();
    }

    public String getf_Prefix()
    {
        return Kmu.capitalizeFirstLetter(getRoot().getApplicationPrefix());
    }

    //##################################################
    //# convenience
    //##################################################

    protected String formatList(String collectionType, String elementType)
    {
        return KmgUtility.formatList(collectionType, elementType);
    }

}
