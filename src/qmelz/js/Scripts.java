package qmelz.js;

import arc.*;
import arc.struct.*;
import arc.util.*;
import mindustry.*;
import mindustry.game.*;
import mindustry.mod.*;

public class Scripts extends Mod{
    {
        Vars.enableConsole = true;
        try{
            Reflect.<Seq<String>>get(Vars.mods.getScripts().getClass(), "blacklist").clear();
        }catch(Throwable c){
            Log.err(c); // might be helpful for debugging
            Events.on(EventType.ClientLoadEvent.class, event -> {
                Vars.mods.setEnabled(Vars.mods.locateMod("js-unblacklist"), false);
                Vars.ui.showErrorMessage("an error occured while unblacklisting js\nthe game will now exit to disable js unblacklister");
                if(Core.scene.getDialog() != null) Core.scene.getDialog().hidden(Core.app::exit);
            });
        }
    }
}
