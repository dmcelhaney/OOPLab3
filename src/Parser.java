import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Parser {
    public static Date parseDate(String text) {
        Date date = null;
        SimpleDateFormat formatter = new SimpleDateFormat("d-MMM-yy");
        SimpleDateFormat formatter2 = new SimpleDateFormat("d/M/yy");
        SimpleDateFormat formatter3 = new SimpleDateFormat("dd MMMM yyyy", new Locale("nl", "NL")); //Handling the word "augustus"
        char thirdToLastCharacter = text.charAt(text.length() - 3);
        String last2Characters = text.substring(text.length() - 2, text.length());

        if(thirdToLastCharacter == '-') {
            text = text.substring(0, text.length() - 2) + "19" + last2Characters;
        }

        try {
            date = formatter.parse(text);
        }catch (java.text.ParseException e) {
            try {
                date = formatter2.parse(text);
            }catch(java.text.ParseException i){
                try{
                    date = formatter3.parse(text);
                }catch(ParseException j){
                    e.printStackTrace();
                }
            }
        }
        return date;
    }
}
