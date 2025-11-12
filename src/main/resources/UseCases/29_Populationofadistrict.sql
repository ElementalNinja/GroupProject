SELECT city.District, country.Population
FROM city JOIN country ON city.name = country.name
WHERE city.District = "*";


