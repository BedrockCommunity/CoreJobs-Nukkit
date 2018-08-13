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
import nycuro.utils.Settings;

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
        FormWindowCustom infoMenu = new FormWindowCustom(TextFormat.colorize(Settings.withoutJobTitleWindow));
        infoMenu.addElement(new ElementLabel(TextFormat.colorize(Settings.infoMessage)));
        player.showFormWindow(infoMenu);
    }

    public void getJob(Player player) {
        FormWindowSimple jobsMenu = new FormWindowSimple("Jobs", CoreJobsAPI.getMessageAPI().sendJobContents());
        jobsMenu.addButton(new ElementButton("LumberJack", new ElementButtonImageData("url", Settings.lumberJackLink)));
        jobsMenu.addButton(new ElementButton("Miner", new ElementButtonImageData("url", Settings.minerLink)));
        jobsMenu.addButton(new ElementButton("Farmer", new ElementButtonImageData("url", Settings.farmerLink)));
        jobsMenu.addButton(new ElementButton("Killer", new ElementButtonImageData("url", Settings.killerLink)));
        jobsMenu.addButton(new ElementButton("Hunter", new ElementButtonImageData("url", Settings.hunterLink)));
        jobsMenu.addButton(new ElementButton("Info", new ElementButtonImageData("url", Settings.infoLink)));
        jobsMenu.addButton(new ElementButton("Without Job", new ElementButtonImageData("url", Settings.withoutJobLink)));
        jobsMenu.addButton(new ElementButton("Close"));
        player.showFormWindow(new ResponseFormWindow(jobsMenu, new Consumer<Map<Integer, Object>>() {
            @Override
            public void accept(Map<Integer, Object> response) {
                if (!response.isEmpty()) {
                    switch (response.entrySet().iterator().next().getKey()) {
                        case 0:
                            CoreJobsAPI.getMainAPI().jobs.set(player.getName(), 1);
                            CoreJobsAPI.getMessageAPI().sendReceiveJobMessage(player);
                            return;
                        case 1:
                            CoreJobsAPI.getMainAPI().jobs.set(player.getName(), 2);
                            CoreJobsAPI.getMessageAPI().sendReceiveJobMessage(player);
                            return;
                        case 2:
                            CoreJobsAPI.getMainAPI().jobs.set(player.getName(), 3);
                            CoreJobsAPI.getMessageAPI().sendReceiveJobMessage(player);
                            return;
                        case 3:
                            CoreJobsAPI.getMainAPI().jobs.set(player.getName(), 4);
                            CoreJobsAPI.getMessageAPI().sendReceiveJobMessage(player);
                            return;
                        case 4:
                            CoreJobsAPI.getMainAPI().jobs.set(player.getName(), 5);
                            CoreJobsAPI.getMessageAPI().sendReceiveJobMessage(player);
                            return;
                        case 5:
                            sendInfoMessageJobs(player);
                            return;
                        case 6:
                            CoreJobsAPI.getMainAPI().jobs.set(player.getName(), 0);
                            CoreJobsAPI.getMessageAPI().sendReceiveJobMessage(player);
                            CoreJobsAPI.getMessageAPI().sendWithoutJobMessage(player);
                            return;
                        case 7:
                            break;
                    }
                }
            }
        }));
    }
}
