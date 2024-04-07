# Solves "half" of the problem:
# For each prefix `P` of `nums`, find the increasing sequence bounded by `P`
# with the maximum sum, and return that sum.
def increasing_prefix_sums(nums):
    # Store the current best increasing sequence, in the form (value, number of occurrences)
    stack = []
    current_sum = 0  # always equal to sum(x * c for x in stack)

    ans = []

    for x in nums:
        count = 1

        # We need to include `x` in our sequence. Values to the left may need to be reduced.
        while stack and stack[-1][0] > x:
            # Anything greater than `x` gets clamped down to `x`.
            # Since `stack` is increasing we only need to look at its tail.
            # This is similar to the min-queue algorithm.
            current_sum -= stack[-1][0] * stack[-1][1]
            count += stack[-1][1]
            stack.pop()

        stack.append((x, count))
        current_sum += x * count
        ans.append(current_sum)

    return ans


class Solution:
    def solve(self, nums):
        left = increasing_prefix_sums(nums)
        right = reversed(increasing_prefix_sums(reversed(nums)))
        # left[i] + right[i] overcounts by nums[i], so subtract that out
        return max(l + r - x for l, r, x in zip(left, right, nums))
