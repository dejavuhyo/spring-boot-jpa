# Spring Boot JPA

## 1. 설명
Spring Boot JPA 예제이며 Dto에서 Entity 변환은 ModelMapper를 사용하였다. 포트는 8080을 사용한다.

## 2. 개발환경

* OpenJDK 17

* spring-boot 3.0.1

* modelmapper 3.1.1

## 3. API 실행

### 1) 전체 조회

* GET
  - http://localhost:8080/jpa/

### 2) ID 조회

* GET
  - http://localhost:8080/jpa/1

### 3) 저장

* POST
  - http://localhost:8080/jpa/

### 4) 수정

* PUT
  - http://localhost:8080/jpa/1

### 5) 삭제

* DELETE
  - http://localhost:8080/jpa/1
