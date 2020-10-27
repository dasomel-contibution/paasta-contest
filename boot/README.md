# 공통컴포넌트 Boot 전환
## 1. pom.xml 수정

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.5.19.RELEASE</version>
    </parent>
    
    <!-- Spring Boot -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
        <exclusions>
            <exclusion>
                <groupId>ch.qos.logback</groupId>
                <artifactId>logback-classic</artifactId>
            </exclusion>
        </exclusions>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-jdbc</artifactId>
    </dependency>
    <dependency>
        <groupId>org.apache.tomcat.embed</groupId>
        <artifactId>tomcat-embed-jasper</artifactId>
    </dependency>
    <dependency>
        <groupId>org.glassfish</groupId>
        <artifactId>javax.el</artifactId>
    </dependency>

## 2. CommonBootApplication 생성

## 3. xml 파일 이동
    * springboot 는 WEB-INF 를 사욯하지 않아 인식이 안됨
    egov-com-interceptor.xml
    egov-com-servlet.xml
    /src/main/webapp/WEB-INF/config/egovframework/springmvc
    ->
    src/main/resources/egovframework/spring/mvc
    
## 전환작업 중