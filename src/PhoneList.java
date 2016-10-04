import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PhoneList {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int t = Integer.valueOf(scan.nextLine());
        
        while (t-- > 0) {
            int n = Integer.valueOf(scan.nextLine());
            
            List<String> phonesLst = new ArrayList<String>();
            while (n-- > 0) {
                String phone = scan.nextLine();
                phonesLst.add(phone);
            }
            
            System.out.println(isConsistent(phonesLst)? "YES" : "NO");
        }
        
        scan.close();
    }
    
    private static boolean isConsistent(List<String> phoneLst) {
    
        // 1. Sort the list based on length (shorter first, longest last)
        phoneLst.sort(new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                Integer length1 = o1.length();
                Integer length2 = o2.length();
                
                return length1.compareTo(length2);
            }
            
        });

        // 2. Create a tree with prefixes. Return false when a repeated prefix is detected.
        Node root = new Node(false);
        
        for (String phone : phoneLst) {
            
            Node node = root;
            char[] phoneArray = phone.toCharArray();
            
            for (int i = 0 ; i < phoneArray.length ; i++) {
                
                if (node.contains(phoneArray[i])) {
                    node = node.get(phoneArray[i]);
                    if (node.mIsEnd) {
                        return false; // Prefix repeated
                    } 
                } else {
                    node = node.add(phoneArray[i], i == phoneArray.length - 1);
                }
            }
        }
        
        return true;
    }
    
    public static class Node {
        private Map<Character, Node> mChildren = new HashMap<>();
        private boolean mIsEnd;
        
        public Node(boolean isEnd) {
            mIsEnd = isEnd;
        }
        
        public Node add(char charNode, boolean isEnd) {
            Node newNode = new Node(isEnd);
            mChildren.put(charNode, newNode);
            return newNode;
        }
        
        public boolean contains(char charNode) {
            return mChildren.containsKey(charNode);
        }
        
        public Node get(char charNode) {
            return mChildren.get(charNode);
        }
    }
}