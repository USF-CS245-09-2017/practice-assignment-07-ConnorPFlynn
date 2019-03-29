public class LinkedList<T> implements List<T>
{
    private Node<T> head;
    private int size;

    LinkedList()
    {
        head = null;
        size = 0;
    }

    public int size()
    {
        return size;
    }

    public void add(T item)
    {
        // check if empty/null, set the head
        if(head == null) {
            head = new Node<>(item);
        }
        else {
            // set the current node as the head
            Node<T> curr = head;
            while (curr.getNext() != null) {
                curr = curr.getNext();
            }
            curr.setNext(new Node<>(item));
        }
        size++;
    }

    public void add(int pos, T item)
    {
        if (pos == 0)
        {
            Node<T> n = new Node<>(item);
            n.setNext(head);
            head = n;
        }
        else
        {
            Node<T> prev = head;
            for (int i = 0; i < pos - 1; i++)
            {
                prev = prev.getNext();
            }
            Node<T> n = new Node<>(item);
            n.setNext(prev.getNext());
            prev.setNext(n);
        }
        ++size;
    }

    public T get(int pos)
    {
        Node<T> n = head;

        for(int i = 0; i < pos; i++)
        {
            n = n.getNext();
        }
        return n.getData();
    }

    public T remove(int pos)
    {
        if(pos == 0)
        {
            Node<T> curr = head;
            head = head.getNext();
            size--;
            return curr.getData();
        }
        else
        {
            Node<T> prev = head;
            for (int i = 0; i < pos - 1; i++)
            {
                prev = prev.getNext();
            }

            Node<T> curr = prev.getNext();
            prev.setNext(curr.getNext());
            size--;
            return curr.getData();
        }
    }

    class Node<T>{

        // separate node class
        T data;
        Node<T> next;

        Node(T data)
        {
            this.data = data;
            next = null;
        }

        T getData()
        {
            return this.data;
        }

         Node getNext()
        {
            return this.next;
        }

        void setNext(Node next)
        {
            this.next = next;
        }
    }
}