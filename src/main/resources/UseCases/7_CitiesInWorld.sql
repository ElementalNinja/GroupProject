/*All the cities in the world organised by largest population to smallest. */
SELECT
  city.Name As 'City',
  city.Population AS 'Population'
FROM city
ORDER BY 'Population' DESC;
