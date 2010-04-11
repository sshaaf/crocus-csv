===============================================================================================================================
			CROCUS - The First Flower of Spring - http://crocus.sourceforge.net/
===============================================================================================================================


PROJECT WEB DIR: http://crocus.sourceforge.net/


	A CSV file is broken up as follows
	A CSVField has a group of characters
	CSVField can be of any DataType
	A CSVRecord has a group of CSVFields
	A CSVFile has a group of record


===================================================================================================================================
FILE DETAILS (Paths and description):
===================================================================================================================================

PRE RULES:
=========
CROCUS_DEV = the main directory i.e. examples from here onwards this will be the variable used for describing details.
You will need to set CROCUS_DEV env variable inorder to run the build process 
Also you would need to set ANT_HOME for usage of ant. I have used Ant 1.6.5 for builds.



$CROCUS_DEV/src 					Holds the source code i.e. java files


$CROCUS_DEV/build					Carries all the build related files
$CROCUS_DEV/build/build.xml			Main build script
$CROCUS_DEV/build/include.xml		patterns for inclusion of java files at the time of compilation
$CROCUS_DEV/build/exclude.xml		patterns for exclusion of java files at the time of compilation
$CROCUS_DEV/build/tests_include.xml	patterns for inclusion of test java files at the time of compilation
$CROCUS_DEV/build/tests_exclude.xml	patterns for exclusion of test java files at the time of compilation
$CROCUS_DEV/build/tools			tools used during build.
$CROCUS_DEV/build/jar_buildfiles	you can simply specify a txt file with some wild card matches and name it as yourjar.jar for the 						build system to recognize that "yourjar.jar" will be the name for this jar that should have the 						packages in it as specified in this txt(yourjar.jar)
$CROCUS_DEV/build/bin				Holds the unix script and the bat file for developers to run the build script more or less as:
	
					Windows:> %CROCUS_DEV%/build all	
					Linux:> $CROCUS_DEV/build.sh all

$CROCUS_DEV/build_results			Holds all the results of the builds
$CROCUS_DEV/build_results/docs		Created java docs
$CROCUS_DEV/build_results/classes	Created classes
$CROCUS_DEV/build_results/tests		Unit test results
$CROCUS_DEV/build_results/jars		the jars created by the system


$CROCUS_DEV/jars/					Is the directory for jars related information
$CROCUS_DEV/jars/manifests			Holds the manifests for the $CROCUS_DEV/build/jar_buildfiles.
									Conventionally should use: Manifest.jarName
									
$CROCUS_DEV/jars/original3rdparty	Holds any 3rd party vendor jars that might be used for putting in the classpath for the build system	
$CROCUS_DEV/testData				logically should hold all testData no matter how that might be. currently I have placed a few csv 						files (tabbed,comma,semicolon).

===============================================================================================================================
			CROCUS - The First Flower of Spring - http://crocus.sourceforge.net/
===============================================================================================================================
