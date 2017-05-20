package zhyzhko.tasks.task2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Egor on 20.05.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader Strim = getBufferedReader();

        String line = Strim.readLine();
        int source = Integer.parseInt(line);

        for (int testIndex = 0; testIndex < source; testIndex++) {
            // the number of tests
            String[] citiesIds = new String[10000];// create an array of the condition of the job
            line = Strim.readLine();

            int countCities = Integer.parseInt(line);// read the number of cities
            int matrixSize = countCities + 1; // The problem of indexing the array from 0

            Matrix matrix = new Matrix(matrixSize);

            workWithCities(Strim, citiesIds, countCities, matrix);

            line = Strim.readLine();
            int routesToFind = Integer.parseInt(line);// number of calculated routes

            getDistance(Strim, citiesIds, matrix, routesToFind);
        }
        Strim.close();
    }

    private static void getDistance(BufferedReader strim, String[] citiesIds, Matrix matrix, int routesToFind) throws IOException {
        String line;
        for (int routesIndex = 0; routesIndex < routesToFind; routesIndex++) {
            line = strim.readLine();// reads the path
            String[] cityNames = line.split(" ");
            String start = cityNames[0];
            String destination = cityNames[1];

            List<String> list = new ArrayList<>();

            removeNullElementsFromArray(citiesIds, list);
            citiesIds = list.toArray(new String[list.size()]);

            int startIndex = 0;
            int destinationIndex = 0;
            startIndex = getStartIndex(citiesIds, start, startIndex);
            destinationIndex = getDestinationIndex(citiesIds, destination, destinationIndex);

            Integer[] distancesFromSource = matrix.distancesFrom(startIndex);
            int destinationDistance = distancesFromSource[destinationIndex];

            System.out.println(destinationDistance);
        }
    }

    private static void workWithCities(BufferedReader strim, String[] citiesIds, int countCities, Matrix matrix) throws IOException {
        String line;
        for (int cityIndex = 0; cityIndex < countCities; cityIndex++) {
            line = strim.readLine();// reads the name of the city
            String cityName = line;
            citiesIds[cityIndex] = cityName;// write the name of the city
            line = strim.readLine();// read the next value (the number of neighbors)

            int numberOfNeighbours = Integer.parseInt(line);
            matrixSetEdge(strim, matrix, cityIndex, numberOfNeighbours);
        }
    }

    private static void matrixSetEdge(BufferedReader strim, Matrix matrix, int cityIndex, int numberOfNeighbours) throws IOException {
        String line;
        for (int neighborIndex = 0; neighborIndex < numberOfNeighbours; neighborIndex++) {
            line = strim.readLine();
            String[] brokenLine = line.split(" ");

            int cityToConnect = Integer.parseInt(brokenLine[0]);// Write the code neighbor
            int weightOfConnection = Integer.parseInt(brokenLine[1]);// write the weight of the edge

            matrix.setEdge(cityIndex, cityToConnect, weightOfConnection);
        }
    }

    private static BufferedReader getBufferedReader() throws FileNotFoundException {
        return new BufferedReader(
                new FileReader("input.txt"));
    }

    // remove the null elements from the array before writing to the list
    private static void removeNullElementsFromArray(String[] citiesIds, List<String> list) {
        for (String s : citiesIds) {
            if (s != null) {
                list.add(s);
            }
        }
    }

    // find the index of the initial city
    private static int getStartIndex(String[] citiesIds, String start, int startIndex) {
        for (int i = 0; i < citiesIds.length; i++) {
            if (start.equals(citiesIds[i])) {
                startIndex = i;
                break;
            }
        }
        return startIndex;
    }

    // find the index of the end of the city
    private static int getDestinationIndex(String[] citiesIds, String destination, int destinationIndex) {
        for (int i = 0; i < citiesIds.length; i++) {
            if (destination.equals(citiesIds[i])) {
                destinationIndex = i;
                break;
            }
        }
        return destinationIndex;
    }
}
