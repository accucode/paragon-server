//**********************************************************
//**
//** A (simple) custom implementation of timeAgo.
//** This can be used to dynamically convert timestamps
//** to formats like "5 minutes ago".
//**
//** Depends on: jQuery.
//**
//** The intent is to create a simple, specialized solution;
//** scacrificing flexibility for simplicity.  Rather than
//** changing the configuration, we just change the code.
//**
//** The the paragon framework, we generally load the page
//** only once, then use ajax to make incremental updates
//** to the DOM.  Because of this, we simply start an 'interval'
//** upon init() and then let it run perpetually.
//**
//** To add a timeaog element to the page, use:
//**    <time class="timeago" datetime="2014-01-08T15:19Z"></time>
//**
//** Date strings should be specified in ISO 8601 format.  E.g.:
//**    2014-01-08T15:19Z
//**
//**********************************************************

var KmTimeAgo =
{
    UPDATE_FREQUENCY_SECONDS: 60
};

KmTimeAgo.init = function()
{
    var fn;
    fn = KmTimeAgo.updateAll;
    fn();

    var ms = 1000 * KmTimeAgo.UPDATE_FREQUENCY_SECONDS;
    window.setInterval(fn, ms);
}

//**********************************************************
//** update
//**********************************************************

/**
 * Update all of the timeago elements;
 */
KmTimeAgo.updateAll = function()
{
    KmTimeAgo.update("time.timeago");
}

/**
 * Update the elements for a particular selector.
 * Clients will typically call this directly when new
 * elements are added to the DOM to avoid waiting for
 * the next interval.
 */
KmTimeAgo.update = function(sel)
{
    $(sel).each(function(i,e)
    {
        e = $(e);
        var iso = e.data("timeago-datetime");
        var showsSuffix = e.data("timeago-suffix")

        var date = new Date(iso);
        var words = KmTimeAgo.format(date, showsSuffix);
        e.text(words);
    });
}

//**********************************************************
//** format
//**********************************************************

/**
 * Create the fuzzy text for target date relative to the current date.
 */
KmTimeAgo.format = function(date, showsSuffix)
{
    var now = new Date();
    var ms = date.getTime() - now.getTime();

    if ( isNaN(ms) )
        return "NaN";

    var units = KmTimeAgo.formatUnits(ms);
    var suffix = KmTimeAgo.formatSuffix(ms);

    if ( showsSuffix )
        return units + suffix;

    return units;
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
    if ( s < 60 )   return s + " seconds";

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
