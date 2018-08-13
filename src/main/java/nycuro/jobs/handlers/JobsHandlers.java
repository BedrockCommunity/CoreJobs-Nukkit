package nycuro.jobs.handlers;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.entity.Entity;
import cn.nukkit.entity.EntityCreature;
import cn.nukkit.entity.passive.EntityAnimal;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.entity.EntityDamageByChildEntityEvent;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.event.entity.EntityDeathEvent;
import cn.nukkit.event.player.PlayerDeathEvent;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.player.PlayerQuitEvent;
import me.onebone.economyapi.EconomyAPI;
import nycuro.CoreJobsAPI;

/**
 * author: NycuRO
 * CoreJobs-Nukkit Project
 * CoreJobsAPI 1.0.0
 */
public class JobsHandlers implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (CoreJobsAPI.getMainAPI().jobs.get(player.getName()) == null) {
            CoreJobsAPI.getMainAPI().jobs.set(player.getName(), 0);
        }
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        CoreJobsAPI.getMainAPI().jobs.save();
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        if (CoreJobsAPI.getMainAPI().jobs.getInt(player.getName()) == 1) {
            switch (block.getId()) {
                case Block.WOOD:
                case Block.WOOD2:
                    EconomyAPI.getInstance().addMoney(player, 1);
                    player.addExperience(1);
                    break;
            }
        } else if (CoreJobsAPI.getMainAPI().jobs.getInt(player.getName()) == 2) {
            switch (block.getId()) {
                case Block.COBBLESTONE:
                case Block.STONE:
                case Block.COAL_ORE:
                case Block.IRON_ORE:
                case Block.GOLD_ORE:
                case Block.DIAMOND_ORE:
                case Block.LAPIS_ORE:
                case Block.REDSTONE_ORE:
                    EconomyAPI.getInstance().addMoney(player.getName(), 2.5);
                    player.addExperience(2);
                    break;
            }
        } else if (CoreJobsAPI.getMainAPI().jobs.getInt(player.getName()) == 3) {
            switch (block.getId()) {
                case 59:
                case 104:
                case 105:
                case 244:
                case 141:
                case 142:
                    switch (block.getDamage()) {
                        case 7:
                            EconomyAPI.getInstance().addMoney(player, 0.5);
                            player.addExperience(1);
                            break;
                    }
                case Block.PUMPKIN:
                case Block.MELON_BLOCK:
                case Block.SUGARCANE_BLOCK:
                case Block.CACTUS:
                case 175:
                case Block.SAPLING:
                case Block.FLOWER:
                    EconomyAPI.getInstance().addMoney(player, 0.5);
                    player.addExperience(1);
                    break;
                case 127:
                    switch (block.getDamage()) {
                        case 2:
                            EconomyAPI.getInstance().addMoney(player, 0.5);
                            player.addExperience(1);
                            break;
                    }
            }
        }
    }

    @EventHandler
    public void onHurt(EntityDamageEvent event) {
        Entity eventEntity = event.getEntity();
        if (eventEntity == null) return;
        Player damager = null;
        if (event instanceof EntityDamageByEntityEvent) {
            EntityDamageByEntityEvent ev = (EntityDamageByEntityEvent) event;
            if (ev instanceof EntityDamageByChildEntityEvent) {
                EntityDamageByChildEntityEvent evc = (EntityDamageByChildEntityEvent) ev;
                if (evc.getDamager() instanceof Player) damager = (Player) evc.getDamager();
            } else if (ev.getDamager() instanceof Player) damager = (Player) ev.getDamager();

            if (damager == null) return;
            if (CoreJobsAPI.getMainAPI().jobs.getInt(damager.getName()) == 4) {
                if (eventEntity instanceof EntityAnimal) return;
                if (eventEntity instanceof EntityCreature) return;
                EconomyAPI.getInstance().addMoney(damager, 0.4);
                damager.addExperience(5);
            } else if (CoreJobsAPI.getMainAPI().jobs.getInt(damager.getName()) == 5) {
                if (eventEntity instanceof Player) return;
                EconomyAPI.getInstance().addMoney(damager, 0.4);
                damager.addExperience(2);
            }
        }
    }


    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        Entity eventEntity = event.getEntity();
        if (eventEntity instanceof Player) return;
        if ((eventEntity.getLastDamageCause() instanceof EntityDamageByEntityEvent)) {
            if (((EntityDamageByEntityEvent) eventEntity.getLastDamageCause()).getDamager() instanceof Player) {
                Player killer = (Player) ((EntityDamageByEntityEvent) eventEntity.getLastDamageCause()).getDamager();
                if (CoreJobsAPI.getMainAPI().jobs.getInt(killer.getName()) == 5) {
                    EconomyAPI.getInstance().addMoney(killer, 1);
                    killer.addExperience(1);
                }
            }
        }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        if ((player.getLastDamageCause() instanceof EntityDamageByEntityEvent)) {
            if (((EntityDamageByEntityEvent) player.getLastDamageCause()).getDamager() instanceof Player) {
                Player killer = (Player) ((EntityDamageByEntityEvent) player.getLastDamageCause()).getDamager();
                if (CoreJobsAPI.getMainAPI().jobs.getInt(killer.getName()) == 4) {
                    EconomyAPI.getInstance().addMoney(killer, 3);
                    (killer).addExperience(2);
                }
            }
        }
    }
}
