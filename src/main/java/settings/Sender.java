package settings;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class Sender {
    public static SendMessage sendMessage(long chatId, String text){

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(text);
        return sendMessage;
    }
}
