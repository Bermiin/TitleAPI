package me.bermine.titleapi;

import com.google.common.base.Preconditions;
import lombok.Getter;
import me.bermine.titleapi.api.ITitleAPI;
import me.bermine.titleapi.impl.LegacyTitleAPI;
import me.bermine.titleapi.impl.ModernTitleAPI;
import me.bermine.titleapi.util.VersionUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

@Getter
public final class TitleAPI {
    private final Logger logger = LogManager.getLogger(TitleAPI.class);

    @Getter
    private static TitleAPI instance;
    private final JavaPlugin plugin;
    private ITitleAPI titleAPI;

    public TitleAPI(JavaPlugin plugin) {
        instance = this;
        this.plugin = plugin;
    }

    public void init() {
        logger.info("[{}] Detected version {} ({}).", plugin.getName(), VersionUtil.NMS, VersionUtil.VERSION_EXACT);
        if (VersionUtil.isOrBelow(8)) {
            this.titleAPI = new LegacyTitleAPI();
        } else {
            this.titleAPI = new ModernTitleAPI();
        }
    }

    /**
     * Sends a title to a player
     *
     * @param player The player to send the title to
     * @param title The title text
     * @param subTitle The subtitle text
     * @param fadeIn The amount of ticks for the title to fade in
     * @param stay The amount of ticks for the title to stay visible on the screen before fading out
     * @param fadeOut The amount of ticks for the title to fade out
     */
    public static void sendTitle(@NotNull Player player, @NotNull String title, String subTitle, int fadeIn, int stay, int fadeOut) {
        Preconditions.checkNotNull(player, "player cannot be null");
        Preconditions.checkNotNull(title, "title cannot be null");
        instance.titleAPI.sendTitle(player, title, subTitle, fadeIn, stay, fadeOut);
    }
}
