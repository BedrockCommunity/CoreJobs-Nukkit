package nycuro;

import nycuro.api.JobsAPI;
import nycuro.api.MessageAPI;
import nycuro.utils.Settings;

/**
 * author: NycuRO
 * CoreJobs-Nukkit Project
 * API 1.0.0
 */
public class CoreJobsAPI {

    public static CoreJobsMain mainAPI;

    public static MessageAPI messageAPI;

    public static JobsAPI jobsAPI;

    public static Settings settingsAPI;

    public static CoreJobsMain getMainAPI() {
        return mainAPI;
    }

    public static MessageAPI getMessageAPI() {
        return messageAPI;
    }

    public static JobsAPI getJobsAPI() {
        return jobsAPI;
    }

    public static Settings getSettingsAPI() { return settingsAPI; }
}
