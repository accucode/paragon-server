@setlocal
@call %~dp0%kmSetEnv.bat

pushd ..\..

echo %awscli_home%\aws %1 %2 %3 %4 %5 %6 %7 %8 %9
"%awscli_home%\aws" %1 %2 %3 %4 %5 %6 %7 %8 %9
set cmdResult=%errorlevel%

popd

Exit /B %cmdResult%

