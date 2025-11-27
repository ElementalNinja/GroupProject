/* the number of people who speak the following the following languages from greatest number to smallest, including the percentage of the world population:
Chinese.  English.  Hindi.  Spanish.  Arabic.*/

SELECT
    countrylanguage.Language AS `Language`,
    SUM(country.Population) AS 'People',
    SUM(countrylanguage.Percentage AS 'Percentage'
FROM countrylanguage
JOIN country ON country.Code = countrylanguage.CountryCode
    WHERE countrylanguage.Language = 'Chinese' OR countrylanguage.Language = 'English' OR countrylanguage.Language = 'Hindi' OR countrylanguage.Language = 'Spanish' OR countrylanguage.Language = 'Arabic'
GROUP BY countrylanguage.Language
ORDER BY SUM(countrylanguage.Language) DESC;
