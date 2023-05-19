/**
 * @param {number} target
 * @param {number[]} nums
 * @return {number}
 */
const minSubArrayLen = function (target, nums) {
    let i = 0;
    let j = 0;
    let out = Infinity;
    if (sumIJ(0, nums.length - 1, nums) < target) {
        return 0;
    }
    while (true) {
        let curr = sumIJ(i, j, nums);
        if (curr < target) {
            j += 1;
        } else {
            if (j - i + 1 < out) {
                out = j - i + 1;
            }
            i += 1;
        }
        if (out === 1) {
            return 1;
        }
        if (j === nums.length - 1 && sumIJ(i, j, nums) < target) {
            return out;
        }
    }
};

function sumIJ(i, j, nums) {
    if (i === j) {
        return nums[i];
    } else {
        let sum = 0;
        for (let k = i; k <= j; k++) {
            sum += nums[k];
        }
        return sum;
    }
}
