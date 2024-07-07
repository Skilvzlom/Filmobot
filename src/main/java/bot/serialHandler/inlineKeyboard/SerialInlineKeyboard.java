package bot.serialHandler.inlineKeyboard;

import DB.DBGetters;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import settings.EmojiConst;

import java.util.ArrayList;
import java.util.List;

import static settings.enums.Genres.*;

public class SerialInlineKeyboard {
    public static EditMessageReplyMarkup serialInlineKeyboard(long chatId, int messageId, long userId){
        EditMessageReplyMarkup message = new EditMessageReplyMarkup();
        message.setChatId(String.valueOf(chatId));
        message.setMessageId(messageId);
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

        Boolean[] flags = DBGetters.getSerialFlags(userId);

        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline2 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline4 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline5 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline6 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline7 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline8 = new ArrayList<>();

        InlineKeyboardButton inlineKeyboardButton11 = new InlineKeyboardButton();
        assert flags != null;
        inlineKeyboardButton11.setText(flags[0]? ACTION.getGenre() + EmojiConst.OK :ACTION.getGenre());
        inlineKeyboardButton11.setCallbackData("Сериал"+ACTION.getGenre());
        InlineKeyboardButton inlineKeyboardButton12 = new InlineKeyboardButton();
        inlineKeyboardButton12.setCallbackData("Сериал"+COMEDY.getGenre());
        inlineKeyboardButton12.setText(flags[2]?COMEDY.getGenre()+EmojiConst.OK:COMEDY.getGenre());
        InlineKeyboardButton inlineKeyboardButton13 = new InlineKeyboardButton();
        inlineKeyboardButton13.setText(flags[1]?DRAMA.getGenre()+EmojiConst.OK: DRAMA.getGenre());
        inlineKeyboardButton13.setCallbackData("Сериал"+DRAMA.getGenre());
        InlineKeyboardButton inlineKeyboardButton14 = new InlineKeyboardButton();
        inlineKeyboardButton14.setText(flags[3]? THRILLER.getGenre() + EmojiConst.OK : THRILLER.getGenre());
        inlineKeyboardButton14.setCallbackData("Сериал"+THRILLER.getGenre());

        InlineKeyboardButton inlineKeyboardButton21 = new InlineKeyboardButton();
        inlineKeyboardButton21.setText(flags[15]?CHILDREN.getGenre()+EmojiConst.OK: CHILDREN.getGenre());
        inlineKeyboardButton21.setCallbackData("Сериал" + CHILDREN.getGenre());
        InlineKeyboardButton inlineKeyboardButton22 = new InlineKeyboardButton();
        inlineKeyboardButton22.setText(flags[17]?WESTERN.getGenre()+EmojiConst.OK: WESTERN.getGenre());
        inlineKeyboardButton22.setCallbackData("Сериал"+WESTERN.getGenre());
        InlineKeyboardButton inlineKeyboardButton23 = new InlineKeyboardButton();
        inlineKeyboardButton23.setText(flags[7]?HORROR.getGenre()+EmojiConst.OK: HORROR.getGenre());
        inlineKeyboardButton23.setCallbackData("Сериал"+HORROR.getGenre());
        InlineKeyboardButton inlineKeyboardButton24 = new InlineKeyboardButton();
        inlineKeyboardButton24.setText(flags[5]?FANTASY.getGenre()+EmojiConst.OK: FANTASY.getGenre());
        inlineKeyboardButton24.setCallbackData("Сериал"+FANTASY.getGenre());

        InlineKeyboardButton inlineKeyboardButton31 = new InlineKeyboardButton();
        inlineKeyboardButton31.setText(flags[6]?DETECTIVE.getGenre()+EmojiConst.OK: DETECTIVE.getGenre());
        inlineKeyboardButton31.setCallbackData("Сериал"+DETECTIVE.getGenre());
        InlineKeyboardButton inlineKeyboardButton32 = new InlineKeyboardButton();
        inlineKeyboardButton32.setText(flags[4]?FANTASTIC.getGenre()+EmojiConst.OK: FANTASTIC.getGenre());
        inlineKeyboardButton32.setCallbackData("Сериал"+FANTASTIC.getGenre());
        InlineKeyboardButton inlineKeyboardButton33 = new InlineKeyboardButton();
        inlineKeyboardButton33.setText(flags[9]?MELODRAMA.getGenre()+EmojiConst.OK: MELODRAMA.getGenre());
        inlineKeyboardButton33.setCallbackData("Сериал"+MELODRAMA.getGenre());

        InlineKeyboardButton inlineKeyboardButton41 = new InlineKeyboardButton();
        inlineKeyboardButton41.setCallbackData("Сериал"+MILITARY.getGenre());
        inlineKeyboardButton41.setText(flags[11]?MILITARY.getGenre()+EmojiConst.OK: MILITARY.getGenre());
        InlineKeyboardButton inlineKeyboardButton42 = new InlineKeyboardButton();
        inlineKeyboardButton42.setCallbackData("Сериал" + FAMILY.getGenre());
        inlineKeyboardButton42.setText(flags[12]?FAMILY.getGenre()+EmojiConst.OK: FAMILY.getGenre());
        InlineKeyboardButton inlineKeyboardButton43 = new InlineKeyboardButton();
        inlineKeyboardButton43.setCallbackData("Сериал" + CRIME.getGenre());
        inlineKeyboardButton43.setText(flags[16]?CRIME.getGenre()+EmojiConst.OK: CRIME.getGenre());

        InlineKeyboardButton inlineKeyboardButton51 = new InlineKeyboardButton();
        inlineKeyboardButton51.setCallbackData("Сериал" + DOCUMENTARY.getGenre());
        inlineKeyboardButton51.setText(flags[14]?DOCUMENTARY.getGenre()+EmojiConst.OK: DOCUMENTARY.getGenre());
        InlineKeyboardButton inlineKeyboardButton52 = new InlineKeyboardButton();
        inlineKeyboardButton52.setText(flags[8]?CARTOON.getGenre()+EmojiConst.OK: CARTOON.getGenre());
        inlineKeyboardButton52.setCallbackData("Сериал"+CARTOON.getGenre());

        InlineKeyboardButton inlineKeyboardButton61 = new InlineKeyboardButton();
        inlineKeyboardButton61.setText(flags[13]?HISTORICAL.getGenre()+EmojiConst.OK: HISTORICAL.getGenre());
        inlineKeyboardButton61.setCallbackData("Сериал"+HISTORICAL.getGenre());
        InlineKeyboardButton inlineKeyboardButton62 = new InlineKeyboardButton();
        inlineKeyboardButton62.setCallbackData("Сериал" +ADVENTURE.getGenre());
        inlineKeyboardButton62.setText(flags[10]?ADVENTURE.getGenre()+EmojiConst.OK: ADVENTURE.getGenre());

        InlineKeyboardButton inlineKeyboardButton71 = new InlineKeyboardButton();
        inlineKeyboardButton71.setCallbackData("ПолучитьСериал");
        inlineKeyboardButton71.setText("Сгенерировать");

        InlineKeyboardButton inlineKeyboardButton81 = new InlineKeyboardButton();
        inlineKeyboardButton81.setCallbackData("Back");
        inlineKeyboardButton81.setText("Назад");

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

        rowInline4.add(inlineKeyboardButton41);
        rowInline4.add(inlineKeyboardButton42);
        rowInline4.add(inlineKeyboardButton43);

        rowInline5.add(inlineKeyboardButton51);
        rowInline5.add(inlineKeyboardButton52);

        rowInline6.add(inlineKeyboardButton61);

        rowInline7.add(inlineKeyboardButton71);

        rowInline8.add(inlineKeyboardButton81);

        rowsInline.add(rowInline1);
        rowsInline.add(rowInline2);
        rowsInline.add(rowInline3);
        rowsInline.add(rowInline4);
        rowsInline.add(rowInline5);
        rowsInline.add(rowInline6);
        rowsInline.add(rowInline7);
        rowsInline.add(rowInline8);


        markupInline.setKeyboard(rowsInline);
        message.setReplyMarkup(markupInline);

        return message;


    }
}
