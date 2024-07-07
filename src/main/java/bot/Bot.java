package bot;

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
import settings.ConfigSettings;
import settings.MessageConst;
import settings.Sender;

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

            if (StartTypes.types().contains(messageText)){
                start.onUpdateReceived(update);
            } else {
                execute(Sender.sendMessage(chatId, "Unrecognized message"));
            }
        } else if (update.hasCallbackQuery()){
            log.info("Replied to " + update.getCallbackQuery().getMessage().getChat().getUserName());
            String call_data = update.getCallbackQuery().getData();
            if (call_data.equals("Фильм")){
                film.onUpdateReceived(update);
            } else if (call_data.equals("Сериал")){
                serial.onUpdateReceived(update);
            } else if (call_data.equals("Аниме")){
                anime.onUpdateReceived(update);
            } else if (call_data.equals("Random")){

            } else if (SerialTypes.types().contains(call_data)){
                serial.onUpdateReceived(update);
            } else if (AnimeTypes.types().contains(call_data)){
                anime.onUpdateReceived(update);
            } else if (FilmTypes.types().contains(call_data)){
                film.onUpdateReceived(update);
            } else if (call_data.equals("Back")){
                start.onUpdateReceived(update);
            }
        }
    }


}


