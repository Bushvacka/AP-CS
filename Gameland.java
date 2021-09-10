import java.awt.Color;
import java.util.Random;
//Troy Dutton
//Play a dice-based board game
//12/2/19

import gpdraw.DrawingTool;
import gpdraw.SketchPad;

public class GameLand {
	SketchPad poster;
	DrawingTool pen;
	int w = 1000, h = 1000, dice1, dice2, sum, p1 = 0, p2 = 0;
	int[] x_squares = new int[102], y_squares = new int[102];
	Color red = new Color(200, 0, 0);
	Color blue = new Color(0, 200, 0);
	Color white = new Color(255, 255, 255);
	Color black = new Color(0, 0, 0);
	Color l_blue = new Color(173, 216, 230);
	boolean done = false, turn = true;
	Random rand = new Random();

	public GameLand() {
		poster = new SketchPad(w, h, 0);
		pen = new DrawingTool(poster);
		gameLoop();
	}

	private void gameLoop() {
		while (!done) {
			drawBoard();
			drawPlayers();
			gameLogic();
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
			}
			clearScreen();
		}
		pen.up();
		pen.move(0, 0);
		pen.down();
		if (p1 == 101) {
			pen.drawString("P1 Win!");
		}
		else {
			pen.drawString("P2 Win!");
		}
	}

	private void gameLogic() {
		if (turn) {
			dice1 = rand.nextInt(6) + 1;
			dice2 = rand.nextInt(6) + 1;
			sum = dice1 + dice2;
			if (sum != 2 && sum != 12) {
				if (sum == 7) {
					p1 -= sum;
					if (p1 < 0) {
						p1 = 0;
					}
				} else {
					p1 += sum;
				}
				if (p1 == p2) {
					p2 = 0;
				}
			}
			drawDice(dice1, dice2);
			turn = false;
			if (p1 > 101) {
				p1 = 101;
				done = true;
			}
		} else {
			dice1 = rand.nextInt(6) + 1;
			dice2 = rand.nextInt(6) + 1;
			sum = dice1 + dice2;
			if (sum != 2 && sum != 12) {
				if (sum == 7) {
					p2 -= sum;
					if (p2 < 0) {
						p2 = 0;
					}
				} else {
					p2 += sum;
				}
				if (p1 == p2) {
					p1 = 0;
				}
			}
			drawDice(dice1, dice2);
			turn = true;
			if (p2 > 101) {
				p2 = 101;
				done = true;
			}
		}
	}

	private void drawDice(int d1, int d2) {
		pen.setColor(black);
		pen.up();
		pen.move(-70, 0);
		pen.down();
		pen.drawRect(60, 60);
		switch (d1) {
		case 1:
			pen.fillCircle(5);
			break;
		case 2:
			pen.up();
			pen.move(-85, 15);
			pen.down();
			pen.fillCircle(5);
			pen.up();
			pen.move(-55, -15);
			pen.down();
			pen.fillCircle(5);
			break;
		case 3:
			pen.fillCircle(5);
			pen.up();
			pen.move(-85, 15);
			pen.down();
			pen.fillCircle(5);
			pen.up();
			pen.move(-55, -15);
			pen.down();
			pen.fillCircle(5);
			break;
		case 4:
			pen.up();
			pen.move(-85, 15);
			pen.down();
			pen.fillCircle(5);
			pen.up();
			pen.move(-85, -15);
			pen.down();
			pen.fillCircle(5);
			pen.up();
			pen.move(-55, 15);
			pen.down();
			pen.fillCircle(5);
			pen.up();
			pen.move(-55, -15);
			pen.down();
			pen.fillCircle(5);
			break;
		case 5:
			pen.fillCircle(5);
			pen.up();
			pen.move(-85, 15);
			pen.down();
			pen.fillCircle(5);
			pen.up();
			pen.move(-85, -15);
			pen.down();
			pen.fillCircle(5);
			pen.up();
			pen.move(-55, 15);
			pen.down();
			pen.fillCircle(5);
			pen.up();
			pen.move(-55, -15);
			pen.down();
			pen.fillCircle(5);
			break;
		case 6:
			pen.up();
			pen.move(-85, 15);
			pen.down();
			pen.fillCircle(5);
			pen.up();
			pen.move(-85, -15);
			pen.down();
			pen.fillCircle(5);
			pen.up();
			pen.move(-55, 15);
			pen.down();
			pen.fillCircle(5);
			pen.up();
			pen.move(-55, -15);
			pen.down();
			pen.fillCircle(5);
			pen.up();
			pen.move(-85, 0);
			pen.down();
			pen.fillCircle(5);
			pen.up();
			pen.move(-55, 0);
			pen.down();
			pen.fillCircle(5);
		}
		pen.up();
		pen.move(70, 0);
		pen.down();
		pen.drawRect(60, 60);
		switch (d2) {
		case 1:
			pen.fillCircle(5);
			break;
		case 2:
			pen.up();
			pen.move(55, 15);
			pen.down();
			pen.fillCircle(5);
			pen.up();
			pen.move(85, -15);
			pen.down();
			pen.fillCircle(5);
			break;
		case 3:
			pen.fillCircle(5);
			pen.up();
			pen.move(55, 15);
			pen.down();
			pen.fillCircle(5);
			pen.up();
			pen.move(85, -15);
			pen.down();
			pen.fillCircle(5);
			break;
		case 4:
			pen.up();
			pen.move(55, 15);
			pen.down();
			pen.fillCircle(5);
			pen.up();
			pen.move(55, -15);
			pen.down();
			pen.fillCircle(5);
			pen.up();
			pen.move(85, 15);
			pen.down();
			pen.fillCircle(5);
			pen.up();
			pen.move(85, -15);
			pen.down();
			pen.fillCircle(5);
			break;
		case 5:
			pen.fillCircle(5);
			pen.up();
			pen.move(55, 15);
			pen.down();
			pen.fillCircle(5);
			pen.up();
			pen.move(55, -15);
			pen.down();
			pen.fillCircle(5);
			pen.up();
			pen.move(85, 15);
			pen.down();
			pen.fillCircle(5);
			pen.up();
			pen.move(85, -15);
			pen.down();
			pen.fillCircle(5);
			break;
		case 6:
			pen.up();
			pen.move(55, 15);
			pen.down();
			pen.fillCircle(5);
			pen.up();
			pen.move(55, -15);
			pen.down();
			pen.fillCircle(5);
			pen.up();
			pen.move(85, 15);
			pen.down();
			pen.fillCircle(5);
			pen.up();
			pen.move(85, -15);
			pen.down();
			pen.fillCircle(5);
			pen.up();
			pen.move(55, 0);
			pen.down();
			pen.fillCircle(5);
			pen.up();
			pen.move(85, 0);
			pen.down();
			pen.fillCircle(5);
		}
	}

	private void drawPlayers() {
		pen.setColor(red);
		pen.up();
		pen.move(x_squares[p1], y_squares[p1]);
		pen.down();
		pen.fillCircle(10);
		pen.setColor(blue);
		pen.up();
		pen.move(x_squares[p2], y_squares[p2]);
		pen.down();
		pen.fillCircle(10);
	}

	private void drawBoard() {
		pen.setColor(black);
		pen.up();
		pen.move(-w / 2.5, h / 2.5);
		pen.down();
		pen.setDirection(90);
		for (int square = 0; square < 102; square++) {
			double orientation = pen.getDirection();
			x_squares[square] = (int) pen.getXPos();
			y_squares[square] = (int) pen.getYPos();
			pen.setColor(l_blue);
			pen.fillRect(30, 30);
			pen.setColor(black);
			pen.drawRect(30, 30);
			if (square == 0) {
				pen.up();
				pen.move(pen.getXPos() - 12, pen.getYPos());
				pen.down();
				pen.drawString("Start");
				pen.up();
				pen.move(pen.getXPos() + 12, pen.getYPos());
				pen.down();
				pen.setDirection(orientation);
			} else if (square == 101) {
				pen.up();
				pen.move(pen.getXPos() - 15, pen.getYPos());
				pen.down();
				pen.drawString("Finish");
				pen.up();
				pen.move(pen.getXPos() + 15, pen.getYPos());
				pen.down();
				pen.setDirection(orientation);
			} else {
				pen.up();
				pen.move(pen.getXPos() - (square / 100.0) * 10, pen.getYPos());
				pen.down();
				pen.drawString(Integer.toString(square));
				pen.up();
				pen.move(pen.getXPos() + (square / 100.0) * 10, pen.getYPos());
				pen.down();
				pen.setDirection(orientation);
			}
			if (square % 26 == 0) {
				pen.turnRight(90);
				pen.up();
				pen.forward(30);
				pen.down();
			} else {
				pen.up();
				pen.forward(30);
				pen.down();
			}
		}
	}

	private void clearScreen() {
		pen.setColor(white);
		pen.move(0, 0);
		pen.fillRect(w, h);
		pen.setColor(black);
	}
}
