public class Main {
    public static void main(String[] args) {
        SmartArray smartArray = new SmartArray();
        smartArray.add(5);
        smartArray.add(8);
        smartArray.add(7);
        smartArray.add(6);

        System.out.println(smartArray.getSize());

        System.out.println(smartArray.get(2));
        System.out.println(smartArray.remove(1));
        System.out.println(smartArray.contains(8));

        smartArray.insert(1, 10);

        smartArray.forEach(el -> System.out.println(el));


        System.out.println();


        CustomStack customStack = new CustomStack();
        customStack.push(5);
        customStack.push(6);
        customStack.push(7);
        customStack.push(8);
        customStack.push(9);
        customStack.push(10);

        System.out.println(customStack.getSize());

        System.out.println(customStack.pop());
        System.out.println(customStack.peek());
        System.out.println(customStack.pop());

        customStack.forEach(el -> System.out.println(el));


        System.out.println();

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addLast(1);
        doublyLinkedList.addLast(2);
        doublyLinkedList.addLast(3);
        doublyLinkedList.addLast(4);
        doublyLinkedList.addLast(5);
    }
}
