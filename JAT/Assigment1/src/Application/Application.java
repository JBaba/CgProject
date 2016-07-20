package Application;

import assign.test.deamon.BankKernal;

/**
 * Application class which runs BankKernal. 
 *   
 * @author nviradia
 *
 */
public class Application {

	public static void main(String[] args) {
		BankKernal bk = new BankKernal();
		bk.run();
	}

}
