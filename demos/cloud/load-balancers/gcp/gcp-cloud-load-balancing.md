    
# Autoscaling VM Instances with Google Cloud Global Load Balancer

* https://cloud.google.com/compute/docs/instance-templates/create-instance-templates
* https://cloud.google.com/compute/docs/instance-groups/creating-groups-of-managed-instances
* https://cloud.google.com/compute/docs/instance-groups/adding-an-instance-group-to-a-load-balancer
* https://cloud.google.com/compute/docs/instance-groups/autohealing-instances-in-migs
* https://cloud.google.com/load-balancing/docs
* https://cloud.google.com/compute/docs/autoscaler
* https://cloud.google.com/compute/docs/autoscaler/scaling-cpu-load-balancing
* https://cloud.google.com/compute/docs/tutorials/high-availability-load-balancing
* https://cloud.google.com/compute/docs/autoscaler/scaling-stackdriver-monitoring-metrics


## Create Instance Template

```
    1. In the Cloud Console / Compute Engine, go to the Instance templates page. 
    2. Create instance template:
        Name:                       php-template 
        Machine Family:             N1
        Machine Type:               f1-micro
        Boot Disk:                  php-image (custom image)
        Identity and API access:    default settings
        Firewall:                   Allow HTTP traffic 
``` 

## Create Managed Instance Group

```
    1. In the Cloud Console / Compute Engine, go to the Instance Groups page.
    2. Create Instance Group:
        Name:                       php-group
        Location:                   multi-zone
                                    Region: us-west1
                                    Zones:  us-west1-a, us-west1-b, us-west1-c
        Instance Template:          php-template
        Auto Scaling:               CPU Utilization: 40%
                                    Cool Down Period: 60 seconds
                                    # of Instances: 1 (min) - 3 (max)
        Health Check:               TCP (Port 80)
                                    Initial Delay: 300 seconds

```

## Configure Health Check Firewall Rule

```
    1. In the Google Cloud Console / VPC Network, go to the Create a firewall rule page.
    2. Create Firewall Rule:
        Name:                       allow-health-check
        Network:                    cmpe281
        Targets:                    all instances in network
        Source filter:              0.0.0.0/0
        Protocols and Ports:        tcp:80
```

## Using a Load Balancer With a Managed Instance Group

```
     1. In the Google Cloud Console / Network Services, go to the Create Load Balancer page.
     2. Create Load Balancer: 
            - Name: php-load-balancer
            - HTTP(S) Load Balancing
            - From Internet to my VMs
     3. Configure Load Balancer:
        Backend:
            Backend Service Name:   php-backend
            Backend Type:           instance group
            Select Instance Group:  php-group
                Port: 80
                Balancing Mode: Utilization (Max 80)
                Capacity: 10  
                Health Check: select healthcheck (tcp)         
        Frontend:
            Front End Name:         php-frontend
            Protocol:               http
            Network Service Tier:   standard
            Region:                 (same as backend)
            IP Version:             IPv4
            IP Address:             Ephemeral
            Port:                   80
```





