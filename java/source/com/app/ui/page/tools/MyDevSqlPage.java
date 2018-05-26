package com.app.ui.page.tools;

import com.kodemore.collection.KmList;
import com.kodemore.database.KmDatabaseTool;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.field.ScCheckboxField;
import com.kodemore.servlet.field.ScChoiceField;
import com.kodemore.servlet.field.ScDynamicDropdownField;
import com.kodemore.servlet.field.ScOption;
import com.kodemore.servlet.field.ScTextArea;
import com.kodemore.sql.formatter.KmSqlResultComposer;
import com.kodemore.sql.formatter.KmSqlResultFormatterExcel;
import com.kodemore.utility.Kmu;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

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
    //# variables
    //##################################################

    private ScDynamicDropdownField<String> _schemaField;
    private ScDynamicDropdownField<String> _tableField;
    private ScChoiceField<Boolean>         _showNullsField;
    private ScChoiceField<Boolean>         _showSqlField;

    private ScTextArea      _sqlField;
    private ScCheckboxField _commitField;
    private ScDiv           _resultBox;

    //##################################################
    //# settings
    //##################################################

    @Override
    public final MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.developer;
    }

    @Override
    protected boolean getAutoFocus()
    {
        return false;
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().fill();

        ScDiv col;
        col = root.addDiv();
        col.css().fill().flexColumn();

        installQueryOn(col);
        installResultsOn(col);
    }

    private void installQueryOn(ScDiv root)
    {
        ScForm form;
        form = root.addForm();
        form.onSubmit(newUncheckedAction(this::handleRunHtml));
        form.css().flexChildStatic();

        ScGroup group;
        group = form.addGroup("Query");

        installBodyOn(group);
        installFooterOn(group);
    }

    //==================================================
    //= install :: body
    //==================================================

    private void installBodyOn(ScGroup group)
    {
        ScDiv body;
        body = group.getBody();
        body.css().pad();

        ScDiv div;
        div = body.addDiv();
        div.css().flexRow().rowSpacer20();
        div.add(createBodyLeft());
        div.add(createBodyRight());

        body.addBreak();
        body.addFieldLayout().add(createSqlField());
    }

    private ScControl createBodyLeft()
    {
        ScFieldTable e;
        e = new ScFieldTable();
        e.add(createSchemaRow());
        e.add(createTableRow());
        e.add(createQuickActions());
        return e;
    }

    private ScControl createBodyRight()
    {
        ScFieldTable e;
        e = new ScFieldTable();
        e.add(createShowSqlField());
        e.add(createShowNullsField());
        return e;
    }

    private ScDiv createSchemaRow()
    {
        ScDiv e;
        e = new ScDiv();
        e.setLabel("Schema");
        e.css().flexRow().rowSpacer5();
        e.add(createSchemaField());
        e.add(createRefreshSchemasButton());
        return e;
    }

    private ScControl createSchemaField()
    {
        ScDynamicDropdownField<String> e;
        e = new ScDynamicDropdownField<>();
        e.setLabel("Schema");
        e.setNullBlankPrefix();
        e.setOptionSupplier(this::findSchemaOptions);
        e.setValue(getProperties().getDatabaseSchema());
        e.disableChangeTracking();
        e.onChange(newCheckedAction(this::handleRefreshTables));
        _schemaField = e;
        return e;
    }

    private ScControl createRefreshSchemasButton()
    {
        ScActionButton e;
        e = new ScActionButton();
        e.setIcon().nameRefresh();
        e.setFlavorIcon();
        e.setAction(newCheckedAction(this::handleRefreshSchemas));
        return e;
    }

    private ScDiv createTableRow()
    {
        ScDiv e;
        e = new ScDiv();
        e.setLabel("Table");
        e.css().flexRow().rowSpacer5();
        e.add(createTableField());
        e.add(createRefreshTablesButton());
        return e;
    }

    private ScControl createTableField()
    {
        ScDynamicDropdownField<String> e;
        e = new ScDynamicDropdownField<>();
        e.setNullBlankPrefix();
        e.setOptionSupplier(this::findTableOptions);
        e.disableChangeTracking();
        _tableField = e;
        return e;
    }

    private ScControl createRefreshTablesButton()
    {
        ScActionButton e;
        e = new ScActionButton();
        e.setIcon().nameRefresh();
        e.setFlavorIcon();
        e.setAction(newCheckedAction(this::handleRefreshTables));
        return e;
    }

    private ScDiv createQuickActions()
    {
        ScDiv e;
        e = new ScDiv();
        e.css().flexRow().rowSpacer5();
        e.addLink("select", newCheckedAction(this::handleSelectStar));
        e.addLink("count", newCheckedAction(this::handleCount));
        e.addLink("describe", newCheckedAction(this::handleDescribe));
        e.addLink("indexes", newCheckedAction(this::handleIndexes));
        return e;
    }

    private ScControl createShowSqlField()
    {
        ScChoiceField<Boolean> e;
        e = new ScChoiceField<>();
        e.setLabel("Show SQL");
        e.setHelp("Determine if the sql statement should be included in the result. ");
        e.addOption(true, "show");
        e.addOption(false, "hide");
        e.setValue(true);
        e.disableChangeTracking();
        _showSqlField = e;
        return e;
    }

    private ScControl createShowNullsField()
    {
        ScChoiceField<Boolean> e;
        e = new ScChoiceField<>();
        e.setLabel("Show Nulls");
        e.setHelp("Determine if nulls should be visible as -null- or left blank.");
        e.addOption(true, "-null-");
        e.addOption(false, "blank");
        e.setValue(true);
        e.disableChangeTracking();
        _showNullsField = e;
        return e;
    }

    private ScTextArea createSqlField()
    {
        ScTextArea e;
        e = new ScTextArea();
        e.setLabel("Sql");
        e.layoutBlock();
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

    //==================================================
    //= install :: footer
    //==================================================

    private void installFooterOn(ScGroup group)
    {
        ScDiv footer;
        footer = group.showFooter();
        footer.css().flexRow().flexCrossAlignCenter();
        footer.add(createRunActions());
        footer.addFlexChildFiller();
        footer.add(createCommitBox());
    }

    private ScControl createRunActions()
    {
        ScDiv e;
        e = new ScDiv();
        e.css().buttonBox();
        e.addSubmitButton("Html");
        e.addButton("Csv", newCheckedAction(this::handleDownloadCsv));
        e.addButton("Excel", newCheckedAction(this::handleDownloadExcel));
        return e;
    }

    private ScControl createCommitBox()
    {
        ScDiv e;
        e = new ScDiv();
        e.css().flexRow().flexCrossAlignCenter().rowSpacer5().pad();
        e.add(createCommitField());
        e.addLabel("Commit Transactions");
        return e;
    }

    private ScCheckboxField createCommitField()
    {
        ScCheckboxField c;
        c = new ScCheckboxField();
        c.setLabel("Commit Transactions");
        c.setHelp("All transactions are rolled back unless checked.");
        c.disableChangeTracking();
        _commitField = c;
        return c;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    public void preRender()
    {
        // none
    }

    //##################################################
    //# handle
    //##################################################

    private void handleRunHtml()
    {
        getRoot().ajaxHideAllErrors();
        String sql = _sqlField.getValue();
        runHtml(sql);
    }

    private void handleDownloadCsv()
    {
        getRoot().ajaxHideAllErrors();
        String sql = _sqlField.getValue();
        runCsv(sql);
    }

    private void handleDownloadExcel()
    {
        getRoot().ajaxHideAllErrors();
        String sql = _sqlField.getValue();
        runExcel(sql);
    }

    private void handleRefreshSchemas()
    {
        _schemaField.ensureValidValue();
        _schemaField.ajaxReplaceOptions();
        _schemaField.ajaxUpdateFieldValues();

        _tableField.ensureValidValue();
        _tableField.ajaxReplaceOptions();
        _tableField.ajaxUpdateFieldValues();
    }

    private void handleRefreshTables()
    {
        _tableField.ensureValidValue();
        _tableField.ajaxReplaceOptions();
        _tableField.ajaxUpdateFieldValues();
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
        getRoot().ajaxHideAllErrors();

        String table = _tableField.getValue();

        if ( table == null )
        {
            ajax().toast("Please select a table.").warn();
            return;
        }

        String sql = Kmu.format(template, table);
        _sqlField.ajaxSetFieldValue(sql);
        runHtml(sql);
    }

    //##################################################
    //# support
    //##################################################

    private void runHtml(String sql)
    {
        KmSqlResultComposer c;
        c = createComposer(sql);
        c.formatHtmlNormal();

        String result = c.run();
        _resultBox.ajaxSetContents(result).fade();
    }

    private void runCsv(String sql)
    {
        KmSqlResultComposer c;
        c = createComposer(sql);
        c.formatCsvNormal();

        String result = c.run();
        ajax().download("sql.csv", result);
    }

    private void runExcel(String sql)
    {
        KmSqlResultComposer c;
        c = createComposer(sql);
        c.formatExcelNormal();
        c.run();

        KmSqlResultFormatterExcel formatter = (KmSqlResultFormatterExcel)c.getFormatter();
        byte[] result = formatter.endBytes();
        ajax().download("sql.xlsx", result);
    }

    private KmSqlResultComposer createComposer(String sql)
    {
        String schema = _schemaField.getValue();
        KmList<String> sqlList = getSqlStatementsFrom(sql);

        KmSqlResultComposer c;
        c = new KmSqlResultComposer();
        c.setSchema(schema);
        c.setAllowCommit(allowsCommit());
        c.setSqlStatements(sqlList);

        boolean useBlanks = !_showNullsField.getValue();
        if ( useBlanks )
            c.useBlanksForNull();

        boolean hideSql = !_showSqlField.getValue();
        if ( hideSql )
            c.hideSqlData();

        return c;
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
        boolean allowsUpdates = allowsCommit();
        if ( allowsUpdates )
            return;

        if ( containsDdlStatements(v) )
        {
            _sqlField.addError("Updates are not allowed.");
            _sqlField.checkErrors();
        }
    }

    private boolean allowsCommit()
    {
        return _commitField.isChecked();
    }

    private boolean containsDdlStatements(KmList<String> v)
    {
        if ( v.containsIf(e -> e.toLowerCase().startsWith("create")) )
            return true;

        if ( v.containsIf(e -> e.toLowerCase().startsWith("alter")) )
            return true;

        if ( v.containsIf(e -> e.toLowerCase().startsWith("drop")) )
            return true;

        return false;
    }

    //##################################################
    //# schemas
    //##################################################

    private KmList<ScOption<String>> findSchemaOptions()
    {
        return findSchemaNames().collect(e -> ScOption.create(e, e));
    }

    private KmList<String> findSchemaNames()
    {
        KmDatabaseTool tool = new KmDatabaseTool();
        try
        {
            tool.open();

            KmList<String> v;
            v = tool.getSchemaNames();
            v.sort();
            return v;
        }
        finally
        {
            tool.closeSafely();
        }
    }

    //##################################################
    //# tables
    //##################################################

    private KmList<ScOption<String>> findTableOptions()
    {
        return findTableNames().collect(e -> ScOption.create(e, e));
    }

    private KmList<String> findTableNames()
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
