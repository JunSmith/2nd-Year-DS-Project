package gmit;

public class TestClass {
	private static final String TEXT = "commonEnglishWords.txt";

	public static void main(String[] args) throws Exception {
		FileParser parser = new FileParser();
		HashMapGen mapGen = new HashMapGen();
		FileCoder fCoder = new FileCoder();
		
		fCoder.encoder(mapGen.encoder(parser.parse(TEXT)), TEXT);
	}
}
