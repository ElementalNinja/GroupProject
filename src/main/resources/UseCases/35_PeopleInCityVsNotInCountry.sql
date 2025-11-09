/*Population Report  For the population reports, the following information is requested:
The name of the country.
The total population of the country.
The total population of the country living in cities (including a %).
The total population of the country not living in cities (including a %).*/
SELECT
  country.Name AS 'Name',
  SUM(country.Population) AS 'Total Population',
  SUM(city.Population) AS 'City Population',
  CONCAT(ROUND(SUM(city.Population)/Sum(country.Population) * 100),'%') AS 'Percent In City',
  (SUM(country.population)-SUM(city.Population)) AS 'Not in city',
  CONCAT(ROUND((SUM(country.population)-SUM(city.Population))/Sum(country.Population) * 100),'%') AS 'Percent Not In City'
FROM country
  JOIN city ON country.Capital = city.ID
GROUP BY country.Name;
