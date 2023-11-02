class Test {

 static int a = 1, b = 2; // global or instance

	public static void main(String arge[]) {
		System.out.println("a: " + a + "b: " + b);
		
		ritesh();
	
	}

	public static void ritesh() {
		int c = 3, d = 4; // local
		System.out.println("c: " + c + " || d: " + d);
		System.out.println("a: " + a + "b: " + b);
	}
}