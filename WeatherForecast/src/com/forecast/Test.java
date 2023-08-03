package com.forecast;


public class Test {
	
	
public static void main(String[] args)  {


	
       String pwd="rmji11";
       
       boolean ans=isGood(pwd);
       System.out.println(ans);
	
}

public  static boolean isGood(String pwd) {
	
  if(pwd.length()<6) return false;
  
  
  boolean hasDigit=false;
  boolean hasUpper=false;
  boolean hasLower=false;
  
  
  for(Character c:pwd.toCharArray())
  {
	  if(Character.isDigit(c))
		  hasDigit=true;
	  else if(Character.isUpperCase(c))
		  hasUpper=true;
	  else if(Character.isLowerCase(c))
		  hasLower=true;
	  
	  if(c==' '||c=='/')
		  return false;
		  
  }
  return hasDigit&&hasUpper&&hasLower;
  
}

}

