package com.kodemore.command;

import com.kodemore.exception.KmSignalingException;

/**
 * I am used to exit a dao command, causing the command to rollback, instead of
 * committing. This exception is NOT used to indicate an error, just that the
 * command should exit and rollback.
 */
public class KmDaoRollbackException
    extends KmSignalingException
{
    // none
}
