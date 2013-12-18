package com.app.ui.page.tools;

import com.kodemore.collection.KmList;
import com.kodemore.database.KmDatabaseTool;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScDropdown;
import com.kodemore.servlet.field.ScTextArea;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.sql.formatter.KmSqlResultComposer;
import com.kodemore.utility.Kmu;

import com.app.utility.MyButtonUrls;

public class MySqlPage
    extends MyAbstractToolsPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MySqlPage instance = new MySqlPage();

    private MySqlPage()
    {
        // singleton
    }

    //##################################################
    //# constants
    //##################################################

    private static final String FORMAT_HTML        = "Html";
    private static final String FORMAT_HTML_SIMPLE = "Html Simple";
    private static final String FORMAT_CSV         = "Csv";
    private static final String FORMAT_CSV_SIMPLE  = "Csv Simple";

    //##################################################
    //# variables
    //##################################################

    private ScTextField         _schemaField;
    private ScDropdown          _formatField;

    private ScTextArea          _sqlField;
    private ScBox               _results;

    private ScDropdown          _tableDropdown;

    //##################################################
    //# navigation
    //##################################################

    @Override
    public ScParameterList composeQueryParameters()
    {
        return null;
    }

    @Override
    public void applyQueryParameters(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        _schemaField = new ScTextField();
        _schemaField.setLabel("Schema");
        _schemaField.setValue(getProperties().getDatabaseSchema());

        _formatField = new ScDropdown();
        _formatField.setLabel("Format");
        _formatField.setValue(FORMAT_HTML);
        _formatField.addOption(FORMAT_HTML);
        _formatField.addOption(FORMAT_HTML_SIMPLE);
        _formatField.addOption(FORMAT_CSV);
        _formatField.addOption(FORMAT_CSV_SIMPLE);

        _sqlField = new ScTextArea();
        _sqlField.setLabel("Sql");
        _sqlField.setWidthFull();
        _sqlField.style().height(150);
        _sqlField.getPostDomScript().focus();

        _results = new ScBox();

        root.css().pad();

        ScForm form;
        form = root.addForm();
        form.setDefaultAction(newSubmitAction());

        ScGroup group;
        group = form.addGroup("Sql");

        ScBox body;
        body = group.addBox();

        ScFieldTable fields;
        fields = body.addPad().addFields();
        fields.css().widthFull();
        fields.rightCss().widthFull();
        fields.add(_schemaField);
        fields.add(createQuickActionBox());
        fields.add(_formatField);
        fields.add(_sqlField);

        group.addDivider();

        ScBox footer;
        footer = group.addButtonBox();
        footer.addSubmitButton();

        root.addBreak();
        root.add(_results);
    }

    private ScBox createQuickActionBox()
    {
        _tableDropdown = new ScDropdown();
        _tableDropdown.addNullSelectPrefix();
        _tableDropdown.css().floatLeft();

        ScBox box;
        box = new ScBox();
        box.setLabel("Quick");
        box.css().marginRightChildren5();
        box.add(_tableDropdown);

        ScActionButton b;
        b = box.addButton();
        b.setImage(MyButtonUrls.refresh());
        b.setAction(newRefreshTablesAction());

        box.addButton("select *", newSelectAllAction());
        box.addButton("count", newCountAction());
        box.addButton("describe", newDescribeTableAction());

        return box;
    }

    //##################################################
    //# actions
    //##################################################

    private ScActionIF newSubmitAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleSubmit();
            }
        };
    }

    private ScActionIF newRefreshTablesAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleRefreshTables();
            }
        };
    }

    private ScActionIF newSelectAllAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleSelectAll();
            }
        };
    }

    private ScActionIF newCountAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleCount();
            }
        };
    }

    private ScActionIF newDescribeTableAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleDescribeTable();
            }
        };
    }

    //##################################################
    //# navigation
    //##################################################

    @Override
    protected boolean getAutoFocus()
    {
        return false;
    }

    @Override
    public void preRender()
    {
        refreshTables();
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSubmit()
    {
        String sql = _sqlField.getValue();

        submitSql(sql);
    }

    private void submitSql(String sql)
    {
        String schema = _schemaField.getValue();

        KmSqlResultComposer c;
        c = new KmSqlResultComposer();
        c.setSchema(schema);
        c.setSqlSource(sql);
        installFormatter(c);

        String result = c.run();

        boolean isHtml = isHtmlFormat();
        if ( isHtml )
        {
            _results.ajax().setHtml(result);
            return;
        }

        getData().setAttachmentResult("sql.csv", result);
    }

    private boolean isHtmlFormat()
    {
        String mode = _formatField.getStringValue();
        return Kmu.matchesAny(mode, FORMAT_HTML, FORMAT_HTML_SIMPLE);
    }

    private void installFormatter(KmSqlResultComposer c)
    {
        String s = _formatField.getStringValue();
        if ( s == null )
            return;

        if ( s.equals(FORMAT_HTML) )
            c.formatHtmlNormal();

        if ( s.equals(FORMAT_HTML_SIMPLE) )
            c.formatHtmlSimple();

        if ( s.equals(FORMAT_CSV) )
            c.formatCsvNormal();

        if ( s.equals(FORMAT_CSV_SIMPLE) )
            c.formatCsvSimple();
    }

    private void handleRefreshTables()
    {
        refreshTables();
        _tableDropdown.ajaxUpdateOptions();
    }

    private void handleSelectAll()
    {
        handleQuickAction("select * from %s limit 10;");
    }

    private void handleCount()
    {
        handleQuickAction("select count(*) from %s;");
    }

    private void handleDescribeTable()
    {
        handleQuickAction("describe %s;");
    }

    private void handleQuickAction(String template)
    {
        String table = _tableDropdown.getStringValue();

        if ( table == null )
        {
            ajax().toast("Please select a table.").warn();
            return;
        }

        String sql = Kmu.format(template, table);
        _sqlField.ajax().setValue(sql);
        submitSql(sql);
    }

    //##################################################
    //# table names
    //##################################################

    private void refreshTables()
    {
        for ( String e : getTableNames() )
            _tableDropdown.addOption(e);
    }

    private KmList<String> getTableNames()
    {
        KmDatabaseTool tool = new KmDatabaseTool();
        try
        {
            String schema = _schemaField.getValue();

            tool.open();
            tool.useSchema(schema);

            KmList<String> v;
            v = tool.getTableNames();
            v.sort();
            return v;
        }
        finally
        {
            tool.closeSafely();
        }
    }

}
