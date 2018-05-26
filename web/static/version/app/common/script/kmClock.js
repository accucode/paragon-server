//**********************************************************
//**
//** A (simple) implementation for client side clock updates.
//**
//** This can be used to easily update an on-screen clock without
//** constantly messaging the remote server.
//**
//** Depends on: jQuery, moment
//**
//** To add a clock to the page, use:
//**    <div class="clock" data-timeZone="America/Denver"></div>
//**
//** Additional styling can be applied via class/style as needed.
//**********************************************************

var KmClock = {};

/**
 * This determines how often the background timer updates
 * all pages elements.
 */
KmClock.UPDATE_FREQUENCY_SECONDS = 10;

/**
 * The default format.
 */
KmClock.FORMAT = 'h:mm a';

//**********************************************************
//** init
//**********************************************************

/**
 * This must be called to start the background timer that
 * automatically updates all page elements.
 */
KmClock.init = function()
{
    var fn;
    fn = KmClock.updateAll;
    fn();

    var ms = 1000 * KmClock.UPDATE_FREQUENCY_SECONDS;
    window.setInterval(fn, ms);
}

//**********************************************************
//** update
//**********************************************************

/**
 * Update all of the clock elements;
 */
KmClock.updateAll = function()
{
    KmClock.update("div.clock");
}

/**
 * Update the elements for a particular selector.
 * Clients may call this directly when new elements are added
 * to the DOM to avoid waiting for the next interval.
 */
KmClock.update = function(sel)
{
    $(sel).each(function(i,e)
    {
        e = $(e);

        var zone = e.data("timezone");
        var f = KmClock.FORMAT;

        var time = !!zone
            ? moment.utc().tz(zone).format(f)
            : moment().format(f);


        e.text(time);
    });
}
