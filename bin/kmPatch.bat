@setlocal
@call %~dp0%kmSetEnv.bat

echo.
echo.
echo Database Patcher ----------------------------------------------
call %km_project_bin%\kmJava.bat com.app.tools.MyPatchConsole %1 %2 %3
if %errorlevel% EQU 0 goto :eof

echo.
echo ###############################
echo # ERROR
echo ###############################
pause
