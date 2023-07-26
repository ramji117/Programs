// In-Place Array Sorting

public class Test {

	public static void main(String[] args)  {
	

		int a[]= {4,5,1,6,8,3,1,9,4,2};
		
		
		for(int i=0;i<a.length-1;i++)
		{
			for(int j=i+1;j<a.length;j++)
			{
				if(a[i]<a[j]) {
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
					j=i+1;
				}
			}
		}
		
	for(int m:a)
	{
		System.out.println(m);
	}

	}

}
