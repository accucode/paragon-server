package com.kodemore.generator.model;

public interface KmgModelConstantsIF
{
    //##################################################
    //# formats
    //##################################################

    String MINIMUM_LENGTH            = "minimumLength";
    String MAXIMUM_LENGTH            = "maximumLength";
    String TYPE                      = "type";
    String BASE_TYPE                 = "baseType";
    String DECIMAL_LENGTH            = "allDigits";
    String DECIMAL_MANTISSA_LENGTH   = "rightDigits";
    String ALLOWS                    = "allows";

    //##################################################
    //# types
    //##################################################

    /**
     * postCopy support:
     *      Update AcDaoField.requiresPostCopy for any new
     *      mutable type.
     */

    String INTEGER                   = "integer";
    String LONG                      = "long";
    String STRING                    = "string";
    String DATE                      = "date";
    String TIME                      = "time";
    String TIMESTAMP                 = "timestamp";
    String DOUBLE                    = "double";
    String BOOLEAN                   = "boolean";
    String LIST                      = "list";
    String VOID                      = "void";
    String DECIMAL                   = "decimal";
    String MONEY                     = "money";
    String KILOGRAM                  = "kilogram";
    String FREQUENCY                 = "frequency";
    String WEIGHT                    = "weight";
    String BYTES                     = "bytes";

    //##################################################
    //# constraints
    //##################################################

    String ALLOWS_ALL                = "all";
    String ALLOWS_PRINTABLE          = "printable";
    String ALLOWS_LETTERS            = "letters";
    String ALLOWS_DIGITS             = "digits";
    String ALLOWS_SYMBOLS            = "symbols";
    String ALLOWS_WHITESPACE         = "whitespace";

    //##################################################
    //# other
    //##################################################

    int    SQL_STRING_AS_CHAR_LENGTH = 10;
}
