import java.io.Serializable;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class access_record implements Serializable {
    List<String> record;
    //접속 기록을 리스트 어레이 형식으로 저장

    access_record() {
        record = new ArrayList<String>();
        LocalDate now = LocalDate.now();
        LocalTime nowt = LocalTime.now();

        record.add(now.toString() + "  " + nowt.toString() + " created");
        //생성 될때의 기록

    }

    //login 인지 아닌지 받아서 기록
    public void addRecord(boolean is_login) {
        LocalDate now = LocalDate.now();
        LocalTime nowt = LocalTime.now();
        if(is_login){
            record.add(now.toString() + "  " + nowt.toString() + " login");
        }
        else{
            record.add(now.toString() + "  " + nowt.toString() + " logout");
        }

    }

    public List<String> getRecord() {
        return record;
        //기록의 어레이 리스트
    }
}
