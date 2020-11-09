
/**
 * Author:  Tiago Teixeira
 * Created: 08/11/2020
 */

/*Usadono relatório de cilentes*/
use locadora;

Select
cli.id, 
case when cli.nome = '' then cli.razaosocial
	 when cli.razaosocial = '' then cli.nome
	 else '' END AS NOME,
case when cli.cpf = '' then cli.cnpj
	 when cli.cnpj = '' then cli.cpf
     else 0 end as CPF_CNPJ,
case when cli.ie = '' then cli.rg
	 when cli.rg = '' then cli.ie
     else 0 end as RG_IE,
cli.datanascimento, 
cli.telefone, 
cli.celular, 
cli.cnh,
cli.observacoes,
cli.email, 
cb.nome as colaboradorCadastro,
case when cli.inativo = 0 then 'LIBERADO'
     when cli.inativo = 1 then 'BLOQUEADO'
     else 0 end as inativo	
from Clientes cli
inner join colaboradores cb on cli.id_colaborador = cb.id 

where cli.id = 5 /*passa o ID do cliente, idependente de ser pessoa juridica ou fisica ele agrupa os dados*/
