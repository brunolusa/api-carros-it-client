# Carros API - Client

Projeto com intuito de abstrair as requisições http da API Carros, fornecendo métodos que interegem diretamente com a aplicação facilitando seu uso nos projetos de Automação de Testes.

# Métodos expostos:
* DeleteCarrosClient - Expõem métodos de delete com sucesso e delete not found;
* GetActuatorClient - Expõem método de get no _Actuator/Health_;
* GetCarrosClient - Expõem métodos de get todos os carros, get pelo id e get not found;
* PostCarrosClient - Expõem método post carros com sucesso;
* PutCarrosClient - Expõem método put carros com sucesso.

# Execução:
O client gerado atravez do build deste projeto servirá como dependência nos projetos de Automação de Testes, e para isso, você precisará clonar este repositório e executar o seguinte comando:

```java
 mvn clean install
```

# Dependência
Como qualquer outra dependência externa, você precisará adicionar no seu projeto a dependência deste Client, conforme exemplo _Maven_ abaixo:

```xml
    <dependency>
        <groupId>com.lusa</groupId>
        <artifactId>api-carros-it-client</artifactId>
        <version>1.0</version>
    </dependency>
```

# Linguagens e Frameworks
* RestAssured 
* Lombok
* Java 11
* Maven


