package com.app.ui.page.tools;

import com.kodemore.collection.KmList;
import com.kodemore.database.KmDatabaseTool;
import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScCheckboxField;
import com.kodemore.servlet.field.ScDropdownField;
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

    private static final String     FORMAT_HTML        = "Html";
    private static final String     FORMAT_HTML_SIMPLE = "Html Simple";
    private static final String     FORMAT_CSV         = "Csv";
    private static final String     FORMAT_CSV_SIMPLE  = "Csv Simple";

    //##################################################
    //# variables
    //##################################################

    private ScTextField             _schemaField;
    private ScDropdownField<String> _formatField;

    private ScTextArea              _sqlField;
    private ScCheckboxField         _allowUpdatesField;
    private ScDiv                   _resultBox;

    private ScDropdownField<String> _tableDropdown;

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
        root.css().fill();

        ScDiv col;
        col = root.addFlexColumn();
        col.css().fill();

        installQueryOn(col);
        installResultsOn(col);
    }

    private void installQueryOn(ScDiv root)
    {
        ScForm form;
        form = root.addForm();
        form.setSubmitAction(this::handleSubmit);
        form.css().flexChildStatic();

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

        ScDiv buttons;
        buttons = group.showFooter().addButtonBox();
        buttons.css().flexRow();
        buttons.addSubmitButton();
        buttons.addFlexChildFiller();
        buttons.add(createAllowUpdatesField());
    }

    private ScControl createAllowUpdatesField()
    {
        ScCheckboxField c;
        c = new ScCheckboxField();
        c.setLabel("Allow Updates");
        c.setHelp("All changed to the database are disabled unless checked.");
        _allowUpdatesField = c;

        ScDiv div;
        div = new ScDiv();
        div.css().flexColumn().flexAlignCenter().flexChildBasis0();

        ScFieldTable fields;
        fields = new ScFieldTable();
        fields.add(c);

        div.add(fields);
        return div;
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

    private ScDropdownField<String> createFormatField()
    {
        ScDropdownField<String> e;
        e = new ScDropdownField<>();
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

    private ScDiv createQuickActionBox()
    {
        _tableDropdown = new ScDropdownField<>();
        _tableDropdown.setNullSelectPrefix();
        _tableDropdown.disableChangeTracking();

        ScDiv box;
        box = new ScDiv();
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
        box.addButton("indexes", this::handleIndexes);

        return box;
    }

    private ScTextArea createSqlField()
    {
        ScTextArea e;
        e = new ScTextArea();
        e.setLabel("Sql");
        e.layoutBlock(150);
        e.getPostRenderScript().focus();
        e.disableChangeTracking();

        _sqlField = e;
        return e;
    }

    private void installResultsOn(ScDiv root)
    {
        _resultBox = root.addDiv();
        _resultBox.css().flexChildFiller();
        _resultBox.css().auto().borderGray().marginTop().pad5();
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
        _sqlField.ajaxHideAllErrors();

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

    private void handleIndexes()
    {
        handleQuickAction("show indexes from %s;");
    }

    private void handleQuickAction(String template)
    {
        String table = _tableDropdown.getValue();

        if ( table == null )
        {
            ajax().toast("Please select a table.").warn();
            return;
        }

        String sql = Kmu.format(template, table);
        _sqlField.ajaxSetFieldValue(sql);
        submitSql(sql);
    }

    //##################################################
    //# support
    //##################################################

    private void submitSql(String sql)
    {
        String schema = _schemaField.getValue();
        KmList<String> v = getSqlStatementsFrom(sql);

        KmSqlResultComposer c;
        c = new KmSqlResultComposer();
        c.setAllowUpdates(allowsUpdates());
        c.setSchema(schema);
        c.setSqlStatements(v);
        installFormatter(c);

        String result = c.run();

        if ( isHtmlFormat() )
            applyHtmlResult(result);
        else
            applyAttachmentResult(result);
    }

    private KmList<String> getSqlStatementsFrom(String sql)
    {
        KmList<String> v = Kmu.tokenize(sql, ';');
        Kmu.trimValues(v);
        Kmu.removeEmptyValues(v);

        checkUpdates(v);

        return v;
    }

    private void checkUpdates(KmList<String> v)
    {
        boolean allowsUpdates = allowsUpdates();

        if ( allowsUpdates )
            return;

        if ( containsDdlStatements(v) )
        {
            _sqlField.addError("Updates are not allowed.");
            _sqlField.checkErrors();
        }
    }

    private boolean allowsUpdates()
    {
        return _allowUpdatesField.isChecked();
    }

    private boolean containsDdlStatements(KmList<String> v)
    {
        if ( v.containsIf(e -> e.toLowerCase().startsWith("alter")) )
            return true;

        if ( v.containsIf(e -> e.toLowerCase().startsWith("drop")) )
            return true;

        if ( v.containsIf(e -> e.toLowerCase().startsWith("create")) )
            return true;

        return false;
    }

    private boolean isHtmlFormat()
    {
        String mode = _formatField.getValue();
        return Kmu.matchesAny(mode, FORMAT_HTML, FORMAT_HTML_SIMPLE);
    }

    private void applyHtmlResult(String result)
    {
        _resultBox.ajaxSetContents(result).fade();
    }

    private void applyAttachmentResult(String result)
    {
        ajax().download("sql.csv", result);
    }

    private void installFormatter(KmSqlResultComposer c)
    {
        String s = _formatField.getValue();
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
