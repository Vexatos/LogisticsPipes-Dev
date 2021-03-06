package logisticspipes.commands.commands;

import logisticspipes.commands.abstracts.ICommandHandler;
import logisticspipes.ticks.VersionChecker;
import net.minecraft.command.ICommandSender;

public class ChangelogCommand implements ICommandHandler {
	
	@Override
	public String[] getNames() {
		return new String[]{"changelog"};
	}
	
	@Override
	public boolean isCommandUsableBy(ICommandSender sender) {
		return VersionChecker.hasNewVersion;
	}
	
	@Override
	public String[] getDescription() {
		return new String[]{"Display the changelog between this version", "and the newest one"};
	}
	
	@Override
	public void executeCommand(ICommandSender sender, String[] args) {
    	sender.sendChatToPlayer("The newest version is #" + VersionChecker.newVersion + ".");
		sender.sendChatToPlayer("Changelog:");
    	for(String msg:VersionChecker.changeLog) {
    		sender.sendChatToPlayer(msg);
    	}
	}
}
