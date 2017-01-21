
public aspect Goodbye {
	before(): call(void Main.print()) {
		System.out.print("Goodbye");
	}
}