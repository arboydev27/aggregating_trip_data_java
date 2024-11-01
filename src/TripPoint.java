/**
 * @author Arboy Magomba
 * @version 1.0
 * Project 2
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TripPoint {
	// Instance variables
	private double lat;
	private double lon;
	private int time;
	private static ArrayList<TripPoint> trip = new ArrayList<>();
	
	// Constructors
	public TripPoint(int time, double lat, double lon) {
		this.time = time;
		this.lat = lat;
		this.lon = lon;
	}
	
	// Getters, Setters and Other methods
	public int getTime() {
		return this.time;
	}
	
	public double getLat() {
		return this.lat;
	}
	
	public double getLon() {
		return this.lon;
		
	}
	
	public static ArrayList<TripPoint> getTrip() {
		// Returning a copy instead of original arraylist
		
		ArrayList<TripPoint> copyOfTrip = new ArrayList<>();
	    for (TripPoint point : trip) {
	        copyOfTrip.add(new TripPoint(point.getTime(), point.getLat(), point.getLon()));
	    }
	    return copyOfTrip;
	}
	
	public static double haversineDistance(TripPoint a, TripPoint b) {
		// Calculating distance btn two points on a sphere
		
		double EARTH_RADIUS = 6371; // Radius of earth in km
		
		double lat1 = Math.toRadians(a.getLat());
		double lon1 = Math.toRadians(a.getLon());
		double lat2 = Math.toRadians(b.getLat());
		double lon2 = Math.toRadians(b.getLon());
		double distanceBtnLat = lat2 - lat1;
		double distanceBtnLon = lon2 - lon1;
		
		double a1 = Math.pow(Math.sin(distanceBtnLat / 2), 2) +
                Math.cos(lat1) * Math.cos(lat2) *
                Math.pow(Math.sin(distanceBtnLon / 2), 2);
		double c = 2 * Math.atan2(Math.sqrt(a1), Math.sqrt(1 - a1));

		return EARTH_RADIUS * c;
		
	}
	
	public static double avgSpeed(TripPoint a, TripPoint b) {
		// Computing avg speed btn two points in km/h
		
		double distance = haversineDistance(a, b); // in kilometers
	    double time = Math.abs(b.getTime() - a.getTime()) / 60.0; // convert minutes to hours
	    return distance / time; // speed in kilometers per hour
	}
	
	public static double totalTime() {
		// Return total time of the trip in hours, time column in the data is in minutes
		return trip.get(trip.size() - 1).getTime() / 60.0;
		
	}
	
	public static double totalDistance() {
		// Computing total distance of trip in kms (total distance btn every pint in the trip arraylist
		
		double total = 0.0;
	    for (int i = 0; i < trip.size() - 1; ++i) {
	        total += haversineDistance(trip.get(i), trip.get(i + 1));
	    }
	    return total;
	}
	
	public static void readFile(String filename) throws IOException {
		trip.clear(); // Clear the trip array list everytime the readFile method is called
		
		File file = new File(filename);
        Scanner scanner = new Scanner(file);
        
        if (scanner.hasNextLine()) { // skip the header
            scanner.nextLine();
        }
        while (scanner.hasNextLine()) {
            String newline = scanner.nextLine();
			String[] data = newline.split(",");
			
			TripPoint point = new TripPoint(Integer.parseInt(data[0]), Double.parseDouble(data[1]), Double.parseDouble(data[2]));
			trip.add(point);	
		}
        		
	}
	
}
