package me.bermine.titleapi.impl;

import me.bermine.titleapi.api.ITitleAPI;
import org.bukkit.entity.Player;

/**
 * @author Bermine
 * @version TitleAPI
 * @since 08/07/2024
 */
public class ModernTitleAPI implements ITitleAPI {

    @Override
    public void sendTitle(Player player, String title, String subTitle, int fadeIn, int stay, int fadeOut) {
        player.sendTitle(title, subTitle, fadeIn, stay, fadeOut);
    }
}
