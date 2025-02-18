package fouriertransform.utils;

import java.awt.Color;
import java.awt.Graphics2D;

import fouriertransform.frame.Frame;

/**
 * @author Fabian
 */

public class Cycle {

	public double offsetX;
	public double offsetY;

	public double freq;
	public double amp;
	public double phase;

	public double rotation;

	public Cycle child;

	public Cycle(double offsetX, double offsetY, double freq, double amp, double phase, double rotation) {
		this.offsetX = offsetX;
		this.offsetY = offsetY;

		this.freq = freq;
		this.amp = amp;
		this.phase = phase;

		this.rotation = rotation;
	}

	public Cycle(double freq, double amp, double phase, double rotation) {
		this.freq = freq;
		this.amp = amp;
		this.phase = phase;

		this.rotation = rotation;
	}

	public void addCycle(Cycle cycle) {
		this.child = cycle;
	}

	public void drawCycle(Graphics2D g2D, double xVal) {
		Cycle cycle = this;
		double posX = offsetX;
		double posY = offsetY;
		do {
			g2D.setColor(Color.BLACK);
			double radius = cycle.amp * 300;
			g2D.setColor(new Color(0, 0, 0, 100));
			g2D.drawOval((int) posX - (int) radius, (int) posY - (int) radius, (int) radius * 2, (int) radius * 2);
			double angle = (xVal * cycle.freq) + cycle.phase + cycle.rotation;
			double x = radius * Math.cos(angle);
			double y = radius * Math.sin(angle);
			g2D.setColor(Color.BLACK);
			g2D.drawLine((int) posX, (int) posY, (int) (x + posX), (int) (y + posY));

			posX += x;
			posY += y;
		} while ((cycle = cycle.child) != null);

		Frame.valuesX.add(posX);
		Frame.valuesY.add(posY);
		if (Frame.valuesX.size() > Frame.cycleSize) {
			Frame.valuesX.remove(0);
		}
		if (Frame.valuesY.size() > Frame.cycleSize) {
			Frame.valuesY.remove(0);
		}
	}
}
