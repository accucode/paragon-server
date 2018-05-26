package com.app.model.transfer;

import java.io.Writer;
import java.util.Collection;

import com.kodemore.collection.KmList;
import com.kodemore.domain.KmDomainIF;
import com.kodemore.exception.KmApplicationException;
import com.kodemore.io.KmIndentPrintWriter;
import com.kodemore.servlet.utility.ScFormatter;
import com.kodemore.utility.Kmu;

import com.app.dao.base.MyDaoAccess;
import com.app.model.MyProject;
import com.app.model.MyTenant;
import com.app.model.transfer.detail.MyTransferAbstractDetail;
import com.app.utility.MyGlobals;

public abstract class MyTransfer
{
    //##################################################
    //# instance creation
    //##################################################

    public static MyTransferRoot create()
    {
        return new MyTransferRoot();
    }

    //##################################################
    //# variables
    //##################################################

    private KmList<MyTransferAbstractDetail<?>> _details;

    //##################################################
    //# constructor
    //##################################################

    public MyTransfer()
    {
        _details = new KmList<>();
    }

    //##################################################
    //# tree
    //##################################################

    public abstract MyTransfer getParent();

    public abstract MyTransferRoot getRoot();

    public boolean isRoot()
    {
        return getParent() == null;
    }

    public int getDepth()
    {
        return isRoot()
            ? 1
            : getParent().getDepth() + 1;
    }

    //==================================================
    //= tree :: convenience
    //==================================================

    public MyProject getTargetProject()
    {
        return getRoot().getTargetProject();
    }

    public MyTenant getTargetTenant()
    {
        return getTargetProject().getTenant();
    }

    public boolean getIncludeBasicTimestamps()
    {
        return getRoot().getIncludeBasicTimestamps();
    }

    //##################################################
    //# map
    //##################################################

    protected <E> void map(E from, E to)
    {
        getRoot().map(from, to);
    }

    protected <E> E map(E from)
    {
        return getRoot().map(from);
    }

    //##################################################
    //# updated
    //##################################################

    protected void setUpdated(Object e)
    {
        getRoot().setUpdated(e);
    }

    protected boolean isUpdated(Object e)
    {
        return getRoot().isUpdated(e);
    }

    //##################################################
    //# details
    //##################################################

    public KmList<MyTransferAbstractDetail<?>> getDetails()
    {
        return _details;
    }

    protected void addDetail(MyTransferAbstractDetail<?> e)
    {
        e._setParent(this);
        _details.add(e);
    }

    //##################################################
    //# transfer
    //##################################################

    public <E extends MyTransferrableIF<E>> E transfer(E from)
    {
        return from == null
            ? null
            : _transferDetail(from.newTransferDetail());
    }

    public <E extends MyTransferrableIF<E>> void transferAll(Collection<E> v)
    {
        for ( E e : v )
            transfer(e);
    }

    //==================================================
    //= transfer :: support
    //==================================================

    private <E extends MyTransferrableIF<E>> E _transferDetail(MyTransferAbstractDetail<E> e)
    {
        addDetail(e);
        e.manageTransfer();
        debugAfterTransfer(e);
        return e.getResult();
    }

    private <E extends MyTransferrableIF<E>> void debugAfterTransfer(MyTransferAbstractDetail<E> e)
    {
        String s = Kmu.format(
            "Transfer %s (%s) => %s",
            e.formatTypeName(),
            e.formatSource(),
            e.getActionType());

        if ( requiresVerbose(e) )
            debugVerbose(s);
        else
            debug(s);
    }

    private <E extends MyTransferrableIF<E>> boolean requiresVerbose(MyTransferAbstractDetail<E> e)
    {
        MyTransferAction type = e.getActionType();
        switch ( type )
        {
            case Add:
            case Error:
            case Update:
                return false;

            case NoSource:
            case Exists:
            case SkipAdd:
            case SkipUpdate:
            case AlreadyUpdated:
                return true;
        }
        throw Kmu.newEnumError(type);
    }

    //##################################################
    //# print
    //##################################################

    @SuppressWarnings("resource")
    public final void print()
    {
        KmIndentPrintWriter out;
        out = KmIndentPrintWriter.createOnSystemOut();
        printOn(out);
        out.flush();
    }

    @SuppressWarnings("resource")
    public final void printOn(Writer out)
    {
        KmIndentPrintWriter wrapper;
        wrapper = new KmIndentPrintWriter(out);
        printOn(wrapper);
        wrapper.flush();
    }

    protected abstract void printOn(KmIndentPrintWriter out);

    protected final void printChildrenOn(KmIndentPrintWriter out)
    {
        out.indent();
        for ( MyTransferAbstractDetail<?> e : getDetails() )
            e.printOn(out);
        out.outdent();
    }

    //==================================================
    //= print :: errors
    //==================================================

    public void printErrors()
    {
        KmList<String> v = collectErrors();
        if ( !v.isEmpty() )
            System.err.println(v.joinLines());
    }

    public KmList<String> collectErrors()
    {
        KmList<String> v = new KmList<>();
        collectErrorsOn(v);
        return v;
    }

    protected void collectErrorsOn(KmList<String> v)
    {
        for ( MyTransferAbstractDetail<?> e : getDetails() )
            e.collectErrorsOn(v);
    }

    //##################################################
    //# debug
    //##################################################

    protected void debug(String msg, Object... args)
    {
        if ( getRoot().getDebug() )
            _debug(msg, args);
    }

    protected void debugVerbose(String msg, Object... args)
    {
        if ( getRoot().getVerbose() )
            _debug(msg, args);
    }

    private void _debug(String msg, Object... args)
    {
        String s = Kmu.format(msg, args);
        System.out.println(s);
    }

    //##################################################
    //# support
    //##################################################

    protected MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }

    protected void flush()
    {
        getAccess().flush();
    }

    protected KmApplicationException newError(String msg, Object... args)
    {
        return Kmu.newError(msg, args);
    }

    protected ScFormatter getFormatter()
    {
        return MyGlobals.getFormatter();
    }

    protected final String formatTitle(Object e)
    {
        if ( e instanceof KmDomainIF )
            return ((KmDomainIF)e).getDomainTitle();

        return e == null
            ? "null"
            : e.toString();
    }

    protected final String formatTypeName()
    {
        String s;
        s = getClass().getSimpleName();
        s = Kmu.removePrefix(s, "Jk");
        s = Kmu.removePrefix(s, "My");
        s = Kmu.removePrefix(s, "Transfer");
        s = Kmu.removeSuffix(s, "Detail");
        return s;
    }

}
