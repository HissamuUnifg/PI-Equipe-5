
/**
 * Função:  Criação da Base de Dados
 * Author:  Tiago Teixeira
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
UNIQUE KEY cpf_UNIQUE (Cpf)
KEY Cpf_Cpf_funCadastro_idx (Cpf_funCadastro),
CONSTRAINT Cpf_Cpf_funCadastro FOREIGN KEY (Cpf_funCadastro) REFERENCES Colaboradores (Cpf)

)

/*Nessa tabela a coluna Id fica como chave primaria 
  e auto incremento, e a coluna Cpf fica como chave
  unica evitando assim um CPF duplicado nos registros*/

