package nycuro.api;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.TextFormat;
import nycuro.CoreJobsAPI;
import nycuro.utils.Settings;

/**
 * author: NycuRO
 * CoreJobs-Nukkit Project
 * API 1.0.0
 */
public class MessageAPI {

    public void sendConsoleMessage(CommandSender commandSender) {
        String message = TextFormat.colorize(Settings.sendMessageConsole);
        commandSender.sendMessage(message);
    }

    public void sendReceiveJobMessage(Player player) {
        String message = Settings.receiveJob;
        message = message.replace("%job", JobsAPI.jobs.get(CoreJobsAPI.getMainAPI().jobs.getInt(player.getName())));
        player.sendMessage(TextFormat.colorize(message));
    }

    public void sendWithoutJobMessage(Player player) {
        String message = Settings.withoutJobMessage;
        player.sendMessage(TextFormat.colorize(message));
    }

    public String sendJobContents() {
        return TextFormat.colorize(Settings.messageTitleJobWindow);
    }
}
