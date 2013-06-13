package com.app.ui.activity.tools;

import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScForm;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.field.ScDropdown;
import com.kodemore.servlet.field.ScTextArea;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.sql.formatter.KmSqlResultComposer;
import com.kodemore.utility.Kmu;

import com.app.ui.activity.MyActivity;

public class MySqlPage
    extends MyAbstractToolsPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyActivity instance = new MySqlPage();

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

    //##################################################
    //# install
    //##################################################

    @Override
    protected ScControl installRoot()
    {
        _schemaField = new ScTextField();
        _schemaField.setLabel("Schema");

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

        _results = new ScBox();

        ScBox root;
        root = new ScBox();
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
        fields.add(_formatField);
        fields.add(_sqlField);

        group.addDivider();

        ScBox footer;
        footer = group.addButtonBox();
        footer.addSubmitButton();

        root.addBreak();
        root.add(_results);

        return root;
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

    //##################################################
    //# start
    //##################################################

    @Override
    public void start()
    {
        preRender();

        print(false);
        _sqlField.ajax().focus();
    }

    private void preRender()
    {
        if ( isOk() && _schemaField.isEmpty() )
        {
            String s = getProperties().getDatabaseSchema();
            _schemaField.setValue(s);
        }
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSubmit()
    {
        String schema = updateSchemaName();
        String sql = _sqlField.getValue();

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

    private String updateSchemaName()
    {
        _schemaField.saveFieldValues();
        String schemaName = _schemaField.getValue();
        return schemaName;
    }

}
