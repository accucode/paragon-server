package com.app.ui.page.guide;

import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScPageRoot;

import com.app.ui.page.MySecurityLevel;
import com.app.ui.page.crud.projectOption.MySiteTypeListPage;
import com.app.ui.page.crud.site.MySiteListPage;
import com.app.ui.page.guide.base.MyGuideGroup;
import com.app.ui.page.guide.base.MyGuidePage;
import com.app.ui.page.importer.MySiteImporterPage;

public class MySiteGuidePage
    extends MyGuidePage
{
    //##################################################
    //# singleton
    //##################################################

    private static MySiteGuidePage _instance;

    public static void installInstance()
    {
        _instance = new MySiteGuidePage();
    }

    public static MySiteGuidePage getInstance()
    {
        return _instance;
    }

    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.projectWorker;
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        super.installRoot(root);

        ScDiv row;
        row = newGroupRow();
        row.add(createSummaryGroup());
        row.add(createSitesGroup());

        row = newGroupRow();
        row.add(createReportsGroup());
        row.add(createSetupGroup());
    }

    //==================================================
    //= install :: summary
    //==================================================

    private ScControl createSummaryGroup()
    {
        MyGuideGroup group;
        group = newSummaryGroup();

        group.addTextSection(
            "Sites",
            ""
                + "Each site generally corresponds to a physical building, with "
                + "a specific street address. Many projects are organized as a list "
                + "of sites to completed serviced. "
                + "");

        return group;
    }

    //==================================================
    //= install :: sites
    //==================================================

    private ScControl createSitesGroup()
    {
        MyGuideGroup group;
        group = newListGroup("Site List");

        group.addPageSection(
            MySiteListPage.getInstance(),
            "Site List",
            ""
                + "Add and modify sites. In addition to basic attributes such as "
                + "ceiling height and street address, each site also tracks additional "
                + "information such as roadmaps, shipments, contacts, and visits."
                + "");

        group.addPageSection(
            MySiteImporterPage.getInstance(),
            "Import (CSV)",
            ""
                + "Import sites from a spreadsheet. This can be used to import sites "
                + "in bulk from a spreadsheet or another application. "
                + "");

        return group;
    }

    //==================================================
    //= install :: reports
    //==================================================

    private ScControl createReportsGroup()
    {
        MyGuideGroup group;
        group = newReportGroup();
        group.addTextSection("None", "No site reports yet.");
        return group;
    }

    //==================================================
    //= install :: setup
    //==================================================

    private ScControl createSetupGroup()
    {
        MyGuideGroup group;
        group = newSetupGroup();

        group.addPageSection(
            MySiteTypeListPage.getInstance(),
            "Site Types",
            ""
                + "Types are used to organize sites into various categories such as: "
                + "restaurant, warehouse, corporate. "
                + "");

        return group;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();
    }

}
