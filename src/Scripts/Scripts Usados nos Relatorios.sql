
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
cb.nome as colaboradorCadastro,
case when cli.inativo = 0 then 'ATIVO'
	when cli.inativo = 1 then 'BLOQUEADO'
    else 0 end as inativo,
end.id,
end.rua,
end.numero,
end.bairro,
cd.nomecidade,
cd.estado,
cd.pais,
end.cep,
end.tipoendereco,
end.referencia  
from Clientes cli
inner join colaboradores cb on cli.id_colaborador = cb.id 
inner join enderecos end on end.id_cliente = cli.id
inner join cidades cd on cd.id = end.id_cidade
where cli.id = 9 
order by end.id

/**
 * Author:  Tiago Teixeira
 * Created: 14/11/2020
 */

/*Usadono relatório de Veiculos*/

SELECT c.id,
	c.`Nome`,
	c.`Marca`,
	c.`Modelo`,
	c.`Classe`,
	c.`TipoVeiculo`,
	c.`Cor`,
	c.`Placa`,
	c.`Renavam`,
	c.`ObsEstado`,
	c.`DataCompra`,
	c.`AnoModelo`,
	c.`AnoFabricacao`,
	c.`Chassi`,
	c.`KmRodados`,
	c.`ValorMercado`,
	c.`ValorSeguro`,
	c.`ValorKmRd`,
	c.`ValorDiariaLoc`,
    CASE when c.`Status` = 0 then 'LIBERADO'
         when c.Status = 1 then  'ALUGADO'
         ELSE  0 END as Status,
	CASE when c.`Inativo` = 0 then 'ATIVO'
		 when c.Inativo = 1 then 'INATIVO'
         ELSE 0 END as Inativo,
	cb.`Nome` AS Colaborador
FROM locadora.carros c
	inner join locadora.colaboradores cb ON 
	 cb.id = c.id_colaborador
	where c.Placa = $P{Placa}
	order by Nome

/**
 * Author:  Tiago Teixeira
 * Created: 14/11/2020
 */

/*Usadono relatório de Colaboradores*/

select 
id, 
nome, 
nomelogin, 
cpf, 
cpf_funcadastro, 
senha, 
telefone  
from colaboradores  
where Cpf = $P{Cpf} 
order by nome