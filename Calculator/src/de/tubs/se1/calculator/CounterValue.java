package de.tubs.se1.calculator;

import javafx.application.Platform;

public class CounterValue extends Value implements Runnable {

	Calculator calculator;

	public CounterValue(Calculator calculator) {
		super(0);
		this.calculator = calculator;
		new Thread(this).start();
	}

	@Override
	public void run() {
		while (value < 10) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			value++;
			Logger.getLogger().log("Counter increased to " + value);
			Platform.runLater(new Runnable() {
				public void run() {
					calculator.updateGUI();
				}
			});
		}
	}
	
}
