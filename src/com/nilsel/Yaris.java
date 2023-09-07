package com.nilsel;

import java.util.ArrayList;
import java.util.List;

public class Yaris {

	public static void main(String[] args) {

		List<Kosucu> kosucular = new ArrayList<>();
		String[] kosucuIsimleri = { "Koşucu 1", "Koşucu 2", "Koşucu 3", "Koşucu 4", "Koşucu 5", "Koşucu 6", "Koşucu 7",
				"Koşucu 8", "Koşucu 9", "Koşucu 10" };

		for (String isim : kosucuIsimleri) {
			Kosucu kosucu = new Kosucu(isim, 100);
			kosucular.add(kosucu);
			Thread thread = new Thread(kosucu);
			thread.start();
		}

		for (Kosucu kosucu : kosucular) {
			try {
				Thread.sleep(1000); // 1 saniye beklet
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		System.out.println("Yarış sonu sıralama ve süreler:");
		kosucular.sort((k1, k2) -> Double.compare(k1.getSure(), k2.getSure()));
		int sira = 1;
		for (Kosucu kosucu : kosucular) {
			System.out.println(sira + ". " + kosucu.getIsim() + " - " + kosucu.getSure() + " saniye");
			sira++;
		}

	}
}
