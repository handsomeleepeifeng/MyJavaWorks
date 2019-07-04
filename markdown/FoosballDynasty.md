#Foosball Dynasty
##Description
Balaji and his coworkers like to play Foosball on their lunch break.Foosball is a game
typically played by 2 players (individual matchup) or 4players (team play). However, 
due to the increasing interest and availabilityof coworkers, Balaji has created a new
variation that supports 5 ormore players. Each individual point is played by four
players: two on the White team and two on the Black team.

![Foosball Dynasty](https://github.com/handsomeleepeifeng/MyJavaWorks/blob/master/PIC/Foosball%20Dynasty.png)

The remaining players wait in line for their turn to play. On each point, the players
on the scoring team switch positions (e.g., if White scores the point,then the White
Offense player becomes the White Defense player, and vice versa). The Offense player
of the team that lost the point becomes the Defense player of the same team, while 
the Defense player of the team that lost thepoint goes to the back of the line and
waits for their next chance to play.The person at the front of the line becomes the
new Offense player of the team that lost the point.Based on these rules, a team that
continues scoring consecutive points gets tokeep playing together (swapping
positions with each other after each point) until the other team breaks the streak.
Each such streak of points creates adynastyfor the winning team. Dynasties can be 
short-lived (a single point) or long-lived,but they are always broken when the opposing 
team scores a point. The ``winners" of this variation of foosball are the players that 
can create the longest dynasty.

##Input
Input begins with a line containing an integer nn representing thenumber of players 
(5 \leq n \leq 105≤n≤10). The next line contains the nn names ofall participating 
players. The first four are the names of the fourplayers who initially arrive at the 
table (in that order): the first person toarrive starts at White Offense, the second 
starts at Black Offense, the third starts atWhite Defense, and the fourth starts at 
Black Defense. The remainingplayers get in line to wait for their turn. The final input 
line containsa non-empty string indicating which side scored each point, with a Whiteteam 
point represented by 'W' and a Black team point represented by `B'.  Themaximum length 
of this string will be 1000.

##Output
Display the team that has achieved the longest dynasty. If morethan one team ties for 
the record, then display each of theseteams in chronological order, one team per line. 
When displaying ateam, names should be displayed in the order in which the players 
arrived at the table for that team.Note that it is possible for the same team to appear 
more than once in the output, potentially with the player names in a different order.

##Sample
### Input 1
    6
    Balaji David Alex Scott Andrew Ravi
    WWBWBBWBW
###Output 1
    Balaji Alex
    Andrew David
###Input 2
    6
    Amy Jinu Kasey Sarah Sheetal Julia
    BBBBB
###Onput 2
    Jinu Sarah
##MisunderstandingCode
    import java.util.*;
    
    public class FoosballDynasty {
    
        public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            int Num = scan.nextInt();
            String[] Name = new String[Num];
            int[] SeqOfPlayer = new int[Num];
            for(int i = 0; i<Num; i++){
                Name[i] = scan.next();
                SeqOfPlayer[i] = i;
            }
            String Scored = scan.next();
            Solution(Num,SeqOfPlayer,Name,Scored);
        }
    
    
        private static void Solution(int NumOfPlayer, int[] SeqOfPlayer, String[] PlayerName, String ScoredSeq){
            int Round = 0;
            int[][] TeamScored = new int[NumOfPlayer][NumOfPlayer];
            char[] ScoredSeqArray = ScoredSeq.toCharArray();
            RecurPlaying(Round,SeqOfPlayer,ScoredSeqArray,TeamScored);
            FindandPrint(TeamScored,PlayerName);
    
    
    
        }
    
        private static void RecurPlaying(int Round, int[] SeqOfPlayer, char[] ScoredSeq, int[][] TeamScored){
            CalculateTheScore(Round,SeqOfPlayer,TeamScored);
            ChangeThePlayer(SeqOfPlayer,ScoredSeq[Round]);
            boolean flag = false;
            if (Round == ScoredSeq.length-1)
                flag = true;
            if (!flag)
                RecurPlaying(++Round,SeqOfPlayer,ScoredSeq,TeamScored);
        }
    
        private static void ChangeThePlayer(int[] SeqofPlayer, char str){
            int temp;
            if (str == 'W' || str == 'w'){
                temp = SeqofPlayer[0];
                SeqofPlayer[0] = SeqofPlayer[2];
                SeqofPlayer[2] = temp;
                temp = SeqofPlayer[3];
                SeqofPlayer[3] = SeqofPlayer[1];
                SeqofPlayer[1] = SeqofPlayer[4];
                for (int i = 5; i<=SeqofPlayer.length-1;i++){
                    SeqofPlayer[i-1] = SeqofPlayer[i];
                }
                SeqofPlayer[SeqofPlayer.length-1] = temp;
            }
            if (str == 'B' || str == 'b'){
                temp = SeqofPlayer[1];
                SeqofPlayer[1] = SeqofPlayer[3];
                SeqofPlayer[3] = temp;
                temp = SeqofPlayer[2];
                SeqofPlayer[2] = SeqofPlayer[0];
                SeqofPlayer[0] = SeqofPlayer[4];
                for (int i = 5; i<=SeqofPlayer.length-1;i++){
                    SeqofPlayer[i-1] = SeqofPlayer[i];
                }
                SeqofPlayer[SeqofPlayer.length-1] = temp;
            }
        }
    
        private static void CalculateTheScore(int Round, int[] SeqOfPlayer, int[][] TeamScored){
            TeamScored[SeqOfPlayer[0]<SeqOfPlayer[2]?SeqOfPlayer[0]:SeqOfPlayer[2]][SeqOfPlayer[0]>SeqOfPlayer[2]?SeqOfPlayer[0]:SeqOfPlayer[2]]++;
            TeamScored[SeqOfPlayer[0]>SeqOfPlayer[2]?SeqOfPlayer[0]:SeqOfPlayer[2]][SeqOfPlayer[0]<SeqOfPlayer[2]?SeqOfPlayer[0]:SeqOfPlayer[2]] = Round;
            TeamScored[SeqOfPlayer[1]<SeqOfPlayer[3]?SeqOfPlayer[1]:SeqOfPlayer[3]][SeqOfPlayer[1]>SeqOfPlayer[3]?SeqOfPlayer[1]:SeqOfPlayer[3]]++;
            TeamScored[SeqOfPlayer[1]>SeqOfPlayer[3]?SeqOfPlayer[1]:SeqOfPlayer[3]][SeqOfPlayer[1]<SeqOfPlayer[3]?SeqOfPlayer[1]:SeqOfPlayer[3]] = Round;
        }
    
        private static void FindandPrint(int[][] TeamScored,String[] PlayerName){
            SortedMap<Integer,String> DynastyandRound = new TreeMap<>();
            int longestDynasty = 0;
            for (int i = TeamScored.length-1; i>=0; i--){
                for(int j =0; j<i; j++){
                    if (TeamScored[j][i]>longestDynasty)
                        longestDynasty = TeamScored[j][i];
                }
            }
            for (int i = TeamScored.length-1; i>=0; i--)
                for(int j =0 ;j<i; j++){
                    if (TeamScored[j][i] == longestDynasty){
                        DynastyandRound.put(TeamScored[i][j],PlayerName[i]+' '+PlayerName[j]);
                    }
                }
            Set<Map.Entry<Integer,String>> entryset = DynastyandRound.entrySet();
            for (Map.Entry<Integer, String> entry : entryset) {
                System.out.print(entry.getValue()+'\n');
            }
        }
    }
    //What i used to do is to calculate which team player on the table longest in total,but
    not the "dynasty",Those code work well in my misunderstanding.
##Mycode
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
    
            for (String s : output) {
                System.out.println(s);
            }
            //System.out.print(output.get(output.size()-1));
        }
    
        private static void NewTeam(String Player1, String Player2, ArrayList<String> output){
            String Team = Player1.concat(" "+Player2);
                if (!output.contains(Team))
                    output.add(Team);
        }
    }