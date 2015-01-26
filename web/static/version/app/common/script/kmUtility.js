//**********************************************************
//**
//** A variety of utility methods.
//** Dependencies: jquery, kmExtensions
//**
//**********************************************************

// jQuery.easing.def = "linear";
jQuery.easing.def = "easeOutBounce";
jQuery.easing.def = "jswing";
jQuery.easing.def = "easeOutQuart";

var Kmu = {};

//**********************************************************
//** constants
//**********************************************************

/*
 * Used with the methods to open and close dialogs.
 */
Kmu.dialogOpenSpeed  = 300;
Kmu.dialogCloseSpeed = 100;

/*
 * Used to determine the automatic block delay.
 * Page content is automatically blocked during ajax requests.
 * If the ajax request takes longer than this, then shade the
 * screen to provide a visual indication to the user.
 */
Kmu.blockDelayMs     = 500; 	

/*
 * Used to identify which page is currently rendered.

 * The server compares the current and next page in order to perform certain
 * conditional updates.  For example, rather than updates the left-menu for EVERY
 * request, the server compares the current/next pages to determine when/if the menu
 * needs to be removed, added, replaced, or when it just needs to have its selection updated.   
 * 
 * This is intentionally managed outside the page session and browser navigation state.
 * It needs to be independent from these since the DOM is also indpendent.
 * 
 * The server should include a script that updates this value each time the page changes.
 * The ajax() submits include this value each time a request is sent to the server.
 * This value may be null, though typically only for the very request.
 */ 
Kmu.currentPageKey = null;

//**********************************************************
//** ajax
//**********************************************************

/*
 * options
 *     action
 *     		Required string.
 *     		The action key that identifies the server side function to execute.		
 *     
 *     form
 *     		Optional string selector.
 *     		Identifies the parameters to be submitted with this request.
 *     
 *     argument
 *     		Optional string.
 *     		The server expects this to be encoded.
 *     		See ScEncoder.
 *     
 *     extra
 *     		Optional string.
 *			If set, pass this value without any encoding.
 *     
 *     block
 *     		Optional string.
 *     		If set, block the ui component BEFORE the ajax request.
 *     		This should be a valid css selector.
 *     
 *     confirmation
 *     		Optional string
 *     		If set, prompt the user to confirm (Ok/Cancel) before submitting.
 *     		Confirmation is handled with a simple window.confirm() dialog.
 *      
 *     direction
 *     		Optional string (forward, back, refresh, unknown).
 *     		If set indicates the navigation direction.
 */
Kmu.ajax = function(options)
{
    if ( !Kmu.checkAjaxConfirmation(options) )
        return;

    var onSuccessArr = [];
    var onErrorArr = [];
    
    Kmu.initAjaxBlocking(options, onSuccessArr, onErrorArr);
    
    onSuccessArr.push(Kmu.ajaxSuccess);
    onErrorArr.push(Kmu.ajaxError);
    
    var data = Kmu.formatAjaxData(options);
    
    // Assumes ROOT servlet context 
    $.ajax(
    {
    	type:   	'POST',
    	url: 		'/servlet/ajax',
    	dataType: 	'json',
    	data: 		data,
    	success: 	onSuccessArr,
    	error: 		onErrorArr,
    	complete: 	Kmu.ajaxComplete
    });
}

Kmu.checkAjaxConfirmation = function(options)
{
    if ( !options.confirmation )
        return true;
        
    var msg = options.confirmation.toString();
	return confirm(msg);
}

Kmu.initAjaxBlocking = function(options, onSuccessArr, onErrorArr)
{
    if ( options.block )
    {
      	var sel = options.block;
      	var delay = Kmu.blockDelayMs;
        Kmu.blockControlQuietly(sel, delay);
        
        var fn = function() { Kmu.unblockControl(sel); };
        onSuccessArr.push(fn);
        onErrorArr.push(fn);
        return;
    }
    
  	var delay = Kmu.blockDelayMs;
    Kmu.blockPageQuietly(delay);
    
    var fn = function() { Kmu.unblockPage(); };
    onSuccessArr.push(fn);
    onErrorArr.push(fn);
}

Kmu.formatAjaxData = function(options)
{
	var baseParams = Kmu.formatAjaxBaseParams(options)
	var formParams = Kmu.formatAjaxFormParams(options);
	
	return Kmu.concatAjaxParams(baseParams, formParams);
}

Kmu.formatAjaxBaseParams = function(options)
{
   	var e;
   	e = {};
   	e._currentPageKey    	= Kmu.currentPageKey;
    e._windowLocation 	 	= window.location.href;
    
    e._isHeaderVisible   	= $('#pageHeader').isVisible();
    e._isFooterVisible	 	= $('#pageFooter').isVisible();
    e._isTopMenuVisible  	= $('#pageTopMenu').isVisible();
    e._isLeftMenuVisible 	= $('#pageLeftMenu').isVisible();
    e._isPageTitleVisible 	= $('#pageTitle').isVisible();
    e._isPageContentVisible	= $('#pageContent').isVisible();
   
    if ( options.form )
        e._form = options.form;

    if ( options.action )
        e._action = options.action;

    if ( options.argument )
        e._argument = options.argument;

    if ( options.extra )
        e._extraValue = options.extra;

    if ( options.direction )
        e._direction = options.direction;
        
    var ps = KmNavigator.getPageSession(); 
    if ( ps )
        e._session = JSON.stringify(ps);

	return $.param(e); 
}

Kmu.formatAjaxFormParams = function(options)
{
    if ( !options.form )
        return null;
        
    return $('#' + options.form).serialize();
}

Kmu.concatAjaxParams = function(a, b)
{
   	if ( a && b )
   		return a + "&" + b;
   		
   	if ( a )
   	    return a;
   	    
   	if ( b )
   	    return b;
   	
    return '';
}

Kmu.ajaxSuccess = function(result)
{
    eval(result.script);
}

Kmu.ajaxError = function(req, status, error)
{
	if ( req.responseHeader === undefined )
	{
	    alert('The server is temporarily down for maintenance.' 
            + '\nPlease check back shortly.'
            );
	    return;
	}
	
	alert('An unexpected error has occurred.' 
	        + '\nStatus: ' + status
	        + '\nError: ' + error
	        + '\nResponseText: ' + req.responseText
	        + '\nResponseHeader: ' + req.responseHeader
	        );
}

/*
 * Called after success or error
 */
Kmu.ajaxComplete = function(jqXHR, textStatus)
{
}

//**********************************************************
//** dom
//**********************************************************

/*
 * Use getElementById if a string, otherwise return e.
 */
Kmu.ref = function(e)
{
    if ( isString(e) )
        return document.getElementById(e);
    
    return e;
}

//**********************************************************
//** types
//**********************************************************

Kmu.isArray = function(e)
{
    return e instanceof Array; 
}

Kmu.isString = function(e)
{
    return typeof(e) == "string";
}

//**********************************************************
//** string
//**********************************************************

Kmu.endsWith = function(s, suffix)
{
    return s.indexOf(suffix) == s.length - suffix.length;
}

Kmu.repeat = function(s, n)
{
    var result = "";
    for ( var i=0; i<n; i++ )
        result += s;
    return result;
}

//**********************************************************
//** utility
//**********************************************************

Kmu.printWindow = function()
{
    window.print();
}

Kmu.wait = function(ms) 
{
    ms += new Date().getTime();
    while ( new Date() < ms ) {}
}

/**
 * Merge the attributes of multiple objects into a NEW result.
 * The parameters are merged in the order in which they are provided.
 * That is, we start with a, then merge b, then merge c, etc.
 * In general, pass the default values first, and overrides second.
 */
Kmu.merge = function(a, b, c)
{
    var r = {};
    
    if ( a )
        for ( key in a )
            r[key] = a[key];
            
    if ( b )
        for ( key in b )
            r[key] = b[key];
    
    if ( c )
        for ( key in c )
            r[key] = c[key];
    
    return r;
}

/**
 * Create a shallow copy.
 */
Kmu.shallowCopy = function(value)
{
    var copy = {};

    for ( var key in value ) 
        if ( value.hasOwnProperty(key) )
		    copy[key] = value[key];
    
    return copy;
}

/**
 * Print the objects attributes onto the console.log.
 */
Kmu.logAttributes = function(o)
{
	if ( !o )
	    return;
	    
	for ( var e in o )
	    if ( o.hasOwnProperty(e) )
		    console.log(e + " => " + o[e]);
}

/**
 * Log the object with JSON.stringify.
 */
Kmu.logJson = function(o)
{
    Kmu.log(JSON.stringify(o));
}

//**********************************************************
//** toast
//**********************************************************

Kmu.toast = function(s)
{
    Kmu.toastInfo(s);
}

Kmu.toastInfo = function(s)
{
    $().toastmessage('showNoticeToast', s);
}

Kmu.toastSuccess = function(s)
{
    $().toastmessage('showSuccessToast', s);
}

Kmu.toastWarn = function(s)
{
    $().toastmessage('showWarningToast', s);
}

Kmu.toastError = function(s)
{
    $().toastmessage('showErrorToast', s);
}

//**********************************************************
//** log
//**********************************************************

Kmu.log = function(s)
{   
    if ( !s )
        s = '.';
        
    console.log(s.toString());
}

Kmu.print = function(s)
{
    Kmu.log(s);
}

//**********************************************************
//** dom
//**********************************************************

/**
 * Add a button to all parents that match the selector. 
 */
Kmu.addButtonTo = function($parent, title, fn)
{
    var e;
    e = document.createElement('button');
    e.onclick = fn;
    $(e).append(title);

    $($parent).append(e);
    
    return $(e);
}

/**
 * Add a text message to all parents that match the selector.
 */
Kmu.addTextTo = function($parent, s)
{
    var e = document.createTextNode(s);
    
    $($parent).append(e);
}

Kmu.show = function(e)
{
	$(e).show();
}

//**********************************************************
//** jquery widgets
//**********************************************************

/*
 * http://jqueryui.com/demos/datepicker/
 */
Kmu.installDateField = function(sel)
{
    $(sel).datepicker(
    {
        showOn: 'focus',
        showAnim: 'slideDown',
        contrainInput: true
    });
    
    /*
    //Assumes ROOT (implied) context
    $(sel).datepicker(
    {
        showOn: 'button',
        showAnim: 'slideDown',
        buttonImage: '/static/version/led-icons/calendar_1.png',
        buttonImageOnly: true,   
        contrainInput: false
    });
    */
}

/*
 * http://www.eyecon.ro/colorpicker/
 */
Kmu.installColorField = function(sel)
{
    $(sel)
        .ColorPicker(
        {
            eventName: 'click',
            onBeforeShow: function() 
            {
                $(this).ColorPickerSetColor(this.value);
            },
            onSubmit: function(hsb, hex, rgb, e) 
            {
                $(e).val(hex);
                $(e).ColorPickerHide();
            },
            onShow: function(picker)
            {
           		$(picker).slideDown(100);
           		return false;
            },
            onHide: function(picker)
            {
           		$(picker).slideUp(100);
           		return false;
            }
        })
        .bind('keyup', function()
        {
            $(this).ColorPickerSetColor(this.value);
        });
}

//**********************************************************
//** json commands
//**********************************************************

Kmu.jsonReplaceSimple = function(json)
{
    var inner = $(json.inner);
    var html  = json.html;

    inner.empty();
    
    if ( html )
        inner.html(html);
        
    if ( json.postDomScript )
        eval(json.postDomScript);

    if ( json.postRenderScript )
        eval(json.postRenderScript);
}

Kmu.jsonReplaceFade = function(json)
{
    var inner = $(json.inner);
    
    var outer = json.outer 
        ? $(json.outer) 
        : inner; 
    
    var speed = json.speed;
    
    outer.hide('fade', {}, speed, function() 
    {
        inner.empty();
        
        if ( json.html )
            inner.html(json.html);
            
        if ( json.postDomScript )
            eval(json.postDomScript);
                
        outer.show('fade', {}, speed, function()
        {
	        if ( json.postRenderScript )
    	        eval(json.postRenderScript);
        });
    });
}

Kmu.jsonReplaceLeft = function(json)
{
    var inner = $(json.inner);
    
    var outer = json.outer 
        ? $(json.outer) 
        : inner; 
    
    var speed = json.speed;
    
    outer.hide('slide', {direction:'left'}, speed, function() 
    {
        inner.empty();
        
        if ( json.html ) 
            inner.html(json.html);
        
        if ( json.postDomScript )
            eval(json.postDomScript);
                
        outer.show('slide', {direction:'right'}, speed, function()
        {
	        if ( json.postRenderScript )
    	        eval(json.postRenderScript);
        });
    });
}

Kmu.jsonReplaceRight = function(json)
{
    var inner = $(json.inner);
    
    var outer = json.outer 
        ? $(json.outer) 
        : inner; 
    
    var speed = json.speed;
    
    outer.hide('slide', {direction:'right'}, speed, function() 
    {
        inner.empty();
        
        if ( json.html )
            inner.html(json.html);
            
        if ( json.postDomScript )
            eval(json.postDomScript);
            
        outer.show('slide', {direction:'left'}, speed, function()
        {
	        if ( json.postRenderScript )
    	        eval(json.postRenderScript);
        });
    });
}

Kmu.jsonShow = function(json)
{
    var target = $(json.target);
	var easing = json.easing;
	
	if ( easing )
    	target.show(easing, json.options, json.speed);
    else
		target.show();
	
    target.promise().done(function()
    {
		Kmu.evalSafe(json.postDomScript);
		Kmu.evalSafe(json.postRenderScript);
    });
}

Kmu.evalSafe = function(s)
{
	if ( s )
		eval(s);
}


//**********************************************************
//** cookies
//** https://github.com/carhartl/jquery-cookie
//**********************************************************

/**
 * The the cookie value, may be empty string.
 * Return null if cookie does not exist.
 */
Kmu.getCookie = function(key)
{
    return $.cookie(key);
}

/**
 * Set a cookie value that expires in one year.
 */    
Kmu.setCookie = function(key, value)
{
    var options = { days: 365 };
    $.cookie(key, value, options);
}

/**
 * Set a cookie value that expires when the session ends.
 */    
Kmu.setSessionCookie = function(key, value)
{
    $.cookie(key, value);
}

/**
 * Return true if the cookie exists.
 */    
Kmu.hasCookie = function(key)
{
    return $.cookie(key) == null;
}

/**
 * Clear the cookie.
 */
Kmu.clearCookie = function(key)
{
    // Set to empty string instead of null.
	// In some cases (e.g.: FF7) setting null doesn't work correctly.
    $.cookie(key, '');
}

//**********************************************************
//** focus
//**********************************************************

/**
 * Set focus on the first field inside of the specified selector.
 * The selector parameter is typically set to a form.
 * The jquery :input matches input, textarea, select, and button. 
 */
Kmu.focus = function(sel)
{
    var filters = [
        ":input[autofocus]:visible:enabled:not([readonly]):first",
        ":input:visible:enabled:not([readonly]):first"
    ];

    var n = filters.length;    
    for ( var i=0; i<n; i++ )
    {
        var filter = filters[i];
        if ( Kmu._focusFilter(sel, filter) )
            return;
    }

    // if the filters don't match anything, then attempt to focus the selector itself.
    if ( sel )
        $(sel).focus();
}

Kmu._focusFilter = function(sel, filter)
{
    var e;
    
    if ( sel )
    {
        // This only matches descendants; NOT the selector itself.
        // YES, the space is required.
        e = $(sel + " " + filter);
        if ( e.length == 0 )
            return false;

        e.focus();
        return true;
    }

    // if no selector, focus first field on page.
    e = $(filter);
    if ( e.length == 0 )
        return false;
        
    e.focus();
    return true;
}

/**
 * Set focus on the first input text field.
 * This is useful when we want to focus on the first text field,
 * NOT on select boxes, check boxes, radio buttons, etc...
 * This does NOT set focus on text areas.
 */
Kmu.focusTextField = function(sel)
{
    var filter = ":text:visible:enabled:first";
    
    if ( !sel )
    {
    	$("input " + filter).focus();
    	return;
    }
    
    var e = $(sel + " " + filter);
    
    if ( e.get(0) )
        e.focus();
    else
        $(sel).focus();
}

//**********************************************************
//** select options
//**********************************************************

/* 
 * The the select box options.
 */
Kmu.setSelectOptions = function(select, options)
{
   	Kmu.clearSelectOptions(select);
   	Kmu.addSelectOptions(select, options);
}

/*
 * Add an array of options.  The parameter must be an array.
 */
Kmu.addSelectOptions = function(select, options)
{
    for ( var i in options )
        Kmu.addSelectOption(select, options[i]);
}

/*
 * Add an option to the end of the select.
 * The parameter must have attributes for "text" and "value".
 */
Kmu.addSelectOption = function(select, o)
{
    Kmu.addSelectOptionTextValue(select, o.text, o.value);
}

/*
 * Add an option to the end of the select.
 */
Kmu.addSelectOptionTextValue = function(select, text, value)
{
    var e;
    e = document.createElement('option');
    e.text = text;
    e.value = value;
    
    var s;
    s = $(select).first().get(0);
    s.add(e);
}

/* 
 * Remove all options from a select box.
 */
Kmu.clearSelectOptions = function(select)
{
    var s = $(select).first().get(0);
    while ( s.length )
        s.remove(0);
}

//**********************************************************
//** buttons
//**********************************************************

Kmu.enableButton = function(e, theme)
{
    if ( ! theme )
        theme = "default";
        
    e = $(e);
    e.removeAttr("disabled");
    Kmu.removeClassesWithPrefix(e, "button-element-");
    e.addClass("button-element-" + theme);
}

Kmu.disableButton = function(e)
{
    e = $(e);
    e.attr("disabled", "disabled");
    Kmu.removeClassesWithPrefix(e, "button-element-");
    e.addClass("button-element-disabled");
}

//**********************************************************
//** elements
//**********************************************************

Kmu.removeClassesWithPrefix = function(e, prefix)
{
    e = $(e);
    
    if ( !e )
        return;
        
    var c = e.attr("class");
    if ( !c )
        return;
        
    var arr = c.split(" ");
    if ( !arr )
        return;
    
    for ( var i in arr )
    {
        var s = arr[i];
        if ( s.startsWith(prefix) )
            e.removeClass(s);
    }
}

//**********************************************************
//** dialog
//**********************************************************

/*
 * Open a modal dialog, using dom content identified a jquery selector.
 * Only one dialog may be open at a time.
 * If a dialog is already open, it will be closed before opening the new dialog.
 */
Kmu.openDialogTarget = function(target, options)
{
   	options = Kmu.getDialogOptions(options);

    var postClose = function()
    {
        $(target).modal(options);
    };

    $.modal.close(postClose);
}

Kmu.openDialogHtml = function(html, options)
{
   	options = Kmu.getDialogOptions(options);

    var postClose = function()
    {
		$(html).modal(options);
    };
   	
    $.modal.close(postClose);
}

Kmu.getDialogOptions = function(overrides)
{
    var defs =
    {
		focus: true,
	    onOpen: Kmu.openDialogCallback,
	    onClose: Kmu.closeDialogCallback,
		containerCss:
        {
            border: "4px solid #44f"
        }
    };

    return $.extend({}, defs, overrides);
}

/*
 * Close the single modal dialog.
 * If no dialog is open, exit without an error.
 */
Kmu.closeDialog = function()
{
	$.modal.close();
}

/*
 * Used to animate the opening of dialogs.  Not called directly.
 */
Kmu.openDialogCallback = function(dialog)
{
    var speed = Kmu.dialogOpenSpeed;

    dialog.overlay.fadeIn(speed, function() 
    {
        dialog.container.slideDown(speed, function() 
        {
            dialog.data.fadeIn(speed, function()
            {
                $.modal.opened();
            });
        });
    });
}
        
/*
 * Used to animate the closing of dialogs.  Not called directly.
 */
Kmu.closeDialogCallback = function(dialog)
{
    var speed = Kmu.dialogCloseSpeed;
    
    dialog.data.fadeOut(speed, function()
    {
        dialog.container.slideUp(speed, function() 
        {
            dialog.overlay.fadeOut(speed, function() 
            {
                $.modal.close();
            });
        });
    });
}


//**********************************************************
//** misc 
//**********************************************************

Kmu.resetCursor = function(sel)
{
    $(sel).css('cursor', 'auto');
}

/*
 * All of the args are optional; but you generally need to provide
 * either the url or the html.
 * args
 *     url:     The url to load in the new window.
 *     name:    The name of the new window.
 *     params:  A single string listing all of the window parameters. 
 *     html:    The html to add to the window after it opens.
 */
Kmu.openWindow = function(args)
{
    if ( ! args )
    {
        window.open();
        return;
    }
    
    var url = null;
    if ( args.url ) url = args.url;
    
    var name = null;
    if ( args.name ) name = args.name;
    
    var params = null;
    if ( args.params ) params = args.params;
    
    var html = null;
    if ( args.html ) html = args.html;
    
    var w;
    w = window.open(url, name, params);

    if ( w && html )
    {
        w.document.write(html);
        w.document.close();
    }
}


//**********************************************************
//** block 
//**********************************************************

/*
 * These methods are used to block user access to the page.
 * We commonly block access during ajax requests to minimize
 * confusion and provide clear ui feedback.
 * 
 * http://jquery.malsup.com/block/
 */
    
/*
 * Blocks the entire page.
 */
Kmu.blockPage = function()
{
    $.blockUI(
    {
        message: "Processing...",
        fadeIn: 100
    });
}

Kmu.blockPageQuietly = function(delayMs)
{
    $.blockUI(
    {
        message: "Processing...",
        fadeIn: 0,
        css: { visibility: 'hidden' },
        overlayCSS: { opacity: 0.0 }
    });

    if ( delayMs !== null )
	    setTimeout("Kmu.unQuietPageBlock();", delayMs);
}

Kmu.unQuietPageBlock = function()
{
    $('.blockOverlay').css('opacity', 0.6);
    $('.blockMsg').css('visibility', 'visible');
}

    
/*
 * Unblocks the entire page.
 */
Kmu.unblockPage = function()
{
    // without this, chrome doesn't reset the cursor until it moves.
    Kmu.resetCursor('.blockUI');

    $.unblockUI(
    {
        fadeOut: 100
    });
}

Kmu.blockControl = function(sel)
{
    $(sel).block(
    {
        message: "Processing...",
        fadeIn: 100
    });
}

Kmu.blockControlQuietly = function(sel, delayMs)
{
    $(sel).block(
    {
        message: "Processing...",
        fadeIn: 0,
        css: { visibility: 'hidden' },
        overlayCSS: { opacity: 0.0 }
    });

    if ( delayMs !== null )
	    setTimeout("Kmu.unQuietControlBlock('" + sel + "');", delayMs);
}

Kmu.unQuietControlBlock = function(sel)
{
    $(sel + ' > .blockOverlay').css('opacity', 0.6);
    $(sel + ' > .blockMsg').css('visibility', 'visible');
}

Kmu.unblockControl = function(sel)
{
    // without this, chrome doesn't reset the cursor until it moves.
    Kmu.resetCursor('.blockUI');

    $(sel).unblock(
    {
        fadeOut: 100
    });
}

/*
 * Clear the default css.  This allows the css to be defined
 * using the class .blockMsg in an external (themed) stylesheet.
 */
$.blockUI.defaults.css = {};

/*
 * The following can be used to automatically block the entire
 * page during ever ajax request.  However, this is not very
 * practical since 1) we prefer to block only the localized 
 * area affected, and 2) I don't think this works reliably when
 * submitting multiple overlapping ajax requests.
 */
// $(document).ajaxStart($.blockUI).ajaxStop($.unblockUI);


//**********************************************************
//** equalize
//**********************************************************

/*
 * This function will equalize the height and width of elements
 * passed in a jquery selector.
 */
Kmu.equalize = function(options) 
{
    var selector    = options.selector;
    var height      = options.height;
    var width       = options.width;
    var tallest     = options.minHeight || 0;
    var widest      = options.minWidth || 0;
    var maxHeight   = options.maxHeight;
    var maxWidth    = options.maxWidth;
    var fillerSel = ".equalizeFiller";

    // equalize width
    
    if ( width )
    {
        $(selector).each(function() 
        {
            if ( $(this).width() > widest ) 
                widest = $(this).width();
        });
            
        if ( maxWidth && widest > maxWidth ) 
                widest = maxWidth;
       
        $(selector).each(function() 
        {
            $(this).width(widest);
        });
    }
    
    // equalize height
    
    if ( height )
    {
        $(selector).find(fillerSel).each(function()
        {
            $(this).height(0);        
        });
    
        $(selector).each(function() 
        {
            if ( $(this).height() > tallest ) 
                tallest = $(this).height();
        });
       
        if ( maxHeight && tallest > maxHeight ) 
                tallest = maxHeight;
       
        $(selector).each(function() 
        {
            var filler = $(this).find(fillerSel);
            
            if ( filler.length > 0 )
            {
                var diff = tallest - $(this).height();
                
                if ( diff > 0 )
                    filler.first().height(diff);
            }        
            else    
                $(this).height(tallest);
        });
    }
}

//**********************************************************
//** flip
//**********************************************************

Kmu.flipHide = function(options)
{
    var selector = options.selector;
    var duration = options.duration;
    var easing = options.easing;
    
    $(selector).transition(
    {
        rotateY: 90, 
        duration: duration, 
        easing: easing
    });
    
    $(selector).promise().done(function()
    {
        $(selector).hide();
    });
}

Kmu.flipShow = function(options)
{
    var selector = options.selector;
    var duration = options.duration;
    var easing = options.easing;
    
    $(selector).show();
    
    $(selector).transition(
    {
        rotateY: 0, 
        duration: duration, 
        easing: easing
    });
}

Kmu.flipToggle = function(options)
{
    var selector = options.selector;

    if ( $(selector).is(':visible') )
        Kmu.flipHide(options);
    else
        Kmu.flipShow(options);
}

//**********************************************************
//** dom traversal
//**********************************************************

Kmu.getIdsFor = function(sel)
{
    return getAttributesFor(sel, 'id');
}

Kmu.formatIdsFor = function(sel)
{
    return formatAttributesFor(sel, 'id');
}

/**
 * Find all elements that match the selector.
 * For each element, collect the corresponding attribute into an array.
 * For example, getAttributesFor('.moose', 'id')... would return an array
 * that contains the id of each element with the moose class.
 */
Kmu.getAttributesFor = function(sel, attr)
{
    var result = [];
    var arr = $(sel).toArray();

    for ( var i in arr )
        result.push($(arr[i]).attr(attr));

    return result;
}

/**
 * Find all elements that match the selector.
 * For each element, collect the corresponding attribute into a comma delimited string. 
 */
Kmu.formatAttributesFor = function(sel, attr)
{
    var s = '';
    var arr = Kmu.getAttributesFor(sel, attr);

    for ( var i in arr )
        s += arr[i] + ',';

    var n = s.length;
    if ( n == 0 )
        return s;
        
    return s.substring(0, n-1);
}

//**********************************************************
//** drag
//**********************************************************

Kmu.registerDragUpdate = function(parentSelector, childPath, attr, actionId)
{
    $(parentSelector).sortable(
    {
        update: function(event, ui) 
        {
            var fullChildPath = parentSelector + childPath;
            var attributes = Kmu.formatAttributesFor(fullChildPath, attr);
             
            Kmu.ajax(
            {
                action: actionId,
                extra: attributes
            });
        }
    });
}

//**********************************************************
//** glow
//**********************************************************

/**
 * Change some attribute of the target element to a new value, then back.
 * The change is animated.
 * 
 * Options
 * 		target
 * 			A valid jquery selector, compatible with $(target).
 * 			This is required.
 * 
 * 		attribute
 * 			The name of the css attribute to modify.
 * 		    Defaults to "background-color".
 * 
 * 		value
 * 			The value to which the attribute will be changed.
 * 			Defaults to "yellow".
 * 
 * 		speed
 * 			The speed at which the animation occurs.
 * 		    This is the total animation time, which is split between first changing
 * 		    to the new value, then changing back to the original value.
 *          Defaults to 200.
 */
Kmu.glow = function(options)
{
	var target = options.target;
	if ( !target )
	    return;
	    
	target = $(target);

	var attr = options.attribute;
	if ( !attr )
	    attr = "background-color";
	    
	var value = options.value;
	if ( value === undefined )
	    value = "yellow";

	var speed = options.speed;
	if ( speed === undefined )
	    speed = 200;
	    
	var oldValue = target.css(attr);
	var oldStyle = target.attr("style");

	var showCss;
	showCss = {};
	showCss[attr] = value;

	var hideCss;
	hideCss = {};
	hideCss[attr] = oldValue;

	var extra;
	extra = {};
	extra.duration = speed / 2;
	
	// SHOW; run the animation to show the effect.
	target.animate(showCss, extra);

    // HIDE: run the animation to hide the effect.
	target.animate(hideCss, extra);

    // RESTORE: ensure that the 'style' attribute is restored to it's original value.
	target.promise().done(function()
    {
    	if ( oldStyle === undefined )
    		target.removeAttr("style");
    	else
    	    target.attr("style", oldStyle);
    });
}

Kmu.glowBackground = function(e)
{
    Kmu.glow(
    {
        target: e,
        attribute: "background-color",
        value: "yellow"
    });
}

Kmu.glowColor = function(e)
{
    Kmu.glow(
    {
        target: e,
        attribute: "color",
        value: "yellow"
    });
}

//**********************************************************
//** flexigrid
//**********************************************************
    
/**
 * Apply styling to a flexigrid such that it fills its parent.
 * The client should pass in the table selector that was originally used to create the grid.
 * We use absolute positioning and rely on several assumptions to make this work.
 * We assume that the header and footer are visible, and hard code the pixel sizes.
 */
Kmu.flexigridFill = function(tableSel)
{
	var grid   = $(tableSel).parent().parent();
	var header = grid.find('.hDiv');
	var body   = grid.find('.bDiv');
	var pager  = grid.find('.pDiv');
	
	grid.css("position", "absolute");
	grid.css("left",   "0");
	grid.css("right",  "0");
	grid.css("top",    "0");
	grid.css("bottom", "0");
	
	header.css("position", "absolute");
	header.css("left",   "0");
	header.css("right",  "0");
	header.css("top",    "0");
	header.css("height", "25px");
	
	body.css("position", "absolute");
	body.css("left",   "0");
	body.css("right",  "0");
	body.css("top",    "25px");
	body.css("bottom", "31px");
	body.css("height", "");
	
	pager.css("position", "absolute");
	pager.css("left",   "0");
	pager.css("right",  "0");
	pager.css("bottom", "0");
	pager.css("height", "31px");
}

//**********************************************************
//** scroll
//**********************************************************

/**
 * Scroll the parent to a position that displays the child,
 * but don't bother scrolling at all if the child is already 
 * visible on screen.
 * 
 * Relies on plugins: scrollTo, jquery.visible
 */ 
Kmu.scrollToIfOffScreen = function(parentSel, childSel)
{
    if ( !$(childSel).visible() ) 
    	$(parentSel).scrollTo(childSel);
}

//**********************************************************
//** client side filter
//**********************************************************

/**
 * The following options are supported...
 *
 * findValue
 *      A string value to search for.
 *      Should NOT be used with findSel.
 *
 * fieldSel
 *      A string selector used to identify the field that contains the value to search for.
 *      Should NOT be used with findValue.
 *
 * itemSel
 *      A string selector that identifies the items to be shown or hidden.
 *      This is required.
 *
 * attrSels
 *      An array of string selectors used to identify one or more child elements of each item.
 */
Kmu.filterItems = function(options)
{
    var find = null;

    if ( options.findValue )
        find = options.findValue;
            
    if ( options.fieldSel )
        find = $(options.fieldSel).val();

    var itemSel = options.itemSel;
    var attrSels = options.attrSels;

    if ( !find )
    {
        $(itemSel).show();
        return;
    }
    
    find = find.toLowerCase();
    
    $(itemSel).each(function()
    {
        var e = $(this);
        var match = false;
        var n = attrSels.length;
        for ( var i=0; i<n; i++ )
        {
            var attr = e.find(attrSels[i]);
            if ( $(attr).text().toLowerCase().indexOf(find) >= 0 )
            {
                match = true;
                break;
            }
        }
        
        if ( match )
            e.show();
        else
            e.hide();
    });
}

//**********************************************************
//** draggable multi select
//**********************************************************

/**
 * This method is used by the ScDraggableMultiSelect widget to move
 * items back-and-forth between the selected and available lists.
 * This method should be bound to the onClick event of either the
 * list items, or any dom child inside of the item (e.g.: the toggle buttons).
 * This depends on the css classes defined in the theme.css.
 */
Kmu.dmsToggle = function(e)
{
    var item      = $(e).closest(".dmsItem");
    var container = item.closest(".dmsContainer");
    var selList   = container.find(".dmsSelectedList");
    var availList = container.find(".dmsAvailableList");
    var field     = item.find(".dmsItemField");

    var targetList;
    var isTargetAvail = item.parent().hasClass("dmsSelectedList");
    
    if ( isTargetAvail )
    {
        targetList = availList;
        field.attr("disabled", "disabled");
    }
    else
    {
        targetList = selList;
        field.removeAttr("disabled");
    }        

    var speed = 150;

    item.slideToggle(speed, function()
    {
        targetList.scrollTo(0);
        
        item.detach();
        item.prependTo(targetList);
        Kmu.dmsRenumber();
        item.slideToggle(speed);
    });
}

/**
 * Renumber the selected items for all draggable multi-selects (dms) currently in the dom.
 * Most of the time, there will only be a single dms widget on the screen, so we just renumber
 * them all.
 */
Kmu.dmsRenumber = function()
{
    $(".dmsSelectedList").each(function(index)
    {
        var list = $(this);
        list.find(".dmsItemPriority").each(function(index)
        {
            var pri = $(this)
            pri.empty();
            pri.append("[" + (index+1) + "]");
        });
    });
}

