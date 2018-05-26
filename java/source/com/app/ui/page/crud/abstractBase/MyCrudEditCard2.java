package com.app.ui.page.crud.abstractBase;

import com.kodemore.domain.KmUidDomainIF;
import com.kodemore.servlet.control.ScDiv;

/**
 * I am used to EDIT a (child) domain.
 *
 * Subclasses are required to implement a minimal number of abstract methods,
 * which are documented below.
 *
 * The PARENT type is NOT specified since the parent is not needed for editing.
 * @param <C> The domain CHILD.
 */

/**
 * todo_wyatt: z refactor edit cards
 * Convert all edit cards to this.
 * Then delete the old crud edit card.
 */
public abstract class MyCrudEditCard2<C extends KmUidDomainIF>
    extends MyCrudEditCard<C>
{
    //##################################################
    //# constructor
    //##################################################

    public MyCrudEditCard2(MyCrudBuilder<?,C> e)
    {
        super(e);
    }

    //##################################################
    //# layout
    //##################################################

    @Override
    protected final MyCrudLayout getDetailLayout()
    {
        return null;
    }

    @Override
    protected final void installBodyCss(ScDiv body)
    {
        // none
    }

    @Override
    protected final ScDiv installDetailViewOn(ScDiv body)
    {
        installBody(body);
        return body;
    }

    @Override
    protected final void installDetailsOn(ScDiv root)
    {
        // none
    }

    protected abstract void installBody(ScDiv body);

}
