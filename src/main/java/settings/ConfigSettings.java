package settings;

import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Data
@Slf4j
public class ConfigSettings {
    private static String FILE_NAME = "config.properties";

    private String botToken;
    private String botUserName;
    private String XApiToken;
    private String dbUrl;
    private String dbUser;
    private String dbPassword;
    private Properties properties;

    @Getter
    private static ConfigSettings instance = new ConfigSettings();

    {
        try {
            properties = new Properties();
            try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream(FILE_NAME)){
                properties.load(inputStream);
            } catch (IOException e){
                throw new IOException(String.format("Error loading file '%s'", FILE_NAME));
            }

            botToken = properties.getProperty("bot.token");
            if (botToken == null){
                throw new RuntimeException("Bot token is null");
            }

            botUserName = properties.getProperty("bot.username");
            if (botUserName == null){
                throw new RuntimeException("Bot UserName is null");
            }

            XApiToken = properties.getProperty("X-API-TOKEN");
            if (XApiToken == null){
                throw new RuntimeException("X-API-TOKEN is null");
            }

            dbUrl = properties.getProperty("db.url");
            if (dbUrl == null){
                throw new RuntimeException("Database url is null");
            }

            dbUser = properties.getProperty("db.user");
            if(dbUser == null){
                throw new RuntimeException("Database username is null");
            }

            dbPassword = properties.getProperty("db.password");
            if(dbPassword == null){
                throw new RuntimeException("Database password is null");
            }

        } catch (RuntimeException | IOException e){
            log.warn("Error " + e);
        }
    }


}
