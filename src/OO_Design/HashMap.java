class HashMap{
    int SZ_OF_TABLE=128;
    HashEntry[] table;
    class HashEntry{
        int key,value;
        HashEntry next;
        HashEntry(){}
        public HashEntry(int k,int v){
            key=k;value=v;
        }
        public int getKey(){
            return key;
        }
        public int getValue(){
            return value;
        }
        public void setValue(int v){
            value=v;
        }
    }
    HashMap(){
        table=new HashEntry[SZ_OF_TABLE];
        for(int i=0;i<SZ_OF_TABLE;i++)
            table[i]=null;
    }
    public int hashCode(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        int hashCode = h ^ (h >>> 7) ^ (h >>> 4);
        return hashCode % SIZE_OF_TABLE;
    }
    public void put(int k,int v){
        int idx=hashCode(k);
        HashEntry hEntry=new HashEntry(k,v);
        if(table[idx]==null){
            table[idx]=hEntry;
        }
        else {
            HashEntry runner=table[idx];
            while (runner.next!=null){
                if(runner.key==hEntry.key){
                    runner.value=hEntry.value;
                    break;
                }
                else {
                    runner=runner.next;
                }
            }
            if(runner.next==null){
                if(runner.key==hEntry.key)
                    runner.value=hEntry.value;
                else
                    runner.next=hEntry;
            }
        }
    }
    public int get(int k){
        int idx=hashCode(k);
        if(table[idx]==null){
            return -1;
        }
        else {
            HashEntry runner=table[idx];
            while (runner.next!=null){
                if(runner.key==k)
                    return runner.value;
                runner=runner.next;
            }
        }
        return -1;
    }
}