SELECT city.Name, Continent, city.Population
FROM country
JOIN city ON country.Code = city.CountryCode
WHERE country.Continent = 'Asia' 
ORDER BY city.Population DESC
LIMIT 3; --Change value