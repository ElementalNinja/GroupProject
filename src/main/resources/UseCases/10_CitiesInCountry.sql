/*All the cities in a country organised by largest population to smallest*/
SELECT
  country.Name AS 'Country',
  SUM(city.Population) AS 'Population'
FROM city
  JOIN country ON country.Capital = city.ID
GROUP BY country.Name
ORDER BY SUM(city.Population) DESC;
