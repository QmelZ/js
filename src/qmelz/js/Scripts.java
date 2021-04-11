package qmelz.js;

import arc.Core;
import arc.Events;
import arc.struct.Seq;
import mindustry.Vars;
import mindustry.game.EventType;
import mindustry.mod.Mod;

public class Scripts extends Mod{

    public Util util = new Util();

    @Override
    public void loadContent(){
        Vars.enableConsole = true;
        try{
            util.set(Vars.mods.getScripts().getClass(), "blacklist", Seq.with());
        }catch(Throwable c){
            Events.on(EventType.ClientLoadEvent.class, event -> {
                Vars.mods.setEnabled(Vars.mods.locateMod("js-unblacklist"), false);
                Vars.ui.showErrorMessage("your java version isn't compatible with js unblacklist, use java 8 or 11 to fix this issue");
                if(Core.scene.getDialog() != null) Core.scene.getDialog().hidden(Core.app::exit);
            });
        }
        // Vars.mods.getScripts().runConsole("this[\"Util\"] = Vars.mods.locateMod(\"js-unblacklist\").main.util");
    }
}
