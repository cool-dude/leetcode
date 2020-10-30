class Solution():
    def findMedian(self, arr1, arr2):
        n1, n2 = len(arr1), len(arr2)
        if n1 > n2:
            n1, n2 = n2, n1
            arr1, arr2 = arr2, arr1

        low = 0
        high = n1

        while low <= high:
            partition_x = low + (high-low)//2   #floor function: nearest integer of math.floor((high-low)/2)
            partition_y = (n1+n2+1)//2 - partition_x  #floor function: nearest integer of math.floor((n1+n2+1)/2)

            maxLeftX = arr1[partition_x - 1] if partition_x > 0 else -float('inf')
            minRightX = arr1[partition_x] if partition_x < n1 else float('inf')

            maxLeftY = arr2[partition_y - 1] if partition_y > 0 else -float('inf')
            minRightY = arr2[partition_y] if partition_y < n2 else float('inf')

            if maxLeftX <= minRightY and maxLeftY <= minRightX:
                if (n1+n2) % 2 == 0:
                    return (max(maxLeftX, maxLeftY) + min(minRightX, minRightY))/2
                else:
                    return max(maxLeftX, maxLeftY)
            elif maxLeftX > minRightY:
                high = partition_x - 1
            else: low = partition_x + 1

s = Solution()
arr1 = [1,2,3,4,5]
arr2 = [2,6,9,11,12,17,21,29]
print(s.findMedian(arr1, arr2))