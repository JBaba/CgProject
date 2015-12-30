package musix.test;

public class MathMode {

	
	
	public static void main(String[] args) {
		
		point3 p1 = new point3(1, 0, 0, 1, 1, 0, 1, 1, 1);
		point3 p2 = new point3(2, 0, 0, 0, 2, 2, 1, 0, 0);
		point3 p3 = new point3(2, 3, 4, 1, 4, 3, 0, 3, 1);
		point3 p4 = new point3(1, 1, 1, 1, 2, 3, 2, 1, 4);

		point3 p5 = new point3(1, 1, 1, 1, 1, 0, 1, 0, 0);
		p1.calculate();
		p2.calculate();
		p3.calculate();
		p4.calculate();
		p5.calculate();
	}
	
}

class point3 {
	public int x1,x2,x3,y1,y2,y3,z1,z2,z3;
	public point3() {
		// TODO Auto-generated constructor stub
	}
	public point3(int x1,int y1,int z1,int x2,int y2,int z2,int x3,int y3,int z3) {
		this.x1=x1;
		this.x2=x2;
		this.x3=x3;
		this.y1=y1;
		this.y2=y2;
		this.y3=y3;
		this.z1=z1;
		this.z2=z2;
		this.z3=z3;
	}
	
	public void calculate(){
		System.out.println("----------------------------");
		printThis();
		point3 vector1 = new point3();
		vector1.x1 = x2-x1;
		vector1.y1 = y2-y1;
		vector1.z1 = z2-z1;
		
		point3 vector2 = new point3();
		vector2.x1 = x3-x2;
		vector2.y1 = y3-y2;
		vector2.z1 = z3-z2;
		
		System.out.print("v1 : "+(x2-x1)+","+(y2-y1)+","+(z2-z1));
		System.out.println(" v2 : "+(x3-x2)+","+(y3-y2)+","+(z3-z2));
		int mx,my,mz;
		mx = (vector1.y1*vector2.z1)-(vector1.z1*vector2.y1);
		my = (vector1.x1*vector2.z1)-(vector1.z1*vector2.x1);
		mz = (vector1.x1*vector2.y1)-(vector1.y1*vector2.x1);
		System.out.println("Eq : "+mx+"x + "+my+"y + "+mz+"z = D "+mx+"x + "+(-1*my)+"y + "+mz+"z = D");
		findD(x1, y1, z1, mx, my, mz);
		findD(x2, y2, z2, mx, my, mz);
		findD(x3, y3, z3, mx, my, mz);
	}
	
	public void findD(int x1,int y1,int z1,int mx,int my,int mz){
		System.out.print("D is "+((x1*mx)+(y1*my)+(z1*mz)));
		System.out.println(" -D is "+((x1*mx)+(y1*(-1*my))+(z1*mz)));
	}
	
	public void printThis() {
		System.out.println("P1("+x1+","+y1+","+z1+")"+" P2("+x2+","+y2+","+z2+")"+" P3("+x3+","+y3+","+z3+")");
	}
}
