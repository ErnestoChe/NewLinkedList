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
        Node tmp = head;
        while(tmp.next != null){
            if(tmp.next.value == _value){
                if(head.value == _value){
                    head = head.next;
                    break;
                }
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
        return true; // если узел был удалён
    }

    public void removeAll(int _value)
    {
        if(head.value == _value){
            head = head.next;
        }
        Node temp = head;
        while(temp.next != null){
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

    public void clear()
    {
        head = null;
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