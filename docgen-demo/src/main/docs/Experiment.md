# Experiment Application

This application can provides a function of message delivery.

## Usage

To use the Experiment Application, you can add the following dependencies.

* Maven (in your `pom.xml`):

```
<dependency>
  <groupId>${maven.groupId}</groupId>
  <artifactId>${maven.artifactId}</artifactId>
  <version>${maven.version}</version>
</dependency>
```

* Gradle (in your `build.gradle` file):

```groovy
dependencies {
  compile '${maven.groupId}:${maven.artifactId}:${maven.version}'
}
```

## Examples

Here are some simple examples to show you how to use it

To deploy a simple message delivery HTTP server:

```$lang
{@link examples.Examples#example1(io.vertx.core.Vertx)}
```

To deploy a simple message delivery TCP server:

```$lang
{@link examples.Examples#example2(io.vertx.core.Vertx)}
```

To send a message:

```$lang
{@link examples.Examples#example3()}
```