# API LANCHONETE

Projeto para o desafio técnico da Salutem, vaga de Desenvolvedor Full Stack Júnior

É um sistema para gerenciar pedidos de uma lanchonete: cadastro de bebidas, ingredientes, hambúrgueres e lançamento de pedidos

## TECNOLOGIAS

- Java 17+
- Spring Boot 4.1.1
- Spring Data JPA
- PostgreSQL
- Maven

## O QUE VOCÊ PRECISA TER INSTALADO

- JDK 17 ou mais novo
- PostgreSQL rodando na máquina

Não é necessário instalar o Maven, o produto já vem com o `mvnw`/`mvnw.cmd`

## COMO RODAR O BACK-END

1 - Clonar o repositório:

git clone https://github.com/Luiszapataa/APILanchonete.git

2 - Criar um banco de dados com o nome:`lanchonete_db`. Porta padrão (5432)

3 - Antes de rodar, é necessário configurar a senha do banco como variável de ambiente `DB_PASSWORD`, com a senha do seu PostgreSQL.

4 - Entre na pasta do projeto e roda: ./mvnw spring-boot:run
    No Windows, utilize: mvnw.cmd spring-boot:run

5 - A API sobe em http://localhost:8080

As tabelas são criadas automaticamente pelo Hibernate na primeira vez que roda (configurei o ddl-auto=update).

## O QUE NÃO FOI IMPLEMENTADO

- O requisito 3.4 (Adicionais no pedido)
- O requisito 3.5 (Cálculo automático de total)

- Não foi implementado por causa do prazo, priorizei deixar os requisitos obrigatórios muito bem feitos.

## RODAR O FRONT-END

1 - Entre na pasta do front-end: cd frontend

2 - Instale as dependências: npm install

3 - Rodar a aplicação: ng serve

4 - Acessar no navegador: http://localhost:4200

OBS: O BACK-END PRECISA ESTAR RODANDO AO MESMO TEMPO (PORTA 8080), SENÃO AS TELAS NÃO VÃO CONSEGUIR BUSCAR OS DADOS

