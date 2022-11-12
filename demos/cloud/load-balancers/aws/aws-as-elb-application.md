# Tutorial: Use Path-Based Routing with Your Application Load Balancer

```
    DOC:  
    http://docs.aws.amazon.com/elasticloadbalancing/latest/application/tutorial-load-balancer-routing.html
```

# Tutorial: Use Microservices as Targets with Your Application Load Balancer

```
    DOC:  
    http://docs.aws.amazon.com/elasticloadbalancing/latest/application/tutorial-target-ecs-containers.html
```

## Create Target Groups

```
    aws-linux-1 Port 80 Protocol HTTP (Register one or more Instances)
         Name: aws-linux-1
         Type: instance
         Protocol: http
         Port: 80
         VPC:  cmpe281
         Health Check: / (HTTP)
         Instances:  Add Instances to Target Group
     
    aws-linux-2 Port 80 Protocol HTTP (Register one or more Instances)
         Name: aws-linux-2
         Type: instance
         Protocol: http
         Port: 80
         VPC:  cmpe281
         Health Check: / (HTTP)
         Instances:  Add Instances to Target Group
``` 
    
## Create Application Load Balancer

``` 
    Name:               aws-php-elb-app
    Internet Facing:    true
    VPC:                cmpe281
    AZ's:               AZ's in your region
                        (us-west-2 or us-east-1)
    Listener: HTTP (Port 80)
    Security Group: cmpe281-dmz
                    Path: /loadtest.php  Target: aws-linux-1 
                    Path: /fibonacci.php Target: aws-linux-2 
                    (Default)            Target: aws-linux-1 
```                     
