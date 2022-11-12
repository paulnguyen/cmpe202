#!/bin/sh

# Container

ACCOUNT=""
CONTAINER="gumball"
VERSION="gumball-v5.0"

# Shell Variables

OPT=""
OPT1=""
OPT2=""
DEBUG="TRUE"
AUTH="FALSE"
XMENU="N"

## Set Echo Command Flavor

PROMPT=""
OS=`uname -a | cut -f1 -d" "`
if [ "$OS" = "Darwin" ] ; then
    PROMPT="echo"
else
    PROMPT="echo -e"
fi ;

#
# Shell Functions 
# for Menu Operations
#

docker_auth () { 
   $PROMPT "Docker Userid:   \c" ; read user ;
   $PROMPT "Docker Password: \c" ; read -s pass ; 
   echo "" ;
   #docker login -u $user -p $pass
   #TMP=`cat ~/.docker/config.json | grep  \"auth\": | wc -l | sed -e 's/^[ \t]*//'`
   TMP=`docker login -u $user -p $pass 2>/dev/null | grep Succeeded | wc -l | sed -e 's/^[ \t]*//'`
   #echo ".${TMP}."
   if [ "$TMP" == "1" ] ; 
   then 
   		AUTH="TRUE" ; 
   		ACCOUNT=$user ;
   else 
   		AUTH="FALSE"; 
   fi ; 
}

docker_pull() {
	if [ "$AUTH" != "TRUE" ] ; 
    then echo "Login Required!" ; 
    else 
    	docker pull -a $ACCOUNT/$CONTAINER ; 
    	#docker pull $ACCOUNT/$CONTAINER:$VERSION ; 
    fi ; 
}

docker_build() {
	if [ "$AUTH" != "TRUE" ] ; 
    then echo "Login Required!" ; 
    else 
 	  	docker build -t $ACCOUNT/$CONTAINER:$VERSION .
    fi ; 
}

docker_release() {
	if [ "$AUTH" != "TRUE" ] ; 
    then echo "Login Required!" ; 
    else 
  		echo "Building Versions: latest and $VERSION"
 	  	docker build -t $ACCOUNT/$CONTAINER:latest -t $ACCOUNT/$CONTAINER:$VERSION .
 	  	echo "Pushing Builds to Docker Hub"
 	  	docker push $ACCOUNT/$CONTAINER:latest ; 
 	  	docker push $ACCOUNT/$CONTAINER:$VERSION ; 
    fi ; 
}

docker_push() { 
	if [ "$AUTH" != "TRUE" ] ; 
    then echo "Login Required!" ; 
    else 
		docker push $ACCOUNT/$CONTAINER:$VERSION ; 
    fi ; 
}

docker_run() { 
	if [ "$AUTH" != "TRUE" ] ; 
    then echo "Login Required!" ; 
    else 
		docker run -td --net=host --name $CONTAINER $ACCOUNT/$CONTAINER:$VERSION ; 
    fi ; 
}

docker_restart () {
	docker restart $CONTAINER
}

docker_images() {
	docker images
}

docker_rmi() {
	IMG_ID=`docker images --format "table {{.ID}}\t{{.Repository}}\t{{.Tag}}" | grep $CONTAINER | tr -s ' ' | tr ' ' '|' | cut -f 1 -d '|' | head -1`
	while [ "$IMG_ID" != "" ]
	do
		echo "Removing Image: $IMG_ID"
 		docker rmi -f $IMG_ID
		IMG_ID=`docker images --format "table {{.ID}}\t{{.Repository}}\t{{.Tag}}" | grep $CONTAINER | tr -s ' ' | tr ' ' '|' | cut -f 1 -d '|' | head -1`
	done
}

docker_rmi_all() {
	IMG_ID=`docker images --format "table {{.ID}}\t{{.Repository}}\t{{.Tag}}" | tr -s ' ' | tr ' ' '|' | cut -f 1 -d '|' | tail -n +2 | head -1`
	while [ "$IMG_ID" != "" ]
	do
		echo "Removing Image: $IMG_ID"
 		docker rmi -f $IMG_ID
		IMG_ID=`docker images --format "table {{.ID}}\t{{.Repository}}\t{{.Tag}}" | tr -s ' ' | tr ' ' '|' | cut -f 1 -d '|' | tail -n +2 | head -1`
	done
}


docker_ps() {
	echo "Running Containers:"
	echo " "
	docker ps --format "table {{.ID}}\t{{.Names}}\t{{.Image}}\t{{.Status}}\t"
}

docker_restart() {
	docker restart $CONTAINER
}

docker_stop() {
	docker stop $CONTAINER
	docker rm $CONTAINER
}

docker_stop_all () {
	INST_ID=`docker ps --format "table {{.ID}}\t{{.Names}}\t{{.Image}}\t{{.Status}}\t" | tr -s ' ' | tr ' ' '|' | cut -f 2 -d '|' | tail -n +2 | head -1`
	while [ "$INST_ID" != "" ]
	do
		echo "Stopping Instance: $INST_ID"
 		docker stop $INST_ID  > /dev/null 2>&1
 		docker rm $INST_ID > /dev/null 2>&1
		INST_ID=`docker ps --format "table {{.ID}}\t{{.Names}}\t{{.Image}}\t{{.Status}}\t" | tr -s ' ' | tr ' ' '|' | cut -f 2 -d '|' | tail -n +2 | head -1`
	done	
}


docker_cmd () {
  	$PROMPT "CMD: \c" ; read cmd ;	
  	echo $cmd
	docker exec -it $CONTAINER $cmd
}

docker_install() {
	if [ "$AUTH" != "TRUE" ] ; 
    then echo "Login Required!" ; 
    else 
        docker_uninstall
        docker_rmi
        docker_pull
        docker_run
    fi ; 
}

docker_uninstall() {
	if [ "$AUTH" != "TRUE" ] ; 
    then echo "Login Required!" ; 
    else 
		docker stop $CONTAINER
		docker rm $CONTAINER
		docker_rmi
    fi ; 
}

set_version() {
  	$PROMPT "Set Container Version: \c" ; read VERSION ;
 }

set_account() {
  	$PROMPT "Set Container Account: \c" ; read ACCOUNT ;
 }

okay_pause() {
	$PROMPT "\n[Okay] \c"; 
	read ans ; 
}


##
## MAIN MENU LOOP
##

while [ "$OPT" != "X" ]  
do
	clear
	echo ""
	echo "============================================" ;
	echo "          D O C K E R   M E N U             " ;
	echo "============================================" ;
	echo "> $CONTAINER - $ACCOUNT/$CONTAINER:$VERSION " ;
	echo " "
	echo "[1] login      - Login to Docker            " ;
	echo "[2] images     - Show Docker Images         " ;
	echo "[3] build      - Build Container Image      " ;
	echo "[4] run        - Run Container              " ;
	echo "[5] pull       - Pull Container Image       " ;
	echo "[6] push       - Push Build to Docker Hub   " ;
	echo "[7] ps         - Show Running Containers    " ;
	echo "[8] rmi        - Remove Container Image     " ;
	echo "[9] release    - Release to Docker Hub      " ;	
	if [ "$XMENU" = "N" ] ; then
		echo " "
		echo "[+] More Options                        " ;
	else
		echo " "
		echo "[i] install    - Install Container         " ;
		echo "[u] uninstall  - Uninstall Container       " ;
		echo "[r] restart    - Restart Container         " ;
		echo "[s] stop       - Stop Running Container    " ;
		echo "[b] bash       - Enter Container Shell     " ;
		echo "[c] cleanup    - Remove Local Images       " ;
		echo "[v] version    - Set Container Version     " ;
		echo "[a] account    - Set Container Account     " ;
		echo " " 
		echo "[-] Fewer Options                          " ;		
	fi ;
	echo "[X] Exit Menu                              " ;
	echo " "
	$PROMPT "Selection: \c"
	read OPT OPT1 OPT2
	case $OPT in
		1|login)		echo " " ; docker_auth ; okay_pause ;;
		2|images)	    echo " " ; docker_images ; okay_pause ;;
		3|build)		echo " " ; docker_build ; okay_pause ;;
		4|run) 			echo " " ; docker_run ; okay_pause ;;
		5|pull)			echo " " ; docker_pull ; okay_pause ;;
		6|push) 		echo " " ; docker_push ; okay_pause ;;
		7|ps) 			echo " " ; docker_ps ; okay_pause ;;
		8|rmi) 			echo " " ; docker_stop ; docker_rmi ; okay_pause ;;
		9|release)		echo " " ; docker_release ;	okay_pause ;;
		i|I|install) 	echo " " ; docker_install ; okay_pause ;;
		u|U|uninstall)	echo " " ; docker_uninstall ; okay_pause ;;
		r|R|restart) 	echo " " ; docker_restart ; echo "Container Restarted!" ; okay_pause ;;
		s|S|stop) 		echo " " ; docker_stop ; echo "Container Stopped!" ; okay_pause ;;
		c|C|cleanup) 	echo " " ; docker_stop_all; docker_rmi_all ; okay_pause ;;
		v|V|version) 	echo " " ; set_version ; okay_pause ;;
		a|A|account) 	echo " " ; set_account ; okay_pause ;;
		cmd)			echo " " ; docker_cmd ; okay_pause ;;
        debug)          echo " " ; if [ "$OPT1" = "" -o "$OPT1" = "on" ] ; then DEBUG="TRUE" ; echo "Debug ON" ; 
								   else DEBUG="FALSE" ; echo "Debug OFF" ; fi ; okay_pause ;;
		b|B|bash)		clear ; docker exec -it $CONTAINER bash ; ;;
 		+)				XMENU="Y" ;;
		-)				XMENU="N" ;;
		x|X) 			clear ; OPT="X" ; echo "Exiting " ;; 
	esac
done

