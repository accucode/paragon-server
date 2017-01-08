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
            throw Kmu.newFatal("invalid base type for: " + field.getType().getName());

        if ( !baseType.isTimestamp() )
            return;

        String suffix = "UtcTs";
        if ( !field.getName().endsWith(suffix) )
            return;

        String name;
        String help;
        String body;
        String type;

        String prefix = Kmu.removeSuffix(field.getName(), suffix);
        String label = Kmu.formatCamelCaseAsCapitalizedWords(prefix);
        KmgModel model = field.getModel();

        name = prefix + "LocalTs";
        help = Kmu.format(
            "The %s timestamp converted to the user's local timezone.",
            label.toLowerCase());
        body = Kmu.format("return KmTimestampUtility.toLocal(%s());", field.getf_getMethod());
        type = "timestamp";
        KmgModelField localTs = model.addCustomGetter(name, label, help, body, type);

        name = prefix + "LocalTsMessage";
        help = Kmu.format(
            "The %s timestamp converted to the user's local timezone, "
                + "and formatted as a string that includes the timezone code.",
            label.toLowerCase());
        body = Kmu.format(
            "return KmTimestampUtility.formatLocalMessage(%s());",
            field.getf_getMethod());
        type = "text100";
        model.addCustomGetter(name, label, help, body, type);

        name = prefix + "LocalDate";
        help = Kmu.format("The %s date based on the user's local timezone.", label.toLowerCase());
        body = Kmu.format("return KmTimestampUtility.getDate(%s());", localTs.getf_getMethod());
        type = "date";
        model.addCustomGetter(name, label, help, body, type);

        name = prefix + "LocalTime";
        help = Kmu.format(
            "The %s time of day based on the user's local timezone.",
            label.toLowerCase());
        body = Kmu.format("return KmTimestampUtility.getTime(%s());", localTs.getf_getMethod());
        type = "time";
        model.addCustomGetter(name, label, help, body, type);
    }
}
