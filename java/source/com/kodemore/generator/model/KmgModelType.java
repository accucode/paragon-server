package com.kodemore.generator.model;

import com.kodemore.collection.KmList;
import com.kodemore.comparator.KmComparator;
import com.kodemore.generator.KmgElement;
import com.kodemore.proto.KmProtoType;
import com.kodemore.proto.KmProtoTypes;
import com.kodemore.stf.KmStfElement;
import com.kodemore.utility.Kmu;

public class KmgModelType
    extends KmgElement
{
    //##################################################
    //# variables
    //##################################################

    private String         _name;
    private String         _comment;

    private KmProtoType    _protoType;
    private Integer        _minimumLength;
    private Integer        _maximumLength;
    private Integer        _allDigits;
    private Integer        _rightDigits;
    private KmList<String> _validCharacters;
    private Integer        _columnWidth;

    private boolean        _forcesLowerCase;
    private boolean        _forcesUpperCase;
    private boolean        _stripsLeadingZeros;
    private boolean        _stripsAllSpaces;
    private boolean        _stripsAllDashes;

    //##################################################
    //# constuctor
    //##################################################

    public KmgModelType(KmgElement parent)
    {
        super(parent);

        _validCharacters = new KmList<>();
    }

    //##################################################
    //# name
    //##################################################

    public String getName()
    {
        return _name;
    }

    public void setName(String e)
    {
        _name = e;
    }

    public boolean hasName(String s)
    {
        return Kmu.isEqual(_name, s);
    }

    //##################################################
    //# comment
    //##################################################

    public String getComment()
    {
        return _comment;
    }

    public void setComment(String e)
    {
        _comment = e;
    }

    //##################################################
    //# base type
    //##################################################

    public KmProtoType getProtoType()
    {
        return _protoType;
    }

    public void setProtoType(KmProtoType e)
    {
        _protoType = e;
    }

    public boolean hasProtoType()
    {
        return getProtoType() != null;
    }

    public boolean hasProtoType(String s)
    {
        return getProtoType().hasName(s);
    }

    //##################################################
    //# testing (types)
    //##################################################

    public boolean isString()
    {
        return hasProtoType(STRING);
    }

    public boolean isInteger()
    {
        return hasProtoType(INTEGER);
    }

    public boolean isLong()
    {
        return hasProtoType(LONG);
    }

    public boolean isBoolean()
    {
        return hasProtoType(BOOLEAN);
    }

    public boolean isBytes()
    {
        return hasProtoType(BYTES);
    }

    public boolean isDecimal()
    {
        return hasProtoType(DECIMAL);
    }

    public boolean isDouble()
    {
        return hasProtoType(DOUBLE);
    }

    public boolean isTimestamp()
    {
        return hasProtoType(TIMESTAMP);
    }

    public boolean isTime()
    {
        return hasProtoType(TIME);
    }

    public boolean isDate()
    {
        return hasProtoType(DATE);
    }

    public boolean isMoney()
    {
        return hasProtoType(MONEY);
    }

    public boolean isKilogram()
    {
        return hasProtoType(KILOGRAM);
    }

    public boolean isDayFrequency()
    {
        return hasProtoType(FREQUENCY);
    }

    public boolean isWeight()
    {
        return hasProtoType(WEIGHT);
    }

    //##################################################
    //# length
    //##################################################

    public Integer getMinimumLength()
    {
        return _minimumLength;
    }

    public void setMinimumLength(Integer e)
    {
        _minimumLength = e;
    }

    public boolean hasMinimumLength()
    {
        return _minimumLength != null;
    }

    public Integer getMaximumLength()
    {
        return _maximumLength;
    }

    public void setMaximumLength(Integer e)
    {
        _maximumLength = e;
    }

    public boolean hasMaximumLength()
    {
        return _maximumLength != null;
    }

    public Integer getFixedLength()
    {
        if ( !hasFixedLength() )
            error("Field (%s) does not have a fixed length.", this);

        return getMaximumLength();
    }

    public boolean hasFixedLength()
    {
        if ( !hasMinimumLength() )
            return false;

        if ( !hasMaximumLength() )
            return false;

        return getMinimumLength().equals(getMaximumLength());
    }

    public boolean isChar()
    {
        if ( !isString() )
            return false;

        if ( !hasMaximumLength() )
            return false;

        if ( hasFixedLength() )
            return true;

        return getMaximumLength() <= SQL_STRING_AS_CHAR_LENGTH;
    }

    //##################################################
    //# numeric size
    //##################################################

    public Integer getAllDigits()
    {
        return _allDigits;
    }

    public void setAllDigits(Integer e)
    {
        _allDigits = e;
    }

    public Integer getRightDigits()
    {
        return _rightDigits;
    }

    public void setRightDigits(Integer e)
    {
        _rightDigits = e;
    }

    //##################################################
    //# valid characters
    //##################################################

    public KmList<String> getValidCharacters()
    {
        return _validCharacters;
    }

    //##################################################
    //# valid characters (testing)
    //##################################################

    public boolean allowsAll()
    {
        return hasValidCharacters(ALLOWS_ALL);
    }

    public boolean allowsPrintable()
    {
        return hasValidCharacters(ALLOWS_PRINTABLE);
    }

    public boolean allowsLetters()
    {
        return hasValidCharacters(ALLOWS_LETTERS);
    }

    public boolean allowsDigits()
    {
        return hasValidCharacters(ALLOWS_DIGITS);
    }

    public boolean allowsSymbols()
    {
        return hasValidCharacters(ALLOWS_SYMBOLS);
    }

    public boolean allowsWhitespace()
    {
        return hasValidCharacters(ALLOWS_WHITESPACE);
    }

    public boolean hasValidCharacters(String s)
    {
        return getValidCharacters().contains(s);
    }

    //##################################################
    //# auto convert
    //##################################################

    public boolean getForcesLowerCase()
    {
        return _forcesLowerCase;
    }

    public boolean getForcesUpperCase()
    {
        return _forcesUpperCase;
    }

    public boolean getStripsLeadingZeros()
    {
        return _stripsLeadingZeros;
    }

    public boolean getStripsAllSpaces()
    {
        return _stripsAllSpaces;
    }

    public boolean getStripsAllDashes()
    {
        return _stripsAllDashes;
    }

    //##################################################
    //# column width
    //##################################################

    public Integer getColumnWidthOverride()
    {
        return _columnWidth;
    }

    public void setColumnWidth(Integer e)
    {
        _columnWidth = e;
    }

    public Integer getColumnWidth()
    {
        if ( _columnWidth != null )
            return _columnWidth;

        if ( hasMaximumLength() )
            return Kmu.constrain(getMaximumLength(), 3, 20);

        return 10;
    }

    //##################################################
    //# parse
    //##################################################

    @Override
    public void parse(KmStfElement x)
    {
        checkAttributeKeys(
            x,
            "name",
            "comment",
            "baseType",
            "minimumLength",
            "maximumLength",
            "allDigits",
            "rightDigits",
            "allows",
            "forceLowerCase",
            "forceUpperCase",
            "stripLeadingZeros",
            "stripAllSpaces",
            "stripAllDashes",
            "columnWidth");

        checkAttributeValues(
            x,
            "allows",
            ALLOWS_ALL,
            ALLOWS_PRINTABLE,
            ALLOWS_LETTERS,
            ALLOWS_DIGITS,
            ALLOWS_SYMBOLS,
            ALLOWS_WHITESPACE);

        _name = parseRequiredString(x, "name");
        _comment = parseRequiredString(x, "comment");

        String baseTypeName = parseRequiredString(x, "baseType");
        _protoType = KmProtoTypes.get(baseTypeName);
        if ( _protoType == null )
            error(x, "Unknown baseType: %s", baseTypeName);

        _minimumLength = parseInteger(x, "minimumLength", null);
        _maximumLength = parseInteger(x, "maximumLength", null);
        _allDigits = parseInteger(x, "allDigits", null);
        _rightDigits = parseInteger(x, "rightDigits", null);
        _validCharacters = parseStrings(x, "allows");
        _forcesLowerCase = parseBoolean(x, "forceLowerCase");
        _forcesUpperCase = parseBoolean(x, "forceUpperCase");
        _stripsLeadingZeros = parseBoolean(x, "stripLeadingZeros");
        _stripsAllSpaces = parseBoolean(x, "stripAllSpaces");
        _stripsAllDashes = parseBoolean(x, "stripAllDashes");
        _columnWidth = parseInteger(x, "columnWidth", null);
    }

    @Override
    public void validate()
    {
        // none
    }

    @Override
    public void postValidate()
    {
        // none
    }

    //##################################################
    //# formatting
    //##################################################

    public String toSqlType()
    {
        return getProtoType().getDatabaseType(this);
    }

    public String toSqlGetter()
    {
        return getProtoType().formatSqlGetter();
    }

    public String toJavaType()
    {
        return getProtoType().format_JavaType();
    }

    //##################################################
    //# context
    //##################################################

    public String getf_name()
    {
        return getName();
    }

    public String getf_maximumLength()
    {
        return getMaximumLength() + "";
    }

    public String getf_columnWidth()
    {
        return getColumnWidth() + "";
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return Kmu.format("type(%s)", _name);
    }

    //##################################################
    //# static sort
    //##################################################

    public static KmComparator<KmgModelType> getNameComparator()
    {
        return new KmComparator<KmgModelType>()
        {
            @Override
            public int compare(KmgModelType a, KmgModelType b)
            {
                return a.getName().compareTo(b.getName());
            }
        };
    }

}
