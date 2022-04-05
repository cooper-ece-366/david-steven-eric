# CooperCars: US-7 - merged all of our changes
## Current Functionality:
#### 'Add Vehicles' page: User enters a VIN, dealer/sale price. Vehicle details are added to CSV database and info presented.
![image1](us-8.png)
#### 'Browse Vehicles' page: Reads all the vehicles in the CSV database. Filter by Make currently working.
![image1](us-11.png)
## Backend:
#### http://localhost:8080/api/vehicle/{vin}/{dealerPrice}/{salePrice} returns info about ONE vehicle, passes to back end price info from front end.
#### http://localhost:8080/api/vehicles returns info about ALL vehicles in database
## Next steps:
#### DONE: When adding a vehicle, prompt for sale price and dealer price
#### WIP: Social login. Seperate platforms for dealer/consumer.
#### WIP: Add sorting/filtering by vehicle specification. Reference: https://www.freecodecamp.org/news/search-and-filter-component-in-reactjs/
#### NEXT SPRINT: CSV database to SQL :-)
#### NEXT SPRINT: delete vehicle from database

