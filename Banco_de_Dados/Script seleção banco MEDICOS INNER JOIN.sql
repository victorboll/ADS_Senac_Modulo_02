--Medicos que atendem em ambulatórios com pelo menos 20 leitos de capacidade


-- Forma incorreta de fazer
SELECT nome, Ambulatorio.nroa, capacidade
FROM Medicos, Ambulatorio
WHERE capacidade > 20
ORDER BY nome


-- Utilizando WHERE para refinar (Ainda não é a ideal)
SELECT m.nome, a.nroa, a.capacidade 
FROM Medicos m, Ambulatorio a
WHERE a.capacidade > 20 AND m.nroa = a.nroa
ORDER BY nome


--Utilizando INNER JOIN (Solução ideal)
SELECT m.nome, m.especialidade, a.nroa, a.capacidade 
FROM Medicos m INNER JOIN Ambulatorio a ON a.nroa = m.nroa
WHERE a.capacidade > 20 and m.especialidade like '%orto%'
ORDER BY m.nome


--Listar o nome do medico, o andar e número de ambulatório onde presta atendimento, ordenado por andar
SELECT m.nome, a.andar, a.nroa
FROM Medicos m INNER JOIN Ambulatorio a ON a.nroa = m.nroa
ORDER BY a.andar


--Buscar o nome dos pacientes que têm consulta marcada, com a respectiva data e hora, ordenado por data/hora
SELECT p.nome, c.data, c.hora
FROM Pacientes p JOIN Consultas c ON p.codp = c.codp
ORDER BY c.data, c.hora


--Buscar o nome do médico, o nome do paciente e a data&hora da consulta ordenado por data/hora
SELECT m.nome as 'Nome Medico', p.nome as 'Nome Paciente', c.data, c.hora
FROM Consultas c JOIN Pacientes p ON p.codp = c.codp JOIN Medicos m ON m.codm = c.codm
ORDER BY c.data, c.hora


--Buscar, para as consultas marcadas para o período da manhã (7hs-12hs) do dia 07/10/2015, o nome do médico, o nome do paciente e a data&hora da consulta
SELECT m.nome as 'Nome Medico', p.nome as 'Nome Paciente', c.data, c.hora
FROM Consultas c JOIN Pacientes p ON p.codp = c.codp JOIN Medicos m ON m.codm = c.codm
WHERE c.hora <= '12:00' AND c.data = '2015-10-07' 
ORDER BY c.data, c.hora


/*Buscar, para as consultas marcadas para o período da manhã (7hs-12hs) do dia 07/10/2015, o nome do médico, o nome do paciente e a data&hora da consulta
e o ambulatório e respectivo andar onde será realizada a consulta*/
SELECT m.nome as 'Nome Medico', p.nome as 'Nome Paciente', c.data, c.hora, a.nroa as 'Ambulatorio', a.andar 'Andar'
FROM Consultas c JOIN Pacientes p ON p.codp = c.codp JOIN Medicos m ON m.codm = c.codm JOIN Ambulatorio a ON a.nroa = m.nroa
WHERE c.data = '2015-10-07' and c.hora between '07:00' AND '12:00'
ORDER BY c.data, c.hora
