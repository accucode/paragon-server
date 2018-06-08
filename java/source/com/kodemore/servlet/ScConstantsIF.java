/*
  Copyright (c) 2005-2018 www.kodemore.com

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in
  all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  THE SOFTWARE.
*/

package com.kodemore.servlet;

import java.nio.charset.Charset;

import com.kodemore.log.KmLogger;
import com.kodemore.servlet.utility.ScEasing;
import com.kodemore.utility.KmVirtualOptions;
import com.kodemore.utility.Kmu;

/**
 * I provide a common location for constants used by this package.
 */
public interface ScConstantsIF
{
    //##################################################
    //# loggers
    //##################################################

    KmLogger ScPerformanceLogger = KmLogger.create("com.kodemore.servlet.performance");

    //##################################################
    //# charsets
    //##################################################

    /**
     * The charset we use for the web pages.
     *
     * This must match...
     * web.xml; the charsetFilter.
     * pageLayout.html; the head/meta tag.
     * index.html; the head/meta tag.
     */
    Charset WEB_CHARSET = Charset.forName("UTF-8");

    /**
     * The charset we use in the database.
     * This is primarily here for reference - we don't use it directly.
     * ISO-8859-1 == Latin1
     */
    Charset DATABASE_CHARSET = Charset.forName("ISO-8859-1");

    //##################################################
    //# path
    //##################################################

    /**
     * The relative path to static content under the web directory.
     * This is used both for "file" paths, and for "url" paths.
     * This should identify the directory (if any) that appears
     * immediately under the "web" directory.   This provides a
     * hook for url rewriting in production, to better manage
     * client side caching.
     */
    String WEB_STATIC_PATH = "static/version";

    //##################################################
    //# parameters
    //##################################################

    /**
     * Some implementations of browsers or servlet engines
     * may not correctly remove cookies upon request so we
     * set the cookie value to well known value that we later
     * check for in getCookies().
     */
    String REMOVED_COOKIE_VALUE = "[[#REMOVED#]]";

    String PARAMETER_PAGE_SESSION = "_session";

    /**
     * The action key.
     */
    String PARAMETER_ACTION = "_action";

    /**
     * The argument, encoded using ScEncoder.
     */
    String PARAMETER_ARGUMENT = "_argument";

    /**
     * An alternate value that is not encoded.  We use
     * the PARAMETER_ARGUMENT most of the time, but use
     * the this extra unencoded value for special cases
     * where encoding is not appropriate.
     */
    String PARAMETER_EXTRA_VALUE = "_extraValue";

    /**
     * The application version associated with the client side
     * javascript/html that sent the HTTP request.
     */
    String PARAMETER_APPLICATION_VERSION = "_applicationVersion";

    /**
     * The browser window's current url is commonly included
     * in ajax submits since it may contain pertinent information
     * such as the 'hash' suffix.
     */
    String PARAMETER_WINDOW_LOCATION = "_windowLocation";

    /**
     * Indicates if the page header side is visible.
     */
    String PARAMETER_IS_PAGE_HEADER_VISIBLE = "_isPageHeaderVisible";

    /**
     * Indicates if the page footer is visible.
     */
    String PARAMETER_IS_PAGE_FOOTER_VISIBLE = "_isPageFooterVisible";

    /**
     * Indicates if the top menu is visible.
     */
    String PARAMETER_IS_PAGE_MENU_VISIBLE = "_isPageMenuVisible";

    /**
     * Indicates if the page title is visible.
     */
    String PARAMETER_IS_PAGE_TITLE_VISIBLE = "_isPageTitleVisible";

    /**
     * Indicates if the page title is visible.
     */
    String PARAMETER_IS_PAGE_CONTENT_VISIBLE = "_isPageContentVisible";

    /**
     * The token of the form that was submitted.
     */
    String PARAMETER_FORM_TOKEN = "_formToken";

    /**
     * The key used to identify the requested page.
     */
    String PARAMETER_REQUESTED_PAGE_KEY = "page";

    /**
     * The key used to identify the current page.
     * This is the page currently rendered in the browser.
     */
    String PARAMETER_CURRENT_PAGE_KEY = "_currentPageKey";

    /**
     * The navigation direction, if known.
     * Values: forward, back, refresh, unknown.
     */
    String PARAMETER_DIRECTION = "_direction";

    //##################################################
    //# session keys
    //##################################################

    String TRANSIENT_KEY_PREFIX  = "T";
    String PERSISTENT_KEY_PREFIX = "P";

    //##################################################
    //# misc
    //##################################################

    String SUBMIT_IMAGE_NAME = "_submitImage";

    String GENERAL_ERROR_MESSAGE = "Please correct the errors below.";

    //##################################################
    //# events
    //##################################################

    String EVENT_KEY_DOWN  = "keydown";
    String EVENT_KEY_UP    = "keyup";
    String EVENT_KEY_PRESS = "keypress";

    String EVENT_CLICK      = "click";
    String EVENT_MOUSE_DOWN = "mousedown";
    String EVENT_MOUSE_UP   = "mouseup";

    String EVENT_MOUSE_MOVE = "mousemove";
    String EVENT_MOUSE_OVER = "mouseover";
    String EVENT_MOUSE_OUT  = "mouseout";

    String EVENT_CHANGE = "change";
    String EVENT_SELECT = "select";

    String EVENT_FOCUS = "focus";
    String EVENT_BLUR  = "blur";

    //##################################################
    //# layout
    //##################################################

    Integer DEFAULT_PADDING = 10;

    //##################################################
    //# animations
    //##################################################

    ScEasing DEFAULT_EASING      = ScEasing.easeInOutCirc;
    ScEasing DEFAULT_HIDE_EASING = ScEasing.easeInCirc;
    ScEasing DEFAULT_SHOW_EASING = ScEasing.easeOutCirc;
    Integer  DEFAULT_SPEED_MS    = 150;

    //##################################################
    //# actions
    //##################################################

    /**
     * Used to identify the special action where the application prints the
     * page identified by the text in the window location.  That is, the location
     * identified by the url bar at the top of the browser window.
     */
    String ACTION_PRINT_WINDOW_LOCATION = "_printWindowLocation";

    //##################################################
    //# data attributes
    //##################################################

    /**
     * The attribute key used to identify editable/revertable field values.
     * Client side javascript is used to test if the field's value has changed.
     * Fields with this attribute must be compatible with...
     *      $('#field').val();
     *      $('#field').val(oldValue);
     */
    String DATA_ATTRIBUTE_OLD_VALUE = "km-old-value";

    /**
     * The attribute key used to identify editable/revertable field values.
     * Client side javascript is used to test if the field's value has changed.
     * Fields with this attribute must be compatible with:
     *      $('#field')[0].checked;
     *      $('#field')[0].checked = (oldValue == 'true');
     *
     */
    String DATA_ATTRIBUTE_OLD_CHECKED = "km-old-checked";

    //##################################################
    //# null prefix
    //##################################################

    String NULL_PREFIX_BLANK   = "";
    String NULL_PREFIX_ALL     = KmVirtualOptions.format("all");
    String NULL_PREFIX_ANY     = KmVirtualOptions.format("any");
    String NULL_PREFIX_DEFAULT = KmVirtualOptions.format("default");
    String NULL_PREFIX_NONE    = KmVirtualOptions.format("none");
    String NULL_PREFIX_UNKNOWN = KmVirtualOptions.format("unknown");
    String NULL_PREFIX_SELECT  = KmVirtualOptions.format("select");

    //##################################################
    //# auto complete
    //##################################################

    /**
     * Web sites generally enable autocompletion, but for web APPs it
     * often makes more sense to disable autocompletion.
     *
     * For values that need to be frequently re-entered, some type of
     * pick-from-list may be more appropriate than autocompletion.
     * Pick-from-list ensures that the data is actually consistent.
     * Also, using a pick-from-list allows the value to be changed in
     * a consistent manner if that is needed at a later time.
     *
     * Additionally, our apps often include fields that are entered
     * via a keyboard wedge and barcode scanner.  Autocompletion on
     * such fields can result in confusing results when autocompletion
     * changes the value without the user realizing it.
     *
     * Enabling autocompletion by default is not necessarily 'wrong'
     * but should be carefully considered as it has historically caused
     * a variety of problems for our applications.
     */
    boolean DEFAULT_AUTO_COMPLETE = false;

}
