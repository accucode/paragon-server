//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.dao.base;

import com.kodemore.collection.*;
import com.app.model.*;

public interface MyMasterProductDaoConstantsIF
{
    //##################################################
    //# fields
    //##################################################

    String UID = "uid";
    String PART_NUMBER = "partNumber";
    String ACTIVE = "active";
    String LOCK_VERSION = "lockVersion";

    //##################################################
    //# associations
    //##################################################

    String PROJECT = "project";
    String PROJECT_UID = "project.uid";

    String PUBLISHED_VERSION = "publishedVersion";
    String PUBLISHED_VERSION_UID = "publishedVersion.uid";

    String DRAFT_VERSION = "draftVersion";
    String DRAFT_VERSION_UID = "draftVersion.uid";

    //##################################################
    //# collections
    //##################################################

    String VERSIONS = "versions";
}
