package task7;

import java.util.*;

public class Navigator {
    private List<City> cities = new ArrayList<>();
    public void shortestPath(City startCity) {
        startCity.setDistance(0);
        Set<City> visited = new HashSet<>();
        Queue<City> unvisited = new PriorityQueue<>();
        unvisited.add(startCity);
        while (!unvisited.isEmpty()) {
            City currentCity = unvisited.remove();
            for (Map.Entry<City, Integer> adjacentCity : currentCity.adjacentCities.entrySet()) {
                City city = adjacentCity.getKey();
                int weight = adjacentCity.getValue();
                if (!visited.contains(city)) {
                    сalculateMinimumDistance(city, weight, currentCity);
                    unvisited.add(city);
                }
            }
            visited.add(currentCity);
        }
    }

    private void сalculateMinimumDistance(City adjacentCity, int weigh, City currentCity) {
        int currentCityDistance = currentCity.getDistance();
        if (currentCityDistance + weigh < adjacentCity.getDistance()) {
            adjacentCity.setDistance(currentCityDistance + weigh);
            List<City> shortestPath = new LinkedList<>(currentCity.getShortestPath());
            shortestPath.add(currentCity);
            adjacentCity.setShortestPath(shortestPath);
        }
    }

    public void findPath(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter city you wanna go to: ");
        String cityName = scanner.nextLine();
        createCities();
        shortestPath(cities.get(0));
        City cityToGo = null;
        for(City city: cities){
            if(city.getName().equals(cityName)){
                cityToGo = city;
            }
        }
        List<City> shortestPath = new LinkedList<>(cityToGo.getShortestPath());
        for(City city: shortestPath){
            System.out.print(city.getName()+ " -> ");
        }
        System.out.print(cityToGo.getName() + "  distance: "+ cityToGo.getDistance());
    }
    private void createCities() {
        City odesa = new City("Odesa");
        cities.add(odesa);
        City uman = new City("Uman");
        cities.add(uman);
        City kyiv = new City("Kyiv");
        cities.add(kyiv);
        City mykolayiv = new City("Mykolayiv");
        cities.add(mykolayiv);
        City kherson = new City("Kherson");
        cities.add(kherson);
        City kryvyiRih = new City("Kryvyi Rih");
        cities.add(kryvyiRih);
        City kropyvnytskyi = new City("Kropyvnytskyi");
        cities.add(kropyvnytskyi);
        City dnipro = new City("Dnipro");
        cities.add(dnipro);
        City poltava = new City("Poltava");
        cities.add(poltava);
        City kharkiv = new City("Kharkiv");
        cities.add(kharkiv);
        City sumy = new City("Sumy");
        cities.add(sumy);
        City vinnytsya = new City("Vinnytsya");
        cities.add(vinnytsya);
        City zhytomyr = new City("Zhytomyr");
        cities.add(zhytomyr);
        City khmelnytskyi = new City("Khmelnytskyi");
        cities.add(khmelnytskyi);
        City ternopil = new City("Ternopil");
        cities.add(ternopil);
        City rivne = new City("Rivne");
        cities.add(rivne);
        City lviv = new City("Lviv");
        cities.add(lviv);
        odesa.setAdjacentCities(uman, 271);
        odesa.setAdjacentCities(mykolayiv, 132);
        mykolayiv.setAdjacentCities(kherson, 71);
        mykolayiv.setAdjacentCities(kryvyiRih, 204);
        kryvyiRih.setAdjacentCities(dnipro, 146);
        dnipro.setAdjacentCities(kharkiv, 216);
        kharkiv.setAdjacentCities(sumy, 183);
        uman.setAdjacentCities(kropyvnytskyi, 167);
        uman.setAdjacentCities(kyiv, 212);
        uman.setAdjacentCities(vinnytsya, 160);
        kropyvnytskyi.setAdjacentCities(kryvyiRih, 119);
        kropyvnytskyi.setAdjacentCities(dnipro, 245);
        kyiv.setAdjacentCities(poltava, 342);
        kyiv.setAdjacentCities(zhytomyr, 140);
        vinnytsya.setAdjacentCities(khmelnytskyi, 122);
        khmelnytskyi.setAdjacentCities(ternopil, 111);
        ternopil.setAdjacentCities(lviv, 127);
        ternopil.setAdjacentCities(rivne, 159);
        zhytomyr.setAdjacentCities(rivne, 188);
        rivne.setAdjacentCities(lviv, 121);
        poltava.setAdjacentCities(kharkiv, 143);
    }

}
