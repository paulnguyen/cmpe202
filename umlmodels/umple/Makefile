
clean:
	rm -rf gumball hellouml statemachines

gumball:
	mkdir -p gumball
	java -jar umple.jar -g GvClassDiagram gumball.ump 
	dot -Tpng gumballcd.gv > gumball-class-diagram.png
	mv gumball-class-diagram.png gumball
	rm gumballcd.gv
	java -jar umple.jar -g GvStateDiagram gumball.ump 
	dot -Tpng gumball.gv > gumball-state-diagram.png
	mv gumball-state-diagram.png gumball
	rm gumball.gv 
	java -jar umple.jar -g Java --path gumball gumball.ump 

hellouml:
	mkdir -p hellouml
	java -jar umple.jar -g GvClassDiagram hellouml.ump 
	dot -Tpng helloumlcd.gv > hellouml-class-diagram.png
	mv hellouml-class-diagram.png hellouml
	rm helloumlcd.gv
	java -jar umple.jar -g Java --path hellouml hellouml.ump 

statemachines:
	mkdir -p statemachines
	java -jar umple.jar -g GvStateDiagram statemachine1.ump 
	dot -Tpng statemachine1.gv > statemachine1.png
	mv statemachine1.png statemachines
	rm statemachine1.gv 
	java -jar umple.jar -g GvStateDiagram statemachine2.ump 
	dot -Tpng statemachine2.gv > statemachine2.png
	mv statemachine2.png statemachines
	rm statemachine2.gv 