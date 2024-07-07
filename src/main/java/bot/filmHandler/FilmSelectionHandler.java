package bot.filmHandler;

import bot.filmHandler.inlineKeyboard.FilmInlineKeyboard;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import settings.ConfigSettings;
@Slf4j
public class FilmSelectionHandler extends TelegramLongPollingBot {
    private final static ConfigSettings config = ConfigSettings.getInstance();
    @Override
    public String getBotUsername() {
        return config.getBotUserName();
    }

    @Override
    public String getBotToken() {
        return config.getBotToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasCallbackQuery()){
            int messageId = update.getCallbackQuery().getMessage().getMessageId();
            long chatId = update.getCallbackQuery().getMessage().getChatId();
            String callData = update.getCallbackQuery().getData();

            if (callData.equals("Фильм")){
                try{
                    execute(FilmInlineKeyboard.filmInlineKeyboard(chatId, messageId));
                } catch (TelegramApiException e){
                    log.warn("Error " + e);
                }
            }
        }
    }
}
