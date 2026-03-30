class TimeMap {

    Map<String, HashMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        
        if(map.get(key) == null) map.put(key, new HashMap<>());

        map.get(key).put(timestamp, value);

    }
    
    public String get(String key, int timestamp) {

        if(map.get(key) == null) return "";

        HashMap<Integer, String> subMap = map.get(key);

        for(int i = timestamp; i >= 0; i--) {

            if(subMap.get(i) != null) {
                return subMap.get(i);
            }

        }

        return "";
       
    }
}
