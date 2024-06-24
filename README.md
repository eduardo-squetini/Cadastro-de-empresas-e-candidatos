# API de Cadastro de Empresas e Candidatos

## Sobre o Projeto
Este repositório é uma API que realiza o cadastro de empresas e seus respectivos candidatos através de requisições e armazena suas informações no banco de dados. Além disso, o sistema conta com APIs públicas que geram informações ainda mais detalhadas das instituições e indivíduos, como o CNPJ e CEP.

## Funcionalidades
- **Cadastro de Empresas**: Realiza o cadastro de empresas e armazena as informações no banco de dados.
- **Cadastro de Candidatos**: Permite o cadastro de candidatos associados a empresas.
- **Consultas Externas**: Integração com APIs públicas para obter informações detalhadas de empresas e endereços.
- **Armazenamento de Dados**: Utilização de banco de dados SQL para armazenamento eficiente das informações.

## Tecnologias Utilizadas
- Java
- Spring Boot
- SQL

## Sites das APIs Públicas Utilizadas
- **Brasil API**:
  - **API de Consulta de CNPJ**: Utilizada para obter informações detalhadas de empresas através do CNPJ. Disponível em: [Brasil API - CNPJ](https://brasilapi.com.br/docs/#tag/cnpj).
- **ViaCEP**:
  - **API de Consulta de CEP**: Utilizada para buscar informações de endereço através do CEP. Disponível em: [ViaCEP - CEP](https://viacep.com.br/docs).
