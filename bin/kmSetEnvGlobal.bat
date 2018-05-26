set km_project_home=%~dp0%\..
set km_project_bin=%~dp0%
set km_project_java=%km_project_home%\java\source
set km_project_lib=%km_project_home%\web\WEB-INF\lib
set km_project_classes=%km_project_home%\web\WEB-INF\classes
set km_project_resource_dir=%km_project_home%\resource

set svcName=ServiceManager
set svcGenerate=%km_project_home%\java\bin\generate
set svcSource=%svcGenerate%\com\app\service
set svcTarget=%km_project_home%\java\source\com\app\service
set svcResource=%km_project_home%\resource\service

set catalina_home=%tomcat_home%

set classpath=
call %km_project_bin%\kmAddClasspath.bat %java_home%\lib\tools.jar
call %km_project_bin%\kmAddClasspath.bat %java_home%\jre\lib\rt.jar
call %km_project_bin%\kmAddClasspath.bat %km_project_classes%
call %km_project_bin%\kmAddClasspathLib.bat %km_project_lib%
call %km_project_bin%\kmAddClasspathLib.bat %km_project_home%\java\lib
call %km_project_bin%\kmAddClasspath.bat %km_project_home%\java\source
