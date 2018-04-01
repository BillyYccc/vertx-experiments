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

```ruby
require 'experiment-application/experiment_application'

# deploy our experiment HTTP server
ExperimentApplication::ExperimentApplication.deploy_http_server(vertx)

```

To deploy a simple message delivery TCP server:

```ruby
require 'experiment-application/experiment_application'

# deploy our experiment TCP server
ExperimentApplication::ExperimentApplication.deploy_tcp_server(vertx)

```

To send a message:

```ruby
require 'experiment-application/experiment_application'

# send a message
experimentApplication = ExperimentApplication::ExperimentApplication.create_application()
experimentApplication.send("Your message", "Address")

```