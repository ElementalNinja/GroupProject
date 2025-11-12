-- Population of people, people living in cities, and not living in cities in each country
SELECT
    country.Name AS 'Country',                              -- country name
    country.Population AS 'Total Population',               -- total people in the country
    IFNULL(SUM(city.Population), 0) AS 'City Population',   -- total people living in cities
    country.Population - IFNULL(SUM(city.Population), 0)    -- total people not living in cities
        AS 'Non-City Population'
FROM country
         LEFT JOIN city
                   ON city.CountryCode = country.Code
GROUP BY
    country.Code, country.Name, country.Population          -- group by country
ORDER BY
    country.Population DESC;                                -- biggest first