package com.kodemore.generator.extend;

import com.kodemore.generator.model.KmgModel;
import com.kodemore.generator.model.KmgModelField;
import com.kodemore.proto.KmProtoType;
import com.kodemore.utility.Kmu;

public class KmgUtcTsFieldExtender
    extends KmgFieldExtender
{
    @Override
    public void extend(KmgModelField field)
    {
        KmProtoType baseType = field.getProtoType();
        if ( baseType == null )
            Kmu.error("invalid base type for: " + field.getType().getName());

        if ( !baseType.isTimestamp() )
            return;

        String suffix = "UtcTs";
        if ( !field.getName().endsWith(suffix) )
            return;

        String name;
        String label;
        String body;
        String type;

        String prefix;
        prefix = Kmu.removeSuffix(field.getName(), suffix);

        KmgModel model;
        model = field.getModel();

        name = prefix + "LocalTs";
        label = Kmu.capitalizeWords(prefix);
        body = Kmu.format("return KmTimestampUtility.toLocal(%s());", field.getf_getMethod());
        type = "timestamp";
        KmgModelField localTs = model.addCustomGetter(name, label, body, type);

        name = prefix + "LocalTsMessage";
        label = Kmu.capitalizeWords(prefix);
        body = Kmu.format(
            "return KmTimestampUtility.formatLocalMessage(%s());",
            field.getf_getMethod());
        type = "text100";
        model.addCustomGetter(name, label, body, type);

        name = prefix + "LocalDate";
        label = Kmu.capitalizeWords(prefix);
        body = Kmu.format("return KmTimestampUtility.getDate(%s());", localTs.getf_getMethod());
        type = "date";
        model.addCustomGetter(name, label, body, type);

        name = prefix + "LocalTime";
        label = Kmu.capitalizeWords(prefix);
        body = Kmu.format("return KmTimestampUtility.getTime(%s());", localTs.getf_getMethod());
        type = "time";
        model.addCustomGetter(name, label, body, type);
    }
}
