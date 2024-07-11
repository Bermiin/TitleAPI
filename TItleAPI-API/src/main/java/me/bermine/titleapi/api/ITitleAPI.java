package me.bermine.titleapi.api;

import org.bukkit.entity.Player;

public interface ITitleAPI {

    void sendTitle(Player player, String title, String subTitle, int fadeIn, int stay, int fadeOut);
}
