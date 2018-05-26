package com.app.ui.page.report;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFieldset;
import com.kodemore.servlet.control.ScGrid;
import com.kodemore.utility.KmEnumIF;

import com.app.criteria.MyNoteCriteria;
import com.app.model.MyNote;
import com.app.model.MyProject;
import com.app.model.MyUser;
import com.app.model.meta.MyMetaNote;
import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.chartReport.MySimpleChartReportPage;
import com.app.ui.page.chartReport.group.MyChartReportSection;
import com.app.ui.page.chartReport.group.MyChartReportStringSection;
import com.app.ui.page.chartReport.value.MyChartReportValue;
import com.app.ui.selector.MyMemberSelector;

public class MyNoteReportPage
    extends MySimpleChartReportPage<MyNote,MyNoteCriteria>
{
    //##################################################
    //# singleton
    //##################################################

    private static MyNoteReportPage _instance;

    public static void installInstance()
    {
        _instance = new MyNoteReportPage();
    }

    public static MyNoteReportPage getInstance()
    {
        return _instance;
    }

    private MyNoteReportPage()
    {
        // singleton
    }

    //##################################################
    //# sort
    //##################################################

    private enum Sort
        implements KmEnumIF
    {
        Created
    }

    //##################################################
    //# variables
    //##################################################

    private MyMemberSelector _userField;

    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.projectWorker;
    }

    @Override
    public String getHelpMessage()
    {
        return "This report shows notes for the selected project.";
    }

    //##################################################
    //# install :: filter
    //##################################################

    @Override
    protected void installFilterFieldsOn(ScDiv root)
    {
        ScDiv row;
        row = root.addDiv();
        row.css().flexChildFiller().flexRow().rowSpacer10();
        row.add(createUserSection());
    }

    //==================================================
    //= install :: site filter
    //==================================================

    private ScControl createUserSection()
    {
        ScFieldset set;
        set = createFilterBox("User");
        set.css().flexChildFiller();

        ScFieldTable fields;
        fields = set.addFieldTable();
        fields.add(createUserField());

        return set;
    }

    private ScControl createUserField()
    {
        MyMemberSelector e;
        e = new MyMemberSelector();
        e.setNullAnyPrefix();
        e.disableChangeTracking();
        _userField = e;
        return e;
    }

    //##################################################
    //# grid
    //##################################################

    @Override
    protected void installGridColumnsOn(ScGrid<MyNote> e)
    {
        MyMetaNote x = MyNote.Meta;

        e.addColumn(x.CreatedLocalDate, "Date");
        e.addColumn(x.CreatedLocalTime, "Time");
        e.addColumn(x.CreatedByFullName, "User");
        e.addColumn(x.OwnerTypeName, "Type", 50);
        e.addColumn(x.OwnerTitle, "Title", 200);
        e.addColumn(x.Message, "Message", 400);
    }

    @Override
    protected KmEnumIF[] getGridSortOptions()
    {
        return Sort.values();
    }

    //##################################################
    //# criteria
    //##################################################

    @Override
    protected MyNoteCriteria createEmptyCriteria()
    {
        return getAccess().getNoteDao().createCriteria();
    }

    @Override
    protected void applyFilterTo(MyNoteCriteria c)
    {
        c.whereProjectIs(getCurrentProject());

        if ( _userField.hasValue() )
        {
            MyUser user = _userField.getValue();
            c.whereCreatedByIs(user);
        }
    }

    //==================================================
    //= sort
    //==================================================

    @Override
    protected void applyGridSortTo(MyNoteCriteria c)
    {
        String sortCode = getGridSortCode();
        Sort sort = Sort.valueOf(sortCode);
        boolean asc = getSortAscending();

        switch ( sort )
        {
            case Created:
                c.sortOnUid(asc);
                break;
        }
    }

    //##################################################
    //# chart values
    //##################################################

    @Override
    protected void defineChartValues(KmList<MyChartReportValue<MyNote,MyNoteCriteria>> v)
    {
        v.add(newRowCountValue());
    }

    //##################################################
    //# chart groups
    //##################################################

    @Override
    protected void defineChartSections(KmList<MyChartReportSection<MyNote,MyNoteCriteria>> v)
    {
        v.add(newUserSection());
    }

    private MyChartReportSection<MyNote,MyNoteCriteria> newUserSection()
    {
        return new MyChartReportStringSection<MyNote,MyNoteCriteria>()
        {
            @Override
            public String getName()
            {
                return "User";
            }

            @Override
            protected void groupByString(MyNoteCriteria c)
            {
                c.joinToCreatedBy().groupByFullName();
            }
        };
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        MyProject project = getCurrentProject();
        _userField.setProject(project);
    }
}
