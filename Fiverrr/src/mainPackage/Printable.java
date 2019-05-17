package mainPackage;

public interface Printable {

	
	public default void print() {}
	
	public default void print(Object printThis , String FILEPATH, boolean Append) {}
	
	
}
