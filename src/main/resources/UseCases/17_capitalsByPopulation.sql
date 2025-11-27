SELECT city.Name AS Capital, country.Name AS CountryName, city.Population
FROM country
JOIN city ON country.Capital = city.ID
ORDER BY city.Population DESC;