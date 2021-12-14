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
    int w=0;
    int l=0;

    user_info(String ID,String PW,String name, String nick, String email){
        this.ID = ID;
        this.PW = PW;
        this.name = name;
        this.nick = nick;
        this.email = email;
        this.w =0;
        this.l =0;
        this.sns = "";
        this.game_record ="0승 0패";
        my_access = new access_record();
    }
    user_info(String ID,String PW,String name, String nick, String email,String sns){
        this.ID = ID;
        this.PW = PW;
        this.name = name;
        this.nick = nick;
        this.email = email;
        this.w =0;
        this.l =0;
        this.sns = sns;
        this.game_record ="0승 0패";
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
    public void gameResult(boolean is_win) {
        if(is_win){
            this.w++;
        }
        else{
            this.l++;
        }
        this.game_record = w+"승 "+l+"패";
    }
}
