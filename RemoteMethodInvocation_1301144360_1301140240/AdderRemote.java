
import java.rmi.*;
import java.rmi.server.*;

public class AdderRemote extends UnicastRemoteObject implements Adder {

    AdderRemote() throws RemoteException {
        super();
    }

    @Override
    public long tambah(int x, int y) {
//        int di java batasnya (2^31)-1
//        kalau x dan y nilainya (2^31)-1
//        penjumlahan x dan y adalah 2x((2^31)-1) = (2^32)-2
//        (2^32)-2 lebih dari batas integer, jadinya return value fungsi ini bertipe long
//        tipe long memiliki batasan sampai (2^63)-1
        return (long) x + y;
    }

    @Override
    public int kurang(int x, int y) throws RemoteException {
//        int di java batasnya (2^31)-1
//        kalau nilai x adalah (2^31)-1 dan nilai y adalah 0
//        pengurangan x dan y adalah (2^31)-1
//        (2^31)-1 masih dalam batasan int
        return x - y;
    }

    @Override
    public String bagi(int x, int y) throws RemoteException {
//        pembagian dua buah bilangan biasanya akan menghasilkan bilangan desimal
//        ada 2 tipe data untuk menampung bilangan desimal, yaitu float dan double
//        tipe data float merepresentasikan 32 bit dengan 1 sign bit, 8 bit untuk exponen, dan 23 bit untuk significant
//        tipe data double merepresentasikan 64 bit dengan 1 sign bit, 11 bit untuk exponen, dan 52 bit untuk significant      
//        masalah pada pembagian adalah jika nilai y bernilai 0 dan juga x dan y bernilai 0
        if (y != 0) {
            double hasilbagi = (float) x / (float) y;
            return String.valueOf(hasilbagi);
        } else {
            if (x == 0) {
                return "Tak Terdefinisi";
            } else {
                return "Tak Terhingga";
            }
        }
    }

    @Override
    public long kali(int x, int y) throws RemoteException {
//        int di java batasnya (2^31)-1
//        kalau x dan y nilainya (2^31)-1
//        perkalian x dan y adalah ((2^31)-1)^2 = (2^62)-(2^32)+1
//        (2^62)-(2^32)+1 lebih dari batas integer, jadinya return value fungsi ini bertipe long
//        tipe long memiliki batasan sampai (2^63)-1
        return (long) x * y;
    }

}
