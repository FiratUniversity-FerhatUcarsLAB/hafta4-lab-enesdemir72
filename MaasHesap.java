/*
 * Ad Soyad: [Hüseyin Enes Demir]
 * Ogrenci No: [250541047]
 * Tarih: [05.11.2025]
 * Aciklama: Gorev 3 - Maas Hesaplama Sistemi
 */

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MaasHesap {
    public static void main(String[] args) {
        // Sabitler
        final double SGK_RATE = 0.14;        // %14
        final double INCOME_TAX_RATE = 0.15; // %15
        final double STAMP_TAX_RATE = 0.00759; // %0.759
        final double OVERTIME_MULTIPLIER = 1.5;
        final double STANDARD_MONTHLY_HOURS = 160.0; // verilen sabit

        Scanner input = new Scanner(System.in);

        System.out.println("=== MAAS HESAPLAMA SISTEMI ===\n");

        System.out.print("Calisan adi soyadi: ");
        String fullName = input.nextLine();

        System.out.print("Brut maas (TL): ");
        double brutMaas = input.nextDouble();

        System.out.print("Haftalik calisma saati: ");
        int weeklyHours = input.nextInt();

        System.out.print("Mesai saati sayisi: ");
        int overtimeHours = input.nextInt();

        // Hesaplamalar
        double hourlyRate = brutMaas / STANDARD_MONTHLY_HOURS; // Brüt saatlik
        double overtimePay = hourlyRate * overtimeHours * OVERTIME_MULTIPLIER;
        double totalIncome = brutMaas + overtimePay;

        double sgkKesinti = totalIncome * SGK_RATE;
        double gelirVergisi = totalIncome * INCOME_TAX_RATE;
        double damgaVergisi = totalIncome * STAMP_TAX_RATE;

        double totalDeductions = sgkKesinti + gelirVergisi + damgaVergisi;
        double netMaas = totalIncome - totalDeductions;

        // Istatistikler
        double deductionRate = (totalDeductions / totalIncome); // oran (0..1)
        // Aylik calisma saati varsayimi: haftalik saat -> günlük = haftalik/5, aylık = 22 işgünü * günlük
        double monthlyWorkHours = weeklyHours * (22.0 / 5.0);
        double hourlyNetEarning = netMaas / monthlyWorkHours;
        double dailyNetEarning = netMaas / 22.0;

        // Tarih
        LocalDate today = LocalDate.now();
        String formattedDate = today.format(DateTimeFormatter.ofPattern("dd MMMM yyyy"));

        // Bordro yazdirma
        System.out.println("\n====================================");
        System.out.println("         MAAS BORDROSU");
        System.out.println("====================================");
        System.out.printf("Calisan: %s%n", fullName);
        System.out.printf("Tarih  : %s%n%n", formattedDate);

        System.out.println("GELIRLER:");
        System.out.printf("  %-24s: %10.2f TL%n", "Brut Maas", brutMaas);
        System.out.printf("  %-24s: %10.2f TL%n", "Mesai Ucreti (" + overtimeHours + " saat)", overtimePay);
        System.out.println("  ------------------------");
        System.out.printf("  %-24s: %10.2f TL%n%n", "TOPLAM GELIR", totalIncome);

        System.out.println("KESINTILER:");
        System.out.printf("  %-24s: %10.2f TL%n", String.format("SGK Kesintisi (%.1f%%)", SGK_RATE * 100), sgkKesinti);
        System.out.printf("  %-24s: %10.2f TL%n", String.format("Gelir Vergisi (%.1f%%)", INCOME_TAX_RATE * 100), gelirVergisi);
        // Damga vergi yuzde gosterimi 1 ondalik istendiginden 0.8% gibi yaziliyor (0.759 -> 0.8 yuvarlanmis gorunebilir)
        System.out.printf("  %-24s: %10.2f TL%n", String.format("Damga Vergisi (%.1f%%)", STAMP_TAX_RATE * 100), damgaVergisi);
        System.out.println("  ------------------------");
        System.out.printf("  %-24s: %10.2f TL%n%n", "TOPLAM KESINTI", totalDeductions);

        System.out.printf("%-28s: %10.2f TL%n%n", "NET MAAS", netMaas);

        System.out.println("ISTATISTIKLER:");
        System.out.printf("  %-24s: %6.1f%%%n", "Kesinti Orani", deductionRate * 100);
        System.out.printf("  %-24s: %10.2f TL/saat%n", "Saatlik Net Kazanc", hourlyNetEarning);
        System.out.printf("  %-24s: %10.2f TL/gun%n", "Gunluk Net Kazanc", dailyNetEarning);

        System.out.println("====================================");

        input.close();
    }
}

