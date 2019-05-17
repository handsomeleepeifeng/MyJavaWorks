import java.util.*;

public class FoosballDynasty {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //while (scan.hasNext()) {
            int Num = scan.nextInt();
            String[] Name = new String[Num];
            int[] SeqOfPlayer = new int[Num];
            for (int i = 0; i < Num; i++) {
                Name[i] = scan.next();
                SeqOfPlayer[i] = i;
            }
            String Scored = scan.next();
            FindAllDynasty(SeqOfPlayer, Name, Scored);
        //}
    }
    private static void ChangeThePlayer(int[] SeqofPlayer, String str , int Round){
        int temp;
        for (int i = 0; i<Round; i++){
            if (str.charAt(i) == 'W' || str.charAt(i) == 'w'){
                temp = SeqofPlayer[0];
                SeqofPlayer[0] = SeqofPlayer[2];
                SeqofPlayer[2] = temp;
                temp = SeqofPlayer[3];
                SeqofPlayer[3] = SeqofPlayer[1];
                SeqofPlayer[1] = SeqofPlayer[4];
                if (SeqofPlayer.length > 5)
                    System.arraycopy(SeqofPlayer, 5, SeqofPlayer, 4, SeqofPlayer.length - 1 - 4);
                SeqofPlayer[SeqofPlayer.length-1] = temp;
            }
            if (str.charAt(i) == 'B' || str.charAt(i) == 'b'){
                temp = SeqofPlayer[1];
                SeqofPlayer[1] = SeqofPlayer[3];
                SeqofPlayer[3] = temp;
                temp = SeqofPlayer[2];
                SeqofPlayer[2] = SeqofPlayer[0];
                SeqofPlayer[0] = SeqofPlayer[4];
                if (SeqofPlayer.length > 5)
                    System.arraycopy(SeqofPlayer, 5, SeqofPlayer, 4, SeqofPlayer.length - 1 - 4);
                SeqofPlayer[SeqofPlayer.length-1] = temp;
            }
        }
    }
    private static void FindAllDynasty(int[] SeqOfPlayer, String[] PlayerName,String ScoredString){
        SortedMap<Integer,Integer> Result = new TreeMap<>();
        int temp = 0;
        int Dynasty = 0;
        ArrayList<String> output = new ArrayList<>();
        for (int i = 1; i<ScoredString.length(); i++){
            if (ScoredString.charAt(i) == ScoredString.charAt(i-1)){
                temp++;
                if (temp >= Dynasty){
                    Dynasty = temp;
                    Result.put(i-temp,Dynasty);
                }
            }
            else
                temp = 0;
        }
        Set<Map.Entry<Integer,Integer>> entrySet = Result.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            if (entry.getValue() >= Dynasty) {
                int value = entry.getKey();
                ChangeThePlayer(SeqOfPlayer, ScoredString, value);
                if (ScoredString.charAt(value) == 'W') {
                    if (value == 0)
                        NewTeam(PlayerName[SeqOfPlayer[0]],PlayerName[SeqOfPlayer[2]],output);
                    else
                        NewTeam(PlayerName[SeqOfPlayer[2]],PlayerName[SeqOfPlayer[0]],output);
                }
                if (ScoredString.charAt(value) == 'B') {
                    if (value == 0)
                        NewTeam(PlayerName[SeqOfPlayer[1]],PlayerName[SeqOfPlayer[3]],output);
                    else
                        NewTeam(PlayerName[SeqOfPlayer[3]],PlayerName[SeqOfPlayer[1]],output);
                }
            }
        }

        for (int i=0; i<output.size()-1; i++) {
            System.out.println(output.get(i));
        }
        System.out.print(output.get(output.size()-1));
    }

    private static void NewTeam(String Player1, String Player2, ArrayList<String> output){
        String Team = Player1.concat(" "+Player2);
            if (!output.contains(Team))
                output.add(Team);
    }
}
