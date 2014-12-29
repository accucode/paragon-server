Paragon Server
======================

Purpose
-------

    This repository is intended to provide a sandbox for developing
    samples of the functionality that we can build with new "HTML 5" 
    apps.

    AccuCode Inc has allowed this entire project to be licenced as
    open source under the Apache License.  This is done to encourage 
    staff contribution, and to provide an open source foundation that
    we can utilize on various project.
    
    Because this project is developed as open source, every effort
    must be made to avoid including anything that would violate the
    ability to bundle and distribute this project as open source.
        
License
-------

    The souce code is primarily licensed under the MIT license.
    
Minimum requirements
--------------------

    Java 1.7
    Tomcat 7
    Ant 1.8

Eclipse
-------

    * We use Luna or later.
    * Disable the auto-indent on save. 
    * See [here](http://goo.gl/y5S39B).

Third party libraries
---------------------

    There are a number of third party libraries.  These include
    java .jar file, as well as other formats such as html, javascript,
    various image files, etc...  Only open source libraries that can
    be safely redistributed should be included.
    
    A summary of third party licenses are listed in:
    
        * $project/credits.txt
        * $project/web/WEB-INF/lib/_credits.txt
        
Installation instructions 
-------------------------

	web/WEB-INF/resource/doc/index.html

Setup
-------------------------
    There are several things that should be reviewed when using this
    as a source for new projects:
    
        $project/java/source/com/app/utility/MyConstantsIF.java
        Also, do a text search for all references to "accucode".
	
end.
