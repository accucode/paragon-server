package com.app.model;

import java.util.*;

import com.kodemore.collection.*;
import com.kodemore.exception.*;
import com.kodemore.time.*;
import com.kodemore.utility.*;

import com.app.model.base.*;
import com.app.model.core.*;
import com.app.utility.*;

/**
 * Miscellaneous tools for use with the model.
 */
public class MyShipMethodTools
    extends MyShipMethodToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyShipMethodTools instance = new MyShipMethodTools();

    //##################################################
    //# constructor
    //##################################################

    private MyShipMethodTools()
    {
        // singleton
    }

}
