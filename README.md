# JeeProject - Paul GILLE & Lu XU
## Clone the application

git clone https://github.com/Lynnluxu/JeeProject.git

> cd application

## Create MySQL database

create database application Change MySQL username and password as per your MySQL installation

> open src/main/resources/application.properties file.

change spring.datasource.username and spring.datasource.password properties as per your mysql installation

## Start ActiveMQ Message Broker

Download [ActiveMQ](http://activemq.apache.org/components/classic/) Message Broker

or

```
wget http://activemq.apache.org/path/tofile/apache-activemq-x.x.x-bin.tar.gz
```

and

```
cd [activemq_install_dir]
tar zxvf activemq-x.x.x-bin.tar.gz
```

and start it

```
cd [activemq_install_dir]/bin
./activemq start
```

You can quickly check the WebConsole [available at http://localhost:8161/admin/ with credentials admin/admin.

[ActiveMQ documentation](http://activemq.apache.org/components/classic/documentation)

## Run the app

You can run the spring boot app by typing the following command -

> mvn spring-boot:run

The server will start on port 8080.

You can also package the application in the form of a jar file and then run it like so -

> mvn package

> java -jar target/polls-0.0.1-SNAPSHOT.jar

## Run the app with Docker

> cd [JeeProject directory]

> mvn -Dmaven.test.skip=true package

Start Docker

> docker-compose build

> docker-compose up



Now you're almost a superstar in JEE, you have to show your skills!**

- Find a partner to make a team, a team is made of 2 students, not 1, not 3...

- For the 2nd of march 2020:

  - You have to communicate to the teacher the students of your team and the private Git Repo for the 15th of february 2020
  - You have to send a description of your application, its features and prerequisites
  - (you will lose 1 point by day if you send too late these infos)

- Your project must :

  - be a multi-module Maven project
  - be built with JDK 8
  - rely on at least 4 entities (with joints of course) and 4 tables in RDBMS
  - provide a web GUI to the users : 3 screens minimum
  - provide technical endpoint for other machine (if made in JAX-WS, provide the WSDL, if made in JAX-RS, you will have to produce the documentation of your API). At least 4 technical endpoints are needed
  - have commits from both students

- The choices of the Java Frameworks are free for your different features, you should nevertheless use what you learned when necessary ;)

- You can ask for help with the [contact](http://jee.chticod.eu/contact) link above or by mail at [amaury.willemant@yncrea.fr](mailto:amaury.willemant@yncrea.fr)

- **The deadline is the 2nd of march 2020 23h59**
