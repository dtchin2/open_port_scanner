package portscanner.dtchin2.com;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

public class PortScanner {
	
	public PortScanner(int num) {
		searchPorts(num);
	}
	
	private List<String> ports = null;
	
	private int makeValidPort() {
		// helper method to make the port number (1) if the port number
		// Entered by the user is less than one
		return 1;
	}
	
	public ArrayList<String> searchPorts(int numOfPorts) {	
		@SuppressWarnings("unused")
		ServerSocket server = null;
		ports = new ArrayList<>();
		
		try {
			if(numOfPorts < 1) {
				throw new InvalidEntryException();
			}
		}
		catch(InvalidEntryException e) {
			System.out.print("Port Number Adjusted to 1");
		}
		
		for(int i=1; i<= numOfPorts; i++) {
			try {
				server = new ServerSocket(i);
				ports.add("Port: " + i + " is open to use");
			}
			catch(IOException e) {
				ports.add("Sorry... Port: " + i + " is in use");
			}
			
		}
		return (ArrayList<String>) ports;
	}
	
	public String printResults() {
		String results = "";
		for(String n: ports) {
			results +=n + "\n";
		}
		return results;
	}
	
	private class InvalidEntryException extends Exception {	
		public InvalidEntryException() {
			super("Invalid Port Number Entry");
			makeValidPort();
		}
	}
	
}
