# CooperCars: US-16 (add status tag to vehicle, remove by status)
This US marks each vehicle as In-transit, for sale, or sold.
Note: this adds onto SDE-merged-US-15, refer that for functionality
## Functionality:
#### Status shows up on vehicle details page.  
#### WIP: working on remove by status. 
![image1](us-14.png)
## API endpts:
#### http://localhost:8080/api/vehicle/getinfo/{vin} returns info about ONE vehicle
#### http://localhost:8080/api/vehicle/addvehicle adds from front end input
#### http://localhost:8080/api/vehicle/remove/{vin} deletes vehicle by VIN
#### http://localhost:8080/api/vehicle/remove/status/{stat} deletes vehicle by status
#### http://localhost:8080/api/vehicles returns info about ALL vehicles in database
## Next steps:
#### IMP: Secure endpoints (after login is working ofc)!!!!!!!!
#### WIP: Add sorting/filtering by vehicle specification. Reference: https://www.freecodecamp.org/news/search-and-filter-component-in-reactjs/

