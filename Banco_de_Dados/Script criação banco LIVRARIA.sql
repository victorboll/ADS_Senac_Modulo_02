CREATE TABLE AUTOR(
	Matricula INT PRIMARY KEY,
	Nome VARCHAR(80) NOT NULL,
	CPF  CHAR(11) NOT NULL UNIQUE,
	Endereco VARCHAR(80),
	DataNasc DATE NOT NULL,
	Nacionalidade VARCHAR(30),

	CHECK (Matricula < 1000)
)

CREATE TABLE EDITORA(
	Editora INT PRIMARY KEY,
	Nome VARCHAR(80) NOT NULL,

	CHECK (Editora < 100)
)

--------------------------------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE LIVRO(
	Codigo INT PRIMARY KEY,
	Titulo VARCHAR(80) NOT NULL,
	Preco DECIMAL(10, 2),
	Lancamento DATE,
	Assunto VARCHAR(50),
	Cod_editora INT NOT NULL,

	CHECK (Codigo < 1000 AND Cod_editora < 100),

	CONSTRAINT FK1 FOREIGN KEY (Cod_editora) REFERENCES EDITORA(Editora)
)


--------------------------------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE AUTOR_LIVRO(
	Cod_livro INT,
	Cod_autor INT
)

--------------------------------------------------------------------------------------------------------------------------------------------------------------

--Colocando not null como em check fazia com que criar uma PK desse erro porque a coluna permitir not null
ALTER TABLE AUTOR_LIVRO ALTER COLUMN Cod_livro INT NOT NULL;
ALTER TABLE AUTOR_LIVRO ALTER COLUMN Cod_autor INT NOT NULL;

--------------------------------------------------------------------------------------------------------------------------------------------------------------

ALTER TABLE AUTOR_LIVRO ADD CONSTRAINT Autor_Livro_FK1 FOREIGN KEY (Cod_autor) REFERENCES AUTOR(Matricula);
ALTER TABLE AUTOR_LIVRO ADD CONSTRAINT Autor_Livro_FK2 FOREIGN KEY (Cod_livro) REFERENCES LIVRO(Codigo);
ALTER TABLE AUTOR_LIVRO ADD CONSTRAINT Autor_Livro_Check1 CHECK (Cod_livro < 1000 AND Cod_Autor < 1000);
ALTER TABLE AUTOR_LIVRO ADD CONSTRAINT Autor_Livro_PKs PRIMARY KEY(Cod_autor,Cod_livro);
	
--------------------------------------------------------------------------------------------------------------------------------------------------------------


ALTER TABLE LIVRO ADD Edicao INT

--------------------------------------------------------------------------------------------------------------------------------------------------------------

ALTER TABLE LIVRO ADD CONSTRAINT edicao_constraint CHECK (Edicao < 20)

--------------------------------------------------------------------------------------------------------------------------------------------------------------

ALTER TABLE LIVRO DROP CONSTRAINT edicao_constraint;
/*Pode ocorrer do drop da coluna não ser permitido se existir na tabela algum valor que esteja fora da regra de constraint.
  Para consertar isso o ideal é apagar o constraint como acima, ou alterar os valores incorretos*/
ALTER TABLE LIVRO DROP COLUMN Edicao;

--------------------------------------------------------------------------------------------------------------------------------------------------------------

ALTER TABLE LIVRO DROP CONSTRAINT FK1;
ALTER TABLE AUTOR_LIVRO DROP CONSTRAINT Autor_Livro_FK1;
ALTER TABLE AUTOR_LIVRO DROP CONSTRAINT Autor_Livro_FK2;
ALTER TABLE AUTOR_LIVRO DROP CONSTRAINT Autor_Livro_Check1;
ALTER TABLE AUTOR_LIVRO DROP CONSTRAINT Autor_Livro_PKs;
DROP TABLE LIVRO

--------------------------------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE LIVRO(
	Codigo INT PRIMARY KEY,
	Titulo VARCHAR(80) NOT NULL,
	Preco DECIMAL(10, 2),
	Lancamento DATE,
	Assunto VARCHAR(50),
	Cod_editora INT NOT NULL,
	Edicao INT,

	CHECK (Codigo < 1000 AND Cod_editora < 100 AND Edicao < 20),

	CONSTRAINT FK1 FOREIGN KEY (Cod_editora) REFERENCES EDITORA(Editora)
)

ALTER TABLE AUTOR_LIVRO ADD CONSTRAINT Autor_Livro_FK1 FOREIGN KEY (Cod_autor) REFERENCES AUTOR(Matricula);
ALTER TABLE AUTOR_LIVRO ADD CONSTRAINT Autor_Livro_FK2 FOREIGN KEY (Cod_livro) REFERENCES LIVRO(Codigo);
ALTER TABLE AUTOR_LIVRO ADD CONSTRAINT Autor_Livro_Check1 CHECK (Cod_livro < 1000 AND Cod_Autor < 1000);
ALTER TABLE AUTOR_LIVRO ADD CONSTRAINT Autor_Livro_PKs PRIMARY KEY(Cod_autor,Cod_livro);

--------------------------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO EDITORA (Editora, Nome) --Você normalmente só vai precisar especificar em que colunas você está inserindo se a ordem da entrada estiver incorreta e/ou incompleta
VALUES (001, 'Addison'), (002, 'Globo'), (003, 'Pearson'),(004, 'Abril');

INSERT INTO LIVRO (Codigo, Titulo, Preco, Lancamento, Assunto, Cod_editora, Edicao)
VALUES (100, 'Sistemas de Banco de Dados', 99.00, '2015-01-01', 'Informática', 003, 1),
	   (200, 'Rede de Computadores', 199.00, '2002-05-01', 'Informática', 003, 2),
	   (300, 'Corpo Humano', 89.00, '2011-09-01', 'Medicina', 004, 1),
       (400, 'Leis da Física', 95.00, '2015-10-01', 'Ciência', 002, 2),
	   (500, 'Física Quântica', 95.00, '2015-10-01', 'Ciência', 002, 1),
	   (600, 'O Coração', 289.00, '1999-09-01', 'Medicina', 004, 10)

INSERT INTO AUTOR (Matricula, Nome, CPF, Endereco, DataNasc, Nacionalidade)
VALUES (911, 'Roberto', '12345678901', 'Rua A num 1', '1966-09-18', 'Brasileira'),
       (922, 'Simone', '22345678901', 'Rua B num 1', '1976-08-08', 'Brasileira'),
       (933, 'Fernando', '32345678901', 'Rua C num 1', '1996-07-13', 'Brasileira'),
       (954, 'Felipe', '42345678901', 'Rua D num 1', '1967-02-28', 'Brasileira'),
       (965, 'Fabio', '52345678901', 'Rua E num 1', '1988-03-08', 'Brasileira'),
       (976, 'Fernanda', '62345678901', 'Rua E num 1','1988-03-08', 'Brasileira'),
       (997, 'Julio', '22345678902', 'Rua E num 1', '1988-03-08', 'Brasileira'),
       (999, 'Dario', '21345678901', 'Rua E num 1', '1998-03-08', 'Brasileira')

INSERT INTO AUTOR_LIVRO (Cod_autor,	Cod_livro)
VALUES (911, 100), (965,  600), (954,  100), (933,  200), (911,  200), (922,  300), (976,  400), (976,  500), (965,  300)

--------------------------------------------------------------------------------------------------------------------------------------------------------------

UPDATE LIVRO
SET Preco = Preco * 1.1 WHERE Assunto = 'Medicina'

--------------------------------------------------------------------------------------------------------------------------------------------------------------

SELECT * FROM LIVRO
FULL JOIN EDITORA ON LIVRO.Cod_editora = EDITORA.Editora
FULL JOIN AUTOR_LIVRO ON LIVRO.Codigo = AUTOR_LIVRO.Cod_livro
FULL JOIN AUTOR ON AUTOR_LIVRO.Cod_autor = AUTOR.Matricula

