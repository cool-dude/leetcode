class Sln1 {
    public boolean isPowerOfThree(int n) {
        return n > 0 && (n == 1 || (n % 3 == 0 && isPowerOfThree(n / 3)));
    }
}
class Sln2 {
    public boolean isPowerOfThree(int n) {
        if (n > 1)
            while (n % 3 == 0) n /= 3;
        return n == 1;
    }
}
class Sln3 {
    public boolean isPowerOfThree(int n) {
        while (n > 1) {
            if (n % 3 != 0) return false;
            n /= 3;
        }
        return n <= 0 ? false : true;
    }
}
class Sln4 {
    public boolean isPowerOfThree(int n) {
        HashSet<Integer> set = new HashSet<>(Arrays.asList(1, 3, 9,
                27, 81, 243, 729,
                2187, 6561, 19683, 59049,
                177147, 531441, 1594323,
                4782969, 14348907, 43046721,
                129140163, 387420489, 1162261467));
        return set.contains(n);
    }
}