package com.app.ui.page.tools;

import com.kodemore.servlet.ScParameterList;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.control.ScBox;
import com.kodemore.servlet.control.ScContainer;
import com.kodemore.servlet.control.ScFieldTable;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScPageRoot;
import com.kodemore.servlet.control.ScText;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.Kmu;

import com.app.model.MyTimeZone;
import com.app.property.MyPropertyManager;
import com.app.ui.core.MyServletData;

public class MyDevUtilityPage
    extends MyDevAbstractPage
{
    //##################################################
    //# singleton
    //##################################################

    public static final MyDevUtilityPage instance = new MyDevUtilityPage();

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
    //# navigation
    //##################################################

    @Override
    public ScParameterList composeQueryParameters()
    {
        return null;
    }

    @Override
    public void applyQueryParameters(ScParameterList v)
    {
        // none
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void installRoot(ScPageRoot root)
    {
        root.css().gap();

        installMiscellaneousGroup(root);
        installExceptionGroup(root);
        installTimeGroup(root);
        installRequestGroup(root);
    }

    private void installMiscellaneousGroup(ScContainer root)
    {
        ScGroup group;
        group = addGroupTo(root, "Single VM");

        ScBox box;
        box = group.addLinkBox();
        box.addLink("garbage collection", newGarbageCollectionAction());
        box.addLink("reload properties", newReloadPropertiesAction());
    }

    private void installExceptionGroup(ScContainer root)
    {
        ScGroup group;
        group = addGroupTo(root, "Exceptions");

        ScBox box;
        box = group.addLinkBox();
        box.addLink("message", newMessageAction());
        box.addLink("error", newErrorAction());
        box.addLink("fatal", newFatalAction());
        box.addLink("runtime exception", newRuntimeExceptionAction());
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
        group = addGroupTo(root, "Time");

        ScFieldTable fields;
        fields = group.addPad().addFields();
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
        group = addGroupTo(root, "Request / Response");

        ScFieldTable fields;
        fields = group.addPad().addFields();
        fields.add(_userAgentText);
        fields.add(_isInternetExplorerText);
        fields.add(_isFirefoxText);
    }

    private ScGroup addGroupTo(ScContainer root, String title)
    {
        ScGroup e;
        e = root.addGroup();
        e.setTitle(title);
        e.css().floatLeft();
        e.style().height(150);
        return e;
    }

    //##################################################
    //# actions
    //##################################################

    private ScActionIF newGarbageCollectionAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleGarbageCollection();
            }
        };
    }

    private ScActionIF newReloadPropertiesAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                handleReloadProperties();
            }
        };
    }

    private ScActionIF newMessageAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                Object[] args = {};
                ajax().toast("test", args);
            }
        };
    }

    private ScActionIF newErrorAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                error("test");
            }
        };
    }

    private ScActionIF newFatalAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                fatal("test");
            }
        };
    }

    private ScActionIF newRuntimeExceptionAction()
    {
        return new ScAction(this)
        {
            @Override
            public void handle()
            {
                throw new RuntimeException("test");
            }
        };
    }

    //##################################################
    //# print
    //##################################################

    @Override
    public void preRender()
    {
        super.preRender();

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
}
