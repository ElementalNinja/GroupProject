/*Population Report  For the population reports, the following information is requested:
The name of the continent/region/country.
The total population of the continent/region/country.
The total population of the continent/region/country living in cities (including a %).
The total population of the continent/region/country not living in cities (including a %).*/
SELECT
  country.Name AS 'Name',
  country.Population AS 'Total Population',
  SUM(city.Population) AS 'City Population', 
  (SUM(county.population)-SUM(coty.Population)) AS 'Not in city'
FROM country
  JOIN city ON country.Capital = city.ID
GROUP BY country.Name;
