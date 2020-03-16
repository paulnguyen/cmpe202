
## Install Java JDK 8 (Cloud 9)

sudo add-apt-repository ppa:webupd8team/java
sudo apt-get update
sudo apt-get install oracle-java8-installer
java -version

## Install UMLGraph, GraphViz and Plotutils

open https://www.spinellis.gr/umlgraph/index.html
wget https://www.spinellis.gr/umlgraph/jars/UmlGraph-5.7_2.32-SNAPSHOT.jar
wget https://www.spinellis.gr/umlgraph/UMLGraph-5.7_2.32-SNAPSHOT.tar.gz
wget https://www.spinellis.gr/umlgraph/UMLGraph-5.7_2.32-SNAPSHOT.zip
sudo apt-get install graphviz
sudo apt-get install plotutils
sudo apt-get install imagemagick

## Note (On Cloud 9, Install to /home/ubuntu/lib and /home/ubuntu/bin)

ls /home/ubuntu/lib
UmlGraph.jar  sequence.pic

ls /home/ubuntu/bin
umlgraph*
