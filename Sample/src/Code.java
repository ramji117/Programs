import java.util.ArrayList;

public class Code {

	public static void main(String[] args) {
		

		
		ArrayList <String>al=new ArrayList<>();
		
		String s="rammadamji";
		
		String ss[]=new String[s.length()*(s.length()+1)/2];
		
		String m="";
		
		int k=0;
		
		boolean flag=false;
		
		for(int i=0;i<s.length();i++)
		{
			for(int j=i;j<s.length();j++)
			{
				m=m+s.charAt(j);
				ss[k]=m;
				k++;
			}
			
			m="";
			
		}

		      for(int k3=0;k3<ss.length;k3++)
		      {
		    	 flag=isPalindrome(ss[k3]);
		    	 
		    	 if(flag==true)
		    	 {
		    		 al.add(ss[k3]);
		    		 flag=false;
		    	 }
		    	 
	    	

		    			 
		      }
		
		       
		String n= isAnswer(al);
		 
		     System.out.println(n);
		
	}

	public static String isAnswer(ArrayList<String> al) {
		String answer1=al.get(0);
		String m[]=new String[al.size()];
		for(int l=0;l<al.size();l++)
		{
			m[l]=al.get(l);
			
			if(answer1.length()<m[l].length())
			{
				answer1=m[l];
			}
		}
		return answer1;
		
	}

	public static boolean isPalindrome(String string) {
	
		if(string.length()==1)
		return true;
		
		int pt1=0;
		int pt2=string.length()-1;
		
		while(pt1<pt2)
		{
			if(string.charAt(pt1)==string.charAt(pt2))
			{
				pt1++;
				pt2--;
			}else
				return false;
		}
		return true;
		
	}
}
