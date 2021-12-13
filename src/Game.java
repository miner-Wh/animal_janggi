//�������� ���� ���۵��� �ϴ� Ŭ����
class GAME {
    static final int NOTHING = 0;
    static final int PLAYER1 = 1;
    static final int PLAYER2 = 2;

    static final int BOARD = 0;
    static final int HAVING = 1;

    static final int Wang = 0;//��
    static final int Sang = 1;//��
    static final int Jang = 2;//��
    static final int Ja = 3;//��
    static final int Hu = 4;//��
    static final int Mu = 5;//��(��ĭ)

    static final int SELECTED = 1;
    static final int MOVED = 2;

    static int[][][] MAL_DIR = {
            {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}},
            {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}},
            {{1, 0}, {-1, 0}, {0, 1}, {0, -1}},
            {{-1, 0}},
            {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {0, -1}, {1, 0}},
            {}
    };

    int turn;
    int state;
    MAL[] player1 = new MAL[6];
    MAL[] player2 = new MAL[6];
    MAL[][] board = new MAL[4][3];
    MAL selected;

    GAME() {
        init_game();
    }
    //���� ���� �������� �ʱ�ȭ
    void init_game() {
        this.turn = PLAYER1;
        this.state = 0;
        for(int i=0; i<6; i++) {
            player1[i] = null;
            player2[i] = null;
        }
        this.selected = null;

        this.board[0][0] = new MAL(PLAYER2, Jang, new POS(BOARD, 0, 0), false);
        this.board[0][1] = new MAL(PLAYER2, Wang, new POS(BOARD, 0, 1), false);
        this.board[0][2] = new MAL(PLAYER2, Sang, new POS(BOARD, 0, 2), false);
        this.board[1][0] = new MAL(NOTHING, Mu, new POS(BOARD, 1, 0), false);
        this.board[1][1] = new MAL(PLAYER2, Ja, new POS(BOARD, 1, 1), false);
        this.board[1][2] = new MAL(NOTHING, Mu, new POS(BOARD, 1, 2), false);
        this.board[2][0] = new MAL(NOTHING, Mu, new POS(BOARD, 2, 0), false);
        this.board[2][1] = new MAL(PLAYER1, Ja, new POS(BOARD, 2, 1), false);
        this.board[2][2] = new MAL(NOTHING, Mu, new POS(BOARD, 2, 2), false);
        this.board[3][0] = new MAL(PLAYER1, Sang, new POS(BOARD, 3, 0), false);
        this.board[3][1] = new MAL(PLAYER1, Wang, new POS(BOARD, 3, 1), false);
        this.board[3][2] = new MAL(PLAYER1, Jang, new POS(BOARD, 3, 2), false);
    }
    //���� �ű� ���ʸ� ����
    void set_turn(int player) {
        this.turn = player;
    }
    //return�� MAL[4][3] ���� ���������� ��ȯ�Ѵ� ���� ������ MAL��ü �迭�� ��ȯ��
    MAL[][] get_board() {
        return this.board;
    }
    //return�� array(MAL) player�� �� ���� ������ �迭�� ��ȯ
    MAL[] get_having(int player) {
        if (player == PLAYER1) return this.player1;
        else if (player == PLAYER2) return this.player2;
        return null;
    }
    //return ��ȿ�� �Է¿��� NOTHING(=0), ���� ���õǸ� SELECTED(=1), ���� �Ű����� MOVED(=2)��ȯ
    int button_click(int player, POS pos) {
        if (player != this.turn) return 0;
        if (pos.from == HAVING) {
            if (player == PLAYER1) {
                this.selected = this.player1[pos.y];
                clear_highlighted(this.board);
                for (int i = 1; i < 4; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (this.board[i][j].type == Mu) {
                            this.board[i][j].highlighted = true;
                        }
                    }
                }
            }
            else if (player == PLAYER2) {
                this.selected = this.player2[pos.y];
                clear_highlighted(this.board);
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (this.board[i][j].type == Mu) {
                            this.board[i][j].highlighted = true;
                        }
                    }
                }
            }
            return SELECTED;
        }
        else if (pos.from == BOARD) {
            if (this.board[pos.y][pos.x].highlighted) {
                if (this.board[pos.y][pos.x].type == Wang) {
                    this.state = player;
                }
                else if (this.board[pos.y][pos.x].type != Mu) {
                    MAL[] this_player = (player == PLAYER1 ? this.player1 : this.player2);
                    for (int i = 0; i < 6; i++) {
                        if (this_player[i] == null) {
                            this_player[i] = new MAL(player, this.board[pos.y][pos.x].type, new POS(HAVING, i, 0), false);
                            //Hu -> Ja
                            if(this_player[i].type == Hu) {
                                this_player[i].type = Ja;
                            }
                            break;
                        }
                    }
                }

                if (this.selected.pos.from == BOARD) this.board[this.selected.pos.y][this.selected.pos.x] = new MAL(NOTHING, Mu, new POS(BOARD, this.selected.pos.y, this.selected.pos.x), false);
                else if (this.selected.pos.from == HAVING) {
                    MAL[] this_player = (player == PLAYER1 ? this.player1 : this.player2);
                    for (int i = this.selected.pos.y; i < 5; i++) {
                        if(this_player[i + 1] != null) {
                            this_player[i] = new MAL(player, this_player[i+1].type, new POS(HAVING, i, 0), false);
                            //Hu -> Ja
                            if(this_player[i].type == Hu) {
                                this_player[i].type = Ja;
                            }
                        }
                        else this_player[i] = null;
                    }
                    this_player[5] = null;
                }
                this.board[pos.y][pos.x] = new MAL(player, this.selected.type, new POS(BOARD, pos.y, pos.x), false);
                if (this.board[pos.y][pos.x].type == Ja && (player == PLAYER1 && pos.y == 0 || player == PLAYER2 && pos.y == 3)) {
                    this.board[pos.y][pos.x].type = Hu;
                }
                clear_highlighted(this.board);

                if (player == PLAYER1) {
                    for (int i = 0; i < 3; i++) {
                        if (this.board[3][i].type == Wang && this.board[3][i].player == PLAYER2) {
                            this.state = PLAYER2;
                        }
                    }
                }
                else if (player == PLAYER2) {
                    for (int i = 0; i < 3; i++) {
                        if (this.board[0][i].type == Wang && this.board[0][i].player == PLAYER1) {
                            this.state = PLAYER1;
                        }
                    }
                }
                return MOVED;
            }
            else if (this.board[pos.y][pos.x].player == player) {
                this.selected = this.board[pos.y][pos.x];
                clear_highlighted(this.board);
                for (int i = 0; i < MAL_DIR[this.selected.type].length; i++) {
                    int y = pos.y + (player == PLAYER1 ? 1 : -1) * MAL_DIR[this.selected.type][i][0];
                    int x = pos.x + MAL_DIR[this.selected.type][i][1];
                    if (0 <= x && x < 3 && 0 <= y && y < 4 && this.board[y][x].player != player) {
                        this.board[y][x].highlighted = true;
                    }
                }
                return SELECTED;
            }
        }
        return NOTHING;
    }

    private void clear_highlighted(MAL[][] board) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j].highlighted = false;
            }
        }
    }
}