package com.app.model.support;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;

import com.app.model.MyAuditLog;
import com.app.model.base.MyAuditLogType;

/**
 * I take a list of audit logs and format them as HTML for display.
 */
public class MyAuditLogFormatter
{
    //##################################################
    //# static
    //##################################################

    public static String format(KmList<MyAuditLog> v)
    {
        if ( v == null || v.isEmpty() )
            return null;

        MyAuditLogFormatter f;
        f = new MyAuditLogFormatter();
        f.setAuditLogs(v);
        return f.format();
    }

    public static String format(MyAuditLog e)
    {
        return e == null
            ? ""
            : format(KmList.createWith(e));
    }

    //##################################################
    //# variables
    //##################################################

    private KmList<MyAuditLog> _auditLogs;
    private KmHtmlBuilder      _builder;
    private MyAuditLog         _previous;
    private boolean            _inBulletList;

    //##################################################
    //# constructor
    //##################################################

    private MyAuditLogFormatter()
    {
        _builder = new KmHtmlBuilder();
    }

    //##################################################
    //# accessing
    //##################################################

    private KmList<MyAuditLog> getAuditLogs()
    {
        return _auditLogs;
    }

    private void setAuditLogs(KmList<MyAuditLog> e)
    {
        _auditLogs = e;
    }

    private boolean hasAuditLogs()
    {
        KmList<MyAuditLog> v = getAuditLogs();

        if ( v == null )
            return false;

        if ( v.isEmpty() )
            return false;

        return true;
    }

    //##################################################
    //# format
    //##################################################

    private String format()
    {
        if ( !hasAuditLogs() )
            return "";

        for ( MyAuditLog e : getAuditLogs() )
        {
            printLog(e);
            _previous = e;
        }

        endBulletList();

        return _builder.toString().trim();
    }

    private void printLog(MyAuditLog e)
    {
        if ( isNewSection(e) )
            printSectionHeader(e);

        if ( isNewGroup(e) )
            printGroupHeader(e);

        printDetail(e);
    }

    //##################################################
    //# section header
    //##################################################

    private void printSectionHeader(MyAuditLog e)
    {
        String name = e.formatMessageUserName();
        String msg = e.getCreatedLocalTsMessage();

        endBulletList();

        if ( !_builder.isEmpty() )
        {
            println();
            println();
        }

        printDivider();
        printflnBold("%s, %s", name, msg);
        printDivider();
    }

    //##################################################
    //# group header
    //##################################################

    private void printGroupHeader(MyAuditLog e)
    {
        MyAuditLogType type = e.getType();
        if ( type == null )
            return;

        endBulletList();
        println();

        switch ( type )
        {
            case Add:
                printAddGroupHeader(e);
                break;

            case Update:
                printUpdateGroupHeader(e);
                break;

            case Delete:
                printDeleteGroupHeader(e);
                break;
        }
    }

    private void printAddGroupHeader(MyAuditLog e)
    {
        printfln("Added %s [%s]", e.getDomainTypeLabel(), e.getDomainName());
    }

    private void printUpdateGroupHeader(MyAuditLog e)
    {
        printfln("Updated %s [%s]", e.getDomainTypeLabel(), e.getDomainName());
    }

    private void printDeleteGroupHeader(MyAuditLog e)
    {
        printfln("Deleted %s [%s]", e.getDomainTypeLabel(), e.getDomainName());
    }

    //##################################################
    //# detail
    //##################################################

    private void printDetail(MyAuditLog e)
    {
        MyAuditLogType type = e.getType();

        if ( type == null )
            return;

        beginBullet();
        switch ( type )
        {
            case Add:
                formatAddDetail(e);
                break;

            case Update:
                formatUpdateDetail(e);
                break;

            case Delete:
                formatDeleteDetail(e);
                break;
        }
        endBullet();
    }

    private void formatAddDetail(MyAuditLog e)
    {
        printfln("set %s = [%s].", e.getFieldNameLabel(), e.getNewValue());
    }

    private void formatUpdateDetail(MyAuditLog e)
    {
        printfln(
            "changed %s from [%s] to [%s].",
            e.getFieldNameLabel(),
            e.getOldValue(),
            e.getNewValue());
    }

    private void formatDeleteDetail(MyAuditLog e)
    {
        printfln("%s was [%s].", e.getFieldNameLabel(), e.getOldValue());
    }

    //##################################################
    //# support
    //##################################################

    private boolean isNewSection(MyAuditLog e)
    {
        if ( _previous == null )
            return true;

        return isNewTransaction(e) || isNewUser(e);
    }

    private boolean isNewGroup(MyAuditLog e)
    {
        if ( _previous == null )
            return true;

        return isNewTransaction(e) || isNewDomain(e);
    }

    private boolean isNewTransaction(MyAuditLog e)
    {
        if ( _previous == null )
            return true;

        if ( _previous.hasTransactionUid(e.getTransactionUid()) )
            return false;

        return true;
    }

    private boolean isNewUser(MyAuditLog e)
    {
        if ( _previous == null )
            return true;

        if ( _previous.hasUserName(e.getUserName()) )
            return false;

        return true;
    }

    private boolean isNewDomain(MyAuditLog e)
    {
        if ( _previous == null )
            return true;

        if ( !_previous.hasDomainType(e.getDomainType()) )
            return true;

        if ( !_previous.hasDomainUid(e.getDomainUid()) )
            return true;

        return false;
    }

    //##################################################
    //# print
    //##################################################

    private void printDivider()
    {
        _builder.printRule();
    }

    private void printfln(String format, Object... args)
    {
        _builder.printfln(format, args);
    }

    private void printflnBold(String format, Object... args)
    {
        _builder.beginBold();
        _builder.printfln(format, args);
        _builder.endBold();
    }

    private void println()
    {
        _builder.println();
    }

    //##################################################
    //# support
    //##################################################

    private void beginBulletList()
    {
        if ( _inBulletList )
            return;

        _builder.beginBulletList();
        _inBulletList = true;
    }

    private void endBulletList()
    {
        if ( !_inBulletList )
            return;

        _builder.endBulletList();
        _inBulletList = false;
    }

    private void beginBullet()
    {
        beginBulletList();
        _builder.beginBullet();
    }

    private void endBullet()
    {
        _builder.endBullet();
    }

}
