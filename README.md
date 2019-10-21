# techtest

Dans ce projet, j'ai opté pour les web services REST 
le projet est alimenté par un fichier TSV static que j'ai mis dans src/main/resources.

Pour Build le projet:
   $ mvn clean install

Pour changer de port du serveur => application.properties
	server.port=8081

Pour Run le projet:
   $ mvn spring-boot:run
    
Pour l'appel des webservices: 

$ curl http://localhost:8081/api/v0/points/count?minLat=6.5&minLon=-7
    question: "Calculer le nombre de POIs d'une zone" (avec min_lat=6.5 et min_lon=-7).

$ curl http://localhost:8081/api/v0/zones/density?value=2
    question: "Trouver les n zones les plus denses" (avec n= 2).

$ curl http://localhost:8081/api/v0/zones
    Pour récupérer toutes les zones

$ curl http://localhost:8081/api/v0/points/all
    Pour récupérer tous les points d'intérêt

ToDo:

- unit tests
- secure endpoints
- implement caching
- setup database  

