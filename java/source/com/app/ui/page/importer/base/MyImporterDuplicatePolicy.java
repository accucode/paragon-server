package com.app.ui.page.importer.base;

import com.kodemore.utility.KmEnumIF;

public enum MyImporterDuplicatePolicy
    implements KmEnumIF
{
    /**
     * Duplicates are treated as an errors. This is the default.
     */
    ErrorOnDuplicates,

    /**
     * Duplicates are simply skipped / ignored.
     */
    SkipDuplicates,

    /**
     * Duplicates are updated, preserving their key and updating other attributes.
     */
    UpdateDuplicates;
}
