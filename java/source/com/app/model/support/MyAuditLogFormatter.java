package com.app.model.support;

import com.kodemore.collection.KmList;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.control.ScTable;
import com.kodemore.servlet.control.ScTableRow;
import com.kodemore.time.KmClock;
import com.kodemore.time.KmDate;
import com.kodemore.utility.KmVirtualOptions;
import com.kodemore.utility.Kmu;

import com.app.model.MyAuditLog;
import com.app.model.MyUser;
import com.app.model.base.MyAuditLogType;

/**
 * I take a list of audit logs and format them as HTML for display.
 */
public class MyAuditLogFormatter
{
    //##################################################
    //# static
    //##################################################

    public static KmHtmlBuilder format(KmList<MyAuditLog> v)
    {
        if ( v == null || v.isEmpty() )
            return null;

        return new MyAuditLogFormatter().composeHtml(v);
    }

    public static KmHtmlBuilder format(MyAuditLog e)
    {
        return e == null
            ? null
            : format(KmList.createWith(e));
    }

    //##################################################
    //# variables
    //##################################################

    private MyAuditLog _previous;

    //##################################################
    //# constructor
    //##################################################

    private MyAuditLogFormatter()
    {
        // none
    }

    //##################################################
    //# compose
    //##################################################

    public KmHtmlBuilder composeHtml(KmList<MyAuditLog> v)
    {
        _previous = null;

        ScTable table;
        table = new ScTable();
        table.css().dataTable();
        table.defaultCellCss().noWrap();

        ScTableRow row;
        row = table.addRow();
        row.addHeader("On");
        row.addHeader("At");
        row.addHeader("User");
        row.addHeader("Action");
        row.addHeader("Element");
        row.addHeader("Attribute");
        row.addHeader("New Value");
        row.addHeader("Old Value");

        for ( MyAuditLog e : v )
        {
            compose(table, e);
            _previous = e;
        }

        return table.render();
    }

    private void compose(ScTable table, MyAuditLog e)
    {
        ScTableRow row;
        row = table.addRow();

        row.addCell().addText(formatDate(e));
        row.addCell().addText(formatTime(e));
        row.addCell().addText(formatUser(e));
        row.addCell().addText(formatAction(e));
        row.addCell().addText(formatElement(e));
        row.addCell().addText(formatAttribute(e));
        row.addCell().addText(formatNewValue(e));
        row.addCell().addText(formatOldValue(e));
    }

    private String formatDate(MyAuditLog e)
    {
        if ( isSameBundle(e) )
            return "";

        KmDate date = e.getCreatedLocalDate();
        int currentYear = KmClock.getLocalDate().getYear();

        return date.hasYear(currentYear)
            ? date.format_m_d()
            : date.format_m_d_yy();
    }

    private String formatTime(MyAuditLog e)
    {
        if ( isSameBundle(e) )
            return "";

        return e.getCreatedLocalTime().format_h_mm_am();
    }

    private String formatUser(MyAuditLog e)
    {
        if ( isSameBundle(e) )
            return "";

        MyUser user = e.getUser();
        return user == null
            ? KmVirtualOptions.format("system")
            : user.getFullName();
    }

    private String formatAction(MyAuditLog e)
    {
        if ( isSameBundle(e) )
            return "";

        MyAuditLogType type = e.getType();
        switch ( type )
        {
            case Add:
                return "Added";

            case Delete:
                return "Deleted";

            case Update:
                return "Updated";
        }
        throw Kmu.newEnumError(type);
    }

    private String formatElement(MyAuditLog e)
    {
        if ( isSameBundle(e) )
            return "";

        return Kmu.format("%s (%s)", e.getDomainName(), e.getDomainType());
    }

    private String formatAttribute(MyAuditLog e)
    {
        return e.getFieldName();
    }

    private String formatNewValue(MyAuditLog e)
    {
        return e.getNewValue();
    }

    private String formatOldValue(MyAuditLog e)
    {
        return e.getOldValue();
    }

    //##################################################
    //# support
    //##################################################

    private boolean isSameBundle(MyAuditLog e)
    {
        return _previous == null
            ? false
            : e.hasBundle(_previous.getBundle());
    }

}
