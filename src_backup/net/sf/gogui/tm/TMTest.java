package net.sf.gogui.tm;

public final class TMTest {
	private static String TEST = "TEST";
	public TMTest(){
		System.out.println(TEST);
	}
	
	public static void main(String[] args) {
		TMTest tmTest = new TMTest();
		System.out.println(tmTest.toString());
	}
}
