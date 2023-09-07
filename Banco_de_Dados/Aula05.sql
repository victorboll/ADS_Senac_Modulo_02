-- Estudante (Est_id, nome, CPF, email)

--Método 1 de criar tabela
create table Estudante (
Est_id int primary key,
nome varchar(20),
CPF varchar(11),
email varchar(50)
sexo char(1) CHECK (sexo in ('M', 'F', 'N'))
)

--Método 2 de criar tabela
create table Estudante (
Est_id int,
nome varchar(20),
CPF varchar(11),
email varchar(50)
constraint pk_estudante primary key (Est_id)
)


INSERT INTO Estudante VALUES ('1', 'Jose Paulo', '12345678911', 'jp@senac', 'M')
INSERT INTO Estudante VALUES ('2', 'Victor', '12345678901', 'vc@senac', 'M')
INSERT INTO Estudante VALUES ('3', 'Alice', '12345678902', 'alice@senac', 'F')


create table UC (
UCid int primary key,
Nome varchar(20),
Horario varchar(20),
)

insert into UC values (101, 'Bando de dados I', '4a feira')
insert into UC values (102, 'Bando de dados II', '2a feira')
insert into UC values (103, 'Int. Programa', '5a feira')


create table Matricula (
Sid int,
UCid int,
conceito char(1)
Constraint PK_matricula primary key(Sid, UCid),
constraint FK2 foreign key (Sid) references Estudante(Est_id),
constraint FK3 foreign key (UCid) references UC(UCid)
)


insert into Matricula values (1, 101, '')
insert into Matricula values (1, 102, '')
insert into Matricula values (3, 101, '')


SELECT * FROM [Estudante]
select * from UC
select * from Matricula


DROP table Estudante
Drop table Matricula
Drop table UC

DELETE FROM Estudante WHERE Est_id =1

ALTER TABLE Estudante
ADD CONSTRAINT uq_cpf UNIQUE (CPF);

INSERT INTO Estudante VALUES ('9', 'Abel', '12345678903', 'abel@senac', 'M')
INSERT INTO Estudante VALUES ('5', 'Carlos', '12345678904', 'carlos@senac', 'M')