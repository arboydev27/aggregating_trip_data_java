Overview:
The second part of a multi-project series, this Java project continues working with the GPS trip data by calculating useful metrics. Using the CSV file generated in Project 1, we will extract meaningful information like total distance and average speed over the trip, setting up data for future analysis.

In this project, we define a TripPoint class to represent each recorded GPS data point. The class calculates and aggregates trip details, such as total travel distance and average speed, based on the GPS coordinates (latitude and longitude) stored in the CSV file.

Features:
1. TripPoint Class: Represents individual points with time, latitude, and longitude fields.
2. CSV Data Parsing: Loads GPS data from triplog.csv and stores each point as a TripPoint object.
3. Distance Calculation: Calculates distances between points using the Haversine formula.
4. Metric Calculations:
    - Total Distance: Computes the complete distance covered over the trip.
    - Total Time: Returns the trip's duration in hours.
    - Average Speed: Calculates speed between two points, with flexibility to handle point order.

Core Methods:
1. readFile(String filename): Parses triplog.csv and loads data into an ArrayList of TripPoint objects.
2. haversineDistance(TripPoint a, TripPoint b): Calculates the distance between two points in kilometers.
3. totalDistance(): Computes the overall distance traveled based on all TripPoint entries.
4. avgSpeed(TripPoint a, TripPoint b): Calculates the speed between two points, in kilometers per hour.

Getting Started:
1. Setup: Clone the repository and load triplog.csv along with the project files into your preferred IDE.
2. Run: Execute the methods in the TripPoint class to calculate distance, time, and speed for the trip data.
3. View Results: The calculated metrics will be used in subsequent projects for deeper analysis.