package nycuro.commands.list;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.ConsoleCommandSender;
import nycuro.CoreJobsAPI;
import nycuro.commands.PrincipalCommand;

/**
 * author: NycuRO
 * CoreJobs-Nukkit Project
 * API 1.0.0
 */
public class JobCommand extends PrincipalCommand {

    public JobCommand() {
        super("job", "Get Informations about Job Plugin");
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        if (commandSender instanceof ConsoleCommandSender) {
            CoreJobsAPI.getMessageAPI().sendConsoleMessage(commandSender);
            return true;
        } else {
            Player player = (Player) commandSender;
            CoreJobsAPI.getJobsAPI().getJob(player);
        }
        return true;
    }
}
