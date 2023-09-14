/****** Script do comando SelectTopNRows de SSMS  ******/
SELECT * FROM Medicos
SELECT * FROM Pacientes
SELECT * FROM Consultas

SELECT * FROM Medicos Where nome = 'Sergio'

select nome, idade from Medicos

INSERT INTO Medicos VALUES (30, '98723458771', 'Luiz Fernando', 40, 'Niteroi', 'Urologia', 301)

UPDATE medicos set idade = 39 where nome = 'Luiz Fernando'

delete from Medicos where codm=30

INSERT INTO Pacientes VALUES (999, '12300008911', 'Fernando', 'M', 55, 'Teresópolis', 'Febre Amarela')

update Pacientes set idade = 45 where codp = 999

insert into Consultas values (97, 999, '2023-09-14', '19:00:00')

SELECT * FROM Consultas where codm = 97 and codp = 999

update Consultas set hora = '14:30' where codm = 97 and codp = 999

delete from Consultas where codm = 97 and codp = 999
