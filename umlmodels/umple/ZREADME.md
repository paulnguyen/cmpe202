
# UMPLE Model-Oriented Programming 

	Merging Modeling with Programming
	http://cruise.eecs.uottawa.ca/umple/

Umple is a modeling tool and programming language family to enable what we call Model-Oriented Programming. It adds abstractions such as Associations, Attributes and State Machines derived from UML to object-oriented programming languages such as Java, C++, PHP and Ruby. Umple can also be used to create UML class and state diagrams textually.

Umple is an open source project, so details will evolve. However, it is ready to be used for real systems. In fact the Umple compiler itself is written in Umple. Any Java, C++ or PHP project could use Umple. We have found the resulting code to be more readable and have many fewer lines. This is because Umple means you can avoid having to code a lot of 'boilerplate' code that would be needed to implement associations and attributes, a system based on Umple should also be less bug-prone.

Umple has also been found to help students learn UML faster in the classroom.

Umple works online, as an Eclipse plugin, and as a stand-alone command-line Jar. For further information and downloads, see the left margin.

# Links

* *Online*:  [http://cruise.eecs.uottawa.ca/umpleonline/](http://cruise.eecs.uottawa.ca/umpleonline/)

* *User's Manual*:  [http://cruise.eecs.uottawa.ca/umple/GettingStarted.html](http://cruise.eecs.uottawa.ca/umple/GettingStarted.html)


# Download

	http://cruise.eecs.uottawa.ca/umpleonline/download_eclipse_umple_plugin.html
	
# Run at Command Line

	Running the Umple compiler on the command line

    Run

    java -jar umple.jar <options> <arguments>

    Specify your umple file as an argument. 
    
    You can use --help as an option to obtain the full set of command-line options. 
    
    Options available include:
    
        -g, --generate : Specify the output language: Java,RTCpp, Php,RTCpp,Ruby,SQL,Json,Ecore,TextUml,Scxml Yuml,Cpp etc.
        
        --help : Display the help message
        
        --override : If a output language is specified using option -g, output will only generate language
        
        --path : If a output language is specified using option -g, output source code will be placed to path
        
        -v, --version : Print out the current Umple version number 


# Command Line Options

	Usage: java -jar umple.jar [options] <umple_file>
	
	Example: java -jar umple.jar airline.ump
	
	Option           Description                            
	------           -----------  
	                          
	-c, --compile   	Indicate to the entry class to         
   	                	compile, or with argument - to       
                  	compile all outputfiles   
                               
	-g, --generate   Specify the output language: 

					Alloy,Cpp,Ecore,GvClassDiagram,
					GvClassTraitDiagram,
					GvEntityRelationshipDiagram,
					GvStateDiagram,Java,Json,NuSMV,
					Papyrus,Php,RTCpp,Ruby,Scxml,
					SimpleCpp,SimpleMetrics,Simulate,Sql,
					StructureDiagram,Test,TextUml,USE,
					Uigu2,Umlet,Umple,UmpleSelf,Violet,
					Xmi,Xtext,Yuml    
                                      
	--help           Display the help message     
	          
	-i, --import     Indicate to read in XMI model and      
                   generate ump files    
                                  
	--override       If a output language <lang> is         
                   specified using option -g, output    
                   will only generate language <lang> 
                     
	--path           If a output language is specified      
                   using option -g, output source code  
                   will be placed to path    
                              
	-s, --suboption  Indicate to generate files with        
                   suboptions    
                                          
	-v, --version    Print out the current Umple version    
                   number         