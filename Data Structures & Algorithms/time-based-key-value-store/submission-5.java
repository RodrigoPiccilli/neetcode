class TimeMap {

    private class Pair {

        private int timestamp;
        private String value;

        public Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }

        public int getTimestamp() {
            return timestamp;
        }

        public String getValue() {
            return value;
        }


    }

    // KEY = Key, VALUE = List of Pairs for Key.
    private Map<String, ArrayList<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        
        if(!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }

        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) { // Use binary search

        String returnVal = "";
        
        if(!map.containsKey(key)) return returnVal;

        ArrayList<Pair> list = map.get(key);

        int l = 0;
        int r = list.size() - 1;

    
        while(l <= r) { // A little bit different; we are trying to find nums[mid] <= timestamp

            int mid = l + (r - l) / 2;

            if(list.get(mid).getTimestamp() <= timestamp) {
                returnVal = list.get(mid).getValue();
                l = mid + 1;
            } else if(list.get(mid).getTimestamp() > timestamp) {
                r = mid - 1;
            }

        }

        return returnVal;
    }
}
