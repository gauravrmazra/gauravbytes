-- ACTOR not `penelope`
SELECT first_name, last_name 
FROM `actor`
WHERE first_name <> 'penelope';

-- AND example
SELECT first_name, last_name
FROM `actor`
WHERE actor_id < 5 AND actor_id > 3;

-- Between example
SELECT first_name, last_name
FROM `actor`
WHERE actor_id BETWEEN 3 AND 5;

-- and/or combined
SELECT first_name, last_name
FROM `actor`
WHERE actor_id < 5 OR first_name = 'penelope';

-- IN example
SELECT first_name, last_name
FROM `actor`
WHERE first_name IN ('penelope', 'nick', 'ed', 'jennifer');

-- Wildcard search
SELECT * FROM `actor`
WHERE first_name LIKE 'JOHN%';

SELECT * FROM `actor` 
WHERE first_name LIKE 'JA%NE';

-- AND and or combined queries
SELECT * FROM `address`
WHERE district = 'Buenos Aires'
AND (address LIKE '%EL' OR address LIKE '%AL%');

-- This is different then the previous 
-- bracket changes the meaning
SELECT * FROM `address`
WHERE district = 'Buenos Aires'
AND address LIKE '%EL' OR address LIKE '%AL%';

-- ORDER BY clause
SELECT first_name, last_name 
FROM `actor`
WHERE first_name = 'penelope'
ORDER BY last_name ASC;

SELECT first_name, last_name 
FROM `actor`
WHERE first_name = 'penelope'
ORDER BY last_name DESC;


-- in-built functions
SELECT first_name, length(first_name) l_first_name
FROM `actor`;

SELECT concat (first_name, ' ', last_name) AS full_name,
length(concat (first_name, ' ', last_name) ) as LEN_OF_FN
FROM `actor` ORDER BY LEN_OF_FN;

-- Capatilize in MySQL
SELECT CONCAT(LEFT(first_name, 1), LOWER(RIGHT(first_name, LENGTH(first_name) - 1))) as first_name
FROM `actor`;

SELECT CONCAT(SUBSTRING(first_name, 1, 1), LOWER(SUBSTRING(first_name, 2))) as first_name
FROM `actor`;

SELECT description, TRIM(LEADING 'A ' FROM description)
FROM `film_text`;

SELECT first_name, LOCATE('lope', first_name) as located_at
FROM `actor`;

SELECT first_name, LOCATE('lope', first_name) as located_at
FROM `actor` where LOCATE('lope', first_name) > 0;












