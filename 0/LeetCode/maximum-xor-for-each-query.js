/**
 * @param {number[]} nums
 * @param {number} maximumBit
 * @return {number[]}
 */
var getMaximumXor = function (nums, maximumBit) {
    let i;
    for (i = 1; i < nums.length; i++) {
        nums[i] ^= nums[i - 1];
        nums[i - 1] = nums[i - 1] ^ (2 ** maximumBit - 1);
    }
    nums[i - 1] = nums[i - 1] ^ (2 ** maximumBit - 1);
    return nums.reverse();
};
