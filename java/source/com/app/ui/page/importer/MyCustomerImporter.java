package com.app.ui.page.importer;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.exception.error.KmErrorList;
import com.kodemore.utility.Kmu;

import com.app.model.MyCustomer;
import com.app.model.MyProject;
import com.app.ui.page.importer.base.MyImporter;
import com.app.ui.page.importer.base.MyImporterDuplicatePolicy;
import com.app.ui.page.importer.base.MyImporterStringColumn;

/**
 * I import Customers from csv.
 */
public class MyCustomerImporter
    extends MyImporter
{
    //##################################################
    //# variables
    //##################################################

    private MyProject _project;

    //==================================================
    //= variables :: columns
    //==================================================

    private MyImporterStringColumn _nameColumn;
    private MyImporterStringColumn _billingAttentionColumn;
    private MyImporterStringColumn _billingStreet1Column;
    private MyImporterStringColumn _billingStreet2Column;
    private MyImporterStringColumn _billingCityColumn;
    private MyImporterStringColumn _billingRegionColumn;
    private MyImporterStringColumn _billingPostalCodeColumn;
    private MyImporterStringColumn _billingCountryColumn;
    private MyImporterStringColumn _billingPhoneColumn;

    //==================================================
    //= variables :: current record
    //==================================================

    private MyCustomer _currentCustomer;

    //==================================================
    //= variables :: results
    //==================================================

    /**
     * The list of NEW customers.
     */
    private KmList<MyCustomer> _newCustomers;

    //==================================================
    //= variables :: dao cache
    //==================================================

    /**
     * The cached list of customers.
     * customer name (lowercase) => customer
     */
    private KmMap<String,MyCustomer> _customers;

    //##################################################
    //# duplicate policy
    //##################################################

    @Override
    public boolean usesDuplicatePolicy()
    {
        return true;
    }

    //##################################################
    //# project
    //##################################################

    public MyProject getProject()
    {
        return _project;
    }

    public void setProject(MyProject e)
    {
        _project = e;
    }

    public boolean hasProject()
    {
        return getProject() != null;
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installColumns()
    {
        _nameColumn = createNameColumn();
        _billingAttentionColumn = createBillingAttentionColumn();
        _billingStreet1Column = createBillingStreet1Column();
        _billingStreet2Column = createBillingStreet2Column();
        _billingCityColumn = createBillingCityColumn();
        _billingRegionColumn = createBillingRegionColumn();
        _billingPostalCodeColumn = createBillingPostalCodeColumn();
        _billingCountryColumn = createBillingCountryColumn();
        _billingPhoneColumn = createBillingPhoneColumn();
    }

    private MyImporterStringColumn createNameColumn()
    {
        MyImporterStringColumn e;
        e = addStringColumn("name");
        e.setSample("Acme");
        e.setDescription(MyCustomer.Meta.Name);
        e.setValidator(MyCustomer.Meta.Name);
        e.setRequired();
        return e;
    }

    private MyImporterStringColumn createBillingAttentionColumn()
    {
        MyImporterStringColumn e;
        e = addStringColumn("billingAttention");
        e.setSample("Attn: John");
        e.setDescription(MyCustomer.Meta.BillingAttention);
        e.setValidator(MyCustomer.Meta.BillingAttention);
        e.setOptional();
        return e;
    }

    private MyImporterStringColumn createBillingStreet1Column()
    {
        MyImporterStringColumn e;
        e = addStringColumn("billingStreet1");
        e.setSample("1600 Main Street");
        e.setDescription(MyCustomer.Meta.BillingStreet1);
        e.setValidator(MyCustomer.Meta.BillingStreet1);
        e.setOptional();
        return e;
    }

    private MyImporterStringColumn createBillingStreet2Column()
    {
        MyImporterStringColumn e;
        e = addStringColumn("billingStreet2");
        e.setSample("Apt 23");
        e.setDescription(MyCustomer.Meta.BillingStreet2);
        e.setValidator(MyCustomer.Meta.BillingStreet2);
        e.setOptional();
        return e;
    }

    private MyImporterStringColumn createBillingCityColumn()
    {
        MyImporterStringColumn e;
        e = addStringColumn("billingCity");
        e.setSample("Denver");
        e.setDescription(MyCustomer.Meta.BillingCity);
        e.setValidator(MyCustomer.Meta.BillingCity);
        e.setOptional();
        return e;
    }

    private MyImporterStringColumn createBillingRegionColumn()
    {
        MyImporterStringColumn e;
        e = addStringColumn("billingRegion");
        e.setSample("CO");
        e.setDescription(MyCustomer.Meta.BillingRegion);
        e.setValidator(MyCustomer.Meta.BillingRegion);
        e.setOptional();
        return e;
    }

    private MyImporterStringColumn createBillingPostalCodeColumn()
    {
        MyImporterStringColumn e;
        e = addStringColumn("billingPostalCode");
        e.setSample("80237");
        e.setDescription(MyCustomer.Meta.BillingPostalCode);
        e.setValidator(MyCustomer.Meta.BillingPostalCode);
        e.setOptional();
        return e;
    }

    private MyImporterStringColumn createBillingCountryColumn()
    {
        MyImporterStringColumn e;
        e = addStringColumn("billingCountry");
        e.setSample("USA");
        e.setDescription(MyCustomer.Meta.BillingCountry);
        e.setValidator(MyCustomer.Meta.BillingCountry);
        e.setOptional();
        return e;
    }

    private MyImporterStringColumn createBillingPhoneColumn()
    {
        MyImporterStringColumn e;
        e = addStringColumn("billingPhone");
        e.setSample("303.555.1000");
        e.setDescription(MyCustomer.Meta.BillingPhone);
        e.setValidator(MyCustomer.Meta.BillingPhone);
        e.setOptional();
        return e;
    }

    //##################################################
    //# reset
    //##################################################

    @Override
    protected void reset()
    {
        super.reset();

        _newCustomers = new KmList<>();
    }

    //##################################################
    //# read
    //##################################################

    @Override
    protected void beginRecord()
    {
        _currentCustomer = null;
    }

    @Override
    protected void handleRecord()
    {
        readName();
        readBillingAttention();
        readBillingStreet1();
        readBillingStreet2();
        readBillingCity();
        readBillingRegion();
        readBillingPostalCode();
        readBillingCountry();
        readBillingPhone();
    }

    @Override
    protected void endRecord()
    {
        if ( _currentCustomer == null )
            return;

        KmErrorList errors = _currentCustomer.getValidationErrors();
        if ( errors.isOk() )
            _newCustomers.add(_currentCustomer);
        else
            addRecordError(null, errors.formatFirstMessage());
    }

    //##################################################
    //# read columns
    //##################################################

    private void readName()
    {
        MyImporterStringColumn col = _nameColumn;
        String name = col.getValue();

        MyCustomer customer = findCustomer(name);
        if ( customer == null )
        {
            _currentCustomer = createNewCustomer(name);
            return;
        }

        MyImporterDuplicatePolicy policy = getDuplicatePolicy();
        switch ( policy )
        {
            case ErrorOnDuplicates:
                addRecordError(col, "Duplicate, customer already exists: %s.", name);
                return;

            case SkipDuplicates:
                skipRecord();
                return;

            case UpdateDuplicates:
                _currentCustomer = customer;
                return;
        }
        throw Kmu.newEnumError(policy);
    }

    private MyCustomer createNewCustomer(String name)
    {
        MyCustomer e = new MyCustomer();
        e.setProject(getProject());
        e.setName(name);
        return e;
    }

    private void readBillingAttention()
    {
        if ( _currentCustomer == null )
            return;

        MyImporterStringColumn col = _billingAttentionColumn;
        String s = col.getValue();

        _currentCustomer.setBillingAttention(s);
    }

    private void readBillingStreet1()
    {
        if ( _currentCustomer == null )
            return;

        MyImporterStringColumn col = _billingStreet1Column;
        String s = col.getValue();

        _currentCustomer.setBillingStreet1(s);
    }

    private void readBillingStreet2()
    {
        if ( _currentCustomer == null )
            return;

        MyImporterStringColumn col = _billingStreet2Column;
        String s = col.getValue();

        _currentCustomer.setBillingStreet2(s);
    }

    private void readBillingCity()
    {
        if ( _currentCustomer == null )
            return;

        MyImporterStringColumn col = _billingCityColumn;
        String s = col.getValue();

        _currentCustomer.setBillingCity(s);
    }

    private void readBillingRegion()
    {
        if ( _currentCustomer == null )
            return;

        MyImporterStringColumn col = _billingRegionColumn;
        String s = col.getValue();

        _currentCustomer.setBillingRegion(s);
    }

    private void readBillingPostalCode()
    {
        if ( _currentCustomer == null )
            return;

        MyImporterStringColumn col = _billingPostalCodeColumn;
        String s = col.getValue();

        _currentCustomer.setBillingPostalCode(s);
    }

    private void readBillingCountry()
    {
        if ( _currentCustomer == null )
            return;

        MyImporterStringColumn col = _billingCountryColumn;
        String s = col.getValue();

        _currentCustomer.setBillingCountry(s);
    }

    private void readBillingPhone()
    {
        if ( _currentCustomer == null )
            return;

        MyImporterStringColumn col = _billingPhoneColumn;
        String s = col.getValue();

        _currentCustomer.setBillingPhone(s);
    }

    //##################################################
    //# dao :: customers
    //##################################################

    private MyCustomer findCustomer(String name)
    {
        if ( name == null )
            return null;

        name = name.toLowerCase();

        if ( _customers == null )
            _customers = findCustomers().toMap(e -> e.getName().toLowerCase());

        return _customers.get(name.toLowerCase());
    }

    private KmList<MyCustomer> findCustomers()
    {
        return getProject().getCustomersByName();
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected void saveAll()
    {
        saveAll(_newCustomers);
    }

    //##################################################
    //# results
    //##################################################

    public KmList<MyCustomer> getNewCustomers()
    {
        return _newCustomers;
    }
}
