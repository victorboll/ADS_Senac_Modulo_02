--listar nome e doença dos funcionários que são pacientes?
SELECT p.nome, p.doença 
FROM Pacientes p INNER JOIN Funcionarios f ON p.CPF = f.CPF



--Listar médicos e suas especialidades que trabalham no domingo?
SELECT m.nome, m.especialidade
FROM Medicos m INNER JOIN Horario h ON m.codm = h.codm
WHERE h.DiaSemana = 1



--Quais especialidades estão disponíveis na 2a feira?
SELECT DISTINCT m.especialidade
FROM Medicos m INNER JOIN Horario h ON m.codm = h.codm
WHERE h.DiaSemana = 2



--Quantos médicos trabalham por dia de semana
SELECT h.DiaSemana, COUNT(DISTINCT m.codm) as 'QtyMedicos'
FROM Medicos m INNER JOIN Horario h ON m.codm = h.codm
GROUP BY h.DiaSemana



--Quais dias da semana o hospital dispõe de Oftalmologistas
SELECT DISTINCT h.DiaSemana
FROM Medicos m INNER JOIN Horario h ON m.codm = h.codm
WHERE m.especialidade = 'Oftalmologia'



--Quantos médicos ortopedistas trabalham por dia de semana
SELECT h.DiaSemana, COUNT(DISTINCT m.codm) as 'QtyOrtopedistas'
FROM Medicos m INNER JOIN Horario h ON m.codm = h.codm
WHERE m.especialidade = 'Ortopedia'
GROUP BY h.DiaSemana