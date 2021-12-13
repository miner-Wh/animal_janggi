import java.io.Serializable;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class access_record implements Serializable {
    List<String> record;
    //���� ����� ����Ʈ ��� �������� ����

    access_record() {
        record = new ArrayList<String>();
        LocalDate now = LocalDate.now();
        LocalTime nowt = LocalTime.now();

        record.add(now.toString() + "  " + nowt.toString() + " created");
        //���� �ɶ��� ���

    }

    //login ���� �ƴ��� �޾Ƽ� ���
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
        //����� ��� ����Ʈ
    }
}
