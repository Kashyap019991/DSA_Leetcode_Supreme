package com.kas.dsasupreme.extra_classes;

public class MovingMachines {
	/*
	 * public static int getMinimumCost(int[] machineCount, int[] finalMachineCount,
	 * int shiftingCost) { int n = machineCount.length;
	 * 
	 * // Calculate the cost of adjusting machines in each region individually int
	 * cost = 0; for (int i = 0; i < n; i++) { cost += Math.abs(finalMachineCount[i
	 * % 3] - machineCount[i]); }
	 * 
	 * // Check if moving machines between regions can further minimize the cost int
	 * minCost = cost; for (int i = 0; i < n; i++) { for (int j = 0; j < n; j++) {
	 * if (i != j) { int tempCost = cost; int diff = Math.min(machineCount[i],
	 * cost); tempCost -= diff; tempCost += diff * shiftingCost; minCost =
	 * Math.min(minCost, tempCost); } } }
	 * 
	 * return minCost; }
	 */

	

	    public static int getMinimumCost(int[] machineCount, int[] finalMachineCount, int shiftingCost) {
	        int n = machineCount.length;

	        // Validate input
	        if (n < 3 || n > 10 || shiftingCost < 1 || shiftingCost > 1000000) {
	            throw new IllegalArgumentException("Invalid input values");
	        }

	        int totalCost = 0;

	        // Adjust machine counts in existing regions
	        for (int i = 0; i < n; i++) {
	            int diff = finalMachineCount[i % 3] - machineCount[i];
	            if (diff > 0) {
	                totalCost += diff; // Add operation to increase machines
	            } else if (diff < 0) {
	                totalCost += Math.abs(diff); // Add operation to remove machines
	            }
	        }

	        // Handle remaining machines (machines not needed in final regions)
	        int remainingMachines = 0;
	        for (int count : machineCount) {
	            remainingMachines += count;
	        }
	        for (int count : finalMachineCount) {
	            remainingMachines -= count;
	        }

	        // If remaining machines exist, moving them to any of the final regions is optimal
	        totalCost += Math.min(Math.min(remainingMachines, finalMachineCount[0]), Math.min(remainingMachines, finalMachineCount[1]));
	        totalCost += Math.min(Math.min(remainingMachines, finalMachineCount[2]), remainingMachines);

	        return totalCost;
	    }
	

    public static void main(String[] args) {
        int[] machineCount = {2,4,5,3};//{2, 3, 5, 7};
        int[] finalMachineCount = {4,4,4};//{5, 10, 5};
        int shiftingCost = 5;
        System.out.println(getMinimumCost(machineCount, finalMachineCount, shiftingCost)); // Output should be 5
    }
}
