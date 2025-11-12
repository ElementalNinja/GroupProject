/* Top populated capitals in a continent */
SELECT
    city.Name       AS `Capital Name`,
    country.Name    AS `Country`,
    city.Population AS `Population`
FROM country
         JOIN city ON country.Capital = city.ID
WHERE country.Continent = 'Europe'   -- change continent
ORDER BY city.Population DESC
LIMIT 10;  -- change the number as needed
