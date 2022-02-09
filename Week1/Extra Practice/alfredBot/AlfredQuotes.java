import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        return "Hello, lovely to see you. How are you?";
    }
    public String guestGreeting(String name) {
        String greeting = String.format("Oh hello %s. Lovely to see you.", name);
        return greeting;
    }
    public String guestGreeting(String time, String name){
        String greeting = String.format("Good %s %s, lovely to see you.", time, name);
        return greeting;
    }
    public String dateAnnouncement() {
        Date date = new Date();
        return "it is currently "+date;
    }
    public String respondBeforeAlexis(String conversation) {
        if (conversation.indexOf("Alfred") >-1){
            return "At your service. As you wish. Naturally.";
        }
        else if (conversation.indexOf("Alexis") > -1){
            return "Right away, sir. She certainly isn't sophisticated enough for that.";
        }
        else{
            return "Right. And with that I shall retire.";
        }
    }
    public String UpperAlfred (String Text){
        return Text.toUpperCase();
    }
}

