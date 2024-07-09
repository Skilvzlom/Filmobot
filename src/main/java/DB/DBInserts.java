package DB;

import lombok.extern.slf4j.Slf4j;
import static settings.enums.Genres.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
public class DBInserts {
    private static final Connection connection = DBConnector.getConnection();

    public static void insertNewUser(long userId, String username){
            String userResponse = String.format("INSERT IGNORE INTO %s.%s SET %s = %d, %s = '%s';", DBConst.DATABASE, DBConst.USERTABLE,
                    DBConst.ID, userId, DBConst.USERNAME, username);
            try {
                connection.prepareStatement(userResponse).execute();
            } catch (SQLException e) {
                throw new RuntimeException("Error with adding user");
            }
            String filmResponse = String.format("INSERT IGNORE INTO %s.%s SET %s = %d, %s = 0, %s = 0, %s = 0,%s = 0,%s = 0,%s = 0,%s = 0,%s = 0," +
                            "%s = 0,%s = 0,%s = 0,%s = 0,%s = 0,%s = 0,%s = 0,%s = 0,%s = 0,%s = 0;", DBConst.DATABASE,
                    DBConst.FILMTABLE, DBConst.ID, userId, DBConst.ACTION, DBConst.COMEDY, DBConst.ADVENTURE, DBConst.CARTOON, DBConst.CHILDREN,
                    DBConst.CRIME, DBConst.DETECTIVE, DBConst.DRAMA, DBConst.FAMILY, DBConst.FANTASTIC, DBConst.FANTASY, DBConst.DOCUMENTARY,
                    DBConst.HISTORICAL, DBConst.HORROR, DBConst.MELODRAMA, DBConst.THRILLER, DBConst.MILITARY, DBConst.WESTERN);
            String serialResponse = String.format("INSERT IGNORE INTO %s.%s SET %s = %d, %s = 0, %s = 0, %s = 0,%s = 0,%s = 0,%s = 0,%s = 0,%s = 0," +
                            "%s = 0,%s = 0,%s = 0,%s = 0,%s = 0,%s = 0,%s = 0,%s = 0,%s = 0,%s = 0;", DBConst.DATABASE,
                    DBConst.SERIALTABLE, DBConst.ID, userId, DBConst.ACTION, DBConst.COMEDY, DBConst.ADVENTURE, DBConst.CARTOON, DBConst.CHILDREN,
                    DBConst.CRIME, DBConst.DETECTIVE, DBConst.DRAMA, DBConst.FAMILY, DBConst.FANTASTIC, DBConst.FANTASY, DBConst.DOCUMENTARY,
                    DBConst.HISTORICAL, DBConst.HORROR, DBConst.MELODRAMA, DBConst.THRILLER, DBConst.MILITARY, DBConst.WESTERN);
            String animeResponse = String.format("INSERT IGNORE INTO %s.%s SET %s = %d, %s = 0, %s = 0, %s = 0,%s = 0,%s = 0,%s = 0,%s = 0,%s = 0," +
                            "%s = 0,%s = 0,%s = 0,%s = 0,%s = 0,%s = 0;", DBConst.DATABASE,
                    DBConst.ANIMETABLE, DBConst.ID, userId, DBConst.ACTION, DBConst.COMEDY, DBConst.ADVENTURE,
                    DBConst.CRIME, DBConst.DETECTIVE, DBConst.DRAMA, DBConst.FANTASTIC, DBConst.FANTASY, DBConst.DOCUMENTARY,
                    DBConst.HISTORICAL, DBConst.HORROR, DBConst.MELODRAMA, DBConst.THRILLER, DBConst.MILITARY);
            try {
                connection.prepareStatement(filmResponse).execute();
                connection.prepareStatement(serialResponse).execute();
                connection.prepareStatement(animeResponse).execute();
            } catch (SQLException e) {
                System.out.println("Error1");
                log.warn("Error with create new user");
            }
    }

    public static void insertIntoGenres(long userId, String callData){
        String typeTable = "";
        String typeGenre = "";
        if (callData.contains("Сериал")){
            typeTable = DBConst.SERIALTABLE;
        } else if (callData.contains("Фильм")){
            typeTable = DBConst.FILMTABLE;
        } else if (callData.contains("Аниме")){
            typeTable = DBConst.ANIMETABLE;
        }
        if (callData.contains(ACTION.getGenre())){
            typeGenre = DBConst.ACTION;
        } else if(callData.contains(DRAMA.getGenre())){
            typeGenre = DBConst.DRAMA;
        } else if (callData.contains(COMEDY.getGenre())) {
            typeGenre = DBConst.COMEDY;
        } else if (callData.contains(THRILLER.getGenre())) {
            typeGenre = DBConst.THRILLER;
        } else if (callData.contains(FANTASTIC.getGenre())) {
            typeGenre = DBConst.FANTASTIC;
        } else if (callData.contains(FANTASY.getGenre())) {
            typeGenre = DBConst.FANTASY;
        } else if (callData.contains(DETECTIVE.getGenre())) {
            typeGenre = DBConst.DETECTIVE;
        } else if (callData.contains(HORROR.getGenre())){
            typeGenre = DBConst.HORROR;
        } else if (callData.contains(CARTOON.getGenre())){
            typeGenre = DBConst.CARTOON;
        } else if (callData.contains(MELODRAMA.getGenre())) {
            typeGenre = DBConst.MELODRAMA;
        } else if (callData.contains(ADVENTURE.getGenre())) {
            typeGenre = DBConst.ADVENTURE;
        } else if (callData.contains(MILITARY.getGenre())) {
            typeGenre = DBConst.MILITARY;
        } else if (callData.contains(FAMILY.getGenre())) {
            typeGenre = DBConst.FAMILY;
        } else if (callData.contains(HISTORICAL.getGenre())) {
            typeGenre = DBConst.HISTORICAL;
        } else if (callData.contains(DOCUMENTARY.getGenre())) {
            typeGenre = DBConst.DOCUMENTARY;
        } else if (callData.contains(CHILDREN.getGenre())){
            typeGenre = DBConst.CHILDREN;
        } else if (callData.contains(CRIME.getGenre())) {
            typeGenre = DBConst.CRIME;
        } else if (callData.contains(WESTERN.getGenre())) {
            typeGenre = DBConst.WESTERN;
        }
        String response = "";
        if (DBGetters.getGenreFlag(userId, typeTable, typeGenre)){
            response = String.format("UPDATE %s.%s SET %s = 0 WHERE id = %d;", DBConst.DATABASE, typeTable, typeGenre, userId);
        } else {
            response = String.format("UPDATE %s.%s SET %s = 1 WHERE id = %d;", DBConst.DATABASE, typeTable, typeGenre, userId);
        }

        try{
            connection.prepareStatement(response).execute();
        }catch (SQLException e){
            log.warn("Error with update genre flag");
        }
    }
}
