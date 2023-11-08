--Listar TODOS os m�dicos e suas respectivas consultas, incluindo aqueles SEM consulta marcada
SELECT m.nome, c.data, FORMAT(c.hora, N'hh\:mm\:ss') as 'Hora'
FROM Medicos m LEFT OUTER JOIN Consultas c ON m.codm = c.codm



--Listar TODOS os Pacientes e suas respectivas consultas, incluindo aqueles SEM consulta marcada
SELECT p.nome, c.data, FORMAT(c.hora, N'hh\:mm\:ss') as 'Hora'
FROM Pacientes p LEFT OUTER JOIN Consultas c ON p.codp = c.codp



--Listar TODOS os m�dicos e TODOS os paciente e suas respectivas consultas, incluindo aqueles SEM consulta marcada
SELECT m.nome as 'Nome Medico', p.nome as 'Nome Paciente', c.data, FORMAT(c.hora, N'hh\:mm\:ss') as 'Hora'
FROM Pacientes p FULL OUTER JOIN Consultas c ON p.codp = c.codp FULL OUTER JOIN Medicos m ON m.codm = c.codm



--Listar TODOS os m�dicos e os andares onde atendem, inclusive aqueles que n�o tem ambulat�rio associado
SELECT m.nome, a.andar
FROM Medicos m LEFT OUTER JOIN Ambulatorio a ON a.nroa = m.nroa  



--Listar todos os ambulat�rios vazios, isto �, que n�o tem m�dicos associados 
SELECT a.andar, a.nroa
FROM Medicos m FULL OUTER JOIN Ambulatorio a ON a.nroa = m.nroa
WHERE m.nome IS NULL