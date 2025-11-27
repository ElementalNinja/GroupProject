SELECT city.Name, city.District, city.Population
FROM city
WHERE District = 'Quebec'
ORDER BY city.Population DESC
LIMIT 3; --Change value