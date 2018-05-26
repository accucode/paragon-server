package com.app.ui.page.guide;

import com.kodemore.servlet.ScPage;
import com.kodemore.servlet.control.ScButton;
import com.kodemore.servlet.control.ScCardFrame;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScImage;
import com.kodemore.servlet.control.ScPageButton;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.utility.Kmu;

import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;
import com.app.utility.MyButtonUrls;

public abstract class MyAbstractSetupGuidePage
    extends MyPage
{
    //##################################################
    //# settings
    //##################################################

    @Override
    public MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.projectManager;
    }

    //##################################################
    //# variables
    //##################################################

    private ScCardFrame _frame;

    private ScControl _infoCard;
    private ScControl _detailsCard;
    private ScControl _listCard;
    private ScControl _transferCard;
    private ScControl _importCard;
    private ScControl _defaultsCard;

    //##################################################
    //# accessing
    //##################################################

    public ScControl getInfoCard()
    {
        return _infoCard;
    }

    public ScControl getDetailsCard()
    {
        return _detailsCard;
    }

    public ScControl getListCard()
    {
        return _listCard;
    }

    public ScControl getTransferCard()
    {
        return _transferCard;
    }

    public ScControl getImportCard()
    {
        return _importCard;
    }

    public ScControl getDefaultsCard()
    {
        return _defaultsCard;
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().flexRow().rowSpacer20();

        root.add(createLeftColumn());
        root.add(createRightColumn());
    }

    //==================================================
    //= install :: left
    //==================================================

    private ScControl createLeftColumn()
    {
        ScDiv e;
        e = new ScDiv();
        e.css().flexColumn().columnSpacer20().flexChildSmall0();

        e.add(createInstructionsGroup());

        return e;
    }

    private ScControl createInstructionsGroup()
    {
        ScGroup e;
        e = new ScGroup();
        e.setTitle(getInstructionGroupTitle());
        e.setDetachedBody();
        e.css().flexChildFiller();

        installInstructionHeaderOn(e);
        installInstructionFooterOn(e);

        ScDiv body;
        body = e.getBody();
        body.css().pad5().columnSpacer20().auto();

        installInstructionsOn(body);

        return e;
    }

    private String getInstructionGroupTitle()
    {
        return Kmu.format("Setup %s", getPluralizedDomainName());
    }

    private String getPluralizedDomainName()
    {
        return Kmu.pluralize(getDomainName());
    }

    protected abstract String getDomainName();

    protected void installInstructionHeaderOn(ScGroup e)
    {
        ScDiv hearder;
        hearder = e.showHeader();
        hearder.css().pad10();

        ScButton b;
        b = hearder.addButton(" Return to Project Setup", MyProjectSetupHomePage.getInstance());
        b.setFlavorIcon();
        b.css().colorBlack();
        b.setIcon().nameHome();
    }

    //==================================================
    //= install :: nav buttons
    //==================================================

    protected abstract ScPage getPreviousPage();

    protected abstract ScPage getNextPage();

    private void installInstructionFooterOn(ScGroup e)
    {
        boolean hasPreviousPage = getPreviousPage() != null;
        boolean hasNextPage = getNextPage() != null;

        if ( !hasPreviousPage && !hasNextPage )
            return;

        ScDiv footer;
        footer = e.showFooter();
        footer.css().flexRow().pad10();

        if ( hasPreviousPage )
            footer.add(createPreviousButton());

        footer.addFlexChildFiller();

        if ( hasNextPage )
            footer.add(createNextButton());
    }

    private ScControl createPreviousButton()
    {
        ScPage page = getPreviousPage();

        if ( page == null )
            return null;

        ScPageButton b;
        b = new ScPageButton();
        b.setFlavorIcon();
        b.css().colorBlack();
        b.setText(getPageName(page));
        b.setPage(page);
        b.setIcon().nameArrowBack();
        return b;
    }

    private ScControl createNextButton()
    {
        ScPage page = getNextPage();

        if ( page == null )
            return null;

        ScPageButton b;
        b = new ScPageButton();
        b.setFlavorIcon();
        b.css().colorBlack();
        b.setText(getPageName(page));
        b.setPage(page);
        b.setPostIcon().nameArrowForward();
        return b;
    }

    protected String getPreviousSetupPageName()
    {
        ScPage page = getPreviousPage();

        if ( page == null )
            return null;

        return getPageName(page);
    }

    protected String getNextSetupPageName()
    {
        ScPage page = getNextPage();

        if ( page == null )
            return null;

        return getPageName(page);
    }

    private String getPageName(ScPage page)
    {
        String title = page.getTitle();
        title = Kmu.removeSuffix(title, "Guide");
        return title;
    }

    //==================================================
    //= install :: instructions
    //==================================================

    protected abstract void installInstructionsOn(ScDiv body);

    //==================================================
    //= install :: Right
    //==================================================

    private ScControl createRightColumn()
    {
        ScDiv e;
        e = new ScDiv();
        e.css().flexColumn().columnSpacer20().flexChildPhiLarge0();

        e.add(createFrame());

        return e;
    }

    //==================================================
    //= install :: frame
    //==================================================

    private ScControl createFrame()
    {
        ScCardFrame frame;
        frame = new ScCardFrame();
        frame.css().flexColumn().flexChildFiller();

        installEmptyCardOn(frame);
        installDetailsCardOn(frame);
        installInfoCardOn(frame);
        installListCardOn(frame);
        installTransferCardOn(frame);
        installImportCardOn(frame);
        installDefaultsCardOn(frame);

        _frame = frame;
        return frame;
    }

    private void installEmptyCardOn(ScCardFrame frame)
    {
        ScDiv e;
        e = new ScDiv();
        e.css().flexColumn().flexChildFiller().flexAlignCenter().flexCrossAlignCenter();
        e.css().setupGuideEmptyCard();

        e.addTextSpan("Select an option from the left to get started.");

        frame.addDefaultCard(e);
    }

    private void installInfoCardOn(ScCardFrame frame)
    {
        ScControl e;
        e = createInfoCard();
        _infoCard = e;

        if ( e == null )
            return;

        frame.addCard(e);
    }

    private void installDetailsCardOn(ScCardFrame frame)
    {
        ScControl e;
        e = createDetailsCard();
        _detailsCard = e;

        if ( e == null )
            return;

        frame.addCard(e);
    }

    private void installListCardOn(ScCardFrame frame)
    {
        ScControl e;
        e = createListCard();
        _listCard = e;

        if ( e == null )
            return;

        frame.addCard(e);
    }

    private void installTransferCardOn(ScCardFrame frame)
    {
        ScControl e;
        e = createTransferCard();
        _transferCard = e;

        if ( e == null )
            return;

        frame.addCard(e);
    }

    private void installImportCardOn(ScCardFrame frame)
    {
        ScControl e;
        e = createImportCard();
        _importCard = e;

        if ( e == null )
            return;

        frame.addCard(e);
    }

    private void installDefaultsCardOn(ScCardFrame frame)
    {
        ScControl e;
        e = createDefaultsCard();
        _defaultsCard = e;

        if ( e == null )
            return;

        frame.addCard(e);
    }

    //==================================================
    //= install :: cards
    //==================================================

    protected ScControl createInfoCard()
    {
        return null;
    }

    protected ScControl createDetailsCard()
    {
        return null;
    }

    protected ScControl createListCard()
    {
        return null;
    }

    protected ScControl createTransferCard()
    {
        return null;
    }

    protected ScControl createImportCard()
    {
        return null;
    }

    protected ScControl createDefaultsCard()
    {
        return null;
    }

    //##################################################
    //# handle
    //##################################################

    protected void ajaxPrintInfoCard()
    {
        ScControl card = _infoCard;
        ajaxPrintCard(card);
    }

    protected void ajaxPrintDetailsCard()
    {
        ScControl card = _detailsCard;
        ajaxPrintCard(card);
    }

    protected void ajaxPrintListCard()
    {
        ScControl card = _listCard;
        ajaxPrintCard(card);
    }

    protected void ajaxPrintTransferCard()
    {
        ScControl card = _transferCard;
        ajaxPrintCard(card);
    }

    protected void ajaxPrintImportCard()
    {
        ScControl card = _importCard;
        ajaxPrintCard(card);
    }

    protected void ajaxPrintDefaultsCard()
    {
        ScControl card = _defaultsCard;
        ajaxPrintCard(card);
    }

    protected void ajaxPrintCard(ScControl card)
    {
        if ( card == null )
            return;

        _frame.ajaxPrint(card);
    }

    //##################################################
    //# support
    //##################################################

    protected ScControl newInfoSection()
    {
        String subject = getPluralizedDomainName();
        String title = "Info";
        String description = Kmu.format("View detailed information about %s.", subject);
        Runnable action = this::ajaxPrintInfoCard;
        String icon = MyButtonUrls.setupInfo();

        ScDiv e;
        e = newSection(title, description, action, icon);
        e.css().setupGuideItemBlue();
        return e;
    }

    protected ScControl newDetailsSection(String description, boolean suggested)
    {
        String title = "Details";
        Runnable action = this::ajaxPrintDetailsCard;
        String icon = MyButtonUrls.setupSheet();

        if ( suggested )
            return newSuggestedSection(title, description, action, icon);

        return newOptionSection(title, description, action, icon);
    }

    protected ScControl newListSection(boolean suggested)
    {
        String subject = getPluralizedDomainName();
        String title = "List";
        String description = Kmu.format(
            "View and manage the list of all %s for your project.",
            subject);
        Runnable action = this::ajaxPrintListCard;
        String icon = MyButtonUrls.setupList();

        if ( suggested )
            return newSuggestedSection(title, description, action, icon);

        return newOptionSection(title, description, action, icon);
    }

    protected ScControl newTransferSection(boolean suggested)
    {
        String subject = getPluralizedDomainName();
        String title = "Transfer";
        String description = Kmu.format("Transfer %s from another project.", subject);
        Runnable action = this::ajaxPrintTransferCard;
        String icon = MyButtonUrls.setupTransfer();

        if ( suggested )
            return newSuggestedSection(title, description, action, icon);

        return newOptionSection(title, description, action, icon);
    }

    protected ScControl newImportSection(boolean suggested)
    {
        String subject = getPluralizedDomainName();
        String title = "Import";
        String description = Kmu.format("Import %s from a CSV file.", subject);
        Runnable action = this::ajaxPrintImportCard;
        String icon = MyButtonUrls.setupSheet();

        if ( suggested )
            return newSuggestedSection(title, description, action, icon);

        return newOptionSection(title, description, action, icon);
    }

    protected ScControl newDefaultsSection(boolean suggested)
    {
        String subject = getPluralizedDomainName();
        String title = "Defaults";
        String description = Kmu.format("Use the suggested defaults for %s.", subject);
        Runnable action = this::ajaxPrintDefaultsCard;
        String icon = MyButtonUrls.setupSheet();

        if ( suggested )
            return newSuggestedSection(title, description, action, icon);

        return newOptionSection(title, description, action, icon);
    }

    private ScControl newSuggestedSection(
        String title,
        String description,
        Runnable action,
        String iconSource)
    {
        ScDiv e;
        e = newSection(title, description, action, iconSource);
        e.css().setupGuideItemGreen();
        return e;
    }

    private ScControl newOptionSection(
        String title,
        String description,
        Runnable action,
        String iconSource)
    {
        ScDiv e;
        e = newSection(title, description, action, iconSource);
        e.css().setupGuideItemGray();
        return e;
    }

    private ScDiv newSection(String title, String description, Runnable action, String iconSource)
    {
        ScDiv e;
        e = new ScDiv();
        e.css().flexRow().flexCrossAlignCenter().rowSpacer20().pad20().setupGuideItem();
        e.setOnClick(newCheckedAction(action));

        ScDiv col;
        col = e.addDiv();
        col.css().flexColumn().flexCrossAlignCenter().spacedBottom5();

        ScDiv label;
        label = col.addLabel(title);
        label.css().font18();

        ScImage icon;
        icon = col.addImage();
        icon.setSource(iconSource);

        col = e.addDiv();
        col.css().flexColumn().flexCrossAlignCenter();
        col.addText(description);

        return e;
    }
}
