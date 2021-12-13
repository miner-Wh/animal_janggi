//말의 위치를 나타내기위한 클래스입니다
class POS {
    int from;//0 == 보드에 있음, 1 == 플레이어가 잡은 말
    int x;//보드에서 x좌표를 나타냄 플레이어가 잡은 말일 경우 0임
    int y; // 보드에서의 y좌표를 나타냄 플레이어가 잡은 말일경우 0~5까지의 좌표를 나타냄

    POS(int from, int y, int x) {
        this.from = from;
        this.y = y;
        this.x = x;
    }
}