SELECT country.Code, country.Name,
       country.Continent, country.Region,
       country.Population, city.Name
FROM country
LEFT JOIN city ON country.Capital = city.ID

ORDER BY country.Code
