public class Linklist {
    public Entry head;

    public void Linklist() {
        head = new Entry();
    }

    class Entry {
        int data;
        Entry next;

        public Entry() {
            data = -1;
            next = null;
        }

        public Entry(int a) {
            data = a;
            next = null;
        }
    }

    public void addHead(int data) {
        Entry cur = new Entry(data);
        cur.next = head.next;
        head.next = cur;
    }

    public void addTail(int data) {
        Entry x = head;
        Entry cur = new Entry(data);
        while (x.next != null)
            x = x.next;
        x.next = cur;
        cur.next = null;
    }

    public int lenth() {
        Entry temp = head;
        int len = 0;
        while (temp.next != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    public boolean add(int a, int b) {
        if (a < 0 || a > lenth())
            return false;
        else {
            Entry temp = head;
            Entry cur = new Entry(b);
            for (int i = 0; i < a; i++)
                temp = temp.next;
            cur.next = temp.next;
            temp.next = cur;
            return true;
        }
    }

    public void show() {
        Entry temp = head;
        while (temp.next != null) {
            System.out.print(temp.next.data + " ");
            temp = temp.next;
        }
    }

    public int get(int k) {
        Entry temp = head;
        if (k < 0 || k > lenth()) {
            System.out.println("超出链表长度");
            return temp.data;
        } else {
            for (int i = 0; i < k; i++)
                temp = temp.next;
            return temp.data;
        }
    }

    public int getlast(int k){
        Entry temp= head;
        if (k < 0 || k > lenth()) {
            System.out.println("超出链表长度");
            return temp.data;
        } else {
            for (int i = 0; i <= lenth()-k; i++)
                temp = temp.next;
            return temp.data;
        }
    }

}
