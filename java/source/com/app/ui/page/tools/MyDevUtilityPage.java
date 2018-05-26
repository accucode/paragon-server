package com.app.ui.page.tools;

import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScText;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.time.KmTimeZone;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.Kmu;

import com.app.property.MyPropertyManager;
import com.app.ui.core.MyServletData;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;
import com.app.utility.MyUidSequenceTest;

public final class MyDevUtilityPage
    extends MyPage
{
    //##################################################
    //# singleton
    //##################################################

    private static MyDevUtilityPage _instance;

    public static void installInstance()
    {
        _instance = new MyDevUtilityPage();
    }

    public static MyDevUtilityPage getInstance()
    {
        return _instance;
    }

    private MyDevUtilityPage()
    {
        // singleton
    }

    //##################################################
    //# variables
    //##################################################

    private ScText _userAgentText;
    private ScText _isFirefoxText;
    private ScText _isInternetExplorerText;
    private ScText _utcText;
    private ScText _localText;
    private ScText _denverText;

    //##################################################
    //# settings
    //##################################################

    @Override
    public final MySecurityLevel getSecurityLevel()
    {
        return MySecurityLevel.developer;
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().fill().auto();

        ScDiv row;
        row = root.addDiv();
        row.css().flexRow().flexWrap().boxGray().gap();

        installSingleVmGroup(row);
        installExceptionGroup(row);
        installTimeGroup(row);
        installTestGroup(row);
        installRequestGroup(row);
    }

    private void installSingleVmGroup(ScContainer root)
    {
        ScGroup group;
        group = root.addGroup("Single VM");
        group.layoutInline();

        ScDiv body;
        body = group.getBody();
        body.css().flexColumn().columnSpacer5().pad();
        body.addLink("garbage collection", newCheckedAction(this::handleGarbageCollection));
        body.addLink("reload properties", newCheckedAction(this::handleReloadProperties));
    }

    private void installExceptionGroup(ScContainer root)
    {
        ScGroup group;
        group = root.addGroup("Exceptions");
        group.layoutInline();

        ScDiv body;
        body = group.getBody();
        body.css().flexColumn().pad().columnSpacer5();
        body.addLink("message", newCheckedAction(this::handleMessage));
        body.addLink("error", newCheckedAction(this::handleError));
        body.addLink("fatal", newCheckedAction(this::handleFatal));
        body.addLink("runtime exception", newCheckedAction(this::handleRuntimeException));
    }

    private void installTimeGroup(ScContainer root)
    {
        _utcText = new ScText();
        _utcText.setLabel("Utc");

        _localText = new ScText();
        _localText.setLabel("Local");

        _denverText = new ScText();
        _denverText.setLabel("Denver");

        ScGroup group;
        group = root.addGroup("Time");
        group.layoutInline();

        ScFieldTable fields;
        fields = group.getBody().addPad().addFullWidthFieldTable();
        fields.style().width(200);
        fields.add(_utcText);
        fields.add(_localText);
        fields.add(_denverText);
    }

    private void installTestGroup(ScContainer root)
    {
        ScGroup group;
        group = root.addGroup("Tests");
        group.layoutInline();

        ScDiv body;
        body = group.getBody();
        body.css().flexColumn().pad().columnSpacer5();
        body.addLink("uid sequence", newCheckedAction(this::handleUidSequence));
    }

    private void installRequestGroup(ScContainer root)
    {
        _userAgentText = new ScText();
        _userAgentText.setLabel("UserAgent");

        _isInternetExplorerText = new ScText();
        _isInternetExplorerText.setLabel("isIE");

        _isFirefoxText = new ScText();
        _isFirefoxText.setLabel("isFirefox");

        ScGroup group;
        group = root.addGroup("Request / Response");
        group.layoutInline();

        ScFieldTable fields;
        fields = group.getBody().addPad().addFullWidthFieldTable();
        fields.add(_userAgentText);
        fields.add(_isInternetExplorerText);
        fields.add(_isFirefoxText);
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        MyServletData data = getData();

        String userAgent = data.getUserAgent();
        boolean isIE = data.isUserAgentInternetExplorer();
        boolean isFirefox = data.isUserAgentFirefox();

        KmTimestamp now = getNowUtc();
        KmTimeZone denverTz = KmTimeZone.Mountain;
        KmTimestamp localTs = now.toLocal();
        KmTimestamp denverTs = now.toLocal(denverTz);

        _userAgentText.setFormattedValue(userAgent);
        _isInternetExplorerText.setFormattedValue(isIE);
        _isFirefoxText.setFormattedValue(isFirefox);

        _utcText.setFormattedValue(now);
        _localText.setFormattedValue(localTs);
        _denverText.setFormattedValue(denverTs);
    }

    //##################################################
    //# handle
    //##################################################

    private void handleGarbageCollection()
    {
        Runtime rt;
        rt = Runtime.getRuntime();
        rt.gc();
        rt.gc();

        long free = rt.freeMemory();
        long total = rt.totalMemory();
        long max = rt.maxMemory();
        long used = total - free;

        KmStringBuilder out;
        out = new KmStringBuilder();
        out.printfln("Used: %s", Kmu.formatInteger(used));
        out.printfln("Free: %s", Kmu.formatInteger(free));
        out.printfln("Total: %s", Kmu.formatInteger(total));
        out.printfln("Max: %s", Kmu.formatInteger(max));

        ajax().toast(out.toString()).sticky();
    }

    private void handleReloadProperties()
    {
        MyPropertyManager.reloadOverrides();
        ajax().toast("Properties reloaded.");
    }

    private void handleMessage()
    {
        Object[] args = {};
        ajax().toast("test", args);
    }

    private void handleError()
    {
        throw Kmu.newError("test");
    }

    private void handleFatal()
    {
        throw Kmu.newFatal("test");
    }

    private void handleRuntimeException()
    {
        throw new RuntimeException("test");
    }

    private void handleUidSequence()
    {
        boolean ok = MyUidSequenceTest.test();

        if ( ok )
            ajax().toast("Uid sequence ok.").success();
        else
            ajax().toast("Uid sequence FAILED.").warn();
    }
}
