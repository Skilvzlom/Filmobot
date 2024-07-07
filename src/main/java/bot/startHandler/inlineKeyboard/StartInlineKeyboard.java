package bot.startHandler.inlineKeyboard;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class StartInlineKeyboard {

    public static InlineKeyboardMarkup createStartInlineKeyboard(){

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> rowsList = new ArrayList<>();
        List<InlineKeyboardButton> rowButton1 = new ArrayList<>();
        List<InlineKeyboardButton> rowButton2 = new ArrayList<>();

        InlineKeyboardButton inlineKeyboardButton11 = new InlineKeyboardButton();
        inlineKeyboardButton11.setText("Фильм");
        inlineKeyboardButton11.setCallbackData("Фильм");
        InlineKeyboardButton inlineKeyboardButton12 = new InlineKeyboardButton();
        inlineKeyboardButton12.setText("Сериал");
        inlineKeyboardButton12.setCallbackData("Сериал");
        InlineKeyboardButton inlineKeyboardButton13 = new InlineKeyboardButton();
        inlineKeyboardButton13.setText("Аниме");
        inlineKeyboardButton13.setCallbackData("Аниме");

        InlineKeyboardButton inlineKeyboardButton21 = new InlineKeyboardButton();
        inlineKeyboardButton21.setText("Что-то случайное");
        inlineKeyboardButton21.setCallbackData("Random");

        rowButton1.add(inlineKeyboardButton11);
        rowButton1.add(inlineKeyboardButton12);
        rowButton1.add(inlineKeyboardButton13);

        rowButton2.add(inlineKeyboardButton21);

        rowsList.add(rowButton1);
        rowsList.add(rowButton2);

        inlineKeyboardMarkup.setKeyboard(rowsList);


        return inlineKeyboardMarkup;
    }
}
