class Solution:
    def isPalindrome(self, s: str) -> bool:
    
        l = 0
        r = len(s) - 1

        s = s.strip().lower()

        while l < r:

            while not s[l].isalnum() and l < r:
                l += 1
            
            while not s[r].isalnum() and r > l:
                r -= 1

            if s[l] != s[r]:
                return False

            l += 1
            r -= 1

        return True

            

            
 
        