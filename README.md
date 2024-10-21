## KNN Implementation:


Command to run:

Prerequisite:
Server should be up and running.

1. Go to client folder
2. There you will find two subfolder, client1, and client2
3. Go to client1 folder, and run below command
```shell
java -jar knn-client-1.0-SNAPSHOT.jar server1_port server2_port k query_point_x query_point_query_point_x 
```
Here:
- server1_port: Port of server 1
- server2_port: Port of server 2
- query_point_x: x part of query coordinate
- query_point_y: y part of query coordinate
- k: how many point you want to locate from given query


Q) Discuss how gRPC facilitates distributed computing in this example.
In the knn implementation we have implemented the KNN where dataset is distributed among
various server, and client query to find the k neared point from a given coordinate.

Below are the few points which we have considered:
1. Client server implementation: here we have implemented knn in client server model 
where knn client is requesting for the computation, and other servers are taking part
in distance calculation.
2. Each server is holding a subset of data, and responsible for the independently computing
the k distance.
3. gRPC is proving the underlying low level abstraction for these communication.
4. Network communication are taking place on the HTTP/2 protocol, and protocol buffer is 
used for data serialisation.
5. Client is acting as master client and handling the multiple server response.
6. Fault Tolerance: gRPC retries failed requests automatically, so if a server goes down or network communication fails, the client can retry.
7. Load balancing support is also provided by the gRPC framework.
8. gRPC's design allows the KNN computation to scale across many distributed servers.
9. gRPC is efficient with low-latency communication (via HTTP/2) and supports streaming, allowing the client to handle large-scale datasets distributed across different servers.

Q) Comparison between gRPC and MPI in terms of communication models, usability, and scalability.

| **Feature**             | **gRPC**                                       | **MPI**                                        |
|-------------------------|------------------------------------------------|------------------------------------------------|
| **Communication Model**  | Client-server (RPC-based)                     | Peer-to-peer (message-passing)                 |
| **Use Cases**            | Microservices, web APIs, distributed systems   | High-performance computing, parallel simulations |
| **Abstraction**          | High-level, abstracted communication          | Low-level, explicit message passing            |
| **Fault Tolerance**      | Built-in features for fault tolerance (retries) | Limited, failure often halts the computation   |
| **Protocol**             | HTTP/2, Protocol Buffers, TLS                 | Direct networking (TCP/IP, Infiniband)         |
| **Programming Model**    | Service-oriented programming                  | Parallel programming                           |
| **Scalability**          | Scales well for loosely coupled services       | Scales in HPC clusters, tightly coupled systems |
| **Concurrency**          | Supports async calls, concurrency through threading | Optimized for parallelism across processes  |

![img.png](report%2Fimg.png)