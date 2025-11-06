USE world;

-- All capital cities in a region, ordered by population (largest to smallest)

-- Selecting the capital cities, countries and population
SELECT
    city.Name    AS 'Capital Name',
        country.Name AS 'Country',
        city.Population AS 'Population'
-- Matching capital to the city ID
FROM country
         JOIN city ON country.Capital = city.ID
WHERE country.Region = 'Western Europe' -- region should be changed here
ORDER BY city.Population DESC;