# Prime Number Generator

This application is built in order to generate prime numbers between a given range.

- Provides both command line and http to get requests.

> Has 3 methods to generate prime numbers: straight, log and sieve methods.
> - Straight: Slowest method to generate prime numbers in a given range
> - Log: Runs faster that `straight`
> - Sieve: The fastest algorithm among all.

All of them generates the same output for a given range.

## Download

```bash
git clone git@github.com:fatihcataltepe/prime-number-generator.git
```

## Create Database

Execute the following script in a `msyql` database

```mysql
drop SCHEMA simscale;

create SCHEMA simscale;

use simscale;

CREATE TABLE simscale.primes
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    timestamp BIGINT NOT NULL,
    start INT NOT NULL,
    end INT NOT NULL,
    time_elapsed INT NOT NULL,
    algorithm_type VARCHAR(100) NOT NULL,
    num_of_primes INT NOT NULL
);
```


## Build

```bash
# go to project's directory
cd prime-number-generator

# build web application
gradle build -DmainClass=com.simscale.primes.ws.Application -DjarName=prime-number-generator-ws

# build command line application
gradle build -DmainClass=com.simscale.primes.terminal.Main -DjarName=prime-number-generator-terminal
```
## Configuration

```bash
#Go to `build/libs` directory by
cd build/libs

#Create application.properties file
touch application.properties
```

Paste the followings into `application.properties`
```text
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/simscale 
spring.datasource.username=root
spring.datasource.password=12345
spring.datasource.driver-class-name=com.mysql.jdbc.Driver

spring.main.banner-mode=off
spring.datasource.hikari.connection-timeout=60000
spring.datasource.hikari.maximum-pool-size=5
```

> Do not forget to update `url, username, password` fields according to your own database configurations.

## Run as Command Line Application

```bash
cd build/libs
java -jar prime-number-generator-terminal-1.0-SNAPSHOT.jar algorithm_type lower-bound upper-bound
```

- algorithm_type can be `straight`, `log` and `sieve`
- lower-bound and upper-bound can be integers



## Run as Web Application

Execute the following command:

```bash
cd build/libs

#make sure that `application.properties` is in the directory, otherwise see Configuration step again.
java -cp . -jar prime-number-generator-ws-1.0-SNAPSHOT.jar 

#Now application is running on 8080 port
```

## Web Services

Postman can be used to test this web services.

### 1. primes/straight (POST)

Calculates the prime numbers with straight method.

*Request:*

```json
{
	"start":1,
	"end":10
}
```
*Response*

```json
[
    2,
    3,
    5,
    7
]
```

### 2. primes/log (POST)

Calculates the prime numbers with log method.

*Request:*

```json
{
	"start":1,
	"end":10
}
```
*Response*

```json
[
    2,
    3,
    5,
    7
]
```

### 3. primes/sieve (POST)

Calculates the prime numbers with sieve method.

*Request:*

```json
{
	"start":1,
	"end":10
}
```
*Response*

```json
[
    2,
    3,
    5,
    7
]
```