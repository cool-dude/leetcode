class Sln {
    public void heapSort(int[] a) {
        PriorityQueue<Integer> pq = Arrays.stream(a)
                .boxed()
                .collect(Collectors.toCollection(PriorityQueue::new));

        int i = 0;
        while (!pq.isEmpty()) {
            a[i] = pq.poll();
            i++;
        }
        Arrays.stream(a)
                .forEach(e -> System.out.print(e + " "));
    }
}