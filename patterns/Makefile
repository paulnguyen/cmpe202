all: clean

clean: 
	find . -name "*.class" -exec rm -rf {} \;

run-abstract-factory:
	javac abstract_factory/*.java
	java  abstract_factory.RunTest
	
run-class-adapter:
	javac adapter/classAdapter/*.java
	java  adapter.classAdapter.Client
	
run-object-adapter:
	javac adapter/objectAdapter/*.java
	java  adapter.objectAdapter.Client

run-chain-of-responsibility:
	javac chain_of_responsibility/*.java
	java  chain_of_responsibility.Client

run-command:
	javac command/*.java
	java  command.Client
	
run-composite:
	javac composite/*.java
	java  composite.Client
	
run-decorator:
	javac decorator/*.java
	java  decorator.Tester

run-factory-method:
	javac factory_method/*.java
	java  factory_method.RunTest
	
run-iterator:
	javac iterator/*.java
	java  iterator.QueryTool

run-observer:
	javac observer/*.java
	java  observer.ObserverTest
	
run-proxy:
	javac proxy/*.java
	java  proxy.Client
	
run-singleton:
	javac singleton/*.java
	java  singleton.Client
	
run-state:
	javac state/*.java
	java  state.Tester
	
run-strategy:
	javac strategy/*.java
	java  strategy.Tester
