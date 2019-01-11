package sky.shopping.list.general;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class Test {
    
	 public void main(String[] args) {
		 BigDecimal myBigDecimal = new BigDecimal("3.84");
		 BigDecimal newValue = myBigDecimal.setScale(2, RoundingMode.DOWN);
		 System.out.println(newValue);
		 String test1 = "test";
		 StringBuilder str = new StringBuilder(test1);
		 str.reverse();
		 System.out.println(str);
	 }
}
