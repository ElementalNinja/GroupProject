/*All the cities in the world organised by largest population to smallest. */
SELECT
  city.population AS 'Population'
FROM city
ORDER BY city.population DESC;
