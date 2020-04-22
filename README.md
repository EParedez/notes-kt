# notes-kt


###run cassandra
* docker run --name cas1 -p 9042:9042  -d cassandra
* to validate the above, connect to port 9042, not user not password
* run the following sentence CQL
```
CREATE KEYSPACE keyspacenotes
WITH replication = {
	'class' : 'NetworkTopologyStrategy',
	'datacenter1' : 1,
	'datacenter2' : 1
};


CREATE TABLE keyspacenotes.mytable (
	id int primary key,
	name text
);
```

###references
* https://www.quora.com/Which-ports-does-Cassandra-use-and-how-are-they-used
* https://gokhanatil.com/2018/02/build-a-cassandra-cluster-on-docker.html
* https://www.baeldung.com/spring-data-cassandra-tutorial
* https://docs.spring.io/spring-data/cassandra/docs/current/reference/html/#reference
* https://hub.docker.com/_/cassandra
* https://medium.com/@michaeljpr/five-minute-guide-getting-started-with-cassandra-on-docker-4ef69c710d84
