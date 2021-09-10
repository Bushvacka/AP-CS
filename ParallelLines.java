import gpdraw.DrawingTool;
import gpdraw.SketchPad;

//Troy Dutton
//Create an optical illusion using parallel lines
//11/22/19
public class ParallelLines {
	SketchPad poster;
	DrawingTool pen;
	int offset;
	boolean backwards;

	public ParallelLines() {
		poster = new SketchPad(800, 600);
		pen = new DrawingTool(poster);
		drawIllusion();
	}

	private void drawIllusion() {
		int y, x = poster.getWidth() / -2 + 20;
		offset = 0;
		backwards = false;
		for (int row = 0; row < 8; row++) {
			y = (poster.getHeight() / 2 - 50 * row) - 150;
			pen.up();
			pen.move(x, y);
			pen.down();
			pen.move(x + 700, y);
			pen.up();
			pen.move(x, y);
			pen.down();
			System.out.println("Row " + row + ": " + offset);
			for (int col = 0; col < 7; col++) {
				pen.up();
				pen.move(x + 25 + col * 100 + offset, y + 25);
				pen.down();
				pen.fillRect(50, 50);
			}
			if (offset < 30 && !backwards) {
				offset += 15;
			} else if (offset == 30) {
				backwards = true;
			}
			if (offset > 0 && backwards) {
				offset -= 15;
			} else if (offset == 0) {
				backwards = false;
				offset += 15;
			}
		}
	}
}
