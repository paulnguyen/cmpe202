
# Setup PHP on AWS EC2 Instance

```
    http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/install-LAMP.html
```

## Create Key Pair: cmpe281-us-west-1 

```
    Download                cmpe281-us-west-1.pem
    openssl x509 -text -in  cmpe281-us-west-1.pem
```

## Download Key Pair PEM file

```
    $ ls -l cmpe281-us-west-1.pem 
    -rw-r--r--@ 1 pnguyen  staff  1692 Feb 21 18:01 cmpe281-us-west-1.pem

    $ chmod go-r cmpe281-us-west-1.pem 

    $ ls -l cmpe281-us-west-1.pem 
    -rw-------@ 1 pnguyen  staff  1692 Feb 21 18:01 cmpe281-us-west-1.pem
```

## PEM Usage on Mac OS X

```    
    ec2.sh:
        ssh -i cmpe281-us-west-1.pem ec2-user@<PUBLIC_IP> 
    scp.sh:
        scp -i cmpe281-us-west-1.pem $1 ec2-user@<PUBLIC_IP>:/tmp 

    $ chmod +x *.sh
```

## Create VPC:  cmpe281 (Using Wizard)

```
    - Public with Private Subnets

    Creates:  A /16 network with two /24 subnets. 
    Public subnet instances use Elastic IPs to access the Internet. 
    Private subnet instances access the Internet via Network Address Translation (NAT).  
    (Hourly charges for NAT devices apply.)

    CIDR block                  10.0.0.0/16 
    IP range                    0.0.0.0 - 10.0.255.255   
    Subnet Mask                 255.255.0.0  
    IP Quantity                 65536   

    Public Subnet:              10.0.0.0/24
    Network =                   10.0.0.0
    Usable IPs =                10.0.0.1 to 10.0.0.254 for 254
    Broadcast =                 10.0.0.255
    Netmask =                   255.255.255.0
    Wildcard Mask =             0.0.0.255

    Private Subnet:             10.0.1.0/24
    Network =                   10.0.1.0
    Usable IPs =                10.0.1.1 to 10.0.1.254 for 254
    Broadcast =                 10.0.1.255
    Netmask =                   255.255.255.0
    Wildcard Mask =             0.0.0.255
```

    
## Launch EC2 Instance:

```
    Amazon Linux AMI 
    T2 Micro Instance
    VPC: cmpe281
    Public Subnet
    Auto Assign Public IP
    Security Group: cmpe281-dmz (create new)
        Open Ports: 22, 80, 443
    Select Key Pair: cmpe281-us-west-1
    AWS Instance Name:  aws-php
```

## Connect to EC2 Instance:

```
    chmod 400 cmpe281-us-west-1.pem
    
    Connect to your instance using its Public DNS (For Example):
    
    ssh -i cmpe281-us-west-1.pem ec2-user@ec2-54-67-49-23.us-west-1.compute.amazonaws.com
```
    
## PHP Setup on EC2 Linux AMI:

```
    1. Update Yum and Install LAMP Stack

    sudo yum update -y
    sudo yum install -y httpd24 php56 mysql55-server php56-mysqlnd
    sudo service httpd start
    sudo chkconfig httpd on
    chkconfig --list httpd

    2. Apache/PHP Web Root

    /var/www/html
    sudo groupadd www
    sudo usermod -a -G www ec2-user

    groups

    sudo chown -R root:www /var/www
    sudo chmod 2775 /var/www
    find /var/www -type d -exec sudo chmod 2775 {} \;
    find /var/www -type f -exec sudo chmod 0664 {} \;
```

## PHP Test

```
    1. Hello LAMP / PHP

    echo "<?php phpinfo(); ?>" > /var/www/html/phpinfo.php

    2. Go to:  http://<public dns or ip>/phpinfo.php

     3. sudo yum install stress

     stress [OPTION]
     
     ## Stress using CPU-bound task
     stress -c 4
     
     ## Stress using IO-bound task 
     stress -i 2
    
     ## Example Test

     stress -c 2 -i 1 -m 1 --vm-bytes 128M -t 10s

    Where,

        -c 2 : Spawn two workers spinning on sqrt()
        -i 1 : Spawn one worker spinning on sync()
        -m 1 : Spawn one worker spinning on malloc()/free()
        --vm-bytes 128M : Malloc 128MB per vm worker (default is 256MB)
        -t 10s : Timeout after ten seconds
        -v : Be verbose
```

## Create PHP AMI Image

```
    1. Create aws-php-ami
    2. From aws-php (EC2 instance)
```
    








