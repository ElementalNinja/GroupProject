USE world;

-- Top populated capitals in the continent

-- Selecting the capitals, countries and population
SELECT
    city.Name AS 'Capital Name',
    country.Name AS 'Country',
    city.Population AS 'Population'
FROM country
         JOIN city ON country.Capital = city.ID
-- Filter by continent name
WHERE country.Continent = 'Europe'
ORDER BY city.Population DESC
LIMIT 10; -- that`s where the number provided by the user be