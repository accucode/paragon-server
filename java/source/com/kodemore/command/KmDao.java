package com.kodemore.command;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import com.kodemore.utility.Kmu;

/**
 * I provide convenience methods to facilitate the running of dao commands
 * with lambdas.
 *
 * You can run methods with 1 or 2 parameters (or none).
 * You can run methods that fetch a result (or not).
 * You can run with multiple optimistic retries (or not).
 *
 * review_ryan (wyatt): lambda utility
 *      Ryan, I added this utility class.
 *      Browser callers to see examples.
 */
public abstract class KmDao
{
    //##################################################
    //# run()
    //##################################################

    public static void run(Runnable r)
    {
        _run(r, getDefaultRetries());
    }

    public static void runNoRetry(Runnable r)
    {
        _run(r, 0);
    }

    //==================================================
    //= run(a)
    //==================================================

    public static <A> void run(Consumer<A> con, A a)
    {
        run(Kmu.toRunnable(con, a));
    }

    public static <A> void runNoRetry(Consumer<A> con, A a)
    {
        runNoRetry(Kmu.toRunnable(con, a));
    }

    //==================================================
    //= run(a, b)
    //==================================================

    public static <A, B> void run(BiConsumer<A,B> con, A a, B b)
    {
        run(Kmu.toRunnable(con, a, b));
    }

    public static <A, B> void runNoRetry(BiConsumer<A,B> con, A a, B b)
    {
        runNoRetry(Kmu.toRunnable(con, a, b));
    }

    //##################################################
    //# fetch() => r
    //##################################################

    /**
     * Fetch the result, using the default retry count.
     */
    public static <R> R fetch(Supplier<R> sup)
    {
        return _fetch(sup, getDefaultRetries());
    }

    public static <R> R fetchOnce(Supplier<R> sup)
    {
        return _fetch(sup, 0);
    }

    //==================================================
    //= fetch(a) => r
    //==================================================

    public static <A, R> R fetch(Function<A,R> fn, A a)
    {
        return fetch(Kmu.toSupplier(fn, a));
    }

    public static <A, R> R fetchNoRetry(Function<A,R> fn, A a)
    {
        return fetchOnce(Kmu.toSupplier(fn, a));
    }

    //==================================================
    //= fetch(a, b) => r
    //==================================================

    public static <A, B, R> R fetch(BiFunction<A,B,R> fn, A a, B b)
    {
        return fetch(Kmu.toSupplier(fn, a, b));
    }

    public static <A, B, R> R fetchNoRetry(BiFunction<A,B,R> fn, A a, B b)
    {
        return fetchOnce(Kmu.toSupplier(fn, a, b));
    }

    //##################################################
    //# support
    //##################################################

    private static void _run(Runnable r, int retryCount)
    {
        KmDaoRunnableCommand cmd;
        cmd = new KmDaoRunnableCommand(r);
        cmd.setStaleObjectRetryCount(retryCount);
        cmd.run();
    }

    private static <R> R _fetch(Supplier<R> sup, int retryCount)
    {
        KmDaoSupplierCommand<R> cmd;
        cmd = new KmDaoSupplierCommand<>(sup);
        cmd.setStaleObjectRetryCount(retryCount);
        cmd.run();
        return cmd.getResult();
    }

    private static int getDefaultRetries()
    {
        return KmDaoBridge.getInstance().getStaleObjectRetryCount();
    }
}
