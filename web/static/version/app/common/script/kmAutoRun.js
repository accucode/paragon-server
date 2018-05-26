//**********************************************************
//*
//* Automatically run the onclick for identified buttons.
//*
//* CSS Classes
//*     autoRun
//*         Finding dom elements based on their data attributes
//*         seems to be unreliable at this time. So instead we
//*         use a css class to identify the pertinent butons.
//*
//* Data attributes
//*     data-autoRunSeconds
//*        The frequence at which the onclick action should be run.
//*
//*     data-autoRunAt
//*        This determines the next time at which the
//*        onclick will be run. This is typically undefined
//*        and/or absent in the initial dom. The first time
//*        the button is checked, this will be set based on
//*        the current time and the autoRunSeconds.
//*
//* Depends on: jQuery, moment
//*
//* To add an autoRun button to the page, use:
//*    <button data-autoRunSeconds="60">...</button>
//*
//**********************************************************

var KmAutoRun = {};

/**
 * This determines how often the background timer checks
 * for autoRun buttons.
 */
KmAutoRun.UPDATE_FREQUENCY_SECONDS = 10;

//**********************************************************
//** init
//**********************************************************

/**
 * This must be called to start the background timer that
 * automatically updates all page elements.
 */
KmAutoRun.init = function()
{
    var fn;
    fn = KmAutoRun.checkAll;
    fn();

    var ms = 1000 * KmAutoRun.UPDATE_FREQUENCY_SECONDS;
    window.setInterval(fn, ms);
}

//**********************************************************
//** update
//**********************************************************

/**
 * Check all buttons.
 * Run and update the pertinent buttons.
 */
KmAutoRun.checkAll = function()
{
    KmAutoRun.checkSelector("button.autoRun");
}

/**
 * Check the elements for a particular selector.
 */
KmAutoRun.checkSelector = function(sel)
{
    $(sel).each(function(i,e)
    {
        KmAutoRun.checkElement($(e));
    });
}

/**
 * Check a single jquery element.
 */
KmAutoRun.checkElement = function(e)
{
    var secs = e.data('autorunseconds');
    if ( ! secs )
        return;

    var now = KmAutoRun.now();
    var next = now + secs;
    var at = e.data('autorunat');

    if ( ! at )
    {
        e.data('autorunat', next);
        return;
    }

    if ( now < at )
        return;

    e.data('autorunat', next);
    e.click();
}

/**
 * Get the number of seconds since the epoch.
 */
KmAutoRun.now = function()
{
    return Math.floor((new Date()).getTime() / 1000);
}