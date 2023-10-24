--1) Buscar a quantidade de médicos por especialidade, ordenados por especialidade.

SELECT especialidade, COUNT(*) AS QtyMedicos
  FROM [MEDICOS].[dbo].[Medicos]
  GROUP BY especialidade
  ORDER BY especialidade;

--2) No exercício 2, buscar apenas aquelas especialidades com mais de 1 médico atendente.

SELECT especialidade, COUNT(*) AS QtyMedicos
  FROM [MEDICOS].[dbo].[Medicos]
  GROUP BY especialidade
  HAVING (COUNT(*) > 1)
  ORDER BY especialidade;

--3) Buscar a maior idade de médicos por especialidade.
--Nesse caso fizemos o select de uma tabela para ver a idade máxima agrupada por especialidade. Depois fizemos um join para juntar a tabela médicos e esse select
--E ver quem tinha a idade igual ao max_idade que foi obtido na consulta aninhada.

SELECT m1.nome, m1.especialidade, m2.max_idade
FROM medicos m1
INNER JOIN (SELECT especialidade, MAX(idade) AS max_idade FROM medicos GROUP BY especialidade) m2 
ON m1.especialidade = m2.especialidade AND m1.idade = m2.max_idade;

--4) Buscar média de salário dos funcionários por cidade

SELECT cidade, AVG(salario) as SalarioMedio
	FROM [MEDICOS].[dbo].[Funcionarios]
	GROUP BY cidade

--5) Apresentar a quantidade de consultas por médicos, listando o código do médico e o total de consultas agendadas

SELECT t1.nome, t1.codm, QtyConsultasAgendadas
FROM [MEDICOS].[dbo].[Medicos] t1
INNER JOIN(SELECT codm, count(*) as QtyConsultasAgendadas FROM [MEDICOS].[dbo].[Consultas] GROUP BY codm) t2 ON t1.codm = t2.codm
ORDER BY QtyConsultasAgendadas DESC

--6)Apresentar os andares que tem capacidade total de leitos superior a 100 

SELECT andar, SUM(capacidade) QtyLeitos
  FROM [MEDICOS].[dbo].[Ambulatorio]
  GROUP BY andar
  HAVING (SUM(capacidade) > 100)


