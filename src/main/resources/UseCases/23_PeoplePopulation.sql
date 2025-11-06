USE world;

-- People living and not living in the cites

-- Selecting the continent, total population and city population
SELECT
    t.Continent AS 'Continent',
    t.TotalPopulation AS 'Total Population',
    IFNULL(c.CityPopulation, 0) AS 'City Population',
    t.TotalPopulation - IFNULL(c.CityPopulation, 0) AS 'Non-City Population'
FROM (
         SELECT
             Continent,
             SUM(Population) AS TotalPopulation             -- Sum of populations from all countries per continent
         FROM country
         GROUP BY Continent
     ) AS t
         LEFT JOIN (
    SELECT
        country.Continent,
        SUM(city.Population) AS CityPopulation         -- Sum of all city populations per continent
    FROM city
             JOIN country ON city.CountryCode = country.Code
    GROUP BY country.Continent
) AS c
                   ON t.Continent = c.Continent
ORDER BY t.TotalPopulation DESC;