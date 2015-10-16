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
public class MyEndUserSiteTools
    extends MyEndUserSiteToolsBase
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyEndUserSiteTools instance = new MyEndUserSiteTools();

    //##################################################
    //# constructor
    //##################################################

    private MyEndUserSiteTools()
    {
        // singleton
    }

}
