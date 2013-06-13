package com.kodemore.property.type;

public interface KmPropertyTypeIF
{
    //##################################################
    //# accessing
    //##################################################

    String getName();

    Object validateValue(String key, String value);

    Object convertValue(String key, String value);

    //##################################################
    //# code generation
    //##################################################

    /**
     * Return the method named used to access the typed value.
     * This is used with code-generation.
     */
    String formatGetValueFor();

    /**
     * Return the java type as a string; this is used in code generation.
     */
    String formatJavaType();
}
