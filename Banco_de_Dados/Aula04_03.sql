CREATE TABLE ESTUDANTE (
idEstudante int PRIMARY KEY,
nome varchar(45),
CPF char(11),
Endereco varchar(45)
)



CREATE TABLE UC (
CID int PRIMARY KEY,
Nome VARCHAR(45),
CargaHoraria TINYINT,
)



CREATE TABLE MATRICULA(
idEstudante int,
idUC int,
Conceito char(1),
CONSTRAINT Matricula_pk PRIMARY KEY (idEstudante, idUC),
CONSTRAINT Matricula_fk1 FOREIGN KEY (idEstudante) REFERENCES ESTUDANTE(idEstudante),
CONSTRAINT Matricula_fk2 FOREIGN KEY (idUC) REFERENCES UC(CID),
)

