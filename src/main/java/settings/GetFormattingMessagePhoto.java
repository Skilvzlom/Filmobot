package settings;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetFormattingMessagePhoto {

    public static SendMessage formatMessage(long chatId, HttpResponse<String> response){
        SendMessage sendMessage = new SendMessage();

        InlineKeyboardMarkup inlineMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton inlineButton = new InlineKeyboardButton();
        List<List<InlineKeyboardButton>> rowsMarkup = new ArrayList<>();
        List<InlineKeyboardButton> row1Markup = new ArrayList<>();



        ObjectMapper mapper = new ObjectMapper();
        String message = "Error";
        if (response != null) {
            try {
                Map<String, ArrayList<Map<String, String>>> mapResponse = mapper.readValue(response.body(), Map.class);
                Map<String, Map<String, ArrayList<Map<String, String>>>> mapURL = mapper.readValue(response.body(), Map.class);
                inlineButton.setUrl(mapURL.get("videos").get("trailers").get(0).get("url"));
                inlineButton.setText("Трейлер");
                message = String.format("Название: %s\n" +
                        "Рейтинг: %.2f\n" +
                        "Год выхода: %d\n" +
                        "Описание: %s", mapResponse.get("names").get(0).get("name"), mapURL.get("rating").get("kp"), mapResponse.get("year"), mapResponse.get("description"));
            } catch (IOException e){
                System.out.println("Error with response");
            }
        }
        row1Markup.add(inlineButton);
        rowsMarkup.add(row1Markup);
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);
        inlineMarkup.setKeyboard(rowsMarkup);
        sendMessage.setReplyMarkup(inlineMarkup);
        return sendMessage;
    }

    public static SendPhoto sendPhoto(long chatId, HttpResponse<String> response){
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(chatId);

        ObjectMapper mapper = new ObjectMapper();
        if (response != null){
            try {
                Map<String, Map<String, String>> mapPhoto = mapper.readValue(response.body(), Map.class);
                String stringUrl = mapPhoto.get("poster").get("url");
                URL url = new URL(stringUrl);
                url.openConnection();
                File img = new File(url.toURI());
                System.out.println("waiiitt");
                sendPhoto.setPhoto(new InputFile(img));
            } catch (IOException | URISyntaxException e){
                System.out.println("Error with photo");
            }
        }

        return sendPhoto;
    }
}
