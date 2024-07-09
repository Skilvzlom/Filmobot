package bot;

import DB.DBGetters;
import DB.DBInserts;
import bot.animeHandler.AnimeSelectionHandler;
import bot.animeHandler.AnimeTypes;
import bot.filmHandler.FilmSelectionHandler;
import bot.filmHandler.FilmTypes;
import bot.serialHandler.SerialSelectionHandler;
import bot.serialHandler.SerialTypes;
import bot.startHandler.StartSelectionHandler;
import bot.startHandler.StartTypes;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import settings.ConfigSettings;
import settings.GetFormattingMessagePhoto;
import settings.GetResponse;
import settings.Sender;

import java.util.Arrays;

@Slf4j
public class Bot extends TelegramLongPollingBot {
    private final static ConfigSettings settings = ConfigSettings.getInstance();
    StartSelectionHandler start = new StartSelectionHandler();
    SerialSelectionHandler serial = new SerialSelectionHandler();
    FilmSelectionHandler film = new FilmSelectionHandler();
    AnimeSelectionHandler anime = new AnimeSelectionHandler();
    @Override
    public String getBotToken() {
        return settings.getBotToken();
    }

    @Override
    public String getBotUsername() {
        return settings.getBotUserName();
    }

    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {
        System.out.println(update.toString());
        long chatId;
        if (update.hasMessage() && update.getMessage().hasText()){

            log.info("Replied to " + update.getMessage().getChat().getUserName());
            String messageText = update.getMessage().getText();
            chatId = update.getMessage().getChatId();
            long userId = update.getMessage().getFrom().getId();
            String username = update.getMessage().getChat().getUserName();
            if (!DBGetters.hasUser(userId)){
                DBInserts.insertNewUser(userId, username);
            }
            if (StartTypes.types().contains(messageText)){
                start.onUpdateReceived(update);
            } else {
                execute(Sender.sendMessage(chatId, "Unrecognized message"));
            }
        } else if (update.hasCallbackQuery()){
            log.info("Replied to " + update.getCallbackQuery().getMessage().getChat().getUserName());
            String call_data = update.getCallbackQuery().getData();
            chatId = update.getCallbackQuery().getMessage().getChatId();
            long userId = update.getCallbackQuery().getMessage().getFrom().getId();
            String username = update.getCallbackQuery().getMessage().getChat().getUserName();
            if (!DBGetters.hasUser(userId)){
                DBInserts.insertNewUser(userId, username);
            }
            if (call_data.contains("Фильм")){
                film.onUpdateReceived(update);
            } else if (call_data.contains("Сериал")){
                serial.onUpdateReceived(update);
            } else if (call_data.contains("Аниме")){
                anime.onUpdateReceived(update);
            } else if (call_data.contains("Random")){
                Boolean[] flags = null;
                try{
                    execute(GetFormattingMessagePhoto.formatMessage(chatId, GetResponse.getResponse(null, null)));
                } catch (TelegramApiException e){
                    System.out.println("Error");
                }

            } else if (call_data.equals("Back")){
                start.onUpdateReceived(update);
            }
        }
    }


}


