//**********************************************************
//**
//** A (simple) custom implementation of timeAgo.
//** This can be used to dynamically convert timestamps
//** to formats like "5 minutes ago".
//**
//** Depends on: jQuery.
//**
//** Date strings should be specified in ISO 8601 format.  E.g.:  
//**    2014-01-08T15:19Z
//**
//**********************************************************

var KmTimeAgo = {};

//**********************************************************
//** variables
//**********************************************************

/**
 * The default settings to use when starting a monitor.
 * Clients may change the defaults directly, or may override the
 * defaults when the timeAgo thread is started.  Note that changes
 * to default values will not affect any monitors that are already
 * running.
 */
KmTimeAgo.settings =
{
    /**
     * The css/jquery selector used to identify the dom elements 
     * to be updated.  Staring multiple monitors with different 
     * selectors allows the client to update different elements
     * at different frequencies.
     * 
     * You should use a different selector for each thread started.
     * The selector is used to keep track of the intervalId in case
     * the user later wants to stop the thread.
     */
    selector: "time.timeago",
    
    /**
     * The frequency at which the dom is updated.
     * Defaults to once per minute.
     */
    frequencyMs: 60000,

    /**
     * The id returned by window.setInterval.  This is included for
     * documentation only; clients should not set or modify this directly.
     */
    intervalId: null
}

/**
 * The the list of monitors that are actively running on an interval.
 * Each time a monitor is started, it is added to this list.  This allows
 * clients to subsequently top a monitor. 
 */
KmTimeAgo.monitors = [];


//**********************************************************
//** timer :: start
//**********************************************************

/**
 * Start a monitor for the specified selector and frequencyMs.
 * Both parameters are optional.  
 */
KmTimeAgo.start = function(sel, ms)
{
    var overrides = {};
    
    if ( sel !== undefined )
        overrides.selector = sel;
        
    if ( ms !== undefined )
        overrides.frequencyMs = ms;
        
    KmTimeAgo.startWith(overrides);
}

/**
 * Start a monitor using the specified (optional) overrides.
 */
KmTimeAgo.startWith = function(overrides)
{
    var m = Kmu.merge(KmTimeAgo.settings, overrides);

    var fn = function()
    {
        KmTimeAgo.updateWith(m);
    };
    var ms = m.frequencyMs;
    var id = window.setInterval(fn, ms);

    m.intervalId = id;
    
    KmTimeAgo.monitors.push(m);
    KmTimeAgo.updateWith(m);
}

//**********************************************************
//** timer :: stop
//**********************************************************

/**
 * Stop any monitors that were started for the specified selector.
 */
KmTimeAgo.stop = function(sel)
{
    while ( true )
    {
        var i = KmTimeAgo.indexOfActiveSelector(sel);
        if ( i < 0 ) 
            break;

        var arr = KmTimeAgo.activeSettings;
        var e = arr[i];
        var id = e.intervalId;
        
        arr.splice(i,1);
        window.clearInterval(id);
    }
}

/**
 * Stop all of the registered intervals. 
 */ 
KmTimeAgo.stopAll = function()
{
    var arr = KmTimeAgo.activeSettings;
    while ( arr.length > 0 )
        stop(arr[0].selector);
}

//**********************************************************
//** update
//**********************************************************

/**
 * Update all of the monitors immediately.
 */
KmTimeAgo.updateAll = function()
{
    var arr = KmTimeAgo.monitors;
    int n = arr.length;
    
    for ( var i=0; i<n; i++ )
        updateWith(arr[i]);
}
        
/**
 * Update the elements for a particular monitor.  
 */
KmTimeAgo.updateWith = function(m)
{
    $(m.selector).each(function(i,e)
    {
        e = $(e);
        var iso = e.attr("datetime");
        var date = new Date(iso);
        var words = KmTimeAgo.format(date);
        e.text(words);
    });
}


//**********************************************************
//** format
//**********************************************************

/**
 * Create the fuzzy text for target date relative to the current date. 
 */
KmTimeAgo.format = function(date)
{
    var now = new Date();
    var ms = date.getTime() - now.getTime();
    
    if ( isNaN(ms) )
        return "NaN";

    var units = KmTimeAgo.formatUnits(ms);
    var suffix = KmTimeAgo.formatSuffix(ms);
    
    return units + suffix;
}

/**
 * Format the "5 hours" portion of the message.
 */
KmTimeAgo.formatUnits = function(ms)
{
    ms = Math.abs(ms);
    
    var s  = Math.floor(ms / 1000);
    var m  = Math.floor(s  / 60);
    var h  = Math.floor(m  / 60);
    var dd = Math.floor(h  / 24);
    var ww = Math.floor(dd / 7);
    var mm = Math.floor(dd / 30);
    var yy = Math.floor(dd / 365);
    
    if ( s < 2 )    return "1 second";
    if ( s < 60 )   return m + " seconds";
        
    if ( m < 2 )    return "1 minute";
    if ( m < 60 )   return m + " minutes";
        
    if ( h < 2 )    return "1 hour";
    if ( h < 24 )   return h + " hours";
        
    if ( dd < 2 )   return "1 day";
    if ( dd < 7 )   return dd + " days";
        
    if ( ww < 2 )   return "1 week";
    if ( ww < 4 )   return ww + " weeks";
        
    if ( mm < 2 )   return "1 month";
    if ( mm < 12 )  return mm + " months";
    
    if ( yy < 2 )   return "1 year";
    return yy + " years";
}

/**
 * Determine the appropriate suffix.
 */
KmTimeAgo.formatSuffix = function(ms)
{
    if ( ms > 0 )
        return " from now";
    
    return " ago";
}
    
//**********************************************************
//** support
//**********************************************************

/**
 * Find the index of the first active selector, or -1 if not found.
 */
KmTimeAgo.indexOfActiveSelector = function(sel)
{
    var arr = KmTimeAgo.activeSettings
    var n = arr.length;
    
    for ( var i=0; i<n; i++)
        if ( arr[i].selector == sel )
            return i;
    
    return -1;
} 



