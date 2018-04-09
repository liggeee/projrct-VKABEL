package cobacoba;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class CobaCoba {

    static String data = new String();
    static ArrayList dataPelanggan = new ArrayList();
    static ArrayList dataPelangganUsername = new ArrayList();
    static ArrayList dataPelangganPassword = new ArrayList();
    static ArrayList dataPelangganAlamat = new ArrayList();
    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static boolean kondisi = true;
    static CobaCoba dataInput = new CobaCoba();
    static CobaCoba condition = new CobaCoba();
    final BufferedReader input = new BufferedReader(inputStreamReader);
    int pilihan;
    String namaPelanggan;
    String userPelanggan;
    String passPelanggan;
    String alamatPelanggan;

    static boolean choiceCondition() {
        return condition.pilihan <= dataPelanggan.size() && condition.pilihan > 0;
    }

    static void noChoice()  {
        System.out.println("Pilihan tidak tersedia");
    }

    static void noData() {
        System.out.println("Data tidak ada");
    }
    
    static void dataTo() {
        int i = dataPelanggan.size();
        System.out.format("Data ke-%d : \n", i);
    }

    static void garisTepi(){
        System.out.println("==============================");
    }

    static void garisTepiSpace() throws IOException {
        garisTepi();
        System.out.println();
    }

    static void notification(int pilihan, String keterangan) throws IOException {
        System.out.format("Data ke=%d berhasil %s\n", pilihan, keterangan);
    }

    static void dataPelanggan() throws IOException {
        if (dataPelanggan.isEmpty()) {
            noData();
        } else {
            for (int i = 0; i < dataPelanggan.size(); i++) {
                System.out.format("Data ke-%d : \n", (i + 1));
                System.out.format("1. Nama Lengkap: %s\n", dataPelanggan.get(i));
                System.out.format("2. Username: %s\n", dataPelangganUsername.get(i));
                System.out.format("3. Password: %s\n", dataPelangganPassword.get(i));
                System.out.format("4. Alamat: %s\n", dataPelangganAlamat.get(i));
            }
        }
    }

    static void showMenu() throws IOException {
        System.out.println("============MENU==============");
        System.out.println("[1]. Daftar data pelanggan");
        System.out.println("[2]. Tambahkan data pelanggan");
        System.out.println("[3]. Ubah data pelanggan");
        System.out.println("[4]. Hapus data pelanggan");
        System.out.println("[5]. Format data pelanggan");
        System.out.println("[6]. Keluar");
        System.out.print("Pilih : ");
        int pilihan = Integer.valueOf(dataInput.input.readLine());
        garisTepiSpace();
        switch (pilihan) {
            case 1:
                showData();
                break;
            case 2:
                insertData();
                break;
            case 3:
                editData();
                break;
            case 4:
                deleteData();
                break;
            case 5:
                formatData();
                break;
            case 6:
                System.exit(0);
                break;
            default:
                garisTepi();
                noChoice();
        }
    }

    static void showData() throws IOException {
        System.out.println("====Daftar Data Pelanggan=====");
        dataPelanggan();
    }

    static void inputData() throws IOException {
        System.out.print("1. Nama Lengkap: ");
        dataInput.namaPelanggan = dataInput.input.readLine();
        System.out.print("2. Username: ");
        dataInput.userPelanggan = dataInput.input.readLine();
        System.out.print("3. Password: ");
        dataInput.passPelanggan = dataInput.input.readLine();
        System.out.print("4. Alamat: ");
        dataInput.alamatPelanggan = dataInput.input.readLine();
    }

    static void insertData() throws IOException {
        System.out.println("===Tambahkan Data Pelanggan===");
        int i = dataPelanggan.size();
        System.out.format("Data ke-%d : \n", (i + 1));
        inputData();
        dataPelanggan.add(dataInput.namaPelanggan);
        dataPelangganUsername.add(dataInput.userPelanggan);
        dataPelangganPassword.add(dataInput.passPelanggan);
        dataPelangganAlamat.add(dataInput.alamatPelanggan);
        notification((i + 1), "terinputkan");
    }

    static void editData() throws IOException {
        System.out.println("======Ubah Data Pelanggan=====");
        dataPelanggan();
        if (!dataPelanggan.isEmpty()) {
            System.out.print("Pilih data ke-: ");
            condition.pilihan = Integer.valueOf(dataInput.input.readLine());
            if (choiceCondition()) {
                System.out.print("Pilih bagian ke-: ");
                int bagian = Integer.valueOf(dataInput.input.readLine());
                garisTepiSpace();
                garisTepi();
                switch (bagian) {
                    case 1:
                        dataTo();
                        System.out.print("Nama baru: ");
                        dataInput.namaPelanggan = dataInput.input.readLine();
                        dataPelanggan.set((condition.pilihan - 1), dataInput.namaPelanggan);
                        garisTepiSpace();
                        garisTepi();
                        notification(condition.pilihan, "terubah");
                        break;
                    case 2:
                        dataTo();
                        System.out.print("Username baru: ");
                        dataInput.userPelanggan = dataInput.input.readLine();
                        dataPelangganUsername.set((condition.pilihan - 1), dataInput.userPelanggan);
                        garisTepiSpace();
                        garisTepi();
                        notification(condition.pilihan, "terubah");
                        break;
                    case 3:
                        dataTo();
                        System.out.print("Password baru: ");
                        dataInput.passPelanggan = dataInput.input.readLine();
                        dataPelangganPassword.set((condition.pilihan - 1), dataInput.passPelanggan);
                        garisTepiSpace();
                        garisTepi();
                        notification(condition.pilihan, "terubah");
                        break;
                    case 4:
                        dataTo();
                        System.out.print("Alamat baru: ");
                        dataInput.alamatPelanggan = dataInput.input.readLine();
                        dataPelangganAlamat.set((condition.pilihan - 1), dataInput.alamatPelanggan);
                        garisTepiSpace();
                        garisTepi();
                        notification(condition.pilihan, "terubah");
                        break;
                    default:
                        noChoice();
                }
            } else {
                garisTepiSpace();
                garisTepi();
                noChoice();
            }
        }
    }

    static void deleteData() throws IOException {
        System.out.println("=====Hapus Data Pelanggan=====");
        dataPelanggan();
        if (!dataPelanggan.isEmpty()) {
            System.out.print("Pilih data ke-: ");
            condition.pilihan = Integer.valueOf(dataInput.input.readLine());
            garisTepiSpace();
            garisTepi();
            if (choiceCondition()) {
                dataPelanggan.remove(condition.pilihan - 1);
                dataPelangganUsername.remove(condition.pilihan - 1);
                dataPelangganPassword.remove(condition.pilihan - 1);
                dataPelangganAlamat.remove(condition.pilihan - 1);
                notification(condition.pilihan, "terhapus");
            } else {
                noChoice();
            }
        }
    }

    static void formatData() throws IOException {
        garisTepi();
        System.out.print("Tulis kata 'format' untuk melanjutkan ");
        String format = dataInput.input.readLine();
        garisTepiSpace();
        garisTepi();
        if (format.equalsIgnoreCase("format")) {
            dataPelanggan.clear();
            System.out.println("Proses format berhasil");
        } else {
            System.out.println("Proses format tidak berhasil");
        }
    }

    public static void main(String[] args) throws IOException {
        do {
            showMenu();
            garisTepiSpace();
            boolean kondisi1 = true;
            do {
                garisTepi();
                System.out.print("Kembali ke menu? (Y/N) ");
                String pilihan = dataInput.input.readLine();
                if (pilihan.equalsIgnoreCase("y")) {
                    kondisi1 = false;
                } else if (pilihan.equalsIgnoreCase("n")) {
                    garisTepiSpace();
                    System.exit(0);
                }
                garisTepiSpace();
            } while (kondisi1);
        } while (kondisi);
    }
}
