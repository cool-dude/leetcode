class Soln{
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();
        if (arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0 ||
                arr3 == null || arr3.length == 0) return result;
        int i=0,j=0,k=0;
        while (i<arr1.length && j<arr2.length && k<arr3.length){
            if(arr1[i]==arr2[j] && arr2[i]==arr3[k]){
                result.add(arr1[i]);
                i++;
                j++;
                k++;
            }
            else{
                int min = Math.min(arr1[i],arr2[j],arr3[k]);
                if(min==arr1[i]) i++;
                else if(min==arr2[j]) j++;
                else k++;
            }
        }
        return result;
    }
}