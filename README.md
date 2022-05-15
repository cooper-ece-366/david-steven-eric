# CooperCars: Vehicle Inventory Management Solution for Small Independent Car Dealers
### ECE366: Software Engineering & Large Systems Design 
### Professor R. Marano
### David Guo, Steven Joongyeon Cho, Eric Xu

## Introduction
- Our solution provides the dealer with valuable information about vehicles available in inventory and is designed as a tool for the dealer to use when consulting with a potential customer.
- The dealer will add vehicles to inventory by **uploading a spreadsheet** with VIN and pertaining information.
- Data and image of vehicle is pulled from **online sources** and presented in its own landing page.
- Solution is designed for a **dealer to reference** when consulting with a client. The dealer employee can look up vehicles on his/her computer and show the client results from the application. 

## Features
- Dealer **logins** to access the application. This ensures an unauthorized third party cannot access inventory information. 
- **Easy-to-use** interface to view inventory. 
- Quickly **filter and sort** vehicles based on feature interest (**safety features, vehicle type, fuel source**). 
- View **detailed specs**, **sales information**, and **pictures** of each vehicle. 
- Easily **upload a spreadsheet** to batch add to inventory (designed to work well with dealer’s **existing workflows**). 
- Remove from inventory based on **sales status** or via **spreadsheet**.

## Purpose and Business Outcomes 
- Dealers may carry **hundreds of vehicles** of different makes and models. 
- Our inventory management solution targets small car dealers that only uses an **Excel spreadsheet or basic database software** (Microsoft Access) to manage their inventory.
- Solution streamlines a car dealer’s workflow, allowing them to focus on things **other than mundane inventory management**.
- [**According to Consumer Reports:**](https://www.consumerreports.org/car-safety/car-safety-survey-new-car-buyers-want-advanced-safety-not-automation/) “In a national survey of U.S. drivers planning on buying a new or used vehicle in the next two years, 51 percent said it was important that their next car have a rearview camera or backup warning, and 45 percent said they wanted a blind-spot warning system.”
- Our solution allows the dealer to **quickly understand** which vehicles in their inventory have these safety features and meet this crucial **consumer need**.

## How to run from scratch (on IntelliJ)
1) Clone our repo from Github. 
2) Go to `./coopercars-service/src/main/java/RestApiServer`.
3) Ensure JDK 17.0 is installed, then build RestApiServer.
4) Check configuration settings to run RestAPIServer:
   ![image1](imgs/restapi_config.png)
   NOTE: This application uses port 3000 and 8080. Ensure these ports are not already in use.
5) Ensure [npm](https://docs.npmjs.com/downloading-and-installing-node-js-and-npm) is installed on your machine.
6) Go to terminal in IntelliJ, change directory into `./coopercars-app`, and run the following: `npm i react-select`, `npm i xlsx`, `npm install @mui/system @emotion/react @emotion/styled`.<br>
   NOTE: If an issue occurs, try deleting ./coopercars-app/node_modules and running with the `--force` tag.
7) Then, run: `npm install`.<br>
   NOTE: If an issue occurs, try deleting ./coopercars-app/node_modules and running `npm install --force` again.
8) Run: `npm start`.<br>
   NOTE: If you run into an issue with starting, try deleting `"proxy": "http://localhost:5000"` in `./coopercars-app/package.json`.
9) ENJOY!<br>
   ADDITIONAL NOTE: The backend database is running on an already configured Amazon RDS server, no additional action is needed to set this up.<br>
   In the case you would like the database to be local, head to `./coopercars-service/src/main/resources/application.yml` and change the datasource to your mySQL server credentials. 

## How-To Guide
- Upon visiting http://localhost:3000/, the only visible tab is the Login tab.
- You must login to access the application. This is to ensure that a car dealer's critical inventory information will not get into the hands of bad actors.
  ![image1](imgs/login.png)
- Once you login, you will have full access to the application.
  ![home](imgs/home.png)
- Starting with the `Browse Vehicles` tab, there are three different ways to sort/filter the cars that are presented.
    1) Filter results by typing in the Make or Model of the car (for example: `Corolla` or `Toyota`)
       ![home](imgs/toyota.png)
    2) Sort by a certain parameter such as Dealer Price, Sale Price, Profit, Mileage, Year, etc.
       ![home](imgs/sortby.png)
    3) Filter by specifications such as Type, Body, Make, Fuel Type, etc. Click on the dropdown to select a specific option.
       ![home](imgs/filterby.png)
    4) Filter by multiple safety features such as backup camera, blind spot monitor, etc by clicking on the checkbox within the dropdown menu.
       ![home](imgs/filterbysafety.png)
- Each vehicle card in the `Browse Vehicles` tab is linked to its own landing page. Click on it to view more details about that specific vehicle.
  ![home](imgs/vehicleDetails1.png)
- The `Add/Update Vehicles` tab is quite self-explanatory: you can choose to upload a spreadsheet (column parameters are defined in the next section), or manually enter details of the vehicle to add to inventory.
  ![home](imgs/addVehicle.png)
- The `Remove Vehicles` tab is also quite self-explanatory: you can choose to upload a spreadsheet with VINs, enter a VIN to directly remove from inventory, or select a Status (ie: Sold, For Sale, In-transit) to batch remove from inventory.
  ![home](imgs/removeVehicle.png)  

## Format for spreadsheets used to batch add/remove vehicles
**Add:** Columns are VIN, Dealer Price, Sale Price, Mileage, Status (Sold, For sale, In-transit).
![image1](imgs/add_xlsx_example.png)<br>
**Remove:** Only a list of VINs. <br>
![image2](imgs/remove_xlsx_example.png)<br>


## Spreadsheets to test application
**_There are spreadsheets attached to this repo (under the `spreadsheets` directory) to test the application._<br>**

**Name:** `sampleSpreadsheet.xlsx`<br>
**Purpose:** Test adding vehicles with a variety of 70 different vehicles. These VINs came from actual cars for sale by dealers across the U.S.!<br>

**Name:** `sampleSpreadsheet2.xlsx`<br>
**Purpose:** Test adding vehicles with another set of 70 different vehicles. These VINs came from actual cars for sale by dealers across the U.S.!<br>

**Name:** `sampleSpreadsheetMaster.xlsx`<br>
**Purpose:** Test adding vehicles with a master set of 140 vehicles (two 70s merged together). These VINs came from actual cars for sale by dealers across the U.S.!<br>

**Name:** `sampleSpreadsheetTest.xlsx`<br>
**Purpose:** Test adding vehicles with a test set of 20 vehicles (used for debugging).<br>

**Name:** `sampleSpreadsheet1000.xlsx`<br>
**Purpose:** A stress test for adding vehicles with 1000 vehicles. VINs were randomly generated using a [Python script](https://replit.com/@exu4630/RandomVINGenerator) (since these VINs were randomly generated, many vehicles are not consumer vehicles and therefore this file is more for stress-testing the backend because the filtering/sorting with these random vehicles isn't too representative of what a dealer would typically have).<br>

**Name:** `sampleRemoveSpreadsheet.xlsx`<br> 
**Purpose:** Test remove vehicles with a set of 44 VINs that were in `sampleSpreadsheet.xlsx`, `sampleSpreadsheetMaster.xlsx`, and `sampleSpreadsheet1000.xlsx`.<br>

## Overall Architecture
![image1](imgs/overall_arch.png)

## UML of Vehicle Backend
![image1](imgs/backend_vehicles_scope.png)

## Description of Vehicle Backend
- **VehicleAPI** class takes the VIN, status, dealer/sale price, and mileage from the front-end. 
- Using the **VIN**, **VehicleAPI** calls **NHTSA's** VIN decoder tool, which returns a .csv file (below is an example for given VIN)
  ![image1](imgs/example_nhtsa.png)
- **VehicleAPI** parses the csv file:
  1) Checks that there is **no error code** returned.
  2) Creates an **array** with the **features (ie: "Element" column)** of interest.
  3) Matches **elements of that array** with **each row of "Element"**, then **parses the value** into another array.
  4) Creates a **Vehicle** class with those attributes from the aforementioned array.
- **Vehicle** class created from **VehicleAPI** class contains VIN, status, dealer/sale price, and mileage, which were parameters for VehicleAPI, and also has attributes of features and specifications pulled from **NHTSA's VIN decoder tool** from the VehicleAPI class.

## Design Choices and Justifications
- This solution is intended for small, independent car dealers with an expected average of 50-100 vehicles in the inventory.
- We conducted most of our testing with 140 vehicles in the inventory and performance was great:
    1) Less than a second to load `Browse Vehicles`, less than a second to search, filter, sort.
    2) Approximately less than 5 seconds to add all vehicles, less than a second to remove all vehicles.
- We conducted a stress test of 1000 vehicles (an extreme case)
    1) Approximately two seconds to load `Browse Vehicles`, approximately one second to seach, filter, sort.
    2) Approximately 8 seconds to add all vehicles to inventory, approximately five seconds to remove all vehicles.
- The decision was made to push all the vehicles in inventory on the `Browse Vehicles` because a small car dealer with 50-100 cars would be better off being able to sort and filter through all the vehicles in the inventory as opposed to going through multiple pages. 

## Images of Application
![image1](imgs/addVehicle.png)
![image2](imgs/removeVehicle.png)
![image3](imgs/browseVehicle.png)
![image4](imgs/vehicleDetails1.png)
![image5](imgs/vehicleDetails2.png)







