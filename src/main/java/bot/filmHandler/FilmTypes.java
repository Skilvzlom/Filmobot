package bot.filmHandler;

import java.util.HashSet;
import java.util.Set;

import static settings.enums.Genres.*;

public class FilmTypes {
    
    public static Set<String> types(){
        Set<String> types = new HashSet<>();

        types.add("Фильм"+ ACTION.getGenre());
        types.add("Фильм"+ DRAMA.getGenre());
        types.add("Фильм"+ COMEDY.getGenre());
        types.add("Фильм"+ THRILLER.getGenre());
        types.add("Фильм"+ FANTASTIC.getGenre());
        types.add("Фильм"+ FANTASY.getGenre());
        types.add("Фильм"+ DETECTIVE.getGenre());
        types.add("Фильм"+ HORROR.getGenre());
        types.add("Фильм"+ CARTOON.getGenre());
        types.add("Фильм"+ MELODRAMA.getGenre());
        types.add("Фильм"+ ADVENTURE.getGenre());
        types.add("Фильм"+ MILITARY.getGenre());
        types.add("Фильм"+ FAMILY.getGenre());
        types.add("Фильм"+ HISTORICAL.getGenre());
        types.add("Фильм"+ DOCUMENTARY.getGenre());
        types.add("Фильм"+ CHILDREN.getGenre());
        types.add("Фильм"+ CRIME.getGenre());
        types.add("Фильм"+ WESTERN.getGenre());

        return types;
    }
}
