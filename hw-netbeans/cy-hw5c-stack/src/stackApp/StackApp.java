package stackApp;

public class StackApp {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		
		pushAlert(stack, "Alice");
		pushAlert(stack, "Bob");
		pushAlert(stack, "Colin");
		popAlert(stack);
		popAlert(stack);
		popAlert(stack);
	}
	
	public static void pushAlert(Stack<String> stack, String s) {
		System.out.printf("Pushed %s\n", s);
		stack.push(s);
	}
	
	public static void popAlert(Stack<String> stack) {
		System.out.printf("Popped %s\n", stack.pop());
	}
}