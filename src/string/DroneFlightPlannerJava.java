package string;


import java.io.*;
        import java.util.*;

class  DroneFlightPlannerJava {

    static int calcDroneMinEnergy(int[][] route) {
        if (route == null || route.length == 0) {
            return 0;
        }

        int startZ = route[0][2];
        int maxZ = startZ;

        // Iterate through the route to find the peak altitude
        for (int i = 1; i < route.length; i++) {
            if (route[i][2] > maxZ) {
                maxZ = route[i][2];
            }
        }

        // The required energy is the difference between the max altitude and start altitude.
        // We use Math.max to ensure we don't return a negative number if the drone only descends.
        return Math.max(0, maxZ - startZ);
    }
    // your code goes here


    public static void main(String[] args) {
        int[][] route = {
                {0,   2, 10},
                {3,   5,  0},
                {9,  20,  6},
                {10, 12, 15},
                {10, 10,  8}
        };

        int minEnergy = calcDroneMinEnergy(route);
        System.out.println("Minimum energy required: " + minEnergy); // Expected output: 5
    }
}
