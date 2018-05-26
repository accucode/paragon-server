package com.app.ui.page.guide.base;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.action.ScSecurityManagerIF;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.utility.KmSimpleResult;
import com.kodemore.utility.Kmu;

import com.app.model.MyProject;
import com.app.model.MyUser;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;
import com.app.utility.MyGlobals;

public class MyGuideGroup
    extends ScGroup
    implements ScSecurityManagerIF
{
    //##################################################
    //# variables
    //##################################################

    private KmList<MyAbstractGuideSection> _sections;

    //##################################################
    //# constructor
    //##################################################

    public MyGuideGroup()
    {
        _sections = new KmList<>();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmList<MyAbstractGuideSection> getSections()
    {
        return _sections;
    }

    //##################################################
    //# sections
    //##################################################

    public MyGuideSection addEmptySection()
    {
        MyGuideSection e;
        e = new MyGuideSection();
        addSection(e);
        return e;
    }

    public MyGuideTextSection addTextSection(String title, String description)
    {
        MyGuideTextSection e;
        e = new MyGuideTextSection(title, description);
        addSection(e);
        return e;
    }

    public MyGuidePageSection addPageSection(MyPage page, String title, String description)
    {
        MyGuidePageSection e;
        e = new MyGuidePageSection(page, title, description);
        addSection(e);
        return e;
    }

    //    public MyGuideProjectOptionSection addOptionSection(
    //        MyProjectOptionTopic topic,
    //        String description)
    //    {
    //        MyGuideProjectOptionSection e;
    //        e = new MyGuideProjectOptionSection(topic, description);
    //        addSection(e);
    //        return e;
    //    }
    //
    //    public MyGuideProjectOptionSection addOptionSection(
    //        MyProjectOptionTopic topic,
    //        String title,
    //        String description)
    //    {
    //        MyGuideProjectOptionSection e;
    //        e = new MyGuideProjectOptionSection(topic, title, description);
    //        addSection(e);
    //        return e;
    //    }

    public void addSection(MyAbstractGuideSection e)
    {
        getBody().add(e);
        _sections.add(e);
    }

    //##################################################
    //# security
    //##################################################

    @Override
    public void checkSecurity()
    {
        MyUser u = getCurrentUser();
        MyProject p = getCurrentProject();

        KmList<MySecurityLevel> levels = getSecurityLevels();
        KmList<KmSimpleResult> results = levels.collect(e -> e.allows(u, p));

        boolean ok = results.containsIf(e -> e.isOk());
        if ( ok )
            return;

        KmList<String> errors;
        errors = results.collect(e -> e.getError());
        errors.removeNulls();

        String msg = errors.join(", or ");
        throw Kmu.newSecurityError(msg);
    }

    protected KmList<MySecurityLevel> getSecurityLevels()
    {
        return getSections().collect(e -> e.getSecurityLevel());
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        show(checkSecuritySilently());
    }

    //##################################################
    //# support
    //##################################################

    private MyUser getCurrentUser()
    {
        return MyGlobals.getCurrentUser();
    }

    private MyProject getCurrentProject()
    {
        return MyGlobals.getCurrentProject();
    }
}
