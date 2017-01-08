//**********************************************************
//**
//** A variety of utility methods.
//** Dependencies: jquery, kmExtensions
//**
//**********************************************************

jQuery.easing.def = "easeOutBounce";
jQuery.easing.def = "jswing";
jQuery.easing.def = "easeOutQuart";

var Kmu = {};

//**********************************************************
//** constants
//**********************************************************

/**
 * Used with the methods to open and close dialogs.
 */
Kmu.dialogOpenSpeed  = 300;
Kmu.dialogCloseSpeed = 100;

/**
 * Used to determine the automatic block delay.
 * Page content is automatically blocked during ajax requests.
 * If the ajax request takes longer than this, then shade the
 * screen to provide a visual indication to the user.
 */
Kmu.blockDelayMs     = 500;

/**
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
 * The ajax submits include this value each time a request is sent to the server.
 * This value may be null, though typically only for the very first request.
 */
Kmu.currentPageKey = null;

//**********************************************************
//** ajax
//**********************************************************

/**
 * options
 *      action
 *          Required string.
 *          The action key that identifies the server side function to execute.
 *
 *      form
 *          Optional string selector.
 *          Identifies the parameters to be submitted with this request.
 *
 *      argument
 *          Optional string.
 *          The server expects this to be encoded.
 *          See ScEncoder.
 *
 *      extra
 *          Optional string.
 *          If set, pass this value without any encoding.
 *
 *      block
 *          Optional string selector.
 *          If set, block the ui component BEFORE the ajax request.
 *          This should be a valid css selector.
 *
 *      confirmation
 *          Optional html string
 *          If set, prompt the user to confirm (Ok/Cancel) before submitting.
 *          Confirmation is handled with a simple jquery popup modal dialog.
 *          Confirmation is handled BEFORE the dirty check for change tracking.
 *
 *      direction
 *          Optional string (forward, back, refresh, unknown).
 *          If set indicates the navigation direction.
 *
 *      changeTracking
 *          Optional boolean.
 *          If true (the default) warn the user if there are any dirty fields.
 *
 *      changeScope
 *          Optional string selector.
 *          If set, changes are only checked inside this container.
 *          If not set, check the entire page.
 */
Kmu.ajax = function(options)
{
    var ajaxFn = function()
    {
        var onSuccessArr
        onSuccessArr = Kmu.initAjaxBlocking(options);
        onSuccessArr.push(Kmu.ajaxSuccess);

        var data = Kmu.formatAjaxData(options);

        // Assumes ROOT servlet context
        $.ajax(
        {
            type:       'POST',
            url:        '/servlet/ajax',
            dataType:   'json',
            data:       data,
            success:    onSuccessArr,
            error:      Kmu.ajaxError,
            complete:   Kmu.ajaxComplete
        });
    };

    var warnIfDirtyFn = function()
    {
        Kmu.warnIfDirty(
        {
            fn: ajaxFn,
            changeTracking: options.changeTracking,
            changeScope: options.changeScope
        });
    }

    if ( !options.confirmation )
        warnIfDirtyFn();
    else
        Kmu.confirmAndThen(options.confirmation.toString(), warnIfDirtyFn);
}


/**
 * Use a modal dialog to confirm that the user wants to continue.
 * If they say yes/ok, then run the supplied function.
 */
Kmu.confirmAndThen = function(htmlMsg, fn)
{
    // The dialog element is predefined in pageLayout.html.
    var dialog = $("#confirmDialog");
    $('#confirmDialogMessage').html(htmlMsg);

    dialog.dialog(
    {
        height: 200,
        modal: true,
        stack: true,
        resizable: false,
        draggable: false,
        closeOnEscape: false, // 'true' interferes with global event listeners.
        close: function()
        {
            $(this).dialog('destroy');
        },
        buttons:
        {
            "Continue": function()
            {
                $(this).dialog("close");
                fn();
            },
            "Cancel": function()
            {
                $(this).dialog("close");
            }
        }
    });

    dialog.parent().onEscape(function()
    {
        dialog.dialog('close');
    });
}

Kmu.initAjaxBlocking = function(options)
{
    var onSuccessArr = [];

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

    return onSuccessArr;
}

Kmu.formatAjaxData = function(options)
{
    var baseParams = Kmu.formatAjaxBaseParams(options)
    var formParams = Kmu.formatAjaxFormParams(options);

    return Kmu.joinAjaxParams(baseParams, formParams);
}

Kmu.formatAjaxBaseParams = function(options)
{
    var e;
    e = {};
    e._currentPageKey       = Kmu.currentPageKey;
    e._windowLocation       = window.location.href;

    e._isPageHeaderVisible  = $('#header').isVisible();
    e._isPageFooterVisible  = $('#footer').isVisible();
    e._isPageMenuVisible    = $('#menu').isVisible();
    e._isPageTitleVisible   = $('#title').isVisible();
    e._isPageContentVisible = $('#content').isVisible();

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

    var gs = KmNavigator.getGlobalSession();
    if ( gs )
        e._globalSession = gs;

    var ps = KmNavigator.getPageSession();
    if ( ps )
        e._session = ps;

    return $.param(e);
}

Kmu.formatAjaxFormParams = function(options)
{
    if ( !options.form )
        return null;

    return $('#' + options.form).serialize();
}

Kmu.joinAjaxParams = function(a, b)
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
    try
    {
        if ( result && result.script )
            eval(result.script);
    }
    catch ( ex )
    {
        alert("Cannot process ajax result...\n" + ex.message);
    }
}

Kmu.ajaxError = function(req, status, error)
{
    alert('Ajax Error'
        + '\nStatus: ' + status
        + '\nError: ' + error
        );
}

/**
 * Called after success or error
 */
Kmu.ajaxComplete = function(jqXHR, textStatus)
{
}

//**********************************************************
//** dialogs
//**********************************************************

/**
 * Use a modal dialog to display a message.
 */
Kmu.showNotice = function(htmlMsg)
{
    // The dialog element is predefined in pageLayout.html.
    var dialog = $("#noticeDialog");
    $('#noticeDialogMessage').html(htmlMsg);

    dialog.dialog(
    {
        height: 200,
        modal: true,
        stack: true,
        resizable: false,
        draggable: false,
        closeOnEscape: false, // 'true' interferes with global event listeners.
        close: function()
        {
            $(this).dialog('destroy');
        },
        buttons:
        {
            "Close": function()
            {
                $(this).dialog("close");
            }
        }
    });

    dialog.parent().onEscape(function()
    {
        dialog.dialog('close');
    });
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
 * In general, pass the default values first, and the overrides second.
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
 * Print the object's attributes to the console.log.
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
    console.log(s);
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

/**
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
}

/**
 * http://www.eyecon.ro/colorpicker/
 */
Kmu.installColorField = function(sel)
{
    var picker = $(sel).ColorPicker(
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
    });

    picker.bind('keyup', function()
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
    if ( !speed )
        speed = 250;

    // half for hide, half for show.
    speed = speed / 2;

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
    if ( !speed )
        speed = 250;

    // half for hide, half for show.
    speed = speed / 2;

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
    if ( !speed )
        speed = 250;

    // half for hide, half for show.
    speed = speed / 2;

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

Kmu.jsonReplaceFlip = function(json)
{
    var inner = $(json.inner);

    var outer = json.outer
        ? $(json.outer)
        : inner;

    outer.promise().done(function()
    {

        var easing   = jQuery.easing.def;
        var style    = outer.attr('style');

        var speed = json.speed;
        if ( !speed )
            speed = 250;

        // half for hide, half for show.
        speed = speed / 2;

        outer.transition(
        {
            rotateY:  90,
            duration: speed,
            easing:   easing
        });

        outer.promise().done(function()
        {
            outer.hide();

            inner.empty();
            if ( json.html )
                inner.html(json.html);

            if ( json.postDomScript )
                eval(json.postDomScript);

            outer.show();

            outer.promise().done(function()
            {
                outer.transition(
                {
                       rotateY:  0,
                       duration: speed,
                       easing:   easing
                });

                outer.promise().done(function()
                {
                    if ( json.postRenderScript )
                        eval(json.postRenderScript);

                    if ( style )
                        outer.attr('style', style);
                    else
                        outer.removeAttr('style');
                });
            });
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
//** https://github.com/js-cookie/js-cookie
//**********************************************************

/**
 * The the cookie value, may be empty string.
 * Return null if cookie does not exist.
 */
Kmu.getCookie = function(key)
{
    return Cookies.get(key);
}

/**
 * Set a cookie value that expires in one year.
 */
Kmu.setCookie = function(key, value)
{
    var options = { expires: 365 };
    Cookies.set(key, value, options);
}

/**
 * Set a cookie value that expires when the session ends.
 */
Kmu.setSessionCookie = function(key, value)
{
    Cookies.set(key, value);
}

/**
 * Return true if the cookie exists.
 */
Kmu.hasCookie = function(key)
{
    var e = Cookies.get(key);
    return e !== null && e !== undefined && e !== '';
}

/**
 * Clear the cookie.
 */
Kmu.clearCookie = function(key)
{
    // Set to empty string instead of null.
    // In some cases (e.g.: FF7) setting null doesn't work correctly.
    Kmu.setSessionCookie(key, '');
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

/**
 * The the select box options.
 */
Kmu.setSelectOptions = function(select, options)
{
       Kmu.clearSelectOptions(select);
       Kmu.addSelectOptions(select, options);
}

/**
 * Add an array of options.  The parameter must be an array.
 */
Kmu.addSelectOptions = function(select, options)
{
    for ( var i in options )
        Kmu.addSelectOption(select, options[i]);
}

/**
 * Add an option to the end of the select.
 * The parameter must have attributes for "text" and "value".
 */
Kmu.addSelectOption = function(select, o)
{
    Kmu.addSelectOptionTextValue(select, o.text, o.value);
}

/**
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

/**
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

/**
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

/**
 * Close the single modal dialog.
 * If no dialog is open, exit without an error.
 */
Kmu.closeDialog = function()
{
    $.modal.close();
}

/**
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

/**
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

/**
 * All of the args are optional; but you generally need to provide
 * either the url or the html.
 * args
 *     url:     The url to load in the new window.
 *     name:    The name of the new window.
 *     params:  A single string listing all of the window parameters.
 *     html:    The html to add to the window after it opens.
 *     print:   If true, attempt to print the window after it opens.
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

    var print = (args.print === true);
    if ( w && print )
        w.print();
}


//**********************************************************
//** block
//**********************************************************

/**
 * These methods are used to block user access to the page.
 * We commonly block access during ajax requests to minimize
 * confusion and provide clear ui feedback.
 *
 * http://jquery.malsup.com/block/
 */

/**
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


/**
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

/**
 * Clear the default css.  This allows the css to be defined
 * using the class .blockMsg in an external (themed) stylesheet.
 */
$.blockUI.defaults.css = {};

/**
 * The following can be used to automatically block the entire
 * page during ever ajax request.  However, this is not very
 * practical since 1) we prefer to block only the localized
 * area affected, and 2) I don't think this works reliably when
 * submitting multiple overlapping ajax requests.
 */
// $(document).ajaxStart($.blockUI).ajaxStop($.unblockUI);


//**********************************************************
//** flip
//**********************************************************

Kmu.flipHide = function(options)
{
    var selector = options.selector;
    var duration = options.duration;
    var easing = options.easing;

    var target = $(selector);

    target.transition(
    {
        rotateY: 90,
        duration: duration,
        easing: easing
    });

    target.promise().done(function()
    {
        target.hide();
    });
}

Kmu.flipShow = function(options)
{
    var selector = options.selector;
    var duration = options.duration;
    var easing = options.easing;

    var target = $(selector);

    target.show();

    target.transition(
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
 *         target
 *             A valid jquery selector, compatible with $(target).
 *             This is required.
 *
 *         attribute
 *             The name of the css attribute to modify.
 *             Defaults to "background-color".
 *
 *         value
 *             The value to which the attribute will be changed.
 *             Defaults to "yellow".
 *
 *         speed
 *             The speed at which the animation occurs.
 *             This is the total animation time, which is split between first changing
 *             to the new value, then changing back to the original value.
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
    e = $(e);
    var item      = e.closest(".dmsItem");
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
 * Most of the time, there will only be a single dms widget on the screen, so for simplicity
 * we just renumber them all.
 */
Kmu.dmsRenumber = function()
{
    $(".dmsSelectedList").each(function(listIndex, list)
    {
        list = $(list);
        list.find(".dmsItemPriority").each(function(itemIndex, item)
        {
            item = $(item)
            item.empty();
            item.append("[" + (itemIndex+1) + "]");
        });
    });
}


//**********************************************************
//** old/dirty value
//**********************************************************

Kmu.oldValueTargets = ["input", "textarea", "select"];

/**
 * Attempt to reset ALL controls on the PAGE to their original values.
 *
 * scope:
 *         Identifies the scope of the document to search for dirty values.
 *         If specified, this must be a valid selector.
 *         If null/undefined, check the entire page.
 */
Kmu.resetDirtyFields = function(scope)
{
    var arr = Kmu.oldValueTargets;
    var n = arr.length;
    for ( var i=0; i<n; i++ )
    {
        var target = arr[i];
        var elements = scope
            ? $(scope).find(target)
            : $(target);

        elements.each(function(i, e)
        {
            Kmu.resetDirtyField(e);
        });
    }
}

/**
 * Attempt to reset a SINGLE control to its original value.
 */
Kmu.resetDirtyField = function(e)
{
    e = $(e);
    var old;

    old = e.data('kmOldValue');
    if ( old !== undefined )
    {
        e.val(old);
        return;
    }

    old = e.data('kmOldChecked');
    if ( old !== undefined )
    {
        var checked = (old == true) || (old == 'true');
        e.prop('checked', checked);
        return;
    }
}

/**
 * Check all fields on the PAGE.
 *
 * If NONE of the fields have been changed, execute continueFn.
 *
 * If ANY of the fields have been changed, display a warning, then execute
 * continueFn if the user accepts the warning.
 *
 * Options
 *         fn:
 *             the no-arg function to run.
 *         changeTracking:
 *              A boolean that indicates if change tracking is enabled.
 *             If not enabled, run the function without any warnings.
 *             Defaults to true, if absent/null/undefined.
 *         changeScope:
 *             Identifies the scope of the document to search for dirty values.
 *             If specified, this must be a valid selector.
 *             If absent/null/undefined, check the entire page.
 */
Kmu.warnIfDirty = function(options)
{
    var fn              = options.fn;
    var skipWarning     = options.changeTracking === false;
    var scope           = options.changeScope;

    if ( skipWarning )
    {
        fn();
        return;
    }

    if ( !Kmu.hasDirtyValues(scope) )
    {
        fn();
        return;
    }

    // The dialog element is predefined in pageLayout.html.
    var dialog;
    dialog = $("#warnIfDirtyDialog");
    dialog.dialog(
    {
        height: 200,
        modal: true,
        stack: true,
        resizable: false,
        draggable: false,
        closeOnEscape: false, // 'true' interferes with global event listeners.
        close: function()
        {
            $(this).dialog('destroy');
        },
        buttons:
        {
            "Continue Without Saving": function()
            {
                $(this).dialog("close");
                Kmu.resetDirtyFields(scope);
                fn();
            },
            "Cancel": function()
            {
                $(this).dialog("close");
            }
        }
    });

    dialog.parent().onEscape(function()
    {
        dialog.dialog('close');
    });
}

/**
 * Check if any field on the page has a different value than its oldValue.
 * Return true if at least one changed field is found.
 *
 * scope
 *         If specified, search the contents of this selector.
 *         If null/undefined, search the entire page.
 *
 */
Kmu.hasDirtyValues = function(scope)
{
    var arr = Kmu.oldValueTargets;
    var n = arr.length;
    var dirty = false;

    for ( var i=0; i<n; i++ )
    {
        var target = arr[i];
        var elements = scope
            ? $(scope).find(target)
            : $(target);

        elements.each(function(i, e)
        {
            if ( Kmu.hasDirtyValue(e))
            {
                dirty = true;
                // console.log('Dirty: ' + $(e).attr('id'));
                return false; // return from the elements.each function
            }
        });

        if ( dirty )
            return true;
    }

    return false;
}

/**
 * Check a single field to determine if its value has changed.
 * Return true if the value has changed.
 */
Kmu.hasDirtyValue = function(e)
{
    e = $(e);
    var old;

    old = e.data('kmOldValue');
    if ( old !== undefined )
        return e.val() != old;

    old = e.data('kmOldChecked');
    if ( old !== undefined )
        return e[0].checked != (old == true);

    return false;
}

Kmu.showNoticeIfDirty = function(scope)
{
    var dirty = Kmu.hasDirtyValues(scope);
    if ( !dirty )
        return true;

    Kmu.showNotice(
        'You have unsaved changes.<br>' +
        'Save or cancel the changes before continuing.');
    return false;
}

/**
 * Set a single fields old value to the current value of the field.
 */
Kmu.updateOldValue = function(e)
{
    e = $(e);
    
    console.log(e);
    console.log(e.val());
    
    e.data('kmOldValue',e.val());
}

//**********************************************************
//** select text
//**********************************************************

/**
 * Select (highlight) the text in the specified element.
 */
Kmu.selectText = function(sel)
{
    var doc = document;
    var range;
    var selection;

    var text = $(sel)[0];
    if ( text === undefined )
        return;

    if ( doc.body.createTextRange )
    {
        range = document.body.createTextRange();
        range.moveToElementText(text);
        range.select();

    }
    else if ( window.getSelection )
    {
        selection = window.getSelection();
        range = document.createRange();
        range.selectNodeContents(text);
        selection.removeAllRanges();
        selection.addRange(range);
    }
}

/**
 * Deselect (un-highlight) the selected text.
 */
Kmu.deselect = function()
{
    // Chrome
    if (window.getSelection && window.getSelection().empty)
    {
        window.getSelection().empty();
        return;
    }

    // Firefox
    if (window.getSelection && window.getSelection().removeAllRanges)
    {
        window.getSelection().removeAllRanges();
        return;
    }

    // IE?
    if (document.selection)
    {
        document.selection.empty();
        return;
    }
}

/**
 * Select and copy the text with an element.
 * E.g.: copy the text within a DIV element.
 * To copy the text in a field use selectAndCopyField.
 */
Kmu.selectAndCopyText = function(sel)
{
    Kmu.selectText(sel);
    Kmu.copyToClipboard();
    Kmu.deselect();
}

/**
 * Select and copy the text with an input field.
 * To copy the text in a div selectAndCopyText.
 */
Kmu.selectAndCopyField = function(sel)
{
    $(sel).select();
    Kmu.copyToClipboard();
    // Kmu.deselect();
}


/**
 * Use execCommand to ask the browser to copy the current selection
 * to the clipboard.  This return true/false to indicate success.
 */
Kmu.copyToClipboard = function()
{
    try
    {
        return document.execCommand('copy');
    }
    catch ( err )
    {
        console.log("Error on copy, " + err.message);
        return false;
    }
}


//**********************************************************
//** screen capture
//**********************************************************

/**
 * Capture the entire screen as a base64 encoded PNG image.
 * Image converation is performed asynchronously; when done,
 * the thenFn function is called with the base64 string as its
 * sole parameter.
 *
 * This requires the html2canvas library.
 * The rendering is not perfect but should be good enough to
 * help with troubleshooting.
 *
 * options
 *     source
 *         The jquery/css selector that identify the source element
 *         to be capture.  If not specified, this defaults to 'body'.
 *
 *     targetUrlField
 *         If set, the field is assumed to be compatible with $().val()
 *         and the field's value is set to the png image url.
 *
 *     targetBase64Field
 *         If set, the field is assumed to be compatible with $().val()
 *         and the field's value is set to the base64 encoded png image.
 *
 *     targetImage
 *         If set, the image is updated with the captured png.
 *
 *     thenBase64Fn
 *         If set, this function is called with the base64 encoded PNG string.
 */
Kmu.screenCapture = function(options)
{
    var defaults =
    {
        source: 'body'
    };

    var values = Kmu.merge(defaults, options);
    var source = $(values.source)[0];

    html2canvas(source,
    {
        onrendered: function(canvas)
        {
            var mime = 'image/png';
            var url = canvas.toDataURL(mime);

            var marker = 'base64,';
            var i = url.indexOf(marker);

            var base64 = null;
            if ( i >= 0 )
                base64 = url.substring(i + marker.length);

            if ( values.targetUrlField )
                $(values.targetUrlField).val(url);

            if ( values.targetBase64Field )
                $(values.targetBase64Field).val(base64);

            if ( values.targetImage )
                $(values.targetImage).attr("src", url);

            if ( values.thenBase64Fn )
                values.thenBase64Fn(base64);
        }
    });
}

//**********************************************************
//** calendar
//**********************************************************

/**
 * Request event data from the server via ajax.
 */
Kmu.calendarGetAjaxData = function(calendar, form)
{
    var result = {};

    if ( form )
    {
        var arr = form.serializeArray();
        var n = arr.length;
        for ( var i=0; i<n; i++ )
        {
            var e = arr[i];
            result[e.name] = e.value;
        }
    }

    var gs = KmNavigator.getGlobalSession();
    if ( gs )
        result._globalSession = gs;

    var ps = KmNavigator.getPageSession();
    if ( ps )
        result._session = ps;

    return result;
}


/**
 * Notify the server that the user selected a region on the calendar.
 * This is typically used to create a new event.
 *
 * Use the standard action/action mechanism to pass the event details
 * in the 'extra' parameter.
 *
 * See ScCalendar.java
 */
Kmu.ajaxCalendarSelect = function(start, end, ajaxOptions)
{
    var e =
    {
        eventStart: start.valueOf(),
        eventEnd:   end.valueOf()
    }

    ajaxOptions.extra = JSON.stringify(e);
    Kmu.ajax(ajaxOptions);
}

/**
 * Notify the server that the user clicked (or moved) on an existing event.
 *
 * Use the standard action/action mechanism to pass the event details
 * in the 'extra' parameter.
 *
 * See ScCalendar.java
 */
Kmu.ajaxCalendarEvent = function(event, ajaxOptions)
{
    var eventEnd = null;
    if ( event.end )
        eventEnd = event.end.valueOf();

    var e =
    {
        eventUid:               event.id,
        eventTitle:             event.title,
        eventStart:             event.start.valueOf(),
        eventEnd:               eventEnd,
        eventAllDay:            event.allDay,
        eventCssName:           event.className,
        eventTextColor:         event.textColor,
        eventBackgroundColor:   event.backgroundColor,
        eventBorderColor:       event.backgroundColor
    };

    ajaxOptions.extra = JSON.stringify(e);
    Kmu.ajax(ajaxOptions);
}

/**
 * This is used to update existing calendar events.
 * Removing and re-adding event with the same id can cause issues.
 */
Kmu.calendarUpdateEvent = function(calendar, event)
{
    var e = calendar.fullCalendar('clientEvents', event.id)[0];
    var exists = !!e;

    if ( !exists )
        e = {};

    e.id     = event.id;
    e.title  = event.title;
    e.start  = event.start;
    e.end    = event.end;
    e.allDay = event.allDay;
    e.color  = event.color;

    if ( exists )
        calendar.fullCalendar('updateEvent', e);
    else
        calendar.fullCalendar('addEventSource', [e]);
}

//**********************************************************
//** choice field
//**********************************************************

/**
 * This is used to hide a single option in the choice field.
 * This also automatically disables the option so it cannot be
 * selected.  See ajaxHideOption() in ScChoiceField.java
 */
Kmu.hideChoiceByValue = function(parent, val)
{
    var choice = Kmu.findChoiceByValue(parent, val);
    var optionId = choice.attr("id");
    var label = Kmu.findLabelForChoice(parent, optionId);

    label.hide();
    choice.attr('disabled', true);
    $(parent).buttonset();
}

/**
 * This is used to show a single option in the choice field.
 * This also automatically enables the option so it can be
 * selected again.  See ajaxHideOption() in ScChoiceField.java
 */
Kmu.showChoiceByValue = function(parent, val)
{
    var choice = Kmu.findChoiceByValue(parent, val);
    var optionId = choice.attr("id");
    var label = Kmu.findLabelForChoice(parent, optionId);

    label.show();
    choice.removeAttr('disabled');
    $(parent).buttonset();
}

/**
 * This is used to disable a single option in the choice field.
 * See ajaxHideOption() in ScChoiceField.java
 */
Kmu.disableChoiceByValue = function(parent, val)
{
    var choice;
    choice = Kmu.findChoiceByValue(parent, val);
    choice.attr('disabled', true);

    $(parent).buttonset();
}

/**
 * This is used to enable a single option in the choice field.
 * See ajaxHideOption() in ScChoiceField.java
 */
Kmu.enableChoiceByValue = function(parent, val)
{
    var choice;
    choice = Kmu.findChoiceByValue(parent, val);
    choice.removeAttr('disabled');

    $(parent).buttonset();
}

/**
 * This is used to make change tracking work for choice fields.  It
 * updates the hidden field with the selected value.
 */
Kmu.updateChoiceHiddenField = function(parent)
{
    var sel = parent + " > input:radio:checked";
    var value = $(sel).val();
    var hidden = parent + " > :hidden";

    $(hidden).val(value);
}

Kmu.findChoiceByValue = function(parent, val)
{
    var sel = parent + " > input[value='" + val + "']";
    return $(sel);
}

Kmu.findLabelForChoice = function(parent, choiceId)
{
    var sel = parent + " > label[for='" + choiceId + "']";
    return $(sel);
}


//**********************************************************
//** set checked by name
//**********************************************************

/**
 * Find any checkbox that match the specified name,
 * then set their checked state.
 *
 * options...
 * name: the name of the checkbox(es) to be updated.
 * value: the (optional) value of the checkbox(es) to be updated.
 * changeTracking: determine if change tracking is enabled
 * checked: sets the checkbox(es) to be checked or unchecked.
 *
 * $("input[name='NAME']").filter("input[value='VALUE']")[0].checked = CHECKED;
 */
Kmu.setCheckedByName = function(options)
{
    var nameSel = "input[name='" + options.name + "']";
    var v = $(nameSel);

    if ( options.value )
    {
        var valueSel = "input[value='" + options.value + "']";
        v = v.filter(valueSel);
    }

    v.each(function()
    {
        this.checked = options.checked;

        if ( options.changeTracking )
            $(this).data("km-old-checked", options.checked);
    });
}

//**********************************************************
//** encode utf8
//**********************************************************

/**
 * Encode a string to utf8.
 * http://ecmanaut.blogspot.ca/2006/07/encoding-decoding-utf8-in-javascript.html
 */
Kmu.encodeUtf8 = function(s)
{
    return unescape(encodeURIComponent(s));
}

/**
 * Decode a string from utf8.
 * http://ecmanaut.blogspot.ca/2006/07/encoding-decoding-utf8-in-javascript.html
 */
Kmu.decodeUtf8 = function(s)
{
    return decodeURIComponent(escape(s));
}

//**********************************************************
//** ckeditor (html editor)
//**********************************************************

/**
 * Attempt to resize a ckeditor to fill its parent.
 * This was tested with version 4.5.8.
 * This overrides the style properties with a combination
 * of absolute and flexbox layouts, applied to the nested
 * elements of the ckeditor.
 */
Kmu.ckEditorFill = function(textAreaId)
{
    var ckeSel = '#cke_' + textAreaId;

    var cke      = $(ckeSel);
    var inner    = $(ckeSel + ' > .cke_inner');
    var top      = $(ckeSel + ' > .cke_inner > .cke_top');
    var contents = $(ckeSel + ' > .cke_inner > .cke_contents');
    var iframe   = $(ckeSel + ' > .cke_inner > .cke_contents > iframe');

    if ( cke.size() != 1 )
    {
        console.log('ckEditorFill, cannot find cke.');
        return;
    }

    if ( inner.size() != 1 )
    {
        console.log('ckEditorFill, cannot find inner.');
        return;
    }

    if ( top.size() != 1 )
    {
        console.log('ckEditorFill, cannot find top.');
        return;
    }

    if ( contents.size() != 1 )
    {
        console.log('ckEditorFill, cannot find contents.');
        return;
    }

    if ( iframe.size() != 1 )
    {
        console.log('ckEditorFill, cannot find iframe.');
        return;
    }

    var s;

    // cke
    s = '';
    s = s + 'display: block;';
    s = s + 'position:absolute; left:0; right:0; top:0; bottom:0;';
    cke.prop('style', s);

    // inner
    s = '';
    s = s + 'position:absolute; left:0; right:0; top:0; bottom:0;';
    s = s + 'display: flex; flex-direction: column;';
    inner.prop('style', s);

    // top
    s = '';
    s = s + 'flex-grow:0; flex-shrink:0;';
    top.prop('style', s);

   // content
    s = '';
    s = s + 'flex-grow:1; flex-shrink:1;';
    s = s + 'display: flex; flex-direction: column;';
    contents.prop('style', s);

    // iframe
    s = '';
    s = s + 'flex-grow:1; flex-shrink:1;';
    iframe.prop('style', s);
}

Kmu.ckEditorSetValue = function(target, value, updateOldValue)
{
    var e = target;
    
    if ( updateOldValue )
        e.val(value).done(function() 
        {
            e.data('kmOldValue',e.val())
        });
    else
        e.val(value);
}

//**********************************************************
//** help tooltip
//**********************************************************

/**
 * Install custom popup tooltips for application help messages.
 * Although the tooltip is install on the entire document, it
 * uses a custom content function to limit its use to elements
 * that have the 'helpTooltip' class.
 */
Kmu.initTooltip = function()
{
    $(document).tooltip(
    {
        content: function(callback)
        {
            var e = $(this);
            if ( e.hasClass('helpTooltip') )
                callback(e.attr('title'));
        },
        tooltipClass: 'helpTooltipPopup',
        position:
        {
            my: "left+5 top",
            at: "right center",
            collision: "flipfit"
        }
    });
}

//**********************************************************
//** popup
//**********************************************************

/**
 * Reset ALL popup menus.
 */
Kmu.resetPopups = function()
{
    var sel = '.popupContent';
    $(sel).hide();
    setTimeout(function() { $(sel).css('display', '') }, 0);
}

//**********************************************************
//** css menu
//**********************************************************

/**
 * Close the top navigation menu.
 * The menu is a simple css menu that opens on hover,
 * so we manually force it to hide, then reshow it.
 */
Kmu.closeMenu = function()
{
    var sel = '.menu ul ul';
    $(sel).hide();
    setTimeout(function() { $(sel).show() }, 0);
}

//**********************************************************
//** math
//**********************************************************

/**
 * Round the value to the requested number of decimal places.
 * Return a NUMBER which although correctly rounded, may display fewer decimal places.
 */
Kmu.roundTo = function(value, places)
{
    var t = Math.pow(10, places);
    return (Math.round((value * t)
        + (places>0?1:0) * (Math.sign(value) * (10 / Math.pow(100, places)))) / t);
}

/**
 * Round the value to the requested number of decimal places.
 * Return a STRING formatted to the requested decimal places.
 */
Kmu.roundPrecise = function(value, places)
{
    return Kmu.roundTo(value, places).toFixed(places);
}

//**********************************************************
//** math
//**********************************************************

/**
 * Adjust the tab book's overlay to match the specified tab.
 */
Kmu.adjustTabBookOverlay = function(overlaySel, tabSel)
{
    var borderWidth = $(tabSel).css('border-left-width');
    var tabPosition = 'left+' + borderWidth + ' bottom';
    var tabWidth    = $(tabSel).innerWidth();

    var e;
    e = $(overlaySel);
    e.innerWidth(tabWidth);
    e.position(
    {
        my: 'left top',
        at: tabPosition,
        of: tabSel,
        collision: 'none'
    });
}
