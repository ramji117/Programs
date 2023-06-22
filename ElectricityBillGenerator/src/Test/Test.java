package Test;

import com.bill.BillGenerator;
import com.data.Customer;

public class Test {

	public static void main(String[] args) {
		
		
		Customer c=new Customer(22);
	 
		BillGenerator b=new BillGenerator(c);
		System.out.println(b.generatebill(2000));

	}

}
