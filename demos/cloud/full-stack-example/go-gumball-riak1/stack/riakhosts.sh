export CLUSTER_NAME=riakkv

export RIAK_HOSTS=$(echo $(docker inspect $(docker ps -q -f label=com.basho.riak.cluster.name=$CLUSTER_NAME) | jq -r '.[] | "localhost:" + .NetworkSettings.Ports."8087/tcp"[0].HostPort') | tr ' ' ',')
export RIAK_HOSTS_HTTP=$(echo $(docker inspect $(docker ps -q -f label=com.basho.riak.cluster.name=$CLUSTER_NAME) | jq -r '.[] | "localhost:" + .NetworkSettings.Ports."8098/tcp"[0].HostPort') | tr ' ' ',')

echo $RIAK_HOSTS
echo $RIAK_HOSTS_HTTP
