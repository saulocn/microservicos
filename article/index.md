# Iniciando com Microserviços

## Introdução

A arquitetura em microserviços está se tornando cada vez mais difundida nos dias de hoje, ainda que devam ser analizados diversos pontos antes de se adotar esta tecnologia, é importante conhecer diversos modelos, suas vantagens e desvantagens para escolher a mais adeqada para cada caso e este artigo se destina a quem quer dar seus primeiros passos com essa arquitetura.

Dentre as vantagens dessa abordagem temos:

- Uma possibilidade de utilização de diversas tecnologias diferentes.
- Cada parte do sistema pode ser escalado de forma independente, assim como seu desenvolvimento.
- Cada microserviço pode ser entrege de forma independente.
- Como o sistema é dividido em partes menores, cada subsistema se torna menos complexo.

Mas, como dizia Tio Ben: "Com grandes poderes, vêm grandes responsabilidades". Com isso, devemos ter:

- Contratos bem definidos, incluindo tempo de resposta de cada microserviço.
- A responsabilidade de consistência de dados é responsabilidade de cada microserviço.
- Deve-se ter muito cuidado na separação da cada microserviço e separar cada domínio não é algo trivial. Deve-se conhecer muito bem o negócio para realizar essa atividade corretamente.

Ainda sim, é importante salientar que [Martin Fowler indica que devemos considerar inicialmente um monolito](https://martinfowler.com/bliki/MonolithFirst.html), principalmente quando se está iniciando o desenvolvimento de um sistema e não se tem a exata idéia de como e se o negócio irá escalar.

## O Projeto

Para o início de aprendizado com microserviços, vamos entender o projeto que vamos desenvolver.

Nosso projeto consiste em três microserviços utilizando tecnologias variadas que irão se comunicar tanto de forma síncrona como assíncrona.

Os três microserviços que vamos desenvolver são:

1. **Loja** - Um microserviço responsável por receber e administrar pedidos dos nossos usuários e será desenvolvido utilizando o framework SpringBoot com o banco de dados relacional PostgreSQL.
1. **Fornecedor** - Este microserviços será responsável por administrar nosso estoque e prateleira de produtos e será desenvolvido com o framework Quarkus utilizando alguns recursos de Microprofile.
1. **Transportador** - Será um microserviços responsável por receber as ordens de entrega e determinar o tempo que levará para isso. Ele será desenvolvido em NodeJS e utilizará um banco de dados NoSQL MongoDB.


### Comunicação

- A *loja* se comunicará com seu *fornecedor* de maneira síncrona pois precisará saber se existe determinado produto em estoque para o pedido.
- A *loja* se comunicará de maneira assíncrona com o *fornecedor*, pois a solicitação do frete não precisa ser realizada naquele momento. Essa comunicação será realizada através de filas que ficarão no [Apache Pulsar](http://pulsar.apache.org/).


## Let's code

### Fornecedor

Vamos começar o desenvolvimento de nosso fornecedor que será responsável por gerenciar nossos produtos e estoque.

Iniciamos utilizando a ferramenta de inicialização de projetos [neste link](https://code.quarkus.io/). Através dele podemos escolher as dependências e e ele cria um projeto para facilitar o desenvolvimento.

As dependências que utilizaremos neste projeto são:

- `quarkus-resteasy` - Responsável por facilitar o desenvolvimento de nossa API Rest
- `quarkus-jackson` - Responsável por fazer a conversão de nosso objetos para JSON e vice e versa
- `quarkus-resteasy-jackson` - Responsável para facilitar o mapeamento dos parâmetros recebidos e enviados pelo API para JSON
- `quarkus-hibernate-orm` - Responsável para facilitar nossa camada de acesso aos dados
- `quarkus-config-yaml` - Responsável por nos ajudar a configurar a aplicação utilizando YAML
- `quarkus-jdbc-postgresql` - Responsável por realizar a conexão com nosso banco de dados PostgreSQL



### Transportador

Vamos iniciar o desenvolvimento com o nosso microserviço responsável pela gestão de transportes dos produtos.

Ele deve receber os dados do pedido através de mensagens em uma fila `X`, registrar no banco de dados e, quando o transportador iniciar o freta, devolver através de outra fila para que a loja possa atualizar seu estado em sua base de dados.
Quando o frete for finalizado, devemos lançar outra mensagem para a loja finalizar o pedido.

## Referências

[Is Modular Monolithic Software Architecture Really Dead? -
Md Kamaruzzaman](https://towardsdatascience.com/looking-beyond-the-hype-is-modular-monolithic-software-architecture-really-dead-e386191610f8)
