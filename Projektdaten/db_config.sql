CREATE TABLE Artikel (
	id_artikel BIGINT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	bezeichnung VARCHAR(100),
	zeitstempel TIMESTAMP,
	user_parameter CLOB,
	PRIMARY KEY (id_artikel)
	)
	
CREATE TABLE Warentraeger (
	id_warentraeger BIGINT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	bezeichnung VARCHAR(100),
	stoerung INT,
	montagezustand INT,
	RFID_inhalt CHAR(128),
	abstand_mm INT,
	user_parameter CLOB,
	zeitstempel TIMESTAMP,
	PRIMARY KEY (id_warentraeger)
	)
	
CREATE TABLE Transportband (
	id_transportband BIGINT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	bezeichnung VARCHAR(100),
	stoerung INT,
	laenge INT,
	geschwindigkeit INT,
	user_parameter CLOB,
	zeitstempel TIMESTAMP,
	PRIMARY KEY (id_transportband)
	)

CREATE TABLE Sektor (
	id_serktor BIGINT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	bezeichnung VARCHAR(100),
	stoerung INT,
	position_x INT,
	position_y INT,
	position_z INT,
	position_ausrichtung INT,
	user_parameter CLOB,
	zeitstempel TIMESTAMP,
	PRIMARY KEY (id_transportband)
	)
	
CREATE TABLE Sensor (
	id_sensor BIGINT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	bezeichnung VARCHAR(100),
	stoerung INT,
	zustand INT,
	phy_adresse CHAR(10),
	user_parameter CLOB,
	zeitstempel TIMESTAMP,
	PRIMARY KEY (id_sensor)
	)

CREATE TABLE Roboter (
	id_roboter BIGINT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	bezeichnung VARCHAR(100),
	stoerung INT,
	position_x INT,
	position_y INT,
	position_z INT,
	position_ausrichtung INT,
	user_parameter CLOB,
	zeitstempel TIMESTAMP,
	PRIMARY KEY (id_sensor)
	)
	
CREATE TABLE Gelenk (
	id_gelenk BIGINT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	bezeichnung VARCHAR(100),
	typ VARCHAR(100),
	nummer INT,
	gelenkstellung INT,
	user_parameter CLOB,
	zeitstempel TIMESTAMP,
	PRIMARY KEY (id_sensor)
	)
	
CREATE TABLE Hubquerpodest (
	id_hubquerpodest BIGINT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	bezeichnung VARCHAR(100),
	motor INT,
	oben INT,
	mittig INT,
	user_parameter CLOB,
	zeitstempel TIMESTAMP,
	PRIMARY KEY (id_sensor)
	)