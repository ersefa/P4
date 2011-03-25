@echo off
rem #######################################################
rem # GAME ENGINE FOR TEXT ADVENTURES                     #
rem # La Friki-Aventura Original III           04/01/2011 #
rem #######################################################
rem # Laboratorio de Programación de Sistemas (2010/2011) #
rem # Ingeniería Técnica en Informática de Sistemas       #
rem # Lecturers: Guillermo Jiménez Díaz                   #
rem #            Federico Peinado Gil                     #
rem #            Borja Manero Iglesias                    #
rem # Facultad de Informática                             #
rem # Universidad Complutense de Madrid                   #
rem #######################################################

rem Setting environment variables
call config.bat

call java -jar engine.jar -c spanish.cfg gameDef.xml
pause