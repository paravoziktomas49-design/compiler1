package com.instakill.botmod;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChatHandler {

    @SubscribeEvent
    public void onChat(ClientChatEvent event) {
        String msg = event.getMessage();

        // Проверка: начинается ли сообщение с одной из наших команд
        if (isBotCommand(msg)) {
            
            // 1. Отменяем отправку сообщения на сервер, чтобы не спалиться
            event.setCanceled(true);
            
            // 2. Убираем слеш (например, "/attackb" станет "attackb")
            String cleanCommand = msg.substring(1); 
            
            // 3. Отправляем скрытое ЛС боту. 
            // Убедись, что ник бота в игре совпадает с "SuperBot"
            Minecraft.getMinecraft().player.sendChatMessage("/msg SuperBot " + cleanCommand);
            
            // 4. Пишем подтверждение в твой локальный чат
            Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(
                new TextComponentString("§b[BotSupport] §fКоманда отправлена: §a" + cleanCommand)
            );
        }
    }

    // Вспомогательный метод, чтобы не писать длинный IF
    private boolean isBotCommand(String msg) {
        return msg.startsWith("/attackb") || 
               msg.startsWith("/followb") || 
               msg.startsWith("/safeb")   || 
               msg.startsWith("/stopb")    || 
               msg.startsWith("/critmode") || 
               msg.startsWith("/whereb")   || 
               msg.startsWith("/nearb")    || 
               msg.startsWith("/cmdb");
    }
}