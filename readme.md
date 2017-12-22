# Rest Spring Boot Java Project

Tecnlogias utilizadas:

- Eclipse Java EE IDE for Web Developers - Version: Oxygen.2 Release (4.7.2);
- Plug in Spring Tools ( https://marketplace.eclipse.org/content/spring-tools-aka-spring-ide-and-spring-tool-suite )
- Postman App(https://www.getpostman.com/)


## Setup

Importe o projeto como Maven -> Existing Maven Project -> selecione o projeto
Clicar com botão direiro -> Run as Spring Boot App 
Use as urls para teste de Payload 1 e Payload 2

Para enviar o email, coloque um email e senha validos no application.properties

Para enviar o POST, utilize o app Postman com a url http://localhost:8081/maladireta 
e o json de acordo com os dados dos alunos;

- O sistema retornará o numero de emails enviados, portanto se quiser testar os emails gerados sem colocar dados validos para a autenticação, troque o retorno de SendEmail.send para true;


Urls para teste:

-Payload 1:
http://localhost:8081/alunos/

-Payload 2:
http://localhost:8081/alunos/11111111112/notas

-Mala Direta
http://localhost:8081/maladireta

Exemplo xml Mala Direta:


[{
"id": 1,
"nome": "Joao",
"endereco": "Rua 1",
"cep": "11111-01",
"mensagem": "Texto referente a mensagem para o aluno 1"
},
{
"id": 8,
"nome": "Joao",
"endereco": "Rua 8",
"cep": "11111-08",
"mensagem": "Texto referente a mensagem para o aluno 8"
}
]





