-- Quantos m�dicos no hospital?
SELECT COUNT(*) as 'Quantidade Medicos' FROM Medicos

--Qual a idade do medico mais velho
SELECT MAX(idade) as 'Maior Idade' from Medicos

--Qual a idade do medico mais novo
SELECT MIN(idade) as 'Menor Idade' from Medicos

--Qual o oftamologista mais velho
SELECT MAX(idade) as 'Oftalmo Mais Velho' from Medicos
WHERE especialidade = 'oftalmologia'

--Qual o nome do m�dico mais velho
SELECT nome, idade
FROM medicos
WHERE idade = (SELECT MAX(idade) from Medicos)

--Qual o nome do m�dico mais velho
SELECT nome, idade
FROM medicos
WHERE idade = (SELECT MAX(idade) FROM Medicos WHERE especialidade = 'Pediatria')
	  AND especialidade = 'Pediatria' --Tem que colocar a condi��o de ser pediatra dentro da consulta de idade m�xima entre os pediatras como fora para especificar que voc� quer ver s� os pediatras.