public class WhilePractice {
	public static void main(String[] args) {
		
		// 1
		int num = 2;
		while(num <= 95 / 5)
			System.out.println(num++ * 5);
			
		// 2
		int sum = 0;
		num = 1;
		
		while(num <= 10)
			sum += num++;
		System.out.println(sum);
		
		// 3
		System.out.println(sum(10, 1));
		
		// 4
		System.out.println(isPrime(6));
	}
	
	// 3
	public static int sum(int a, int b) {
		if(a > b) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		a += 1;
		int sum = 0;
		while(a < b)
			sum += a++;
			
		return sum;
	}
	
	// 4
	public static boolean isPrime(int n) {
		for(int i = 2; i < n - 1; i++) if(n % i == 0) return false; return true;
	}
}