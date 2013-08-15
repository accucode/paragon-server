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
//** variables
//**********************************************************

/*
 * Used to manage page session state for apps.
 * Client side application scripts will generally NOT access
 * pageSession variables.  Instead, this state is used by
 * the server to coordinate application state without 
 * 
 */
Kmu.pageSession = {};

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
Kmu.blockDelayMs     = 350; 	

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
 */
Kmu.merge = function(a, b)
{
    var r = {};
    
    if ( a )
        for ( key in a )
            r[key] = a[key];
            
    if ( b )
        for ( key in b )
            r[key] = b[key];
    
    return r;
}


/**
 * Print the objects attributes onto the console.log.
 */
Kmu.logAttributes = function(o)
{
	if ( !o )
	    return;
	    
	for ( var e in o )
	    console.log(e + " => " + o[e]);
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
    $(sel).datepicker(
    {
        showOn: 'button',
        showAnim: 'slideDown',
        buttonImage: '/app/static/version/led-icons/calendar_1.png',
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
//** ajax
//**********************************************************

Kmu.ajaxEnter = function(params)
{
    Kmu.ajax(
    {
    	action: "_enter",
    	argument: params
    });
}

Kmu.ajaxNavigate = function()
{
    Kmu.ajax(
    {
    	action: "_navigate"
    });
}

/*
 * options
 *     form:        submit the fields from the optional form.
 *     action:      the action key, typically required.
 *     argument:    the optional argument (uses application specific encoding).
 *     extra:       the optional extra value (no encoding).
 *     block:       optionally block the ui component BEFORE the ajax request.
 */
Kmu.ajax = function(options)
{
   	var extra = {};
   	
   	var onSuccessArr = [];

    if ( options.form )
        extra._form = options.form;

    if ( options.action )
        extra._action = options.action;

    if ( options.argument )
        extra._argument = options.argument;

    if ( options.extra)
        extra._extraValue = options.extra;

    if ( options.block )
    {
      	var sel = options.block;
      	var delay = Kmu.blockDelayMs;
        Kmu.blockControlQuietly(sel, delay);
        
        var fn = function() { Kmu.unblockControl(sel); };
        onSuccessArr.push(fn);
    }
    else
    {
      	var delay = Kmu.blockDelayMs;
        Kmu.blockPageQuietly(delay);
        
        var fn = function() { Kmu.unblockPage(); };
        onSuccessArr.push(fn);
    }
    
    if ( Kmu.pageSession )
        extra._session = JSON.stringify(Kmu.pageSession);
        
    extra._windowLocation = window.location.href;

	var extraParams = $.param(extra);
	
	var formParams = '';
    if ( options.form )
    	formParams = $(options.form).serialize();

    var data;
	data = null;
	data = Kmu.appendParams(data, formParams);
	data = Kmu.appendParams(data, extraParams);

    onSuccessArr.push(Kmu.ajaxSuccess);

    $.ajax(
    {
    	type:   	'POST',
    	url: 		'/app/servlet/ajax',
    	data: 		data,
    	success: 	onSuccessArr,
    	error: 		Kmu.ajaxError,
    	complete: 	Kmu.ajaxComplete,
    	dataType: 	'json'
    });
}

Kmu.appendParams = function(prefix, suffix)
{
    if ( !prefix ) return suffix;
    if ( !suffix ) return prefix;
    
    return prefix + "&" + suffix;
}

Kmu.ajaxSuccess = function(result)
{
    eval(result.script);
}

Kmu.ajaxError = function(req, status, error)
{
    alert('Ajax error'
        + '\nStatus: ' + status
        + '\nError: ' + error
        );
}

/*
 * Called after success or error
 */
Kmu.ajaxComplete = function(jqXHR, textStatus)
{
}

//**********************************************************
//** page session
//**********************************************************

Kmu.updatePageSession = function(session)
{
    Kmu.pageSession = session;
}

Kmu.setPageSessionValue = function(key, value)
{
    Kmu.pageSession[key] = value;
}

Kmu.logPageSession = function()
{
    Kmu.logAttributes(Kmu.pageSession);
}

//**********************************************************
//** json commands
//**********************************************************

Kmu.jsonReplaceSimple = function(json)
{
    var inner = $(json.inner);
    var html  = $(json.html);

    inner.empty();
    
    if ( json.html )
        inner.append(json.html);
        
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
            inner.append(json.html);
            
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
            inner.append(json.html);
        
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
            inner.append(json.html);
            
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
    var filter = ":input:visible:enabled:first";
    
    if ( !sel )
    {
        // if no selector, focus first field on page.
    	$(filter).focus();
    	return;
    }

    // this only matches descendants; not the selector itself.
    var e = $(sel + " " + filter);

    if ( e.get(0) )
    {
        e.focus();
        return;
    }

    // if not matching child, then attempt to focus the selector itself.
    $(sel).focus();
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
    removeClassesWithPrefix(e, "button-element-");
    e.addClass("button-element-" + theme);
}

Kmu.disableButton = function(e)
{
    e = $(e);
    e.attr("disabled", "disabled");
    removeClassesWithPrefix(e, "button-element-");
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

    if ( html )
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
        $(selector).find('.filler').each(function()
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
            var filler = $(this).find('.filler');
            
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
