TvGuide-RESTapi
===================

Write an application that serves data using a REST­ interface with the following requirements:

1. Given a specific day and a specific channel, serve the broadcasts that are within 07:00 AM the same day and 07:00 AM the following day. 

        http://localhost:8080/tvguide-restapi/rest/broadcasts/find/[date]/[channelId]

        [date] - e.g. 2013-10-19

2. Given a specific program, serve reruns of the same programs

        http://localhost:8080/tvguide-restapi/rest/programs/reruns/[programId]

3. Given a specific series, serve a list of seasons and episodes, with corresponding broadcasts for each episode.

        http://localhost:8080/tvguide-restapi/rest/series/find/[seriesId]

        JSON List with [program.season, program.episode, program.beginTime, broadcast.endTime, broadcast.channelId]

4. Bonus: Write a feature that you think is beneficial to users

Other access points to the application
---------------------

The application will be running at the following URL:

        http://localhost:8080/tvguide-restapi/

The sample data is loaded at start-up into the H2 in-memory database, for every resource (broadcasts, channels, programs) I created this generic api to do three basic actions:

* Get all records

        http://localhost:8080/tvguide-restapi/rest/broadcasts/

* Count records:  
        
        http://localhost:8080/tvguide-restapi/rest/broadcasts/count/

* Get specific record: 
 
        http://localhost:8080/tvguide-restapi/rest/broadcasts/1


System requirements
-------------------

All you need to build this project is Java 6.0 (Java SDK 1.6) or better, Maven 3.0 or better.

The application this project produces is designed to be run on JBoss AS 7 or JBoss Enterprise Application Platform 6.

Start JBoss Enterprise Application Platform 6 or JBoss AS 7 with the Web Profile
-------------------------

1. Open a command line and navigate to the root of the JBoss server directory.
2. The following shows the command line to start the server with the web profile:

        For Linux:   JBOSS_HOME/bin/standalone.sh    	

Build and Deploy the application
-------------------------

1. Make sure you have started the JBoss Server as described above.
2. Open a command line and navigate to the root directory of this quickstart.
3. Type this command to build and deploy:

        mvn clean package jboss-as:deploy

4. This will deploy `target/tvguide-restapi.war` to the running instance of the server.


Undeploy the Archive
--------------------

        mvn jboss-as:undeploy		

