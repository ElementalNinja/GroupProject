-- Capital City Report
-- Shows every capital city in the world with its country and population

SELECT
    city.Name AS 'Capital Name',
    country.Name AS 'Country',
    city.Population AS 'Population'
FROM country
JOIN city
    ON country.Capital = city.ID
ORDER BY city.Population DESC;