/*
 * Ad Soyad: [Hüseyin Enes Demir]
 * Ogrenci No: [250541047]
 * Tarih: [4.11.2025]
 * Aciklama: Gorev 1 - Ogrenci Bilgi Sistemi
 * 
 * Bu program kullanicidan ogrenci bilgilerini alir ve
 * duzenli bir formatta ekrana yazdirir.
 * Diğer java dosyalarının başında da bu örnek formattaki gibi kısa bilgi giriniz
 */

import java.util.Scanner;

public class OgrenciBilgi {
    public static void main(String[] args) {
        // Scanner objesi olusturun
        Scanner input = new Scanner(System.in);

        
        // Degisken tanimlamalari
        // String ad, soyad;
        // int ogrenciNo, yas;
        // double gpa;
         String ad_soyad ;
        int ogrenci_no ;
        int yas ;
        double gpa ;
        boolean bk;
        
        // Kullanicidan bilgileri alin
        System.out.println("=== OGRENCI BILGI SISTEMI ===");
        System.out.println();
        
        // Ad   // Soyad
        System.out.print("Adinizi Soyadinizi Giriniz: ");
        ad_soyad =input.nextLine();
        
      
        // Ogrenci No
         System.out.print("Öğrenci No Giriniz: ");
        ogrenci_no =input.nextInt();
        
        // Yas
        System.out.print("Yaş Giriniz: ");
        yas =input.nextInt();
        
        // GPA
        System.out.print("GPA Giriniz: ");
        gpa =input.nextDouble();
        
        
        // Bilgileri ekrana yazdirin
        System.out.println("\n=== OGRENCI BILGI SISTEMI ===");
        
        // COZUMUNUZU BURAYA YAZIN
        
         if(gpa<0 || gpa>4 ){
          System.out.print("Gpa 0 4 aralığında olmalıdır");
      }
      else{
                  System.out.println("----------------");
        System.out.println("Adı: "+ad_soyad);
        System.out.println("Öğrenci No "+ogrenci_no);
        System.out.println("Yaşınız: "+yas);
        System.out.printf("Not Ortalamnız  : %.2f\n",gpa);
     
     if( gpa>2 ){
          System.out.print(" Basarili oğrenci ");
      }
     
      
      
      
   
    }
   
        // Scanner'i kapatin (önemli pratik)
        scanner.close();
    
        
        
        

        
     
    }
}
