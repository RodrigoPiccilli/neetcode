class Solution {

    public String encode(List<String> strs) {

        if(strs.size() == 0) return "";

        StringBuilder sb = new StringBuilder();

        for(String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }

        return sb.toString();

    }

    public List<String> decode(String str) {

        if(str == null || str.length() == 0) return new ArrayList<String>();

        List<String> solved = new ArrayList<>();

        int i = 0;
        
        int j = 0;

        while(i < str.length()) {

            while(str.charAt(j) != '#') {
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));

            i = j + length;

            j++;

            solved.add(str.substring(j, i + 1));

            i++;
            
            j = i;

        }

        return solved;


    }
}
