package string;

public class DroneFlightPlanner {
    public static int calcDroneMinEnergySimulation(int[][] route) {
        if (route == null || route.length == 0) {
            return 0;
        }

        int currentEnergy = 0;      // Represents our running energy balance
        int minEnergyLevel = 0;     // Tracks the lowest point our balance reaches

        // Start checking from the second point (index 1)
        for (int i = 1; i < route.length; i++) {

            // Calculate altitude change: Previous Z - Current Z
            // If we go down, previous Z > current Z, so energyChange is positive.
            // If we go up, previous Z < current Z, so energyChange is negative.
            int energyChange = route[i - 1][2] - route[i][2];

            // Update our current energy balance
            currentEnergy += energyChange;

            // If our energy dips lower than we've seen before, record it
            if (currentEnergy < minEnergyLevel) {
                minEnergyLevel = currentEnergy;
            }
        }

        // To prevent the drone from crashing at its lowest point,
        // our starting energy must exactly offset that lowest dip.
        return Math.abs(minEnergyLevel);
    }

    public static void main(String[] args) {
        int[][] route = {
                {0, 2, 10},
                {3, 5, 0},
                {9, 20, 6},
                {10, 12, 15},
                {10, 10, 8}
        };

        int requiredEnergy = calcDroneMinEnergySimulation(route);
        System.out.println("Minimum energy required: " + requiredEnergy);
        // Output: Minimum energy required: 5
    }

}
