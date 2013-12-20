//**********************************************************
//**
//** Basic management of browser history via javascript.
//**
//**********************************************************

var KmNavigator = {};

/**
 * Called once to initialize the navigator.
 */
KmNavigator.init = function()
{
    KmNavigator.bind();            
}

/**
 * Push a page on the history stack.
 * The options parameter supports the following attributes:
 *
 *      url
 *          The url to be pushed. 
 *          This is the only required attribute, and is pushed 'as is'.
 *
 *      title
 *          Although this may be used to update the browser's title, it is
 *          not well supported.  If no value is specified, we use an empty string. 
 *
 *      replace
 *          If true, do a replaceState instead of a pushState.
 *
 *      silent
 *          By defualt, a push normally triggers the statechange event.  
 *          If silent is set to true, the statechange event is temporarily disabled.
 */
KmNavigator.pushPage = function(options)
{
    var url = options.url;
    
    var title = options.title;
    if ( !title )
        title = '';
    
    var data = 
    {
        pageSession: Kmu.pageSession
    };

    var push = true;
    if ( options.replace )
        push = false;
        
    var silent = options.silent;
    
        KmNavigator.unbind();
        KmNavigator.pushOrReplace(data, title, url, push);
        KmNavigator.bind();
        
    if ( !silent )
        KmNavigator.handleStateChange();
}

KmNavigator.pushOrReplace = function(data, title, url, push)
{
    if ( push )
        History.pushState(data, title, url);
    else
        History.replaceState(data, title, url);
}

KmNavigator.pushUrl = function(url)
{
    KmNavigator.pushPage({url: url});
}

KmNavigator.printCurrentPage = function()
{
    Kmu.ajax(
    {
        action: "_printWindowLocation"
    });
}

KmNavigator.replacePageSession = function()
{
    var state = History.getState();
    
    var data;
    data = state.data;
    data.pageSession = Kmu.pageSession;
    
    var title = state.title;
    var url = state.url;
    
    History.replaceState(data, title, url);
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

/**
 * Bind the statechange event listener.
 * This is typically NOT called directly. 
 */
KmNavigator.bind = function()
{
    $(window).bind('statechange', KmNavigator.handleStateChange);
}

/**
 * Unbind the statechange event listener.
 * This is typically NOT called directly. 
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
    var state = History.getState();
    var ps = state.data.pageSession;
    if ( ps === undefined )
        ps = {};
    Kmu.pageSession = ps;
    
    KmNavigator.printCurrentPage();
}



