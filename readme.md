# ERP - JavaDesk

Este projeto consiste em um ERP Java completo incluindo emissão de NF-e com certificado A1.
Conta com uma interface gráfica simples e conexão com um banco de dados MySQL. Em faze de construção com inicio pelas telas de cadastro.
O banco de dados também sera construido passo a passo em um link a parte.

## Funcionalidades 1.0

- Cadastro de clientes com os seguintes campos:
  - Nome
  - Endereço
  - Email
  - Telefone
  - CNPJ
- Conexão com banco de dados MySQL para armazenamento dos dados
- Interface gráfica simples e intuitiva
- Opções de salvar e cancelar cadastros
- Menu com opções adicionais, incluindo impressão e informações sobre o aplicativo

## Tecnologias Utilizadas

- Java: Para a lógica principal do programa e interface gráfica
- Swing: Biblioteca para a interface gráfica
- JDBC: Para conexão com o banco de dados MySQL
- MySQL: Banco de dados para armazenamento das informações dos clientes

## Configuração do Projeto

Para executar este projeto, você precisará ter o Java e o MySQL instalados em sua máquina. 
Assegure-se de que o banco de dados `TWStremaingX` esteja configurado no MySQL e a tabela `ClienteDBO` esteja criada conforme as especificações do projeto.

### Estrutura da Tabela `ClienteDBO`

A tabela `ClienteDBO` deve ter as seguintes colunas:
- `nome` VARCHAR
- `endereco` VARCHAR
- `email` VARCHAR
- `telefone` VARCHAR
- `cnpj` VARCHAR

### Configuração do Banco de Dados

Certifique-se de que as credenciais do banco de dados no arquivo de conexão estejam configuradas para:

- Usuário: `TWStesteAdm`
- Senha: `ADM123`

## Executando o Projeto

Para executar o projeto, siga estas etapas:

1. Clone o repositório ou faça o download do código-fonte.
2. Abra o projeto em seu ambiente de desenvolvimento Java.
3. Execute o arquivo `ClienteForm.java`.

## Contribuições

Contribuições são sempre bem-vindas. Se você tem sugestões para melhorar este projeto, sinta-se à vontade para abrir um pull request ou uma issue.

## Autor

- Wellington Neves

## Versão

- Versão 1.0
