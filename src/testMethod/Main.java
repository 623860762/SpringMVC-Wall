package testMethod;


public class Main extends Parent {

	private String name;
	static {
		System.out.println("子类：我是static区域");
	}
	{
		System.out.println("子类：非静态区域");
	}
	Main(String s){
		this.name = s;
		System.out.println(name);
	}
	
	public static void syso(){
		System.out.println("静态方法");
	}
	public static void main(String[] args) {
		//new Main("ssssssssss");

	}

}
