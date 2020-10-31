
/**
 * Função:  Criação da Base de Dados
 * Authors:  Tiago Teixeira / André Luiz / Bernado Souto
 * Created: 21/10/2020
 */

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
PRIMARY KEY (id),
UNIQUE KEY cpf_UNIQUE (Cpf),
KEY Cpf_Cpf_funCadastro_idx (Cpf_funCadastro),
CONSTRAINT Cpf_Cpf_funCadastro FOREIGN KEY (Cpf_funCadastro) REFERENCES Colaboradores (Cpf)

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
Renavam int(30) NOT NULL,
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
UNIQUE KEY placa_UNIQUE (Placa),
FOREIGN KEY fk_id_colaborador(id_colaborador) references Colaboradores(id)
);

/*Criando tabela Cidades*/
CREATE TABLE IF NOT EXISTS Cidades (
id int NOT NULL,
NomeCidade varchar(200),
SiglaEstado varchar(2),
Estado varchar(200),
Pais varchar(6),

PRIMARY KEY(id)
);

/*Criando tabela Endereços*/
CREATE TABLE IF NOT EXISTS Enderecos(
id int NOT NULL,
Rua varchar(200) NOT NULL,
Numero varchar(5) NOT NULL,
Bairro varchar(100) NOT NULL,
id_cidade int NOT NULL,

PRIMARY KEY(id),
FOREIGN KEY fk_id_cidade(id_cidade) references Cidades(id)
)

/*Criando tabela Clientes*/
CREATE TABLE IF NOT EXISTS Clientes(
id int NOT NULL,
Nome varchar(200),
Cpf varchar(11),
RazaoSocial(200),
Cnpj(14),
IE varchar(20),
RG varchar(20),
DataNascimento date,
Telefone varchar(12) NOT NULL,
Celular varchar(12) NOT NULL,
CNH varchar(20) NOT NULL,
id_endereco int NOT NULL,
id_colaborador int NOT NULL,
Inativo int(1) NOT NULL,

PRIMARY KEY (id),
UNIQUE KEY cpf_Unique(Cpf), cnpj_Unique(Cnpj), ie_Unique(IE), rg_Unique(RG), cnh_Unique(CNH)
FOREIGN KEY fk_id_endereco(id_endereco) references Endereco(id),
FOREIGN KEY fk_id_colaborador(id_colaborador) references Colaboradores(id)
)
