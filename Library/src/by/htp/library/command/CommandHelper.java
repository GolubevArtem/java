package by.htp.library.command;

import java.util.HashMap;
import java.util.Map;

import by.htp.library.command.impl.AddBookCommand;
import by.htp.library.command.impl.LoginCommand;
import by.htp.library.command.impl.RegisterUserCommand;
import by.htp.library.command.impl.ShowCatalogCommand;
import by.htp.library.command.impl.UnknownCommand;

public final class CommandHelper {


	private Map<CommandName, Command> commands = new HashMap<>();
	
	public CommandHelper(){
		commands.put(CommandName.LOGIN, new LoginCommand());
		commands.put(CommandName.REGISTER_USER, new RegisterUserCommand());
		commands.put(CommandName.ADD_BOOK, new AddBookCommand());
		commands.put(CommandName.SHOW_CATALOG, new ShowCatalogCommand());
	}
	
	
	public Command getCommand(String commandName){
		Command command = null;
		CommandName key = null; 
		commandName = commandName.replace('-', '_').toUpperCase();
		key = CommandName.valueOf(commandName);
		
		command = commands.get(key);
		
		if(command == null){
			command = new UnknownCommand();
		}
		return command;
	}
}
