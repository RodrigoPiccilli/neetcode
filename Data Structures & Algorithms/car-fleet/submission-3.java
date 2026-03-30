class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        double[][] master = new double[position.length][2];

        Stack<Integer> fleet = new Stack();

        for(int i = 0; i < position.length; i++) {
            master[i][0] = (double) position[i];
            master[i][1] = (double) (target - position[i]) / (double) speed[i];
        }

        Arrays.sort(master, (a, b) -> Double.compare(a[0], b[0]));

        fleet.push(position.length - 1);

        for(int i = position.length - 2; i >= 0; i--) {
            if(master[i][1] > master[fleet.peek()][1]) fleet.push(i);
        }

        return fleet.size();
        
    }
}
