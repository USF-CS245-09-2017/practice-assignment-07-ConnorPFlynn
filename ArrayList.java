public class ArrayList<T> implements List<T> {

    private T[] arr;
    private int size = 0;
    private int max = 10;

    ArrayList() {
        arr = (T[]) new Object[10];
    }

    public int size()
    {
        return size;
    }

    public void add(T item)
    {
        // if the array is full, call the grow method, else, increase the size and add at the end
        if (arr.length == size)
        {
            growArray();
        }
        arr[size++] = item;
    }

    public void add (int pos, T item)
    {
        if (arr.length == size)
        {
            growArray(); // call method
        }

        if (size - pos >= 0) System.arraycopy(arr, pos, arr, pos + 1, size - pos);
        arr[pos] = item;
        size++;
    }

    public T get(int pos)
    {
        return arr[pos];
    }

    public T remove(int pos)
    {
        T item = arr[pos];
        // find the item in the array by looping through, set the item to the last position, then decrement

        for(int i = pos; i < size - 1; i++)
        {
            arr[i] = arr[i+1];
        }

        size--;
        return item;
    }

    private void growArray()
    {
        T[] tempArr = (T[]) new Object[arr.length * 2];
        // create temp array with double the size, them copy to the original array object
        System.arraycopy(arr, 0, tempArr, 0, arr.length);
        arr = tempArr;
    }
}