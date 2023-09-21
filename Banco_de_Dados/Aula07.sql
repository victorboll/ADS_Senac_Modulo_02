CREATE TABLE Pessoas (
  CPF VARCHAR(11) primary key,
  Nome VARCHAR(45) NOT NULL,
  Sexo CHAR(1) NOT NULL,
)

CREATE TABLE Cerveja (
  Nome VARCHAR(20) primary key,
  Tipo VARCHAR(45) NOT NULL,
  Teor_Alcoolico VARCHAR(45) NOT NULL,
  Cor VARCHAR(45) NOT NULL,
)

CREATE TABLE Boteco (
  CNPJ VARCHAR(14) primary key,
  Nome VARCHAR(45) NOT NULL,
  Cidade VARCHAR(45) NOT NULL,
)

CREATE TABLE Gosta (
  Pessoas_CPF VARCHAR(11) NOT NULL,
  Cerveja_Nome VARCHAR(20) NOT NULL,
  Constraint PK_Gosta primary key(Pessoas_CPF, Cerveja_Nome),
  constraint Fk1 foreign key (Pessoas_CPF) references Pessoas(CPF),
  constraint Fk2 foreign key (Cerveja_Nome) references Cerveja(Nome)
)

CREATE TABLE Vende (
  Cerveja_Nome VARCHAR(20) NOT NULL,
  Boteco_CNPJ VARCHAR(14) NOT NULL,
  Constraint PK_Vende primary key(Boteco_CNPJ, Cerveja_Nome),
  constraint Fk1 foreign key (Boteco_CNPJ) references Boteco(CNPJ),
  constraint Fk2 foreign key (Cerveja_Nome) references Cerveja(Nome)
)

CREATE TABLE Dono (
  Boteco_CNPJ VARCHAR(14) NOT NULL,
  Pessoas_CPF VARCHAR(11) NOT NULL,
  Constraint PK_Dono primary key(Boteco_CNPJ, Pessoas_CPF),
  constraint Fk1 foreign key (Pessoas_CPF) references Pessoas(CPF),
  constraint Fk2 foreign key (Boteco_CNPJ) references Boteco(CNPJ)
)





CREATE Gosta (
  Pessoas_CPF VARCHAR(11) NOT NULL,
  Cerveja_Nome VARCHAR(20) NOT NULL,
  PRIMARY KEY (`Pessoas_CPF`, `Cerveja_Nome`),
  INDEX `fk_Pessoas_has_Cerveja_Cerveja1_idx` (`Cerveja_Nome` ASC) VISIBLE,
  INDEX `fk_Pessoas_has_Cerveja_Pessoas1_idx` (`Pessoas_CPF` ASC) VISIBLE,
  CONSTRAINT `fk_Pessoas_has_Cerveja_Pessoas1`
    FOREIGN KEY (`Pessoas_CPF`)
    REFERENCES `mydb`.`Pessoas` (`CPF`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pessoas_has_Cerveja_Cerveja1`
    FOREIGN KEY (`Cerveja_Nome`)
    REFERENCES `mydb`.`Cerveja` (`Nome`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB



CREATE TABLE IF NOT EXISTS `mydb`.`Vende` (
  `Cerveja_Nome` VARCHAR(20) NOT NULL,
  `Boteco_CNPJ` VARCHAR(14) NOT NULL,
  PRIMARY KEY (`Cerveja_Nome`, `Boteco_CNPJ`),
  INDEX `fk_Cerveja_has_Boteco_Boteco1_idx` (`Boteco_CNPJ` ASC) VISIBLE,
  INDEX `fk_Cerveja_has_Boteco_Cerveja1_idx` (`Cerveja_Nome` ASC) VISIBLE,
  CONSTRAINT `fk_Cerveja_has_Boteco_Cerveja1`
    FOREIGN KEY (`Cerveja_Nome`)
    REFERENCES `mydb`.`Cerveja` (`Nome`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cerveja_has_Boteco_Boteco1`
    FOREIGN KEY (`Boteco_CNPJ`)
    REFERENCES `mydb`.`Boteco` (`CNPJ`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB




CREATE TABLE IF NOT EXISTS `mydb`.`Frequenta` (
  `Pessoas_CPF` VARCHAR(11) NOT NULL,
  `Boteco_CNPJ` VARCHAR(14) NOT NULL,
  PRIMARY KEY (`Pessoas_CPF`, `Boteco_CNPJ`),
  INDEX `fk_Pessoas_has_Boteco_Boteco1_idx` (`Boteco_CNPJ` ASC) VISIBLE,
  INDEX `fk_Pessoas_has_Boteco_Pessoas1_idx` (`Pessoas_CPF` ASC) VISIBLE,
  CONSTRAINT `fk_Pessoas_has_Boteco_Pessoas1`
    FOREIGN KEY (`Pessoas_CPF`)
    REFERENCES `mydb`.`Pessoas` (`CPF`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pessoas_has_Boteco_Boteco1`
    FOREIGN KEY (`Boteco_CNPJ`)
    REFERENCES `mydb`.`Boteco` (`CNPJ`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB