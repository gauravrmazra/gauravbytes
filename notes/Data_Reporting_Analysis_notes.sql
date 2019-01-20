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


-- Aggregating functions


-- GROUP BY
SELECT district, count(*) as addresses_per_district
FROM `address`
GROUP BY district
ORDER BY addresses_per_district;

-- HAVING Clause
SELECT district, count(*) as addresses_per_district
FROM `address`
GROUP BY district
HAVING addresses_per_district > 8
ORDER BY addresses_per_district;


-- MAX function
SELECT MAX(rental_duration) max_rental_duration FROM `film`;

-- MIN function
SELECT MIN(rental_duration) min_rental_duration FROM `film`;

-- SUM function
SELECT SUM(rental_duration) sum_of_rental_duration from `film`;

-- AVG function
SELECT rating, avg(rental_duration) as avg_rental_duration
FROM `film`
GROUP BY rating;


-- distinct clause
SELECT DISTINCT district, group_concat(phone) AS customer_phones
FROM address
GROUP BY district;

SELECT DISTINCT district, group_concat(phone ORDER BY phone ASC SEPARATOR ';') AS customer_phones
FROM address
GROUP BY district;

-- Joining tables
SELECT c.first_name, c.last_name, CONCAT(a.address, ' ', a.address2, ' ', a.district) AS ADDRESS 
FROM `customer` AS c 
JOIN `address` AS a
ON c.address_id = a.address_id
WHERE a.district = 'Buenos Aires';

SELECT c.first_name, c.last_name, CONCAT(a.address, ' ', a.address2,' ', a.district, ' ', cty.city, ' ', ctry.country) AS ADDRESS 
FROM `customer` AS c 
JOIN `address` AS a
ON c.address_id = a.address_id
JOIN `city` AS cty
ON a.city_id = cty.city_id
JOIN `country` AS ctry
ON cty.country_id = ctry.country_id
WHERE a.district = 'Buenos Aires';

-- UNION example
SELECT 'actor' as tbl, date(last_update) last_updated FROM `actor`
UNION ALL
SELECT 'address' as tbl, date(last_update) last_updated FROM `address`;

-- IN QUERY on multiple tables
SELECT * FROM `rental`
WHERE customer_id IN (
	SELECT customer_id 
    FROM `customer` 
    WHERE first_name = 'Jennifer'
);