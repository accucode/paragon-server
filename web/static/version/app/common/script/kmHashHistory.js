//**********************************************************
//**
//** Basic management of browser history via javascript.
//** We cannot control the browser history, but we can 
//** provide custom responses to the change of the url
//** as long as the user stays on the same page.  
//**
//** General usage is as follows.  
//** 1) The client registers a callback function.
//** 2) Create links (or navigation) using #hash...
//** 3) The callback will be run when the window.location changes.
//**
//**********************************************************

var KmHashHistory = {};

//**********************************************************
//** functions
//**********************************************************

/*
 * Register the callback function.  This function will
 * be called each time the browser's window.location
 * changes.
 */
KmHashHistory.register = function(fn)
{
    $(window).on('hashchange', fn); 
}

/*
 * Go to a local hash url.  
 * E.g.: goto("#somePage");
 * The registered callback method will be executed after
 * the url changes.
 */
KmHashHistory.goto = function(hash)
{
    window.location.hash(hash);
}

/*
 * Navigate to the previous view.
 */
KmHashHistory.back = function()
{
    window.history.back();
}
