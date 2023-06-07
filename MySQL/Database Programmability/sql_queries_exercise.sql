# 1
USE `soft_uni`;

DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above_35000()
BEGIN 
	SELECT `first_name`, `last_name`
    FROM `employees`
    WHERE `salary` > 35000
    ORDER BY `first_name`, `last_name`, `employee_id`;
END$$

DELIMITER ;
CALL usp_get_employees_salary_above_35000();

# 2
DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above(`min_salary` DECIMAL(19, 4))
BEGIN 
	SELECT `first_name`, `last_name`
    FROM `employees`
    WHERE `salary` >= `min_salary`
    ORDER BY `first_name`, `last_name`, `employee_id`;
END$$

DELIMITER ;
CALL usp_get_employees_salary_above(45000);

# 3
DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with(`starting_string` VARCHAR(50))
BEGIN 
	SELECT `name` AS 'town_name'
    FROM `towns`
    WHERE `name` LIKE CONCAT(`starting_string`, '%')
    ORDER BY `name`;
END$$

DELIMITER ;
CALL usp_get_towns_starting_with('be');

# 4
DELIMITER $$
CREATE PROCEDURE usp_get_employees_from_town(`town_name` VARCHAR(50))
BEGIN 
	SELECT e.`first_name`, e.`last_name`
    FROM `employees` AS e
	JOIN `addresses` AS a ON e.`address_id` =  a.`address_id`
	JOIN `towns` AS t ON a.`town_id` =  t.`town_id`
    WHERE t.`name` = `town_name`
    ORDER BY `first_name`, `last_name`, `employee_id`;
END$$

DELIMITER ;
CALL usp_get_employees_from_town('Sofia');

# 5
DELIMITER $$
CREATE FUNCTION ufn_get_salary_level(`salary` DECIMAL(19, 4))
RETURNS VARCHAR(7)
DETERMINISTIC
BEGIN 
	RETURN (CASE WHEN `salary` < 30000 THEN 'Low'
				 WHEN `salary` BETWEEN 30000 AND 50000 THEN 'Average'
				 ELSE 'High'
			END);
END$$

DELIMITER ;
SELECT 13500.00 AS 'salary', ufn_get_salary_level(13500.00) AS 'salary_level';
SELECT 43300.00 AS 'salary', ufn_get_salary_level(43300.00) AS 'salary_level';
SELECT 125500.00 AS 'salary', ufn_get_salary_level(125500.00) AS 'salary_level';

# 6
DELIMITER $$
CREATE PROCEDURE usp_get_employees_by_salary_level(`salary_level` VARCHAR(7))
BEGIN 
	SELECT e.`first_name`, e.`last_name`
    FROM `employees` AS e
    WHERE 
		CASE WHEN `salary_level` = 'Low' THEN `salary` < 30000 
			 WHEN `salary_level` = 'Average' THEN `salary` BETWEEN 30000 AND 50000 
			 WHEN `salary_level` = 'High' THEN `salary` > 50000 
		END
    ORDER BY `first_name` DESC, `last_name` DESC;
END$$

DELIMITER ;
CALL usp_get_employees_by_salary_level('High');

# 7 - solution 1
DELIMITER $$
CREATE FUNCTION ufn_is_word_comprised(`set_of_letters` VARCHAR(50), `word` VARCHAR(50))
RETURNS BIT
DETERMINISTIC
BEGIN 
	DECLARE `current_letter` CHAR;
	DECLARE `word_letters_count` INT;
    SET `word_letters_count` = LENGTH(`word`);
		
	WHILE `word_letters_count` > 0 DO
		SET `current_letter` = SUBSTRING(`word`, `word_letters_count`, 1);
        IF(`set_of_letters` NOT LIKE CONCAT('%', `current_letter`, '%'))
        THEN RETURN 0;
        END IF;
		SET `word_letters_count` = `word_letters_count` - 1;
    END WHILE;
    RETURN 1;
END$$

# 7 - solution 2
CREATE FUNCTION ufn_is_word_comprised_2(`set_of_letters` VARCHAR(50), `word` VARCHAR(50))
RETURNS BIT
DETERMINISTIC
BEGIN
	RETURN `word` REGEXP CONCAT('^[', `set_of_letters`, ']+$');
END$$

DELIMITER ;
SELECT 'oistmiahf' AS 'set_of_letters', 'Sofia' AS 'word', 
		ufn_is_word_comprised_2('oistmiahf', 'Sofia') AS 'result';
SELECT 'oistmiahf' AS 'set_of_letters', 'halves' AS 'word', 
		ufn_is_word_comprised_2('oistmiahf', 'halves') AS 'result';
SELECT 'bobr' AS 'set_of_letters', 'Rob' AS 'word', 
		ufn_is_word_comprised('bobr', 'Rob') AS 'result';
SELECT 'pppp' AS 'set_of_letters', 'Guy' AS 'word', 
		ufn_is_word_comprised('pppp', 'Guy') AS 'result';

# 8
DELIMITER $$
CREATE PROCEDURE usp_get_holders_full_name()
BEGIN
	SELECT CONCAT(`first_name`, ' ', `last_name`) AS 'full_name'
    FROM `account_holders`
    ORDER BY `full_name`, `id`;
END$$

DELIMITER ;
CALL usp_get_holders_full_name();

# 9
DELIMITER $$
CREATE PROCEDURE usp_get_holders_with_balance_higher_than(`money_input` DECIMAL(19, 4))
BEGIN
	SELECT ah.`first_name`, ah.`last_name`
    FROM `account_holders` AS ah
    JOIN `accounts` AS a ON a.`account_holder_id` = ah.`id`
    GROUP BY a.`account_holder_id`
    HAVING SUM(a.`balance`) > `money_input`
    ORDER BY a.`account_holder_id`;
END$$

DELIMITER ;
CALL usp_get_holders_with_balance_higher_than(7000);

# 10
DELIMITER $$
CREATE FUNCTION ufn_calculate_future_value(`sum` DECIMAL(19, 4), 
										   `yearly_interest_rate` DOUBLE, 
                                           `number_of_years` INT)
RETURNS DECIMAL(19, 4)
DETERMINISTIC
BEGIN
	RETURN `sum`*(POW(1+`yearly_interest_rate`, `number_of_years`));
END$$

DELIMITER ;
SELECT ufn_calculate_future_value(1000, 0.5, 5);

# 11


# 12


# 13


# 14


# 15


# 16

