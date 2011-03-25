---------------------------------------------------
-- Laboratorio de Programación de Sistemas       --
---------------------------------------------------
-- README.TXT: How to use the "corrector" folder --
---------------------------------------------------


The purpose of this folder is to provide some tools for
checking the students' projects, comparing them to what is expected by the lecturer.

PRELIMINAR NOTE: This folder contains some necessary files for executing comparison of results both in Windows and UNIX systems. Important: UNIX users (Linux, Mac, etc.) should have Python 2.5 installed in their machines for the automatic comparison to work propertly!  


Files
-----

* ant: Folder of Ant 1.8.1 distribution.

* comp: Folder containing some necessary files for the automatic comparison of two files in Windows.

* comp.py: Python script that performs the automatic comparison of two files in UNIX.

* config.bat: Batch script for configuring environment variables for setting paths to Java and Ant executables in Windows.

* junit.jar: Java Archive of JUnit 4.8.2 distribution.

* lps-ant.bat: Script for launching the LPS Ant project in Windows.

* lps-clean.bat: Script for cleaning the "corrector" folder in Windows.

* README.txt: This text file with instructions.

* testapi.jar: Java Archive of Test API 0.1beta distribution by Ivan Martínez, reviewed by Federico Peinado.


Files that should be added for checking a project
(for example, the content of LPS-P1Example.zip)
-------------------------------------------------

* srcExample: Folder with additional source code for running the example game (in LPS-P1Example, it contains a new Main class that reads the player input from a file and saves the game output in another file).

* build.xml: Ant build file containing information for compiling the source code, creating the JAR file, generating the documentation, executing the tests, and (optionally) other tasks.

* example.in: Text file with the player input for the example.

* exampleMap.pdf: Diagram of the example map.

* exampleMap.txt: Piece of source code for creating the example map. Important: You have to include this code in your project in order to execute the correction with the example map!

* exampleUNIX.out: expected game output in UNIX.

* exampleWindows.out: expected game output in Windows.

* run.bat: Batch script for running the game in Windows.

* run.sh: Shell script for running the game in UNIX.

* testx.jar: Java Archive of the basic tests given by the lecturer 


Steps to follow
---------------

1. Download the "corrector" folder.
2. Write the right path of your JDK 1.6 distribution in config.bat or config.sh (obviously, JDK 1.6 should be installed on your machine).
3. Download the ZIP file for correcting the current projec (for example, LPS-P1Example.zip).
4. Unzip that ZIP file and copy its content in the "corrector" folder.
5. Copy the src folder of your project in the "corrector" folder.
  Important: Remember that you have to include the code from exampleMap.txt in your project in order to execute the correction with the example map!
6. Copy the test folder of your proyect in the "corrector" folder.
  Important: You should have an AllTest class that calls all your test (for example, lps.pr2.test.AllTests).
7. Place yourself in the "corrector" folder and execute the LPS Ant project: 
  In UNIX: lps-ant 
  In Windows: lps-ant.bat
8. Check everything is ok (compiled classes should be placed in a "bin" folder, Javadoc documentation should be placed in a "doc" folder), the JAR file of the project should be created, and the tests should be all ok). If something is wrong, you have to go back to Eclipse for making changes to the project, and restart the whole correction process.
9. Execute the comparison:
  In UNIX: sh comp.sh 
  In Windows: comp.bat
10. You will see something like MATCH: XX.XX where XX.XX is the similarity percentage between the results of your project (example.out) and the expected results (exampleUNIX.out or exampleWindows.out, depending on the system you are using). MATCH = 100 means the results are identical. MATCH < 100 means there are differences (in many cases these differences are minimal, due to extra blank lines, white spaces, etc., but check manually the results if you find significant differences). 

You can play the game, executing the lps.jar file that has been created by Ant (or using run.bat or run.sh files in Windows or UNIX systems, respectively)

You can clean the "corrector" folder, restoring its state before executing the LPS Ant project, calling to lps-clean.bat or lps-clean.sh (from Windows or UNIX systems, respectively). Important: Note that this delete the bin, doc, src and test folders! Be sure you have the working copy of your source code OUTSIDE the "corrector" folder when cleaning the folder.
