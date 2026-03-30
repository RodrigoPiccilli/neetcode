class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;

        Stack<Double> stack = new Stack();

        int[][] cars = new int[n][2];

        for(int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(a[0], b[0]));

        double arrival = (double) (target - cars[n - 1][0]) / (double) (cars[n - 1][1]);

        stack.push(arrival);

        for(int i = n - 2; i >= 0; i--) {

    
            double newArrival = (double) (target - cars[i][0]) / (double) cars[i][1];

            System.out.println(arrival + " : " + newArrival);

            if(newArrival > stack.peek()) {
                stack.push(newArrival);
            }

        }

        return stack.size();
        
    }
}
