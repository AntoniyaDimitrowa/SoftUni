
-- 0 --
CREATE DATABASE minions;
USE minions;

-- 1 --
CREATE TABLE minions (
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50),
    `age` INT
);

CREATE TABLE towns (
    town_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50)
);

-- 2 --
ALTER TABLE minions 
ADD COLUMN town_id INT;

ALTER TABLE minions
ADD CONSTRAINT fk_minions_towns 
FOREIGN KEY minions(town_id)
REFERENCES towns(id);

-- 3 --
INSERT INTO towns(id, name)
VALUES(1, 'Sofia'),
	(2, 'Plovdiv'),
	(3, 'Varna');

INSERT INTO minions(id, name, age, town_id)
VALUES(1, 'Kevin', 22, 1),
	(2, 'Bob', 15, 3),
	(3, 'Steward', NULL, 2);
    
-- 4 --
TRUNCATE TABLE minions;

-- 5 --
DROP TABLE minions;
DROP TABLE towns;

-- 6 --
CREATE TABLE people(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    picture BLOB,
    height DOUBLE(10, 2),
    weight DOUBLE(10, 2),
    gender CHAR(1) NOT NULL,
    birthdate DATE NOT NULL,
    biography TEXT
);

INSERT INTO people(id, name, gender, birthdate)
VALUES(1, 'Kevin', 'm', DATE(NOW())),
	(2, 'Bob', 'm', DATE(NOW())),
	(3, 'Steward', 'm', DATE(NOW())),
	(4, 'Lilly', 'f', DATE(NOW())),
	(5, 'Kari', 'f', DATE(NOW()));

-- 7 --
CREATE TABLE users(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(30) NOT NULL,
    password VARCHAR(26) NOT NULL,
    profile_picture BLOB,
    last_login_time DATETIME,
    is_deleted BOOLEAN
);

INSERT INTO users(username, password)
VALUES('Kevin', 'password123'),
	('Bob', 'password456'),
	('Steward', 'mpassword789'),
	('Lilly', 'fpassword426'),
	('Kari', 'fpassword896');
    
-- 8 --