# Integra Nota Fiscal

![Licença](https://img.shields.io/badge/licença-MIT-green)
![Versão do Java](https://img.shields.io/badge/Java-21-blue)
![Build Status](https://img.shields.io/badge/build-passing-brightgreen)

## Descrição

Este projeto é uma aplicação Jakarta EE desenvolvida com Spring Data JPA para persistência de dados, Lombok para reduzir o boilerplate, e Spring MVC para a criação de APIs RESTful. Ele está configurado para rodar com o Java 21 na porta 8083. Basicamente, esse projeto visa fazer a integração com gateways de pagamento para gerar notas fiscais de maneira mais fácil e eficiente.

## Estrutura do Projeto

- **Controller**: Contém os endpoints da API.
- **Service**: Implementa a lógica de negócio do aplicativo.
- **Repository**: Interface para a comunicação com o banco de dados.
- **Model**: Contém as entidades do banco de dados.

## Requisitos

- Java 21
- Maven 3.6+
- Banco de Dados MySql

## Instalação

1. Clone o repositório:

    ```sh
    git clone https://github.com/GabrielRochaFC/MentoriaRasmoo-IntegraNotaFiscal.git
    ```

2. Navegue até o diretório do projeto:

    ```sh
    cd IntegraNf
    ```

3. Compile o projeto usando Maven:

    ```sh
    mvn clean install
    ```

4. Execute a aplicação:

    ```sh
    java -jar target/IntegraNf-0.0.1-SNAPSHOT.jar
    ```

## Configuração

Certifique-se de configurar as informações do banco de dados em `src/main/resources/application.properties` conforme o necessário:

```properties
server.port=${SERVER_PORT}
spring.datasource.url=${SPRING_DATASOURCE_URL}
spring.datasource.username=${SPRING_DATASOURCE_USERNAME}
spring.datasource.password=${SPRING_DATASOURCE_PASSWORD}
```

## Endpoints

A aplicação fornece vários endpoints, conforme detalhado abaixo. O context path é `/integranf`.

### Autenticação

- **POST** `/auth/login`: Autenticação de usuários.
    - Request Body: `{"email": "user@example.com", "password": "password"}`
    - Response: `{"token": "jwt_token"}`

- **POST** `/auth/register`: Registro de novos usuários.
    - Request Body: `{"email": "user@example.com", "password": "password", ...}`
    - Response: `{"id": 1, "email": "user@example.com", ...}`

### Usuários

- **GET** `/user`: Lista todos os usuários paginados.
    - Query Params: `page`, `size`
    - Response: `[{"id": 1, "name": "John Doe", ...}, ...]`

- **PATCH** `/user/{id}`: Atualiza informações de um usuário.
    - Path Param: `id` (ID do usuário)
    - Request Body: `{"name": "New Name", ...}`
    - Response: `{"id": 1, "name": "New Name", ...}`

### Tipos de Usuário

- **GET** `/user-type`: Lista todos os tipos de usuário.
    - Response: `[{"id": 1, "type": "Admin", ...}, ...]`

### Tipos de Assinatura

- **POST** `/subscription-type`: Cria um novo tipo de assinatura.
    - Request Body: `{"type": "Premium", "duration": 12, ...}`
    - Response: `{"id": 1, "type": "Premium", ...}`

- **GET** `/subscription-type`: Lista todos os tipos de assinatura paginados.
    - Query Params: `page`, `size`, `enabled`
    - Response: `[{"id": 1, "type": "Premium", ...}, ...]`

### Assinaturas

- **POST** `/subscriptions/select`: Assigna uma assinatura a um usuário autenticado.
    - Request Body: `{"subscriptionTypeId": 1, ...}`
    - Response: `{"id": 1, "userId": 1, "subscriptionTypeId": 1, ...}`

### Gateways

- **POST** `/gateway`: Cria um novo gateway.
    - Request Body: `{"name": "Gateway1", ...}`
    - Response: `{"id": 1, "name": "Gateway1", ...}`

- **GET** `/gateway`: Lista todos os gateways.
    - Response: `[{"id": 1, "name": "Gateway1", ...}, ...]`

- **POST** `/gateway/integrations`: Registra uma integração de usuário com um gateway.
    - Request Body: `{"userId": 1, "gatewayId": 1, ...}`
    - Response: `{"id": 1, "userId": 1, "gatewayId": 1, ...}`

- **GET** `/gateway/integrations`: Lista todas as integrações de usuário com gateways, paginados.
    - Query Params: `page`, `size`
    - Response: `[{"id": 1, "userId": 1, "gatewayId": 1, ...}, ...]`

## Contribuição

1. Faça um fork do repositório.
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`).
3. Commit suas mudanças (`git commit -am 'Adiciona uma nova feature'`).
4. Push para a branch (`git push origin feature/nova-feature`).
5. Abra um Pull Request.

## Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo LICENSE.md para detalhes.

## Contato

- LinkedIn: [Gabriel Rocha](https://linkedin.com/in/gabriel-rocha-28ab8414b)

---

Feito com ❤️ por [Gabriel Rocha](https://github.com/GabrielRochaFC)