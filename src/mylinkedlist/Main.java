package mylinkedlist;

public class Main {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);

        linkedList.addLast(4);
        linkedList.addLast(5);
        linkedList.addLast(6);

        System.out.println("Do dai la: " + linkedList.length());

        System.out.print("Danh sach la: ");
        linkedList.display();

        linkedList.add(0, 3);

        System.out.print("Danh sach sau khi them la: ");
        linkedList.display();

        linkedList.deleteFirst();
        System.out.print("Danh sach da xoa phan tu dau: ");
        linkedList.display();

        linkedList.deleteLast();
        System.out.print("Danh sach da xoa phan tu cuoi: ");
        linkedList.display();

        linkedList.delete(2);
        System.out.print("Danh sach da xoa phan tu mong muon: ");
        linkedList.display();

        boolean found = linkedList.search(0);
        if (found){
            System.out.println("Co du lieu.");
        } else {
            System.out.println("Khong co du lieu.");
        }

        Node nodeAtPosition = linkedList.searchAtPosition(1);
        if (nodeAtPosition != null){
            System.out.println("Phan tu da tim thay la: " + nodeAtPosition.getData());
        } else {
            System.out.println("Khong tim thay du lieu.");
        }

        linkedList.sort();
        System.out.print("Danh sach da sap xep: ");
        linkedList.display();
    }
}
