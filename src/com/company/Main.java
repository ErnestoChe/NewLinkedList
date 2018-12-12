package com.company;


class LinkedList
{
    public Node head;
    public Node tail;

    public LinkedList()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                nodes.add(node);
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value)
    {
        boolean flag = false;
        if(head == null){
            flag = false;
        } else if(head == tail && head.value == _value){
            head = null;
            tail = null;
            flag = true;
        }else{
            Node tmp = head;
            if(head.value == _value){
                head = head.next;
                flag = true;
            }else{
                while(tmp.next != null){
                    if(tmp.next.value == _value){
                        flag = true;
                        Node t = tmp.next;
                        tmp.next = t.next;
                        if(t.next == null){
                            tail = tmp;
                        }
                        break;
                    }
                    else{
                        tmp = tmp.next;
                    }
                }
            }
        }
        return flag;
    }

    /*public void removeAll(int _value)
    {
        if(head == tail && head.value == _value){
            head = null;
            tail = null;
        }else
            {
                Node temp = head;
                while(temp.next != null){
                    if(head.value == _value){
                        head = head.next;
                    }
                    if(temp.next.value == _value){
                        Node t = temp.next;
                        temp.next = t.next;
                        if(t.next == null){
                            tail = temp;
                        }
                    }else{
                        temp = temp.next;
                    }
                }
            }
    }*/
    public void removeAll(int _value)
    {
        Node temp = head;
        while(temp.next != null){
            remove(_value);
            temp = temp.next;
        }
        if(head == tail && head.value == _value){
            head = null;
            tail = null;
        }
    }

    public void clear()
    {
        head = null;
        tail = null;
    }

    public int count()
    {
        Node temp = head;
        int count = 0;
        while (temp != null)
        {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        if(tail == _nodeAfter){
        addLast(_nodeToInsert.value);
    }else{
        Node tmp = head;
        while((tmp != null) && (tmp != _nodeAfter)){
            tmp = tmp.next;
        }
        if(tmp != null){
            Node n = new Node(_nodeToInsert.value);
            n.next = tmp.next;
            tmp.next = n;
        }
    }

    }
    public void addLast(int new_data){

        if(head == null){
            addFirst(new_data);
        }
        else{
            Node tmp = new Node(new_data);
            tail.next = tmp;
            tail = tail.next;
        }
    }
    public void addFirst(int new_data) {
        head = new Node(new_data);
        tail = head;
    }
    public void log(){

        Node temp = head;

        if(head == null){

            System.out.println("empty list");

        }

        while(temp!= null){

            System.out.print(temp.value+" ");

            temp = temp.next;

        }

        System.out.println();

    }
}

class Node
{
    public int value;
    public Node next;
    public Node(int _value)
    {
        value = _value;
        next = null;
    }
}