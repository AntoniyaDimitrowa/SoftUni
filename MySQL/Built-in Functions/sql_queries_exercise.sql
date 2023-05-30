-- 1 --
USE soft_uni;

SELECT `first_name`, `last_name`
FROM `employees`
WHERE `first_name` LIKE 'sa%'
ORDER BY `employee_id`;

-- 2 --
SELECT `first_name`, `last_name`
FROM `employees`
WHERE `last_name` LIKE '%ei%'
ORDER BY `employee_id`;

-- 3 --
SELECT `first_name`
FROM `employees`
WHERE `department_id` IN(3, 10)
AND YEAR(`hire_date`) BETWEEN 1995 AND 2005
ORDER BY `employee_id`;

-- 4 --
SELECT `first_name`, `last_name`
FROM `employees`
WHERE `job_title` NOT LIKE '%engineer%'
ORDER BY `employee_id`;

-- 5 --
SELECT `name`
FROM `towns`
WHERE CHAR_LENGTH(`name`) = 5 
OR CHAR_LENGTH(`name`) = 6
ORDER BY `name`;

-- 6 --
SELECT `town_id`, `name`
FROM `towns`
WHERE `name` LIKE 'M%' 
OR `name` LIKE 'K%'
OR `name` LIKE 'B%'
OR `name` LIKE 'E%'
ORDER BY `name`;

-- 7 --
SELECT `town_id`, `name`
FROM `towns`
WHERE `name` NOT LIKE 'R%' 
AND `name` NOT LIKE 'D%'
AND `name` NOT LIKE 'B%'
ORDER BY `name`;

-- 8 --
CREATE VIEW `v_employees_hired_after_2000` AS
SELECT `first_name`, `last_name`
FROM `employees`
WHERE YEAR(`hire_date`) > 2000;

SELECT * FROM `v_employees_hired_after_2000`;

-- 9 --
SELECT `first_name`, `last_name`
FROM `employees`
WHERE CHAR_LENGTH(`last_name`) = 5;

-- 10 --
USE `geography`;

SELECT `country_name`, `iso_code`
FROM `countries`
WHERE `country_name` LIKE '%a%a%a%'
ORDER BY `iso_code`;

-- 11--


-- 12 --
-- 13 --
-- 14 --
-- 15 --
-- 16 --