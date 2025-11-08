/* the number of people who speak the following the following languages from greatest number to smallest, including the percentage of the world population:
Chinese.  English.  Hindi.  Spanish.  Arabic.*/
SELECT
    Language,
    SUM(Language),
    ROUND((SUM(Language)/SUM(country.Population) *100, 2)) AS 'People'
FROM countrylanguage
  JOIN country ON countryCode=Code
GROUP BY Language
ORDER BY 'People' DESC;
