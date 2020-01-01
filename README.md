# JavaCarAppBackEnd
This repository contains the back end APIs written for an assignment from RHKDHV to design a car management application. This has APIs to add a new car in the repository, fetch the cars from the repository based on brand and price , fetch all cars from the repository, get the cars based on lowest annual cost.

This is a Maven Spring boot application. 

Steps to run :
1. Clone the project https://github.com/dixitank/JavaCarAppBackEnd.git
2. Make sure maven is installed on your machine . 
3. go to the project location where the project is cloned .
4. Run mvn clean install which will create a war file in the project_location/target directory .
5. Run the war file afrom the project location as:
   java -jar target/car-rest-service-0.0.1-SNAPSHOT.jar
6. This will start the spring boot application .

Now, following steps can be performed to test the APIs : 

To add new cars , following APIs to be used : 
  curl -X POST http://localhost:8080/cars -H 'Content-type:application/json' -d '{"model": "Focus", "brand": "Ford", "version": "2.0 GLX", "yearOfRelease": 2019, "price": 18000,
	"fuelConsumption": 11, "annualMaintenanceCost": 6000}'
  
  curl -X POST http://localhost:8080/cars -H 'Content-type:application/json' -d '{"model": "Fusion", "brand": "Ford", "version": "Hybrid SE", "yearOfRelease": 2019, "price": 23000,
	"fuelConsumption": 9.5, "annualMaintenanceCost": 9000}'

	curl -X POST http://localhost:8080/cars -H 'Content-type:application/json' -d '{"model": "C3", "brand": "Citroen", "version": "1.6", "yearOfRelease": 2018, "price": 15000,
	"fuelConsumption": 13, "annualMaintenanceCost": 6000}'

	curl -X POST http://localhost:8080/cars -H 'Content-type:application/json' -d '{"model": "Honda", "brand": "Civic", "version": "1.8 ELX", "yearOfRelease": 2019, "price": 18.500,
	"fuelConsumption": 12, "annualMaintenanceCost": 7500}'

	curl -X POST http://localhost:8080/cars -H 'Content-type:application/json' -d '{"model": "Corolla", "brand": "Toyota", "version": "1.8 GLX", "yearOfRelease": 2019, "price": 18.500,
	"fuelConsumption": 12.5, "annualMaintenanceCost": 7900}'

	curl -X POST http://localhost:8080/cars -H 'Content-type:application/json' -d '{"model": "Fit", "brand": "Honda", "version": "1.5", "yearOfRelease": 2018, "price": 14.500,
	"fuelConsumption": 14, "annualMaintenanceCost": 6850}'

	curl -X POST http://localhost:8080/cars -H 'Content-type:application/json' -d '{"model": "Yaris", "brand": "Toyota", "version": "1.5 L", "yearOfRelease": 2019, "price": 15600,
	"fuelConsumption": 13, "annualMaintenanceCost": 5900}'

	curl -X POST http://localhost:8080/cars -H 'Content-type:application/json' -d '{"model": "Focus", "brand": "Ford", "version": "1.6 GL", "yearOfRelease": 2019, "price": 15900,
	"fuelConsumption": 13, "annualMaintenanceCost": 5400}'  
  
 To fetch all cars: 
 curl -X GET 'http://localhost:8080/cars'
 
 To fetch cars by year of release and brand: 
 curl -X GET 'http://localhost:8080/cars?yearOfRelease=2019&brand=Ford'
 
 To fetch cars by year of release: 
 curl -X GET 'http://localhost:8080/cars?yearOfRelease=2019&brand='
 curl -X GET 'http://localhost:8080/cars?yearOfRelease=2019'
 
 To fetch cars by brand:
 curl -X GET 'http://localhost:8080/cars?yearOfRelease=&brand=Ford'
 curl -X GET 'http://localhost:8080/cars?brand=Ford'
 
 
 To fetch cars by annual maintenance cost, we will be passing expected distance to travel each month and the price of fuel per litre,
 curl -X GET 'http://localhost:8080/cars/250/0.66'
 This will return us the list of cars in ascending ranking of total annual cost (lowest being returned the first)
