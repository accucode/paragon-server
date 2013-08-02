@setlocal
@call %~dp0%kmSetEnv.bat

set java_opts=-mx64m
"%tomcat_home%\bin\shutdown.bat"
