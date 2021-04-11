package qmelz.js;

import arc.struct.Seq;
import mindustry.Vars;
import mindustry.mod.Mod;

public class Scripts extends Mod{

    public Util util = new Util();

    @Override
    public void loadContent(){
        Vars.enableConsole = true;
        util.set(Vars.mods.getScripts().getClass(), "blacklist", Seq.with());
        Vars.mods.getScripts().runConsole("this[\"Util\"] = Vars.mods.locateMod(\"js-unblacklist\").main.util");
    }
}
