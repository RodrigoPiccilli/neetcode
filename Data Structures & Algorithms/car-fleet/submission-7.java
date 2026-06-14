class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        int n = position.length;

        // [0] = Position, [1] = Speed
        double[][] cars = new double[n][2];

        for(int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

       Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));

        // [0, 1, 4, 7]
        // [1, 2, 2, 1]

        Stack<Double> fleets = new Stack<>();

        for(int i = n - 1; i >= 0; i--) {

            double arrivalTime = (target - cars[i][0]) / cars[i][1];

            if(fleets.isEmpty() || fleets.peek() < arrivalTime) {
                fleets.push(arrivalTime);
            } 

        }

        return fleets.size();

    }
}
