class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        Stack<Double> stack = new Stack();

        // Row -> Position
        // Column -> Arrival Time
        double[][] merged = new double[position.length][2];

        for(int i = 0; i < position.length; i++) {
            merged[i][0] = (double) position[i];
            merged[i][1] = (double) (target - position[i]) / (double) speed[i];
        }

        Arrays.sort(merged, (a, b) -> Double.compare(a[0], b[0]));

        int fleetCounter = 1;
        double currentArrival = merged[position.length - 1][1];

        for(int i = position.length - 2; i >= 0; i--) {

            if(merged[i][1] > currentArrival) {
                currentArrival = merged[i][1];
                fleetCounter++;
            }
        }

        return fleetCounter;
        
    }
}
