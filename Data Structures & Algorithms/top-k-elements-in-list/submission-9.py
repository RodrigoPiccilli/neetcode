class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:

        freq = {}

        for n in nums:
            freq[n] = freq.get(n, 0) + 1

        freq_list = [[] for _ in range(len(nums) + 1)]

        for key, value in freq.items():

            freq_list[value].append(key)

        res = []

        for num_list in reversed(freq_list):
            
            for n in num_list:
                res.append(n)

                if len(res) == k: return res
            
        return res
            


        








        