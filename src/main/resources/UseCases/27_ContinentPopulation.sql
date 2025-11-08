/*The population of a continent*/
SELECT Name, COUNT(Population) FROM country
GROUP BY Name;
