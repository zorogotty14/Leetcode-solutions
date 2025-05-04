class Solution:
    def numEquivDominoPairs(self, dominoes):
        freq = defaultdict(int)
        count = 0

        for a, b in dominoes:
            key = (min(a, b), max(a, b))
            count += freq[key]
            freq[key] += 1  # safely increment
        return count