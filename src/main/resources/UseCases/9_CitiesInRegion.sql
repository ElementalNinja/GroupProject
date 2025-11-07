/*All the cities in a region organised by largest population to smallest. */
SELECT
  country.Region AS 'Region'
  city.Population AS 'Population'
FROM country
  JOIN city ON country.Capital = city.ID
GROUP BY country.Region, city.Population
ORDER BY 'Population' DESC;
