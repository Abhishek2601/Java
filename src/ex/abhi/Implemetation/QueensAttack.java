package ex.abhi.Implemetation;

import java.util.HashMap;
import java.util.Map;

public class QueensAttack {
    public static class Cordinate{
        int x;
        private int y;
        public Cordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object anotherObject){
            if(anotherObject instanceof  Cordinate ){
                Cordinate anotherCordinate = (Cordinate) anotherObject;
                if(anotherCordinate.x == this.x && anotherCordinate.y == this.y){
                    return true;
                }
            }
            return false;
        }

        @Override
        public int hashCode(){
            return this.x + 31 * this.y;
        }
    }

    public int attackPositions(int chessSquareSize, Cordinate queenPos,
                               Map<Cordinate, Boolean> obstacls){
        int totalSqares = 0;
        int i =0;
        boolean right = true, left = true, up = true, down = true, upR =
                true, upL = true, dR= true, dL = true;
        while (right || left || up || down || upR || upL || dR || dL){
            i = i+1;
            //right
            if(queenPos.x + i <= chessSquareSize && right)
            {
                right = obstacls.getOrDefault(new Cordinate(queenPos.x+i,
                        queenPos.y), true);
                if(right) {totalSqares++;}
            }else{
                right = false;
            }
            //left
            if(queenPos.x - i > 0 && left){
                left = obstacls.getOrDefault(new Cordinate(queenPos.x-i,
                        queenPos.y), true);
                if(left) {totalSqares++;}
            }else{
                left = false;
            }
            //up
            if(queenPos.y + i <= chessSquareSize && up){
                up = obstacls.getOrDefault(new Cordinate(queenPos.x,
                        queenPos.y+i), true);
                if(up) {totalSqares++;}
            }else{
                up = false;
            }
            //down
            if(queenPos.y - i > 0 && down){
                down = obstacls.getOrDefault(new Cordinate(queenPos.x,
                        queenPos.y-i), true);
                if(down) {totalSqares++;}
            }else{
                down = false;
            }

            //upR
            if(queenPos.y + i <= chessSquareSize && queenPos.x + i <=
                    chessSquareSize && upR){
                upR = obstacls.getOrDefault(new Cordinate(queenPos.x+i,
                        queenPos.y+i), true);
                if(upR) {totalSqares++;}
            }else{
                upR = false;
            }

            //upL
            if(queenPos.y + i <= chessSquareSize && queenPos.x - i >0 && upL){
                upL = obstacls.getOrDefault(new Cordinate(queenPos.x-i,
                        queenPos.y+i), true);
                if(upL) {totalSqares++;}
            }else{
                upL = false;
            }

            //dR
            if(queenPos.y - i > 0 && queenPos.x + i <= chessSquareSize && dR){
                dR = obstacls.getOrDefault(new Cordinate(queenPos.x+i,
                        queenPos.y-i), true);
                if(dR) {totalSqares++;}
            }else{
                dR = false;
            }
            //dL
            if(queenPos.y - i > 0 && queenPos.x - i >0 && dL){
                dL = obstacls.getOrDefault(new Cordinate(queenPos.x-i,
                        queenPos.y-i), true);

                if(dL) {totalSqares++;}
            }else{
                dL = false;
            }

        }
        return totalSqares;
    }

    public static void main(String [] args){
        Cordinate cordinate = new Cordinate(4,4);

        QueensAttack queenAttack = new QueensAttack();
        Cordinate ob = new Cordinate(3,5);
        Map<Cordinate, Boolean>obs = new HashMap<Cordinate, Boolean>();
        obs.put(ob,false);
        System.out.println(queenAttack.attackPositions(8,cordinate,obs));

    }
}
