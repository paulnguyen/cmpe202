     ,-----.,--.                  ,--. ,---.   ,--.,------.  ,------.
    '  .--./|  | ,---. ,--.,--. ,-|  || o   \  |  ||  .-.  \ |  .---'
    |  |    |  || .-. ||  ||  |' .-. |`..'  |  |  ||  |  \  :|  `--, 
    '  '--'\|  |' '-' ''  ''  '\ `-' | .'  /   |  ||  '--'  /|  `---.
     `-----'`--' `---'  `----'  `---'  `--'    `--'`-------' `------'
    ----------------------------------------------------------------- 


## Install AspectJ Compiler & Tools

    $ pwd
    /home/ubuntu
    $ ls
    lib/  workspace/
    $ unzip workspace/aspectj/zaspectj1.8.zip 
    creating: aspectj1.8/
    creating: aspectj1.8/bin/
    inflating: aspectj1.8/bin/aj 
    ...
## Install Java 7 JDK (Not needed if JDK 7 or 8 Already Installed)

    sudo apt-get update
    sudo apt-get install openjdk-7-jdk
        
## Setup AspectJ and Java Home

    $ vi /home/ubuntu/.bashrc
	
	# SET UP ASPECTJ and JAVA
	export CLASSPATH=/home/ubuntu/aspectj1.8/lib/aspectjrt.jar:.
	export JAVA_HOME=/usr/lib/jvm/java-7-openjdk-amd64
	export ASPECTJ_HOME=/home/ubuntu/aspectj1.8
	export ASPECTJ_RT=/home/ubuntu/aspectj1.8/lib/aspectjrt.jar	
	export PATH=$PATH:$ASPECTJ_HOME/bin:$JAVA_HOME/bin.
 
    