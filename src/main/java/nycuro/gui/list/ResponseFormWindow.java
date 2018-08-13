package nycuro.gui.list;

import cn.nukkit.form.window.FormWindow;

import java.util.Map;
import java.util.function.Consumer;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * author: Empire92
 * FAWE Project
 * API 1.0.0
 */
public class ResponseFormWindow extends DelegateFormWindow {

    private final Consumer<Map<Integer, Object>> task;

    public ResponseFormWindow(FormWindow parent, Consumer<Map<Integer, Object>> onResponse) {
        super(parent);
        checkNotNull(onResponse);
        this.task = onResponse;
    }

    public void respond(Map<Integer, Object> response) {
        if (task != null) task.accept(response);
    }
}