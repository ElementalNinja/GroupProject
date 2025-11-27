SELECT city.Name, country.Region, city.Population
FROM country
JOIN city ON country.Code = city.CountryCode
WHERE country.Region = 'Caribbean'
ORDER BY city.Population DESC
LIMIT 3; --Change value