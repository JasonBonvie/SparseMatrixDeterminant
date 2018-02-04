 import java.util.*;
 import java.lang.Math;

public class SparseMatrix implements SparseInterface {


        ArrayList <Object> values = new ArrayList <Object> ();
        private int cur_rows = 5;
        private int cur_columns = 5;
        private int num_elements = 0;
        private MatrixNode head = null;


        public class MatrixNode {
            int data;
            int row;
            int col;
            public MatrixNode next = null;

            MatrixNode(int data, int row, int col){
                this.data = data;
                this.row = row;
                this.col = col;
            }
        }




        public void addElement(int row, int col, int data){
            MatrixNode node = new MatrixNode(data, row, col);
            MatrixNode current = head;
            if (row > cur_rows || col > cur_columns){
               throw new IndexOutOfBoundsException("Index " + row + ", "
                       + col + " is out of bounds!");
            }
            if ((row < 0) || (col < 0)){
                throw new IndexOutOfBoundsException("Index " + row + ", "
                        + col + " is out of bounds!");
            }

            if (head == null ){
                this.head = node;
                node.next = null;
                return;
            }

            while (current.next != null) {
                if(current.row == row && current.col == col) {
                    current.data = data;
                    break;
                }
                current = current.next;
            }
            if(current.row == row && current.col == col){
                return;
            }
            if (current.next == null) {
                current.next = node;
                num_elements++;
            }




        }
        public String toString() {
            MatrixNode current = head;
            ArrayList <String> list = new ArrayList <String> ();
            if (head == null ){
                return "";
            }
            while (current.next != null) {
                list.add(String.valueOf(current.row));
                list.add(String.valueOf(current.col));
                list.add(String.valueOf(current.data));
                current = current.next;
                }
            list.add(String.valueOf(current.row));
            list.add(String.valueOf(current.col));
            list.add(String.valueOf(current.data));
            String listString = String.join(" ", list);
            String Strang = listString.replaceAll("((?:\\w+\\s){2}\\w+)(\\s)", "$1\n");
            return Strang;
        }


        public void clear() {
            this.head = null;
        }


        public void setSize(int size) {
            this.cur_columns = size;
            this.cur_rows = size;
            this.head = null;
            this.num_elements = 0;

        }


        public void removeElement(int row, int col) {
            if (row > cur_rows || col > cur_columns){
                throw new IndexOutOfBoundsException("Index " + row + ", "
                        + col + " is out of bounds!");
            }
            if ((row < 0) || (col < 0)){
                throw new IndexOutOfBoundsException("Index " + row + ", "
                        + col + " is out of bounds!");
            }
            MatrixNode current = head;
            while(current.next != null){
                if((current.next.col == col) && (current.next.row == row)){
                    current.next = current.next.next;
                    break;
                }
                current= current.next;
            }

        }


        public int getElement(int row, int col) {
            if (row > cur_rows || col > cur_columns){
                throw new IndexOutOfBoundsException("Index " + row + ", "
                        + col + " is out of bounds!");
            }
            if ((row < 0) || (col < 0)){
                throw new IndexOutOfBoundsException("Index " + row + ", "
                        + col + " is out of bounds!");
            }
            MatrixNode current = head;
            while (current.next != null) {
                if ((current.col == col) && (current.row == row)) {
                    return current.data;
                }
                current = current.next;
            }
            if ((current.col == col) && (current.row == row)) {
                return current.data;
            }
            return 0;
        }


        public int determinant() {
            int det = 0;
            int sum = 0;
            for(int i = 0; i < cur_rows; i++ ){
                for(int j = 0; j< cur_columns; j++){
                        det = (int) (Math.pow(-1, i  + j ) * getElement(i,j)*minor(i,j).determinant());
                }
                sum += det;
            }
            return sum;
        }


        public SparseInterface minor(int row, int col) {
            values.clear();
            MatrixNode current = head;
            while (current.next != null){
                if ((current.col != col) ||  (current.row != row)){
                    values.add(current);
                }
            }
            return null;
        }


        public int getSize() {
            return cur_columns;
        }
    }

