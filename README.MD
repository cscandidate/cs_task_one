# Events log processor
This is first version events log reader.

## Version 1 - only for file < 1GB
 * Add Unit Test
 * Add Flyway
 
## Version 1.2 Composed Message Processor
We can use Composed Message Processor from EIP, to split file on many small files and aggregate all messages by key
To implement this solution we can use Spring Integration
https://www.enterpriseintegrationpatterns.com/patterns/messaging/DistributionAggregate.html 

## Map reduce with java 8 reduce and nio AsyncFileReader ?

## Version 2 with DI and Spring Data
 * Add Spring Boot or Google Guice
 * Check if the Spring Data JPA batch insert is efficient enough.
 
## Version 3 with Spring Batch
 * Spring Boot Batch Partitioning
 * Parallel Processor to handle many files in many threads
 * Send POJO to Queue (Id, Pair<EventLog, EventLog>)
 * Read Object from Queue, count duration and store in database
 
## Version 4 with Map Reduce

## Version 5 with Apache Spark 


##NOTES