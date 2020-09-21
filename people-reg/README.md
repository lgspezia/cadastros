
## Instalação
Banco de dados mySql, nome : people-reg - jdbc:mysql://localhost:3306/people-reg

Execução do client com o ng serve

para validação do Access-Control-Allow-Origin: utilizar pluginAllow CORS no chrome


Tecnologia e acessos:
1) Back-end > Spring
2) Front-end > Angular
3) Segurança > Senha: java1, password: pas1 
5) Código fonte > endpoint com url dos projetos localhost:8080/source/v1/url

Extras

A API desenvolvida em REST

# Springbootapp - Rodando testes e build

Para rodar e construir a aplicação entre na pasta `people-reg` e execute `./mnvw package`

Na pasta `people-reg` rode os testes com o comando `./mnvw test`

## Deploy

**necessário ter construído (build) a aplicação antes**

Para rodar a aplicação é necessário ter o docker instalado, navegue até o diretório raiz do projeto
e rode o comando abaixo: 

`
 docker-compose up -d
`

O docker irá buildar as imagens referentes ao projeto e será possível acessar pelos endereços:

* Front: localhost:4200 ou 192.168.99.100:4200
* Backend: localhost:8080 ou 192.168.99.100:8080

Para visualizar o swagger da api basta acessar:

`
localhost:8000/swagger-ui 
  ou 
192.168.99.100:8000/swagger-ui
`

## Empacotamento
* Para empacotar o projeto em um JAR executavel

mvn clean package

* Para executar o projeto

java -DBASE_LOG_PATH=".\TRACE" -jar app.jar
