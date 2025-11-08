/*All the cities in a continent organised by largest population to smallest. */
SELECT
  country.Continent AS 'Continent',
  SUM(city.Population) AS 'Population'
FROM city
  JOIN country ON country.Capital = city.ID
GROUP BY country.Continent
ORDER BY SUM(city.Population) DESC;
