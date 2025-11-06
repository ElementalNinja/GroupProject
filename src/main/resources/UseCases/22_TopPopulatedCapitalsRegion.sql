/* Top populated capitals in a region */
SELECT
    city.Name       AS `Capital Name`,
    country.Name    AS `Country`,
    city.Population AS `Population`
FROM country
         JOIN city ON country.Capital = city.ID
WHERE country.Region = 'South America'   -- change region
ORDER BY city.Population DESC
LIMIT 10;  -- change the number as needed
