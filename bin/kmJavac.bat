@setlocal
@call %~dp0%kmSetEnv.bat

echo Javac %1 %2 %3 %4 %5 %6 %7 %8 %9
call %java_home%\bin\javac.exe -g -Xmaxerrs 25 -Xlint:all,-serial -d "%km_project_classes%" %1 %2 %3 %4 %5 %6 %7 %8 %9

