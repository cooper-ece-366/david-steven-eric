# CooperCars: US-12 - re-organized directory structure, implemented remove from database
## Note: mySql command: create database coopercars; (do this before running)
## Refer to US-10 for current functionality. 
## Backend:
#### http://localhost:8080/api/vehicle/getinfo returns info about ONE vehicle
#### http://localhost:8080/api/vehicle/addvehicle adds from front end input
#### http://localhost:8080/api/vehicle/remove/{vin} deletes vehicle by VIN
#### http://localhost:8080/api/vehicles returns info about ALL vehicles in database
## Next steps:
#### DONE: Save date/time when vehicle was added.
#### DONE: Since vehicles are now store in mySQL database with VINs as the 'key', it won't add the same vehicle twice to database.
#### Note: Attempted to pull down first image from Google Search... ok reliability, but image is "encrypted (ie: supppper compressed)"
#### WIP: Social login. Seperate platforms for dealer/consumer.
#### WIP: Add sorting/filtering by vehicle specification. Reference: https://www.freecodecamp.org/news/search-and-filter-component-in-reactjs/
#### NEXT SPRINT: delete vehicle from database
#### NEXT SPRINT: allow user to upload a spreadsheet to add vehicles.

