public class HelloWorld {
	public static void main(String[] args) {
		int times = 0;
		
		try {
			times = Integer.parseInt(args[0]);
		}
		
		catch(Exception e) {
			System.out.println("Input parameter must be an integer!");
			System.exit(0);
		}
		
		
		if(times % 2 == 0 && times > 0)
			for(int i = 0; i < times; i++)
				System.out.println("Hello, world!");
		else
			System.out.println("Not a postive even number!");
	}
}