# app-direct-api-integration
AppDirect API integration

**Table of Contents**

* [Overview](#overview)
* [Documentation](https://docs.appdirect.com/developer/apis/billing-api-guide/oauth-credentials)
* [Build and Run](#build-run)
* [Testing](#Testing)

## Overview<a id="overview"></a>

AppDirect API integration is a service that provided some samples that show how to consume some *AppDirect API* operations.

This service exposes four operations.

* [CompanyAdd](https://docs.appdirect.com/developer/apis/billing-api-guide/creating-a-company)
* [UserAdd](https://docs.appdirect.com/developer/apis/billing-api-guide/creating-a-user)
* [SubscriptionAdd](https://docs.appdirect.com/developer/apis/billing-api-guide/creating-a-subscription)
* [SubscriptionCancel](https://docs.appdirect.com/developer/apis/billing-api-guide/cancelling-a-subscription)

## Build and Run<a id="build-run"></a>

**Note**: This is maven project and  Maven need to be correctly setup on the host that is used to build or run this service.

```
mvn clean install

```

### Run as a "main" Java class

From your IDE, right-click on the "AppDirectApiIntegrationApplication" class at the root of your Java package hierarchy, and run it directly. 
You should also be able to debug it as easily.

This project use the lombok plugin to avoid boilerplate code.

In IntelliJ or Eclipse , for Lombok annotations, you need to enable annotation processing, change the compiler from Ajc to Javac,
and probably install the Lombok plugin.


### As a Maven target

To run the application from command line. you may run  the following commands from the project root folder after building your application:
```
mvn spring-boot:run
```


## Testing<a id="Testing"></a>

* Swagger has been setup for integration testing.
By default when you are running the service locally, the application is avaible at *http://localhost:8080/swagger-ui.html*

Launch the *swagger ui* and click on api-controller to load avaible operations.

* Normally Unit tests has been made to test all the operations.


