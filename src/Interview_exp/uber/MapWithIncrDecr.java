class MyMap{
    private Map<Integer, Integer> actualMap;
    private int keyOffset;
    private int valOffset;
    public MyMap() {
        actualMap = new HashMap<>();
        keyOffset = 0;
        valOffset = 0;
    }
    public void incKey(int inc) {
        keyOffset += inc;
    }
    public void incVal(int inc) {
        valOffset += inc;
    }
    public void put(int k, int v) {
        actualMap.put(k - keyOffset, v - valOffset);
    }
    public int get(int k) {
        return actualMap.get(k - keyOffset) + valOffset;
    }
}