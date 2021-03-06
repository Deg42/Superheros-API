
DROP TABLE IF EXISTS HERO_HAS_POW
DROP TABLE IF EXISTS HERO_HAS_WEA
DROP TABLE IF EXISTS HEROES
DROP TABLE IF EXISTS SUPERPOWERS
DROP TABLE IF EXISTS WEAKNESSES

CREATE TABLE HEROES (
	ID			NUMERIC			PRIMARY KEY,
	NAME		VARCHAR(50)		NOT NULL,
	ALTEREGO	VARCHAR(50)		NOT NULL,
	IMG			VARCHAR(50)
);

CREATE TABLE SUPERPOWERS (
	ID			NUMERIC			PRIMARY KEY,
	POWER		VARCHAR(50)		NOT NULL
);

CREATE TABLE WEAKNESSES (
	ID			NUMERIC			PRIMARY KEY,
	WEAKNESS	VARCHAR(50)		NOT NULL
);

CREATE TABLE HERO_HAS_POW (
	ID_HERO		NUMERIC,
	ID_POW		NUMERIC,
	CONSTRAINT PK_HERO_HAS_POW PRIMARY KEY (ID_HERO, ID_POW),
	CONSTRAINT FK1_HERO_HAS_POW FOREIGN KEY (ID_HERO) REFERENCES HEROES(ID),
	CONSTRAINT FK2_HERO_HAS_POW FOREIGN KEY (ID_POW) REFERENCES SUPERPOWERS(ID),
);

CREATE TABLE HERO_HAS_WEA (
	ID_HERO		NUMERIC,
	ID_WEA		NUMERIC,
	CONSTRAINT PK_HERO_HAS_WEA PRIMARY KEY (ID_HERO, ID_WEA),
	CONSTRAINT FK1_HERO_HAS_WEA FOREIGN KEY (ID_HERO) REFERENCES HEROES(ID),
	CONSTRAINT FK2_HERO_HAS_WEA FOREIGN KEY (ID_WEA) REFERENCES WEAKNESSES(ID),
);

INSERT INTO HEROES (ID, NAME, ALTEREGO) VALUES (1, 'Batman', 'Bruce Wayne');
INSERT INTO HEROES (ID, NAME, ALTEREGO) VALUES (2, 'Catwoman', 'Selina Kyle');
INSERT INTO HEROES (ID, NAME, ALTEREGO) VALUES (3, 'Homelander', 'Jhon');
INSERT INTO HEROES (ID, NAME, ALTEREGO) VALUES (4, 'Rorschach', 'Walter Joseph Kovacs');

INSERT INTO SUPERPOWERS (ID, POWER) VALUES (1, 'Money');
INSERT INTO SUPERPOWERS (ID, POWER) VALUES (2, 'Aglity');
INSERT INTO SUPERPOWERS (ID, POWER) VALUES (3, 'Strengh');
INSERT INTO SUPERPOWERS (ID, POWER) VALUES (4, 'Logic');
INSERT INTO SUPERPOWERS (ID, POWER) VALUES (5, 'Laser Vision');

INSERT INTO WEAKNESSES (ID, WEAKNESS) VALUES (1, 'Is Human');
INSERT INTO WEAKNESSES (ID, WEAKNESS) VALUES (2, 'Laser pointers');
INSERT INTO WEAKNESSES (ID, WEAKNESS) VALUES (3, 'Love');

INSERT INTO HERO_HAS_POW (ID_HERO, ID_POW) VALUES (1, 1);
INSERT INTO HERO_HAS_POW (ID_HERO, ID_POW) VALUES (1, 3);
INSERT INTO HERO_HAS_POW (ID_HERO, ID_POW) VALUES (2, 2);
INSERT INTO HERO_HAS_POW (ID_HERO, ID_POW) VALUES (3, 3);
INSERT INTO HERO_HAS_POW (ID_HERO, ID_POW) VALUES (4, 4);
INSERT INTO HERO_HAS_POW (ID_HERO, ID_POW) VALUES (3, 5);

INSERT INTO HERO_HAS_WEA (ID_HERO, ID_WEA) VALUES (1, 1);
INSERT INTO HERO_HAS_WEA (ID_HERO, ID_WEA) VALUES (2, 2);
INSERT INTO HERO_HAS_WEA (ID_HERO, ID_WEA) VALUES (3, 3);
INSERT INTO HERO_HAS_WEA (ID_HERO, ID_WEA) VALUES (4, 1);



SELECT * FROM HEROES;
SELECT * FROM SUPERPOWERS;
SELECT * FROM WEAKNESSES;
SELECT * FROM HERO_HAS_POW;
SELECT * FROM HERO_HAS_WEA;