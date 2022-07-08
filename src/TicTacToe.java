

public class TicTacToe {
    int scoreP1,scoreP2;
    char[] gameNet = new char[9];
    private String move;
    int movesCount;
    private char XO;

    public String getMove(){
        return move;
    }

    public char getXO(){
        return XO;
    }

    public void newGame(String whoStarts){
        for(int i=0;i<9;i++)
            gameNet[i]=(char)(i+65);
        move = whoStarts;
        XO = 'X';
        movesCount=0;
    }

    String makeMove(int index){
        if(gameNet[index]>='A' && gameNet[index]<='I') {
            gameNet[index] = XO;
            movesCount++;
            if (isThereAWinner(gameNet)!=null) {
                if (move == "P1")
                    scoreP1++;
                else
                    scoreP2++;
                if (move == "P1") {
                    newGame("P2");
                    return "P1 WINS";
                }
                else{
                    newGame("P1");
                    return "P2 WINS";
                }
            }

            if (move == "P1")
                move = "P2";
            else
                move = "P1";

            if (XO == 'X')
                XO = 'O';
            else
                XO = 'X';
        }

        if (movesCount == 9) {
            newGame(move);
            return "DRAW";
        }

        return null;
    }

    public String isThereAWinner(char[] gameNet){
        if((gameNet[0] == gameNet[4] && gameNet[0]== gameNet[8]) || (gameNet[2] == gameNet[4] && gameNet[2]== gameNet[6]) ||
                (gameNet[0] == gameNet[1] && gameNet[0]== gameNet[2]) || (gameNet[3] == gameNet[4] && gameNet[3]== gameNet[5]) ||
                (gameNet[6] == gameNet[7] && gameNet[6]== gameNet[8]) || (gameNet[0] == gameNet[3] && gameNet[0]== gameNet[6]) ||
                (gameNet[1] == gameNet[4] && gameNet[1]== gameNet[7]) || (gameNet[2] == gameNet[5] && gameNet[2]== gameNet[8]))
            if(move=="P1")
                return "P2";
            else
                return "P1";
        else
            return null;
    }
}

