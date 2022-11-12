
# Setup PHP on Google Compute Engine
```
    https://cloud.google.com/compute/docs/
    https://cloud.google.com/vpc/docs/
    https://cloud.google.com/compute/docs/instances/create-start-instance
    https://cloud.google.com/compute/docs/images/create-delete-deprecate-private-images
```

## Create New Project:  CMPE281 

```
  Note your Project ID (for example): cmpe281-263314
```

## Create VPC Network: 
```
    1. Name:                    cmpe281
    2. Subnet Creation Mode:    automatic
    3. Firewall rules:          select all
    4. Dynamic routing mode:    regional
    5. DNS server policy:       none
```

## Delete the Default VPC Network: 
```
    1. Select VPC Networks List
    2. Select Default VPC
    3. Select to "Delete VPC Network"
```
    
## Create VM Instance:

```
	1. Select your project: cmpe281
	
	2. Select Compute Engine (on Left Nav)
	
	3. Click on "Create" Button to Create a new VM instance
	
		Instance Name:           php
		Region:                  us-west1 (or us-west2)
		Zone:                    us-west1-a (or us-west2-a)
		Machine Family:          N1
		Machine Type:            f1-micro
		Boot Disk:               Debian GNU/Linux 9 / 10gb Disk (default)
		Identity and API Access: Leave Defaults
		Firewall:                Select "Allow HTTP access"
```

## Connect to VM Instance:

```
	1. In VM Instances list, note the "green" status of running php instance
	2. Select SSH "pull down" and pick "Open in Browser Window"
```
    
## PHP Setup:

```
	1. Update APT and Install PHP
	
		sudo apt update
		sudo apt install apache2
		sudo apt install php libapache2-mod-php

    2. Test Apache Service

    	Click on ling to default HTTP Port for your Public IP
    	Or, type in:  http://<your public ip> on Browser
    	
    	Note WWW Document Root:  /var/www/html
```

## PHP Test

```
    1. Hello LAMP / PHP

    Create a file: /var/www/html/phpinfo.php
    With Content: <?php phpinfo(); ?>
    Note: using vi as sudo

    2. Go to:  http://<public ip>/phpinfo.php
```

## Install Stress Test Tool

```
     sudo apt-get install stress

     stress [OPTION]
     
     ## Stress using CPU-bound task
     stress -c 4
     
     ## Stress using IO-bound task 
     stress -i 2
    
     ## Example Test

     stress -c 2 -i 1 -m 1 --vm-bytes 128M -t 300

    Where,

        -c 2 : Spawn two workers spinning on sqrt()
        -i 1 : Spawn one worker spinning on sync()
        -m 1 : Spawn one worker spinning on malloc()/free()
        --vm-bytes 128M : Malloc 128MB per vm worker (default is 256MB)
        -t 10s : Timeout after ten seconds
        -v : Be verbose
        
   	In VM Instance "Info Panel", view the Monitoring Pane 
   	and observer CPU Utilitzation Increase.
```

## Upload PHP Source Files to Web Root Folder

```

	1. fibonacci.php
	2. loadtest.php

	In VM Instance SSH Web Shell, Select the "Gear" Icon and select "Upload File"
	To upload the Lab files:  fibonacci.php and loadtest.php
	
	Move php files to:   /var/www/html
	
```

## Create PHP Image

```
	1. Stop Running php Instance

    2, Go to Compute Engine / Images / Create Image
    
    	Name: 				php-image
    	Source:				Disk
    	Source Disk:		php
    	Location:			Multi-Region
    	Remaining Options:	Defaults
    	
```
    








