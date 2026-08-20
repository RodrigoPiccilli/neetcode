class Solution:

    def encode(self, strs: List[str]) -> str:

        parts = []

        for s in strs:
            parts.append(str(len(s)) + '#' + s)


        return "".join(parts)

    def decode(self, s: str) -> List[str]:

        res = []

        while(len(s) > 0):

            sep = s.index('#')

            count = int(s[:sep])

            print(s[sep + 1:count + sep + 1])
            res.append(s[sep + 1:count + sep + 1])

            s = s[count + sep + 1:]

        return res

# 5#hello
# [0, 1, 2, 3, 4, 5, 6]


