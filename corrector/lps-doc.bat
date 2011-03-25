@echo off
echo -----------------
echo LPS - ANT JAVADOC
echo -----------------
echo.

echo Setting environment variables
echo.
call config.bat

call ant doc
pause





