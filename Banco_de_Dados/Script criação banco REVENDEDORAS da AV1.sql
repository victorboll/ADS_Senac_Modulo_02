--Criar as tabelas CONSUMIDORES, REVENDEDORAS e NEGOCIOS – atentar a ordem de criação e à descrição das chaves primárias e estrangeiras de cada tabela.
CREATE TABLE CONSUMIDORES(
	CPF CHAR(11) PRIMARY KEY,
	Nome VARCHAR(80) NOT NULL,
	Cidade VARCHAR(15) NOT NULL,
	Estado CHAR(2) NOT NULL
);

CREATE TABLE REVENDEDORAS(
	CNPJ CHAR(14) PRIMARY KEY,
	Nome VARCHAR(80) NOT NULL,
	Cidade VARCHAR(15) NOT NULL,
	Estado CHAR(2) NOT NULL 
);

-------------------------------------------------------

CREATE TABLE NEGOCIOS(
	CNPJ CHAR(14),
	CPF CHAR(11),
	Automovel VARCHAR(15) NOT NULL,
	DataCompra DATE NOT NULL,
	Preco INT NOT NULL,

	CONSTRAINT PKS_NEGOCIOS PRIMARY KEY(CNPJ, CPF),
	CONSTRAINT FK1_NEGOCIOS FOREIGN KEY (CNPJ) REFERENCES REVENDEDORAS(CNPJ),
	CONSTRAINT FK2_NEGOCIOS FOREIGN KEY (CPF) REFERENCES CONSUMIDORES(CPF),
);

--Adicionar a coluna “idade” na tabela CONSUMIDORES, já criada. Esta coluna deverá aceitar somente números inferiores a 100 (atenção: estamos adicionando uma coluna e uma restrição)

ALTER TABLE CONSUMIDORES ADD idade INT;
ALTER TABLE CONSUMIDORES ADD CONSTRAINT CHECK_IDADE_CONSUMIDORES CHECK (idade < 100);

--Remover a coluna “idade” da tabela CONSUMIDORES (dica: remover a restrição também)

ALTER TABLE CONSUMIDORES DROP CONSTRAINT CHECK_IDADE_CONSUMIDORES;
ALTER TABLE CONSUMIDORES DROP COLUMN idade;

--Qual seria o comando para destruir tabela NEGOCIOS?

DROP TABLE NEGOCIOS

--Inserir os seguintes registros nas tabelas 

INSERT INTO CONSUMIDORES VALUES
	('12345678901', 'Roberto', 'Rio de Janeiro', 'RJ'),
	('11145678901', 'Ana', 'Niterói', 'RJ'),
	('13345678901', 'Ricardo', 'Rio de Janeiro', 'RJ'),
	('12245678901', 'Rachel', 'Niterói', 'RJ'),
	('16645678901', 'Ninho', 'Niterói', 'RJ')

INSERT INTO REVENDEDORAS VALUES
	('12345678901234', 'BobAuto', 'Rio de Janeiro', 'RJ'),
	('44445678904444', 'SenacAuto', 'Niterói', 'RJ')

INSERT INTO NEGOCIOS VALUES
	('12345678901234', '12345678901', 'Honda FIT', '2023-01-10', 80000),
	('12345678901234', '13345678901', 'Honda CIVIC', '2023-01-10', 100000),
	('44445678904444', '12245678901', 'Honda CRV', '2023-01-10', 130000),
	('44445678904444', '16645678901', 'Toyota Corolla', '2023-01-10', 85000)

--Atualizar preço do negócio realizado com ‘Roberto’ para $90.000 (tabela NEGOCIOS)

UPDATE NEGOCIOS SET Preco = 90000 WHERE CPF = '12345678901'

--Apagar registro do consumidor ‘Ana ‘da tabela de CONSUMIDORES

DELETE FROM CONSUMIDORES WHERE Nome = 'Ana'






SELECT * FROM NEGOCIOS
FULL JOIN CONSUMIDORES ON NEGOCIOS.CPF = CONSUMIDORES.CPF
FULL JOIN REVENDEDORAS ON NEGOCIOS.CNPJ = REVENDEDORAS.CNPJ
