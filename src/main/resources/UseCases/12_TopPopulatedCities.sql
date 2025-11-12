/* The top N populated cities in the world where N is provided by the user.*/
SELECT
    city.Name As `City`,
    city.Population AS `Population`
FROM city
ORDER BY city.Population DESC
LIMIT 10;  -- change the number as needed
