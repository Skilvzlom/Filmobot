package bot.startHandler;

import bot.startHandler.inlineKeyboard.StartInlineKeyboard;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import settings.ConfigSettings;
import settings.MessageConst;
import settings.Sender;

import java.io.IOException;

@Slf4j
public class StartSelectionHandler extends TelegramLongPollingBot {
    private static final ConfigSettings config = ConfigSettings.getInstance();
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
        if(update.hasMessage() && update.getMessage().hasText()) {
            long chatId = update.getMessage().getChatId();
            String sendMessage = update.getMessage().getText();
            try {

                if (sendMessage.equals("/start")) {
                    SendMessage message = new SendMessage();
                    message.setChatId(chatId);
                    message.setText("Выбери нужные пункты");
                    execute(Sender.sendMessage(chatId, "Привет, " + update.getMessage().getChat().getUserName() + MessageConst.HELLO));
                    message.setReplyMarkup(StartInlineKeyboard.createStartInlineKeyboard());
                    execute(message);
                } else if (sendMessage.equals("/help")) {
                    execute(Sender.sendMessage(chatId, MessageConst.CHOOSE));
                } else if (sendMessage.equals("/thanks")) {
                    execute(Sender.sendMessage(chatId, MessageConst.THANKS));
                }
            } catch (TelegramApiException e){
                log.warn("Error with / commands" + e);
            }
        } else if (update.hasCallbackQuery()) {
            long chatId = update.getCallbackQuery().getMessage().getChatId();
            String callData = update.getCallbackQuery().getData();
            int messageId = update.getCallbackQuery().getMessage().getMessageId();
            if (callData.equals("Back")) {
                EditMessageReplyMarkup message = new EditMessageReplyMarkup();
                message.setMessageId(messageId);
                message.setChatId(chatId);
                message.setReplyMarkup(StartInlineKeyboard.createStartInlineKeyboard());
                try {
                    execute(message);
                }catch (TelegramApiException e){
                    log.warn("Error " + e);
                }
            }
        }
    }
}
