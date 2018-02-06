#HowTorun
- jar
~~~
./gradlew bootRepackage
java -jar ./build/libs/demo-0.0.1-SNAPSHOT.jar
~~~
- gradlew
~~~
export JAVA_OPTS=-Xmx1024m -XX:MaxPermSize=128M
./gradlew bootRun
~~~
- java option
~~~
-Dspring.profiles.active=develop
~~~
- docker
~~~
./gradlew build -x test
docker build . -t springboot-demo:0.0.1
docker run -e "SPRING_PROFILES_ACTIVE=docker" -p 8080:8080 --name spring-demo -it --rm -d springboot-demo:0.0.1
~~~

#Properties
- Yaml 은 profile 별 속성이 전부 한파일에 있어서 보기 힘듬
- @ConfigurationProperties, @Value 중 spEl이 필요할땐 @value를 쓰면 됨

#Static resource
- -classpath /Users/akaroice/toss-project/demo/build/classes/main:/Users/akaroice/toss-project/demo/build/resources/main:
- classpath 경로에 맞게 resource location 도 classpath:/static 으로 줌 

#Logback pattern
- https://logback.qos.ch/manual/layouts.html
- logger{length}

#Mysql
~~~
$ docker run --name mysql -e MYSQL_ROOT_PASSWORD=root -p 3306:3306 -d mysql
$ docker exec -it mysql bash
$ mysql -u root -p
~~~
~~~
$ docker start mysql
$ docker exec -it mysql bash
$ mysql -u root -p
~~~

#Redis
- RedisAutoConfiguration
~~~
docker run --name redis -d -p 6379:6379 redis:4.0.6
docker exec -it redis bash
docker run -v /workspace/redis/redis.conf:/usr/local/etc/redis/redis.conf --name redis -d -p 6379:6379 redis:4.0.6 redis-server /usr/local/etc/redis/redis.conf
~~~
- AbstractCacheManager - key generator
- CacheAspectSupport - support cache annotation process

#Security
- http://localhost:8080/api/demo without security
- http://localhost:8080/welcome redirect to login
- http://localhost:8080/logout - never use GET logout in production

Endpoints security check
- MvcEndpointSecurityInterceptor
- user, name are used by SpringSecurity

#Test
- @RestClientTest include customConfiguration automatically so it is better that a configuration holds beans by itself(ex cacheRedisProperties is declared in the configuration)  

#Details
##Hibernate naming stratergy
- SpringNamingStrategy

##Gradle commands
- gradle tasks --all

##ViewSresolver
- MustacheAutoConfiguration
- MustacheViewResolver
