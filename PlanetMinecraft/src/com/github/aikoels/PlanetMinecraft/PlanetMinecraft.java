package com.github.aikoels.PlanetMinecraft;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class PlanetMinecraft extends JavaPlugin implements Runnable {

	Thread t = null;
	
	@Override
	public void onEnable()
	{
		t = new Thread(new PlanetMinecraft());
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		if(commandLabel.equalsIgnoreCase("planetminecraft"))
		{
			if (args.length == 0)
			{
				if(sender instanceof Player)
				{
					Player p = (Player)sender;

					if(sender.hasPermission("PlanetMinecraft.Use"))
					{
						ItemStack itemstack = new ItemStack(Material.DIRT, 64);
						Inventory i = p.getInventory();
						p.sendMessage(ChatColor.AQUA + "Please, Do Not Troll.");
						i.clear(); 
						i.addItem(itemstack); 
						try{
							Thread.sleep(5000);
						}catch(InterruptedException e) {}
						p.setHealth(0); 
						p.getWorld().strikeLightningEffect(p.getLocation());
						p.getWorld().createExplosion(p.getLocation(), 0);
						getServer().broadcastMessage(ChatColor.BLUE + p.getDisplayName() + ChatColor.BLUE + " thinks they are from planetminecraft!"); 
	
						return true;		
					}
				}else
				{
					sender.sendMessage("As a console, you can't issue commands!");
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public void run() 
	{
		
	}
}


	
