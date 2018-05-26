package com.app.model.transfer;

import com.kodemore.collection.KmMap;
import com.kodemore.collection.KmSet;
import com.kodemore.collection.KmSetImpl;
import com.kodemore.io.KmIndentPrintWriter;

import com.app.model.MyProject;

public class MyTransferRoot
    extends MyTransfer
{
    //##################################################
    //# variables
    //##################################################

    /**
     * The project FROM which we are transferring values.
     */
    private MyProject _sourceProject;

    /**
     * The project TO which we are transferring values.
     */
    private MyProject _targetProject;

    //==================================================
    //= variables :: config
    //==================================================

    /**
     * Determine whether values that already exist in the target project should
     * be updated. This is primarily useful for setup data (e.g.: depots) and is
     * less useful for operations details (jobs and notes).
     *
     * Some values can be transferred as part of an add, but cannot be subsequently
     * updated. This is mostly true for values that lack a good key such (e.g.: notes)
     * or operations data that would be too complicated to update. Supporting the
     * ability to update operational data (e.g.: jobs) is usually not critical
     * since this data is normally only transferred when cloning a project for the
     * purpose of creating a demo.
     *
     * Defaults to false.
     */
    private boolean _updateExisting;

    //==================================================
    //= variables :: include
    //==================================================

    /**
     * Determine if the 'basic timestamps' should be transferred from the source,
     * or whether they should be reset to the current time and user.
     *
     * Defaults to false.
     */
    private boolean _includeBasicTimestamps;

    /**
     * Determine if attachments should be included during the transfer.
     * This only applies if adding new/missing models (not during update).
     *
     * Defaults to false.
     */
    private boolean _includeAttachments;

    /**
     * Determine if notes should be included during the transfer.
     * This only applies if adding new/missing models (not during update).
     *
     * Defaults to false.
     */
    private boolean _includeNotes;

    //==================================================
    //= variables :: cache
    //==================================================

    /**
     * A cached record of which objects have been (are being) tranferred.
     * This uses a single map for all of the different models.
     * For any given key, the value is guaranteed to be the same class.
     *
     * Maps from => to.
     */
    private KmMap<Object,Object> _fromTo;

    /**
     * This tracks which models have been (are being) updated.
     * This is used to avoid updating the same model multiple times.
     */
    private KmSet<Object> _updated;

    //==================================================
    //= variables :: debug
    //==================================================

    /**
     * Determine if progress should be printed to system.out.
     *
     * Defaults to false.
     */
    private boolean _debug;

    private boolean _verbose;

    //##################################################
    //# constructor
    //##################################################

    public MyTransferRoot()
    {
        _fromTo = new KmMap<>();
        _updated = new KmSetImpl<>();
    }

    //##################################################
    //# tree
    //##################################################

    @Override
    public MyTransfer getParent()
    {
        return null;
    }

    @Override
    public MyTransferRoot getRoot()
    {
        return this;
    }

    //##################################################
    //# source project
    //##################################################

    public MyProject getSourceProject()
    {
        return _sourceProject;
    }

    public void setSourceProject(MyProject e)
    {
        _sourceProject = e;
    }

    //##################################################
    //# result project
    //##################################################

    @Override
    public MyProject getTargetProject()
    {
        return _targetProject;
    }

    public void setTargetProject(MyProject e)
    {
        _targetProject = e;
    }

    //##################################################
    //# update existing
    //##################################################

    public boolean getUpdateExisting()
    {
        return _updateExisting;
    }

    public void setUpdateExisting(boolean e)
    {
        _updateExisting = e;
    }

    public void updateExisting()
    {
        setUpdateExisting(true);
    }

    //##################################################
    //# timestamp
    //##################################################

    @Override
    public boolean getIncludeBasicTimestamps()
    {
        return _includeBasicTimestamps;
    }

    public void setIncludeBasicTimestamps(boolean e)
    {
        _includeBasicTimestamps = e;
    }

    public void includeBasicTimestamps()
    {
        setIncludeBasicTimestamps(true);
    }

    //##################################################
    //# notes
    //##################################################

    public boolean getIncludeNotes()
    {
        return _includeNotes;
    }

    public void setIncludeNotes(boolean e)
    {
        _includeNotes = e;
    }

    public void includeNotes()
    {
        setIncludeNotes(true);
    }

    //##################################################
    //# attachments
    //##################################################

    public boolean getIncludeAttachments()
    {
        return _includeAttachments;
    }

    public void setIncludeAttachments(boolean e)
    {
        _includeAttachments = e;
    }

    public void includeAttachments()
    {
        setIncludeAttachments(true);
    }

    //##################################################
    //# progress
    //##################################################

    public boolean getDebug()
    {
        return _debug;
    }

    public boolean getVerbose()
    {
        return _verbose;
    }

    public void debug()
    {
        _debug = true;
        _verbose = false;
    }

    public void debugVerbose()
    {
        _debug = true;
        _verbose = true;
    }

    //##################################################
    //# map
    //##################################################

    @Override
    protected final <E> void map(E from, E to)
    {
        _fromTo.put(from, to);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected final <E> E map(E from)
    {
        return (E)_fromTo.get(from);
    }

    //##################################################
    //# updated
    //##################################################

    @Override
    protected final void setUpdated(Object e)
    {
        _updated.add(e);
    }

    @Override
    protected final boolean isUpdated(Object e)
    {
        return _updated.contains(e);
    }

    //##################################################
    //# print
    //##################################################

    @Override
    public final void printOn(KmIndentPrintWriter out)
    {
        out.printfln(formatTypeName());
        out.printfln("%s => %s", formatTitle(getSourceProject()), formatTitle(getTargetProject()));
        out.printfln();

        printChildrenOn(out);
    }

}
