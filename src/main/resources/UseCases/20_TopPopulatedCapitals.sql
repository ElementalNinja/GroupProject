/* Top populated capitals in the world */
SELECT
    city.Name       AS `Capital Name`,
    country.Name    AS `Country`,
    city.Population AS `Population`
FROM country
         JOIN city ON country.Capital = city.ID
ORDER BY city.Population DESC
LIMIT 10;  -- change the number as needed
