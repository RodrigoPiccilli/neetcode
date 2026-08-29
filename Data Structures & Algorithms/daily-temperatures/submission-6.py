class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:

        # Keep indices in the stack
        # If current temperature is higher than the top index in the stack,
        # pop index from stack and compare distance.
        # Keep doing this in the stack

        stack = []
        res = [0] * len(temperatures)

        for i, temp in enumerate(temperatures):

            while stack and temperatures[stack[-1]] < temp:
                res[stack[-1]] = (i - stack[-1])
                stack.pop()

            stack.append(i)

        return res

            
            



        