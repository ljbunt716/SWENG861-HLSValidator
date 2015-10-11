
public class HelloWorld {
	private String word;
	
	public HelloWorld(){
		word ="Hello World!";
	}
	
	public static void main(String[] args) {
		String word = "Hello World!";
		
		System.out.println(word);

	}
	
	public String GetWord()
	{
		return word;
	}

}
