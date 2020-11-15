/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Tiago Teixeira
 * Created: 15/11/2020
 */

SELECT
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
FROM enderecos end
inner join cidades cd on cd.id = end.id_cidade