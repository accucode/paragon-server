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

public class MyMetaOptimisticLock
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaOptimisticLock instance = new MyMetaOptimisticLock();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaOptimisticLock()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "optimisticLock";
    }

    public MyOptimisticLockValidator getValidator()
    {
        return MyOptimisticLockValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "This table is used to coordinate optimistic locks in rare circumstances where the pertinent modifications would otherwise not necessarily touch the same record.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaOptimisticLock_AuditLogTitle AuditLogTitle = new MyMetaOptimisticLock_AuditLogTitle();
    public final MyMetaOptimisticLock_DomainSubtitle DomainSubtitle = new MyMetaOptimisticLock_DomainSubtitle();
    public final MyMetaOptimisticLock_DomainTitle DomainTitle = new MyMetaOptimisticLock_DomainTitle();
    public final MyMetaOptimisticLock_Name Name = new MyMetaOptimisticLock_Name();
    public final MyMetaOptimisticLock_LockVersion LockVersion = new MyMetaOptimisticLock_LockVersion();

    //##################################################
    //# associations
    //##################################################


    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaOptimisticLock_AuditLogTitle
        extends KmMetaStringProperty<MyOptimisticLock>
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
        public String getValueFor(MyOptimisticLock model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyOptimisticLock model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaOptimisticLock_DomainSubtitle
        extends KmMetaStringProperty<MyOptimisticLock>
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
        public String getValueFor(MyOptimisticLock model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyOptimisticLock model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaOptimisticLock_DomainTitle
        extends KmMetaStringProperty<MyOptimisticLock>
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
        public String getValueFor(MyOptimisticLock model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyOptimisticLock model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# Name
    //##################################################

    public class MyMetaOptimisticLock_Name
        extends KmMetaStringProperty<MyOptimisticLock>
        implements KmMetaDaoPropertyIF<MyOptimisticLock,String>
    {
        @Override
        public String getName()
        {
            return "name";
        }

        @Override
        public String getLabel()
        {
            return "Name";
        }

        @Override
        public String getHelp()
        {
            return "The unique 'natural' key.  This can be whatever the client wants. In theory, all clients could use a single record/key to coordinate ALL optimistic locks, but this is a poor design with limited scalability. Instead, clients should try to choose keys that minimize unnecessary collisions.";
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
            return MyOptimisticLockValidator.instance.getNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "name";
        }

        @Override
        public MyOptimisticLockDao getDao()
        {
            return getAccess().getOptimisticLockDao();
        }

        public KmDaoStringKeyCursor<MyOptimisticLock> createCursor()
        {
            KmDaoStringKeyCursor<MyOptimisticLock> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MyOptimisticLock model)
        {
            return model.getName();
        }

        @Override
        public void setValueFor(MyOptimisticLock model, String value)
        {
            model.setName(value);
        }

        @Override
        public boolean hasValueFor(MyOptimisticLock model, String value)
        {
            return model.hasName(value);
        }
    }

    //##################################################
    //# LockVersion
    //##################################################

    public class MyMetaOptimisticLock_LockVersion
        extends KmMetaIntegerProperty<MyOptimisticLock>
        implements KmMetaDaoPropertyIF<MyOptimisticLock,Integer>
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
            return MyOptimisticLockValidator.instance.getLockVersionValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "lockVersion";
        }

        @Override
        public MyOptimisticLockDao getDao()
        {
            return getAccess().getOptimisticLockDao();
        }

        @Override
        public Integer getValueFor(MyOptimisticLock model)
        {
            return model.getLockVersion();
        }

        @Override
        public void setValueFor(MyOptimisticLock model, Integer value)
        {
            model.setLockVersion(value);
        }

        @Override
        public boolean hasValueFor(MyOptimisticLock model, Integer value)
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
