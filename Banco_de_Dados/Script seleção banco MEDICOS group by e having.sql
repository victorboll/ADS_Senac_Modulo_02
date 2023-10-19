select nome, idade
from medicos
order by nome, idade desc


select especialidade, count(*) as QtyMedicos
from medicos
group by especialidade
order by QtyMedicos


select especialidade, count(*) as QtyMedicos
from medicos
group by especialidade
having (count(*)=1)
order by QtyMedicos


select doença, count(*) as QtyDoentes
from Pacientes
group by doença
order by QtyDoentes


select nome, especialidade, idade
from medicos
order by especialidade


select nome, doença
from Pacientes
order by doença


select especialidade, count(*) as QtyMedicos
from medicos
group by especialidade
having (count(*)>1)
order by QtyMedicos


select doença, count(*) as QtyDoentes
from Pacientes
group by doença
having (count(*)>3)
order by QtyDoentes


/*Médico + velho por especialidade*/

select especialidade, max(idade)
from medicos
group by especialidade


SELECT Nome, idade, especialidade
FROM Medicos
WHERE idade = ( SELECT MAX(idade) 
		FROM medicos)


SELECT nome, idade, especialidade
FROM medicos
WHERE idade = (SELECT MAX(idade) FROM Medicos)
group by especialidade, nome, idade



select especialidade, max(idade)
from medicos
group by especialidade


select m1.nome m1.especialidade, max(m1.idade) as idade
from medicos m1
RIGHT JOIN (select especialidade, max(idade) as idade from medicos group by especialidade) m2
on m1.especialidade = m2.especialidade and m1.idade = m2.idade


/*Correcao da de cima*/
SELECT m1.nome, m1.especialidade, m1.idade
FROM medicos m1
INNER JOIN (SELECT especialidade, MAX(idade) AS max_idade FROM medicos GROUP BY especialidade) m2 
ON m1.especialidade = m2.especialidade AND m1.idade = m2.max_idade;
