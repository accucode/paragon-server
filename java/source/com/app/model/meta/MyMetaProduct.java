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
import com.kodemore.exception.*;
import com.kodemore.meta.*;
import com.kodemore.servlet.encoder.*;
import com.kodemore.servlet.field.*;
import com.kodemore.time.*;
import com.kodemore.utility.*;
import com.kodemore.validator.*;

import com.app.model.*;
import com.app.model.core.*;
import com.app.utility.*;

public class MyMetaProduct
    extends KmMetaModel
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyMetaProduct instance = new MyMetaProduct();

    //##################################################
    //# constructor
    //##################################################

    private MyMetaProduct()
    {
        // singleton
    }

    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "product";
    }

    public static MyProductValidator getValidator()
    {
        return MyProductValidator.instance;
    }
    
    public static String getComment()
    {
        return "null";
    }

    public static String getHelp()
    {
        return "A specific version of a product.\n Products are primarily used to define the things that we sell, but are also used to coordinate inventory and technician stock (checkouts). Products are managed within a project, and even if multiple projects use products with the same name, the products are tracked and managed separately.\n Products are versioned and go through an explicit publishing cycle.  Once a draft version has been published, no further changes to that version are allowed.  This allows the rest of the system to reference a particular version of the product and ensures that we can easily report on what we sold to a particular customer on a particular order.\n Most of the details are marked as NOT required.  This is because the attributes are not initially required when editing a draft.  However, many of the attributes ARE required in order to finalize and publish a draft for use in the standard catalog.  The rules for publishing a draft are defined in the model.";
    }

    //##################################################
    //# fields and delegates
    //##################################################

    public static final MyMetaProduct_Uid Uid = new MyMetaProduct_Uid();
    public static final MyMetaProduct_StatusCode StatusCode = new MyMetaProduct_StatusCode();
    public static final MyMetaProduct_Name Name = new MyMetaProduct_Name();
    public static final MyMetaProduct_Description Description = new MyMetaProduct_Description();
    public static final MyMetaProduct_ListPrice ListPrice = new MyMetaProduct_ListPrice();
    public static final MyMetaProduct_Discountable Discountable = new MyMetaProduct_Discountable();
    public static final MyMetaProduct_Taxable Taxable = new MyMetaProduct_Taxable();
    public static final MyMetaProduct_Cost Cost = new MyMetaProduct_Cost();
    public static final MyMetaProduct_RequiresShip RequiresShip = new MyMetaProduct_RequiresShip();
    public static final MyMetaProduct_ShipInstruction ShipInstruction = new MyMetaProduct_ShipInstruction();
    public static final MyMetaProduct_PickInstruction PickInstruction = new MyMetaProduct_PickInstruction();
    public static final MyMetaProduct_NetworkPortsProduced NetworkPortsProduced = new MyMetaProduct_NetworkPortsProduced();
    public static final MyMetaProduct_NetworkPortsConsumed NetworkPortsConsumed = new MyMetaProduct_NetworkPortsConsumed();
    public static final MyMetaProduct_PoePortsProduced PoePortsProduced = new MyMetaProduct_PoePortsProduced();
    public static final MyMetaProduct_PoePortsConsumed PoePortsConsumed = new MyMetaProduct_PoePortsConsumed();
    public static final MyMetaProduct_VendorPartNumber VendorPartNumber = new MyMetaProduct_VendorPartNumber();
    public static final MyMetaProduct_LockVersion LockVersion = new MyMetaProduct_LockVersion();
    public static final MyMetaProduct_StatusName StatusName = new MyMetaProduct_StatusName();
    public static final MyMetaProduct_PartNumber PartNumber = new MyMetaProduct_PartNumber();
    public static final MyMetaProduct_CategoryName CategoryName = new MyMetaProduct_CategoryName();

    //##################################################
    //# associations
    //##################################################

    public static final MyMetaProduct_Project Project = new MyMetaProduct_Project();
    public static final MyMetaProduct_Master Master = new MyMetaProduct_Master();
    public static final MyMetaProduct_Category Category = new MyMetaProduct_Category();
    public static final MyMetaProduct_PowerType PowerType = new MyMetaProduct_PowerType();
    public static final MyMetaProduct_Vendor Vendor = new MyMetaProduct_Vendor();
}
