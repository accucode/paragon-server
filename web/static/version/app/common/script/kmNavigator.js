//**********************************************************
//**
//** Basic management of browser history via javascript.
//**
//**********************************************************

var KmNavigator = {};

/**
 * The default title to be displayed if none is provided.
 */
KmNavigator.defaultTitle = "";

/**
 * Called once to initialize the navigator.
 */
KmNavigator.init = function()
{
    KmNavigator.previousPrintDepth = undefined;
    KmNavigator.bind();
}

/**
 * Push a page on the history stack.
 * The options parameter supports the following attributes:
 *
 *      url
 *          The url to be pushed.
 *          This is the only required attribute, and is pushed 'as is'.
 *          In most cases, this is a relative path and may include nothing
 *          except the query string (e.g.: "?page=somePage").
 *
 *      title
 *          Although this may be used to update the browser's title, it is
 *          not well supported.  If no value is specified, we use the defaultTitle
 *          property defined above.
 *
 *      replace
 *          If true, do a replaceState instead of a pushState.
 *
 *      pageSession
 *          If set, apply this to the NEW page, after pushing it onto the stack.
 *
 *      handleStateChange
 *          By default, a push normally triggers the statechange event.
 *          If handleStateChange is false, the statechange event is temporarily ignored.
 *
 *      changeTracking
 *          If true (the default), check if there are any unsaved changes on the page.
 *          If unsaved changes are found, warn the user before initiating the navigation.
 *
 *      changeScope
 *          Optional string selector.
 *          If set, changes are only checked inside this container.
 *          If not set, check the entire page.
 */
KmNavigator.pushPage = function(options)
{
    var pushFn = function()
    {
        var url = options.url;

        var title = options.title;
        if ( !title )
            title = KmNavigator.defaultTitle;

        var state = History.getState();

        var push = true;
        if ( options.replace )
            push = false;

        var data;
        data = {};
        data.pageSession = KmNavigator.getPageSession();

        var inc = push && !state.url.endsWith(url);
        if ( inc )
            data.depth = KmNavigator.getNextDepth();
        else
            data.depth = state.data.depth;

        if ( options.pageSession )
            data.pageSession = options.pageSession;

        var handle = options.handleStateChange;
        if ( handle === undefined )
            handle = true;

        KmNavigator.unbind();

        if ( push )
        {
            // console.log('push title(' + title + '), url(' + url + ')')
            History.pushState(data, title, url);
        }
        else
        {
            // console.log('repl title(' + title + '), url(' + url + ')')
            History.replaceState(data, title, url);
        }

        KmNavigator.bind();

        if ( handle )
            KmNavigator.handleStateChange();
    };

    Kmu.warnIfDirty(
    {
        fn: pushFn,
        changeTracking: options.changeTracking,
        changeScope: options.changeScope
    });
}

KmNavigator.pushUrl = function(url)
{
    KmNavigator.pushPage({url: url});
}

KmNavigator.printCurrentPage = function()
{
    Kmu.ajax(
    {
        action:         "_printWindowLocation",
        direction:      KmNavigator.getDirection(),
        changeTracking: false
    });

    KmNavigator.previousPrintDepth = KmNavigator.getDepth();
}

KmNavigator.getDirection = function()
{
    var previous = KmNavigator.previousPrintDepth;
    var current  = KmNavigator.getDepth();

    if ( previous === undefined )
        return "unknown";

    if ( current === undefined )
        return "unknown";

    if ( current == previous )
        return "refresh";

    if ( current < previous )
        return "back";

    if ( current > previous )
        return "forward";

    return "unknown";
}

KmNavigator.getPageSession = function()
{
    var e = History.getState().data.pageSession;

    if ( e === undefined )
        e = '';

    return e;
}

/**
 * Update history state with the parameter specified.
 * This does NOT push (or pop) a page on the history stack.
 * This uses History.replaceState, and temporarily unbinds
 * the event listener to avoid an infinite loop.
 */
KmNavigator.updatePageSession = function(pageSession)
{
    var state = History.getState();

    var data;
    data = state.data;
    data.pageSession = pageSession;

    var title = state.title;
    var url = state.url;

    KmNavigator.unbind();
    History.replaceState(data, title, url);
    KmNavigator.bind();
}

/**
 * Update the title, but nothing else.
 * Does NOT push a new page onto the stack.
 * Does NOT trigger an update.
 */
KmNavigator.updateTitle = function(title)
{
    var state = History.getState();

    var data = state.data;
    var title = title;
    var url = state.url;

    KmNavigator.unbind();
    History.replaceState(data, title, url);
    KmNavigator.bind();
}

KmNavigator.back = function()
{
    History.back();
}

KmNavigator.printState = function()
{
    var state = History.getState();
    History.log(state.url, state.title, state.data);
}

//****************************************
//** state change
//****************************************

/**
 * Bind the statechange event listener.
 * Clients should usually NOT call this directly.
 */
KmNavigator.bind = function()
{
    $(window).bind('statechange', KmNavigator.handleStateChange);
}

/**
 * Unbind the statechange event listener.
 * Clients should usually NOT call this directly.
 */
KmNavigator.unbind = function()
{
    $(window).unbind('statechange', KmNavigator.handleStateChange);
}

/**
 * Handle a state change.  This is the callback that gets executed
 * when the browser detects that the page has changed.  E.g.: when the
 * user presses the back button.
 */
KmNavigator.handleStateChange = function()
{
    KmNavigator.printCurrentPage();
}

//****************************************
//** depth
//****************************************

KmNavigator.getDepth = function()
{
    return History.getState().data.depth;
}

KmNavigator.getNextDepth = function()
{
    var i = KmNavigator.getDepth();

    if ( i === undefined )
        return 0;

    return i + 1;
}

//****************************************
//** real depth
//****************************************

KmNavigator.getRealDepth = function()
{
    return History.getState().data.realDepth;
}

KmNavigator.getNextRealDepth = function()
{
    var i = KmNavigator.getRealDepth();

    if ( i === undefined )
        return 0;

    return i + 1;
}
