/**
 * Created by travisclement on 9/8/15.
 */
public class Player {

    private String playerName;

    private String playerRace;

    private String playerColor;


    public Player(String aplayerName,
                  String aplayerRace, String aplayerColor) {

        playerName = aplayerName;
        playerRace = aplayerRace;
        playerColor = aplayerColor;

    }




    // Getters and setters
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerRace() {
        return playerRace;
    }

    public void setPlayerRace(String playerRace) {
        this.playerRace = playerRace;
    }

    public String getPlayerColor() {
        return playerColor;
    }

    public void setPlayerColor(String playerColor) {
        this.playerColor = playerColor;
    }
}