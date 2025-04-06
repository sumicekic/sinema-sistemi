# sinema-sistemi
Nesneye Dayalı Programlama dersi için Java ile geliştirilmiştir.

import java.util.Scanner;    

--Scanner sınıfını içe aktararak kullanıcıdan veri almayı hedefledim. Bu şekilde müşteri bilgilerini kullanıcıdan alabileceğim.--



public class Main {

--Tüm kodumu yazacağım ana sınıfı oluşturdum.--



public static void main(String[] args) {

--Programın başlama fonksiyonu, static ile bu metodun sınıfın bir parçası olduğunu ve bir nesne oluşturulmadan çalışabileceğini,String[ ] args ile de komut satırından gelen verileri alabileceğini belirttim.--




 String[] filmAdlari = new String[10];
 int[] filmSureleri = new int[10];
 String[] filmTurleri = new String[10];

--10 tane filmi saklayabilmek için 3 tane dizi oluşturdum, bunları kullanarak filmlerin adını,süresini ve türünü ayrı ayrı saklamak mümkün olacak.--


String[ ] musteriler = new String[20];
String[ ] emailler = new String[20];

--20 tane müşteryii kaydedebilmek için iki tane dizim var. Birisi müşteri adlarını diğeri e posta adreslerini tutacak.--



int[ ][ ] biletler = new int[20][10];

--20 müşteri ve 10 film için bilet bilgilerini saklayacak bir matris kullandım. Satırlar müşterileri, sütunlar filmleri gösteriyor.(tablo yapısı)--



int filmSayisi = 0;
int musteriSayisi = 0;

--Kaç film ve kaç müşteri kaydedildiğini takip etmek için iki sayaç oluşturdum. Yeni biri eklendikçe bunları artıracağım.--



Scanner input = new Scanner(System.in);

--Kullanıcıdan klavye girdisi almak için scanner nesnesiyle oluşturup system.in kullandım.--



 int secim;

--Kullanıcının menüde seçeceği seçeneği saklamak için seçim değişkeni oluşturdum.--



do {
System.out.println("--- Sinema Sistemimize Hoş Geldiniz! ---");
System.out.println("1.Yeni Film Kaydı");
System.out.println("2.Yeni Müşteri Kaydı");
System.out.println("3.Bilet Satışı");
System.out.println("4.Biletleri Görüntüleme");
System.out.println("0.Çıkış Yap");
System.out.print("Seçiminizi Yapın: ");

--do yapısı sayesinde menü sürekli tekrar ediyor, ardından kullanıcının ne yapmak istediğine dair seçenekler ekrana yazdırılıyor.--



secim = input.nextInt();
 input.nextLine();

--kullanıcının seçim yapmasını ve satır boşluğunu temizlemek için bu yapıyı kullandım.(diğer türlü hata alıyoruz.)--




Bundan sonrasını yapısal bloklarla  olarak açıklayacağım, Seçimler için basit if-else döngüsü kullandım ;




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
}

--Bu bloğun amacı, kullanıcı "1" seçeneğini seçtiğinde çalışırarak ve yeni filmi eklemesi. İlk olarak, eğer eklenen film sayısı 10'dan azsa (filmSayisi < 10), kullanıcıdan filmin adını, süresini ve türünü alıyoruz. Bu bilgiler,depoya ekleniyor. filmSayisi++ ile toplam film sayısını bir arttırıyoruz.(sayaç mantığı). Eğer zaten 10 film varsa, kullanıcı "Sadece 10 film bulunmaktadır." mesajını görüyor.--





else if (secim == 2) {
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
}

--Bu blok, kullanıcı "2" seçeneğini seçtiğinde çalışıyor ve yeni müşteriyü kaydediyor. Eğer müşteri sayısı 20'den azsa (musteriSayisi < 20), kullanıcıdan müşteri adı ve e-posta adresi alınır ve bu bilgiler ilgili dizilere eklenir. musteriSayisi++ ile toplam müşteri sayısı bir arttırılır.(sayaç) Eğer 20 müşteri eklenmişse, kullanıcıya "Şimdilik 20 müşteri ağırlayabiliyoruz." mesajı gösteriliyor.--





else if (secim == 3) {
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
}

--Bu blok, kullanıcı "3" seçeneğini seçtiğimizde çalışır ve bilet satışı yapar. Öncelikle kullanıcıdan müşteri numarası ve film numarasını alıyoruz.  Girişlerin geçerli olup olmadığını kontrol etmek için mNo (müşteri numarası yerine kullanılıyor) ve fNo (film numarası yerine kullanılıyor) dizininin sınırlarında olup olmadığına bakılır. Eğer geçerli bir müşteri ve film seçildiyse, müşterinin o filme bilet almdığı varsayılır ve matrisin ilgili hücresine 1 yazılır . Eğer geçerli olmayan bir giriş yapılırsa, kullanıcıya hata mesajı gösteriliyor.--






else if (secim == 4) {
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


--Bu blok, kullanıcı "4" seçeneğini seçtiğinde çalışır ve tüm biletleri görüntüler. İlk olarak, "Tüm Biletler" başlığı yazdırılır. Ardından, her müşteri için bir döngü oluşturulur ve o müşterinin aldığı filmler (yani biletler[i][j] == 1 olan filmler) ekrana yazdırılır. Her film için, filmin adı, süresi ve türü gösterilir. Son olarak, "Tüm biletler başarıyla gösterildi." mesajı ekrana yazdırılır.--




} while (secim != 0);

--Burada while döngüsü kullandım. 0 seçeneği seçilene kadar menüyü sürekli olarak göstermemizi sağlar.(Çıkış için 0'a basılır)--



System.out.println("Tekrar bekleriz. Hoşça kalın!");

--Kullanıcının 0 a basmasıyla beraber veda mesajını yazdırıyoruz.--
