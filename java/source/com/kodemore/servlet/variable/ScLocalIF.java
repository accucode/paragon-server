package com.kodemore.servlet.variable;

import com.kodemore.servlet.ScEncodedValueIF;
import com.kodemore.servlet.ScObjectValueIF;

/**
 * I am used to manage thread safe values.
 * I am specifically designed to work in conjuction with the Sc framework
 * and the ScServletData request/response.
 *
 * Locals manage three layered states: default, session, local.
 *
 * Default Values
 * The default values are values which are automatically shared by all
 * threads for all http requests.  Defaults are typically set (implicitly)
 * during vm startup and downstread of page.createRoot().
 *
 * Session
 * The [Page] Session refers to the user's long running interaction with
 * the application.  The session spans many threads across many http
 * request / response cycles.
 *
 * Local
 * The [Thread] Local refers to the context within a specific thread.
 * The value used by one thread should not be used or even visible
 * to any other thread.  Modification of the value in one thread must
 * not affect that values of any other threads.  Reuse of the same thread
 * due to thread pooling should be treated as separate threads.  Care
 * must be taken in the framework to ensure there is no bleed over due
 * to thread pooling.  Due to the specialized usage of the ScLocal, a
 * thread can generally be considered synonomous with a single http
 * request/response cycle.   The thread begins at at the top of the servlet's
 * doPost (or doGet) and ends when the doPost method ends.  When setting
 * values during aPage.preRender, you are running inside an http request
 * and therefore the values set are local to that thread and do not affect
 * any other threads.
 *
 */
public interface ScLocalIF
    extends ScObjectValueIF, ScEncodedValueIF
{
    //##################################################
    //# accessing
    //##################################################

    /**
     * Generally, all subclasses will implement getValue() and setValue()
     * methods to access the wrapped value in a type safe manner.
     * However, due to the use of generics and such, there is no
     * clean way to declare this formally in the interface.
     *
     * There are non-typed accessors for get/setObjectValue if
     * you need to manipulate values in a non-type safe manner
     * against this interface.
     *
     * NOTE: The set method's function differs depending on whether
     * the current thread is running inside an http request.
     * I.e.: there is an accessible ScServletData instance.
     *
     * If there is NO available http request, then set() should
     * set the local's default value, which is subsequently
     * shared by all thread and all http requests.  Since all pages
     * are created prior to processing any http requests, this applies
     * to all locals created and configured downstread of aPage.createRoot().
     *
     * On the other hand, if set() is called inside of an http request,
     * then the value set must NOT affect the default, as this would
     * cause undesired side-effects for other threads.  The value
     * set only affects that thread.  Furthermore the value is discarded
     * at the end of the http response, unless the local is saved, in
     * which cases it will be available for subsequent threads/requests
     * that are part of the same session; but still not visible to other
     * sessions.
     *
     * <type> get();
     * void set(<type> e);
     */

    //##################################################
    //# load / save
    //##################################################

    /**
     * Save the local state into the page session.
     * This will make the value persistent until the users session ends.
     * Clients may call this safely but should rarely need to.
     * It is fairly common to save values for use throughout a session
     * but this is normally managed by enabling the local to autoSave
     * its values rather than by calling explicitly save each time.
     */
    void saveValue();

    /**
     * Reset the local state to the default value.  NOTE: this does not
     * save the state.  So if you have previously saved a modified version
     * of the state, then resetting will only reset for the current thread.
     * If you want to reset the values permanantly for this session, you
     * must call save() after reset().
     */
    void resetValue();

    //##################################################
    //# auto-save
    //##################################################

    /**
     * When auto-save is enabled, any modification to the local state
     * will automatically, and immediately be saved into the session.
     * Auto-save is disabled by default.  If you want to enable it
     * you must do so during the vm start up, before any http requests
     * are processed.
     */
    boolean getAutoSave();

    /**
     * Enable auto-save for this local.  Once enabled, this cannot be
     * disabled.  If used, this must be called prior to any http requests,
     * typically downstream of MyInstaller.install(), or ScPage.createRoot().
     */
    void setAutoSave();

    //##################################################
    //# ObjectValueIF
    //##################################################

    /**
     * Get the value.
     * Intended for use only when the type specific value cannot be used.
     * Most of the time, clients should use the shorter, typed, get() method.
     */
    @Override
    Object getObjectValue();

    /**
     * Set the value.
     * Intended for use only when the type specific value cannot be used.
     * Most of the time, clients should use the shorter, typed, set() method.
     */
    @Override
    void setObjectValue(Object e);

    //##################################################
    //# EncodedValueIF
    //##################################################

    /**
     * Get an encodable value.
     */
    @Override
    Object getEncodableValue();

    /**
     * Set an encodable value.
     */
    @Override
    void setEncodableValue(Object e);
}
