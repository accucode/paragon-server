package com.app.ui.page.crud.project;

import com.kodemore.domain.KmUidDomainIF;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.servlet.ScBookmark;
import com.kodemore.servlet.control.ScLiteral;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.Kmu;

import com.app.model.MyProject;
import com.app.model.MyTenant;
import com.app.model.MyUser;
import com.app.ui.layout.MyPageLayoutType;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;
import com.app.utility.MyUserProxy;
import com.app.utility.MyUtility;

/**
 * I provide common behavior for 'print' pages. That is, pages
 * that are not part of the normally application flow, but that
 * are displayed as a new window for the purpose of printing content.
 *
 * I use the 'print' layout which hides the page headers and footers,
 * and also assumes NO absolute positioning. The html body is configured
 * for auto-scrolling so that multi-page content will print properly.
 *
 * I support a single uid bookmark.
 *
 */
public abstract class MyPrintDomainPage<T extends KmUidDomainIF>
    extends MyPage
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalString _domainUid;
    private ScLiteral     _message;

    //##################################################
    //# settings
    //##################################################

    /**
     * Security requires an authenticated user, but does not check
     * for project membership. Since this page does not display
     * the page header (with the project info) it doesn't make
     * sense to check the project.
     */
    @Override
    public final MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.user;
    }

    /**
     * Use the print layout to hide page headers and footers,
     * and to auto-scroll the html body.
     */
    @Override
    public final MyPageLayoutType getLayoutType()
    {
        return MyPageLayoutType.print;
    }

    /**
     * Hide this page from the JumpTo navigation menu.
     */
    @Override
    public final boolean allowsJumpTo()
    {
        return false;
    }

    //##################################################
    //# bookmark
    //##################################################

    @Override
    public MyPrintDomainBookmark newBookmark()
    {
        return new MyPrintDomainBookmark(this);
    }

    private MyPrintDomainBookmark castBookmark(ScBookmark e)
    {
        return (MyPrintDomainBookmark)e;
    }

    @Override
    protected void readStateFrom(ScBookmark o)
    {
        super.readStateFrom(o);

        MyPrintDomainBookmark e;
        e = castBookmark(o);
        _domainUid.setValue(e.getDomainUid());
    }

    @Override
    protected void writeStateTo(ScBookmark o)
    {
        super.writeStateTo(o);

        MyPrintDomainBookmark e;
        e = castBookmark(o);
        e.setDomainUid(_domainUid.getValue());
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected final void installRoot(ScPageRoot root)
    {
        root.css().pad();

        _domainUid = new ScLocalString();
        _message = root.addLiteral();
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected final void preRender()
    {
        _message.setValue(formatHtml());
    }

    //##################################################
    //# domain
    //##################################################

    private T findDomain()
    {
        String uid = _domainUid.getValue();
        return findDomainUid(uid);
    }

    protected abstract T findDomainUid(String uid);

    //##################################################
    //# format html
    //##################################################

    private String formatHtml()
    {
        MyUser user = getCurrentUser();
        if ( user == null )
            return formatHtml("No user.");

        T domain = findDomain();
        if ( domain == null )
            return formatHtml("Cannot determine domain.");

        MyTenant currentTenant = getCurrentTenant();
        MyTenant domainTenant = MyUtility.getTenantFor(domain);
        if ( !Kmu.isEqual(currentTenant, domainTenant) )
            return formatHtml("Invalid domain.");

        return formatHtml(domain);
    }

    protected abstract String formatHtml(T domain);

    //##################################################
    //# support
    //##################################################

    protected final String formatHtml(String msg, Object... args)
    {
        KmHtmlBuilder out;
        out = new KmHtmlBuilder();
        out.printfln(msg, args);
        return out.toString();
    }

    protected boolean allowsProjectMember(MyProject project)
    {
        MyUser user = getCurrentUser();
        MyUserProxy proxy = MyUserProxy.createProxy(user, project);
        return proxy.allowsProjectMember();
    }

}
