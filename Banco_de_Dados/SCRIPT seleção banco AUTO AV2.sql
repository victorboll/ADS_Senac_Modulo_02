--1)	Listar consumidores cadastrados (todos os campos)
SELECT *  FROM [AV2].[dbo].[CONSUMIDORES]

--2)	Listar fabricantes de automóveis e seus respectivos países
SELECT DISTINCT Fabricante, Pais FROM [AV2].[dbo].[AUTOMOVEIS]

--3)	Quais são os carros (Fabricante, modelo, Ano) que custam mais do que R$ 70.000?
SELECT [Fabricante], [Modelo], [Ano] FROM [AV2].[dbo].[AUTOMOVEIS]
WHERE[Preco_tabela] > 70000

--4)	Listar a quantidade de diferentes automóveis existentes (dica: use a tabela AUTOMOVEIS)
SELECT COUNT(DISTINCT [Modelo]) as 'QtyAutomoveisExistentes' FROM [AV2].[dbo].[AUTOMOVEIS]

SELECT Modelo, COUNT(*) as 'QtyAutomoveis' FROM [AV2].[dbo].[AUTOMOVEIS] GROUP BY Modelo

--5)	Qual é o valor (preço de tabela) de automóvel mais caro a venda?
SELECT MAX([Preco_tabela]) as 'PrecoTabelaAutomovelMaisCaro' FROM [AV2].[dbo].[AUTOMOVEIS]

--6)	Qual o modelo de automóvel mais caro a venda? (dica: consulta aninhadas)
SELECT Modelo FROM AUTOMOVEIS WHERE Preco_tabela = (SELECT MAX([Preco_tabela]) FROM [AV2].[dbo].[AUTOMOVEIS])

--7)	Listar fabricante e o valor de automóvel mais caro a venda de cada fabricante. (dica: agrupar por fabricantes)
SELECT Fabricante, MAX(Preco_tabela) as 'ValorAutomovelMaisCaroAVenda' FROM  AUTOMOVEIS GROUP BY Fabricante 


--8)	Apresentar a quantidade de automóveis na garagem de cada Revendedora (CNPJ) (dica: na tabela GARAGEM listar quantidade agrupada por CNPJ)
SELECT [CNPJ], SUM(Quantidade) as 'QtyAutomoveisGaragem' FROM [AV2].[dbo].[GARAGENS] GROUP BY CNPJ


--9)	Apresentar a quantidade de Negócios realizados, e o total de dinheiro movimentado nas vendas
SELECT COUNT(*) as 'QtyNegociosRealizados', SUM(Preco) as 'TotalDinheiroMovimentado' FROM [AV2].[dbo].[NEGOCIOS]


--10)	Apresentar a quantidade de Negócios por CNPJ, listando o CNPJ da revendedora, quantidade total de vendas e o total de dinheiro movimentado por CNPJ
SELECT CNPJ, COUNT(*) as 'QtyTotalVendas', SUM(Preco) as 'TotalDinheiroMovimentado' FROM [AV2].[dbo].[NEGOCIOS] GROUP BY CNPJ

--11)	Apresentar a quantidade de Negócios por CNPJ, listando o CNPJ da revendedora, e o total de vendas por CNPJ, considerando apenas vendas superiores a 3 unidades 
SELECT CNPJ, COUNT(*) as 'QtyTotalVendas' FROM [AV2].[dbo].[NEGOCIOS] GROUP BY CNPJ HAVING COUNT(*) > 3

--12)	Listar os consumidores e seus negócios realizados, apresentando nome do consumidor, CPF, CODIGO do veículo adquirido e preço pago
SELECT c.Nome, c.CPF, n.codigo, n.Preco FROM CONSUMIDORES c INNER JOIN NEGOCIOS n ON c.CPF = n.CPF

--13)	Listar os consumidores e seus negócios realizados, apresentando nome do consumidor, CPF, fabricante e modelo do veículo adquirido e preço pago
SELECT c.Nome, c.CPF, a.Fabricante, a.Modelo, n.Preco 
FROM CONSUMIDORES c INNER JOIN NEGOCIOS n ON c.CPF = n.CPF INNER JOIN AUTOMOVEIS a ON a.Codigo = n.Codigo

--14)	Listar os TODOS os consumidores (incluindo aqueles que não fizeram negócios) e os negócios realizados, apresentando nome do consumidor, CPF, CODIGO do veículo adquirido e preço pago
SELECT c.Nome, c.CPF, n.codigo, n.Preco FROM CONSUMIDORES c LEFT OUTER JOIN NEGOCIOS n ON c.CPF = n.CPF

