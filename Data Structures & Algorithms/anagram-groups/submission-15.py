class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:

        res = []
        anagrams = {}

        for word in strs:

            freq = [0] * 26

            for c in word:
                freq[ord(c) - ord('a')] += 1

            key = ','.join(str(n) for n in freq)

            if key in anagrams.keys():
                anagrams[key].append(word)
            else: 
                anagrams[key] = [word]

        
        for value in anagrams.values():
            res.append(value)

        return res

        