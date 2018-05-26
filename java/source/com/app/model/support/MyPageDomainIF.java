package com.app.model.support;

import com.kodemore.domain.KmUidDomainIF;

/**
 * I represent domain objects that have a primary application
 * page that can be displayed.
 */
public interface MyPageDomainIF
    extends KmUidDomainIF
{
    void ajaxEnterPage();

    String formatEntryUrl();
}
