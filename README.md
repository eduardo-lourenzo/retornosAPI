# CRUD de Produtos
API de retorno de produtos.

## Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas em sua máquina:

- [Java 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) ou superior
- [Maven 3.8+](https://maven.apache.org/download.cgi)
- [Git](https://git-scm.com/)

## Configuração do Projeto

1. Clone o repositório do projeto:
    ```bash
      git clone https://github.com/eduardo-lourenzo/retornosAPI
      cd <PASTA_DO_PROJETO>
    ```
2. Compile as dependências do projeto:
    ```bash
        mvn clean compile
   ```

3. Gerar o JAR da Aplicação 
      ```bash
         mvn spring-boot:run
     ```

4. Executar o JAR Gerado
    ```bash
          java -jar target/retornosAPI.jar
     ```


## EndPoints
Assume-se que o servidor está rodando no endereço localhost na porta 8080. 
Caso o endereço e/ou porta sejam configurados diferentemente, altere os links.

1. id: um número inteiro estritamente positivo
2. name: uma palavra formada por letras maiúsculas/minúsculas, acentuadas ou não.

| Operação                      | Método | URL                                            |
|-------------------------------|--------|------------------------------------------------|
| Criar um produto:             | POST   | http://localhost:8080/api/products             |
| Obter um produto pelo ID:     | GET    | http://localhost:8080/api/products/id/{id}     |
| Obter produtos pelo nome:     | GET    | http://localhost:8080/api/products/name/{name} |
| Obter todos os produtos:      | GET    | http://localhost:8080/api/products             |
| Atualizar um produto pelo ID: | PUT    | http://localhost:8080/api/products/id/{id}     |
| Excluir um produto pelo ID:   | DELETE | http://localhost:8080/api/products/{id}        |

## Exemplos de JSON
JSONs enviados no corpo da mensagem para "Criar" ou "Atualizar" um produto.

```json
{
  "name": "Smartphone Atualizado",
  "description": "Um smartphone atualizado com novos recursos.",
  "price": 2099.99,
  "stockQuantity": 45,
  "category": "Eletrônicos"
}
```
```json
{
  "name": "Notebook Gamer",
  "description": "Notebook com alto desempenho para jogos.",
  "price": 5999.99,
  "stockQuantity": 20,
  "category": "Informática"
}
```
```json
{
  "name": "Cafeteira Premium",
  "description": "Cafeteira elétrica com funções avançadas.",
  "price": 399.99,
  "stockQuantity": 80,
  "category": "Eletrodomésticos"
}
```
```json
{
  "name": "Tênis de Corrida",
  "description": "Tênis leve e confortável para maratonas.",
  "price": 299.99,
  "stockQuantity": 60,
  "category": "Esportes"
}
```
```json
{
  "name": "Livro de Aventura",
  "description": "Um livro emocionante de aventuras épicas.",
  "price": 59.99,
  "stockQuantity": 150,
  "category": "Livros"
}
```
```json

```
```json

```
