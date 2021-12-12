# twelveJanggi-API (십이장기 API)


##### 십이장기 게임을 쉽게 관리 할 수 있는 api


# Game class
전반적인 게임 조작들을 하는 클래스

## Game.init_game()
게임 내부 설정들을 초기화

## Game.set_turn(player)
말을 옮길 차례를 설정

~~~javascript
//player는 PLAYER1 (=1)과 PLAYER2 (=2)만 가능
Game.set_first(PLAYER1);
Game.set_fisrt(PLAYER2);
~~~

## Game.get_board
* returns MAL[4][3]
현재 보드 정보를 반환한다
보드 정보는 MAL 객체 배열로 반환된다

~~~javascript
board = Game.getBoard();
console.log(board[1][1].type);
~~~

## Game.get_having(player)
* returns array(MAL)
player가 딴 말을 저장한 배열을 반환

~~~javascript
p1_having = Game.get_having(PLAYER1);
p2_having = Game.get_having(PLAYER2);
~~~


## Game.button_click(player, pos)
* returns {success} 무효한 입력에는 NOTHING (=0), 말이 선택되면 SELECTED (=1), 말이 옮겨지면 MOVED (=2)
)  
~~~javascript
// 플레이어 1이 2, 2 버튼을 눌렸을 때 
if(Game.button_click(PLAYER1, new POS(BOARD, 2, 2)) == MOVED) {
    Game.set_turn(PLAYER2);
}
~~~

## Game.state
* returns {state} 플레이어 1이 승리시 PLAYER1 (=1), 플레이어 2가 승리시 PLAYER2 (=2), 나머지 NOTHING (=0)
  
  ~~~javascript
  winner = Game.state;
  if(winner != NOTHING) {
      console.log(i + " is Win");
  }
  ~~~
  
# MAL class
게임 말의 종류, 진행 가능 방향, 상태를 정의

## MAL.type
* type : {Number}
  + Wang 왕(王)   (=0)
  + Sang 상(相)   (=1)
  + Jang 장(將)   (=2)
  + Ja   자(子)   (=3)
  + Hu   후(侯)   (=4)
  + Mu   무(빈칸) (=5)
  
## MAL.player
* type : {Number}
  + 1   플레이어 1
  + 2   플레이어 2
  
## MAL.highlighted
* type : {boolean}
플레이어가 말을 선택하면 이동 가능한 칸이 하이라이트 되는데 이 여부를 반환

## MAL.pos
* type : {POS}
말의 위치를 나타냄

# POS Class
위치를 표현함

## POS.from
* type {string}
  + BOARD  (=0) 보드에 있음
  + HAVING (=1) 플레이어가 잡은 말
  
## POS.y
* type {Number}
보드에서 y좌표를 나타냄
플레이어가 잡은 말일경우 0~5까지의 좌표를 나타냄

## POS.x
* type {Number}
보드에서 x좌표를 나타냄
플레이어가 잡은 말일 경우 0임
