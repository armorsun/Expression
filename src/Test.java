import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Sunny on 5/20/16.
 */
public class Test {
    public static void main(String[] args)throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            Expression expression= new Expression();
            String infix=br.readLine();
//            System.out.println(infix);
            expression.Infix2BT(infix);

        }
    }
}
