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

public class MyMetaPatch
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaPatch instance = new MyMetaPatch();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaPatch()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "patch";
    }

    public MyPatchValidator getValidator()
    {
        return MyPatchValidator.instance;
    }

    public String getComment()
    {
        return "null";
    }

    @Override
    public String getHelp()
    {
        return "The list of all database patches. These are used to coordinate database migrations. During database migration checks, the list of patches on the file system are compared to the list of patches known in this table.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public final MyMetaPatch_AuditLogTitle AuditLogTitle = new MyMetaPatch_AuditLogTitle();
    public final MyMetaPatch_DomainSubtitle DomainSubtitle = new MyMetaPatch_DomainSubtitle();
    public final MyMetaPatch_DomainTitle DomainTitle = new MyMetaPatch_DomainTitle();
    public final MyMetaPatch_InstalledUtcTs InstalledUtcTs = new MyMetaPatch_InstalledUtcTs();
    public final MyMetaPatch_Name Name = new MyMetaPatch_Name();
    public final MyMetaPatch_Source Source = new MyMetaPatch_Source();
    public final MyMetaPatch_InstalledLocalTs InstalledLocalTs = new MyMetaPatch_InstalledLocalTs();
    public final MyMetaPatch_InstalledLocalTsMessage InstalledLocalTsMessage = new MyMetaPatch_InstalledLocalTsMessage();
    public final MyMetaPatch_InstalledLocalDate InstalledLocalDate = new MyMetaPatch_InstalledLocalDate();
    public final MyMetaPatch_InstalledLocalTime InstalledLocalTime = new MyMetaPatch_InstalledLocalTime();

    //##################################################
    //# associations
    //##################################################


    //##################################################
    //# AuditLogTitle
    //##################################################

    public class MyMetaPatch_AuditLogTitle
        extends KmMetaStringProperty<MyPatch>
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
        public String getValueFor(MyPatch model)
        {
            return model.getAuditLogTitle();
        }

        @Override
        public boolean hasValueFor(MyPatch model, String value)
        {
            return model.hasAuditLogTitle(value);
        }
    }

    //##################################################
    //# DomainSubtitle
    //##################################################

    public class MyMetaPatch_DomainSubtitle
        extends KmMetaStringProperty<MyPatch>
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
        public String getValueFor(MyPatch model)
        {
            return model.getDomainSubtitle();
        }

        @Override
        public boolean hasValueFor(MyPatch model, String value)
        {
            return model.hasDomainSubtitle(value);
        }
    }

    //##################################################
    //# DomainTitle
    //##################################################

    public class MyMetaPatch_DomainTitle
        extends KmMetaStringProperty<MyPatch>
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
        public String getValueFor(MyPatch model)
        {
            return model.getDomainTitle();
        }

        @Override
        public boolean hasValueFor(MyPatch model, String value)
        {
            return model.hasDomainTitle(value);
        }
    }

    //##################################################
    //# InstalledUtcTs
    //##################################################

    public class MyMetaPatch_InstalledUtcTs
        extends KmMetaTimestampProperty<MyPatch>
        implements KmMetaDaoPropertyIF<MyPatch,KmTimestamp>
    {
        @Override
        public String getName()
        {
            return "installedUtcTs";
        }

        @Override
        public String getLabel()
        {
            return "Installed Utc Ts";
        }

        @Override
        public String getHelp()
        {
            return "The date and time when the patch was installed in this database.";
        }

        @Override
        public int getColumnWidth()
        {
            return 16;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmTimestampValidator getValidator()
        {
            return MyPatchValidator.instance.getInstalledUtcTsValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "installedUtcTs";
        }

        @Override
        public MyPatchDao getDao()
        {
            return getAccess().getPatchDao();
        }

        @Override
        public KmTimestamp getValueFor(MyPatch model)
        {
            return model.getInstalledUtcTs();
        }

        @Override
        public void setValueFor(MyPatch model, KmTimestamp value)
        {
            model.setInstalledUtcTs(value);
        }

        @Override
        public boolean hasValueFor(MyPatch model, KmTimestamp value)
        {
            return model.hasInstalledUtcTs(value);
        }
    }

    //##################################################
    //# Name
    //##################################################

    public class MyMetaPatch_Name
        extends KmMetaStringProperty<MyPatch>
        implements KmMetaDaoPropertyIF<MyPatch,String>
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
            return "The unique key. This is typically a short date-ish value such as: 20140131-1.txt. The patches are applied in the sequence implied by their collating sequence.";
        }

        @Override
        public int getColumnWidth()
        {
            return 15;
        }

        @Override
        public boolean isEditable()
        {
            return true;
        }

        @Override
        public KmStringValidator getValidator()
        {
            return MyPatchValidator.instance.getNameValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "name";
        }

        @Override
        public MyPatchDao getDao()
        {
            return getAccess().getPatchDao();
        }

        public KmDaoStringKeyCursor<MyPatch> createCursor()
        {
            KmDaoStringKeyCursor<MyPatch> e;
            e = new KmDaoStringKeyCursor<>();
            e.setProperty(this);
            return e;
        }

        @Override
        public String getValueFor(MyPatch model)
        {
            return model.getName();
        }

        @Override
        public void setValueFor(MyPatch model, String value)
        {
            model.setName(value);
        }

        @Override
        public boolean hasValueFor(MyPatch model, String value)
        {
            return model.hasName(value);
        }
    }

    //##################################################
    //# Source
    //##################################################

    public class MyMetaPatch_Source
        extends KmMetaStringProperty<MyPatch>
        implements KmMetaDaoPropertyIF<MyPatch,String>
    {
        @Override
        public String getName()
        {
            return "source";
        }

        @Override
        public String getLabel()
        {
            return "Source";
        }

        @Override
        public String getHelp()
        {
            return "The full raw script.  This contains both the text originally used to upgrade, as well as the text used to subsequently downgrade.  Each script has a maximum length of 50,000 characters.";
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
            return MyPatchValidator.instance.getSourceValidator();
        }

        @Override
        public String getDaoPropertyName()
        {
            return "source";
        }

        @Override
        public MyPatchDao getDao()
        {
            return getAccess().getPatchDao();
        }

        @Override
        public String getValueFor(MyPatch model)
        {
            return model.getSource();
        }

        @Override
        public void setValueFor(MyPatch model, String value)
        {
            model.setSource(value);
        }

        @Override
        public boolean hasValueFor(MyPatch model, String value)
        {
            return model.hasSource(value);
        }
    }

    //##################################################
    //# InstalledLocalTs
    //##################################################

    public class MyMetaPatch_InstalledLocalTs
        extends KmMetaTimestampProperty<MyPatch>
    {
        @Override
        public String getName()
        {
            return "installedLocalTs";
        }

        @Override
        public String getLabel()
        {
            return "Installed";
        }

        @Override
        public String getHelp()
        {
            return "The installed timestamp converted to the user's local timezone.";
        }

        @Override
        public int getColumnWidth()
        {
            return 16;
        }

        @Override
        public boolean isEditable()
        {
            return false;
        }

        @Override
        public KmTimestamp getValueFor(MyPatch model)
        {
            return model.getInstalledLocalTs();
        }

        @Override
        public boolean hasValueFor(MyPatch model, KmTimestamp value)
        {
            return model.hasInstalledLocalTs(value);
        }
    }

    //##################################################
    //# InstalledLocalTsMessage
    //##################################################

    public class MyMetaPatch_InstalledLocalTsMessage
        extends KmMetaStringProperty<MyPatch>
    {
        @Override
        public String getName()
        {
            return "installedLocalTsMessage";
        }

        @Override
        public String getLabel()
        {
            return "Installed";
        }

        @Override
        public String getHelp()
        {
            return "The installed timestamp converted to the user's local timezone, and formatted as a string that includes the timezone code.";
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
        public String getValueFor(MyPatch model)
        {
            return model.getInstalledLocalTsMessage();
        }

        @Override
        public boolean hasValueFor(MyPatch model, String value)
        {
            return model.hasInstalledLocalTsMessage(value);
        }
    }

    //##################################################
    //# InstalledLocalDate
    //##################################################

    public class MyMetaPatch_InstalledLocalDate
        extends KmMetaDateProperty<MyPatch>
    {
        @Override
        public String getName()
        {
            return "installedLocalDate";
        }

        @Override
        public String getLabel()
        {
            return "Installed";
        }

        @Override
        public String getHelp()
        {
            return "The installed date based on the user's local timezone.";
        }

        @Override
        public int getColumnWidth()
        {
            return 10;
        }

        @Override
        public boolean isEditable()
        {
            return false;
        }

        @Override
        public KmDate getValueFor(MyPatch model)
        {
            return model.getInstalledLocalDate();
        }

        @Override
        public boolean hasValueFor(MyPatch model, KmDate value)
        {
            return model.hasInstalledLocalDate(value);
        }
    }

    //##################################################
    //# InstalledLocalTime
    //##################################################

    public class MyMetaPatch_InstalledLocalTime
        extends KmMetaTimeProperty<MyPatch>
    {
        @Override
        public String getName()
        {
            return "installedLocalTime";
        }

        @Override
        public String getLabel()
        {
            return "Installed";
        }

        @Override
        public String getHelp()
        {
            return "The installed time of day based on the user's local timezone.";
        }

        @Override
        public int getColumnWidth()
        {
            return 10;
        }

        @Override
        public boolean isEditable()
        {
            return false;
        }

        @Override
        public KmTime getValueFor(MyPatch model)
        {
            return model.getInstalledLocalTime();
        }

        @Override
        public boolean hasValueFor(MyPatch model, KmTime value)
        {
            return model.hasInstalledLocalTime(value);
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
