import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Functional {
    public interface UnaryOperator<T> {
        T apply(T t1);
    }

    public static void main(String[] args) {
        streams();
    }

    private static void m3() {
        UnaryOperator<Integer> Sqare = x -> x * x;
        System.out.println(Sqare.apply(5));
        UnaryOperator<StringBuilder> op = S6 -> reverseAndToLowerCase(S6);
        System.out.println(op.apply(new StringBuilder("Java 8")));

    }

    private static StringBuilder reverseAndToLowerCase(StringBuilder S6) {
        return new StringBuilder((S6.insert(0, "it-courses.by/"))
                .append(".html")
                .toString()
                .replace("", "_")
                .toLowerCase());
    }

    private static void m4() {
//        public interface Function<T,R>{
//            R apply(T t);
//        }
//        Function<Integer,String> convert = x->String.valueOf(x)+"dollars";
//        Function<String,Integer > StringToNumber = x ->Integer.valueOf(x)*100;
//        System.out.println(convert.apply(5));
//        System.out.println(StringToNumber.apply(120));
    }

    private static void m5() {


        Consumer<Integer> printer = x -> System.out.printf("%d, dollars \n", x);
        printer.accept(600);
    }

    static class User {
        private String name;

        String getName() {
            return name;
        }

        User(String n) {
            this.name = n;
        }
    }

    private static void m6() {


    Supplier<User> userfacttory = () -> {
        Scanner in = new Scanner(System.in);
        System.out.println(("Enter Name"));
        String name = in.nextLine();
        return new User(name);
    };
    User user1 = userfacttory.get();
    User user2 = userfacttory.get();
        System.out.println(user1.getName());
        System.out.println(user2.getName());
}
private static void sorting(){
        List<String> names = Arrays.asList("peter","anna","mike","xenia");
        Collections.sort(names);
        Comparator<String> reverseComparator= new Comparator<String>(){
            @Override
            public int compare(String a,String b){
                return b.compareTo(a);
            }
        };
}
private static void optional(){
    List<String> StringNumbers = Arrays.asList("9","two","2",null);
    Optional<Integer> op1 = StringToNumber(StringNumbers.get(0));
    Optional<Integer> op2 = StringToNumber(StringNumbers.get(3));
    if(op1.isPresent()){
        System.out.println(op1.get());
    }
}
private static Optional<Integer>StringToNumber(String string){
    Optional<Integer> result;
    try{
        result=Optional.ofNullable(Integer.valueOf(string));
    }catch(NumberFormatException e){
        result=Optional.empty();
    }
    return result;

}
private static void streams(){
    List<String> Strings = Arrays.asList("dd2","aa3","6661","aaa1","bbb3","ccc","bbb2","ddd1");
    Strings.stream()
            .sorted()
            .sorted((a,b)->b.compareTo(a))
            .filter((s)->s.startsWith("a"))
            .map(String::toUpperCase)
            .forEach(System.out::println);




}
}
