# DACAE-CO

Adiconar Maven e executar ECoApplication.java para iniciar o projeto.
É possível testar acessando a página http://localhost:8080/swagger-ui.html#/.

Especificação do projeto: https://docs.google.com/document/d/e/2PACX-1vRMP1dmmr6DpXQECabYiR_pboa4P_XiXEywRX_wntWL0ego4KHlH25_Vsv0HB0_Io4nXn4lNI0eEaXU/pub#h.hwxmy83m4n3k

O sistema é baseado na arquitetura Controller-Service-Repository. Pessoas, Deputados, Partidos, Propostas, Votações e Tramitações são representadas como entidades no sistema. Deputado herda o tipo Pessoa, e, PL, PLP e PEC herdam o tipo Proposta. Uma Tramitação é formada por uma composição de votações.

Diagrama ER

![Diagrama ER](https://github.com/ViniciusMSoares/DACAE-CO/blob/master/daca.png)

### Como rodar:

#### Requisitos:

* Java 8
* Git
* Maven

**1- Clone a aplicação**

```bash
git clone https://github.com/ViniciusMSoares/DACAE-CO.git
```

**2- Execute a aplicação com o maven na pasta criada**

```bash
cd DACAE-CO
mvn spring-boot:run
```

#### Por padrão está sendo utilizado o H2 database, você pode configurar seu banco de dados em application.properties

## Authentication
A autenticação do usuário é feita pelo POST '/login', passando como corpo o JSON:
{
  "dni": "123456789-0",
  "senha": "senha"
}

É gerado um token JWT para o usuário. O token é solicitado no header de algumas requisições, e  utilizado para identificar o usuário logado.

## Reactive

A aplicação apresenta uma estruturação reactive simples, composta por um handler, um router e um client.

A classe router gerencia a rota e retorna o valor provido pela respectiva classe handler para o client, que consome o serviço.

## Kubernetes

Foi utilizado o Kubernetes Engine, do Google Cloud Platform, para fazer uma estruturação em Kubernetes da aplicação.

O Kubernetes acessa uma imagem da aplicação, criada pelo Docker, para o deploy. A aplicação foi escalada com 3 pods, que podem receber tráfego após criar um service que acessa um Load balancer através dos pods.

É possível acessar e testar o cluster em: http://35.239.223.114:8080/swagger-ui.html.

