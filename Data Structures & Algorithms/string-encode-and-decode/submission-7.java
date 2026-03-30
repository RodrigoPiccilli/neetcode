class Solution {

    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();

        for(String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();

    }

    public List<String> decode(String str) {

        ArrayList<String> decoded = new ArrayList();

        int l = 0;

        while(l < str.length()) {

            int r = l;


            while(str.charAt(r) != '#') {
                r++;
            }

            int length = Integer.parseInt(str.substring(l, r));

            l = r + 1;
            r = length + l;
            decoded.add(str.substring(l, r));
            
            l = r;


        }


        return decoded;


    }
}
