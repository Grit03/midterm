package scripts;

import java.io.IOException;

public class kuir {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String command = args[0];   
		String path = args[1];
		if(command.equals("-m")) {
			String command2 = args[2];
			if(command2.equals("-q")){
				String query = args[3];
				MidTerm midterm = new MidTerm(path, query);
				midterm.showSnippet();
			}
		}
	}

}
