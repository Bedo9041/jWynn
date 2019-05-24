jWynn
========
A currently WIP java wrapper for the [Wynncraft](https://wynncraft.com/) [public API](https://docs.wynncraft.com/)
## Usage
### Setup
This wrapper is distributed using [jitpack.io](https://jitpack.io/). This can be done using Maven:
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
```xml
<dependencies>
    <dependency>
        <groupId>com.github.Bedo9041</groupId>
        <artifactId>jWynn</artifactId>
        <version>VERSION</version>
    </dependency>
</dependencies>
```
Using Gradle:
```groovy
repositories {
    maven { url 'https://jitpack.io' }
}
```
```groovy
dependencies {
    implementation 'com.github.Bedo9041:jWynn:VERSION'
}
```
Where VERSION can be selected from the [releases page](https://github.com/Bedo9041/jWynn/releases).
### Basic Usage
Firstly, you should create a new instance of WynncraftAPI, this will be the entry point for all future requests using this wrapper. You can optionally pass in a WynncraftAPIConfig object to configure the default behaviour of the wrapper. The configuration set (or the default configuration, if none is specified) can be override on a request-by-request basis.
```java
WynncraftAPI api = new WynncraftApi();
```
Once you have the base objects, requests can be made by following a similar structure to the way a request would be made to the web API. Once you have an APIRequest object, you can configure the request further, or simply run it immediatly. For example if I wanted to get my player stats I would do:
```java
WynncraftPlayer player = api.v2().player().stats("_Bedo_").run()[0];
System.out.println(player.getUsername()); // _Bedo_
System.out.println(player.getMeta().getFirstJoin()); // Mon Apr 28 17:37:03 BST 2014
System.out.println(player.getMeta().getTag().getValue()); // HERO
```
Due to the different structure of V1 requests they generally don't need multiple method calls to run:
```java
WynncraftGuild guild = api.v1().guildStats("Imperial").run();
System.out.println(guild.getCreated()); // Wed Jan 14 12:09:42 GMT 2015
System.out.println(guild.getPrefix()); // Imp
```
Generally once you have the data object, the fields within said object are fairly self explanatory, however if you do have issues feel free to get in touch with me on discord \_Bedo\_#0160. (Note I have PMs from Wynncraft's main discord disabled due to spam, please join the [Wynncraft API Discord](https://discord.gg/nUFD9xX))

By default the wrapper will handle rate limits automatically, however due to potentially receiving cached data, and the fact requests may be made by multiple sources on the IP, it may not be 100% accurate. I have made the best attempt to deal with these issues, but sometimes it may not work. Due to this you should aim to reduce the amount of requests you make and cache data for as long as relevant to prevent excessive requests.
### Exceptions
The following exceptions are used when problems occur:
* APIException is the base class - all other API exceptions extend this and this can be used as a general exception to catch all problems with a request.
* APIConnectionException is thrown when the wrapper was unable to establish a connection with Wynncraft's API **or** the connection timeout during download. If you have set a custom URL make sure the request is going to the right place; if you are not check whether the API is down, or try increasing the timeout on the request.
* APIRateLimitExceededException is thrown if a 429 response code is received from the server, or (if rate limit management is enabled) if the wrapper expects that the request you are about to make would exceed the rate limit. You can check which of these it is by calling `.isFromRequest()` and get to see when the request can be retried using `.getTryAgain()` 
* APIRequestException is thrown if there was a problem with your request, check to see what you are doing wrong (or if there's a bug with the wrapper). You should not continue to make similar requests.
* APIResponseException is thrown if there was a problem with the data received from the request. Some common causes of this include: an unexpected response code was received from the API; the API didn't specify the correct content-type for the request. When you get this exception you can get the status code returned by the server using `.getStatusCode()`, this will be -1 if an expected status code was returned.
### Configuration
You can configure the wrapper by passing an instance of WynncraftAPIConfig into the constructor of WynncraftAPI. You can currently configure 4 basic variables that are used throughout the wrapper:
1. The base URL that requests should be made to (default: https://api.wynncraft.com/)
2. Whether the API should automatically handle rate limits (default: true)
3. The user-agent that requests will be submitted as (default: `jWynn/v<VERSION>`)
4. The default connection **and** read timeout when connecting to the api (in milliseconds) (default: 10000)

Example using the default values:
```java
WynncraftAPIConfig config = new WynncraftAPIConfig("https://api.wynncraft.com/", true, "jWynn/v" + WynncraftAPI.VERSION, 10000);
WynncraftAPI api = new WynncraftAPI(config);
```
In addition to the configuration that changes the behaviour across the entire wrapper, you can also individually config each request in a builder fashion by calling the methods within the request. For example:
```java
api.v2().player().stats("_Bedo_").ignoreRateLimit().withTimeout(5000).toURL("https://example.com/").run();
```
The methods that change requests are generally self explanatory. The only exception to this is the `.fallbackFile(File)` method, which specifies the file to save the request to **and** the file to attempt to load from if the web request fails.
