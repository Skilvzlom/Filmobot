package bot.animeHandler.inlineKeyboard;

import DB.DBGetters;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import settings.EmojiConst;

import java.util.ArrayList;
import java.util.List;

import static settings.enums.Genres.*;

public class AnimeInlineKeyboard {
    public static EditMessageReplyMarkup animeInlineKeyboard(long chatId, int messageId, long userId){
        EditMessageReplyMarkup message = new EditMessageReplyMarkup();
        message.setChatId(String.valueOf(chatId));
        message.setMessageId(messageId);
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();

        Boolean[] flags = DBGetters.getAnimeFlags(userId);

        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
        List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline2 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline3 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline4 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline5 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline6 = new ArrayList<>();
        List<InlineKeyboardButton> rowInline7 = new ArrayList<>();

        InlineKeyboardButton inlineKeyboardButton11 = new InlineKeyboardButton();
        assert flags != null;
        inlineKeyboardButton11.setText(flags[0]? ACTION.getGenre() + EmojiConst.OK :ACTION.getGenre());
        inlineKeyboardButton11.setCallbackData("Аниме"+ACTION.getGenre());
        InlineKeyboardButton inlineKeyboardButton12 = new InlineKeyboardButton();
        inlineKeyboardButton12.setCallbackData("Аниме"+COMEDY.getGenre());
        inlineKeyboardButton12.setText(flags[2]?COMEDY.getGenre()+EmojiConst.OK:COMEDY.getGenre());
        InlineKeyboardButton inlineKeyboardButton13 = new InlineKeyboardButton();
        inlineKeyboardButton13.setText(flags[1]?DRAMA.getGenre()+EmojiConst.OK: DRAMA.getGenre());
        inlineKeyboardButton13.setCallbackData("Аниме"+DRAMA.getGenre());
        InlineKeyboardButton inlineKeyboardButton14 = new InlineKeyboardButton();
        inlineKeyboardButton14.setText(flags[3]? THRILLER.getGenre() + EmojiConst.OK : THRILLER.getGenre());
        inlineKeyboardButton14.setCallbackData("Аниме"+THRILLER.getGenre());

        InlineKeyboardButton inlineKeyboardButton21 = new InlineKeyboardButton();
        inlineKeyboardButton21.setText(flags[16]?CRIME.getGenre()+EmojiConst.OK: CRIME.getGenre());
        inlineKeyboardButton21.setCallbackData("Аниме" + CRIME.getGenre());
        InlineKeyboardButton inlineKeyboardButton23 = new InlineKeyboardButton();
        inlineKeyboardButton23.setText(flags[4]?FANTASTIC.getGenre()+EmojiConst.OK: FANTASTIC.getGenre());
        inlineKeyboardButton23.setCallbackData("Аниме"+FANTASTIC.getGenre());
        InlineKeyboardButton inlineKeyboardButton24 = new InlineKeyboardButton();
        inlineKeyboardButton24.setText(flags[5]?FANTASY.getGenre()+EmojiConst.OK: FANTASY.getGenre());
        inlineKeyboardButton24.setCallbackData("Аниме"+FANTASY.getGenre());

        InlineKeyboardButton inlineKeyboardButton31 = new InlineKeyboardButton();
        inlineKeyboardButton31.setText(flags[6]?DETECTIVE.getGenre()+EmojiConst.OK: DETECTIVE.getGenre());
        inlineKeyboardButton31.setCallbackData("Аниме"+DETECTIVE.getGenre());
        InlineKeyboardButton inlineKeyboardButton32 = new InlineKeyboardButton();
        inlineKeyboardButton32.setText(flags[7]?HORROR.getGenre()+EmojiConst.OK: HORROR.getGenre());
        inlineKeyboardButton32.setCallbackData("Аниме"+HORROR.getGenre());
        InlineKeyboardButton inlineKeyboardButton33 = new InlineKeyboardButton();
        inlineKeyboardButton33.setText(flags[9]?MELODRAMA.getGenre()+EmojiConst.OK: MELODRAMA.getGenre());
        inlineKeyboardButton33.setCallbackData("Аниме"+MELODRAMA.getGenre());

        InlineKeyboardButton inlineKeyboardButton41 = new InlineKeyboardButton();
        inlineKeyboardButton41.setCallbackData("Аниме"+MILITARY.getGenre());
        inlineKeyboardButton41.setText(flags[11]?MILITARY.getGenre()+EmojiConst.OK: MILITARY.getGenre());
        InlineKeyboardButton inlineKeyboardButton42 = new InlineKeyboardButton();
        inlineKeyboardButton42.setCallbackData("Аниме" + DOCUMENTARY.getGenre());
        inlineKeyboardButton42.setText(flags[14]?DOCUMENTARY.getGenre()+EmojiConst.OK: DOCUMENTARY.getGenre());

        InlineKeyboardButton inlineKeyboardButton51 = new InlineKeyboardButton();
        inlineKeyboardButton51.setText(flags[13]?HISTORICAL.getGenre()+EmojiConst.OK: HISTORICAL.getGenre());
        inlineKeyboardButton51.setCallbackData("Аниме"+HISTORICAL.getGenre());
        InlineKeyboardButton inlineKeyboardButton52 = new InlineKeyboardButton();
        inlineKeyboardButton52.setCallbackData("Аниме" +ADVENTURE.getGenre());
        inlineKeyboardButton52.setText(flags[10]?ADVENTURE.getGenre()+EmojiConst.OK: ADVENTURE.getGenre());

        InlineKeyboardButton inlineKeyboardButton61 = new InlineKeyboardButton();
        inlineKeyboardButton61.setCallbackData("ПолучитьАниме");
        inlineKeyboardButton61.setText("Сгенерировать");

        InlineKeyboardButton inlineKeyboardButton71 = new InlineKeyboardButton();
        inlineKeyboardButton71.setCallbackData("Back");
        inlineKeyboardButton71.setText("Назад");

        rowInline1.add(inlineKeyboardButton11);
        rowInline1.add(inlineKeyboardButton12);
        rowInline1.add(inlineKeyboardButton13);
        rowInline1.add(inlineKeyboardButton14);

        rowInline2.add(inlineKeyboardButton21);
        rowInline2.add(inlineKeyboardButton23);
        rowInline2.add(inlineKeyboardButton24);

        rowInline3.add(inlineKeyboardButton31);
        rowInline3.add(inlineKeyboardButton32);
        rowInline3.add(inlineKeyboardButton33);

        rowInline4.add(inlineKeyboardButton41);
        rowInline4.add(inlineKeyboardButton42);

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
