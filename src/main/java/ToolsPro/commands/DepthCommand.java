package ToolsPro.commands;

import ToolsPro.ToolsPro;
import ToolsPro.util.Message;
import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;

/**
 * Created by Pub4Game on 19.12.2015.
 */
public class DepthCommand extends ToolsProCommand {

    private ToolsPro plugin;

    public DepthCommand(ToolsPro plugin) {
        super("depth",Message.CMD_DEPTH_DESC, "/depth");
        this.setPermission("toolspro.commands.depth");
        this.plugin = plugin;
    }

    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!sender.hasPermission(this.getPermission())) {
            sender.sendMessage(this.getPermissionMessage());
        }else if (sender instanceof Player) {
            int pos = ((Player) sender).getFloorY()-63;
            if (pos>0) Message.CMD_DEPTH_ABOVE.print(sender,Math.abs(pos));
            else Message.CMD_DEPTH_BELOW.print(sender,Math.abs(pos));
            //sender.sendMessage(TextFormat.colorize("You're " + ((pos - 63) == 0 ? "at" : (Math.abs(pos) + " meters " + (pos > 0 ? "above" : "below"))) + " the sea level."));
        }else{
            Message.NEEDPLAYER.print(sender,'c');
            //sender.sendMessage(TextFormat.colorize("&cПожалуйста, используйте эту команду только в игре!"));
        }
        return true;
    }
}