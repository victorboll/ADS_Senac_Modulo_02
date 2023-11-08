--listar nome e doen�a dos funcion�rios que s�o pacientes?
SELECT p.nome, p.doen�a 
FROM Pacientes p INNER JOIN Funcionarios f ON p.CPF = f.CPF



--Listar m�dicos e suas especialidades que trabalham no domingo?
SELECT m.nome, m.especialidade
FROM Medicos m INNER JOIN Horario h ON m.codm = h.codm
WHERE h.DiaSemana = 1



--Quais especialidades est�o dispon�veis na 2a feira?
SELECT DISTINCT m.especialidade
FROM Medicos m INNER JOIN Horario h ON m.codm = h.codm
WHERE h.DiaSemana = 2



--Quantos m�dicos trabalham por dia de semana
SELECT h.DiaSemana, COUNT(DISTINCT m.codm) as 'QtyMedicos'
FROM Medicos m INNER JOIN Horario h ON m.codm = h.codm
GROUP BY h.DiaSemana



--Quais dias da semana o hospital disp�e de Oftalmologistas
SELECT DISTINCT h.DiaSemana
FROM Medicos m INNER JOIN Horario h ON m.codm = h.codm
WHERE m.especialidade = 'Oftalmologia'



--Quantos m�dicos ortopedistas trabalham por dia de semana
SELECT h.DiaSemana, COUNT(DISTINCT m.codm) as 'QtyOrtopedistas'
FROM Medicos m INNER JOIN Horario h ON m.codm = h.codm
WHERE m.especialidade = 'Ortopedia'
GROUP BY h.DiaSemana