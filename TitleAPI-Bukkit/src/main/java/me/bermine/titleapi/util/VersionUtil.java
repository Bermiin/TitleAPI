package me.bermine.titleapi.util;

import org.bukkit.Bukkit;

/**
 * @author iiAhmedYT
 * @version ModernDisguise
 * @since 20/01/2024
 */
public final class VersionUtil {

    public static final String VERSION_EXACT = Bukkit.getBukkitVersion().split("-")[0];
    public static final boolean IS_FOLIA = Reflections.findClass("io.papermc.paper.threadedregions.RegionizedServer");
    public static final boolean IS_PAPER = Reflections.findClass("com.destroystokyo.paper.PaperConfig", "io.papermc.paper.configuration.Configuration");

    public static final int MAJOR, MINOR, PATCH;

    static {
        final String[] versions = VERSION_EXACT.split("\\.");
        MAJOR = Integer.parseInt(versions[0]);
        MINOR = Integer.parseInt(versions[1]);
        PATCH = versions.length > 2 ? Integer.parseInt(versions[2]) : 0;
    }

    // initialize after IS_PAPER is initialized
    public static final String NMS = findVersion();
    public static final boolean IS_13_R2_PLUS = isOrOver(1, 13, 2);
    public static final boolean IS_20_R2_PLUS = isOrOver(1, 20, 2);
    public static final boolean IS_20_R4_PLUS = isOrOver(1, 20, 5);

    public static boolean is(final int minor) {
        return MINOR == minor;
    }

    public static boolean is(final int major, final int minor, final int patch) {
        return MAJOR == major && MINOR == minor && PATCH == patch;
    }

    public static boolean isOver(final int minor) {
        return MINOR > minor;
    }

    public static boolean isOver(final int major, final int minor, final int patch) {
        if (MAJOR > major) {
            return true;
        } else if (MAJOR == major) {
            if (MINOR > minor) {
                return true;
            } else if (MINOR == minor) {
                return PATCH > patch;
            }
        }
        return false;
    }

    public static boolean isOrOver(final int minor) {
        return MINOR >= minor;
    }

    public static boolean isOrOver(final int major, final int minor, final int patch) {
        return isOver(major, minor, patch) || (MAJOR == major && MINOR == minor && PATCH == patch);
    }

    public static boolean isBelow(final int minor) {
        return MINOR < minor;
    }

    public static boolean isBelow(final int major, final int minor, final int patch) {
        if (MAJOR < major) {
            return true;
        } else if (MAJOR == major) {
            if (MINOR < minor) {
                return true;
            } else if (MINOR == minor) {
                return PATCH < patch;
            }
        }
        return false;
    }

    public static boolean isOrBelow(final int minor) {
        return MINOR <= minor;
    }

    public static boolean isOrBelow(final int major, final int minor, final int patch) {
        return isBelow(major, minor, patch) || (MAJOR == major && MINOR == minor && PATCH == patch);
    }

    private static String findVersion() {
        if (IS_PAPER && MINOR >= 20) {
            switch (VERSION_EXACT) {
                case "1.20":
                case "1.20.1":
                    return "1_20_R1";
                case "1.20.2":
                case "1.20.3":
                    return "1_20_R2";
                case "1.20.4":
                    return "1_20_R3";
                case "1.20.5":
                case "1.20.6":
                    return "1_20_R4";
                case "1.21":
                    return "1_21_R1";
                default:
                    return "UNKNOWN";
            }
        }
        return Bukkit.getServer().getClass().getPackage().getName().substring(24);
    }
}