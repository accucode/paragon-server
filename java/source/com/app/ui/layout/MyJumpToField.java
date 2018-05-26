package com.app.ui.layout;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.ScPage;
import com.kodemore.servlet.field.ScAutoCompleteField;
import com.kodemore.utility.Kmu;

import com.app.ui.page.MyPageRegistry;

public class MyJumpToField
    extends ScAutoCompleteField
{
    //##################################################
    //# constructor
    //##################################################

    public MyJumpToField()
    {
        setPlaceholder("Jump to... (alt-/)");
        setHelp(
            ""
                + "Quickly jump to any page that you have access to. "
                + "You can also use the hotkey alt-/.");
        onSelect(newCheckedAction(this::handleSelect));
        disableChangeTracking();
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        KmList<String> titles = getJumpToPages().collect(e -> e.getTitle());
        addOptions(titles);
    }

    //##################################################
    //# public
    //##################################################

    /**
     * Called by external clients to trigger a jump-to using
     * the currently value in my text field.
     */
    public void jumpTo()
    {
        String title = getValue();
        ajaxJumpToPage(title);
    }

    //##################################################
    //# handle
    //##################################################

    private void handleSelect()
    {
        String title = getData().getExtraParameter();
        ajaxJumpToPage(title);
    }

    //##################################################
    //# ajax
    //##################################################

    private void ajaxJumpToPage(String title)
    {
        if ( Kmu.isEmpty(title) )
            return;

        ScPage page = findBestPageForTitle(title);
        if ( page == null )
        {
            ajaxToast("No such page.");
            return;
        }

        clearValue();
        ajaxUpdateFieldValues();

        page.ajaxEnter();
    }

    private ScPage findBestPageForTitle(String title)
    {
        double bestScore = 0;
        ScPage bestPage = null;
        KmList<String> titleWords = toWords(title);

        for ( ScPage page : getJumpToPages() )
        {
            double score = scorePage(page, titleWords);
            if ( score > bestScore )
            {
                bestScore = score;
                bestPage = page;
            }
        }

        return bestPage;
    }

    private double scorePage(ScPage e, KmList<String> titleWords)
    {
        KmList<String> pageWords = toWords(e.getTitle());

        if ( pageWords.containsSame(titleWords) )
            return 100;

        int matches = pageWords.countIf(pageWord -> startsWithAny(pageWord, titleWords));
        int count = pageWords.size();

        return 1.0 * matches / count + count / 10.0;
    }

    private boolean startsWithAny(String s, KmList<String> prefixes)
    {
        for ( String prefix : prefixes )
            if ( s.startsWith(prefix) )
                return true;

        return false;
    }

    private KmList<String> toWords(String s)
    {
        return Kmu.getWords(s.toLowerCase());
    }

    //##################################################
    //# jump to
    //##################################################

    private KmList<ScPage> getJumpToPages()
    {
        return getPageRegistry().getPages().select(e -> allowsJumpTo(e));
    }

    private boolean allowsJumpTo(ScPage e)
    {
        return e.allowsJumpTo() && e.checkSecuritySilently();
    }

    //##################################################
    //# support
    //##################################################

    private MyPageRegistry getPageRegistry()
    {
        return MyPageRegistry.getInstance();
    }
}
