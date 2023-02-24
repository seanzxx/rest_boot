# Rest Boot

Rest Boot is a lightweight REST framework that uses Jersey, Jetty, and JAX-RS. It's designed to help you quickly build production-grade APIs with minimal effort.

## Features

Rest Boot includes the following features:

- Easy configuration: Rest Boot is designed to be easy to configure, so you can get your API up and running quickly.
- Robust request handling: Rest Boot uses Jersey and JAX-RS to handle requests, providing robust support for HTTP methods, content types, and other request features.
- Embedded Jetty server: Rest Boot includes an embedded Jetty server, so you don't need to set up a separate server to run your API.
- Customizable error handling: Rest Boot includes customizable error handling, so you can provide meaningful error messages to your API users.
- Lightweight and flexible: Rest Boot is lightweight and flexible, so you can use it with a variety of Java frameworks and libraries.

## Getting Started

To get started with Rest Boot, you'll need to add the following dependency to your project:

```xml
<dependency>
    <groupId>com.edriving.commons</groupId>
    <artifactId>rest-boot</artifactId>
    <version>1.0.0</version>
</dependency>
```
Once you've added the dependency, you can start using Rest Boot in your project.

## Usage

Rest Boot provides a simple and intuitive API for building RESTful APIs. Here's an example:

```java
@Path("/hello")
public class HelloWorldResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, world!";
    }
}
```

In this example, we've defined a resource class that responds to GET requests on the "/hello" path. When a request is received, the sayHello() method is called, which returns the string "Hello, world!".

## Building from Source

To build Rest Boot from the source code, follow these steps:

1. Clone the Rest Boot repository from GitHub: `git clone https://github.com/edriving-limited/rest_boot.git`
2. Navigate to the `rest_boot` directory: `cd rest_boot`
3. Build Rest Boot using Maven: `mvn clean package`

After the build is complete, you'll find the Rest Boot JAR file in the `target` directory.

You can also install Rest Boot JAR file in your local Maven repository by running `mvn clean install`.

## Running the Example

To run the example included with Rest Boot, follow these steps:

1. Clone the Rest Boot repository from GitHub: `git clone https://github.com/edriving-limited/rest_boot.git`
2. Navigate to the `rest_boot/example` directory: `cd rest_boot/example`
3. Build the example using Maven: `mvn clean package`
4. Start the example server: `java -Dapi-package=com.edriving.example -jar target/rest-boot-example-1.0.0.jar`
5. Open a web browser and go to `http://localhost:8080/hello`

You should see a "Hello, world!" message in your web browser. This demonstrates how to define a simple resource class and respond to HTTP requests.

## License

Rest Boot is licensed under the MIT License.
