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
SELECT e.`employee_id`, e.`first_name`, p.`name` AS 'project_name'
FROM `employees` AS e
JOIN `employees_projects` AS ep ON e.`employee_id` = ep.`employee_id`
JOIN `projects` AS p ON ep.`project_id` = p.`project_id`
WHERE p.`start_date` > '2002-08-13'
AND p.`end_date` IS NULL
ORDER BY e.`first_name`, p.`name`
LIMIT 5;

# 8
SELECT e.`employee_id`, e.`first_name`, p.`name` AS 'project_name', p.`start_date`, p.`end_date`
FROM `employees` AS e
JOIN `employees_projects` AS ep ON e.`employee_id` = ep.`employee_id`
JOIN `projects` AS p ON ep.`project_id` = p.`project_id`
WHERE DATE(p.`start_date`) > '2002-08-13'
AND p.`end_date` IS NULL
ORDER BY e.`first_name`ASC, p.`name` ASC
LIMIT 10;

SELECT 
    e.`employee_id`, e.`first_name`, p.`name` AS `project_name`
FROM
    `employees` AS e
        JOIN
    `employees_projects` AS ep ON e.`employee_id` = ep.`employee_id`
        JOIN
    `projects` AS p ON ep.`project_id` = p.`project_id`
WHERE
    DATE(p.`start_date`) > '2002-08-13'
        AND p.`end_date` IS NULL
ORDER BY e.`first_name` ASC , p.`name` ASC
LIMIT 5;

# 9


# 10


# 11


# 12


# 13


# 14


# 15


# 16


# 17

