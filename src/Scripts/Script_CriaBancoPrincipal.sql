
/**
 * Função:  Criação da Base de Dados
 * Authors:  Tiago Teixeira / André Luiz / Bernado Souto
 * Created: 21/10/2020
 */

/*PARA CRIAR AS FKs USE O SEGUNDO SCRIPT "Script_CriaFk_BancoPrincipal.sql*/

/*Comando vai criar a base de dados caso não exista*/
CREATE DATABASE IF NOT EXISTS LOCADORA;

USE LOCADORA;


/*Comando para criar a tabela Colaboradores*/

CREATE TABLE IF NOT EXISTS Colaboradores (
id int NOT NULL AUTO_INCREMENT,
Nome varchar(250) NOT NULL,
Cpf varchar(14) NOT NULL,
NomeLogin varchar(20) NOT NULL,
Cpf_funCadastro varchar(14) DEFAULT NULL,
Senha varchar(20) NOT NULL,
Telefone varchar(20) NOT NULL,
Nivel varchar(20) NOT NULL,
PRIMARY KEY (id),
UNIQUE KEY cpf_UNIQUE (Cpf)


);

/*Nessa tabela a coluna Id fica como chave primaria 
  e auto incremento, e a coluna Cpf fica como chave
  unica evitando assim um CPF duplicado nos registros*/

/*Criando tabela Carros*/

CREATE TABLE IF NOT EXISTS Carros (
id int NOT NULL AUTO_INCREMENT,
Nome varchar(50) NOT NULL,
Marca varchar(50) NOT NULL,
Modelo varchar(50) NOT NULL,
Classe varchar(50) NOT NULL,
TipoVeiculo varchar(50) NOT NULL,
Cor varchar(50) NOT NULL,
Placa varchar(7) NOT NULL,
Renavam varchar(12) NOT NULL,
ObsEstado varchar(1000),
DataCompra Date NOT NULL,
AnoModelo int(4) NOT NULL,
AnoFabricacao int(4) NOT NULL,
Chassi varchar(50) NOT NULL,
KmRodados int(9) NOT NULL,
ValorMercado FLOAT NOT NULL,
ValorSeguro FLOAT NOT NULL,
ValorKmRd FLOAT NOT NULL,
ValorDiariaLoc FLOAT NOT NULL,
Status int(1) NOT NULL,
Inativo int(1) NOT NULL,
id_colaborador int NOT NULL,

PRIMARY KEY (id),
UNIQUE KEY placa_UNIQUE (Placa)

);

/*Criando tabela Cidades*/
CREATE TABLE IF NOT EXISTS Cidades (
id int NOT NULL AUTO_INCREMENT,
NomeCidade varchar(200) NOT NULL,
SiglaEstado varchar(2) NOT NULL,
Estado varchar(200) NOT NULL,
Pais varchar(6) NOT NULL,
PRIMARY KEY(id)

);

/*Criando a tabela clientes */

/*Nessa tabela a coluna Id fica como chave primaria 
  e auto incremento, e a coluna Cpf e CnPJ fica como chave
  unica evitando assim um CPF ou CNPJ duplicado nos registros*/

CREATE TABLE IF NOT EXISTS Clientes (
  Id INT NOT NULL AUTO_INCREMENT,
  Nome VARCHAR(200) NULL,
  Cpf VARCHAR(11) NULL,
  RazaoSocial VARCHAR(200) NULL,
  Cnpj VARCHAR(14) NULL,
  IE VARCHAR(20) NULL,
  RG VARCHAR(20) NULL,
  DataNascimento DATE  NULL,
  Telefone VARCHAR(13) NOT NULL,
  Celular VARCHAR(14) DEFAULT NULL,
  Email VARCHAR(250) NOT NULL,
  Observacoes VARCHAR(1000) DEFAULT NULL,
  CNH VARCHAR(20)  NULL,
  id_colaborador INT NOT NULL,
  Inativo INT NOT NULL,
   
  UNIQUE KEY Cpf_Cnpj (Cpf,Cnpj),
  PRIMARY KEY (id)
  
);


/*Criando a tabela Endereços*/
CREATE TABLE IF NOT EXISTS Enderecos(
id int NOT NULL AUTO_INCREMENT,
Rua varchar(200) NOT NULL,
Numero varchar(5) NOT NULL,
Bairro varchar(100) NOT NULL,
Cep varchar(10) NOT NULL,
TipoEndereco varchar(20) NOT NULL,
Referencia varchar(1000) DEFAULT NULL,
id_cidade int NOT NULL,
id_cliente int NOT NULL,
PRIMARY KEY(id)
);


/*criando tabela contrato*/



CREATE TABLE IF NOT EXISTS Contratos (
  id INT NOT NULL AUTO_INCREMENT,
  id_cliente INT NOT NULL,
  id_carro INT NOT NULL,
  id_colaborador INT NOT NULL,
  Observacoes VARCHAR(1000) NULL,
  QuantidadeDiarias INT(3) NULL,
  QuantidadeKmRet INT(9) NULL,
  QuantidadeKmUtil INT(9) NULL,
  ValorExtra FLOAT NULL,
  ValorTotal FLOAT NULL,
  TipoLocacao VARCHAR(15) NOT NULL,
  DataSaida DATE NOT NULL,
  DataChegada DATE NULL,
  DataContrato DATE NOT NULL,
  Status VARCHAR(15) NOT NULL,
  PRIMARY KEY (id)
  
);

