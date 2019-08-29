# DACAE-CO

Adiconar Maven e executar ECoApplication.java para iniciar o projeto.
É possível testar acessando a página http://localhost:8080/swagger-ui.html#/.

Especificação do projeto: https://docs.google.com/document/d/e/2PACX-1vRMP1dmmr6DpXQECabYiR_pboa4P_XiXEywRX_wntWL0ego4KHlH25_Vsv0HB0_Io4nXn4lNI0eEaXU/pub#h.hwxmy83m4n3k

O sistema é baseado na arquitetura Controller-Service-Repository. Pessoas, Deputados, Partidos, Propostas, Votações e Tramitações são representadas como entidades no sistema. Deputado herda o tipo Pessoa, e, PL, PLP e PEC herdam o tipo Proposta. Uma Tramitação é formada por uma composição de votações.
