package com.app.model;

import com.app.model.support.MyPersonNameIF;

public interface MyContactIF
    extends MyPersonNameIF
{
    //##################################################
    //# title
    //##################################################

    String getTitle();

    void setTitle(String e);

    //##################################################
    //# phone
    //##################################################

    String getPhone();

    void setPhone(String e);

    //##################################################
    //# email
    //##################################################

    String getEmail();

    void setEmail(String e);

    boolean hasEmail();
}
