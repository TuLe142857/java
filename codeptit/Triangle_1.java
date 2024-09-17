import java.util.*;

public class Triangle_1 {
	public static void main(String []args){
		Scanner in = new Scanner(System.in);

		int k = in.nextInt();
		for(int i = 0; i < k; i++){
			Triangle t = new Triangle(  new Point(in.nextDouble(), in.nextDouble()),
										new Point(in.nextDouble(), in.nextDouble()), 
										new Point(in.nextDouble(), in.nextDouble()) );
			if(!t.check())
				System.out.println("INVALID");
			else
				System.out.println(String.format("%." + 3 + "f", t.perimeter()));
			
		}
	}
}

class Point{
	private double x;
	private double y;

	public Point(){
		x = 0;
		y = 0;
	}

	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}



	public double getX(){
		return x;
	}

	public double getY(){
		return y;
	}


	public static double length(Point p1, Point p2){
		double dx = p1.getX() - p2.getX();
		double dy = p1.getY() - p2.getY();
		return Math.sqrt((dx * dx) + (dy * dy));
	}
}

class Triangle{
	private Point p1, p2, p3;
	

	public Triangle(){
		p1 = new Point();
		p2 = new Point();
		p3 = new Point();
	}

	public Triangle(Point p1, Point p2, Point p3){
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}

	public boolean check(){
		double l_12 = Point.length(p1, p2);
		double l_13 = Point.length(p1, p3);
		double l_23 = Point.length(p2, p3);

		Point v1 = new Point(p2.getX() - p1.getX(), p2.getY()-p1.getY());
		Point v2 = new Point(p3.getX() - p1.getX(), p3.getY()-p1.getY());
		double k1 = Math.abs(v1.getX()/v1.getY());
		double k2 = Math.abs(v2.getX()/v2.getY());
		

		return ((l_12 + l_13) > l_23) && (k1 != k2);
	}

	public double perimeter(){
		double l_12 = Point.length(p1, p2);
		double l_23 = Point.length(p2, p3);
		double l_13 = Point.length(p1, p3);
		return l_12 + l_13 + l_23;
	}
}
