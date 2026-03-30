class Solution {

    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();

        // "neet","code","love","you"

        for(String s : strs) {
            sb.append(s.length()).append("#").append(s);
        }

        return sb.toString();

    }

    public List<String> decode(String str) {

        List<String> solution = new ArrayList<String>();

         // 4#neet4#code4#love3#you

        while(str.length() > 0) {

          int divider = str.indexOf('#');

          int length = Integer.parseInt(str.substring(0, divider));

          solution.add(str.substring((divider + 1), (divider + 1) + length));

          str = str.substring(divider + length + 1);

        }

        return solution;

    }
}
