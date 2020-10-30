import junit.framework.Assert;
import org.junit.Test;
public class HashMap{
    int SZ_OF_TABLE=128;
    HashEntry[] table;
    class HashEntry {
        int key;
        int value;
        HashEntry next = null;
        HashEntry() {
        }
        public HashEntry(int key, int value) {
            this.key = key;
            this.value = value;
        }
        public int getKey() {
            return this.key;
        }
        public int getValue() {
            return this.value;
        }
        public void setValue(int v)
    }
    HashMap(){
        table=new HashEntry[SZ_OF_TABLE];
        for(int i=0;i<SZ_OF_TABLE;++i)
            table[i]=NULL;
    }
    public void put(int key,int value){
        int index=hashCodeNew(key);
        System.out.println(index);
        HashEntry hashEntry = new HashEntry(key, value);
        if (table[index] == null) {
            table[index] = hashEntry;
        }
        else {
            HashEntry runner = table[index];
            while (runner.next != null) {
                if (runner.key == hashEntry.key) {
                    runner.value = hashEntry.value;
                    break;
                }
                else {
                    runner = runner.next;
                }
            }
            if (runner.next == null) {
                if (runner.key == hashEntry.key) {
                    runner.value = hashEntry.value;
                }
                else {
                    runner.next = hashEntry;
                }
            }
        }
    }
    public int get(int key) {
        int index = hashCodeNew(key);
        if (table[index] == null) {
            return -1;
        }
        else {
            HashEntry runner = table[index];
            if (runner.key == key) {
                return runner.value;
            }
            while (runner.next != null) {
                if (runner.key == key) {
                    return runner.value;
                }
            }
            return -1;
        }
    }
    public int hashCodeNew(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        int hashCode = h ^ (h >>> 7) ^ (h >>> 4);
        return hashCode % SIZE_OF_TABLE;
    }
}

class HashMap{
    int SIZE=128;
    HashEntry[] table;
    class HashEntry{
        int key,val;
        HashEntry next=null;
        HashEntry(){
        }
        public HashEntry(int k,int v){
            key=k;
            val=v;
        }
        public int getKey(){
            return key;
        }
        public int getValue() {
            return this.value;
        }
        public void setVal(int v_){
            val=v_;
        }
    }
    HashMap(){
        table=new HashEntry[SIZE];
        for(int i=0;i<SIZE;i++)
            table[i]=null;
    }
    public int hashCode(int h){
        h^=(h>>20)^(h>>12);
        int hCode=h^(h>>7)^(h>>4);
        return hCode%SIZE;
    }
    public void put(int k,int v){
        int idx=hashCode(k);
        HashEntry he=new HashEntry(k,v);
        if(table[idx]==null){
            table[idx]=he;
        }
        else{
            HashEntry runner=table[idx];
            while (runner.next!=null){
                if(runner.getKey()==k){
                    runner.setVal(v);
                }
                else {
                    runner=runner.next;
                }
            }
            if(runner.next==null){
                if(runner.getKey()==k){
                    runner.setVal(v);
                }
                else {
                    runner.next=he;
                }
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
            if(runner.getKey()==k){
                return runner.getValue();
            }
            while (runner.next!=null){
                if(runner.getKey()==k){
                    return runner.getValue();
                }
                runner=runner.next;
            }
            return -1;
        }
    }
}