package com.app.ui.page.importer;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;
import com.kodemore.exception.error.KmErrorList;
import com.kodemore.time.KmTimeZone;
import com.kodemore.utility.Kmu;

import com.app.criteria.MySiteCriteria;
import com.app.dao.MyChoiceDao;
import com.app.model.MyCustomer;
import com.app.model.MyPriority;
import com.app.model.MyProject;
import com.app.model.MyChoice;
import com.app.model.MySite;
import com.app.model.base.MyChoiceType;
import com.app.ui.page.importer.base.MyImporter;
import com.app.ui.page.importer.base.MyImporterDuplicatePolicy;
import com.app.ui.page.importer.base.MyImporterStringColumn;

/**
 * I import Sites from csv.
 */
public class MySiteImporter
    extends MyImporter
{
    //##################################################
    //# variables
    //##################################################

    private MyProject _project;

    //==================================================
    //= variables :: columns
    //==================================================

    private MyImporterStringColumn _customerColumn;
    private MyImporterStringColumn _numberColumn;
    private MyImporterStringColumn _nameColumn;
    private MyImporterStringColumn _typeColumn;
    private MyImporterStringColumn _timeZoneColumn;
    private MyImporterStringColumn _attentionColumn;
    private MyImporterStringColumn _street1Column;
    private MyImporterStringColumn _street2Column;
    private MyImporterStringColumn _cityColumn;
    private MyImporterStringColumn _regionColumn;
    private MyImporterStringColumn _postalCodeColumn;
    private MyImporterStringColumn _countryColumn;
    private MyImporterStringColumn _phoneColumn;

    //==================================================
    //= variables :: current record
    //==================================================

    private MyCustomer _currentCustomer;
    private MySite     _currentSite;

    //==================================================
    //= variables :: results
    //==================================================

    /**
     * The list of NEW sites.
     */
    private KmList<MySite> _newSites;

    /**
     * The list of NEW site types.
     */
    private KmList<MyChoice> _newSiteTypes;

    //==================================================
    //= variables :: doa cache
    //==================================================

    /**
     * The cached list of customers.
     * customer name (lowercase) => customer
     */
    private KmMap<String,MyCustomer> _customers;

    /**
     * The cached list of sites.
     * customer => siteNumber (lowercase) => site
     */
    private KmMap<MyCustomer,KmMap<String,MySite>> _customerSites;

    /**
     * The cached list of site types.
     * This is initially populated with existing types.
     * Newly added types are also added.
     */
    private KmMap<Object,MyChoice> _siteTypes;

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
        _customerColumn = createCustomerColumn();
        _numberColumn = createNumberColumn();
        _nameColumn = createNameColumn();
        _typeColumn = createTypeColumn();
        _timeZoneColumn = createTimeZoneColumn();
        _attentionColumn = createAttentionColumn();
        _street1Column = createStreet1Column();
        _street2Column = createStreet2Column();
        _cityColumn = createCityColumn();
        _regionColumn = createRegionColumn();
        _postalCodeColumn = createPostalCodeColumn();
        _countryColumn = createCountryColumn();
        _phoneColumn = createPhoneColumn();
    }

    private MyImporterStringColumn createCustomerColumn()
    {
        MyImporterStringColumn e;
        e = addStringColumn("customer");
        e.setSample("Acme Inc");
        e.setValidator(MyCustomer.Meta.Name);
        e.setRequired();
        e.setDescription(MySite.Meta.Customer);
        e.addDescription("The customer must already exist in this project.");
        return e;
    }

    private MyImporterStringColumn createNumberColumn()
    {
        MyImporterStringColumn e;
        e = addStringColumn("number");
        e.setSample("S0001");
        e.setDescription(MySite.Meta.Number);
        e.setValidator(MySite.Meta.Number);
        e.setRequired();
        return e;
    }

    private MyImporterStringColumn createNameColumn()
    {
        MyImporterStringColumn e;
        e = addStringColumn("name");
        e.setSample("Denver 5th and Vine");
        e.setDescription(MySite.Meta.Name);
        e.setValidator(MySite.Meta.Name);
        e.setRequired();
        return e;
    }

    private MyImporterStringColumn createTypeColumn()
    {
        MyImporterStringColumn e;
        e = addStringColumn("type");
        e.setSample("Corp");
        e.setDescription(MySite.Meta.Type);
        e.setValidator(MyChoice.Meta.Name);
        e.setOptional();
        return e;
    }

    private MyImporterStringColumn createTimeZoneColumn()
    {
        MyImporterStringColumn e;
        e = addStringColumn("timeZone");
        e.setSample("US/Mountain");
        e.setDescription(MySite.Meta.TimeZoneCode);
        e.addDescription("Use the project's default timezone if not specified.");
        e.setValidator(MySite.Meta.TimeZoneCode);
        e.setOptional();
        return e;
    }

    private MyImporterStringColumn createAttentionColumn()
    {
        MyImporterStringColumn e;
        e = addStringColumn("attention");
        e.setSample("Attn: John");
        e.setDescription(MySite.Meta.AddressAttention);
        e.setValidator(MySite.Meta.AddressAttention);
        e.setOptional();
        return e;
    }

    private MyImporterStringColumn createStreet1Column()
    {
        MyImporterStringColumn e;
        e = addStringColumn("street1");
        e.setSample("1600 Main Street");
        e.setDescription(MySite.Meta.AddressStreet1);
        e.setValidator(MySite.Meta.AddressStreet1);
        e.setOptional();
        return e;
    }

    private MyImporterStringColumn createStreet2Column()
    {
        MyImporterStringColumn e;
        e = addStringColumn("street2");
        e.setSample("Apt 23");
        e.setDescription(MySite.Meta.AddressStreet2);
        e.setValidator(MySite.Meta.AddressStreet2);
        e.setOptional();
        return e;
    }

    private MyImporterStringColumn createCityColumn()
    {
        MyImporterStringColumn e;
        e = addStringColumn("city");
        e.setSample("Denver");
        e.setDescription(MySite.Meta.AddressCity);
        e.setValidator(MySite.Meta.AddressCity);
        e.setOptional();
        return e;
    }

    private MyImporterStringColumn createRegionColumn()
    {
        MyImporterStringColumn e;
        e = addStringColumn("region");
        e.setSample("CO");
        e.setDescription(MySite.Meta.AddressRegion);
        e.setValidator(MySite.Meta.AddressRegion);
        e.setOptional();
        return e;
    }

    private MyImporterStringColumn createPostalCodeColumn()
    {
        MyImporterStringColumn e;
        e = addStringColumn("postalCode");
        e.setSample("80237");
        e.setDescription(MySite.Meta.AddressPostalCode);
        e.setValidator(MySite.Meta.AddressPostalCode);
        e.setOptional();
        return e;
    }

    private MyImporterStringColumn createCountryColumn()
    {
        MyImporterStringColumn e;
        e = addStringColumn("country");
        e.setSample("USA");
        e.setDescription(MySite.Meta.AddressCountry);
        e.setValidator(MySite.Meta.AddressCountry);
        e.setOptional();
        return e;
    }

    private MyImporterStringColumn createPhoneColumn()
    {
        MyImporterStringColumn e;
        e = addStringColumn("phone");
        e.setSample("303.555.1000");
        e.setDescription(MySite.Meta.AddressPhone);
        e.setValidator(MySite.Meta.AddressPhone);
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

        _newSites = new KmList<>();
        _newSiteTypes = new KmList<>();

        _customers = null;
        _customerSites = new KmMap<>();
        _siteTypes = null;
    }

    //##################################################
    //# read
    //##################################################

    @Override
    protected void beginRecord()
    {
        _currentCustomer = null;
        _currentSite = null;
    }

    @Override
    protected void handleRecord()
    {
        readCustomer();
        readNumber();
        readName();
        readSiteType();
        readTimeZone();
        readAttention();
        readStreet1();
        readStreet2();
        readCity();
        readRegion();
        readPostalCode();
        readCountry();
        readPhone();
    }

    @Override
    protected void endRecord()
    {
        if ( _currentSite == null )
            return;

        KmErrorList errors = _currentSite.getValidationErrors();
        if ( errors.isOk() )
            _newSites.add(_currentSite);
        else
            addRecordError(null, errors.formatFirstMessage());
    }

    //##################################################
    //# read columns
    //##################################################

    private void readCustomer()
    {
        MyImporterStringColumn col = _customerColumn;
        String name = col.getValue();

        MyCustomer customer = findCustomer(name);
        if ( customer == null )
        {
            addRecordError(col, "No such customer: %s.", name);
            return;
        }

        _currentCustomer = customer;
    }

    private void readNumber()
    {
        if ( _currentCustomer == null )
            return;

        MyImporterStringColumn col = _numberColumn;
        String number = col.getValue();

        MySite site = findSite(_currentCustomer, number);
        if ( site == null )
        {
            _currentSite = createNewSite(number);
            return;
        }

        MyImporterDuplicatePolicy policy = getDuplicatePolicy();
        switch ( policy )
        {
            case ErrorOnDuplicates:
                addRecordError(col, "Duplicate, site already exists: %s.", number);
                return;

            case SkipDuplicates:
                skipRecord();
                return;

            case UpdateDuplicates:
                _currentSite = site;
                return;
        }
        throw Kmu.newEnumError(policy);
    }

    private MySite createNewSite(String number)
    {
        MySite site;
        MyPriority priority = getProject().getDefaultPriority();

        site = new MySite();
        site.setCustomer(_currentCustomer);
        site.setNumber(number);
        site.setPriority(priority);
        return site;
    }

    private void readName()
    {
        if ( _currentSite == null )
            return;

        MyImporterStringColumn col = _nameColumn;
        String name = col.getValue();
        _currentSite.setName(name);
    }

    private void readSiteType()
    {
        if ( _currentSite == null )
            return;

        MyImporterStringColumn col = _typeColumn;
        String name = col.getValue();

        if ( name == null )
            return;

        MyChoice oldType = findSiteType(name);
        if ( oldType != null )
        {
            _currentSite.setType(oldType);
            return;
        }

        MyChoice newType;
        newType = new MyChoice();
        newType.setProject(getProject());
        newType.setName(name);

        KmErrorList errors = newType.getValidationErrors();
        if ( errors.hasErrors() )
        {
            addRecordError(col, errors.getFirstProblem());
            return;
        }

        addSiteType(newType);
        _currentSite.setType(newType);
    }

    private void readTimeZone()
    {
        if ( _currentSite == null )
            return;

        MyImporterStringColumn col = _timeZoneColumn;
        String code = col.getValue();

        KmTimeZone zone = code == null
            ? getProject().getTimeZone()
            : KmTimeZone.findCode(code);

        if ( zone == null )
        {
            addRecordError(col, "Invalid timezone code: %s.", code);
            return;
        }

        _currentSite.setTimeZone(zone);
    }

    private void readAttention()
    {
        if ( _currentSite == null )
            return;

        MyImporterStringColumn col = _attentionColumn;
        String s = col.getValue();

        _currentSite.setAddressAttention(s);
    }

    private void readStreet1()
    {
        if ( _currentSite == null )
            return;

        MyImporterStringColumn col = _street1Column;
        String s = col.getValue();

        _currentSite.setAddressStreet1(s);
    }

    private void readStreet2()
    {
        if ( _currentSite == null )
            return;

        MyImporterStringColumn col = _street2Column;
        String s = col.getValue();

        _currentSite.setAddressStreet2(s);
    }

    private void readCity()
    {
        if ( _currentSite == null )
            return;

        MyImporterStringColumn col = _cityColumn;
        String s = col.getValue();

        _currentSite.setAddressCity(s);
    }

    private void readRegion()
    {
        if ( _currentSite == null )
            return;

        MyImporterStringColumn col = _regionColumn;
        String s = col.getValue();

        _currentSite.setAddressRegion(s);
    }

    private void readPostalCode()
    {
        if ( _currentSite == null )
            return;

        MyImporterStringColumn col = _postalCodeColumn;
        String s = col.getValue();

        _currentSite.setAddressPostalCode(s);
    }

    private void readCountry()
    {
        if ( _currentSite == null )
            return;

        MyImporterStringColumn col = _countryColumn;
        String s = col.getValue();

        _currentSite.setAddressCountry(s);
    }

    private void readPhone()
    {
        if ( _currentSite == null )
            return;

        MyImporterStringColumn col = _phoneColumn;
        String s = col.getValue();

        _currentSite.setAddressPhone(s);
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

    //==================================================
    //= dao :: sites
    //==================================================

    private MySite findSite(MyCustomer customer, String number)
    {
        if ( customer == null )
            return null;

        if ( number == null )
            return null;

        KmMap<String,MySite> sites = _customerSites.get(customer);
        if ( sites == null )
        {
            sites = findSitesFor(customer).toMap(e -> e.getNumber().toLowerCase());
            _customerSites.put(customer, sites);
        }

        return sites.get(number.toLowerCase());
    }

    private KmList<MySite> findSitesFor(MyCustomer customer)
    {
        MySiteCriteria c;
        c = getAccess().getSiteDao().createCriteria();
        c.whereCustomerIs(customer);
        return c.findAll();
    }

    //==================================================
    //= dao :: site types
    //==================================================

    private MyChoice findSiteType(String name)
    {
        if ( _siteTypes == null )
            _siteTypes = findSiteTypes().toMap(e -> e.getName().toLowerCase());

        return _siteTypes.get(name.toLowerCase());
    }

    private void addSiteType(MyChoice e)
    {
        _newSiteTypes.add(e);
        _siteTypes.put(e.getName().toLowerCase(), e);
    }

    private KmList<MyChoice> findSiteTypes()
    {
        MyProject project = getProject();
        MyChoiceType type = MyChoiceType.SiteType;
        MyChoiceDao dao = getAccess().getChoiceDao();

        return dao.findAllChoicesFor(project, type);
    }

    //##################################################
    //# save
    //##################################################

    @Override
    protected void saveAll()
    {
        saveAll(_newSiteTypes);
        saveAll(_newSites);
    }

    //##################################################
    //# results
    //##################################################

    public KmList<MySite> getNewSites()
    {
        return _newSites;
    }
}
