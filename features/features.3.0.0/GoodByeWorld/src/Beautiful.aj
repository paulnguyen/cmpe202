
public aspect Beautiful {

	before(): call(void Main.print()) {
		System.out.print(" Beautiful");
	}

}