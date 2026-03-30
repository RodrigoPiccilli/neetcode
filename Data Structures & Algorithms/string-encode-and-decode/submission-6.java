class Solution {

    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();

        for(String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {

        List<String> decoded = new ArrayList<>();

        while(str.length() > 0) {

            int l = 0;

            while(str.charAt(l) != '#') l++;

            int length = Integer.parseInt(str.substring(0, l++));

            int r = l + length;

            decoded.add(str.substring(l, r));

            if(r > str.length()) break;

            str = str.substring(r);

        }

        return decoded;


    }
}
