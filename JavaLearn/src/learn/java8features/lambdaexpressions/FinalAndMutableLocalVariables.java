package learn.java8features.lambdaexpressions;

interface MyFunction {
    int func(int n);
}

interface MyInterface {
    void myFunction();
}
    public class FinalAndMutableLocalVariables {
        int data = 170;
        public static void main(String[] args) {
        int number = 10;
        MyFunction myLambda = (n) ->{
            int value = number + n;
            return value;
        };
        System.out.println(myLambda.func(11));
        System.out.println("number " + number);
        System.out.println("GFG!");

            FinalAndMutableLocalVariables obj = new FinalAndMutableLocalVariables();
            MyInterface intFace = () ->  {
                System.out.println("Data : " + obj.data);
                obj.data += 500;
                System.out.println("Data : " + obj.data);
            };

            intFace.myFunction();
            obj.data += 200;

            System.out.println("Data : " + obj.data);
        }
}
