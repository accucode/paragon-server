package com.kodemore.generator.extend;

import com.kodemore.collection.KmList;
import com.kodemore.generator.model.KmgModel;
import com.kodemore.generator.model.KmgModelEnum;
import com.kodemore.generator.model.KmgModelField;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;

public class KmgEnumNameFieldExtender
    extends KmgFieldExtender
{
    @Override
    public void extend(KmgModelField field)
    {
        if ( !field.hasEnum() )
            return;

        KmgModelEnum e = field.getEnum();
        if ( e == null )
            return;

        KmgModel model = field.getModel();
        String name = e.getName() + "Name";
        String label = getLabelFor(e);
        String help = field.getHelp();
        String body = Kmu.format("return Kmu.getName(%s());", e.getf_getMethod());
        String type = "name";

        model.addCustomGetter(name, label, help, body, type);
    }

    private String getLabelFor(KmgModelEnum e)
    {
        KmList<String> words = Kmu.getCamelCaseWords(e.getName());
        KmStringBuilder out = new KmStringBuilder();

        for ( String s : words )
        {
            out.print(Kmu.capitalizeFirstLetter(s));
            out.print(" ");
        }

        return out.toString().trim();
    }
}
