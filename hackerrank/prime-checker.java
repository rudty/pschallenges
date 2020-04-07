import static java.lang.System.in;
class Prime {
    void checkPrime(int... nums) {
        for (int num : nums) {
            int sqrtNum = (int)Math.sqrt(num);
            boolean isPrime = num >= 2;
            for (int i = 2; i <= sqrtNum; ++i) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }
}