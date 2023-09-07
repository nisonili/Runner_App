package com.nilsel;

import java.util.Random;

public class Kosucu implements Runnable {

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public int getMesafe() {
		return mesafe;
	}

	public void setMesafe(int mesafe) {
		this.mesafe = mesafe;
	}

	public double getSure() {
		return sure;
	}

	private String isim;
	private int mesafe;
	private double sure;
	private long baslangicZamani;

	public Kosucu(String isim, int mesafe) {
		this.isim = isim;
		this.mesafe = mesafe;
		this.sure = 0.0;
	}

	@Override
	public void run() {
		baslangicZamani = System.currentTimeMillis();
		Random random = new Random();

		while (mesafe > 0) {
			int hiz = random.nextInt(5) + 1;
			mesafe -= hiz;
			sure += 0.1;
			try {
				Thread.sleep(100); // 100 milisaniye (0.1 saniye) beklet
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		sure = Math.round(sure * 10.0) / 10.0; // Süreyi 1 ondalık haneli yuvarla
		System.out.println(isim + " yarışı " + sure + " saniyede tamamladı.");
	}
}
