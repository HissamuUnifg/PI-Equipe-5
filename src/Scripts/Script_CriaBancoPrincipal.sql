
/**
 * Função:  Criação da Base de Dados
 * Author:  Tiago Teixeira
 * Created: 21/10/2020
 */

/*Comando vai criar a base de dados caso não exista*/
CREATE DATABASE IF NOT EXISTS LOCADORA;


/*Comando para criar a tabela Colaboradores*/

CREATE TABLE IF NOT EXISTS LOCADORA.Colaboradores (
id int NOT NULL AUTO_INCREMENT,
Nome varchar(250) NOT NULL,
Cpf varchar(14) NOT NULL,
NomeLogin varchar(20) NOT NULL,
Senha varchar(20) NOT NULL,
Telefone varchar(20) NOT NULL,
PRIMARY KEY (id),
UNIQUE KEY cpf_UNIQUE (Cpf)
)

/*Nessa tabela a coluna Id fica como chave primaria 
  e auto incremento, e a coluna Cpf fica como chave
  unica evitando assim um CPF duplicado nos registros*/

