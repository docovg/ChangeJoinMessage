package fr.atmoz.changejoinmessage;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	private static Main instance;
	@Override
	public void onEnable() {
        instance = this;
        saveDefaultConfig();
        
        getServer().getPluginManager().registerEvents(new Listeners(), this);
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
	} 
	
    public static Main getInstance() {
        return instance;
    }
}
