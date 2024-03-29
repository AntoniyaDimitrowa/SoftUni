USE `soft_uni`;

# 1
SELECT e.`employee_id`, e.`job_title`, e.`address_id`, a.`address_text`
FROM `employees` AS e
JOIN `addresses` AS a 
ON e.`address_id` = a.`address_id`
ORDER BY `address_id`
LIMIT 5;

# 2
SELECT e.`first_name`, e.`last_name`, t.`name` AS 'town', a.`address_text`
FROM `employees` AS e
JOIN `addresses` AS a ON e.`address_id` = a.`address_id`
JOIN `towns` AS t ON a.`town_id` = t.`town_id`
ORDER BY `first_name`, `last_name`
LIMIT 5;

# 3
SELECT e.`employee_id`, e.`first_name`, e.`last_name`, d.`name` AS 'department_name'
FROM `employees` AS e
JOIN `departments` AS d ON e.`department_id` = d.`department_id`
WHERE d.`name` = 'Sales'
ORDER BY e.`employee_id` DESC;

# 4
SELECT e.`employee_id`, e.`first_name`, e.`salary`, d.`name` AS 'department_name'
FROM `employees` AS e
JOIN `departments` AS d ON e.`department_id` = d.`department_id`
WHERE e.`salary` > 15000
ORDER BY d.`department_id` DESC
LIMIT 5;

# 5
SELECT e.`employee_id`, e.`first_name`
FROM `employees` AS e
LEFT JOIN `employees_projects` AS ep ON e.`employee_id` = ep.`employee_id`
WHERE ep.`project_id` IS NULL
ORDER BY e.`employee_id` DESC
LIMIT 3;

# 6
SELECT e.`first_name`, e.`last_name`, e.`hire_date`, d.`name` AS 'dept_name'
FROM `employees` AS e
JOIN `departments` AS d ON e.`department_id` = d.`department_id`
WHERE e.`hire_date` > '1999-01-01'
AND (d.`name` = 'Sales' OR d.`name` = 'Finance')
ORDER BY e.`hire_date`;

# 7
SELECT e.`employee_id`, e.`first_name`, p.`name` AS `project_name`
FROM `employees` AS e
JOIN `employees_projects` AS ep ON e.`employee_id` = ep.`employee_id`
JOIN `projects` AS p ON ep.`project_id` = p.`project_id`
WHERE DATE(p.`start_date`) > '2002-08-13'
AND p.`end_date` IS NULL
ORDER BY e.`first_name`, p.`name`
LIMIT 5;

# 8
SELECT e.`employee_id`, 
		e.`first_name`, 
		(CASE WHEN YEAR(p.`start_date`) >= 2005 THEN NULL
        ELSE p.`name` 
        END) AS 'project_name'
FROM `employees` AS e
JOIN `employees_projects` AS ep ON e.`employee_id` = ep.`employee_id`
JOIN `projects` AS p ON ep.`project_id` = p.`project_id`
WHERE e.`employee_id` = 24
ORDER BY p.`name` ASC;

# 9
SELECT e.`employee_id`, e.`first_name`, e.`manager_id`, em.`first_name` AS 'manager_name'
FROM `employees` AS e
JOIN `employees` AS em ON e.`manager_id` = em.`employee_id`
WHERE e.`manager_id` = 3 OR e.`manager_id` = 7
ORDER BY e.`first_name`;

# 10
SELECT e.`employee_id`, CONCAT_WS(' ', e.`first_name`, e.`last_name`) AS 'employee_name', 
	   CONCAT_WS(' ', em.`first_name`, em.`last_name`) AS 'manager_name',
       d.`name` AS 'department_name'
FROM `employees` AS e
JOIN `employees` AS em ON e.`manager_id` = em.`employee_id`
JOIN `departments` AS d ON e.`department_id` = d.`department_id`
WHERE e.`manager_id` IS NOT NULL
ORDER BY e.`employee_id`
LIMIT 5;

# 11
SELECT MIN(t.`average_salary`) AS `min_average_salary`
FROM (SELECT AVG(`salary`) AS `average_salary`
	  FROM `employees`
      GROUP BY `department_id`) AS t;

# 12
USE `geography`;

SELECT mc.`country_code`, m.`mountain_range`, p.`peak_name`, p.`elevation`
FROM `peaks` AS p
JOIN `mountains` AS m ON p.`mountain_id` = m.`id`
JOIN `mountains_countries` AS mc ON m.`id` = mc.`mountain_id`
WHERE mc.`country_code` = 'BG'
AND p.`elevation` > 2835
ORDER BY p.`elevation` DESC;

# 13
SELECT mc.`country_code`, COUNT(m.`mountain_range`) AS 'mountain_range'
FROM `mountains_countries` AS mc
JOIN `mountains` AS m ON mc.`mountain_id` = m.`id`
WHERE mc.`country_code` IN (SELECT c.`country_code`
							FROM `countries` AS c
                            WHERE c.`country_name` IN ('United States', 'Russia', 'Bulgaria'))
GROUP BY mc.`country_code`
ORDER BY `mountain_range` DESC;

# 14
SELECT c.`country_name`, r.`river_name`
FROM `countries` AS c
LEFT JOIN `countries_rivers` AS cr ON c.`country_code` = cr.`country_code`
LEFT JOIN `rivers` AS r ON cr.`river_id` = r.`id`
WHERE c.`continent_code` = (SELECT `continent_code`
							FROM `continents`
                            WHERE `continent_name` = 'Africa')
ORDER BY c.`country_name`
LIMIT 5;

# 15
SELECT c.`continent_code`, c.`currency_code`, COUNT(*) AS `currency_usage`
FROM `countries` AS c
GROUP BY c.`continent_code`, c.`currency_code`
HAVING `currency_usage` > 1
AND `currency_usage` = (SELECT COUNT(*) AS 'count_of_currencies'
						FROM `countries` co
                        WHERE co.`continent_code` = c.`continent_code`
                        GROUP BY co.`currency_code`
                        ORDER BY `count_of_currencies` DESC
                        LIMIT 1)
ORDER BY c.`continent_code`, c.`currency_code`;

# 16
SELECT COUNT(c.`country_code`) AS 'country_count'
FROM `countries` AS c
WHERE c.`country_code` NOT IN (SELECT `country_code`
							   FROM `mountains_countries`);

# 17
SELECT c.`country_name`, 
	   MAX(p.`elevation`) AS 'highest_peak_elevation' ,
       MAX(r.`length`) AS 'longest_river_length'
FROM `countries` AS c
LEFT JOIN `countries_rivers` AS cr ON c.`country_code` = cr.`country_code` 
LEFT JOIN `rivers` AS r ON cr.`river_id` = r.`id` 
LEFT JOIN `mountains_countries` AS mc ON c.`country_code` = mc.`country_code` 
LEFT JOIN `peaks` AS p ON mc.`mountain_id` = p.`mountain_id` 
GROUP BY c.`country_code`
ORDER BY `highest_peak_elevation` DESC, `longest_river_length` DESC, `country_name`
LIMIT 5;