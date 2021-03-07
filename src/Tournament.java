import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Tournament {
    public static void main(String[] args) {
        System.out.println("test");
        String[][] competitons = {
                {"puma", "cheetah"},
                {"cheetah", "lion"},
                {"lion", "puma"}
        };

        int[] results = {
                1, 0, 0
        };
        System.out.println("Winner: "+getTournamentWinner(competitons, results));
    }

    public static String getTournamentWinner(String[][] competitions, int[] results) {
//        ArrayList<String>teams=new ArrayList<String>();
        Map<String, Integer> teams = new HashMap<String, Integer>();
        for (int i = 0; i < competitions.length; ++i) {
            teams.put(competitions[i][0], 0);
            teams.put(competitions[i][1], 0);
        }
        for (int i = 0; i < competitions.length; ++i) {
            if (results[i] == 1) {
                int current_score = teams.get(competitions[i][0]);
                teams.put(competitions[i][0], current_score + 3);
            } else {
                int current_score = teams.get(competitions[i][1]);
                teams.put(competitions[i][1], current_score + 3);
            }
        }
        Set<Map.Entry<String, Integer>> sorted = teams.entrySet().stream().sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue())).collect(Collectors.toSet());
      return sorted.iterator().next().getKey();
    }
}
