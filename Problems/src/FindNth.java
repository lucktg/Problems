public class FindNth {

    public static void main(String args[]) {
        System.out.println("Result " + findNth(21));
    }

    static long findNth(long number)
    {
        long value = 0;
        int i = 0;
        long modulus = 0;
        while(number > 0) {
            modulus = number % 9;
            value = ((long)Math.pow(10, i) * modulus) + value;
            number = number/9;
            i++;
        }
        return value;
    }
    
}
