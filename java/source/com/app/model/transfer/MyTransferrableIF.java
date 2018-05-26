package com.app.model.transfer;

import com.app.model.transfer.detail.MyTransferAbstractDetail;

/**
 * I identify domain models that can be transferred from one project
 * to another. Transferrs can be within a tenant, or to a different tenant.
 */
public interface MyTransferrableIF<E extends MyTransferrableIF<E>>
{
    MyTransferAbstractDetail<E> newTransferDetail();
}
