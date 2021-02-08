# Desafio2
FlowTalents Desafio 2: Distribuidora de Estoque

## Requisitos

Para rodar a aplica��o localmente � necess�rio

- [JDK 11](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html)
- [Maven 3](https://maven.apache.org)

## Iniciando a aplica��o

Rodando por padr�o em http://localhost:8080:

```shell
git clone https://github.com/jonathanribs/Desafio2.git
cd target
java -jar desafio2-0.0.1-SNAPSHOT.jar
```

Alternativamente, a api pode ser acessada em:

```shell
https://desafio2-api.herokuapp.com
```

## Funcionalidades

Listar Produtos

```shell
GET: /api/products
```

Incrementar pontua��o (� necess�rio passar como par�metro, o id do produto que ter� a pontua��o incrementada):

```shell
PUT: /api/products?id={id}
```

Sugest�o de produtos (� necess�rio passar no Body nome, nomeDoMercado e texto):

```shell
POST: /api/form
```

Autenticar (recebe pelo Body o "nome" e a "senha" de login e retorna OK se estiver de acordo com usu�rio cadastrado no banco de dados):
Cadastrado para testes -> usuario: admin    senha: admin

```shell
POST: /api/security
```