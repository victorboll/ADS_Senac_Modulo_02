--1)	Listar consumidores cadastrados (todos os campos)
SELECT *  FROM [AV2].[dbo].[CONSUMIDORES]

--2)	Listar fabricantes de autom�veis e seus respectivos pa�ses
SELECT DISTINCT Fabricante, Pais FROM [AV2].[dbo].[AUTOMOVEIS]

--3)	Quais s�o os carros (Fabricante, modelo, Ano) que custam mais do que R$ 70.000?
SELECT [Fabricante], [Modelo], [Ano] FROM [AV2].[dbo].[AUTOMOVEIS]
WHERE[Preco_tabela] > 70000

--4)	Listar a quantidade de diferentes autom�veis existentes (dica: use a tabela AUTOMOVEIS)
SELECT COUNT(DISTINCT [Modelo]) as 'QtyAutomoveisExistentes' FROM [AV2].[dbo].[AUTOMOVEIS]

SELECT Modelo, COUNT(*) as 'QtyAutomoveis' FROM [AV2].[dbo].[AUTOMOVEIS] GROUP BY Modelo

--5)	Qual � o valor (pre�o de tabela) de autom�vel mais caro a venda?
SELECT MAX([Preco_tabela]) as 'PrecoTabelaAutomovelMaisCaro' FROM [AV2].[dbo].[AUTOMOVEIS]

--6)	Qual o modelo de autom�vel mais caro a venda? (dica: consulta aninhadas)
SELECT Modelo FROM AUTOMOVEIS WHERE Preco_tabela = (SELECT MAX([Preco_tabela]) FROM [AV2].[dbo].[AUTOMOVEIS])

--7)	Listar fabricante e o valor de autom�vel mais caro a venda de cada fabricante. (dica: agrupar por fabricantes)
SELECT Fabricante, MAX(Preco_tabela) as 'ValorAutomovelMaisCaroAVenda' FROM  AUTOMOVEIS GROUP BY Fabricante 


--8)	Apresentar a quantidade de autom�veis na garagem de cada Revendedora (CNPJ) (dica: na tabela GARAGEM listar quantidade agrupada por CNPJ)
SELECT [CNPJ], SUM(Quantidade) as 'QtyAutomoveisGaragem' FROM [AV2].[dbo].[GARAGENS] GROUP BY CNPJ


--9)	Apresentar a quantidade de Neg�cios realizados, e o total de dinheiro movimentado nas vendas
SELECT COUNT(*) as 'QtyNegociosRealizados', SUM(Preco) as 'TotalDinheiroMovimentado' FROM [AV2].[dbo].[NEGOCIOS]


--10)	Apresentar a quantidade de Neg�cios por CNPJ, listando o CNPJ da revendedora, quantidade total de vendas e o total de dinheiro movimentado por CNPJ
SELECT CNPJ, COUNT(*) as 'QtyTotalVendas', SUM(Preco) as 'TotalDinheiroMovimentado' FROM [AV2].[dbo].[NEGOCIOS] GROUP BY CNPJ

--11)	Apresentar a quantidade de Neg�cios por CNPJ, listando o CNPJ da revendedora, e o total de vendas por CNPJ, considerando apenas vendas superiores a 3 unidades 
SELECT CNPJ, COUNT(*) as 'QtyTotalVendas' FROM [AV2].[dbo].[NEGOCIOS] GROUP BY CNPJ HAVING COUNT(*) > 3

--12)	Listar os consumidores e seus neg�cios realizados, apresentando nome do consumidor, CPF, CODIGO do ve�culo adquirido e pre�o pago
SELECT c.Nome, c.CPF, n.codigo, n.Preco FROM CONSUMIDORES c INNER JOIN NEGOCIOS n ON c.CPF = n.CPF

--13)	Listar os consumidores e seus neg�cios realizados, apresentando nome do consumidor, CPF, fabricante e modelo do ve�culo adquirido e pre�o pago
SELECT c.Nome, c.CPF, a.Fabricante, a.Modelo, n.Preco 
FROM CONSUMIDORES c INNER JOIN NEGOCIOS n ON c.CPF = n.CPF INNER JOIN AUTOMOVEIS a ON a.Codigo = n.Codigo

--14)	Listar os TODOS os consumidores (incluindo aqueles que n�o fizeram neg�cios) e os neg�cios realizados, apresentando nome do consumidor, CPF, CODIGO do ve�culo adquirido e pre�o pago
SELECT c.Nome, c.CPF, n.codigo, n.Preco FROM CONSUMIDORES c LEFT OUTER JOIN NEGOCIOS n ON c.CPF = n.CPF

