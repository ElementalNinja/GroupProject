SELECT country.Code, country.Name,
       country.Continent, country.Region,
       country.Population, country.Capital
FROM country
LEFT JOIN city ON country.Capital = city.ID
ORDER BY country.Code