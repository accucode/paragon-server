@setlocal
@call %~dp0%kmSetEnv.bat

set java_opts=-mx512m
"%tomcat_home%\bin\startup.bat"
