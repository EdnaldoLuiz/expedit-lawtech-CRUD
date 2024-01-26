# Lawtech CRUD API

Este projeto é uma API RESTful criada para o desafio Rest API da Lawtech.

A documentação da API está disponível em `http://localhost:8080/swagger-ui/index.html#/`.

> Obs: O servidor está rodando em `http://localhost:8080`.

## Endpoints

A API consiste nos seguintes endpoints:

### User Repo Controller

<table align=center>
    <thead>
        <tr>
            <th>Endpoint</th>
            <th>Método</th>
            <th>Descrição</th>
        </tr>
    </thead>
    <tbody align=center>
        <tr>
            <td>/api/v1/user/repo/update</td>
            <td>PUT</td>
            <td>Atualiza um usuário existente.</td>
        </tr>
        <tr>
            <td>/api/v1/user/repo/create</td>
            <td>POST</td>
            <td>Cria um novo usuário.</td>
        </tr>
        <tr>
            <td>/api/v1/user/repo/getAll</td>
            <td>GET</td>
            <td>Retorna todos os usuários.</td>
        </tr>
        <tr>
            <td>/api/v1/user/repo/get/{id}</td>
            <td>GET</td>
            <td>Retorna um usuário específico pelo ID.</td>
        </tr>
        <tr>
            <td>/api/v1/user/repo/delete/{id}</td>
            <td>DELETE</td>
            <td>Deleta um usuário específico pelo ID.</td>
        </tr>
    </tbody>
</table>

### User DAO Controller

<table align=center>
  <tbody align=center>
        <tr>
            <td>/api/v1/user/dao/update</td>
            <td>PUT</td>
            <td>Atualiza um usuário existente.</td>
        </tr>
        <tr>
            <td>/api/v1/user/dao/create</td>
            <td>POST</td>
            <td>Cria um novo usuário.</td>
        </tr>
        <tr>
            <td>/api/v1/user/dao/getAll</td>
            <td>GET</td>
            <td>Retorna todos os usuários.</td>
        </tr>
        <tr>
            <td>/api/v1/user/dao/get/{id}</td>
            <td>GET</td>
            <td>Retorna um usuário específico pelo ID.</td>
        </tr>
        <tr>
            <td>/api/v1/user/dao/delete/{id}</td>
            <td>DELETE</td>
            <td>Deleta um usuário específico pelo ID.</td>
        </tr>
    </tbody>
</table>

### Auth Controller

<table align=center>
  <tbody align=center>
    <tr>
      <td>/api/v1/auth/register</td>
      <td>POST</td>
      <td>Registra um novo usuário.</td>
    </tr>
    <tr>
      <td>/api/v1/auth/login</td>
      <td>POST</td>
      <td>Autentica um usuário existente.</td>
      </tr>
    </tbody>
</table>

## Autorização

Para realizar as operações do CRUD de Pessoas é necessario realizar o registro para obter uma conta de admin.

### Registrar uma conta Admin

> Rota: http://localhost:8080/api/v1/auth/register

#### Formato do JSON esperado para registro:

```json
{
    "name": "Luiz",
    "login": "email@gmail.com",
    "password": "12345678"
}
```

#### JSON Retornado

```json
{
    "id": 6,
    "name": "Luiz",
    "login": "email@gmail.com",
    "password": "$2a$10$Md24RziTiIVuM0vCUynlEekeEgiomfvpv5tw7KL/nCYLrWEusAnle",
    "enabled": true,
    "authorities": [
        {
            "authority": "ROLE_ADMIN"
        }
    ],
    "accountNonLocked": true,
    "accountNonExpired": true,
    "credentialsNonExpired": true,
    "username": "email@gmail.com"
}
```

### Realizar o login

> Rota: http://localhost:8080/api/v1/auth/login

#### Formato do JSON esperado para o login:

```json
{
    "login": "email@gmail.com",
    "password": "12345678"
}
```

#### JSON Retornado (Token JWT)

```json
{
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJBUEkgTGF3dGVjaCIsInN1YiI6Imx1aXpAZ21haWwuY29tIiwiZXhwIjoxNzA2MzA0NTY2fQ.O1l3GuLDn16rKBuU2SqXRnrAdf1g2RVAU0v1OsLzTAA"
}
```

> Obs: A API usa autenticação JWT. Para fazer uma solicitação, você precisa incluir um token JWT válido no cabeçalho `Authorization` da solicitação do tipo OAuth 2.0, no formato `Bearer <token>`.
