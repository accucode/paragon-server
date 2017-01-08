package com.kodemore.generator.model;

import com.kodemore.generator.KmgElement;
import com.kodemore.stf.KmStfElement;
import com.kodemore.utility.Kmu;

public class KmgModelAssociationReference
    extends KmgElement
{
    //##################################################
    //# variables
    //##################################################

    private String _modelName;
    private String _associationName;

    //##################################################
    //# constructor
    //##################################################

    public KmgModelAssociationReference(KmgElement parent)
    {
        super(parent);
    }

    //##################################################
    //# accessing
    //##################################################

    public String getModelName()
    {
        return _modelName;
    }

    public void setModelName(String e)
    {
        _modelName = e;
    }

    public String getAssociationName()
    {
        return _associationName;
    }

    public void setAssociationName(String e)
    {
        _associationName = e;
    }

    //##################################################
    //# abstract accessing
    //##################################################

    public KmgModel getReferenceModel()
    {
        return getRoot().getModel(getModelName());
    }

    public KmgModelAssociation getAssociation()
    {
        KmgModel m = getReferenceModel();
        if ( m == null )
            throw newError("Cannot get association for model(%s).", getModelName());
        return m.getAssociation(getAssociationName());
    }

    //##################################################
    //# parse
    //##################################################

    @Override
    public void parse(KmStfElement x)
    {
        _modelName = parseRequiredString(x, "modelName");
        _associationName = parseRequiredString(x, "associationName");
    }

    @Override
    public void validate()
    {
        if ( getReferenceModel() == null )
            throw newError("Cannot find reference model(%s).", _modelName);

        if ( getAssociation() == null )
            throw newError(
                "Cannot find reference model(%s) association(%s).",
                _modelName,
                _associationName);
    }

    @Override
    public void postValidate()
    {
        // none
    }

    //##################################################
    //# context
    //##################################################

    //##################################################
    //# display
    //##################################################

    @Override
    public String toString()
    {
        return Kmu.format("referenceAssociation(%s,%s)", _modelName, _associationName);
    }

}
