# orm project - demo project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables **live coding** using (can load the wrong maven version):

`./mvnw quarkus:dev`

You can also use `mvn quarkus:dev` if you installed maven properly. (Recommended way, uses the installed maven version and bypasses the script )

If not already done, compile the application in dev mode using: `mvn compile` or combine the commands by `mvn compile quarkus:dev`

## REST end points

Check the following URLs after you have started your cloud-based application on your local computer successfully:

1. [http://localhost:8081/](http://localhost:8081/)
2. [http://localhost:8081/hello](http://localhost:8081/hello)
3. [http://localhost:8081/hello/listPatients](http://localhost:8081/hello/listPatients)
4. [http://localhost:8081/hello/listPatientsAsHtml](http://localhost:8081/hello/listPatientsAsHtml)
5. [http://localhost:8081/swagger-ui](http://localhost:8081/swagger-ui)


## Student Tasks

1. REST. Describe for each url (2..4) mentioned above what you see in the browser! Have a closer look at the code to explain the implementation details. 
2. REST documentation. Try out the *swagger-ui*. Explain in your own words what swagger is!
3. Cloud. Register at *heroku*, install the *heroku cli*-tools and deploy your application to heroku. Be aware that you have to adapt the name of your application in the `pom.xml` file. 

```
<heroku.appName>swen-orm-demo</heroku.appName>
```

In order to deploy your application to heroku use the heroku-maven plugin:

1. Commit your changes to local master branch (git)
2. Push your changes to the remote heroku master branch: `git push heroku master`
3. Look at the heroku console which url you should use to access your application in the cloud: `https://my-application.herokuapp.com/index.html`

Put your url into the wiki (in moodle) by providing your name, application name and the url!

Customize your application:

1. Change the background of your application. Which web framework for styling is currently used?
2. Increase the number of patients which are listed in the application to 250.
3. Change the configuration of your application in ` src/main/resources/application.properties` by using a different local port.

Don't forget to submit your changes to git (locally and remotely).

## Packaging and running the application

The application is packageable using `./mvnw package`.
It produces the executable `orm-1.0.0-SNAPSHOT-runner.jar` file in `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/orm-1.0.0-SNAPSHOT-runner.jar`.

