package help;

public class help {
public static class checkmain {

	public static void main(String[] args) {
		check obj = new check();
		
		
		System.out.println(obj.m());
	}

}
public static class check {
    int[] array = new int[3];
    public int m(){
    	int a = 30;
    	array[0]=a;
    	return array[0];
    }
}
}
