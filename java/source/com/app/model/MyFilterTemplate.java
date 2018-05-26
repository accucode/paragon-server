package com.app.model;

import com.kodemore.collection.KmCollection;
import com.kodemore.collection.KmList;
import com.kodemore.json.KmJsonMap;
import com.kodemore.json.KmJsonReader;
import com.kodemore.utility.Kmu;

import com.app.criteria.MyFilterTemplateCriteria;
import com.app.model.base.MyFilterTemplateBase;
import com.app.model.base.MyFilterTemplateType;
import com.app.model.core.MyProjectDomainIF;

public class MyFilterTemplate
    extends MyFilterTemplateBase
    implements MyProjectDomainIF
{
    //##################################################
    //# constructor
    //##################################################

    public MyFilterTemplate()
    {
        super();
    }

    //##################################################
    //# domain
    //##################################################

    @Override
    public MyTenant getTenant()
    {
        return getProject().getTenant();
    }

    //##################################################
    //# items
    //##################################################

    public void resetItems()
    {
        for ( MyFilterTemplateItem e : getItems() )
            e.resetValue();
    }

    public KmCollection<MyFilterTemplateItem> getUsedItems()
    {
        return getItems().select(e -> e.isUsed());
    }

    public KmCollection<String> getUsedAttributeCodes()
    {
        return getUsedItems().collect(e -> e.getAttributeCode());
    }

    public MyFilterTemplateItem lazyGetItem(String attrCode)
    {
        MyFilterTemplateItem item = getItems().selectAny(e -> e.hasAttributeCode(attrCode));

        if ( item == null )
        {
            item = addItem();
            item.setAttributeCode(attrCode);
            item.setUsed(false);
            item.validateAndCheck();
        }

        return item;
    }

    public MyFilterTemplateItem getItem(String attrCode)
    {
        return getItems().selectAny(e -> e.hasAttributeCode(attrCode));
    }

    //##################################################
    //# json
    //##################################################

    private static final String JSON_UID       = "uid";
    private static final String JSON_NAME      = "name";
    private static final String JSON_PROJECT   = "project";
    private static final String JSON_TYPE      = "type";
    private static final String JSON_CONTEXT   = "context";
    private static final String JSON_MODIFIED  = "modified";
    private static final String JSON_PREFERRED = "preferred";
    private static final String JSON_ITEMS     = "items";

    //##################################################
    //# json
    //##################################################

    public void applyFrom(MyFilterTemplate detached, boolean applyUid)
    {
        fromJson(detached.toJson(), applyUid);
    }

    public String toJson()
    {
        KmJsonMap json;
        json = new KmJsonMap();
        json.setString(JSON_UID, getUid());
        json.setString(JSON_NAME, getName());
        json.setString(JSON_PROJECT, getProject().getUid());
        json.setString(JSON_TYPE, getTypeCode());
        json.setString(JSON_CONTEXT, getContextTypeCode());
        json.setBoolean(JSON_MODIFIED, isModified());
        json.setBoolean(JSON_PREFERRED, isPreferred());

        KmJsonMap map = json.setMap(JSON_ITEMS);
        for ( MyFilterTemplateItem item : getUsedItems() )
            map.setString(item.getAttributeCode(), item.getValue());

        return json.toString();
    }

    public void fromJson(String s, boolean applyUid)
    {
        KmJsonMap json = KmJsonReader.parseJsonMap(s);

        String projectUid = json.getString(JSON_PROJECT);
        MyProject project = getAccess().findProjectUid(projectUid);

        if ( applyUid )
            setUid(json.getString(JSON_UID));

        setName(json.getString(JSON_NAME));
        setProject(project);
        setTypeCode(json.getString(JSON_TYPE));
        setContextTypeCode(json.getString(JSON_CONTEXT));
        setModified(json.getBoolean(JSON_MODIFIED));
        setPreferred(json.getBoolean(JSON_PREFERRED));

        resetItems();

        KmJsonMap itemMap = json.getMap(JSON_ITEMS);
        KmList<String> codes = itemMap.getKeys();
        for ( String attrCode : codes )
        {
            MyFilterTemplateItem item;
            item = getItem(attrCode);

            if ( item == null )
            {
                item = addItem();
                item.setAttributeCode(attrCode);
            }

            item.setUsed(true);
            item.setValue(itemMap.getString(attrCode));
        }
    }

    //##################################################
    //# debug
    //##################################################

    public void print()
    {
        print(false);
    }

    public void print(boolean showAll)
    {
        System.out.println(getDomainTitle());
        System.out.println("    context:  " + getContextTypeCode());
        System.out.println("    project:  " + getProjectName());
        System.out.println("    type:     " + getTypeCode());
        System.out.println("    template: " + getUid());

        KmCollection<MyFilterTemplateItem> items = showAll
            ? getItems()
            : getUsedItems();

        for ( MyFilterTemplateItem item : items )
            System.out.printf("        %10s => %s%n", item.getAttributeCode(), item.getValue());
    }

    //##################################################
    //# find
    //##################################################

    public MyFilterTemplate findOriginalTemplate()
    {
        if ( !isModified() )
            return this;

        MyFilterTemplateCriteria c;
        c = getAccess().getFilterTemplateDao().createCriteria();
        c.whereProjectIs(getProject());
        c.whereContextTypeIs(getContextType());
        c.whereName().is(getName());
        c.whereModified().isFalse();
        c.whereDeleted().isFalse();
        return c.findUnique();
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getAuditLogTitle()
    {
        return getContextTypeName() + ", " + getName();
    }

    @Override
    public String getDomainTitle()
    {
        String prefix = isModified()
            ? "* "
            : "";

        MyFilterTemplateType type = getType();
        switch ( type )
        {
            case Predefined:
                return Kmu.format("%s<%s>", prefix, getName());

            case Shared:
                return Kmu.format("%s%s", prefix, getName());
        }
        throw Kmu.newEnumError(type);
    }

    @Override
    public String getDomainSubtitle()
    {
        String suffix = isModified()
            ? " (modified)"
            : "";

        MyFilterTemplateType type = getType();
        switch ( type )
        {
            case Predefined:
                return "predefined" + suffix;

            case Shared:
                return "shared" + suffix;
        }
        throw Kmu.newEnumError(type);
    }

}
