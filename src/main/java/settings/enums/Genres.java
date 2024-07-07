package settings.enums;

public enum Genres {
    ACTION ("Боевик"), //0
    DRAMA("Драма"), //1
    COMEDY("Комедия"),//2
    THRILLER("Триллер"),//3
    FANTASTIC("Фантастика"),//4
    FANTASY("Фэнтези"),//5
    DETECTIVE("Детектив"),//6
    HORROR("Ужасы"),//7
    CARTOON("Мультфильмы"),//8
    MELODRAMA("Мелодрама"),//9
    ADVENTURE("Приключение"),//10
    MILITARY("Военные"),//11
    FAMILY("Семейные"),//12
    HISTORICAL("Исторические"),//13
    DOCUMENTARY("Документальный"),//14
    CHILDREN("Детские"),//15
    CRIME("Криминал"),//16
    WESTERN("Вестерн");//17


    private final String genre;

    Genres(String genre){
        this.genre = genre;
    }
    public String getGenre(){
        return genre;
    }
}
