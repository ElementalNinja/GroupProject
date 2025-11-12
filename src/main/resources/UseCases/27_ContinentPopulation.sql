/*The population of a continent*/
SELECT Name, SUM(Population) FROM country
    WHERE Name = "Greece" -- change the name as needed
GROUP BY Name;
