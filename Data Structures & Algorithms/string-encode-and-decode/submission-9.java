class Solution {

    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();

        for(String s : strs) {
            sb.append(s.length() + "#" + s);
        }

        return sb.toString();


    }

    public List<String> decode(String str) {

        List<String> decoded = new ArrayList();

        while(str.length() > 0) {

            // 5 # W o r l d 5 # W o  r  l  d
            // 0 1 2 3 4 5 6 7 8 9 10 11 12 13

            int separator = str.indexOf('#');

            int size = Integer.parseInt(str.substring(0, separator)); // 5

            decoded.add(str.substring(separator + 1, separator + 1 + size));

            if(str.length() == size + 2) break;

            str = str.substring(separator + size + 1);

        }

        return decoded;




    }
}
