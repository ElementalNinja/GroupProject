SELECT city.Name, Continent, city.Population
FROM country
JOIN city ON country.Capital = city.ID
WHERE country.Continent = 'Europe'
ORDER BY city.Population DESC;