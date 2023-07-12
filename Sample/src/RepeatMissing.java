
public class RepeatMissing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


        int n=6;                 // Repeat=3 Missing=5
		
		int a[]= {1,2,2,3,5,6,7};
		int rep=-1;
		int mis=-1;
		
		int i=0;
		
		while(i<a.length-1)
		{
			if(a[i]==a[i+1])
			{
			   rep=a[i+1];	
			}
			else if(a[i]!=i+1)
			{
				mis=i+1;
			}
			
			i++;
			
		}
		
		  
		
		System.out.println(rep);
		System.out.println(mis);

	}

}
