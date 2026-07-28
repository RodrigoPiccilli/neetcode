class TimeMap {

    private class Pair {
        
        int timestamp;
        String value;

        public Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }

        public String toString() {
            return this.value + " --- " + this.timestamp;
        }

    }

    private Map<String, List<Pair>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {

        if(!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }

        map.get(key).add(new Pair(timestamp, value));
        
    }
    
    public String get(String key, int timestamp) {

        if(!map.containsKey(key)) return "";

        List<Pair> pairs = map.get(key);

        int l = 0;
        int r = pairs.size() - 1;

        String res = "";

        while(l <= r) {

            int mid = l + (r - l) / 2 ;

            if(pairs.get(mid).timestamp <= timestamp) {
                res = pairs.get(mid).value;
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }

        return res;

    }
}
