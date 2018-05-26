package com.app.model.transfer;

import com.kodemore.utility.KmEnumIF;

public enum MyTransferAction
    implements KmEnumIF
{
    NoSource,
    Add,
    SkipAdd,
    SkipUpdate,
    AlreadyUpdated,
    Error,
    Update,
    Exists
}
