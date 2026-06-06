class Solution {

    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();

        for(String s : strs) {
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }

        return sb.toString();

    }

    public List<String> decode(String str) {

        List<String> res = new ArrayList<>();


       while(str.length() > 0) {

            int end = str.indexOf("#");

            int wordLength = Integer.parseInt(str.substring(0, end));

            String word = str.substring(end + 1, end + wordLength + 1);

            str = str.substring(end + wordLength + 1);

            System.out.println(word);


            res.add(word);
        }

        return res;

    }
}
