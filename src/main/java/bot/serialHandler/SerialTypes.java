package bot.serialHandler;

import static settings.enums.Genres.*;

import java.util.HashSet;
import java.util.Set;

public class SerialTypes {

    public static Set<String> types(){
        Set<String> types = new HashSet<>();

        types.add("Сериал"+ ACTION.getGenre());
        types.add("Сериал" + DRAMA.getGenre());
        types.add("Сериал"+  COMEDY.getGenre());
        types.add("Сериал"+ THRILLER.getGenre());
        types.add("Сериал"+ FANTASTIC.getGenre());
        types.add("Сериал"+ FANTASY.getGenre());
        types.add("Сериал"+ DETECTIVE.getGenre());
        types.add("Сериал"+ HORROR.getGenre());
        types.add("Сериал"+ CARTOON.getGenre());
        types.add("Сериал"+ MELODRAMA.getGenre());
        types.add("Сериал"+ ADVENTURE.getGenre());
        types.add("Сериал"+ MILITARY.getGenre());
        types.add("Сериал"+ FAMILY.getGenre());
        types.add("Сериал"+ HISTORICAL.getGenre());
        types.add("Сериал"+ DOCUMENTARY.getGenre());
        types.add("Сериал"+ CHILDREN.getGenre());
        types.add("Сериал"+ CRIME.getGenre());
        types.add("Сериал"+ WESTERN.getGenre());

        return types;
    }
}
