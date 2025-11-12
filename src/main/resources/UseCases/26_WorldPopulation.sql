-- Returns the total population of the world
SELECT
    SUM(country.Population) AS 'World Population'
FROM
    country;