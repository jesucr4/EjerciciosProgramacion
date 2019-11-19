SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS Cursan;
DROP TABLE IF EXISTS Hacen;
DROP TABLE IF EXISTS Realizan;
DROP TABLE IF EXISTS Alumnos;
DROP TABLE IF EXISTS Asignaturas;
DROP TABLE IF EXISTS Elaboran;
DROP TABLE IF EXISTS Examenes;
DROP TABLE IF EXISTS Practicas;
DROP TABLE IF EXISTS Profesores;




/* Create Tables */

CREATE TABLE Alumnos
(
	Num_Alum bigint NOT NULL,
	Nombre varchar(25) NOT NULL,
	Grupo mediumtext NOT NULL,
	PRIMARY KEY (Num_Alum)
);


CREATE TABLE Asignaturas
(
	Num_asignaturas bigint NOT NULL,
	Nombre text NOT NULL,
	Num_prof bigint NOT NULL,
	PRIMARY KEY (Num_asignaturas)
);


CREATE TABLE Cursan
(
	Num_Alum bigint NOT NULL,
	Num_asignaturas bigint NOT NULL,
	Trimestre varchar(25) NOT NULL
);


CREATE TABLE Elaboran
(
	Num_prof bigint NOT NULL,
	COD_Practica bigint NOT NULL,
	Fecha date NOT NULL
);


CREATE TABLE Examenes
(
	Num_exam bigint NOT NULL,
	Npregunta bigint NOT NULL,
	Fecha date NOT NULL,
	PRIMARY KEY (Num_exam)
);


CREATE TABLE Hacen
(
	Num_Alum bigint NOT NULL,
	Num_exam bigint NOT NULL,
	Nota bigint NOT NULL
);


CREATE TABLE Practicas
(
	COD_Practica bigint NOT NULL,
	Titulo mediumtext NOT NULL,
	Nivel bigint NOT NULL,
	PRIMARY KEY (COD_Practica)
);


CREATE TABLE Profesores
(
	Nombre text NOT NULL,
	Num_prof bigint NOT NULL,
	PRIMARY KEY (Num_prof)
);


CREATE TABLE Realizan
(
	Num_Alum bigint NOT NULL,
	COD_Practica bigint NOT NULL,
	Nota bigint NOT NULL,
	Fecha date NOT NULL,
	UNIQUE (COD_Practica)
);



/* Create Foreign Keys */

ALTER TABLE Cursan
	ADD FOREIGN KEY (Num_Alum)
	REFERENCES Alumnos (Num_Alum)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Hacen
	ADD FOREIGN KEY (Num_Alum)
	REFERENCES Alumnos (Num_Alum)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Realizan
	ADD FOREIGN KEY (Num_Alum)
	REFERENCES Alumnos (Num_Alum)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Cursan
	ADD FOREIGN KEY (Num_asignaturas)
	REFERENCES Asignaturas (Num_asignaturas)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Hacen
	ADD FOREIGN KEY (Num_exam)
	REFERENCES Examenes (Num_exam)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Elaboran
	ADD FOREIGN KEY (COD_Practica)
	REFERENCES Practicas (COD_Practica)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Realizan
	ADD FOREIGN KEY (COD_Practica)
	REFERENCES Practicas (COD_Practica)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Asignaturas
	ADD FOREIGN KEY (Num_prof)
	REFERENCES Profesores (Num_prof)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Elaboran
	ADD FOREIGN KEY (Num_prof)
	REFERENCES Profesores (Num_prof)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



