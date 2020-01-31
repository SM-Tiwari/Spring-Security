import java.util.Arrays;

public class Tricky {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer i1=null;
		Integer i2 =1;
		//System.out.println(i1+i2);
		
		byte b1 = 10;
		System.out.println(b1+2);
		
		System.out.println(Math.min(Double.MIN_VALUE, 0.0d));
		/*
		 * System.out.println(Math.min(Integer.MIN_VALUE, 0.0d));
		 * System.out.println(Double.MIN_VALUE); System.out.println(Double.MAX_VALUE);
		 * System.out.println(Double.MIN_NORMAL);
		 * System.out.println(Double.MIN_EXPONENT);
		 */
		
		char[] chars = new char[] {'\u0097'};
        String str = new String(chars);
        byte[] bytes = str.getBytes();
        System.out.println(Arrays.toString(bytes));


	}

}
