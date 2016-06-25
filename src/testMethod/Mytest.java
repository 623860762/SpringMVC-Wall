package testMethod;

public class Mytest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.println("try...........");
			return;
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			
			System.out.println("finally...........");
		}
		

	}

}
