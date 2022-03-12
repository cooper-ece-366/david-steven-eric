# Basic Java-only proof-of-concept application.
## Key functionalities are working:
1. **Vehicle**: class for a single vehicle in inventory with all its attributes, getters/setters.
2. **Vehicles**: class for all the vehicles in inventory, held in an ArrayList. Working on functions such as sorting by
   price, filtering by certain features, etc.
3. **VehiclesDataBuilder**: user enters a VIN, service grabs info from NHTSA's online source and puts it in our database
   (vehiclesDatabase.csv). Multiple vehicles can be added continuously since the service keeps prompting the user until
   he/she types "stop". Exception detection: if VIN is invalid, notify user.
4. **VehiclesDataReader**: reads from a database (vehiclesDatabase.csv) and creates a new Vehicles object. 
