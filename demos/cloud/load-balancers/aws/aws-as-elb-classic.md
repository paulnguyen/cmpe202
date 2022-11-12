    
# Tutorial: Set Up a Scaled and Load-Balanced Application

```
    DOC:  http://docs.aws.amazon.com/autoscaling/latest/userguide/as-register-lbs-with-asg.html
```

## Create or Select a Launch Configuration

```
    Select My AMI:                  aws-php-ami
    Instance Type:                  T2-Micro (Free Tier)
    Launch Configuration Name:      aws-php-autoscale
    Enable Monitoring:              Enable CloudWatch detailed monitoring
    Select Public IP:               Assign a public IP address to every instance.
    Security Group:                 cmpe281-dmz (SG)
    Select Key Pair:                cmpe281-us-west-1
    Select VPC:                     cmpe281 (VPC) & Public Subnet
``` 

## Create an Auto Scaling Group

```
    Create Auto Scale Group:        aws-php-autoscale
    Group Size (Starts with):       1
    Network:                        cmpe281 (VPC) | Public Subnet
    
    Use scaling policies to adjust the capacity of this group

    Scale between:                  1 - 3 instances
    Increase when:                  AVG CPU >= 40% (for at lease 1 minute)
    Decrease when:                  AVG CPU <= 15% (for at lease 1 minute)
```

## Using a Load Balancer With an Auto Scaling Group 

```
    DOC: http://docs.aws.amazon.com/autoscaling/latest/userguide/autoscaling-load-balancer.html
``` 
    
## Create ELB (Classic Load Balancer)

```
        Name:                   aws-php-elb-classic 
        VPC:                    cmpe281 (select public subnet)
        SG:                     cmpe281-dmz
        Port:                   80
        Health Check:           Default path, Unhealthy Checks: 2, Healthy Checks: 4
        Add Instances:          Select running instance (from aws-php-autoscale)        
        Edit Auto Scale Group:  aws-php-autoscale
        Select ELB:             aws-php-elb-classic
``` 
    
## Expanding Your Scaled and Load-Balanced Application to an Additional Availability Zone

```
    DOC:  http://docs.aws.amazon.com/autoscaling/latest/userguide/as-add-availability-zone.html#as-add-az-console
    
    Select Auto Scale Group:        aws-php-autoscale
    Select Edit / Details / AZs:    Select two Public Subnets (in us-west-1a and us-west-1b)
    Set the Desired and Min to:     two instances   
```

## Elastic Load Balancer (Classic)

```
    Name:                       aws-php-elb-classic
    DNS name:                   aws-php-elb-classic-1441705822.us-west-1.elb.amazonaws.com (A Record)
    Scheme:                     internet-facing
    Availability Zones:         subnet-38805260 - us-west-1a, subnet-a2b73ac6 - us-west-1b
    VPC:                        vpc-4d2cd129
    Port Configuration:         80 (HTTP) forwarding to 80 (HTTP) Stickiness: Disabled
    Source Security Group:      sg-742cd613, cmpe281-dmz
    Idle timeout:               60 seconds
    Access logs:                Disabled
    Cross-Zone Load Balancing:  Enabled
    Connection Draining:        Enabled, 300 seconds
    Ping Target:                HTTP:80/index.html
    Timeout:                    5 seconds
    Interval:                   30 seconds
    Unhealthy threshold:        2
    Healthy threshold:          10
```

# Create an HTTPS/SSL Load Balancer Using the Console

```
    http://docs.aws.amazon.com/elasticloadbalancing/latest/classic/elb-create-https-ssl-load-balancer.html
    
    VPC ID:                   vpc-4d2cd129 | cmpe281
    Network ACL:              acl-8808d1ec
    State:                    available
    Tenancy:                  Default
    VPC CIDR:                 10.0.0.0/16
    DNS resolution:           yes
    DHCP options set:         dopt-047f6a66
    DNS hostnames:            yes
    Route table:              rtb-7144e515
    ClassicLink DNS Support:  yes
    ClassicLink:              Enabled
    
    Subnet ID:                subnet-38805260 | Public subnet
    Availability Zone:        us-west-1a
    CIDR:                     10.0.2.0/24
    Available IPs:            250
    
    Subnet ID:                subnet-a2b73ac6 | Public subnet
    Availability Zone:        us-west-1b
    CIDR:                     10.0.0.0/24
    Available IPs:            247
    
    SG Group name:            cmpe281-dmz
    Group description:        cmpe281-dmz
    Group ID:                 sg-742cd613
    VPC ID:                   vpc-4d2cd129
    Inbound:                  Allow All on 80, 22, 443
    Outbound:                 Allow All
``` 
    
    


 






