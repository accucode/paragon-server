package com.kodemore.lock;

public interface KmLockIF
{
    /**
     * Return the key that uniquely identifies this lock.  Only one
     * client in the installation should be allowed to acquire a given
     * lock at a given time.
     */
    String getKey();

    /**
     * Determine if this is my key.
     */
    boolean hasKey(String s);

    /**
     * Attempt to lock the specified key.  Return true if the lock succeeds
     * or false if the lock is unavailable.  A generic RuntimeException is
     * throw for low level errors; e.g.: cannot get a db connection, or
     * invalid sql syntax.
     */
    boolean lock();

    /**
     * This is like the lock() except that instead of returning a false
     * value to indicate an unavailable lock, the KmLockFailureException
     * is throw with the requested key.  Generic RuntimeExceptions may also
     * still be thrown for the same causes as lock().
     */
    void lockFailing();

    /**
     * Determine if I current have a lock on my key.
     */
    boolean isLocked();

    /**
     * Unlock my key, allowing other clients to lock it.
     */
    void unlock();

    /**
     * Release any resource (such as a db connection) that I may hold.
     * I also unlock my key, if currently locked.
     */
    void release();
}
