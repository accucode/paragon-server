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
 *
 *      title
 *          Although this may be used to update the browser's title, it is
 *          not well supported.  If no value is specified, we use an empty string. 
 *
 *      replace
 *          If true, do a replaceState instead of a pushState.
 *
 *      handleStateChange
 *          By default, a push normally triggers the statechange event.  
 *          If handleStateChange is false, the statechange event is temporarily ignored.
 */
KmNavigator.pushPage = function(options)
{
    var url = options.url;
    
    var title = options.title;
    if ( !title )
        title = '';
    
    var state = History.getState();
    
    var push = true;
    if ( options.replace )
        push = false;
        
    var data = {};
    data.pageSession = KmNavigator.getPageSession();
    
    var inc = push && !state.url.endsWith(url);
    if ( inc )
        data.depth = KmNavigator.getNextDepth();
    else
    	data.depth = state.data.depth;
        
    var handle = options.handleStateChange;
    if ( handle === undefined )
        handle = true;
    
    KmNavigator.unbind();

    if ( push )
        History.pushState(data, title, url);
    else
        History.replaceState(data, title, url);
        
    KmNavigator.bind();

    if ( handle )
        KmNavigator.handleStateChange();
}

KmNavigator.pushUrl = function(url)
{
    KmNavigator.pushPage({url: url});
}

KmNavigator.printCurrentPage = function()
{
    Kmu.ajax(
    {
        action: "_printWindowLocation",
        direction: KmNavigator.getDirection()
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
    var ps = History.getState().data.pageSession;
    
    if ( ps === undefined )
        ps = {};
        
    return ps;
}
    
/**
 * Update history state with the parameter specified.
 * This does NOT push (or pop) a page on the history stack.
 * This uses History.replaceState, but temporary unbinds the 
 * event listener to avoid an infinite loop.
 */ 
KmNavigator.updatePageSession = function(map)
{
    var state = History.getState();
    
    var data;
    data = state.data;
    data.pageSession = map;
    
    var title = state.title;
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
