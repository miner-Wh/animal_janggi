class MAL {
    int player;
    int type;
    POS pos;
    boolean highlighted; //�÷��̾ ���� �����ϸ� �̵� ������ ĭ�� ���̶���Ʈ �Ǵµ� �� ���θ� ��ȯ

    MAL(int player, int type, POS pos, boolean highlighted) {
        this.player = player;
        this.type = type;
        this.pos = pos;
        this.highlighted = highlighted;
    }
}