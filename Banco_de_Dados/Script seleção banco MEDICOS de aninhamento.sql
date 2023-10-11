-- Quantos médicos no hospital?
SELECT COUNT(*) as 'Quantidade Medicos' FROM Medicos

--Qual a idade do medico mais velho
SELECT MAX(idade) as 'Maior Idade' from Medicos

--Qual a idade do medico mais novo
SELECT MIN(idade) as 'Menor Idade' from Medicos

--Qual o oftamologista mais velho
SELECT MAX(idade) as 'Oftalmo Mais Velho' from Medicos
WHERE especialidade = 'oftalmologia'

--Qual o nome do médico mais velho
SELECT nome, idade
FROM medicos
WHERE idade = (SELECT MAX(idade) from Medicos)

--Qual o nome do médico mais velho
SELECT nome, idade
FROM medicos
WHERE idade = (SELECT MAX(idade) FROM Medicos WHERE especialidade = 'Pediatria')
	  AND especialidade = 'Pediatria' --Tem que colocar a condição de ser pediatra dentro da consulta de idade máxima entre os pediatras como fora para especificar que você quer ver só os pediatras.