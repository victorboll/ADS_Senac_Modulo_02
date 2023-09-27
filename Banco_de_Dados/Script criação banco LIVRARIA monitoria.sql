--1)	Criar a tabela AUTOR e EDITORA, com as devidas restrições.

CREATE TABLE AUTOR(
	Matricula INT PRIMARY KEY, 
	Nome VARCHAR(80) NOT NULL,
	CPF CHAR(11) NOT NULL UNIQUE,
	Endereco VARCHAR(80),
	DataNascimento DATE NOT NULL,
	Nacionalidade VARCHAR(30) NOT NULL,

	CHECK (Matricula < 1000)
)

CREATE TABLE EDITORA(
	Editora INT PRIMARY KEY,
	Nome VARCHAR(80) NOT NULL,

	CHECK (Editora < 100)
)

--2) Criar a tabela LIVRO com as devidas restrições

CREATE TABLE LIVRO(
	Codigo INT PRIMARY KEY,
	Titulo VARCHAR(80) NOT NULL,
	Preco DECIMAL(10, 2),
	Lancamento DATE,
	Assunto VARCHAR(50),
	Cod_editora INT NOT NULL,

	CHECK (Codigo < 1000 AND Cod_editora < 100),

	CONSTRAINT FK1_LIVRO FOREIGN KEY (Cod_Editora) REFERENCES EDITORA(Editora)
)

--3) Criar a tabela AUTOR_LIVRO sem especificar restrições de integridade

CREATE TABLE AUTOR_LIVRO(
	Cod_Livro INT,
	Cod_Autor INT
)

--4) Alterar a tabela AUTOR_LIVRO incluindo agora as devidas restrições de integridade

ALTER TABLE AUTOR_LIVRO ALTER COLUMN Cod_Livro INT NOT NULL;
ALTER TABLE AUTOR_LIVRO ALTER COLUMN Cod_Autor INT NOT NULL;

ALTER TABLE AUTOR_lIVRO ADD CONSTRAINT PKs_AUTOR_LIVRO PRIMARY KEY(Cod_Livro, Cod_Autor);

ALTER TABLE AUTOR_LIVRO ADD CONSTRAINT FK1_AUTOR_LIVRO FOREIGN KEY(Cod_Autor) REFERENCES AUTOR(Matricula);
ALTER TABLE AUTOR_LIVRO ADD CONSTRAINT FK2_AUTOR_LIVRO FOREIGN KEY(Cod_Livro) REFERENCES LIVRO(Codigo);

ALTER TABLE AUTOR_LIVRO ADD CONSTRAINT Check1_AUTOR_LIVRO CHECK (Cod_Livro < 1000 AND Cod_Autor < 1000);


--5) Adicionar coluna “Edição” na tabela LIVRO, já criada. Esta coluna deverá aceitar números inferiores a 20 (criar uma restrição em separado)

ALTER TABLE LIVRO ADD Edicao INT;

ALTER TABLE LIVRO ADD CONSTRAINT Check1_Livro CHECK(Edicao < 20);

--6) Remover a coluna “Edição” recém-criada da tabela LIVRO (atenção a restrição criada)

ALTER TABLE LIVRO DROP CONSTRAINT Check1_Livro;

ALTER TABLE LIVRO DROP COLUMN Edicao;

--7) Destruir e Recriar tabela EDITORA incluindo a coluna Edição, conforme especificado no item 5.

ALTER TABLE LIVRO DROP CONSTRAINT FK1_LIVRO
ALTER TABLE AUTOR_LIVRO DROP CONSTRAINT FK2_AUTOR_LIVRO

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

	CONSTRAINT FK1_LIVRO FOREIGN KEY (Cod_Editora) REFERENCES EDITORA(Editora)
)

ALTER TABLE AUTOR_LIVRO ADD CONSTRAINT FK2_AUTOR_LIVRO FOREIGN KEY(Cod_Livro) REFERENCES LIVRO(Codigo);

-- 8) Popular as tabelas, utilizando os dados abaixo relacionados. (Dica: criar um script com os dados abaixo e depois executá-lo)

INSERT INTO EDITORA (Editora, Nome) VALUES (001, 'Addison'), (002, 'Globo'), (003, 'Pearson'),(004, 'Abril');

INSERT INTO LIVRO (Codigo, Titulo, Preco, Lancamento, Assunto, Cod_editora, Edicao) VALUES 
(100, 'Sistemas de Banco de Dados', 99.00, '2015-01-01', 'Informática', 003, 1),
(200, 'Rede de Computadores', 199.00, '2002-05-01', 'Informática', 003, 2),
(300, 'Corpo Humano', 89.00, '2011-09-01', 'Medicina', 004, 1),
(400, 'Leis da Física', 95.00, '2015-10-01', 'Ciência', 002, 2),
(500, 'Física Quântica', 95.00, '2015-10-01', 'Ciência', 002, 1),
(600, 'O Coração', 289.00, '1999-09-01', 'Medicina', 004, 10)

INSERT INTO AUTOR (Matricula, Nome, CPF, Endereco, DataNascimento, Nacionalidade) VALUES 
(911, 'Roberto', '12345678901', 'Rua A num 1', '1966-09-18', 'Brasileira'),
(922, 'Simone', '22345678901', 'Rua B num 1', '1976-08-08', 'Brasileira'),
(933, 'Fernando', '32345678901', 'Rua C num 1', '1996-07-13', 'Brasileira'),
(954, 'Felipe', '42345678901', 'Rua D num 1', '1967-02-28', 'Brasileira'),
(965, 'Fabio', '52345678901', 'Rua E num 1', '1988-03-08', 'Brasileira'),
(976, 'Fernanda', '62345678901', 'Rua E num 1','1988-03-08', 'Brasileira'),
(997, 'Julio', '22345678902', 'Rua E num 1', '1988-03-08', 'Brasileira'),
(999, 'Dario', '21345678901', 'Rua E num 1', '1998-03-08', 'Brasileira')

INSERT INTO AUTOR_LIVRO (Cod_autor,	Cod_livro)
VALUES (911, 100), (965,  600), (954,  100), (933,  200), (911,  200), (922,  300), (976,  400), (976,  500), (965,  300)



-- 10) Atualizar os preços dos livros de “Medicina” em 10%

UPDATE LIVRO SET Preco = Preco * 1.1 WHERE Assunto = 'Medicina'



SELECT * FROM LIVRO
FULL JOIN EDITORA ON LIVRO.Cod_editora = EDITORA.Editora
FULL JOIN AUTOR_LIVRO ON LIVRO.Codigo = AUTOR_LIVRO.Cod_livro
FULL JOIN AUTOR ON AUTOR_LIVRO.Cod_autor = AUTOR.Matricula