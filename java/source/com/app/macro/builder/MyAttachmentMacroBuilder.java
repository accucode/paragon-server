package com.app.macro.builder;

import com.app.macro.MyMacroDomainType;
import com.app.model.MyAttachment;
import com.app.model.meta.MyMetaAttachment;

/**
 * I build the macros for a specific domain type.
 */
public class MyAttachmentMacroBuilder
    extends MyAbstractMacroBuilder
{
    //##################################################
    //# setup
    //##################################################

    @Override
    protected MyMacroDomainType getDomainType()
    {
        return MyMacroDomainType.Attachment;
    }

    //##################################################
    //# install
    //##################################################

    @Override
    protected void addAll()
    {
        MyMetaAttachment x = MyAttachment.Meta;

        addText("Name", "file001.pdf", x.Name);
    }
}
