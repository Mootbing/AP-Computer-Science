package project3;

import java.util.Random;

public class Cryptic
{
	private String keycode;
	
	//initializes the keycode – creates a String with the 10 digits (0 – 9) in a random order 
	public Cryptic() //[5 points]
	{
		keycode = "";
		Random rand = new Random();
		
		for (int i = 0; i < 10; ++i)
			keycode += String.valueOf(rand.nextInt(10));
	}

	//Create a public accessor method to get the generated keycode [2 points]
	public String getKeycode() {
		return keycode;
	}

	public void setKeycode(String keycode) {
		this.keycode = keycode;
	}
	
	//Precondition: sourceChar and keyChar are one-character Strings and are not null //Postcondition: returns an encrypted one-character String
	private String getCode(String sourceChar, String keyChar) //[5 points]
	{
		return Character.toString((int)(sourceChar.toCharArray()[0]) + (int)(keyChar.toCharArray()[0]));
	}

	//Precondition: codedChar and keyChar are one-character Strings and are not null //Postcondition: returns a decrypted one-character String
	private String getSource(String codedChar, String keyChar) //[5 points]
	{
		return Character.toString((int)(codedChar.toCharArray()[0]) - (int)(keyChar.toCharArray()[0]));
	}
	
	//Precondition: source and key are not null //Postcondition: returns the entire encrypted message
	public String encrypt(String source, String key) //[5 points] 
	{
		String Return = "";
		
		String Code = keycode.substring(0, key.length());
		
		for (int i = 0; i < source.length(); i++)
		{
			//System.out.println(String.valueOf(keycode.charAt(i % keycode.length())));
			Return += getCode(String.valueOf(source.charAt(i)), String.valueOf(Code.charAt(i % Code.length()))); //String.valueOf(key.charAt(i % key.length())));
		}
		
		return Return;
	}
	//Precondition: coded and key are not null //Postcondition: returns the entire decrypted message 
	public String decrypt(String coded, String key) //[5 points] 
	{
		String Return = "";
		
		String Code = keycode.substring(0, key.length());
		
		for (int i = 0; i < coded.length(); i++)
		{
			Return += getSource(String.valueOf(coded.charAt(i)), String.valueOf(Code.charAt(i % Code.length()))); //String.valueOf(key.charAt(i % key.length())));
		}
		
		return Return;
	}
	
	public static void main(String args[])
	{
		Cryptic C = new Cryptic();
		//System.out.println("Random code: " + C.getKeycode());
		//System.out.println("Test character: " + C.getCode(C.setKeycode("920715");
		
		System.out.println(C.getKeycode());
		
		String Encrypted = C.encrypt("DISCOMBOBULATED", "MONDAY");
		String Decrypted = C.decrypt(Encrypted, "MONDAY");
		
		System.out.println("Get Encrypted: " + Encrypted);
		System.out.println("Get decrypted " + Decrypted);
	}

}