#实现Singleton模式
##题目
设计一个类，我们只能生成该类的一个实例
##代码
        /*****
        *在一开始就创建对象，对象始终存在
        *****/
        class ProTwoSingleton {
            private ProTwoSingleton(){
        
            }
            private static ProTwoSingleton Simple = new ProTwoSingleton();
            public static ProTwoSingleton getSimple(){
                return Simple;
            }
        }
         /*****
          *在需要用到对象的时候才创建，如果对象还没创建则创建，反之如果对象存在则直接调用
         *****/
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