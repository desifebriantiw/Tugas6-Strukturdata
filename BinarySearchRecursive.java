public class BinarySearchRecursive {
    // Metode binary search secara rekursif
    public static int binarySearchRecursive(int[] arr, int target, int low, int high) {
        // Kasus dasar: jika batas bawah melebihi batas atas, target tidak ditemukan
        if (low > high) {
            return -1;
        }
        // Hitung indeks tengah untuk menghindari overflow
        int mid = low + (high - low) / 2;
        // Jika elemen tengah adalah target, kembalikan indeksnya
        if (arr[mid] == target) {
            return mid;
        }
        // Jika elemen tengah lebih besar dari target, cari di setengah kiri
        if (arr[mid] > target) {
            return binarySearchRecursive(arr, target, low, mid - 1);
        }
        // Jika elemen tengah lebih kecil dari target, cari di setengah kanan
        return binarySearchRecursive(arr, target, mid + 1, high);
    }
    // Metode pembungkus (wrapper) untuk memudahkan pemanggilan metode rekursif
    public static int binarySearch(int[] arr, int target) {
        // Memanggil metode rekursif dengan parameter awal low = 0 dan high = panjang array - 1
        return binarySearchRecursive(arr, target, 0, arr.length - 1);
    }
    public static void main(String[] args) {
        // Array yang sudah terurut
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 45, 56, 72, 91};
        // Elemen yang ingin dicari
        int target = 23;
        // Memanggil metode binarySearch dan menyimpan hasilnya di variabel result
        int result = binarySearch(arr, target);
        // Menampilkan hasil pencarian
        if (result == -1) {
            System.out.println("Elemen " + target + " tidak ditemukan dalam array");
        } else {
            System.out.println("Elemen " + target + " ditemukan pada indeks " + result);
        }
    }  
}
