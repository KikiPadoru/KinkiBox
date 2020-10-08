package com.model;
public class MyList<T> {


    public void setSq (ListStackQueue<T> sq){
        this.sq = sq;
        sq.setList(this);
    }
    public void push(T item){
        sq.push(item);
    }

    public int getSize() {

        return size;
    }

    class Node<T>{
        private T info;
        private Node<T> next;

        public Node(T info, Node<T> next) {
            this.info = info;
            this.next = next;
        }

        public Node() {
        }

        public Node(T info) {
            this.info = info;
        }

        public void setInfo(T info) {
            this.info = info;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }


    }
    Node<T> head;
    Node<T> tail;
    Node<T> currentNode;
    public int size;

    ListStackQueue<T> sq;
    public MyList() {
        head = null;
        tail = null;
    }
    public void addToEnd(T info){
        if(head ==null){
            head = new Node(info,null);
            tail= head;
        }
        else{
            Node<T> current = new Node<>(info,null);
            tail.next = current;
            tail = current;
        }
    }
    public void addToBegin(T info){
        if(head ==null){
            head = new Node(info,null);
            tail= head;
        }
        else{
            Node<T> current = new Node<>(info,head);
            head = current;
        }
    }
    public T pop(){
        size--;
        if(head!=null){
            Node<T> current = head;
            head = head.next;
            return current.info;
        }

        return null;
    }
    public T getIndex(int ind){
        int j=0;
        Node<T> i= head;
        for(; i.next!=null &&j<ind; j++, i=i.next );

        return i.info;
    }
    public void add(T value) {
        Node<T> nodeToAdd = new Node<T>(value);
        if (head == null) { head = nodeToAdd; currentNode = head; }
        else {
            Node<T> cur = head;
            while(cur.next != null) cur = cur.next;
            cur.next = nodeToAdd;
            currentNode = nodeToAdd;
        }
        size++;
    }
    @Override
    public String toString() {
        String str = "";
        for(Node<T>i = head; i!=null ;  i=i.next )
            str+=i.info +" ";
        return str;
    }
    public void add_front(T value) {
        Node<T> nodeToAdd = new Node<T>(value);
        if (head == null) { head = nodeToAdd; currentNode = head; }
        else {
            nodeToAdd.next =head;
            head = nodeToAdd;
        }

        size++;
    }

}

