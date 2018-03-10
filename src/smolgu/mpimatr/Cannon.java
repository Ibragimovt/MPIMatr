package smolgu.mpimatr;

public class Cannon {
	Matrix matrix;
	int A[][][][];
	int B[][][][];
	int C[][][][];
	
	Cannon(int m){
		matrix = new Matrix(m);
		matrix.init();
	}
	
	public void multiply() throws Exception {
		long startTime = System.nanoTime();
		matrix.shiftLeft();
		matrix.shiftUp();
		startSetThreade();
		matrix.shiftLeftSimple();
		matrix.shiftUpSimple();
		startSetThreade();
		matrix.shiftLeftSimple();
		matrix.shiftUpSimple();
		startSetThreade();
		long estimatedTime = System.nanoTime() - startTime;
		System.out.println((double)estimatedTime/1000000000.0);
		System.out.println("Конец!");
	}
	
	private void startSetThreade() throws Exception {
		Thread t1 = new Thread1(matrix, 0, 0);
		Thread t2 = new Thread1(matrix, 0, 1);
		Thread t3 = new Thread1(matrix, 0, 2);
		Thread t4 = new Thread1(matrix, 1, 0);
		Thread t5 = new Thread1(matrix, 1, 1);
		Thread t6 = new Thread1(matrix, 1, 2);
		Thread t7 = new Thread1(matrix, 2, 0);
		Thread t8 = new Thread1(matrix, 2, 1);
		Thread t9 = new Thread1(matrix, 2, 2);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		t5.join();
		t6.join();
		t7.join();
		t8.join();
		t9.join();
	}

}
