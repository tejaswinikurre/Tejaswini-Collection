import java.util.Arrays;
 
class CustomList<E> 
{
    private int size = 0;
    private static final int DEFAULT_LENGTH = 10;
    private Object elements[];
    public CustomList() {
        elements = new Object[DEFAULT_LENGTH];
    }
    public void add(E e) {
        if (size == elements.length) {
            CalculateLength();
        }
        elements[size++] = e;
    }
    @SuppressWarnings("unchecked")
    public E FetchElementAt(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) elements[i];
    }
    @SuppressWarnings("unchecked")
    public E remove(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        Object item = elements[i];
        int numElts = elements.length - ( i + 1 ) ;
        System.arraycopy( elements, i + 1, elements, i, numElts ) ;
        size--;
        return (E) item;
    }
    public int ListSize() {
        return size;
    }
    @Override
    public String toString() 
    {
         StringBuilder sb = new StringBuilder();
         sb.append('[');
         for(int i = 0; i < size ;i++) {
             sb.append(elements[i].toString());
             if(i<size-1){
                 sb.append(",");
             }
         }
         sb.append(']');
         return sb.toString();
    }
     
    private void CalculateLength() {
        int Size = elements.length * 2;
        elements = Arrays.copyOf(elements, Size);
    }
}


 
public class Collections
{
    public static void main(String[] args) 
    {
        CustomList<Integer> list = new CustomList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println(list);
        System.out.println(list);
        System.out.println( list.FetchElementAt(0) );
        System.out.println( list.FetchElementAt(1) );
        System.out.println(list.ListSize());
    }
}