@echo off
echo -------------------
echo LPS - ANT EXECUTION
echo -------------------
echo.

echo Setting environment variables
echo.
call config.bat

call ant
pause