/* the number of people who speak the following the following languages from greatest number to smallest, including the percentage of the world population:
Chinese.  English.  Hindi.  Spanish.  Arabic.*/

SELECT
    countrylanguage.Language AS `Language`,
    COUNT(countrylanguage.Language) AS 'People',
    CONCAT(ROUND((COUNT(countrylanguage.Language)/COUNT(country.population)*100), 2), '%')
FROM countrylanguage
INNER JOIN country on countrylanguage.CountryCode = country.Code
    WHERE countrylanguage.Language = 'Chinese' OR countrylanguage.Language = 'English' OR countrylanguage.Language = 'Hindi' OR countrylanguage.Language = 'Spanish' OR countrylanguage.Language = 'Arabic'
GROUP BY countrylanguage.Language
ORDER BY SUM(countrylanguage.Language) DESC;
