-- Returns the population of a specific city

SELECT
    city.Name AS 'City Name',
    city.Population AS 'Population'
FROM
    city
WHERE
    city.Name = 'Minsk'; -- Can be changed to any city if required