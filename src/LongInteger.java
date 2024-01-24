public class LongInteger {

    private LinkedList list;
    LongInteger (String string){
        list = new LinkedList();
        for (int i=0;i<string.length();i++){
            Node node = new Node(Character.getNumericValue(string.charAt(i)));
            list.insertLast(node);
        }
    }

    LongInteger (LinkedList linkedList){
        String string=new String("");
        Node tmpNode=linkedList.head;
        for(int i=0;i<linkedList.numberOfElements();i++){
            string+=tmpNode.data;
            tmpNode=tmpNode.next;
        }

        list = new LinkedList();

        for (int i=0;i<string.length();i++){
            Node node = new Node(Character.getNumericValue(string.charAt(i)));
            list.insertLast(node);
        }
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        Node tmp = list.head;
        while (tmp != null) {
            result.append(tmp).append("");
            tmp = tmp.getNext();
        }
        return result.toString();
    }

    public LinkedList getList(){
        return list;
    }
}
