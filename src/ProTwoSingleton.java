class ProTwoSingleton {
    private ProTwoSingleton(){

    }//构析，禁止外界访问设为私有；
    private static ProTwoSingleton Simple = new ProTwoSingleton();
    public static ProTwoSingleton getSimple(){
        return Simple;
    }//通过函数来获取Simple

}

class ProTwoSingleton2{
    private ProTwoSingleton2(){

    }
    private static ProTwoSingleton2 Simple2 = null;

    public synchronized static ProTwoSingleton2 getInstance(){
        if (Simple2 == null){
            Simple2 = new ProTwoSingleton2();
        }
        return Simple2;
    }
}