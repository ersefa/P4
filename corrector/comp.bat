@echo off
echo ----------------
echo LPS - COMPARISON
echo ----------------
echo.

echo Setting environment variables
echo.
call config.bat

echo Playing "Game01" without a config file...
call java -jar engine.jar -i game01.in -o game01.out gameDef.xml 
echo Comparison of the generated "game01.out" with the expected "expectedGame01.out":
call "comp\comp.exe" game01.out expectedGame01.out

echo Playing "Game02" without a config file...
call java -jar engine.jar -i game02.in -o game02.out gameDef.xml 
echo Comparison of the generated "game02.out" with the expected "expectedGame02.out":
call "comp\comp.exe" game02.out expectedGame02.out

echo Playing "Game03" without a config file...
call java -jar engine.jar -i game03.in -o game03.out gameDef.xml 
echo Comparison of the generated "game03.out" with the expected "expectedGame03.out":
call "comp\comp.exe" game03.out expectedGame03.out

echo Playing "Game01" with config file...
call java -jar engine.jar -i game01.in -o game01config.out -c game.cfg gameDef.xml 
echo Comparison of the generated "game01.out" with the expected "expectedGame01config.out":
call "comp\comp.exe" game01config.out expectedGame01config.out

echo Playing "Game01" with spanish config file...
call java -jar engine.jar -i gameSpanish.in -o game01spanish.out -c spanish.cfg gameDef.xml 
echo Comparison of the generated "game01spanish.out" with the expected "expectedGame01spanish.out":
call "comp\comp.exe" game01spanish.out expectedGame01spanish.out

pause