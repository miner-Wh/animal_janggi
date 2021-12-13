class MAL {
    int player;
    int type;
    POS pos;
    boolean highlighted; //플레이어가 말을 선택하면 이동 가능한 칸이 하이라이트 되는데 이 여부를 반환

    MAL(int player, int type, POS pos, boolean highlighted) {
        this.player = player;
        this.type = type;
        this.pos = pos;
        this.highlighted = highlighted;
    }
}