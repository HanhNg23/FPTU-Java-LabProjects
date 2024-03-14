
public class String_method {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "HAHA HAHA HAHA alo co nghe ko";
		
		//_____________________________________STATEMENTS__________________________________________
		//boolean result = name.equals("haHA");
		//boolean result = name.equalsIgnoreCase("haHA");
		
		        /*Note: tháº±ng equals() tráº£ vá»� true khi vÃ  chá»‰ khi nÃ³ giá»‘ng háº¿t chuá»—i bá»‹ so sÃ¡nh
		         * khÃ¡c tháº±ng equalsIgnoreCase á»Ÿ chá»— lÃ  tháº±ng nÃ y váº«n tráº£ vá»� true cho trÆ°á»�ng há»£p chuá»—i so sÃ¡nh
		         * vá»›i chuá»—i bá»‹ so sÃ¡nh cÃ³ cÃ¡c kÃ­ tá»± hoa thÆ°á»�ng lÃ  giá»‘ng nhau*/ 
		
	    //int result = name.length();	
		//char result = name.charAt(1); //return to the character at index required
		//int result = name.indexOf("H");
		//String result = name.toLowerCase();
		//String result = name.trim(); //"      HAHA  " -> "HAHA" 
		//String result = name.replace("HAHA", "HOHO HELLO"); 
		//String result = name.replace('A', 'E');
		//String result = name.replaceAll(name, "Thay the het roi");
		String result = name.concat(" Thay the het roi").concat(" Thay chua hay ko");
		
	
	    
	    //________________________________________OUTPUT__________________________________________
		System.out.println(result);
	
		
	}

}
