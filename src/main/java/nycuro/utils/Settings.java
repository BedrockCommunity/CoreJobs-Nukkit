package nycuro.utils;

import cn.nukkit.utils.Config;
import nycuro.CoreJobsAPI;

import java.io.File;

/**
 * author: NycuRO
 * CoreJobs-Nukkit Project
 * API 1.0.0
 */
public class Settings {

    public static String sendMessageConsole = "";
    public static String messageTitleJobWindow = "";
    public static String lumberJackLink = "";
    public static String minerLink = "";
    public static String farmerLink = "";
    public static String killerLink = "";
    public static String hunterLink = "";
    public static String infoLink = "";
    public static String withoutJobLink = "";
    public static String receiveJob = "";
    public static String withoutJobTitleWindow = "";
    public static String infoMessage = "";
    public static String withoutJobMessage = "";


    public static void init(Config config) {
        Config cfg = new Config(new File(CoreJobsAPI.getMainAPI().getDataFolder(), "config.yml"), Config.YAML);
        sendMessageConsole = cfg.getString("messages.consoleMessage");
        messageTitleJobWindow = cfg.getString("messages.messageTitleJobWindow");
        lumberJackLink = cfg.getString("icons.lumberJackIcon");
        minerLink = cfg.getString("icons.minerIcon");
        farmerLink = cfg.getString("icons.farmerIcon");
        killerLink = cfg.getString("icons.killerIcon");
        hunterLink = cfg.getString("icons.hunterIcon");
        infoLink = cfg.getString("icons.infoIcon");
        withoutJobLink = cfg.getString("icons.withoutJobLink");
        receiveJob = cfg.getString("messages.receiveJob");
        withoutJobTitleWindow = cfg.getString("messages.withoutJobTitleWindow");
        infoMessage = cfg.getString("messages.infoMessage");
        withoutJobMessage = cfg.getString("messages.withoutJob");
    }
}
