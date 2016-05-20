import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Expression{
  
    private Node root=null;
    private List<String> infixAryList= new ArrayList<>();
    private Stack<Node> valueStack = new Stack<>();
    private Stack<String> operatorStack = new Stack<>();

    // DO NOT MODIFY THIS
    public Expression(){}

    // Build a Binary and Return the Root
    public Node Infix2BT(String infix){
        char tmpChar[]=infix.toCharArray();
        Node nodeL;
        Node nodeR;

        for (int i = 0; i < tmpChar.length; i++) {
            infixAryList.add(String.valueOf(tmpChar[i]));
            String t=infixAryList.get(i);
            if (t.equals("(")) ;
            else if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {
                operatorStack.push(t);
            }else if(t.equals(")")) {
                if(root==null) {
                    nodeR = new Node(null, null, valueStack.pop().getValue());
                    nodeL = new Node(null, null, valueStack.pop().getValue());
                }else{
                    nodeR = valueStack.pop();
                    nodeL = valueStack.pop();
                }
                root=new Node(nodeL,nodeR,operatorStack.pop());
                valueStack.push(root);
            }else {
                Node tmpNode=new Node(null,null,t);
                valueStack.push(tmpNode);
            }
        }
        return root;
    }

    public Node[] PrintPrefix(){
        Node[] prefix = null;
        return prefix;
    }
  
    public Node[] PrintPostfix(){
        Node[] postfix = null;
        while(root.getLeft()==null&&root.getRight()==null){

        }
        return postfix;
    }

    public double Evaluation(){
        double answer = 0;

        return answer;
    }
    public static void main(String[] args)throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            Expression expression= new Expression();
            String infix=br.readLine();
//            System.out.println(infix);
            expression.Infix2BT(infix);
        }
    }
}
