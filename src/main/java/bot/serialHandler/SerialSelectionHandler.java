package bot.serialHandler;

import DB.DBGetters;
import DB.DBInserts;
import bot.serialHandler.inlineKeyboard.SerialInlineKeyboard;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import settings.ConfigSettings;
import settings.GetFormattingMessagePhoto;
import settings.GetResponse;

import java.net.http.HttpResponse;

@Slf4j
public class SerialSelectionHandler extends TelegramLongPollingBot {
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
        if(update.hasCallbackQuery()) {
            int messageId = update.getCallbackQuery().getMessage().getMessageId();
            long chatId = update.getCallbackQuery().getMessage().getChatId();
            long userId = update.getCallbackQuery().getFrom().getId();
            String callData = update.getCallbackQuery().getData();

            if (callData.equals("Сериал")) {
                try {
                    execute(SerialInlineKeyboard.serialInlineKeyboard(chatId, messageId, userId));
                } catch (TelegramApiException e) {
                    log.warn("Error " + e);
                }
            } else if (SerialTypes.types().contains(callData)) {
                DBInserts.insertIntoGenres(userId, callData);
                try {
                    execute(SerialInlineKeyboard.serialInlineKeyboard(chatId, messageId, userId));
                } catch (TelegramApiException e){
                    log.warn("Error with serial buttons " + e);
                }
            } else if (callData.equals("ПолучитьСериал")) {
                HttpResponse<String> response = GetResponse.getResponse(callData, DBGetters.getSerialFlags(userId));
                try {
                    //execute(GetFormattingMessagePhoto.sendPhoto(chatId, response));
                    execute(GetFormattingMessagePhoto.formatMessage(chatId, response));
                }catch (TelegramApiException e ){
                    System.out.println("Error");
                }
            }
        }
    }
}
