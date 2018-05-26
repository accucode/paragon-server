package com.app.ui.page.importer.base;

import com.kodemore.collection.KmList;
import com.kodemore.csv.KmCsvReader;
import com.kodemore.meta.KmMetaProperty;
import com.kodemore.time.KmDate;
import com.kodemore.types.KmMoney;
import com.kodemore.types.KmQuantity;
import com.kodemore.utility.KmResult;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoAccess;
import com.app.model.core.MyAbstractDaoDomain;
import com.app.utility.MyGlobals;

/**
 * I coordinate importing data from a csv source.
 */
public abstract class MyImporter
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The csv source text.
     */
    private String _source;

    /**
     * This policy determines how duplicates should be handled.
     * Defaults to ERROR.
     */
    private MyImporterDuplicatePolicy _duplicatePolicy;

    /**
     * The ready used to parse the csv structure.
     */
    private KmCsvReader _reader;

    /**
     * The list of exected columns. This includes the column names,
     * data types, and validation rules.
     */
    private KmList<MyImporterColumn<?>> _columns;

    /**
     * The list of errors found during the import.
     */
    private KmList<MyImporterError> _errors;

    /**
     * The number of records that were skipped.
     */
    private int _skipCount;

    //==================================================
    //= variables :: current record
    //==================================================

    private boolean _currentOk;

    //##################################################
    //# constructor
    //##################################################

    public MyImporter()
    {
        _duplicatePolicy = MyImporterDuplicatePolicy.ErrorOnDuplicates;
        _columns = new KmList<>();
        installColumns();
    }

    protected abstract void installColumns();

    /**
     * If true, the duplicate policy dropdown will be displayed,
     * and the subclass should handle the policy selection appropriately.
     *
     * If false, the policy dropdown will be hidden,
     * and the subclass should ignore it.
     */
    public abstract boolean usesDuplicatePolicy();

    //##################################################
    //# columns
    //##################################################

    public KmList<MyImporterColumn<?>> getColumns()
    {
        return _columns;
    }

    private KmList<MyImporterColumn<?>> getActiveColumns()
    {
        return getColumns().select(e -> e.isActive());
    }

    private KmList<MyImporterColumn<?>> getRequiredColumns()
    {
        return getColumns().select(e -> e.isRequired());
    }

    private <E extends MyImporterColumn<?>> E addColumn(String name, E e)
    {
        e.setName(name);
        _columns.add(e);
        return e;
    }

    //==================================================
    //= columns :: string
    //==================================================

    public MyImporterStringColumn addStringColumn(String name)
    {
        return addColumn(name, new MyImporterStringColumn(this));
    }

    public MyImporterStringColumn addStringColumn(String name, String sample, String def)
    {
        MyImporterStringColumn e;
        e = addStringColumn(name);
        e.setSample(sample);
        e.setDefaultValue(def);
        return e;
    }

    public MyImporterStringColumn addStringColumn(KmMetaProperty<?,String> meta, String sample)
    {
        return addStringColumn(meta, sample, null);
    }

    public MyImporterStringColumn addStringColumn(
        KmMetaProperty<?,String> meta,
        String sample,
        String def)
    {
        String name = meta.getName();
        boolean required = meta.isRequired();

        MyImporterStringColumn e;
        e = addStringColumn(name, sample, def);
        e.setDescription(meta);
        e.setValidator(meta);

        if ( required )
            e.setRequired();

        return e;
    }

    //==================================================
    //= columns :: integer
    //==================================================

    public MyImporterIntegerColumn addIntegerColumn(String name)
    {
        return addColumn(name, new MyImporterIntegerColumn(this));
    }

    public MyImporterIntegerColumn addIntegerColumn(KmMetaProperty<?,Integer> meta, Integer sample)
    {
        return addIntegerColumn(meta, sample, null);
    }

    public MyImporterIntegerColumn addIntegerColumn(
        KmMetaProperty<?,Integer> meta,
        Integer sample,
        Integer def)
    {
        String name = meta.getName();
        boolean required = meta.isRequired();

        MyImporterIntegerColumn e;
        e = addIntegerColumn(name);
        e.setSample(sample);
        e.setDescription(meta);
        e.setValidator(meta);
        e.setDefaultValue(def);

        if ( required )
            e.setRequired();

        return e;
    }

    //==================================================
    //= columns :: double
    //==================================================

    public MyImporterDoubleColumn addDoubleColumn(String name)
    {
        return addColumn(name, new MyImporterDoubleColumn(this));
    }

    public MyImporterDoubleColumn addDoubleColumn(KmMetaProperty<?,Double> meta, Double sample)
    {
        return addDoubleColumn(meta, sample, null);
    }

    public MyImporterDoubleColumn addDoubleColumn(
        KmMetaProperty<?,Double> meta,
        Double sample,
        Double def)
    {
        String name = meta.getName();
        boolean required = meta.isRequired();

        MyImporterDoubleColumn e;
        e = addDoubleColumn(name);
        e.setSample(sample);
        e.setDescription(meta);
        e.setValidator(meta);
        e.setDefaultValue(def);

        if ( required )
            e.setRequired();

        return e;
    }

    //==================================================
    //= columns :: boolean
    //==================================================

    public MyImporterBooleanColumn addBooleanColumn(String name)
    {
        return addColumn(name, new MyImporterBooleanColumn(this));
    }

    public MyImporterBooleanColumn addBooleanColumn(KmMetaProperty<?,Boolean> meta, Boolean sample)
    {
        return addBooleanColumn(meta, sample, null);
    }

    public MyImporterBooleanColumn addBooleanColumn(
        KmMetaProperty<?,Boolean> meta,
        Boolean sample,
        Boolean def)
    {
        String name = meta.getName();
        boolean required = meta.isRequired();

        MyImporterBooleanColumn e;
        e = addBooleanColumn(name);
        e.setSample(sample);
        e.setDescription(meta);
        e.setValidator(meta);
        e.setDefaultValue(def);

        if ( required )
            e.setRequired();

        return e;
    }

    //==================================================
    //= columns :: date
    //==================================================

    public MyImporterDateColumn addDateColumn(String name)
    {
        return addColumn(name, new MyImporterDateColumn(this));
    }

    public MyImporterDateColumn addDateColumn(KmMetaProperty<?,KmDate> meta, KmDate sample)
    {
        return addDateColumn(meta, sample, null);
    }

    public MyImporterDateColumn addDateColumn(
        KmMetaProperty<?,KmDate> meta,
        KmDate sample,
        KmDate def)
    {
        String name = meta.getName();
        boolean required = meta.isRequired();

        MyImporterDateColumn e;
        e = addDateColumn(name);
        e.setSample(sample);
        e.setDescription(meta);
        e.setValidator(meta);
        e.setDefaultValue(def);

        if ( required )
            e.setRequired();

        return e;
    }

    //==================================================
    //= columns :: quantity
    //==================================================

    public MyImporterQuantityColumn addQuantityColumn(String name)
    {
        return addColumn(name, new MyImporterQuantityColumn(this));
    }

    public MyImporterQuantityColumn addQuantityColumn(
        KmMetaProperty<?,KmQuantity> meta,
        KmQuantity sample)
    {
        return addQuantityColumn(meta, sample, null);
    }

    public MyImporterQuantityColumn addQuantityColumn(
        KmMetaProperty<?,KmQuantity> meta,
        KmQuantity sample,
        KmQuantity def)
    {
        String name = meta.getName();
        boolean required = meta.isRequired();

        MyImporterQuantityColumn e;
        e = addQuantityColumn(name);
        e.setSample(sample);
        e.setDescription(meta);
        e.setValidator(meta);
        e.setDefaultValue(def);

        if ( required )
            e.setRequired();

        return e;
    }

    //==================================================
    //= columns :: money
    //==================================================

    public MyImporterMoneyColumn addMoneyColumn(String name)
    {
        return addColumn(name, new MyImporterMoneyColumn(this));
    }

    public MyImporterMoneyColumn addMoneyColumn(KmMetaProperty<?,KmMoney> meta, KmMoney sample)
    {
        return addMoneyColumn(meta, sample, null);
    }

    public MyImporterMoneyColumn addMoneyColumn(
        KmMetaProperty<?,KmMoney> meta,
        KmMoney sample,
        KmMoney def)
    {
        String name = meta.getName();
        boolean required = meta.isRequired();

        MyImporterMoneyColumn e;
        e = addMoneyColumn(name);
        e.setSample(sample);
        e.setDescription(meta);
        e.setValidator(meta);
        e.setDefaultValue(def);

        if ( required )
            e.setRequired();

        return e;
    }

    //##################################################
    //# duplicate policy
    //##################################################

    public MyImporterDuplicatePolicy getDuplicatePolicy()
    {
        return _duplicatePolicy;
    }

    public void setDuplicatePolicy(MyImporterDuplicatePolicy e)
    {
        _duplicatePolicy = e == null
            ? MyImporterDuplicatePolicy.ErrorOnDuplicates
            : e;
    }

    //##################################################
    //# errors
    //##################################################

    public KmList<MyImporterError> getErrors()
    {
        return _errors;
    }

    public boolean hasErrors()
    {
        return _errors.isNotEmpty();
    }

    public boolean isOk()
    {
        return !hasErrors();
    }

    public void addHeaderError(String msg, Object... args)
    {
        MyImporterError e;
        e = new MyImporterError();
        e.setColumnName("Header");
        e.setMessage(msg, args);
        _addError(e);
    }

    protected void addRecordError(MyImporterColumn<?> col, String msg, Object... args)
    {
        String name = col == null
            ? Kmu.formatMetaValue("unknown")
            : col.getName();

        MyImporterError e;
        e = new MyImporterError();
        e.setRecordIndex(_reader.getRecordIndex());
        e.setColumnName(name);
        e.setMessage(msg, args);
        _addError(e);
    }

    protected void addGeneralError(String msg, Object... args)
    {
        MyImporterError e;
        e = new MyImporterError();
        e.setRecordIndex(_reader.getRecordIndex());
        e.setColumnName("...");
        e.setMessage(msg, args);
        _addError(e);
    }

    private void _addError(MyImporterError e)
    {
        _errors.add(e);
        _currentOk = false;
    }

    //##################################################
    //# csv
    //##################################################

    public void setCsv(String csv)
    {
        _source = csv;
    }

    //##################################################
    //# reset
    //##################################################

    protected void reset()
    {
        _reader = new KmCsvReader();
        if ( Kmu.hasValue(_source) )
            _reader.setSource(_source);

        _skipCount = 0;
        _errors = new KmList<>();
    }

    protected String getRawFieldAt(int index)
    {
        String s = _reader.getString(index);

        if ( s == null )
            return null;

        s = s.trim();

        return s.isEmpty()
            ? null
            : s;
    }

    //##################################################
    //# test
    //##################################################

    public void testAll()
    {
        reset();

        testSource();
        if ( hasErrors() )
            return;

        testHeader();
        if ( hasErrors() )
            return;

        testRequiredColumns();
        if ( hasErrors() )
            return;

        testRecords();
    }

    private void testSource()
    {
        if ( Kmu.isEmpty(_source) )
            addHeaderError("Nothing to import.");
    }

    private void testHeader()
    {
        boolean hasHeader = nextRecord();
        if ( !hasHeader )
        {
            addHeaderError("Header columns are required.");
            return;
        }

        KmList<String> v = _reader.getFields().collect(e -> e.trim());
        if ( v.hasDuplicates() )
        {
            addHeaderError("Duplicate column headers: %s.", v.getDuplicates().join());
            return;
        }

        int n = _reader.getFieldCount();
        for ( int i = 0; i < n; i++ )
            testHeaderColumn(i);
    }

    private void testHeaderColumn(int i)
    {
        String header = _reader.getString(i).trim();

        if ( Kmu.isEmpty(header) )
        {
            addHeaderError("Column %s is empty.", i + 1);
            return;
        }

        for ( MyImporterColumn<?> col : getColumns() )
            if ( col.hasName(header) )
            {
                col.setIndex(i);
                return;
            }

        addHeaderError("Column '%s' is not a recognized value.", header);
    }

    private void testRequiredColumns()
    {
        for ( MyImporterColumn<?> col : getRequiredColumns() )
            if ( !col.hasIndex() )
                addHeaderError("Column '%s' is required.", col.getName());
    }

    private void testRecords()
    {
        boolean hasMore = nextRecord();
        if ( !hasMore )
        {
            addHeaderError("No data records available.");
            return;
        }

        while ( hasMore )
        {
            testRecord();
            hasMore = nextRecord();

            if ( _errors.size() > 100 )
            {
                addGeneralError("Too many errors. Fix the current problems, then try again.");
                break;
            }
        }
    }

    protected void testRecord()
    {
        try
        {
            _currentOk = true;
            testColumnFields();
            if ( !_currentOk )
                return;

            beginRecord();
            handleRecord();

            if ( _currentOk )
                endRecord();
        }
        catch ( MyImporterSkipSignal ex )
        {
            // not an error, just skipping the current record.
            _skipCount++;
        }
    }

    protected final void skipRecord()
    {
        throw new MyImporterSkipSignal();
    }

    public int getSkipCount()
    {
        return _skipCount;
    }

    protected abstract void beginRecord();

    protected abstract void endRecord();

    protected void testColumnFields()
    {
        for ( MyImporterColumn<?> col : getActiveColumns() )
            testColumnField(col);
    }

    private void testColumnField(MyImporterColumn<?> col)
    {
        KmResult<?> result = col.getResult();

        if ( result.hasError() )
            addRecordError(col, result.getError());
    }

    //##################################################
    //# read
    //##################################################

    protected abstract void handleRecord();

    //##################################################
    //# import
    //##################################################

    public final void importAll()
    {
        reset();
        testAll();

        if ( hasErrors() )
            return;

        saveAll();
    }

    //##################################################
    //# save
    //##################################################

    protected abstract void saveAll();

    protected void saveAll(KmList<? extends MyAbstractDaoDomain<?>> v)
    {
        for ( MyAbstractDaoDomain<?> e : v )
            e.daoAttach();
    }

    //##################################################
    //# support
    //##################################################

    protected MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    /**
     * Get the next non-blank record from the csv source.
     */
    private boolean nextRecord()
    {
        while ( true )
        {
            boolean hasNext = _reader.nextRecord();
            if ( !hasNext )
                return false;

            int n = _reader.getFieldCount();
            if ( n == 0 )
                continue;

            if ( n == 1 )
            {
                String s = _reader.getString(0);
                if ( s.trim().isEmpty() )
                    continue;
            }

            return true;
        }
    }

}
