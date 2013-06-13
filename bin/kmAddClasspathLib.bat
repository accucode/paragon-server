for %%i in (%1\*.jar) do call %km_project_bin%\kmAddClasspath.bat %%i
for %%i in (%1\*.zip) do call %km_project_bin%\kmAddClasspath.bat %%i

