Paragon Server Ajax
======================

Purpose
-------

    This repository is intended to provide a sandbox for developing
    samples of the functionality that we can build with new "HTML 5"
    apps. This framework relies heavily on ajax and relatively modern
    browser support. Although no there are no specific tests cases,
    the features of this framework are generally compatible with major
    desktop browsers such as IE and Chrome available in 2015.

    Accucode Inc has allowed this entire project to be licenced as
    open source.  This is done to encourage staff contribution,
    and to provide an open source foundation that we can utilize
    on various projects.

    Because this project is developed as open source, every effort
    must be made to avoid including anything that would violate the
    ability to bundle and distribute this project as open source.


License
-------

    Open Source MIT License.


Minimum requirements
--------------------

    Java 1.8
    Tomcat 8
    Ant 1.9
    MySql 5.6

Eclipse
-------

    Neon, IDE for Java Developers, 64-bit.

Eclipse.ini
-----------
    We typically increase the memory allocation.
    This is done via the eclipse.ini file in the root folder.
    In particular, use the following settings.

    -Xms512m
    -Xmx4048m


Eclipse Plugins
---------------

    AnyEdit
        Convert tabs to spaces.
        Convert tabs inside line (not just prefix)



Node.js
-------

    This project relies on Node.js.
    In particular, we use it for the Stylus css preprocessor.
    Install Node with NPM (package manager).


Stylus (css preprocessor)
-------------------------

    We use Stylus as a css preprocessor.
    https://learnboost.github.io/stylus/

    If you already have Node.js installed, you can install
    Stylus from a command shell using:

    npm install stylus -g


Third party libraries
---------------------

    There are a number of third party libraries.  These include
    java .jar file, as well as other formats such as html, javascript,
    various image files, etc...  Only open source libraries that can
    be safely redistributed should be included.

    All third party libraries should be documented in credits.txt.


Installation instructions
-------------------------

    web/WEB-INF/resource/doc/index.html


Hosts
-------------------------

This application implements multi-tenant support by using
different host names for each tenant. For example when using
two tenants (system, example) the corresponding host names are:

    system.localhost
    example.localhost

In order for local development testing to work correctly
this requires that you update your "hosts" file with the
pertinent entries.

    /Windows/System32/drivers/etc/hosts

For example

    127.0.0.1           localhost
    127.0.0.1           system.localhost
    127.0.0.1           example.localhost

After updating, you may need to reboot for the changes to take effect.


end.
-------------------------
