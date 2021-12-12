import java.io.Serializable;

public class user_info implements Serializable {
    String        ID;
    String        PW;
    String        name;
    String        nick;
    String        email;
    String        sns;
    String        game_record;
    access_record my_access;

    user_info(String ID,String PW,String name, String nick, String email){
        this.ID = ID;
        this.PW = PW;
        this.name = name;
        this.nick = nick;
        this.email = email;
        this.sns = "";
        String game_recore;
        my_access = new access_record();
    }
    user_info(String ID,String PW,String name, String nick, String email,String sns){
        this.ID = ID;
        this.PW = PW;
        this.name = name;
        this.nick = nick;
        this.email = email;
        this.sns = sns;
        my_access = new access_record();

    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setPW(String PW) {
        this.PW = PW;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSns(String sns) {
        this.sns = sns;
    }

    public void setGame_record(String game_record) {
        this.game_record = game_record;
    }
}
