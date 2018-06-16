# Academia ABC - Arquitetura de Software

| Branch | Build | Coverage |
| ------------- |:-------------:|:-------------:|
| master | [![Build Status](https://travis-ci.org/alencarrh/AcademiaABC-ArqSw.svg?branch=master)](https://travis-ci.org/alencarrh/AcademiaABC-ArqSw) | [![codecov](https://codecov.io/gh/alencarrh/AcademiaABC-ArqSw/branch/master/graph/badge.svg)](https://codecov.io/gh/alencarrh/AcademiaABC-ArqSw)
| develop | [![Build Status](https://travis-ci.org/alencarrh/AcademiaABC-ArqSw.svg?branch=develop)](https://travis-ci.org/alencarrh/AcademiaABC-ArqSw) | [![codecov](https://codecov.io/gh/alencarrh/AcademiaABC-ArqSw/branch/develop/graph/badge.svg)](https://codecov.io/gh/alencarrh/AcademiaABC-ArqSw)


## Ambiente de Desenvolvimento

São pré-requisitos deste projeto:

* **Maven 3**
* **Java 8**
* **[Lombok](https://projectlombok.org/)** Habilitado na sua IDE

### Dados técnicos

- SpringBoot 2
- H2 Database
- Swagger2

### Lista de serviços da api

Execute a api localmente e acesse o seguinte link:
`http://localhost:8080/academia/swagger-ui.html`

### Setup inicial
```
git clone https://github.com/alencarrh/AcademiaABC-Dev3.git
cd AcademiaABC-Dev3/back
```

#### Compilar
```
mvn compile
```

#### Executar Testes
```
mvn test
```

#### Build executando Testes
```
mvn install
```

#### Build sem executar Testes
```
mvn install -DskipTests
```

#### Executar
```
mvn spring-boot:run
```