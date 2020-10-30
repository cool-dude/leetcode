/*LC496: Next Greater Element I
https://leetcode.com/problems/next-greater-element-i/
You are given two arrays(without duplicates) nums1
and nums2 where nums1’s elements are subset of nums2.
Find all the next greater numbers for nums1's elements
in the corresponding places of nums2.

Example 1:
Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]

Example 2:
Input: nums1 = [2,4], nums2 = [1,2,3,4].
Output: [3,-1]*/
/*Key observation:
Suppose we have a decreasing sequence followed
by a greater number
For example [5, 4, 3, 2, 1, 6] then the greater
number 6 is the next greater element for all
previous numbers in the sequence

We use a stack to keep a decreasing sub-sequence,
whenever we see a number x greater than stack.peek()
we pop all elements less than x and for all the popped ones,
their next greater element is x
For example [9, 8, 7, 3, 2, 1, 6]
The stack will first contain [9, 8, 7, 3, 2, 1]
then we see 6 which is greater than 1 so we pop
1 2 3 whose next greater element should be 6*/
class Sln1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map=new HashMap<>();
        Stack<Integer> st=new Stack<>();
        for(int num:nums2){
            while (!st.isEmpty() && st.peek()<num)
                map.put(st.pop(),num);
            st.push(num);
        }
        for(int i=0;i<nums1.length;i++)
            nums1[i]=map.getOrDefault(nums1[i],-1);
        return nums1;
    }
    //T:O(n)
    //S:O(n).
}
/*LC503: Next Greater Element II
https://leetcode.com/problems/next-greater-element-ii/
Given a circular array (the next
element of the last element is the
first element of the array), print the
Next Greater Number for every element.
The Next Greater Number of a number x is
the first greater number to its
traversing-order next in the array, which
means you could search circularly to find
its next greater number. If it doesn't exist,
output -1 for this number.

Example 1:
Input: [1,2,1]
Output: [2,-1,2].
The approach is same as Next Greater Element I
The only difference here is that we use stack
to keep the indexes of the decreasing subsequence*/
class Sln2{
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length,next[]=new int[n];
        Arrays.fill(next,-1);
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n*2;i++){
            int num=nums[i%n];
            while (!st.isEmpty() && nums[st.peek()]<num)
                next[st.pop()]=num;
            st.push(i);
        }
        return next;
    }
    //T:O(n)
    //S:O(1).
}
/*LC556: Next Greater Element III
https://leetcode.com/problems/next-greater-element-iii/
Given a positive 32-bit integer n,
you need to find the smallest 32-bit integer which
has exactly the same digits existing in the integer
n and is greater in value than n. If no such
positive 32-bit integer exists, you need to return -1.

Input:  n = 218765
Output: 251678

Input:  n = 1234
Output: 1243

Input: n = 4321
Output: -1

Input: n = 534976
Output: 536479*/
class Sln3 {
    public int nextGreaterElement(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1])
            i--;
        if (i < 0) return -1;
        int j = arr.length - 1;
        while (arr[j] <= arr[i])
            j--;
        swap(arr, i, j);
        reverse(arr, i + 1, arr.length - 1);
        try {
            return Integer.valueOf(String.valueOf(arr));
        }
        catch (NumberFormatException e) {
            return -1;
        }
    }
    void swap(char[] arr, int i, int j) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }
    void reverse(char[] arr, int i, int j) {
        int l = i, h = j;
        while (l < h)
            swap(arr, l++, h--);
    }
}
/*LC3: Next Permutation
Implement next permutation, which
rearranges numbers into the lexicographically
next greater permutation of numbers.

If such arrangement is not possible, it
must rearrange it as the lowest possible
order (ie, sorted in ascending order).

Here are some examples. Inputs are in the
left-hand column and its corresponding
outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1*/
class Sln4 {
    void swap(int[] arr, int i, int j) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }
    void reverse(int[] arr, int i, int j) {
        int l = i, h = j;
        while (l < h)
            swap(arr, l++, h--);
    }
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1])
            i--;
        if(i>=0){
            int j = nums.length - 1;
            while (nums[j] <= nums[i])
                j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }
}