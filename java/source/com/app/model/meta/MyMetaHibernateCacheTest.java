//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import java.util.*;

import com.kodemore.collection.*;
import com.kodemore.dao.*;
import com.kodemore.exception.*;
import com.kodemore.meta.*;
import com.kodemore.servlet.encoder.*;
import com.kodemore.servlet.field.*;
import com.kodemore.time.*;
import com.kodemore.types.*;
import com.kodemore.utility.*;
import com.kodemore.validator.*;

import com.app.dao.*;
import com.app.dao.base.*;
import com.app.finder.*;
import com.app.model.*;
import com.app.model.base.*;
import com.app.model.core.*;
import com.app.utility.*;

public class MyMetaHibernateCacheTest
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaHibernateCacheTest instance = new MyMetaHibernateCacheTest();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaHibernateCacheTest()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "hibernateCacheTest";
    }

    public MyHibernateCacheTestValidator getValidator()
    {
        return MyHibernateCacheTestValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "I am used to test the hibernate second level cache.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaHibernateCacheTest_AuditLogTitle AuditLogTitle = new MyMetaHibernateCacheTest_AuditLogTitle();
    public final MyMetaHibernateCacheTest_Data Data = new MyMetaHibernateCacheTest_Data();
    public final MyMetaHibernateCacheTest_DomainSubtitle DomainSubtitle = new MyMetaHibernateCacheTest_DomainSubtitle();
    public final MyMetaHibernateCacheTest_DomainTitle DomainTitle = new MyMetaHibernateCacheTest_DomainTitle();
    public final MyMetaHibernateCacheTest_Uid Uid = new MyMetaHibernateCacheTest_Uid();
    public final MyMetaHibernateCacheTest_LockVersion LockVersion = new MyMetaHibernateCacheTest_LockVersion();

    //##################################################
    //# associations
    //##################################################


    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaHibernateCacheTest_AuditLogTitle
        extends KmMetaStringProperty<MyHibernateCacheTest>
    {
        @Override
        public String getName()
        {
            return "auditLogTitle";
        }

        @Override
        public String getLabel()
        {
            return "Audit Log Title";
        }

        @Override
        public String getHelp()
        {
            return "This is used a the title in auditLogs. This should NEVER be null.";
        }

        @Override
        public int getColumnWidth()
        {
            return 20;
        }

        @Override
        public boolean isEditable()
        {
            return false;
        }

        @Override
        public String getValueFor(MyHibernateCacheTest model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyHibernateCacheTest model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# Data
    //##################################################

    public class MyMetaHibernateCacheTest_Data
        extends KmMetaStringProperty<MyHibernateCacheTest>
        implements KmMetaDaoPropertyIF<MyHibernateCacheTest,String>
    {
        @Override
        public String getName()
        {
            return "data";
        }

        @Override
        public String getLabel()
        {
            return "Data";
        }

        @Override
        public String getHelp()
        {
            return "Random data used for testing.";
        }

        @Override
        public int getColumnWidth()
        {
            return 20;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MyHibernateCacheTestValidator.instance.getDataValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "data";
        }

        @Override
        public MyHibernateCacheTestDao getDao()
        {
            return getAccess().getHibernateCacheTestDao();
        }

        @Override
        public String getValueFor(MyHibernateCacheTest model)
        {
            return model.getData();
        }

        @Override
        public void setValueFor(MyHibernateCacheTest model, String value)
        {
            model.setData(value);
        }

        @Override
        public boolean hasValueFor(MyHibernateCacheTest model, String value)
        {
            return model.hasData(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaHibernateCacheTest_DomainSubtitle
        extends KmMetaStringProperty<MyHibernateCacheTest>
    {
        @Override
        public String getName()
        {
            return "domainSubtitle";
        }

        @Override
        public String getLabel()
        {
            return "Domain Subtitle";
        }

        @Override
        public String getHelp()
        {
            return "The subtitle commonly used for rows in a list. This MAY be null, if there is not subtitle.";
        }

        @Override
        public int getColumnWidth()
        {
            return 20;
        }

        @Override
        public boolean isEditable()
        {
            return false;
        }

        @Override
        public String getValueFor(MyHibernateCacheTest model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyHibernateCacheTest model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaHibernateCacheTest_DomainTitle
        extends KmMetaStringProperty<MyHibernateCacheTest>
    {
        @Override
        public String getName()
        {
            return "domainTitle";
        }

        @Override
        public String getLabel()
        {
            return "Domain Title";
        }

        @Override
        public String getHelp()
        {
            return "The title commonly used for rows in a list or dropdown field. This should NEVER be null.";
        }

        @Override
        public int getColumnWidth()
        {
            return 20;
        }

        @Override
        public boolean isEditable()
        {
            return false;
        }

        @Override
        public String getValueFor(MyHibernateCacheTest model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyHibernateCacheTest model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# Uid
    //##################################################

    public class MyMetaHibernateCacheTest_Uid
        extends KmMetaStringProperty<MyHibernateCacheTest>
        implements KmMetaDaoPropertyIF<MyHibernateCacheTest,String>
    {
        @Override
        public String getName()
        {
            return "uid";
        }

        @Override
        public String getLabel()
        {
            return "Uid";
        }

        @Override
        public String getHelp()
        {
            return "The global unique key.  This is a large hex-encoded number, and is usually not displayed to users.  This is currently NOT a standard format, but is instead a format that we use internally.";
        }

        @Override
        public int getColumnWidth()
        {
            return 20;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MyHibernateCacheTestValidator.instance.getUidValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "uid";
        }

        @Override
        public MyHibernateCacheTestDao getDao()
        {
            return getAccess().getHibernateCacheTestDao();
        }

        public KmDaoStringKeyCursor<MyHibernateCacheTest> createCursor()
        {
            KmDaoStringKeyCursor<MyHibernateCacheTest> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MyHibernateCacheTest model)
        {
            return model.getUid();
        }

        @Override
        public void setValueFor(MyHibernateCacheTest model, String value)
        {
            model.setUid(value);
        }

        @Override
        public boolean hasValueFor(MyHibernateCacheTest model, String value)
        {
            return model.hasUid(value);
        }
    }

    //##################################################
    //# LockVersion
    //##################################################

    public class MyMetaHibernateCacheTest_LockVersion
        extends KmMetaIntegerProperty<MyHibernateCacheTest>
        implements KmMetaDaoPropertyIF<MyHibernateCacheTest,Integer>
    {
        @Override
        public String getName()
        {
            return "lockVersion";
        }

        @Override
        public String getLabel()
        {
            return "Lock Version";
        }

        @Override
        public String getHelp()
        {
            return "This is used to coordinate optimistic locking in the database. This is usually not displayed.";
        }

        @Override
        public int getColumnWidth()
        {
            return 10;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmIntegerValidator getValidator()
        {
            return MyHibernateCacheTestValidator.instance.getLockVersionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lockVersion";
        }

        @Override
        public MyHibernateCacheTestDao getDao()
        {
            return getAccess().getHibernateCacheTestDao();
        }

        @Override
        public Integer getValueFor(MyHibernateCacheTest model)
        {
            return model.getLockVersion();
        }

        @Override
        public void setValueFor(MyHibernateCacheTest model, Integer value)
        {
            model.setLockVersion(value);
        }

        @Override
        public boolean hasValueFor(MyHibernateCacheTest model, Integer value)
        {
            return model.hasLockVersion(value);
        }
    }


    //##################################################
    //# support
    //##################################################

    protected MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

}
