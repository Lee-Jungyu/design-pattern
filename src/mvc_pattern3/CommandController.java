package mvc_pattern3;

import java.io.Serializable;

public class CommandController implements Serializable {
	Command command;
	
	public CommandController(){
		//LoginFrame login = new LoginFrame(this);
		//view = new LoginFrame(this);
	}
	
	public void setCommand(Command c){command = c;}
	
	public void doCommand(){
		command.excute();
	}
}
