/**
 * @author Deep Pandya(Id#) and Harsh Shah(Id#6715591)
 * @date 26/05/2014
 * COMP 6231 - Assignment-1, Distributed Player Status System using Java RMI
 * This class is responsible for creating and logging server activities into log files.
 */


package idlInterface;

import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class Log {
	
	FileHandler handler = null;
	Logger logger = null;
	String name = "";

	Log(String filename) {
		this.name = filename;
		try {
			handler = new FileHandler(name + ".log", true);
			logger = Logger.getLogger("DPSS");
			logger.addHandler(handler);
		} catch (Exception e) {
			System.out.println("message: " + e.getMessage());
		}
	}

	public void Error(String msg) {

		logger.severe(msg);
	}

	public void Warning(String msg) {
		logger.warning(msg);
	}

	public void Info(String msg) {
		logger.info(msg);
	}

}