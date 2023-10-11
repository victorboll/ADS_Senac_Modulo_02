SELECT Nome, CPF, especialidade 
FROM Medicos
WHERE especialidade = 'Oftamologia' OR
	  especialidade = 'Pediatria' 
	  --especialidade in ('Oftalmologia', 'Pediatria')


SELECT nome, salario, salario*1.1 as Novosalario
FROM Funcionarios


SELECT DISTINCT especialidade
FROM Medicos


SELECT especialidade, COUNT(especialidade) as QuantEspecialidades --Voc� tamb�m poderia colocar COUNT(*), colocasse o nome da coluna se tiver NULL nela
FROM Medicos
GROUP BY especialidade;


SELECT p.codp, c.codp, nome, data
FROM Consultas c, Pacientes p
WHERE c.codp = p.codp

--Dado o esquema acima, no seu ambiente SQL execute as seguintes consultas:

--Liste nome e especialidade dos m�dicos que tem o nome �Pedro� 
SELECT nome, especialidade
FROM Medicos
WHERE nome = 'Pedro'

--Liste o nome e especialidade dos m�dicos do hospital com idade entre 30 e 50 anos
SELECT nome, especialidade, idade
FROM Medicos
WHERE idade between 30 and 50
order by idade

--Liste o nome m�dicos Ortopedistas, cardiologistas e Pediatras (use clausula IN)
SELECT nome, especialidade
FROM Medicos
WHERE especialidade IN ('Ortopedia', 'Cardiologia', 'Pediatria')

--Liste todos os registros da tabela Medicos
SELECT *
FROM Medicos

--Liste o nome e especialidade de todos os m�dicos do hospital
SELECT nome, especialidade
FROM Medicos

--Liste o nome e idade dos m�dicos com mais de 55 anos
SELECT nome, idade
FROM Medicos
WHERE idade > 55

--Liste o nome e idade dos m�dicos Ortopedistas com mais de 55 anos
SELECT nome, idade, especialidade
FROM Medicos
WHERE idade > 55 and especialidade = 'Ortopedia'

--Liste as especialidades dispon�veis no hospital
SELECT DISTINCT especialidade
FROM Medicos