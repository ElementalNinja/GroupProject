SELECT
    city.District,
    SUM(city.Population) AS 'Total District Population'
FROM
    city
WHERE
    city.District = 'Noord-Holland'
GROUP BY
    city.District;