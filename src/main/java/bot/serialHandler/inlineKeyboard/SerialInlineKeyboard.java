package bot.serialHandler.inlineKeyboard;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

import static settings.enums.Genres.*;

public class SerialInlineKeyboard {
    public static EditMessageReplyMarkup serialInlineKeyboard(long chatId, int messageId){
        EditMessageReplyMarkup message = new EditMessageReplyMarkup();
        message.setChatId(String.valueOf(chatId));
        message.setMessageId(messageId);
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline2 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline4 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline5 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline6 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline7 = new ArrayList<>();

        InlineKeyboardButton inlineKeyboardButton11 = new InlineKeyboardButton();
        inlineKeyboardButton11.setText(ACTION.getGenre());
        inlineKeyboardButton11.setCallbackData("Сериал"+ACTION.getGenre());
        InlineKeyboardButton inlineKeyboardButton12 = new InlineKeyboardButton();
        inlineKeyboardButton12.setCallbackData("Сериал"+COMEDY.getGenre());
        inlineKeyboardButton12.setText(COMEDY.getGenre());
        InlineKeyboardButton inlineKeyboardButton13 = new InlineKeyboardButton();
        inlineKeyboardButton13.setText(DRAMA.getGenre());
        inlineKeyboardButton13.setCallbackData("Сериал"+DRAMA.getGenre());
        InlineKeyboardButton inlineKeyboardButton14 = new InlineKeyboardButton();
        inlineKeyboardButton14.setText(THRILLER.getGenre());
        inlineKeyboardButton14.setCallbackData("Сериал"+THRILLER.getGenre());

        InlineKeyboardButton inlineKeyboardButton21 = new InlineKeyboardButton();
        inlineKeyboardButton21.setText(HISTORICAL.getGenre());
        inlineKeyboardButton21.setCallbackData("Сериал"+HISTORICAL.getGenre());
        InlineKeyboardButton inlineKeyboardButton22 = new InlineKeyboardButton();
        inlineKeyboardButton22.setText(ADVENTURE.getGenre());
        inlineKeyboardButton22.setCallbackData("Сериал"+ADVENTURE.getGenre());
        InlineKeyboardButton inlineKeyboardButton23 = new InlineKeyboardButton();
        inlineKeyboardButton23.setText(FANTASTIC.getGenre());
        inlineKeyboardButton23.setCallbackData("Сериал"+FANTASTIC.getGenre());
        InlineKeyboardButton inlineKeyboardButton24 = new InlineKeyboardButton();
        inlineKeyboardButton24.setText(FANTASY.getGenre());
        inlineKeyboardButton24.setCallbackData("Сериал"+FANTASY.getGenre());

        InlineKeyboardButton inlineKeyboardButton31 = new InlineKeyboardButton();
        inlineKeyboardButton31.setText(DETECTIVE.getGenre());
        inlineKeyboardButton31.setCallbackData("Сериал"+DETECTIVE.getGenre());
        InlineKeyboardButton inlineKeyboardButton32 = new InlineKeyboardButton();
        inlineKeyboardButton32.setText(HORROR.getGenre());
        inlineKeyboardButton32.setCallbackData("Сериал"+HORROR.getGenre());
        InlineKeyboardButton inlineKeyboardButton33 = new InlineKeyboardButton();
        inlineKeyboardButton33.setText(CARTOON.getGenre());
        inlineKeyboardButton33.setCallbackData("Сериал"+CARTOON.getGenre());
        InlineKeyboardButton inlineKeyboardButton34 = new InlineKeyboardButton();
        inlineKeyboardButton34.setText(MELODRAMA.getGenre());
        inlineKeyboardButton34.setCallbackData("Сериал"+MELODRAMA.getGenre());

        InlineKeyboardButton inlineKeyboardButton41 = new InlineKeyboardButton();
        inlineKeyboardButton41.setCallbackData("Сериал"+MILITARY.getGenre());
        inlineKeyboardButton41.setText(MILITARY.getGenre());
        InlineKeyboardButton inlineKeyboardButton42 = new InlineKeyboardButton();
        inlineKeyboardButton42.setCallbackData("Сериал" + FAMILY.getGenre());
        inlineKeyboardButton42.setText(FAMILY.getGenre());
        InlineKeyboardButton inlineKeyboardButton43 = new InlineKeyboardButton();
        inlineKeyboardButton43.setCallbackData("Сериал" + DOCUMENTARY.getGenre());
        inlineKeyboardButton43.setText(DOCUMENTARY.getGenre());
        InlineKeyboardButton inlineKeyboardButton44 = new InlineKeyboardButton();
        inlineKeyboardButton44.setCallbackData("Сериал" + CHILDREN.getGenre());
        inlineKeyboardButton44.setText(CHILDREN.getGenre());

        InlineKeyboardButton inlineKeyboardButton51 = new InlineKeyboardButton();
        inlineKeyboardButton51.setText(CRIME.getGenre());
        inlineKeyboardButton51.setCallbackData("Сериал" + CRIME.getGenre());
        InlineKeyboardButton inlineKeyboardButton52 = new InlineKeyboardButton();
        inlineKeyboardButton52.setCallbackData("Сериал" + WESTERN.getGenre());
        inlineKeyboardButton52.setText(WESTERN.getGenre());

        InlineKeyboardButton inlineKeyboardButton61 = new InlineKeyboardButton();
        inlineKeyboardButton61.setCallbackData("ПолучитьСериал");
        inlineKeyboardButton61.setText("Сгенерировать");

        InlineKeyboardButton inlineKeyboardButton71 = new InlineKeyboardButton();
        inlineKeyboardButton71.setCallbackData("Back");
        inlineKeyboardButton71.setText("Назад");

        rowInline1.add(inlineKeyboardButton11);
        rowInline1.add(inlineKeyboardButton12);
        rowInline1.add(inlineKeyboardButton13);
        rowInline1.add(inlineKeyboardButton14);

        rowInline2.add(inlineKeyboardButton21);
        rowInline2.add(inlineKeyboardButton22);
        rowInline2.add(inlineKeyboardButton23);
        rowInline2.add(inlineKeyboardButton24);

        rowInline3.add(inlineKeyboardButton31);
        rowInline3.add(inlineKeyboardButton32);
        rowInline3.add(inlineKeyboardButton33);
        rowInline3.add(inlineKeyboardButton34);

        rowInline4.add(inlineKeyboardButton41);
        rowInline4.add(inlineKeyboardButton42);
        rowInline4.add(inlineKeyboardButton43);
        rowInline4.add(inlineKeyboardButton44);

        rowInline5.add(inlineKeyboardButton51);
        rowInline5.add(inlineKeyboardButton52);

        rowInline6.add(inlineKeyboardButton61);

        rowInline7.add(inlineKeyboardButton71);

        rowsInline.add(rowInline1);
        rowsInline.add(rowInline2);
        rowsInline.add(rowInline3);
        rowsInline.add(rowInline4);
        rowsInline.add(rowInline5);
        rowsInline.add(rowInline6);
        rowsInline.add(rowInline7);


        markupInline.setKeyboard(rowsInline);
        message.setReplyMarkup(markupInline);

        return message;


    }
}
