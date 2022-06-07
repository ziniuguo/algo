/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
const merge = function (nums1, m, nums2, n) {
    let insertPos = m + n - 1;
    m -= 1;
    n -= 1;
    while (n >= 0) {
        if (nums1[m] > nums2[n]) {
            nums1[insertPos] = nums1[m];
            m -= 1;
        } else {
            nums1[insertPos] = nums2[n];
            n -= 1;
        }
        insertPos -= 1;
    }
};