import java.util.Date;

public record WCPlayer (String playerName, String team, Date dob, String birthPlace, String birthCountry, String currentCountry
                      , String nationalityFather, String nationalityMother, String nationalityGrandfather, String nationalityGrandmother
                      , int foreignBorn, int yearPlayed) {}
