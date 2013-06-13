@setlocal
@call %~dp0%kmSetEnv.bat

pushd ..\..

echo Java %1 %2 %3 %4 %5 %6 %7 %8 %9
"%java_home%\bin\java.exe" -Xmx256m -Xms256m %1 %2 %3 %4 %5 %6 %7 %8 %9

popd
