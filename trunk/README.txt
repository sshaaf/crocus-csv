===============================================================================================================================
			CROCUS - The First Flower of Spring - http://crocus.sourceforge.net/
===============================================================================================================================


Statement/Motive: All through out this phase/project I have stressed deeply on the design. Although I have worked off Office hours to do this thing but have done it in a way that it can be admired. I would admit on a few things that I have done huridly. I have registerd this project on the sourceforge.net as CROCUS i.e. "The First Flower of Spring". And I plan to move on with this small utility from now onwards. I will strongly ask for any questions or improvements on this applicaiton from anyone and plan to take this criticsm positively.

PROJECT WEB DIR: http://crocus.sourceforge.net/

3. CSV file reader, 
	Does not use a String Tokenizer. 
	Is only done in readonly mode. 
	User is able to query the application for a given element.
	User is able to query for a particular row,column
	Able to Convert any column to any type, currently supporting only default NumberFormats from java. The applicaiton has room as per 	design to have for instance remove a comma to form an integer.

DESIGN:
	The system has been deisgned to keep the following objectives alive
	- Extensibility
	- Reuse and Future Reuse
	- Loosely Coupled
	- Clear Seperation of concers
	- Maintianable
	- A Framework approach used

NEAR Future:  (Extensions, Plugins, MOmento, toXML,Internationalization)	
	all of them are easy to implement with the current design


As a pointer on what we would be looking for in the application:

===================================================================================================================================

a) Well defined objects / interfaces
	Good usage of Abstract Classes and interface. 
	lesser dependancy or coupling of work.
	Implementation of a MessageFactory with a class that holds all system messages. Looking into future of this with Internationalization


===================================================================================================================================

b) Clear separation of concerns
	A CSV file is broken up as follows
	A CSVField has a group of characters
	CSVField can be of any DataType
	A CSVRecord has a group of CSVFields
	A CSVFile has a group of record


===================================================================================================================================

c) Application of patterns to solve the problem
	Prominent patterns used: 
	Singelton Good usage: One object in the system: CommandManager

	AbstractFactory - Usage of multiple realted Factories either current or a robust design to support future.

	Factory Method - Usage for getting Objects that are someHow related (Example is FieldFactory)

	Command - Usage for all system commands whether GUI or NON GUI. 

	State - State and Momento could have been a feature of this whole idea but for such a small application momento at this time is not 		suitable as a majorly operation is readonly. Although i have put in State patterns using String currently to show a State Framework
	in place
	
	Concept: Model View Controller

	**Hopefully I am not forgetting any other pattern that I would have used. But would like to clearify any if asked.


===================================================================================================================================

d) No code duplication e) Well refactored code
	(minimized code duplication more or less none)
	Usage of Constants for FIELDTYPE, DELIMINATOR, MESSAGES. else other wise code resuse is highleted as a better practise then code 	duplication.

Other things that would be a bonus are

===================================================================================================================================

f) Tests included
	A few of the tests included only as a pointer to show the knowledge of unit tests.

===================================================================================================================================

g) build script
	Build: init, clean, compile, jar, javadoc, tests
	Including, Excluding files while creating compile, jar, tests

===================================================================================================================================
FILE DETAILS (Paths and description):
===================================================================================================================================

PRE RULES:
=========
CROCUS_DEV = the main directory i.e. examples from here onwards this will be the variable used for describing details.
You will need to set CROCUS_DEV env variable inorder to run the build process 
Also you would need to set ANT_HOME for usage of ant. I have used Ant 1.6.5 for builds.



$CROCUS_DEV/src 			Holds the source code i.e. java files


$CROCUS_DEV/build			Carries all the build related files
$CROCUS_DEV/build/build.xml		Main build script
$CROCUS_DEV/build/include.xml		patterns for inclusion of java files at the time of compilation
$CROCUS_DEV/build/exclude.xml		patterns for exclusion of java files at the time of compilation
$CROCUS_DEV/build/tests_include.xml	patterns for inclusion of test java files at the time of compilation
$CROCUS_DEV/build/tests_exclude.xml	patterns for exclusion of test java files at the time of compilation
$CROCUS_DEV/build/tools			tools used during build.
$CROCUS_DEV/build/jar_buildfiles	you can simply specify a txt file with some wild card matches and name it as yourjar.jar for the 						build system to recognize that "yourjar.jar" will be the name for this jar that should have the 						packages in it as specified in this txt(yourjar.jar)
$CROCUS_DEV/build/bin			Holds the uniz script and the bat file for developers to run the build script more or less as:
	
					Windows:> %CROCUS_DEV%/build all	
					Linux:> $CROCUS_DEV/build.sh all

$CROCUS_DEV/build_results		Holds all the results of the builds
$CROCUS_DEV/build_results/docs		Created java docs
$CROCUS_DEV/build_results/classes	Created classes
$CROCUS_DEV/build_results/tests		Unit test results
$CROCUS_DEV/build_results/jars		the jars created by the system


$CROCUS_DEV/jars/			Is the directory for jars related information
$CROCUS_DEV/jars/manifests		Holds the manifests for the $CROCUS_DEV/build/jar_buildfiles.

					Conventionally should use: Manifest.jarName
$CROCUS_DEV/jars/original3rdparty	Holds any 3rd party vendor jars that might be used for putting in the classpath for the build system	
$CROCUS_DEV/testData			logically should hold all testData no matter how that might be. currently I have placed a few csv 						files (tabbed,comma,semicolon).

$CROCUS_DEV/web				Holds the webContent for this project
$CROCUS_DEV/web/Crocus.jnlp		File that is used to launch this applicaiton from the web in javaws
$CROCUS_DEV/web/jars/Crocus.jar		Holds the applicaiton jars for the jnlp as resources.
$CROCUS_DEV/web/docs			Holds the published javadocs
$CROCUS_DEV/web/web/Individual*		Holds the individual Class diagrams of each class(with some dependancy, relationships)
$CROCUS_DEV/web/Crocus*.pdf		Holds the pdf document of the overall system classes. 
	** PLEASE NOTE: I am unable to have a good tool for modelling and am unable to show you the complete classes in this diagram as 		RationalRose or rationalxDE does not give me the opportunity to show classes with features 1.5. My apologies i do not have any other 		tool or license to show my intention; the alternative to this is $CROCUS_DEV/web/Individual* 


===============================================================================================================================
			CROCUS - The First Flower of Spring - http://crocus.sourceforge.net/
===============================================================================================================================
