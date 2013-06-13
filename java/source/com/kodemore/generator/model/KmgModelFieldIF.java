package com.kodemore.generator.model;

import com.kodemore.proto.KmProtoType;

public interface KmgModelFieldIF
{
    //##################################################
    //# accessing
    //##################################################

    KmgModel getModel();

    String getName();

    KmgModelType getType();

    KmProtoType getProtoType();

    //##################################################
    //# testing
    //##################################################

    boolean isAbstract();

    boolean isString();

    boolean isBoolean();

    boolean isRequired();

    //##################################################
    //# format
    //##################################################

    String getf_Type();

    String getf_ADAPTOR();

    String getf_COMPARATOR();

}
