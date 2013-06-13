package com.kodemore.generator.extend;

import com.kodemore.collection.KmList;
import com.kodemore.generator.model.KmgModel;
import com.kodemore.generator.model.KmgModelEnum;
import com.kodemore.generator.model.KmgModelField;
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

        KmList<String> words = Kmu.getCamelCaseWords(e.getName());
        String label = "";
        for ( String s : words )
            label += Kmu.capitalizeFirstLetter(s) + " ";
        label = label.trim();

        KmgModel model = field.getModel();
        String name = e.getName() + "Name";
        String body = Kmu.format("return Kmu.getName(%s());", e.getf_getMethod());
        String type = "name";

        model.addCustomGetter(name, label, body, type);
    }
}
