package com.app.macro;

import com.kodemore.collection.KmList;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.KmConstantsIF;
import com.kodemore.utility.Kmu;

import com.app.model.MyAttachment;
import com.app.model.MyProject;
import com.app.model.MySite;
import com.app.model.MyTenant;
import com.app.model.MyUser;
import com.app.utility.MyGlobals;

/**
 * I represent a macro document.  I containt a list of parts and know how format
 * the final document, handling all appropriate macro substitutions.
 */
public class MyMacroDocument
{
    //##################################################
    //# constant
    //##################################################

    private static final String NONE = KmConstantsIF.NONE;

    //##################################################
    //# variables
    //##################################################

    /**
     * The specific object that acts as the context for macros.
     * E.g.: a project, visit, job, etc.
     */
    private Object _context;

    /**
     * The context (project, job, visit, etc) that we are operating
     * on. This determines which macros are available.
     */
    private MyMacroContextType _contextType;

    private KmList<MyMacroDocumentPart> _parts;

    //##################################################
    //# constructors
    //##################################################

    public MyMacroDocument()
    {
        _parts = new KmList<>();
    }
    //##################################################
    //# context
    //##################################################

    public Object getContext()
    {
        return _context;
    }

    public void setContext(Object e)
    {
        _context = e;
    }

    public MyMacroContextType getContextType()
    {
        return _contextType;
    }

    public void setContextType(MyMacroContextType type)
    {
        _contextType = type;
    }

    public boolean hasContext()
    {
        return _context != null;
    }

    //==================================================
    //= context :: domain
    //==================================================

    public void setContext(MyAttachment e)
    {
        _context = e;
        _contextType = MyMacroContextType.Attachment;
    }

    public void setContext(MyProject e)
    {
        _context = e;
        _contextType = MyMacroContextType.Project;
    }

    //==================================================
    //= context :: validate
    //==================================================

    public void validateMacroParts()
    {
        MyMacroFetcher f;
        f = new MyMacroFetcher();
        f.setContextType(getContextType());
        f.setProject(MyGlobals.getCurrentProject());

        KmList<MyMacro> macros = f.findAll();
        KmList<MyMacroDocumentPart> parts = getParts().select(e -> e.isTypeMacro());
        for ( MyMacroDocumentPart e : parts )
            if ( !macros.contains(e.getMacro()) )
                e.setTypeLiteral();
    }

    //##################################################
    //# accessing
    //##################################################

    public KmList<MyMacroDocumentPart> getParts()
    {
        return _parts;
    }

    public void setParts(KmList<MyMacroDocumentPart> v)
    {
        _parts = v;
    }

    public void addPart(MyMacroDocumentPart e)
    {
        getParts().add(e);
    }

    //##################################################
    //# format
    //##################################################

    public String formatText()
    {
        if ( !hasContext() )
            return formatSamplePlaintext();

        return _formatText();
    }

    private String _formatText()
    {
        KmStringBuilder out;
        out = new KmStringBuilder();

        for ( MyMacroDocumentPart part : _parts )
        {
            String text = formatPartText(part);
            out.print(text);
        }

        return out.toString();
    }

    private String formatPartText(MyMacroDocumentPart part)
    {
        Object e = getDomainFor(part);
        return part.formatValuePlaintext(e);
    }

    //==================================================
    //= format :: html
    //==================================================

    public String formatHtml()
    {
        if ( !hasContext() )
            return formatSampleHtml();

        return _formatHtml();
    }

    private String _formatHtml()
    {
        KmStringBuilder out;
        out = new KmStringBuilder();

        for ( MyMacroDocumentPart part : _parts )
        {
            String html = formatPartHtml(part);
            out.print(html);
        }

        return out.toString();
    }

    private String formatPartHtml(MyMacroDocumentPart part)
    {
        Object e = getDomainFor(part);
        return part.formatValueHtml(e);
    }

    //==================================================
    //= format :: sample
    //==================================================

    public String formatSamplePlaintext()
    {
        KmStringBuilder out;
        out = new KmStringBuilder();

        for ( MyMacroDocumentPart part : _parts )
            out.print(part.formatSamplePlaintext());

        return out.toString();
    }

    public String formatSampleHtml()
    {
        KmStringBuilder out;
        out = new KmStringBuilder();

        for ( MyMacroDocumentPart part : _parts )
            out.print(part.formatSampleHtml());

        return out.toString();
    }

    //##################################################
    //# domain
    //##################################################

    private Object getDomainFor(MyMacroDocumentPart part)
    {
        if ( part.isTypeLiteral() )
            return null;

        MyMacroContextType contextType = getContextType();
        switch ( contextType )
        {
            case Attachment:
                return getDomainForAttachment(part);

            case Project:
                return getDomainForProject(part);

            case Site:
                return getDomainForSite(part);

            case Tenant:
                return getDomainForTenant(part);
        }
        throw Kmu.newEnumError(contextType);
    }

    private Object getDomainForAttachment(MyMacroDocumentPart part)
    {
        MyAttachment attachment = (MyAttachment)getContext();
        MyMacroDomainType type = part.getMacroDomainType();

        switch ( type )
        {
            case Attachment:
                return attachment;

            case Tenant:
                return attachment.getTenant();

            // global tools, no domain
            case Global:
                return NONE;

            // current user
            case CurrentUser:
                return getCurrentUser();

            case Customer:
            case Project:
            case Site:
                throw Kmu.newFatal("Unexpected Macro Domain Type");
        }
        throw Kmu.newEnumError(type);
    }

    private Object getDomainForProject(MyMacroDocumentPart part)
    {
        MyProject project = (MyProject)getContext();
        MyMacroDomainType type = part.getMacroDomainType();

        switch ( type )
        {
            case Tenant:
                return project.getTenant();

            case Project:
                return project;

            // global tools, no domain
            case Global:
                return NONE;

            // current user
            case CurrentUser:
                return getCurrentUser();

            case Attachment:
            case Customer:
            case Site:
                throw Kmu.newFatal("Unexpected Macro Domain Type");
        }
        throw Kmu.newEnumError(type);
    }

    private Object getDomainForSite(MyMacroDocumentPart part)
    {
        MySite site = (MySite)getContext();
        MyMacroDomainType type = part.getMacroDomainType();

        switch ( type )
        {
            case Tenant:
                return site.getTenant();

            case Project:
                return site.getProject();

            case Site:
                return site;

            // global tools, no domain
            case Global:
                return NONE;

            // current user
            case CurrentUser:
                return getCurrentUser();

            case Attachment:
            case Customer:
                throw Kmu.newFatal("Unexpected Macro Domain Type");
        }
        throw Kmu.newEnumError(type);
    }

    private Object getDomainForTenant(MyMacroDocumentPart part)
    {
        MyTenant tenant = (MyTenant)getContext();
        MyMacroDomainType type = part.getMacroDomainType();

        switch ( type )
        {
            case Tenant:
                return tenant;

            // global tools, no domain
            case Global:
                return NONE;

            // current user
            case CurrentUser:
                return getCurrentUser();

            case Attachment:
            case Project:
            case Customer:
            case Site:
                throw Kmu.newFatal("Unexpected Macro Domain Type");
        }
        throw Kmu.newEnumError(type);
    }

    //##################################################
    //# support
    //##################################################

    private MyUser getCurrentUser()
    {
        return MyGlobals.getCurrentUser();
    }
}
