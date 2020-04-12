package cn.com.webxml;


public class StartClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EnglishChineseSoap englishChineseSoap=new EnglishChinese().getEnglishChineseSoap();
		ArrayOfString ts=englishChineseSoap.translatorString(" ¿ΩÁ");
	    System.out.println(ts.string.get(0));
	    System.out.println(ts.string.get(1));
	    System.out.println(ts.string.get(2));
	    System.out.println(ts.string.get(3));
	    System.out.println(ts.string.get(4));

	    
	}

}
