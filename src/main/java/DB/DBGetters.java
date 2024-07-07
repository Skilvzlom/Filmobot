package DB;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

@Slf4j
public class DBGetters {

    private static Connection connection = DBConnector.getConnection();

    public static boolean hasUser(long userId){
        int count = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT count(*) FROM " + DBConst.USERTABLE + " WHERE id = " + userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                count = resultSet.getInt("COUNT(*)");
            }
            if (count > 0){
                return true;
            }
        } catch (SQLException e){
            log.warn("Error with get User");

        }
        return false;
    }
    public static Boolean[] getSerialFlags(long userId){
        if (hasUser(userId)) {
            Boolean[] genreFlags = new Boolean[18];
            String response = String.format("SELECT * FROM %s.%s WHERE id = %d;", DBConst.DATABASE, DBConst.SERIALTABLE, userId);
            try {
                ResultSet resultSet = connection.prepareStatement(response).executeQuery();
                while (resultSet.next()) {
                    genreFlags[0] = resultSet.getBoolean(DBConst.ACTION);
                    genreFlags[1] = resultSet.getBoolean(DBConst.DRAMA);
                    genreFlags[2] = resultSet.getBoolean(DBConst.COMEDY);
                    genreFlags[3] = resultSet.getBoolean(DBConst.THRILLER);
                    genreFlags[4] = resultSet.getBoolean(DBConst.FANTASTIC);
                    genreFlags[5] = resultSet.getBoolean(DBConst.FANTASY);
                    genreFlags[6] = resultSet.getBoolean(DBConst.DETECTIVE);
                    genreFlags[7] = resultSet.getBoolean(DBConst.HORROR);
                    genreFlags[8] = resultSet.getBoolean(DBConst.CARTOON);
                    genreFlags[9] = resultSet.getBoolean(DBConst.MELODRAMA);
                    genreFlags[10] = resultSet.getBoolean(DBConst.ADVENTURE);
                    genreFlags[11] = resultSet.getBoolean(DBConst.MILITARY);
                    genreFlags[12] = resultSet.getBoolean(DBConst.FAMILY);
                    genreFlags[13] = resultSet.getBoolean(DBConst.HISTORICAL);
                    genreFlags[14] = resultSet.getBoolean(DBConst.DOCUMENTARY);
                    genreFlags[15] = resultSet.getBoolean(DBConst.CHILDREN);
                    genreFlags[16] = resultSet.getBoolean(DBConst.CRIME);
                    genreFlags[17] = resultSet.getBoolean(DBConst.WESTERN);
                }
                return genreFlags;
            } catch (SQLException e) {
                log.warn("Error with gets serial Flags");
            }
        }
        return null;
    }
    public static Boolean[] getFilmFlags(long userId){
        if (hasUser(userId)) {
            Boolean[] genreFlags = new Boolean[18];
            String response = String.format("SELECT * FROM %s.%s WHERE id = %d;", DBConst.DATABASE, DBConst.FILMTABLE, userId);
            try {
                ResultSet resultSet = connection.prepareStatement(response).executeQuery();
                while (resultSet.next()) {
                    genreFlags[0] = resultSet.getBoolean(DBConst.ACTION);
                    genreFlags[1] = resultSet.getBoolean(DBConst.DRAMA);
                    genreFlags[2] = resultSet.getBoolean(DBConst.COMEDY);
                    genreFlags[3] = resultSet.getBoolean(DBConst.THRILLER);
                    genreFlags[4] = resultSet.getBoolean(DBConst.FANTASTIC);
                    genreFlags[5] = resultSet.getBoolean(DBConst.FANTASY);
                    genreFlags[6] = resultSet.getBoolean(DBConst.DETECTIVE);
                    genreFlags[7] = resultSet.getBoolean(DBConst.HORROR);
                    genreFlags[8] = resultSet.getBoolean(DBConst.CARTOON);
                    genreFlags[9] = resultSet.getBoolean(DBConst.MELODRAMA);
                    genreFlags[10] = resultSet.getBoolean(DBConst.ADVENTURE);
                    genreFlags[11] = resultSet.getBoolean(DBConst.MILITARY);
                    genreFlags[12] = resultSet.getBoolean(DBConst.FAMILY);
                    genreFlags[13] = resultSet.getBoolean(DBConst.HISTORICAL);
                    genreFlags[14] = resultSet.getBoolean(DBConst.DOCUMENTARY);
                    genreFlags[15] = resultSet.getBoolean(DBConst.CHILDREN);
                    genreFlags[16] = resultSet.getBoolean(DBConst.CRIME);
                    genreFlags[17] = resultSet.getBoolean(DBConst.WESTERN);
                }
                return genreFlags;
            } catch (SQLException e) {
                log.warn("Error with gets film Flags");
            }
        }
        return null;
    }
    public static Boolean[] getAnimeFlags(long userId){
        if (hasUser(userId)) {
            Boolean[] genreFlags = new Boolean[18];
            String response = String.format("SELECT * FROM %s.%s WHERE id = %d;", DBConst.DATABASE,DBConst.ANIMETABLE, userId);
            try {
                ResultSet resultSet = connection.prepareStatement(response).executeQuery();
                while (resultSet.next()) {
                    genreFlags[0] = resultSet.getBoolean(DBConst.ACTION);
                    genreFlags[1] = resultSet.getBoolean(DBConst.DRAMA);
                    genreFlags[2] = resultSet.getBoolean(DBConst.COMEDY);
                    genreFlags[3] = resultSet.getBoolean(DBConst.THRILLER);
                    genreFlags[4] = resultSet.getBoolean(DBConst.FANTASTIC);
                    genreFlags[5] = resultSet.getBoolean(DBConst.FANTASY);
                    genreFlags[6] = resultSet.getBoolean(DBConst.DETECTIVE);
                    genreFlags[7] = resultSet.getBoolean(DBConst.HORROR);
                    genreFlags[8] = false;
                    genreFlags[9] = resultSet.getBoolean(DBConst.MELODRAMA);
                    genreFlags[10] = resultSet.getBoolean(DBConst.ADVENTURE);
                    genreFlags[11] = resultSet.getBoolean(DBConst.MILITARY);
                    genreFlags[12] = false;
                    genreFlags[13] = resultSet.getBoolean(DBConst.HISTORICAL);
                    genreFlags[14] = resultSet.getBoolean(DBConst.DOCUMENTARY);
                    genreFlags[15] = false;
                    genreFlags[16] = resultSet.getBoolean(DBConst.CRIME);
                    genreFlags[17] = false;
                }
                return genreFlags;
            } catch (SQLException e) {
                log.warn("Error with gets film Flags");
            }
        }
        return null;
    }
    public static boolean getGenreFlag(long userId, String typeTable, String typeGenre){
        if (hasUser(userId)) {
            String response = String.format("SELECT * FROM %s.%s WHERE id = %d;", DBConst.DATABASE, typeTable, userId);
            try {
                ResultSet resultSet = connection.prepareStatement(response).executeQuery();
                boolean flag = false;
                while (resultSet.next()){
                    flag = resultSet.getBoolean(typeGenre);
                }
                return flag;
            } catch (SQLException e){
                log.warn("Error with get Genre Flag");
            }
        }
        return false;
    }
}
