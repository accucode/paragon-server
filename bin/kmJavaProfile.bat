@setlocal
@call %~dp0%kmSetEnv.bat

pushd ..\..

echo Java %1 %2 %3 %4 %5 %6 %7 %8 %9
"%java_home%\bin\java" -Xrunhprof:cpu=times,depth=50,thread=y,file=prof.txt, -mx128m -ms128m %1 %2 %3 %4 %5 %6 %7 %8 %9

popd
