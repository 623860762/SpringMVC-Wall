package testMethod;

public class Parent {
	
	private static String fname="kkkkkk";
	static{
		System.out.println("父类：我是父类静态区域"+fname);
	}
	{
		System.out.println("父类：我是父类非静态区域");
	}
	Parent(){
		System.out.println("父类：我是父类构造函数"+fname);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
