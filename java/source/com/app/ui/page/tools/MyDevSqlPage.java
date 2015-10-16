package com.app.ui.page.tools;

import com.kodemore.collection.KmList;
import com.kodemore.database.KmDatabaseTool;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScDropdown;
import com.kodemore.servlet.field.ScTextArea;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.sql.formatter.KmSqlResultComposer;
import com.kodemore.utility.Kmu;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;
import com.app.utility.MyButtonUrls;

public final class MyDevSqlPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyDevSqlPage _instance;

    public static void installInstance()
    {
        _instance = new MyDevSqlPage();
    }

    public static MyDevSqlPage getInstance()
    {
        return _instance;
    }

    private MyDevSqlPage()
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

    private ScTextField _schemaField;
    private ScDropdown  _formatField;

    private ScTextArea _sqlField;
    private ScBox      _resultBox;

    private ScDropdown _tableDropdown;

    //##################################################
    //# settings
    //##################################################

    @Override
    public final MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.developer;
    }

    //##################################################
    //# bookmark
    //##################################################

    @Override
    public void composeBookmarkOn(ScParameterList v)
    {
        // none
    }

    @Override
    public void applyBookmark(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().gap();

        ScForm form;
        form = root.addForm();
        form.setSubmitAction(this::handleSubmit);

        installQueryOn(form);
        installResultsOn(root);
    }

    private void installQueryOn(ScForm form)
    {
        ScGroup group;
        group = form.addGroup("Query");

        ScDiv body;
        body = group.getBody();
        body.css().pad();

        ScFieldTable fields;
        fields = body.addFieldTable();
        fields.css().widthFull();
        fields.rightCss().widthFull();
        fields.add(createSchemaField());
        fields.add(createQuickActionBox());
        fields.add(createFormatField());
        fields.add(createSqlField());

        ScBox buttons;
        buttons = group.showFooter().addButtonBox();
        buttons.addSubmitButton();
    }

    private ScTextField createSchemaField()
    {
        ScTextField e;
        e = new ScTextField();
        e.setLabel("Schema");
        e.setValue(getProperties().getDatabaseSchema());
        e.disableChangeTracking();

        _schemaField = e;
        return e;
    }

    private ScDropdown createFormatField()
    {
        ScDropdown e;
        e = new ScDropdown();
        e.setLabel("Format");
        e.setValue(FORMAT_HTML);
        e.disableChangeTracking();
        e.addOption(FORMAT_HTML);
        e.addOption(FORMAT_HTML_SIMPLE);
        e.addOption(FORMAT_CSV);
        e.addOption(FORMAT_CSV_SIMPLE);

        _formatField = e;
        return e;
    }

    private ScBox createQuickActionBox()
    {
        _tableDropdown = new ScDropdown();
        _tableDropdown.addNullSelectPrefix();
        _tableDropdown.css().floatLeft();
        _tableDropdown.disableChangeTracking();

        ScBox box;
        box = new ScBox();
        box.setLabel("Table");
        box.css().marginRightChildren5();
        box.add(_tableDropdown);

        ScActionButton b;
        b = box.addButton();
        b.setImage(MyButtonUrls.refresh());
        b.setAction(this::handleRefreshTables);

        box.addButton("select *", this::handleSelectStar);
        box.addButton("count", this::handleCount);
        box.addButton("describe", this::handleDescribe);

        return box;
    }

    private ScTextArea createSqlField()
    {
        ScTextArea e;
        e = new ScTextArea();
        e.setLabel("Sql");
        e.setWidthFull();
        e.style().height(150);
        e.getPostRenderScript().focus();
        e.disableChangeTracking();

        _sqlField = e;
        return e;
    }

    private void installResultsOn(ScPageRoot root)
    {
        _resultBox = new ScBox();

        root.add(_resultBox);
    }

    //##################################################
    //# bookmark
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

    private void handleRefreshTables()
    {
        refreshTables();
        _tableDropdown.ajaxUpdateOptions();
    }

    private void handleSelectStar()
    {
        handleQuickAction("select * from %s limit 10;");
    }

    private void handleCount()
    {
        handleQuickAction("select count(*) from %s;");
    }

    private void handleDescribe()
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
    //# support
    //##################################################

    private void submitSql(String sql)
    {
        String schema = _schemaField.getValue();

        KmSqlResultComposer c;
        c = new KmSqlResultComposer();
        c.setSchema(schema);
        c.setSqlSource(sql);
        installFormatter(c);

        String result = c.run();

        if ( isHtmlFormat() )
            applyHtmlResult(result);
        else
            applyAttachmentResult(result);
    }

    private boolean isHtmlFormat()
    {
        String mode = _formatField.getStringValue();
        return Kmu.matchesAny(mode, FORMAT_HTML, FORMAT_HTML_SIMPLE);
    }

    private void applyHtmlResult(String result)
    {
        _resultBox.ajax().setContents(result).fade();
    }

    private void applyAttachmentResult(String result)
    {
        ajax().download("sql.csv", result);
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
