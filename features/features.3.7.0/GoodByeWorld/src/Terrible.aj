
public aspect Terrible {
	before(): call(void Main.print()) {
		System.out.print(" Terrible");
	}
}