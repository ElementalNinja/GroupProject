SELECT
    city.District,
    SUM(city.Population) AS 'Total District Population'
FROM
    city
WHERE
    city.District = 'Kabol'
GROUP BY
    city.District;
