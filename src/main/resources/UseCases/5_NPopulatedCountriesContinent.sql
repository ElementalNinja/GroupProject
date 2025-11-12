SELECT country.Name, country.Population, country.Continent
FROM country
WHERE country.Continent = 'Europe' -- Can change this
ORDER BY country.Population DESC
LIMIT 3; -- Can change this