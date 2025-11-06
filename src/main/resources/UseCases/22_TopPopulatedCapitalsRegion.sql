USE world;

-- Top populated capitals in the region

-- Selecting the capitals, countries and population
SELECT
    city.Name AS 'Capital Name',
    country.Name AS 'Country',
    city.Population AS 'Population'
FROM country
         JOIN city ON country.Capital = city.ID
WHERE country.Region = 'South America' -- region should be changed here
ORDER BY city.Population DESC
    LIMIT 10; -- that`s where the number provided by the user be