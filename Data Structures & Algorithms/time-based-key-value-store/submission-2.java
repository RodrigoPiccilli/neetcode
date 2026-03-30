class TimeMap {

    HashMap<String, ArrayList<Pair>> map;

    public TimeMap() {
        map = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.get(key) == null) map.put(key, new ArrayList());
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(map.get(key) == null) return "";

        ArrayList<Pair> list = map.get(key);

        int l = 0;
        int r = list.size() - 1;

        int closest = -1;

        while(l <= r) {

            int mid = (l + r)/ 2;

            Pair pair = list.get(mid);

            if(pair.timestamp == timestamp) {
                return pair.val;
            } else if(pair.timestamp > timestamp) {
                r = mid - 1;
            } else {
                closest = mid;
                l = mid + 1;
            }
        }
        return (closest == -1) ? "" : list.get(closest).val;

    }

    private class Pair {

        private String val;
        private int timestamp;

        public Pair(String val, int timestamp) {
            this.val = val;
            this.timestamp = timestamp;
        }

    }
}
