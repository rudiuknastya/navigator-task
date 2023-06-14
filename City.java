package task7;

import java.util.*;

public class City implements Comparable<City>{
    private String name;
    private int distance = Integer.MAX_VALUE;
    private List<City> shortestPath = new LinkedList<>();
    Map<City, Integer> adjacentCities = new HashMap<>();

    public City(String name) {
        this.name = name;
    }

    public void setAdjacentCities(City city, int distance ) {
        adjacentCities.put(city, distance);
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public List<City> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(List<City> shortestPath) {
        this.shortestPath = shortestPath;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(City o) {
        return Integer.compare(this.distance, o.distance);
    }
}
