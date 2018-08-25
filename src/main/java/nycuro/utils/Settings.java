package nycuro.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import nycuro.CoreJobsAPI;
import nycuro.utils.objects.JsonObject;
import nycuro.utils.objects.Icons;
import nycuro.utils.objects.Message;

import java.io.*;

/**
 * author: NycuRO
 * SimpleMessages-Nemisys Project
 * API 1.0.0
 */
public class Settings {

    public Message message = new Message();
    public Icons icons = new Icons();

    public void init() {
        try {
            File file = new File(CoreJobsAPI.getMainAPI().getDataFolder(), "config.json");
            if (!file.exists()) {
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(serializeData());
                fileWriter.close();
            } else {
                ObjectMapper mapper = new ObjectMapper();
                JsonNode settings = mapper.reader().readTree(new FileReader(file));
                JsonNode jsonNodeMessages = settings.get("messages");
                JsonNode jsonNodeIcons = settings.get("icons");

                icons.setLumberJackIcon(jsonNodeIcons.get("lumberJackIcon").toString());
                icons.setMinerIcon(jsonNodeIcons.get("minerIcon" ).toString());
                icons.setFarmerIcon(jsonNodeIcons.get("farmerIcon").toString());
                icons.setKillerIcon(jsonNodeIcons.get("killerIcon").toString());
                icons.setHunterIcon(jsonNodeIcons.get("hunterIcon").toString());
                icons.setInfoIcon(jsonNodeIcons.get("infoIcon").toString());
                icons.setWithoutJobIcon(jsonNodeIcons.get("withoutJobIcon").toString());

                message.setConsoleMessage(jsonNodeMessages.get("consoleMessage").toString());
                message.setMessageTitleJobWindow(jsonNodeMessages.get("messageTitleJobWindow").toString());
                message.setReceiveJob(jsonNodeMessages.get("receiveJob").toString());
                message.setWithoutJobTitleWindow(jsonNodeMessages.get("withoutJobTitleWindow").toString());
                message.setWithoutJobMessage(jsonNodeMessages.get("withoutJobMessage").toString());
            }
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    private String serializeData() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        JsonObject json = new JsonObject();
        icons.setLumberJackIcon("https://i.imgur.com/uWmtrax.png");
        icons.setMinerIcon("https://i.imgur.com/XFCYdCz.png");
        icons.setFarmerIcon("https://i.imgur.com/otMDlEU.png");
        icons.setKillerIcon("https://i.imgur.com/YHkAa4q.png");
        icons.setHunterIcon("https://i.imgur.com/HpwAZvq.png");
        icons.setInfoIcon("https://i.imgur.com/nujWKR3.png");
        icons.setWithoutJobIcon("https://i.imgur.com/YXBNPBc.png");

        message.setConsoleMessage("&cYou can't use this command as Console Command Sender.");
        message.setMessageTitleJobWindow("Hello!");
        message.setReceiveJob("&7» &3You have successfully selected Job: &b %job &3!");
        message.setWithoutJobTitleWindow("Without Job Option");
        message.setWithoutJobMessage("&7» &3From now, you don't have One Job &3!");

        json.setIcons(icons);
        json.setMessages(message);

        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
    }
}
