package me.bjtmastermind.simplesweep;

import java.util.Collections;
import java.util.List;

public class Config {
    public static List<? extends String> whitelist = Collections.emptyList();
    public static List<? extends String> blacklist = Collections.emptyList();
    public static boolean onlyCrouch = false;

    /*private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
    public static ForgeConfigSpec COMMON_CONFIG;

    public static ForgeConfigSpec.ConfigValue<List<? extends String>> whitelist;
    public static ForgeConfigSpec.ConfigValue<List<? extends String>> blacklist;
    public static ForgeConfigSpec.BooleanValue onlyCrouch;

    static {
        whitelist = COMMON_BUILDER
            .comment(" List of items to block the sweep attack for, if no Sweeping Edge.",
                " Items should be in the form of registry name, i.e. 'minecraft:diamond_sword'")
            .defineList("whitelist", Collections.emptyList(),
                it -> it instanceof String && ResourceLocation.isValidResourceLocation((String) it)
            );

        blacklist = COMMON_BUILDER
            .comment(" List of items to not block the sweep attack for, if no Sweeping Edge.",
                " If whitelist is not empty, the blacklist will be ignored.",
                " Items should be in the form of registry name, i.e. 'minecraft:diamond_sword'")
            .defineList("blacklist", Collections.emptyList(),
                it -> it instanceof String && ResourceLocation.isValidResourceLocation((String) it)
            );

        onlyCrouch = COMMON_BUILDER
            .comment(" Alternatively to requiring the Sweeping Edge enchantment, set this option to",
                    " true require the player to crouch to be able to sweep attack.")
            .define("onlyCrouch", false);

        COMMON_CONFIG = COMMON_BUILDER.build();
    }*/
}
