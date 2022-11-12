
# Setup PHP on Docker Container


## Build Docker Image

```
    docker build -t phptest .
    docker images
```

## Run Docker Container

```
    docker run -dit --name phptest -p 8080:80 phptest
```

## Check PHP Scripts

```
    open http://localhost:8080/phpinfo.php
    open http://localhost:8080/fibonacci.php
    open http://localhost:8080/loadtest.php
```

## Load Test

```  
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









