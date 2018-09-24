@FunctionalInterface
interface Calc{
public int compute(int x, int y);
}
class Adder implements Calc{
	public int compute(int x, int y) {
		return x  + y;
	}
}
public class CalcDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Calc e = new Adder();
		Calc c  = (a,b)->a+b;
		int d = c.compute(100, 200);
		System.out.println(d);

	}

}
