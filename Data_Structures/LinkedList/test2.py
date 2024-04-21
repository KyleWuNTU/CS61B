class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n = len(s)
        maxLength = 0
        charMap = {}
        l = 0
        
        for r in range(n):
            print(l, r)
            right_val = s[r]
            if right_val not in charMap or charMap[right_val] < l:
                charMap[right_val] = r
                maxLength = max(maxLength, r - l + 1)
            else:
                l = charMap[right_val] + 1
                charMap[right_val] = r
        
        return maxLength

sol = Solution()
sol.lengthOfLongestSubstring("abcabcbb")