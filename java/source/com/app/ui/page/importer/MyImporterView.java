package com.app.ui.page.importer;

import com.kodemore.collection.KmList;
import com.kodemore.csv.KmCsvBuilder;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.control.ScActionButton;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScTable;
import com.kodemore.servlet.control.ScTableRow;
import com.kodemore.servlet.control.ScTransientDiv;
import com.kodemore.servlet.field.ScStaticEnumDropdownField;
import com.kodemore.servlet.field.ScTextArea;
import com.kodemore.servlet.script.ScHtmlIdAjax;
import com.kodemore.utility.Kmu;

import com.app.model.MyProject;
import com.app.ui.page.importer.base.MyImporter;
import com.app.ui.page.importer.base.MyImporterColumn;
import com.app.ui.page.importer.base.MyImporterDuplicatePolicy;
import com.app.ui.page.importer.base.MyImporterError;
import com.app.utility.MyGlobals;

public abstract class MyImporterView<T extends MyImporter>
    extends ScDiv
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The form that wraps the page.
     */
    private ScForm _form;

    /**
     * Determine how duplicates should be handled. Hidden by default,
     * but may be enabled by specific subclasses.
     */
    private ScStaticEnumDropdownField _duplicateField;

    /**
     * The csv source text. This can be fairly large.
     */
    private ScTextArea _csvField;

    /**
     * Test the CSV source, but do NOT import it.
     */
    private ScAction _testAction;

    /**
     * Test and IMPORT the csv source.
     */
    private ScAction _importAction;

    /**
     * A summary of the test/import.
     */
    private ScTransientDiv _result;

    //##################################################
    //# domain
    //##################################################

    protected abstract String getDomainName();

    private String getPluralDomainName()
    {
        return Kmu.pluralize(getDomainName());
    }

    //##################################################
    //# install
    //##################################################

    public MyImporterView()
    {
        ScDiv e;
        e = this;
        e.css().flexColumn().flexChildFiller();
        installOn(e);
    }

    //##################################################
    //# install
    //##################################################

    private void installOn(ScDiv root)
    {
        ScForm form;
        form = root.addForm();
        form.css().flexChildFiller().flexRow();
        form.add(createInstructionGroup());
        _form = form;

        ScDiv right;
        right = form.addDiv();
        right.css().flexChildFiller0().flexColumn().columnSpacer20();
        right.add(createImportGroup());
        right.add(createResultsGroup());

        _testAction = newUncheckedAction(this::handleTest);
        _importAction = newUncheckedAction(this::handleImport);
    }

    //==================================================
    //= install :: instructions
    //==================================================

    private ScControl createInstructionGroup()
    {
        ScGroup group;
        group = new ScGroup();
        group.setTitle("Instructions");
        group.css().flexChildFiller0().marginRight20();

        ScDiv body;
        body = group.getBody();
        body.css().gap20().auto();
        explainIntroduction(body);
        explainUsage(body);
        explainColumns(body);

        return group;
    }

    //==================================================
    //= install :: introduction
    //==================================================

    private void explainIntroduction(ScDiv root)
    {
        ScTable table;
        table = root.addTable();
        table.css().dataTable();

        ScTableRow row;
        row = table.addRow();
        row.addHeader("Introduction");

        row = table.addRow();
        row.addCell(formatIntroduction());
    }

    private String formatIntroduction()
    {
        String msg = ""
            + "This tool is used to import %s "
            + "from text files, spreadsheets, or other external applications. "
            + "The data must be provided as Comma Separated Value (CSV). "
            + "";

        return Kmu.format(msg, getPluralDomainName());
    }

    private void explainUsage(ScDiv root)
    {
        ScTable table;
        table = root.addTable();
        table.css().dataTable();

        ScTableRow row;
        row = table.addRow();
        row.addHeader("Usage");

        row = table.addRow();
        row.addCell(formatUsage());
    }

    private String formatUsage()
    {
        String msg = ""
            + "Generate your list of %s "
            + "as CSV, then copy the CSV text into the field to the right. "
            + "You must include a header row that identifies the pertinent "
            + "column, and the names must match the column described below. "
            + "Optional columns may be left blank, or completely omitted."
            + "\n\n"
            + "Test your CSV data using the 'Test' button. This will check for "
            + "any problems and report the results without making any changes. "
            + "\n\n"
            + "Import the data by pressing the 'Import' button. This can be slow "
            + "if the list is long, so it may be helpful to import your "
            + "data in smaller batches. "
            + "";

        return Kmu.format(msg, getPluralDomainName());
    }

    //==================================================
    //= install :: instruction columns
    //==================================================

    private void explainColumns(ScDiv root)
    {
        ScTable table;
        table = root.addTable();
        table.css().dataTable();

        ScTableRow row;
        row = table.addRow();
        row.addHeader("Column");
        row.addHeader("Description");
        row.addHeader("Required");
        row.addHeader("Default");

        KmList<MyImporterColumn<?>> cols = createBaseImporter().getColumns();
        for ( MyImporterColumn<?> col : cols )
            explainColumnOn(table, col);
    }

    private void explainColumnOn(ScTable table, MyImporterColumn<?> col)
    {
        ScTableRow row;
        row = table.addRow();
        row.addCell(col.getName());
        row.addCell(col.getDescription());
        row.addCell(Kmu.formatBoolean(col.isRequired(), "required", ""));
        row.addCell(getFormatter().formatAny(col.getDefaultValue()));
    }

    //==================================================
    //= install :: import
    //==================================================

    private ScControl createImportGroup()
    {
        ScGroup group;
        group = new ScGroup();
        group.setTitle("Import");
        group.css().flexChildFiller0();

        ScDiv body;
        body = group.getBody();
        body.css().pad10().flexColumn().columnSpacer5();
        body.add(createCsvTitleRow());
        body.add(createCsvField());

        ScDiv footer;
        footer = group.showFooter();
        footer.css().buttonBox();
        footer.add(createTestButton());
        footer.add(createImportButton());
        footer.addFlexChildFiller();
        footer.add(createDownloadSampleButton());
        footer.add(createClearButton());

        return group;
    }

    private ScControl createCsvTitleRow()
    {
        ScDiv row;
        row = new ScDiv();
        row.css().flexRow().flexAlignSpaced().flexCrossAlignEnd();
        row.addLabel("CSV Source");
        row.add(createDuplicateField());
        return row;
    }

    private ScControl createDuplicateField()
    {
        ScStaticEnumDropdownField e;
        e = new ScStaticEnumDropdownField();
        e.setLabel("Duplicates");
        e.setHelp("This determines how duplicates should be handled.");
        e.setOptions(MyImporterDuplicatePolicy.values());
        e.selectFirstOption();
        e.disableChangeTracking();
        e.hide();
        _duplicateField = e;
        return e;
    }

    private ScControl createCsvField()
    {
        ScTextArea e;
        e = new ScTextArea();
        e.layoutFlexFiller();
        e.noWrap();
        e.disableChangeTracking();
        _csvField = e;
        return e;
    }

    private ScControl createTestButton()
    {
        String helpMessage = ""
            + "TEST the CSV data, but do not import any data. "
            + "Errors will be reported in the results section below, but no changes "
            + "will be made to the application.";

        ScActionButton e;
        e = new ScActionButton();
        e.setText("Test CSV");
        e.setAction(newUncheckedAction(this::handlePreTest));
        e.ignoreForm();
        e.setHelp(helpMessage);
        return e;
    }

    private ScControl createImportButton()
    {
        ScActionButton e;
        e = new ScActionButton();
        e.setText(formatImportTitle());
        e.setAction(newCheckedAction(this::handlePreImport));
        e.ignoreForm();
        e.setConfirmationMessageText(formatImportConfirmation());
        e.setHelp(formatImportHelp());
        return e;
    }

    private String formatImportTitle()
    {
        return format("Import $(Domains)");
    }

    private String formatImportConfirmation()
    {
        return format(
            ""
                + "IMPORT $(Domains)?"
                + "\n\n"
                + "This will permanently import all of the $(domains) listed above."
                + "");
    }

    private String formatImportHelp()
    {
        return format(
            ""
                + "IMPORT the $(domains) into the application. The results will be reported "
                + "in the section below. If any errors are detected, they will be reported "
                + "as well. No $(domains) will be imported unless the data is 100% acceptable."
                + "");
    }

    private ScControl createDownloadSampleButton()
    {
        ScActionButton e;
        e = new ScActionButton();
        e.setText("Download Sample");
        e.setAction(newCheckedAction(this::handleDownloadSample));
        e.ignoreForm();
        e.setHelp("Download a short sample of the CSV file, with headers and data.");
        return e;
    }

    private ScControl createClearButton()
    {
        ScActionButton e;
        e = new ScActionButton();
        e.setText("Clear");
        e.setAction(newCheckedAction(this::handleClear));
        e.ignoreForm();
        e.setHelp("Clear the CSV and results.");
        return e;
    }

    //==================================================
    //= install :: results
    //==================================================

    private ScControl createResultsGroup()
    {
        ScGroup e;
        e = new ScGroup();
        e.setTitle("Results");
        e.css().flexChildFiller0();

        ScDiv body;
        body = e.getBody();
        body.css().pad().flexColumn().auto();
        body.add(createResult());
        return e;
    }

    private ScControl createResult()
    {
        ScTransientDiv e;
        e = new ScTransientDiv();
        _result = e;
        return e;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        if ( createBaseImporter().usesDuplicatePolicy() )
            _duplicateField.show();
    }

    //##################################################
    //# handle
    //##################################################

    private void handleDownloadSample()
    {
        KmList<MyImporterColumn<?>> cols = createBaseImporter().getColumns();

        KmCsvBuilder out;
        out = new KmCsvBuilder();

        for ( MyImporterColumn<?> col : cols )
            out.printField(col.getName());

        out.endRecord();

        for ( MyImporterColumn<?> col : cols )
            out.printField(col.getSample());

        out.endRecord();

        String file = format("sample$(Domain).csv");
        String csv = out.toString();

        ajax().download(file, csv);
    }

    private void handleClear()
    {
        _csvField.ajaxClearFieldValue();
        _result.ajaxReplace();
    }

    //==================================================
    //= handle :: test
    //==================================================

    /**
     * Prepare for the test.
     * 1) Clear the previous results.
     * 2) Show a message in the results area.
     * 3) Initiate the real test action.
     */
    private void handlePreTest()
    {
        ScTransientDiv root;
        root = _result;
        root.addParagraph("Testing CSV...").css().titleText();
        root.ajaxReplace();

        ajax().runDelayedAction(_form, _testAction);
    }

    private void handleTest()
    {
        T importer;
        importer = createImporter();
        importer.setCsv(_csvField.getValue());
        importer.testAll();

        printTestResults(importer);
        _result.ajaxReplace();
    }

    //==================================================
    //= handle :: import
    //==================================================

    private void handlePreImport()
    {
        ScTransientDiv root;
        root = _result;
        root.addParagraph(formatImportingMessage()).css().titleText();
        root.ajaxReplace();

        ajax().runDelayedAction(_form, _importAction);
    }

    private String formatImportingMessage()
    {
        return format("Importing $(Domains)...");
    }

    private void handleImport()
    {
        T importer;
        importer = createImporter();
        importer.setCsv(_csvField.getValue());
        importer.importAll();

        printImportResults(importer);
        _result.ajaxReplace();
    }

    //##################################################
    //# print :: results
    //##################################################

    private void printTestResults(T importer)
    {
        if ( importer.isOk() )
        {
            printResultTitle(
                "Test Success",
                "A summary of the candidates identified is listed below.");
            printSuccessSummaryOn(_result, importer);
        }
        else
        {
            printResultTitle("Test FAILED", "Please correct the errors listed below.");
            printErrors(importer);
        }
    }

    private void printImportResults(T importer)
    {
        if ( importer.isOk() )
        {
            printResultTitle(
                "Import Success",
                "A summary of the charges imported is listed below.");
            printSuccessSummaryOn(_result, importer);
        }
        else
        {
            printResultTitle("Import FAILED", "Please correct the errors listed below.");
            printErrors(importer);
        }
    }

    private void printResultTitle(String title, String subtitle)
    {
        ScTransientDiv root;
        root = _result;
        root.addParagraph(title).css().titleText();
        root.addParagraph(subtitle).css().subtitleText();
        root.addBreak();
    }

    protected abstract void printSuccessSummaryOn(ScTransientDiv result, T importer);

    //##################################################
    //# print :: errors
    //##################################################

    private void printErrors(T importer)
    {
        ScTransientDiv root;
        root = _result;

        ScTable table;
        table = root.addTable();
        table.css().dataTable();

        printErrorHeaderOn(table);
        printErrorLinesOn(importer, table);
    }

    private void printErrorHeaderOn(ScTable table)
    {
        ScTableRow row;
        row = table.addRow();
        row.addHeader("Row");
        row.addHeader("Column");
        row.addHeader("Message");
    }

    private void printErrorLinesOn(T importer, ScTable table)
    {
        for ( MyImporterError e : importer.getErrors() )
            printErrorLineOn(table, e);
    }

    private void printErrorLineOn(ScTable table, MyImporterError error)
    {
        ScTableRow row;
        row = table.addRow();
        row.addCell(error.getRecordNumber() + "");
        row.addCell(error.getColumnName());
        row.addCell(error.getMessage());
    }

    //##################################################
    //# support
    //##################################################

    private final T createImporter()
    {
        T importer;
        importer = createBaseImporter();
        importer.setDuplicatePolicy(getDuplicatePolicy());
        return importer;
    }

    protected abstract T createBaseImporter();

    private MyImporterDuplicatePolicy getDuplicatePolicy()
    {
        String code = _duplicateField.getValue();
        return code == null
            ? MyImporterDuplicatePolicy.ErrorOnDuplicates
            : MyImporterDuplicatePolicy.valueOf(code);
    }

    private String format(String s)
    {
        s = Kmu.replaceAll(s, "$(domain)", getDomainName());
        s = Kmu.replaceAll(s, "$(domains)", getPluralDomainName());
        s = Kmu.replaceAll(s, "$(Domain)", Kmu.capitalizeWords(getDomainName()));
        s = Kmu.replaceAll(s, "$(Domains)", Kmu.capitalizeWords(getPluralDomainName()));
        return s;
    }

    private ScHtmlIdAjax ajax()
    {
        return _htmlIdAjax();
    }

    protected MyProject getCurrentProject()
    {
        return MyGlobals.getCurrentProject();
    }
}
