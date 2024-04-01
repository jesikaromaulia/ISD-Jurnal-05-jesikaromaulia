import java.util.Scanner;

public class ToDoList {
    public static void main(String[] args) {

        QueueLL<String> queue = new QueueLL<>();

        Scanner s = new Scanner(System.in);

        boolean run = true;

        while(run) {
            System.out.println("Pilih operasi: \n1. Tambahkan nama pekerjaan yang harus dilakukan \n2. Tampilkan pekerjaan yang harus diselesaikan terlebih dahulu \n3. Hapus pekerjaan yang sudah selesai \n4. Tampilkan seluruh isi to-do list \n5. keluar");
            
            int pilihan = s.nextInt();
            s.nextLine();

            switch(pilihan) {
                case 1:
                    System.out.print("Masukkan nama pekerjaan: ");
                    String pekerjaan = s.nextLine();

                    queue.enqueue(pekerjaan);
                    System.out.println("Pekerjaan " + pekerjaan + " berhasilkan ditambahkan ke to-do list");
                break;
                case 2:
                    queue.printPekerjaan();
                break;
                case 4:
                    if(queue.isEmpty()) {
                        System.out.println("To-Do list kosong");
                    } else {
                        queue.printQueue();
                        System.out.println();
                    }  
                break;
                case 3:
                    if(queue.isEmpty()) {
                        System.out.println("To-Do list kosong");
                    } else {
                        String hapus = queue.dequeue();
                        // queue.dequeue();
                        System.out.println("Pekerjaan " + hapus + " telah selesai dikerjakan");
                    }
                break;
                case 5:
                    s.close();
                    run = false;
                break;

            }
        }
    }
}
