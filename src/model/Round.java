
/**
 * Created by ryyanj on 9/20/15.
 */

import java.lang.reflect.Array;
import java.util.ArrayList;;

public class Round {

    public ArrayList<Turn> roundTurns;
    public static int numPasses;
    public Round() {
        numPasses = 0;
    }
    public static int getNumPasses() {
        return numPasses;
    }

    public void createTurns() {

    }
    //public roundTurns;

    public boolean isRoundOver() {
        //round is over if all turns are done
        Turn lastTurn = roundTurns.get(roundTurns.size()-1);
        if( lastTurn.isTurnOver() ) {
            return true;
        }
        return false;
    }



}


