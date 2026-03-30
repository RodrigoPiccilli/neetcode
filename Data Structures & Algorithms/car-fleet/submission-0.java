class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        Stack<Integer> fleet = new Stack<>();

        int n = position.length;

        int cars[][] = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i]; 
            cars[i][1] = speed[i];     
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(a[0], b[0]));

        fleet.push(n - 1);

        for(int i = n - 2; i >= 0; i--) {

            double arrival1 = (double) (target - cars[fleet.peek()][0]) / (double) (cars[fleet.peek()][1]);

            double arrival2 = (double) (target - cars[i][0]) / (double) (cars[i][1]);

            if(arrival2 > arrival1) {
                fleet.push(i);
            }

        } 


        return fleet.size();

    }
}
