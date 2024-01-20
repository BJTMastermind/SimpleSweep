package me.bjtmastermind.simplesweep;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleSweep implements ModInitializer {
    public static final String MOD_ID = "simplesweep";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // Config.loadConfig(Config.COMMON_CONFIG, FabricLoader.getInstance().getConfigDir().resolve("simplesweep-common.toml"));

        AttackEntityCallback.EVENT.register((PlayerEntity player, World world, Hand hand, Entity entity, EntityHitResult hitResult) -> {
            if ((Config.onlyCrouch && !player.isSneaking()) ||
                (!Config.onlyCrouch && EnchantmentHelper.getSweepingMultiplier(player) == 0.0F)) {
                ItemStack heldItemMainHand = player.getMainHandStack();
                Identifier weaponLocation = Registries.ITEM.getId(heldItemMainHand.getItem());
                assert weaponLocation != null;
                List<? extends String> whitelist = Config.whitelist;
                boolean isInWhitelist = false;
                for (String item : whitelist) {
                    if (weaponLocation.equals(new Identifier(item))) {
                        isInWhitelist = true;
                        break;
                    }
                }

                List<? extends String> blacklist = Config.blacklist;
                boolean isInBlacklist = false;
                for (String item : blacklist) {
                    if (weaponLocation.equals(new Identifier(item))) {
                        isInBlacklist = true;
                        break;
                    }
                }

                if ((isInWhitelist || (whitelist.size() == 0 && !isInBlacklist)) && player.isOnGround()) {
                    // Set player (for this tick) to onGround = false
                    player.setOnGround(false);
                }
            }
            return ActionResult.PASS;
        });
    }
}