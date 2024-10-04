CREATE DATABASE db_factory_floor;

USE db_factory_floor;

CREATE TABLE escritorios (
    id_escritorio INT PRIMARY KEY AUTO_INCREMENT,
    nome_escritorio VARCHAR(50) NOT NULL
);

CREATE TABLE setores (
    id_setor INT PRIMARY KEY AUTO_INCREMENT,
    nome_setor VARCHAR(50) NOT NULL,
    cod_escritorio INT,
    FOREIGN KEY (cod_escritorio) REFERENCES Escritorios(id_escritorio)
);

CREATE TABLE funcionarios (
    id_funcionario INT PRIMARY KEY AUTO_INCREMENT,
    nome_funcionario VARCHAR(100) NOT NULL,
    tipo_funcionario INT NOT NULL,
    cod_setor INT,
    FOREIGN KEY (cod_setor) REFERENCES Setores(id_setor)
);

CREATE TABLE relatos (
    id_relato INT PRIMARY KEY AUTO_INCREMENT,
    descricao_relato VARCHAR(100) NOT NULL,
    cod_funcionario INT,
    FOREIGN KEY (cod_funcionario) REFERENCES Funcionarios(id_funcionario)
);