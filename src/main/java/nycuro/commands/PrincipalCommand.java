package nycuro.commands;

import cn.nukkit.command.Command;

/**
 * author: NycuRO
 * CoreJobs-Nukkit Project
 * API 1.0.0
 */
public abstract class PrincipalCommand extends Command {

    public PrincipalCommand(String name, String description) {
        super(name, description);
        this.description = description;
    }
}
