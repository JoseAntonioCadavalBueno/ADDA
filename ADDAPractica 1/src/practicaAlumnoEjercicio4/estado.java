package practicaAlumnoEjercicio4;

public record estado(double ini, double fin, double middy) {
	private static double dnum,derror;
	public static estado first(double num, double error) {
		dnum = num;
		derror = error;
		return new estado(1.0,num,num/2);
	}
	public boolean condicion() {
		return Math.abs(Math.pow(middy, 3)-dnum)>derror;
	}
	public estado next() {
		double middy = (ini+fin)/2;
		if(Math.pow(middy, 3)>dnum) {
			return new estado(ini, middy, (ini+middy)/2);
		}else {
			return new estado(middy, fin, (fin+middy)/2);
		}
	}
}

