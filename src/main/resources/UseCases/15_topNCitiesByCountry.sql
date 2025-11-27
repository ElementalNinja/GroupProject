SELECT city.Name, city.Population, country.Name AS CountryName
FROM country
JOIN city ON country.Code = city.CountryCode
WHERE country.Name = 'Canada'
ORDER BY city.Population DESC
LIMIT 3; --Change value