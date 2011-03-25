@echo off
rem #######################################################
rem # GAME ENGINE FOR TEXT ADVENTURES                     #
rem # Colossal Geek Adventure III              04/01/2011 #
rem #######################################################
rem # Laboratorio de Programaci�n de Sistemas (2010/2011) #
rem # Ingenier�a T�cnica en Inform�tica de Sistemas       #
rem # Lecturers: Guillermo Jim�nez D�az                   #
rem #            Federico Peinado Gil                     #
rem #            Borja Manero Iglesias                    #
rem # Facultad de Inform�tica                             #
rem # Universidad Complutense de Madrid                   #
rem #######################################################

rem Setting environment variables
call config.bat

call java -jar engine.jar -c game.cfg gameDef.xml
pause