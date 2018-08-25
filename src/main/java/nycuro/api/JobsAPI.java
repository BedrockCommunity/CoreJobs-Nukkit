package nycuro.api;

import cn.nukkit.Player;
import cn.nukkit.form.element.ElementButton;
import cn.nukkit.form.element.ElementButtonImageData;
import cn.nukkit.form.element.ElementLabel;
import cn.nukkit.form.window.FormWindowCustom;
import cn.nukkit.form.window.FormWindowSimple;
import cn.nukkit.utils.TextFormat;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;

import nycuro.CoreJobsAPI;
import nycuro.gui.list.ResponseFormWindow;

import java.util.Map;
import java.util.function.Consumer;

/**
 * author: NycuRO
 * CoreJobs-Nukkit Project
 * API 1.0.0
 */
public class JobsAPI {

    public static Object2ObjectMap<Integer, String> jobs = new Object2ObjectArrayMap<>();

    static {
        jobs.put(0, "");
        jobs.put(1, "LumberJack");
        jobs.put(2, "Miner");
        jobs.put(3, "Farmer");
        jobs.put(4, "Killer");
        jobs.put(5, "Hunter");
    }

    public int getTypeOfJob(Player player) {
        return CoreJobsAPI.getMainAPI().jobs.getInt(player.getName());
    }

    private void sendInfoMessageJobs(Player player) {
        String messagewithoutJobTitleWindow = CoreJobsAPI.getSettingsAPI().message.getWithoutJobTitleWindow();
        messagewithoutJobTitleWindow = messagewithoutJobTitleWindow.replace("\"", "");
        FormWindowCustom infoMenu = new FormWindowCustom(TextFormat.colorize(messagewithoutJobTitleWindow));
        String string = "                      Hello!\n" +
                "            Welcome to Info Jobs!\n\n" +
                "§c» §aLumberJack:\n" +
                "§eWith that Job you can get money if you cut wood, any type of wood.\n" +
                "§eThe sum received per block: §72.5$\n\n" +
                "§c» §aMiner: \n" +
                "§eYou can make money if you are going to work with this job.\n" +
                "§eEncount money only if you are mining CobbleStone and Precious Ores.\n" +
                "§eThe sum received per block: §72.5$\n\n" +
                "§c» §aFarmer: \n" +
                "§eYou can make money with this job if you plant.\n" +
                "§eAnd You only accept money if you Plant or Cultivate Seeds, any kind of Seeds, Saplings and Flowers.\n" +
                "§eThe sum received per block: §71$\n\n" +
                "§c» §aKiller:\n" +
                "§eWith this Job you can make money if you kill or hit non-spawn players.\n" +
                "§eThe sum received per hit: §70.4$\n" +
                "§eSum received per kill: §73$\n\n" +
                "§c» §aHunter:\n" +
                "§eWith this Job you can make money if you kill or hit animals.\n" +
                "§eThe sum received per hit: §70.4$\n" +
                "§eSum received per kill: §71.4$";
        infoMenu.addElement(new ElementLabel(TextFormat.colorize(string)));
        player.showFormWindow(infoMenu);
    }

    public void getJob(Player player) {
        String lumberJackLink = CoreJobsAPI.getSettingsAPI().icons.getLumberJackIcon();
        String minerLink = CoreJobsAPI.getSettingsAPI().icons.getMinerIcon();
        String farmerLink = CoreJobsAPI.getSettingsAPI().icons.getFarmerIcon();
        String killerLink = CoreJobsAPI.getSettingsAPI().icons.getKillerIcon();
        String hunterLink = CoreJobsAPI.getSettingsAPI().icons.getHunterIcon();
        String infoLink = CoreJobsAPI.getSettingsAPI().icons.getInfoIcon();
        String withoutJobLink = CoreJobsAPI.getSettingsAPI().icons.getWithoutJobIcon();
        String messageTitleJobWindow = CoreJobsAPI.getSettingsAPI().message.getMessageTitleJobWindow();
        FormWindowSimple jobsMenu = new FormWindowSimple("Jobs", TextFormat.colorize(messageTitleJobWindow));
        jobsMenu.addButton(new ElementButton("LumberJack", new ElementButtonImageData("url", lumberJackLink)));
        jobsMenu.addButton(new ElementButton("Miner", new ElementButtonImageData("url", minerLink)));
        jobsMenu.addButton(new ElementButton("Farmer", new ElementButtonImageData("url", farmerLink)));
        jobsMenu.addButton(new ElementButton("Killer", new ElementButtonImageData("url", killerLink)));
        jobsMenu.addButton(new ElementButton("Hunter", new ElementButtonImageData("url", hunterLink)));
        jobsMenu.addButton(new ElementButton("Info", new ElementButtonImageData("url", infoLink)));
        jobsMenu.addButton(new ElementButton("Without Job", new ElementButtonImageData("url", withoutJobLink)));
        jobsMenu.addButton(new ElementButton("Close"));
        System.out.println("Hello work first");
        player.showFormWindow(new ResponseFormWindow(jobsMenu, new Consumer<Map<Integer, Object>>() {
            @Override
            public void accept(Map<Integer, Object> response) {
                System.out.println("Hello work second");
                if (!response.isEmpty()) {
                    System.out.println("Passed");
                    String message = CoreJobsAPI.getSettingsAPI().message.getReceiveJob();
                    System.out.println(player.getName());
                    switch (response.entrySet().iterator().next().getKey()) {
                        case 0:
                            System.out.println(player.getName());
                            CoreJobsAPI.getMainAPI().jobs.set(player.getName(), 1);
                            System.out.println(player.getName());
                            System.out.println(message);
                            message = message.replace("%job", JobsAPI.jobs.get(CoreJobsAPI.getMainAPI().jobs.getInt(player.getName())));
                            System.out.println(message);
                            System.out.println(message);
                            player.sendMessage(TextFormat.colorize(message));
                            return;
                        case 1:
                            CoreJobsAPI.getMainAPI().jobs.set(player.getName(), 2);
                            message = message.replace("%job", JobsAPI.jobs.get(CoreJobsAPI.getMainAPI().jobs.getInt(player.getName())));
                            player.sendMessage(TextFormat.colorize(message));
                            return;
                        case 2:
                            CoreJobsAPI.getMainAPI().jobs.set(player.getName(), 3);
                            message = message.replace("%job", JobsAPI.jobs.get(CoreJobsAPI.getMainAPI().jobs.getInt(player.getName())));
                            player.sendMessage(TextFormat.colorize(message));
                            return;
                        case 3:
                            CoreJobsAPI.getMainAPI().jobs.set(player.getName(), 4);
                            message = message.replace("%job", JobsAPI.jobs.get(CoreJobsAPI.getMainAPI().jobs.getInt(player.getName())));
                            player.sendMessage(TextFormat.colorize(message));
                            return;
                        case 4:
                            CoreJobsAPI.getMainAPI().jobs.set(player.getName(), 5);
                            message = message.replace("%job", JobsAPI.jobs.get(CoreJobsAPI.getMainAPI().jobs.getInt(player.getName())));
                            player.sendMessage(TextFormat.colorize(message));
                            return;
                        case 5:
                            sendInfoMessageJobs(player);
                            return;
                        case 6:
                            CoreJobsAPI.getMainAPI().jobs.set(player.getName(), 0);
                            message = message.replace("%job", JobsAPI.jobs.get(CoreJobsAPI.getMainAPI().jobs.getInt(player.getName())));
                            player.sendMessage(TextFormat.colorize(message));
                            String mess = CoreJobsAPI.getSettingsAPI().message.getWithoutJobMessage();
                            player.sendMessage(TextFormat.colorize(mess));
                            return;
                        case 7:
                            break;
                    }
                }
            }
        }));
    }
}
