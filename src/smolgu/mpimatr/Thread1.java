package smolgu.mpimatr;

public class Thread1 extends Thread{

	Matrix matrix;
	int x;  //координаты блока
	int y;
	public Thread1(Matrix matrix, int x, int y) {
		this.matrix = matrix;
		this.x = x;
		this.y = y;
	}
	 @Override
	    public void run() {
		 int[][] C = matrix.multiply(matrix.getA()[x][y], matrix.getB()[x][y]);
		 matrix.addition(C, x, y);
	    }


}
