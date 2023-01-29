package net.jinnjar.problem1603;

/**
 * @author adnan
 * @since 5/29/2023
 */
class ParkingSystem {

    // Solution 1 (Fastest, Bad Space Complexity)
    int[] space;

    public ParkingSystem(int big, int medium, int small) {
        space = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        return space[carType - 1]-- > 0;
    }
}
