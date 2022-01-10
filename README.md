# stacja_pogodowa
Projekt na Systemy Wbudowane i Programowanie w języku Java.

W ramach projektu została zrealizowana prosta aplikacja backendowa w Spring Boot wystawiająca dwa trzy endpointy (funkcjonalnie dwa) umożliwiające ściaganie danych z bazy danych, filtrowanie tych danych, jak i wpychanie ich do bazy (razem z prostą walidacją na te dane). Endpointy są chronione przez serwer autoryzacyjny Okta, baza danych to PostgreSQL. Wszystkie jest hostowane na Heroku.

Starano się mniej więcej stosować podejście DDD (Domain-driven Design), rozdzielając w miarę przejrzyście poszczególne elementy aplikacji, co pozwala na jej łatwy dalszy rozwój i skalowalność.

Diagram UML.

<a href="https://ibb.co/vzws14W"><img src="https://i.ibb.co/88KzMgw/stacja-pogodowa-uml.png" alt="stacja-pogodowa-uml" border="0"></a>

[![Stacja pogodowa CI/CD](https://github.com/amkrosa/stacja_pogodowa/actions/workflows/maven.yml/badge.svg?branch=master)](https://github.com/amkrosa/stacja_pogodowa/actions/workflows/maven.yml)

# Swagger UI
https://pk-stacja-pogodowa.herokuapp.com/swagger-ui.html
