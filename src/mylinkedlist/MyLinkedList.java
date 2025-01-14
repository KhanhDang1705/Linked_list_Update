package mylinkedlist;

public class MyLinkedList {
    private Node head;

    public void display(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.getData());
            if (temp.getNext() != null){
                System.out.print("->");
            }
            temp = temp.getNext();
        }
        System.out.println();
    }

    public int length(){
        Node temp = head;
        int count = 0;
        while (temp != null){
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        newNode.setNext(head);
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            return;
        } else {
            Node temp = head;
            while (temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
    }

    public void add(int data, int index){
        Node newNode = new Node(data);
        if (index == 0){
            addFirst(data);
            return;
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1 ; i++){
                temp = temp.getNext();
            }
            Node nextNode = temp.getNext();
            temp.setNext(newNode);
            newNode.setNext(nextNode);
        }
    }

    public void deleteFirst(){
        if (head != null){
            head = head.getNext();
        }
    }

    public void deleteLast(){
        if (head == null){
            return;
        } else if (head.getNext() == null){
            deleteFirst();
        } else {
            Node temp = head;
            Node preTemp = null;
            while(temp.getNext() != null){
                preTemp = temp;
                temp = temp.getNext();
            }
            preTemp.setNext(null);
        }
    }

    public void delete(int index){
        if (index == 0){
            deleteFirst();
        } else if (index == length() - 1){
            deleteLast();
        } else {
            int count = 0;
            Node temp = head;
            while (count < index - 1){
                count++;
                temp = temp.getNext();
            }
            Node nextNode = temp.getNext();
            temp.setNext(nextNode.getNext());
        }
    }

    public boolean search(int data){
        if (head == null){
            return false;
        } else {
            Node temp = head;
            while (temp != null){
                if (temp.getData() == data){
                    return true;
                }
                temp = temp.getNext();
            }
        }
        return false;
    }

    public Node searchAtPosition(int index){
        if (index < 0 || index >= length()){
            return null;
        }
        Node temp = head;
        for (int i = 0; i < index; i++){
            temp = temp.getNext();
        }
        return temp;
    }

    public void sort(){
        if (head == null || head.getNext() == null){
            return;
        } else {
            boolean swapped;
            do {
                swapped = false;
                Node temp = head;
                while (temp != null && temp.getNext() != null){
                    if (temp.getData() > temp.getNext().getData()){
                        int tempData = temp.getData();
                        temp.setData(temp.getNext().getData());
                        temp.getNext().setData(tempData);
                        swapped = true;
                    }
                    temp = temp.getNext();
                }
            } while (swapped);
        }
    }

    public void sortAtPosition(int start, int end){
        if (start > end || end < 0 || start < 0){
            return;
        }
        Node temp = head;
        int i = 0;
        while (i < start){
            temp = temp.getNext();
            i++;
        }
        while (i < end){
            Node temp2 = temp.getNext();
            while (temp2 != null){
                if (temp.getData() > temp2.getData()){
                    int tempData = temp.getData();
                    temp.setData(temp2.getData());
                    temp2.setData(tempData);
                }
                temp2 = temp2.getNext();
            }
            temp = temp.getNext();
            i++;
        }
    }
}
