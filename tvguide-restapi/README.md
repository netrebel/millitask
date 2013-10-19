TvGuide-RESTapi
===================

Write an application that serves data using a REST­ interface with the following requirements:

1) Given a specific day and a specific channel, serve the broadcasts that are within 07:00 AM the same day and 07:00 AM the following day

http://localhost:8080/tvguide-restapi/rest/broadcasts/find/2013-10-19/1

2) Given a specific program, serve reruns of the same programs

http://localhost:8080/tvguide-restapi/rest/programs/reruns/33

3) Given a specific series, serve a list of seasons and episodes, with corresponding broadcasts for each episode.

http://localhost:8080/tvguide-restapi/rest/series/find/1

4) Bonus: Write a feature that you think is beneficial to users

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


Access the application 
---------------------

The application will be running at the following URL <http://localhost:8080/tvguide-restapi/>.

You can also test the REST endpoint as follows. Feel free to replace `YOUR_NAME` with a name of your choosing.

* The *XML* content can be tested by accessing the following URL: <http://localhost:8080/tvguide-restapi/rest/xml/YOUR_NAME>
* The *JSON* content can be tested by accessing this URL: <http://localhost:8080/tvguide-restapi/rest/json/YOUR_NAME>

Undeploy the Archive
--------------------

        mvn jboss-as:undeploy		

