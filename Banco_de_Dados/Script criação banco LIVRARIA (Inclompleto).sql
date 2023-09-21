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

CREATE TABLE AUTOR_LIVRO(
	Cod_livro INT,
	Cod_autor INT
)


ALTER TABLE AUTOR_LIVRO
ADD CONSTRAINT integrity_constraints
	PRIMARY KEY(Cod_autor,Cod_livro),
	FOREIGN KEY (Cod_autor) REFERENCES AUTOR(Matricula),
	FOREIGN KEY (Cod_livro) REFERENCES LIVRO(Codigo),
	CHECK (Cod_livro IS NOT NULL AND Cod_Autor IS NOT NULL AND Cod_livro < 1000 AND Cod_Autor < 1000);

/* Outra maneira de fazer not null seria criar um constraint:
ALTER TABLE AUTOR_LIVRO ALTER COLUMN Cod_livro INT NOT NULL;
ALTER TABLE AUTOR_LIVRO ALTER COLUMN Cod_autor INT NOT NULL;*/


ALTER TABLE LIVRO ADD Edicao INT

ALTER TABLE LIVRO ADD CONSTRAINT edicao_constraint CHECK (Edicao < 20)


ALTER TABLE LIVRO DROP CONSTRAINT edicao_constraint
/*Pode ocorrer do drop da coluna não ser permitido se existir na tabela algum valor que esteja fora da regra de constraint.
  Para consertar isso o ideal é apagar o constraint como acima, ou alterar os valores incorretos*/
ALTER TABLE LIVRO DROP Edicao


DROP TABLE LIVRO

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

INSERT INTO EDITORA (Editora, Nome) --Você normalmente só vai precisar especificar em que colunas você está inserindo se a ordem da entrada estiver incorreta e/ou incompleta
VALUES (001, 'Addison'), (002, 'Globo'), (003, 'Pearson'),(004, 'Abril');

INSERT INTO LIVRO (Codigo, Titulo, Preco, Lancamento, Assunto, Cod_editora, Edicao)
VALUES (100, 'Sistemas de Banco de Dados', 99.00, 01/01/2015, 'Informática', 003, 1)
	   (200, 'Rede de Computadores', 199.00, 01/05/2002, 'Informática', 003, 2)
	   (300, 'Corpo Humano', 89.00, 01/09/2011, 'Medicina', 004, 1)
       (400, 'Leis da Física', 95.00, 01/10/2015, 'Ciência', 002, 2)
	   (500, 'Física Quântica', 95.00, 01/10/2015, 'Ciência', 005, 1)
	   (300, 'O Coração', 289.00, 01/09/1999, 'Medicina', 004, 10)


