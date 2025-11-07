/*All the cities in a region organised by largest population to smallest. */
SELECT
  country.Region AS 'Region',
  SUM(city.Population) AS 'Population'
FROM country
  JOIN city ON country.Capital = city.ID
GROUP BY country.Region
ORDER BY 'Population' DESC;
