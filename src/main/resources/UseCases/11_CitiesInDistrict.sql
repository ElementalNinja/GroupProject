/*All the cities in a district organised by largest population to smallest.*/
SELECT
  city.District AS 'District',
  SUM(city.Population) AS 'Population'
FROM city
GROUP BY city.District
ORDER BY SUM(city.Population) DESC;
