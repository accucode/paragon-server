//**********************************************************
//**
//** A (simple) custom implementation of timeAgo, but for
//** dates instead of timestamps.  This can be used to dynamically
//** convert dates (or timestamps) to formats like:
//**	today, tomorrow, 3 days ago, etc...
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
//** To add a dateago element to the page, use:
//**	<time class="dateago" datetime="2014-01-08T15:19Z"></time>
//**
//** Date strings should be specified in ISO 8601 format.  E.g.:  
//**    2014-01-31
//** or
//**    2014-01-31T15:19Z
//**
//**********************************************************

var KmDateAgo = {};

KmDateAgo.init = function()
{
	var fn;
	fn = KmDateAgo.updateAll;
	fn();
	
	var ms = 1000 * 60;
	window.setInterval(fn, ms);
}

//**********************************************************
//** update
//**********************************************************

/**
 * Update all of the dateago elements;
 */
KmDateAgo.updateAll = function()
{
	KmDateAgo.update("time.dateago");
}
        
/**
 * Update the elements for a particular selector.
 * Clients will typically call this directly when new
 * elements are added to the DOM to avoid waiting for
 * the next interval.  
 */
KmDateAgo.update = function(sel)
{
    $(sel).each(function(i,e)
    {
        e = $(e);
        var iso = e.attr("datetime");
        var date = KmDateAgo.parse(iso);
        var words = KmDateAgo.format(date);
        e.text(words);
    });
}

/**
 * Parse a iso formatted string and return the date.
 * The date is returned as midnight in the local timezone.
 */
KmDateAgo.parse = function(iso)
{
	var e
	e = new Date(iso);
	e.setDate(e.getUTCDate());
	e.setHours(0);
	e.setMinutes(0);
	e.setSeconds(0);
	e.setMilliseconds(0);
	return e;
}

/**
 * Return the current date, at midnight, in the local timezone.
 */
KmDateAgo.today = function()
{
	var e;
	e = new Date();
	e.setHours(0);
	e.setMinutes(0);
	e.setSeconds(0);
	e.setMilliseconds(0);
	return e;
}

//**********************************************************
//** format
//**********************************************************

/**
 * Create the fuzzy text for target date relative to the current date. 
 */
KmDateAgo.format = function(date)
{
    var today = KmDateAgo.today();
    var days = (date - today) / 24 / 60 / 60 / 1000;
    
    if ( isNaN(days) )
        return "NaN";

	if ( days ==  0 )	return "today";
	if ( days ==  1 )	return "tomorrow";
	if ( days == -1 )	return "yesterday";
	
    var units = KmDateAgo.formatUnits(days);
    var suffix = KmDateAgo.formatSuffix(days);
    
    return units + suffix;
}

/**
 * Format the "5 days" portion of the message.
 */
KmDateAgo.formatUnits = function(days)
{
    var d = Math.abs(days);
    var w = Math.floor(d / 7);
    var m = Math.floor(d / 30);
    var y = Math.floor(d / 365);
    
    if ( d < 2 )	return "1 day";
    if ( d < 7 )    return d + " days";
        
    if ( w < 2 )    return "1 week";
    if ( w < 4 )    return w + " weeks";
        
    if ( m < 2 )    return "1 month";
    if ( m < 12 )   return m + " months";
    
    if ( y < 2 ) 	return "1 year";
    return y + " years";
}

/**
 * Determine the appropriate suffix.
 */
KmDateAgo.formatSuffix = function(days)
{
    if ( days > 0 )
        return " from now";
    
    return " ago";
}
