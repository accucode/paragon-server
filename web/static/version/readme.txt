All files under the "version" folder will be reloaded each time we 
deploy a new version of the application.  This is primarily intended
for locally managed files that lack formal versioning.  However, in
practice, we have currently moved ALL static resources under this 
folder to simplify file management and improve consistency.

We configure the web server (apache httpd) to request that browsers 
cache all static resources "forever" (e.g.: for a year).  This 
increases the applications performance.  However, this also means 
that extra care needs to be taken to ensure that clients receive 
up-to-date versions when those resources change.

For third party libraries we use an explicit number as part of the
file name, or more commonly, as part of the path.  It is the 
developer's reponsibility to ensure that the version number is 
updated any time there is a change to the library.  Typically,
this is simply a matter of downloading and installing the new
version of the library into a new folder with an appropriate
version number.

For libraries that are actively maintained as part of the application
development, we typically do NOT want to modify file and/or folder 
names (for many reasons).  Instead we place volitile files under
this "version" folder.  When running in production we replace all
paths downstream of version with a path based on the applications
current version number.  E.g.:

    /static/version/readme.txt
    
becomes

    /static/version-Build-100101-1/readme.txt
    
Then ensures that anytime we deploy a new version of the application,
all client browsers will immediately download current versions of the
application managed resources.

The versioning mechanism is only used in production and is controlled
a property (webResourceVersioningEnabled).  A rewrite rule in the apache 
httpd server changes the /version-Build-100101/ back to /version/ so 
that the static resources can be found on the file system.
