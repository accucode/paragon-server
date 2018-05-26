package com.app.macro.builder;

import java.util.function.Function;

import com.kodemore.collection.KmList;
import com.kodemore.meta.KmMetaProperty;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;

import com.app.macro.MyHtmlMacro;
import com.app.macro.MyImageMacro;
import com.app.macro.MyMacro;
import com.app.macro.MyMacroDomainType;
import com.app.macro.MyTextMacro;
import com.app.model.address.MyAddressVo;

/**
 * I build the macros for a specific domain type.
 */
public abstract class MyAbstractMacroBuilder
{
    //##################################################
    //# variables
    //##################################################

    private KmList<MyMacro> _list;

    //##################################################
    //# build
    //##################################################

    public final KmList<MyMacro> getAll()
    {
        _list = new KmList<>();
        addAll();
        return _list;
    }

    //##################################################
    //# setup
    //##################################################

    protected abstract MyMacroDomainType getDomainType();

    //##################################################
    //# install
    //##################################################

    protected abstract void addAll();

    //##################################################
    //# list
    //##################################################

    protected final void add(MyMacro e)
    {
        _list.add(e);
    }

    //##################################################
    //# create macro
    //##################################################

    protected final MyHtmlMacro newHtmlMacro()
    {
        MyHtmlMacro e;
        e = new MyHtmlMacro();
        e.setDomainType(getDomainType());
        return e;
    }

    protected final MyTextMacro newTextMacro()
    {
        MyTextMacro e;
        e = new MyTextMacro();
        e.setDomainType(getDomainType());
        return e;
    }

    protected final MyImageMacro newImageMacro()
    {
        MyImageMacro e;
        e = new MyImageMacro();
        e.setDomainType(getDomainType());
        return e;
    }

    //==================================================
    //= create macro :: convenience
    //==================================================

    protected final MyTextMacro addText(
        String associationName,
        String fieldName,
        String sample,
        KmMetaProperty<?,?> prop)
    {
        MyTextMacro e;
        e = newTextMacro();
        e.setAssociationName(associationName);
        e.setFieldName(fieldName);
        e.setDescription(prop.getHelp());
        e.setFunction(prop);
        e.setSampleText(sample);
        add(e);
        return e;
    }

    protected final MyTextMacro addText(String fieldName, String sample, KmMetaProperty<?,?> prop)
    {
        MyTextMacro e;
        e = newTextMacro();
        e.setFieldName(fieldName);
        e.setDescription(prop.getHelp());
        e.setFunction(prop);
        e.setSampleText(sample);
        add(e);
        return e;
    }

    protected final MyTextMacro addText(
        String fieldName,
        String sample,
        Function<?,?> function,
        String help)
    {
        MyTextMacro e;
        e = newTextMacro();
        e.setFieldName(fieldName);
        e.setDescription(help);
        e.setFunction(function);
        e.setSampleText(sample);
        add(e);
        return e;
    }

    protected final MyImageMacro addImage(
        String fieldName,
        Function<?,String> bytesFunction,
        Function<?,String> nameFunction,
        String help)
    {
        MyImageMacro e;
        e = newImageMacro();
        e.setFieldName(fieldName);
        e.setDescription(help);
        e.setEncodedfunction(bytesFunction);
        e.setNameFunction(nameFunction);
        add(e);
        return e;
    }

    //##################################################
    //# samples
    //##################################################

    protected MyAddressVo getSampleAddress()
    {
        MyAddressVo e;
        e = new MyAddressVo();
        e.setStreet1("89 South Main Street");
        e.setCity("Denver");
        e.setRegion("CO");
        e.setPostalCode("80237");
        e.setCountry("USA");
        return e;
    }

    //##################################################
    //# lorem
    //##################################################

    protected final String getLoremIpsum()
    {
        return getLoremIpsum(100);
    }

    protected final String getLoremIpsum(int n)
    {
        return Kmu.getLoremIpsum(n);
    }

    //##################################################
    //# print
    //##################################################

    protected final void print()
    {
        System.out.println(composePrint());
    }

    private KmStringBuilder composePrint()
    {
        KmStringBuilder out;
        out = new KmStringBuilder();
        out.printfln("%s (%s)", getClass().getSimpleName(), getDomainType());

        KmList<MyMacro> list = getAll();

        KmList<String> keys;
        keys = list.collect(e -> e.getKey());
        keys.sort();

        KmList<String> dups = keys.getDuplicates();
        if ( !dups.isEmpty() )
        {
            out.println("DUPLICATE KEYS...");
            out.println(dups.join());
            return out;
        }

        for ( String key : keys )
            out.printfln("    %s", key);

        out.println("ok.");
        return out;
    }

}
