# exampleSpringHateoas

### **1. Description**
* **Spring HATEOAS**를 사용한 간단한 REST API 웹 프로젝트
* 실행 URL
  + **localhost:8080/exampleSpringHateoas/api/actors** 또는 **localhost:8080/exampleSpringHateoas/api/actors/id**
  + **localhost:8080/exampleSpringHateoas/api/albums** 또는 **localhost:8080/exampleSpringHateoas/api/albums/id**

### **2. Environment**
* **IDE**
  + Intellij IDEA
* **Database**
  + MySQL
* **Server**
  + Tomcat
  
  
### **3. Packages & Class**
* **assembler package**
  + JPA Entity Class를 DTO 객체로 변환하기 위한 Class
  + **ActorModelAssembler, AlbumModelAssembler**
* **controller package**
  + 사용자 요청을 처리하는 메인 Class로 여기서는 Read 기능만 사용
  + **WebController**
* **entity package**
  + Entity 정보를 저장하는 Class
  + **ActorEntity, AlbumEntity**
* **model package**
  + Representation을 위한 Class
  + **ActorModel, AlbumModel**
* **repository package**
  + Spring Data JPA를 사용하여 CRUD 기능을 구현한 Class
  + **ActorRepository, AlbumRepository**
* **MyAppRunner Class**
  + 데이터베이스 초기화를 위한 Class


### **4. 주요 Files**
* **pom.xml**
  + 프로젝트 기본 정보 및 Dependency 관리
  + 사용한 Dependency
    - lombok
    - spring-boot-starter-web
    - spring-boot-starter-data-jpa
    - mysql-connector-java
    - spring-boot-starter-hateoas
* **application.properties**
  + 애플리케이션 속성(Property) 정보를 작성하는 파일
    - **Data Source, JPA & Hibernate, Logging** 관련 설정
