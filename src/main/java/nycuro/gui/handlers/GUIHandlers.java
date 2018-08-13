package nycuro.gui.handlers;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.form.response.FormResponse;
import cn.nukkit.form.response.FormResponseCustom;
import cn.nukkit.form.response.FormResponseData;
import cn.nukkit.form.response.FormResponseSimple;
import cn.nukkit.form.window.FormWindow;
import nycuro.gui.list.ResponseFormWindow;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * author: Empire92
 * FAWE Project
 * API 1.0.0
 */
public class GUIHandlers implements Listener {

    @EventHandler
    public void onFormSubmit(PlayerFormRespondedEvent event) {
        FormWindow window = event.getWindow();
        if (window instanceof ResponseFormWindow) {
            ResponseFormWindow responseWindow = (ResponseFormWindow) window;
            FormResponse response = event.getResponse();
            if (response instanceof FormResponseSimple) {
                FormResponseSimple simple = (FormResponseSimple) response;
                int index = simple.getClickedButtonId();
                responseWindow.respond(Collections.singletonMap(index, "true"));
            } else if (response instanceof FormResponseCustom) {
                FormResponseCustom custom = (FormResponseCustom) response;
                HashMap<Integer, Object> responses = custom.getResponses();
                HashMap<Integer, Object> parsedResponses = new HashMap<>();
                for (Map.Entry<Integer, Object> responseEntry : responses.entrySet()) {
                    int index = responseEntry.getKey();
                    Object value = responseEntry.getValue();
                    if (value instanceof FormResponseData) {
                        value = ((FormResponseData) value).getElementContent();
                    } else if (value instanceof Float) {
                        value = (double) (float) value;
                    }
                    parsedResponses.put(index, value);
                }
                responseWindow.respond(parsedResponses);
            }
        }
    }
}