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

        for(int i = list.size() - 1; i >= 0; i--) {

            Pair p = list.get(i);

            if(p.timestamp <= timestamp) return p.val;

        }

        return "";


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
