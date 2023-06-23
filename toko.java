import java.util.Scanner; //agar bisa di input

public class TokoSembako {
    public static void main(String[] args) { 
        Scanner input = new Scanner(System.in);//menerima input dr pengguna
        //deklrasi array
        String[] namaBarang = new String[100]; //dg jumlah maks 100
        int[] hargaBarang = new int[100];
        int[] stokBarang = new int[100];
        String[] riwayatTransaksi = new String[100];
        //deklarasi variabel
        int jumlahBarang = 0;
        int jumlahTransaksi = 0;

        int pilihan;
        do { //loop untuk menampilkan menu 
            System.out.println("=============TOKO SEMBAKO AL-HIKMAH===============");
            System.out.println("              1. Tambah Barang                    ");
            System.out.println("              2. Beli Barang                      ");
            System.out.println("              3. Lihat Stok Barang                ");
            System.out.println("              4. Lihat Riwayat Transaksi          ");
            System.out.println("              5. Keluar                           ");
            System.out.println("==================================================");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt(); //menyimpan pilihan yg dimasukkan oleh pengguna

            //Menentukan perintah berdasarkan kode yang dimasukkan
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama barang: ");
                    input.nextLine();
                    String nama = input.nextLine();
                    System.out.print("Masukkan harga barang: ");
                    int harga = input.nextInt();
                    System.out.print("Masukkan stok barang: ");
                    int stok = input.nextInt();

                    namaBarang[jumlahBarang] = nama; //akan disimpan pd array jml barang dst
                    hargaBarang[jumlahBarang] = harga;
                    stokBarang[jumlahBarang] = stok;
                    jumlahBarang++;

                    System.out.println("Barang berhasil ditambahkan!\n");//menampilkan
                    break;

                case 2:
                    if (jumlahBarang == 0) {
                        System.out.println("Belum ada barang yang tersedia.\n"); //program akan kembali ke awal loop menu
                        break;
                    }

                    System.out.println("=======DAFTAR BARANG=======");
                    for (int i = 0; i < jumlahBarang; i++) {
                        System.out.println((i + 1) + ". " + namaBarang[i] + stokBarang[i] + " - pcs" + stokBarang[i] + " - Rp" + hargaBarang[i]);
                    }
                    System.out.print("Pilih nomor barang yang akan dibeli: ");
                    int nomorBarang = input.nextInt();
                    if (nomorBarang < 1 || nomorBarang > jumlahBarang) {
                        System.out.println("Nomor barang tidak valid.\n");
                        break;
                    }

                    int indeksBarang = nomorBarang - 1; //akses elemen array
                    if (stokBarang[indeksBarang] == 0) {
                        System.out.println("Stok barang habis.\n");
                        break;
                    }

                    System.out.print("Masukkan jumlah barang yang akan dibeli: ");
                    int jumlahBeli = input.nextInt();
                    if (jumlahBeli > stokBarang[indeksBarang]) {
                        System.out.println("Jumlah barang melebihi stok yang tersedia.\n");
                        break;
                    }
                    //menghitung total harga
                    int totalHarga = hargaBarang[indeksBarang] * jumlahBeli;
                    stokBarang[indeksBarang] -= jumlahBeli;
                    //simpan infromasi transaksi
                    String transaksi = namaBarang[indeksBarang] + " - " + jumlahBeli + " pcs - Rp" + totalHarga;
                    riwayatTransaksi[jumlahTransaksi] = transaksi;
                    jumlahTransaksi++;

                    System.out.println("Barang berhasil dibeli!\n");
                    break;

                case 3:
                    System.out.println("======STOK BARANG======");
                    for (int i = 0; i < jumlahBarang; i++) {
                        System.out.println((i + 1) + "."+ namaBarang[i] + " - " + stokBarang[i] + " pcs"+ " - Rp" + hargaBarang[i]);
                    }
                    System.out.println();
                    break;

                case 4:
                    System.out.println("=======RIWAYAT TRANSAKSI========");
                    for (int i = 0; i < jumlahTransaksi; i++) {
                        System.out.println(riwayatTransaksi[i]);

                    }
                    
                    System.out.println();
                    break;
                //menampilkan dan keluar dr loop do while
                case 5:
                    System.out.println("Terima kasih:)");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.\n");
                    break;
            }
        } while (pilihan != 5); //tdk sama dengan 

        input.close();
    }
}