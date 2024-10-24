import java.util.Date;

public class WCPlayerObject {
    private String playerName;
    private String team;
    private String birthCountry;
    private int yearPlayed;
    private Date dob;

    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getTeam() {
        return team;
    }
    public void setTeam(String team) {
        this.team = team;
    }

    public String getBirthCountry() {
        return birthCountry;
    }
    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    public int getYearPlayed() {
        return yearPlayed;
    }
    public void setYearPlayed(int yearPlayed) {
        this.yearPlayed = yearPlayed;
    }

    public Date getDOB() {
        return dob;
    }
    public void setDOB(Date dob) {
        this.dob = dob;
    }

    public WCPlayerObject() {
        playerName = "";
        team = "";
        birthCountry = "";
        yearPlayed = 0;
        dob = null;
    }

    public WCPlayerObject(String playerName, String team, String birthCountry, int yearPlayed, Date dob) {
        this.playerName = playerName;
        this.yearPlayed = yearPlayed;
        this.birthCountry = birthCountry;
        this.dob = dob;
        this.team = team;
    }
}
