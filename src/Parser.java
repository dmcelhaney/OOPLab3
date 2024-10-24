import java.text.SimpleDateFormat;
import java.util.Date;

public class Parser {
    public static Date parseDate(String text) {
        Date date = null;
        SimpleDateFormat formatter = new SimpleDateFormat("d-MMMM-yy");

        try {
            char thirdToLastCharacter = text.charAt(text.length() - 3);
            String last2Characters = text.substring(text.length() - 2, text.length());

            if (thirdToLastCharacter == '-') {
                text = text.substring(0, text.length() - 2) + "19" + last2Characters;
            }

            date = formatter.parse(text);
        } catch (java.text.ParseException e) {
            //e.printStackTrace();
        }

        return date;
    }
}
