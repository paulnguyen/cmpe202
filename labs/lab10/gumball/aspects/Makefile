all: clean

clean: 
	rm *.class
	
java:
	ajc -1.5 *.java
	
model1:
	ajc -1.5 *.java GumballCrankModel.aj GumballCost25.aj GumballOneQuarter.aj
	
model2:
	ajc -1.5 *.java GumballCrankModel.aj GumballCost50.aj GumballTwoQuarters.aj
	
model3:
	ajc -1.5 *.java GumballSlotModel.aj GumballCost50.aj 

error:
	ajc -1.5 *.java GumballSlotModel.aj GumballCost50.aj GumballOneQuarter.aj

run:
	java GumballMachine


