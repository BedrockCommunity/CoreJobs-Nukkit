package nycuro.api;

import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;
import nycuro.CoreJobsAPI;

/**
 * author: NycuRO
 * CoreJobs-Nukkit Project
 * API 1.0.0
 */
public class MessageAPI {

    public void sendConsoleMessage(CommandSender commandSender) {
        String message = TextFormat.colorize(CoreJobsAPI.getSettingsAPI().message.getConsoleMessage());
        message = message.replace("\"", "");
        commandSender.sendMessage(message);
    }
}
