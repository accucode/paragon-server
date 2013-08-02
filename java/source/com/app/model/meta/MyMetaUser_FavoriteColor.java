//###############################################################
//###############################################################
//##
//##  AUTO GENERATED - DO NOT EDIT
//##
//###############################################################
//###############################################################

package com.app.model.meta;

import java.util.*;

import com.kodemore.adaptor.*;
import com.kodemore.collection.*;
import com.kodemore.comparator.*;
import com.kodemore.exception.*;
import com.kodemore.match.*;
import com.kodemore.meta.*;
import com.kodemore.servlet.encoder.*;
import com.kodemore.servlet.field.*;
import com.kodemore.time.*;
import com.kodemore.types.*;
import com.kodemore.utility.*;
import com.kodemore.validator.*;

import com.app.dao.*;
import com.app.dao.base.*;
import com.app.model.*;
import com.app.model.core.*;
import com.app.utility.*;

public class MyMetaUser_FavoriteColor
    extends KmMetaHtmlColorProperty<MyUser>
    implements KmMetaDaoPropertyIF<MyUser,KmHtmlColor>
{
    //##################################################
    //# accessing
    //##################################################

    @Override
    public String getName()
    {
        return "favoriteColor";
    }

    @Override
    public String getLabel()
    {
        return "Favorite Color";
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
    public KmHtmlColorValidator getValidator()
    {
        return MyUserValidator.instance.getFavoriteColorValidator();
    }

    //##################################################
    //# dao
    //##################################################

    @Override
    public String getDaoPropertyName()
    {
        return "favoriteColor";
    }

    @Override
    public MyUserDao getDao()
    {
        return getAccess().getUserDao();
    }

    private MyDaoRegistry getAccess()
    {
        return MyGlobals.getAccess();
    }
    
    //##################################################
    //# value
    //##################################################

    @Override
    public KmHtmlColor getValueFor(MyUser model)
    {
        return model.getFavoriteColor();
    }
    
    @Override
    public void setValueFor(MyUser model, KmHtmlColor value)
    {
        model.setFavoriteColor(value);
    }
    
    @Override
    public boolean hasValueFor(MyUser model, KmHtmlColor value)
    {
        return model.hasFavoriteColor(value);
    }
    
    @Override
    public int compareValues(MyUser o1, MyUser o2, boolean nullsOnTop)
    {
        return KmCompareUtility.compare(getValueFor(o1), getValueFor(o2), nullsOnTop);    
    }
    
}
