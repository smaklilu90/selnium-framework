package util;

public class Practice {
	
	public static void main(String[] args) {
		
		String str = "Appleppqq";
		char [] chrArray = str.toCharArray();
		int c =1;
		
		for (int i=0;i<chrArray.length; i++) {
			
			 for (int j=0; j<chrArray.length; j++) {
				 if(chrArray[j]!='0' && i!=j && chrArray[j]==chrArray[i]) {
				 
				 c++;
				 System.out.print(" "+chrArray[j]+ c);
				 chrArray[j] = '0';
			
				 }
				 
			 }
		}
		
		
		
	}

}
