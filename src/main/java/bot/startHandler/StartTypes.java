package bot.startHandler;

import java.util.HashSet;
import java.util.Set;

public class StartTypes {
    public static Set<String> types(){
        Set<String> types = new HashSet<>();

        types.add("/start");
        types.add("/help");
        types.add("/thanks");
        return types;
    }
}
