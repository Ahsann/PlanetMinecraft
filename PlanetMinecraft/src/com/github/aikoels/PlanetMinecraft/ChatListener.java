package com.github.aikoels.PlanetMinecraft;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import com.github.aikoels.PlanetMinecraft.PlanetMinecraft; 

@SuppressWarnings("deprecation")
public class ChatListener implements Listener {
    PlanetMinecraft plugin;
    public ChatListener(PlanetMinecraft instance) {
    plugin = instance;
    }
    @EventHandler
    public void onPlayerChat(PlayerChatEvent event){
    	Player p = event.getPlayer(); 
    	
    	if(event.getMessage().contains("I")){
    		if(event.getMessage().contains("from")){
    			if(event.getMessage().contains("planetminecraft")){
    				if(event.getMessage().contains("have")){
    					if(event.getMessage().contains("op")){
    						if(p.hasPermission("PlanetMinecraft.Use"))
    						{
    							ItemStack itemstack = new ItemStack(Material.DIRT, 64);
    							Inventory i = p.getInventory();
    							event.getMessage();
    							event.setMessage(ChatColor.RED + "I am a troll."); 
    							p.sendMessage(ChatColor.AQUA + "Please, Do Not Troll.");
								i.clear(); 
								try{
								Thread.sleep(5000);
								}catch(InterruptedException e) {}
								p.setHealth(0); 
								p.getWorld().strikeLightningEffect(p.getLocation());
								p.getWorld().createExplosion(p.getLocation(), 0);
								p.getServer().broadcastMessage(ChatColor.BLUE + p.getDisplayName() + ChatColor.BLUE + " thinks they are from planetminecraft!");
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {}
								i.addItem(itemstack); 
    						}
    	}
    }
}
    		}
    	}
    }
}


