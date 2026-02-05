package com.instakill.botmod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

// Здесь мы указываем ID мода (как в mcmod.info), имя и версию
@Mod(modid = "botsupport", name = "Simple Bot Support", version = "1.0")
public class BotMod {

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        // ЭТА СТРОЧКА САМАЯ ВАЖНАЯ:
        // Она регистрирует твой ChatHandler в системе событий Forge.
        // Без неё ChatHandler будет просто текстом, и команды не будут ловиться.
        MinecraftForge.EVENT_BUS.register(new ChatHandler());
    }
}