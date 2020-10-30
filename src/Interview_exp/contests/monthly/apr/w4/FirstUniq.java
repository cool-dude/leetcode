class FirstUnique {
    LinkedHashSet<Integer> uniq;
    HashSet<Integer> dup;
    public FirstUnique(int[] nums) {
        dup = new HashSet<Integer>();
        uniq = new LinkedHashSet<Integer>();
        for(int num:nums){
            if(!uniq.contains(num) && !dup.contains(num)){
                uniq.add(num);
            }
            else {
                if(uniq.contains(num)){
                    uniq.remove(num);
                    dup.add(num);
                }
            }
        }
    }

    public int showFirstUnique() {
        if(uniq.size()==0)
            return -1;
        for(int num : uniq){
            return num;
        }
        return -1;
    }

    public void add(int num) {
        if(!uniq.contains(num) && !dup.contains(num)){
            uniq.add(num);
        }
        else {
            if(uniq.contains(num)){
                uniq.remove(num);
                dup.add(num);
            }
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */