package com.app.model;

import com.kodemore.utility.Kmu;

import com.app.model.base.MyMasterProductBase;

public class MyMasterProduct
    extends MyMasterProductBase
{
    //##################################################
    //# constructor
    //##################################################

    public MyMasterProduct()
    {
        super();
    }

    //##################################################
    //# accessing
    //##################################################//

    public MyProduct addDraft()
    {
        if ( hasDraftVersion() )
        {
            String msg = "Cannot create multiple drafts; publish or cancel the existing draft first.";
            throw Kmu.newError(msg);
        }

        MyProduct draft;
        MyProduct pub = getPublishedVersion();

        if ( pub != null )
        {
            draft = pub.getCopy();
            draft.setUid(newUid());
            draft.setStatusDraft();
            addVersion(draft);

            pub.setStatusArchived();
        }
        else
            draft = addVersion();

        setDraftVersion(draft);
        return draft;
    }

    public void publishDraft()
    {
        if ( !hasDraftVersion() )
            throw Kmu.newError("No draft available to publish");

        MyProduct draft = getDraftVersion();
        validateForPublish(draft);

        if ( hasPublishedVersion() )
            getPublishedVersion().setStatusArchived();

        draft.setStatusPublished();
        setPublishedVersion(draft);
        clearDraftVersion();
    }

    /**
     * Validate the draft version, to make sure it is ready to publish.
     */
    private void validateForPublish(MyProduct e)
    {
        if ( !e.hasCategory() )
            throw Kmu.newError("Category is required.");
    }

    //##################################################
    //# display
    //##################################################

    @Override
    public String getDisplayString()
    {
        return getPartNumber();
    }

}
