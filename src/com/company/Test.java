package com.company;

public class Test {
    public static void testRemoveAll(){
        LinkedList list = new LinkedList();
        int count = 0;
        int fail = 0;


        for(int i = 0; i< 6; i++){
            list.addLast((i+1) % 3);
        }
        list.addLast(3);
        list.addLast(4);
        list.addLast(4);
        for(int i = 0; i<5; i++){
            list.removeAll(i);
        }
        if(list.head == null && list.tail == null){
            count++;
        }else fail++;
        list.clear();
        //удаление всех элементов по очереди

        list.addLast(2);
        list.removeAll(2);
        if(list.head == null && list.tail == null){
            count++;
        }else fail++;
        list.clear();
        //удаление единственного


        list.addLast(1);
        list.addLast(1);
        list.removeAll(1);
        if(list.head == null && list.tail == null){
            count++;
        }else fail++;
        list.clear();
        //удаление двух первых единственных


        list.addLast(4);
        list.addLast(3);
        list.addLast(3);
        list.addLast(5);
        list.removeAll(3);
        if(list.head.value == 4 && list.tail.value == 5){
            count++;
        }else fail++;
        list.clear();
        //удаление "внутренних" элементов


        list.addLast(4);
        list.addLast(3);
        list.addLast(4);
        list.removeAll(4);
        if(list.head == list.tail){
            count++;
        }else fail++;
        list.clear();
        //удаление первого и последнего


        System.out.println(count + " success");
        System.out.println(fail + " fails");
    }
    public static void testRemove(){
        LinkedList list = new LinkedList();
        int count = 0;
        int fail = 0;


        for(int i = 0; i< 6; i++){
            list.addLast((i+1) % 3);
        }
        list.addInTail(new Node(4));
        list.addInTail(new Node(3));
        list.remove(1);
        if(list.head.value == 2){
            count++;
        }else {
            fail++;
            System.out.println("head delete fail");
        }
        //удаление головного элемента

        Node tmp = list.head;
        boolean check4 = false;
        list.remove(4);
        while(tmp.next!=null){
            if(tmp.value == 4){
                check4 = true;
            }
            tmp = tmp.next;
        }
        if(!check4){
            count++;
        }else {
            fail++;
            System.out.println("not tail delete fail");
        }
        //удаление элемента не являющегося ни головным ни хвостовым


        list.remove(3);
        if(list.tail.value == 0){
            count++;
        }else {
            fail++;
            System.out.println("tail delete fail");
        }
        //удаление хвостового элемента
        list.clear();

        list.addInTail(new Node(1));
        list.remove(1);
        if(list.head == null && list.tail == null){
            count++;
        }else {
            fail++;
            System.out.println("one element delete fail");
        }
        //удаление единственного элемента

        System.out.println(count+" success");
        System.out.println(fail+" fails");
    }
}

class Main{
    public static void main(String[] args){
        Test.testRemoveAll();
        Test.testRemove();
    }
}