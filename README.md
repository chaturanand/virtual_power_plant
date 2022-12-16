# virtual_power_plant
This is a repo of virtual power plant system for aggregating distributed power sources into a single cloud based energy provider

# Tool and Library are

* Java
* Spring Boot
* Rest API
* Memory Database (H2)
* Junit Testing
* Sonar Cube implemtation


# Project setup
project is setup from https://start.spring.io/


## API Request and response is

1. Create the list of battery

curl --location --request POST 'localhost:8082/api/v1/batteries' \
--header 'Content-Type: application/json' \
--data-raw '{
"name": "Akunda Bay",
"postcode": "2084",
"capacity":  13500
}'


Response:
![image](https://user-images.githubusercontent.com/13887312/208163070-895baba4-e03c-4c76-a3ac-bc52106f8c11.png)


2. Get the list of battery and order of sorting alphabettically
curl --location --request GET 
'localhost:8082/api/v1/batteries'

Response is:

![image](https://user-images.githubusercontent.com/13887312/208163453-08cbbc53-e5cc-4f07-9c71-1b51d17188af.png)


3. statistics Data of  batteries including total and average watt capacity.
 curl --location --request GET
'localhost:8082/api/v1/batteries/statistics'

Response is:

![image](https://user-images.githubusercontent.com/13887312/208164304-b3188530-f4e3-4d33-8c9d-334b953cdaf8.png)






  


