import java.util.Arrays;
import java.util.Comparator;

interface MyFunction {
    public void justPrint(String tx1, String tx2);
}

class LambdaExpression {
    public static void main (String[] agrs) {
        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        System.out.println(stringComparator.compare("hello", "world"));


        Comparator<String> stringComparatorLambda = 
                (o1, o2) -> { return o1.compareTo(o2); };

        System.out.println(stringComparatorLambda.compare("hello", "world"));

        // =============

        MyFunction func = (tx1, tx2) -> { System.out.println(tx1 + tx2); };

        func.justPrint("hello", "World");

        // Java lambda expression can implement interfaces with a "single abstract method",
        // but as many default or static methods.        
    }
}
