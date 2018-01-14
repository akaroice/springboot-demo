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
#Properties
- Yaml 은 profile 별 속성이 전부 한파일에 있어서 보기 힘듬
- @ConfigurationProperties, @Value 중 spEl이 필요할땐 @value를 쓰면 됨

#Static resource
- -classpath /Users/coupang/toss-project/demo/build/classes/main:/Users/coupang/toss-project/demo/build/resources/main:
- classpath 경로에 맞게 resource location 도 classpath:/static 으로 줌 

#Logback pattern
- https://logback.qos.ch/manual/layouts.html
- logger{length}

#Gradle commands
gradle tasks --all

#ViewSresolver
- MustacheAutoConfiguration
- MustacheViewResolver