import java.util.Scanner; // Mengimpor kelas Scanner dari Java untuk menerima input dari pengguna

// Kelas Buku untuk merepresentasikan data buku
class Buku {
    String isbn; // Nomor ISBN buku
    String judul; // Judul buku
    String penulis; // Nama penulis buku
    int tahunTerbit; // Tahun buku diterbitkan

    // Konstruktor untuk menginisialisasi atribut buku saat objek dibuat
    public Buku(String isbn, String judul, String penulis, int tahunTerbit) {
        this.isbn = isbn; // Menyimpan nilai ISBN ke dalam atribut
        this.judul = judul; // Menyimpan nilai judul ke dalam atribut
        this.penulis = penulis; // Menyimpan nama penulis ke dalam atribut
        this.tahunTerbit = tahunTerbit; // Menyimpan tahun terbit ke dalam atribut
    }

    // Override method toString untuk menampilkan data buku dalam format yang rapi
    @Override
    public String toString() {
        return String.format("ISBN: %s\nJudul: %s\nPenulis: %s\nTahun Terbit: %d",
                isbn, judul, penulis, tahunTerbit); // Mengembalikan string deskriptif buku
    }
}

// Kelas utama untuk menjalankan program pencarian buku
public class PencarianBuku {
    public static void main(String[] args) {
        // Membuat array daftar buku, sudah terurut berdasarkan ISBN
        Buku[] daftarBuku = {
            new Buku("9780071606301", "Java: The Complete Reference", "Herbert Schildt", 2007),
            new Buku("9780132222204", "Effective Java", "Joshua Bloch", 2008),
            new Buku("9780132778046", "Head First Java", "Kathy Sierra & Bert Bates", 2005),
            new Buku("9780134685991", "Effective Python", "Brett Slatkin", 2019),
            new Buku("9780135957059", "Clean Code", "Robert C. Martin", 2008),
            new Buku("9780137081073", "The Clean Coder", "Robert C. Martin", 2011),
            new Buku("9780262033848", "Introduction to Algorithms", "Cormen, Leiserson, Rivest & Stein", 2009),
            new Buku("9780321356680", "Effective Java", "Joshua Bloch", 2008),
            new Buku("9780596009205", "Head First Design Patterns", "Eric Freeman & Elisabeth Robson", 2004)
        };

        Scanner scanner = new Scanner(System.in); // Membuat objek Scanner untuk membaca input dari keyboard

        System.out.println("=== SISTEM PENCARIAN BUKU PERPUSTAKAAN ==="); // Menampilkan judul program
        System.out.print("Masukkan nomor ISBN buku yang dicari: "); // Meminta pengguna memasukkan ISBN
        String isbnCari = scanner.nextLine(); // Membaca input ISBN dari pengguna dan menyimpannya ke variabel

        // Melakukan pencarian menggunakan binary search
        int index = cariBukuByISBN(daftarBuku, isbnCari); // Menyimpan hasil pencarian (indeks buku)

        System.out.println("\nHASIL PENCARIAN:"); // Menampilkan hasil pencarian
        if (index != -1) { // Jika buku ditemukan
            System.out.println("Buku ditemukan!"); // Menampilkan pesan bahwa buku ditemukan
            System.out.println(daftarBuku[index]); // Menampilkan detail buku menggunakan toString()
        } else {
            System.out.println("Buku dengan ISBN " + isbnCari + " tidak ditemukan."); // Jika tidak ditemukan
        }

        scanner.close(); // Menutup scanner untuk menghindari memory leak
    }

    // Metode untuk mencari buku berdasarkan ISBN dengan algoritma binary search
    public static int cariBukuByISBN(Buku[] daftarBuku, String isbn) {
        int low = 0; // Indeks bawah pencarian
        int high = daftarBuku.length - 1; // Indeks atas pencarian

        // Selama batas bawah belum melebihi batas atas
        while (low <= high) {
            int mid = low + (high - low) / 2; // Menghitung indeks tengah

            int comparison = daftarBuku[mid].isbn.compareTo(isbn); // Membandingkan ISBN di tengah dengan ISBN yang dicari

            if (comparison == 0) {
                return mid; // Jika ISBN cocok, kembalikan indeks
            }

            if (comparison > 0) {
                high = mid - 1; // ISBN target lebih kecil, geser ke kiri
            } else {
                low = mid + 1; // ISBN target lebih besar, geser ke kanan
            }
        }

        return -1; // Jika tidak ditemukan, kembalikan -1
    }
}
