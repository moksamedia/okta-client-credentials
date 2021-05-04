# OAuth 2.0 Client Credential With Spring Boot
 
This example app shows how to implement the client credentials grant with Spring Boot and Spring Security 5

Please read [OAuth 2.0 Client Credential With Spring Boot](https://developer.okta.com/blog/<need a link>) to see how this app was created.

**Prerequisites:** HTTPie, [Java 11](https://adoptopenjdk.net/) and an [Okta Developer Account](https://developer.okta.com).

> [Okta](https://developer.okta.com/) has Authentication and User Management APIs that reduce development time with instant-on, scalable user infrastructure. Okta's intuitive API and expert support make it easy for developers to authenticate, manage, and secure users and roles in any application.

> Java 11: This project uses Java 12. OpenJDK 12 will work just as well. Instructions are found on the [OpenJDK website](https://openjdk.java.net/install/). OpenJDK can also be installed using [Homebrew](https://brew.sh/). Alternatively, [SDKMAN](https://sdkman.io/) is another great option for installing and managing Java versions.

> HTTPie: This is a powerful command-line HTTP request utility that you'll use to test the WebFlux server. Install it according to [the docs on their site](https://httpie.org/doc#installation).

* [Getting Started](#getting-started)
* [Links](#links)
* [Help](#help)
* [License](#license)

## Getting Started

The repository contains three sub-projects:
- `/secure-server` - a simple test server
- `/client-webclient` - a client built using the new WebClient
- `/secure-server` - a client build using the deprecated RestTemplate

Before you begin, you’ll need a free Okta developer account. Install the [Okta CLI](https://cli.okta.com) and run `okta register` to sign up for a new account. If you already have an account, run `okta login`. Then, run `okta apps create`. Select the default app name, or change it as you see fit. Choose **Web** and press **Enter**.

Select **Other**. Then, change the Redirect URI to `http://localhost:8080/authorization-code/callback` and use `http://localhost:8080` for the Logout Redirect URI.

Copy `src/main/resources/application.template.yml` to `src/main/resources/application.yml` and fill in the necessary information.

See [these instructions](https://developer.okta.com/blog/2018/07/24/social-spring-boot#configure-google-and-facebook-for-social-login-in-your-spring-boot-app) to complete your social login setup.

## Links

This example uses the following open source libraries:

* [Okta Sign-In Widget](https://github.com/okta/okta-signin-widget)
* [Okta Spring Boot Starter](https://github.com/okta/okta-spring-boot)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Spring Security](https://spring.io/projects/spring-security)

## Help

Please post any questions as comments on the [blog post](https://developer.okta.com/blog/2018/07/24/social-spring-boot), or visit our [Okta Developer Forums](https://devforum.okta.com/). 

## License

Apache 2.0, see [LICENSE](LICENSE).
