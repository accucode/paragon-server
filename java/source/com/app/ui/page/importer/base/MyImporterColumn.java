package com.app.ui.page.importer.base;

import com.kodemore.exception.error.KmErrorIF;
import com.kodemore.meta.KmMetaAttribute;
import com.kodemore.meta.KmMetaProperty;
import com.kodemore.servlet.control.ScUtility;
import com.kodemore.servlet.utility.ScFormatter;
import com.kodemore.utility.KmResult;
import com.kodemore.utility.Kmu;
import com.kodemore.validator.KmValidator;

import com.app.utility.MyGlobals;

/**
 * I define a single column within a particular import.
 * The generic V indicates the type of VALUE imported by this column.
 */
public abstract class MyImporterColumn<V>
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The importer this column belongs to.
     */
    private MyImporter _importer;

    /**
     * The name of the column. Columns are not required to be in a
     * specific sequence. Instead, the first csv row must contain
     * headers, and this name is used to identify the header corresponding
     * to this column.
     */
    private String _name;

    /**
     * A description of this column, suitable for display to the user.
     * This typically explains any business rules and background necessary
     * for the user to properly fill in the data.
     */
    private String _description;

    /**
     * The value to use when downloading a sample csv file.
     * Each column type has a default sample, but it usually
     * helps to provide a context sensitive sample.
     */
    private String _sample;

    /**
     * Any validation rules.
     */
    public KmValidator<V> _validator;

    /**
     * The optional default value.  If the column doesn't exist or has
     * no value, this value will be returned by getValue()
     */
    private V _defaultValue;

    /**
     * The index of the the column. This is determine based on the
     * headers that are found. A null value indicates that this column
     * has not been identified in the csv source.
     */
    private Integer _index;

    //##################################################
    //# constructor
    //##################################################

    public MyImporterColumn(MyImporter e)
    {
        _importer = e;
    }

    //##################################################
    //# importer
    //##################################################

    protected MyImporter getImporter()
    {
        return _importer;
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
        return Kmu.isEqualIgnoreCase(getName(), s);
    }

    //##################################################
    //# description
    //##################################################

    public String getDescription()
    {
        return _description;
    }

    public void setDescription(String e)
    {
        _description = e;
    }

    public void setDescription(KmMetaAttribute<?,?> x)
    {
        setDescription(x.getHelp());
    }

    public void addDescription(String msg, Object... args)
    {
        String suffix = Kmu.format(msg, args);

        if ( !hasDescription() )
        {
            setDescription(suffix);
            return;
        }

        String s;
        s = getDescription().trim();
        s = Kmu.ensureSuffix(s, ".");
        s = s + " " + suffix;
        setDescription(s);
    }

    public boolean hasDescription()
    {
        return Kmu.hasValue(getDescription());
    }

    //##################################################
    //# sample
    //##################################################

    public String getSample()
    {
        return _sample == null
            ? getDefaultSample()
            : _sample;
    }

    public void setSample(V e)
    {
        _sample = getFormatter().formatAny(e);
    }

    public abstract String getDefaultSample();

    //##################################################
    //# validation
    //##################################################

    public KmValidator<V> getValidator()
    {
        return _validator;
    }

    public void setValidator(KmValidator<V> e)
    {
        _validator = e;
    }

    public void setValidator(KmMetaProperty<?,V> p)
    {
        setValidator(p.getValidator());
    }

    public boolean hasValidator()
    {
        return _validator != null;
    }

    protected abstract KmValidator<V> newValidator();

    //==================================================
    //= validator :: required
    //==================================================

    public final void setRequired()
    {
        KmValidator<V> e = ScUtility.toRequiredValidator(getValidator());
        setValidator(e);
    }

    public final void setOptional()
    {
        KmValidator<V> e = ScUtility.toOptionalValidator(getValidator());
        setValidator(e);
    }

    public boolean isRequired()
    {
        return hasValidator() && getValidator().isRequired();
    }

    //##################################################
    //# decault
    //##################################################

    public V getDefaultValue()
    {
        return _defaultValue;
    }

    public void setDefaultValue(V e)
    {
        _defaultValue = e;
    }

    //##################################################
    //# validate
    //##################################################

    protected KmResult<V> validate(V value)
    {
        KmErrorIF error = getValidationError(value);

        return error == null
            ? KmResult.createValue(value)
            : KmResult.createError(error.formatProblem());
    }

    protected KmResult<V> validateNull()
    {
        return isRequired()
            ? KmResult.createError("Required.")
            : KmResult.createValue(null);
    }

    protected KmErrorIF getValidationError(V value)
    {
        return hasValidator()
            ? getValidator().getValidationErrors(value).getFirstSafe()
            : null;
    }

    //##################################################
    //# value
    //##################################################

    public abstract KmResult<V> getResult();

    public final V getValue()
    {
        V value = isActive()
            ? getResult().getCheckedValue()
            : null;

        return value == null
            ? getDefaultValue()
            : value;
    }

    //##################################################
    //# index
    //##################################################

    public Integer getIndex()
    {
        return _index;
    }

    public void setIndex(Integer e)
    {
        _index = e;
    }

    public boolean hasIndex()
    {
        return _index != null;
    }

    public boolean isActive()
    {
        return hasIndex();
    }

    //##################################################
    //# support
    //##################################################

    protected ScFormatter getFormatter()
    {
        return MyGlobals.getFormatter();
    }

    protected String getRawField()
    {
        return getImporter().getRawFieldAt(getIndex());
    }
}
