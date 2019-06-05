import java.util.*;

public class Alicesgame {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        HashMap<Integer,String> Point = new HashMap<>();
        int NumPoint = 0;
        while (scan.hasNext()){
            String input = scan.nextLine();
            if (!input.contains(" ")){
                if(input.charAt(0)!='0'){
                    NumPoint = Integer.valueOf(input);
                }
                else {
                    for (Integer out : Point.keySet()) {
                        System.out.println(out + "//" + Point.get(out));
                    }
                    findallpoint(Point, NumPoint);
                }
            }
            else {
                String[] temp = input.split(" ");
                buildthemap(temp,Point);
            }
        }

    }

    private static void buildthemap(String[] temp,HashMap<Integer,String> Point){
        if (Point.containsKey(Integer.valueOf(temp[0]))){
            String str =Point.get(Integer.valueOf(temp[0])).concat("-").concat(temp[1]).concat(" ").concat(temp[2]);
            Point.replace(Integer.valueOf(temp[0]),str);
        }
        if (Point.containsKey(Integer.valueOf(temp[1]))){
            String str =Point.get(Integer.valueOf(temp[1])).concat("-").concat(temp[0]).concat(" ").concat(temp[2]);
            Point.replace(Integer.valueOf(temp[1]),str);
        }
        if (!Point.containsKey(Integer.valueOf(temp[0]))){
            String str = temp[1].concat(" ").concat(temp[2]);
            Point.put(Integer.valueOf(temp[0]),str);
        }
        if (!Point.containsKey(Integer.valueOf(temp[1]))){
            String str = temp[0].concat(" ").concat(temp[2]);
            Point.put(Integer.valueOf(temp[1]),str);
        }
    }

    private static void findallpoint(HashMap<Integer,String> Point,int Numpoint){
        ArrayList<String> couple = new ArrayList<>();
        int Num4 = 0;
        //ArrayList<String> Total  = new ArrayList<>();
        //for(int key : Point.keySet()){
            Findnear4point(0,1,Point,couple,0);
            Num4 = couple.size()+Num4;
            for (String str : couple) {
                System.out.print(1);
                System.out.println(str);
            }
            if (couple.size() > 0) {
                couple.subList(0, couple.size()).clear();
                //System.out.println(couple.size());
            //}
        }
        int Molecule = Num4/2;
        int denominator = Numpoint*(Numpoint-1)/2;
        int Gcd = gcd(denominator,Molecule);
        System.out.print(Molecule/Gcd);
        System.out.print("/");
        System.out.print(denominator/Gcd);
    }

    private static void Findnear4point(int priviouskey,int currentkey,HashMap<Integer,String> Point,ArrayList<String> couple,int distance){
        String nearPoint = Point.get(currentkey);
        System.out.println(currentkey);
        String[] nearArray = nearPoint.split("-");
        for (String str: nearArray){
            String[] temp = str.split(" ");
            boolean flag1 = !(temp[0].contains(String.valueOf(priviouskey)));
            boolean flag2 = !(priviouskey == currentkey);
            if ((flag1&&flag2)) {
                if ((distance+Integer.valueOf(temp[1])) == 4){
                    couple.add(temp[0]);
                    //System.out.println(temp[0]);
                }
                else if (distance + Integer.valueOf(temp[1]) < 4) {
                    //System.out.println(temp[0]);
                    distance = distance + Integer.valueOf(temp[1]);
                    //System.out.println(distace);
                    Findnear4point(currentkey,Integer.valueOf(temp[1]),Point,couple,distance);
                }
            }
        }
    }

    private static int gcd(int x, int y){
        if(y == 0)
            return x;
        else
            return gcd(y,x%y);
    }
}
