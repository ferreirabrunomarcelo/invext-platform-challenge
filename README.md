# invext-platform-challenge

O projeto foi desenvolvido com base na arquitetura de microsserviços e utilizando o framework Spring. O projeto contém os seguintes serviços:

1. Eureka-discovery-service: Tem a responsabilidade de realizar a estratégia de descobertas de serviços
2. Gateway: Serve como um portão de entrada para as requisições escondendo os endpoints importantes de outros microsserviços.
3. Request-distribution-service: Esse serviço é chamado quando uma nova solicitação de suporte é criada. Também tem a responsabilidade de encaminhar para os times 4. responsáveis de acordo com o assunto da solicitação.
5. Attendent-service: Esse serviço gerencia todos os atendentes.
6. Card-support-service: Esse serviço recebe todas as solicitações de suporte sobre cartões de crédito e delega para os atendentes de acordo com as regras pré-estabelecidas.
7. Loan-support-service: Esse serviço recebe todas as solicitações de suporte sobre empréstimose delega para os atendentes de acordo com as regras pré-estabelecidas.
8. Other-support-service: Esse serviço recebe todas as solicitações de suporte sobre outros assuntos e delega para os atendentes de acordo com as regras pré-estabelecidas.

# Como executar o projeto

1. Acessar a pasta raiz e executar o comando docker-compose up para subir o Kafka e o Zookeeper.
2. Executar o eureka-discovery-service 
3. Executar o Gateway
4. Executar o request-distribution-service 
5. Executar o attendent-service
6. Executar o card-support-service
7. Executar o loan-support-service
8. Executar o other-support-service

# Possíveis melhorias

1. Adicionar restrições de acesso aos serviços por meio do spring security.
2. Adicionar tratamento de exceções com o Exception Handler.
3. Adicionar banco em memória para otimizar o processamento de atendentes e solicitações de suporte como o redis.
4. Adicionar estratégias de balanceamento de carga para a distribuição de solicitações de suporte.
5. Adicionar uma camada de persistência de dados e manipular com o Spring Data/JPA.
6. Adicionar uma estratégia de resiliência para garantir que os serviços sejam totalmente independentes.
7. Adicionar Spring webflux/reativo para tratar de solicitações assíncronas.
8. Adicionar outras configurações do kafka para suprir cenários mais complexos.

