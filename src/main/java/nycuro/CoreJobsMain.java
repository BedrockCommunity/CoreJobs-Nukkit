package nycuro;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import nycuro.api.JobsAPI;
import nycuro.api.MessageAPI;
import nycuro.commands.list.JobCommand;
import nycuro.jobs.handlers.JobsHandlers;
import nycuro.utils.Settings;

import java.io.File;

/**
 * author: NycuRO
 * CoreJobs-Nukkit Project
 * API 1.0.0
 */
public class CoreJobsMain extends PluginBase {

    public Config jobs;

    @Override
    public void onLoad() {
        registerCommands();
        registerAPI();
    }

    @Override
    public void onEnable() {
        createConfig();
        registerEvents();
    }

    @Override
    public void onDisable() {
        this.getServer().getScheduler().cancelAllTasks();
        this.jobs.save();
    }

    private void registerCommands() {
        this.getServer().getCommandMap().register("job", new JobCommand());
    }

    private void registerAPI() {
        CoreJobsAPI.mainAPI = this;
        CoreJobsAPI.messageAPI = new MessageAPI();
        CoreJobsAPI.jobsAPI = new JobsAPI();
        CoreJobsAPI.settingsAPI = new Settings();
    }

    private void registerEvents() {
        this.getServer().getPluginManager().registerEvents(new JobsHandlers(), this);
    }

    private void createConfig() {
        this.getLogger().info(String.valueOf(this.getDataFolder().mkdirs()));
        Config jobs = new Config(
                new File(this.getDataFolder(), "jobs.yml"),
                Config.YAML);
        this.jobs = jobs;
        jobs.save();
        CoreJobsAPI.getSettingsAPI().init();
    }
}
