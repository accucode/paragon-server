package com.app.ui.page.tools;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScFlexbox;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScText;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.Kmu;

import com.app.model.MyTimeZone;
import com.app.property.MyPropertyManager;
import com.app.ui.core.MyServletData;
import com.app.ui.page.MyPage;
import com.app.ui.page.MySecurityLevel;

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
    //# bookmark
    //##################################################

    @Override
    public void composeBookmarkOn(ScParameterList v)
    {
        // none
    }

    @Override
    public void applyBookmark(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css();

        ScFlexbox row;
        row = root.addRow();
        row.css().gap();
        row.wrap();

        installSingleVmGroup(row);
        installExceptionGroup(row);
        installTimeGroup(row);
        installRequestGroup(row);
    }

    private void installSingleVmGroup(ScContainer root)
    {
        ScGroup group;
        group = root.addInlineGroup("Single VM");

        ScBox box;
        box = group.getBody().addLinkBox();
        box.addLink("garbage collection", this::handleGarbageCollection);
        box.addLink("reload properties", this::handleReloadProperties);
    }

    private void installExceptionGroup(ScContainer root)
    {
        ScGroup group;
        group = root.addInlineGroup("Exceptions");

        ScBox box;
        box = group.getBody().addLinkBox();
        box.addLink("message", this::handleMessage);
        box.addLink("error", this::handleError);
        box.addLink("fatal", this::handleFatal);
        box.addLink("runtime exception", this::handleRuntimeException);
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
        group = root.addInlineGroup("Time");

        ScFieldTable fields;
        fields = group.getBody().addPad().addFieldTable();
        fields.style().width(200);
        fields.add(_utcText);
        fields.add(_localText);
        fields.add(_denverText);
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
        group = root.addInlineGroup("Request / Response");

        ScFieldTable fields;
        fields = group.getBody().addPad().addFieldTable();
        fields.add(_userAgentText);
        fields.add(_isInternetExplorerText);
        fields.add(_isFirefoxText);
    }

    //##################################################
    //# print
    //##################################################

    @Override
    public void preRender()
    {
        MyServletData data = getData();

        String userAgent = data.getUserAgent();
        boolean isIE = data.isUserAgentInternetExplorer();
        boolean isFirefox = data.isUserAgentFirefox();

        KmTimestamp now = getNowUtc();
        MyTimeZone denverTz = MyTimeZone.MSTD;
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
        Runtime rt = Runtime.getRuntime();
        long max = rt.maxMemory();
        long free1 = rt.freeMemory();
        rt.gc();
        long free2 = rt.freeMemory();

        KmStringBuilder out;
        out = new KmStringBuilder();
        out.printfln("Max: %s", Kmu.formatInteger(max));
        out.printfln("Free Before: %s", Kmu.formatInteger(free1));
        out.printfln("Free After: %s", Kmu.formatInteger(free2));
        out.printfln("Reclaimed: %s", Kmu.formatInteger(free2 - free1));

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

}
