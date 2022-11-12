
# Docker Image

* http://basho.com/products/riak-kv/
* https://hub.docker.com/r/basho/riak-kv/

"Riak KV is a distributed NoSQL key/value database with advanced local and
"multi-cluster replication that guarantees reads and writes even in the event
"of hardware failures or network partitions. — Basho

## Starting a Riak KV cluster

You can start a simple Riak KV cluster using docker-compose. Create a working
directory named riak and inside that directory create a file named docker-
compose.yml based on the following example.

Note: the coordinator node is the first one to be started in the cluster and
is the node to which all the others will join. It's also the only container
exposed on a predictable port.

## docker-compose.yml

```
version: "2"
services:
  coordinator:
    image: basho/riak-kv
    ports:
      - "8087:8087"
      - "8098:8098"
    environment:
      - CLUSTER_NAME=riakkv
    labels:
      - "com.basho.riak.cluster.name=riakkv"
    volumes:
      - schemas:/etc/riak/schemas
  member:
    image: basho/riak-kv
    ports:
      - "8087"
      - "8098"
    labels:
      - "com.basho.riak.cluster.name=riakkv"
    links:
      - coordinator
    depends_on:
      - coordinator
    environment:
      - CLUSTER_NAME=riakkv
      - COORDINATOR_NODE=coordinator

volumes:
  schemas:
    external: false
```

# Start Cluster

If you bring up the cluster now, you'll get a single-node cluster consisting
of only the coordinator node.

```
$ docker-compose up -d coordinator
```

# Riak Admin Console

Open Riak Explorer in the browser by navigating to:

* http://localhost:8098/admin/ 

You can now create data types using the explorer web UI. There is also a
comprehensive REST API your applications can leverage when interacting with
this Dockerized cluster.

* http://basho-labs.github.io/riak_explorer/docs/api.html

# Scaling the Cluster

You can scale the cluster to multiple nodes by using docker-compose and
scaling the member service to the number of nodes you want.

```
docker-compose scale member=4
```

The above will scale the cluster to 5 total nodes (1 coordinator + 4 member).
If you refresh the OPS page in Riak Explorer you should see the new nodes
(they'll be using the Docker internal IPs which are 172.18.0.X).

# Volumes for data

The default configuration above creates an ephemeral cluster--one you throw
away when your task is complete. In order to persist data from one run to the
next, provide a volume for the image that mounts to the container path
/var/lib/riak.

Consult the official docker-compose reference for more information.

# HOST:PORT Discovery

To discover the HOST:PORT values needed to connect to the Riak nodes running
in the Dockerized cluster, you can use a combination of docker inspect and jq.

Set an environment variable to hold the HOST:PORT pairs.

```
export CLUSTER_NAME=riakkv
export RIAK_HOSTS=$(echo $(docker inspect $(docker ps -q -f label=com.basho.riak.cluster.name=$CLUSTER_NAME) | jq -r '.[] | "localhost:" + .NetworkSettings.Ports."8087/tcp"[0].HostPort') | tr ' ' ',')
```

Note: if you change the label com.basho.riak.cluster.name in the docker-
compose configuration, you'll need to make sure the docker ps filter in the
above command reflects this change.

# Data type bootstrapping

Automatic loading of data types is supported in this image. It does this by
looking for files inside the /etc/riak/schemas/ directory, which can be
mounted as a volume. If a file ends with a .dt it's assumed to be a KV data
type. The basename of the file (minus the .dt suffix) will be used as the
bucket name.

To use the schema bootstrapping with docker-compose you need to set up a
volume named "schemas" that contains all the schema files. This volume will be
mounted in the container at path /etc/riak/schemas/.

The following will create a volume named schemas and copy the contents of
$(pwd)/schemas/* to the volume. When docker-compose up is run, the dt files
will be translated into riak-admin bucket type create and activate commands
based on the basename of the file.

```
docker run --rm -it -v riak_schemas:/etc/riak/schemas -v $(pwd)/schemas:/tmp/schemas alpine cp /tmp/schemas/* /etc/riak/schemas/
```



