SELECT country.Name, country.Population
FROM country
WHERE Continent = 'Europe'
ORDER BY country.Population DESC;