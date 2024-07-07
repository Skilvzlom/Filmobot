package bot.animeHandler;

import java.util.HashSet;
import java.util.Set;

import static settings.enums.Genres.*;
import static settings.enums.Genres.WESTERN;

public class AnimeTypes {
    
    public static Set<String> types(){

        Set<String> types = new HashSet<>();

        types.add("Аниме"+ ACTION.getGenre());
        types.add("Аниме" + DRAMA.getGenre());
        types.add("Аниме"+  COMEDY.getGenre());
        types.add("Аниме"+ THRILLER.getGenre());
        types.add("Аниме"+ FANTASTIC.getGenre());
        types.add("Аниме"+ FANTASY.getGenre());
        types.add("Аниме"+ DETECTIVE.getGenre());
        types.add("Аниме"+ HORROR.getGenre());
        types.add("Аниме"+ MELODRAMA.getGenre());
        types.add("Аниме"+ ADVENTURE.getGenre());
        types.add("Аниме"+ MILITARY.getGenre());
        types.add("Аниме"+ HISTORICAL.getGenre());
        types.add("Аниме"+ DOCUMENTARY.getGenre());
        types.add("Аниме"+ CRIME.getGenre());

        return types;
    }
}
