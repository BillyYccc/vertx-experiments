# Experiment Application

This application can provides a function of message delivery.

## Usage

To use the Experiment Application, you can add the following dependencies.

* Maven (in your `pom.xml`):

```
<dependency>
 <groupId>com.billyyccc</groupId>
 <artifactId>docgen-demo</artifactId>
 <version>1.0-SNAPSHOT</version>
</dependency>
```

* Gradle (in your `build.gradle` file):

```groovy
dependencies {
 compile 'com.billyyccc:docgen-demo:1.0-SNAPSHOT'
}
```

## Examples

Here are some simple examples to show you how to use it

To deploy a simple message delivery HTTP server:

```groovy

// deploy our experiment HTTP server
ExperimentApplication.deployHttpServer(vertx)

```

To deploy a simple message delivery TCP server:

```groovy

// deploy our experiment TCP server
ExperimentApplication.deployTcpServer(vertx)

```

To send a message:

```groovy

// send a message
def experimentApplication = ExperimentApplication.createApplication()
experimentApplication.send("Your message", "Address")

```