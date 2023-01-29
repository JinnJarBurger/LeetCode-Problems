package net.jinnjar.problem1396;

import java.util.HashMap;
import java.util.Map;

/**
 * @author adnan
 * @since 6/1/2023
 */
class UndergroundSystem {

    private final Map<Integer, CheckIn> checkInMap;
    private final Map<String, TravelInfo> travelInfoMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        travelInfoMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckIn checkIn = checkInMap.get(id);
        String startEndStation = checkIn.getStartStation() + " -> " + stationName;
        int timeTaken = t - checkIn.getStartTime();

        if (travelInfoMap.containsKey(startEndStation)) {
            TravelInfo travelInfo = travelInfoMap.get(startEndStation);
            travelInfo.setTotalTime(travelInfo.getTotalTime() + timeTaken);
            travelInfo.setTotalTravels(travelInfo.getTotalTravels() + 1);
        } else {
            travelInfoMap.put(startEndStation, new TravelInfo(timeTaken, 1));
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        TravelInfo travelInfo = travelInfoMap.get(startStation + " -> " + endStation);

        return (double) travelInfo.getTotalTime() / travelInfo.getTotalTravels();
    }
}

class CheckIn {

    private String startStation;
    private int startTime;

    public CheckIn(String startStation, int startTime) {
        this.startStation = startStation;
        this.startTime = startTime;
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }
}

class TravelInfo {

    private int totalTime;
    private int totalTravels;

    public TravelInfo(int totalTime, int totalTravels) {
        this.totalTime = totalTime;
        this.totalTravels = totalTravels;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public int getTotalTravels() {
        return totalTravels;
    }

    public void setTotalTravels(int totalTravels) {
        this.totalTravels = totalTravels;
    }
}
