@setlocal
@call %~dp0%kmSetEnv.bat

pushd ..\..

echo %awscli_home%\aws %*
"%awscli_home%\aws" --region us-east-1 %*
set cmdResult=%errorlevel%

popd

exit /B %cmdResult%
