package settings;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;

import java.io.File;
import java.net.URI;

public class Sender {
    public static SendMessage sendMessage(long chatId, String text){

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(text);
        return sendMessage;
    }
    public static SendPhoto sendPhotoFromInternet(long chatId, String photoPath){
        File img = new File(URI.create(photoPath));
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);
        sendPhoto.setPhoto(new InputFile(img));
        return sendPhoto;
    }
}
