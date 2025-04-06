import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] filmAdlari = new String[10];
        int[] filmSureleri = new int[10];
        String[] filmTurleri = new String[10];

        String[] musteriler = new String[20];
        String[] emailler = new String[20];

        int[][] biletler = new int[20][10];

        int filmSayisi = 0;
        int musteriSayisi = 0;

        Scanner input = new Scanner(System.in);
        int secim;

        do {
            System.out.println("--- Sinema Sistemimize Hoş Geldiniz! ---");
            System.out.println("1.Yeni Film Kaydı");
            System.out.println("2.Yeni Müşteri Kaydı");
            System.out.println("3.Bilet Satışı");
            System.out.println("4.Biletleri Görüntüleme");
            System.out.println("0.Çıkış Yap");
            System.out.print("Seçiminizi Yapın: ");
            secim = input.nextInt();
            input.nextLine();

            if (secim == 1) {
                if (filmSayisi < 10) {
                    System.out.print("Film adı: ");
                    filmAdlari[filmSayisi] = input.nextLine();
                    System.out.print("Film süresi (dakika olarak girin.): ");
                    filmSureleri[filmSayisi] = input.nextInt();
                    input.nextLine();
                    System.out.print("Film türü: ");
                    filmTurleri[filmSayisi] = input.nextLine();
                    System.out.println("Film başarıyla eklenmiştir!");
                    filmSayisi++;
                } else {
                    System.out.println("Üzgünüz, sadece 10 film bulunmaktadır.");
                }
            } else if (secim == 2) {
                if (musteriSayisi < 20) {
                    System.out.print("Müşteri adı: ");
                    musteriler[musteriSayisi] = input.nextLine();
                    System.out.print("Email adresi: ");
                    emailler[musteriSayisi] = input.nextLine();
                    System.out.println("Yeni bir müşteri başarıyla kaydedild! Hoş geldiniz, " + musteriler[musteriSayisi] + "!");
                    musteriSayisi++;
                } else {
                    System.out.println("Üzgünüz, şimdilik 20 müşteri ağırlayabiliyoruz.");
                }
            } else if (secim == 3) {
                System.out.print("Müşteri numarası (0-" + (musteriSayisi - 1) + "): ");
                int mNo = input.nextInt();
                System.out.print("Film numarası (0-" + (filmSayisi - 1) + "): ");
                int fNo = input.nextInt();

                if (mNo >= 0 && mNo < musteriSayisi && fNo >= 0 && fNo < filmSayisi) {
                    biletler[mNo][fNo] = 1;
                    System.out.println("Harika! " + musteriler[mNo] + " için " + filmAdlari[fNo] + " Bilet satışı başarılı! ");
                } else {
                    System.out.println("Hatalı giriş, Lütfen tekrar deneyin!");
                }
            } else if (secim == 4) {
                System.out.println("\nTüm Biletler:");
                for (int i = 0; i < musteriSayisi; i++) {
                    System.out.println("\nMüşteri: " + musteriler[i] + " (Email: " + emailler[i] + ")");
                    System.out.println("Seçtiği Filmler:");
                    for (int j = 0; j < filmSayisi; j++) {
                        if (biletler[i][j] == 1) {
                            System.out.println("- " + filmAdlari[j] + " (" + filmSureleri[j] + " dk, Tür: " + filmTurleri[j] + ")");
                        }
                    }
                }
                System.out.println("\nTüm biletler başarıyla gösterildi.");
            }
        } while (secim != 0);

        System.out.println("Tekrar bekleriz. Hoşça kalın!");
    }
}
