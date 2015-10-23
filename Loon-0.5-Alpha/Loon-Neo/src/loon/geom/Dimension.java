package loon.geom;

public class Dimension {

	public float width = -1, height = -1;

	private Matrix4 matrix4;

	private RectBox rect;

	private boolean dirty = false;

	public Dimension() {
		this(-1, -1);
	}

	public Dimension(float w, float h) {
		width = w;
		height = h;
		dirty = true;
	}

	public Dimension(Dimension d) {
		width = d.getWidth();
		height = d.getHeight();
		dirty = true;
	}

	public RectBox getRect() {
		if (rect == null) {
			rect = new RectBox(0, 0, width, height);
		} else {
			rect.setBounds(0, 0, width, height);
		}
		return rect;
	}

	public Matrix4 getMatrix() {
		if (dirty) {
			if (matrix4 == null) {
				matrix4 = new Matrix4();
			}
			matrix4.setToOrtho2D(0, 0, width, height);
			dirty = false;
		}
		return matrix4;
	}

	public boolean isDirty() {
		return dirty;
	}

	public boolean contains(int x, int y) {
		return x >= 0 && x < width && y >= 0 && y < height;
	}

	public float height() {
		return height;
	}

	public float width() {
		return width;
	}

	public int getHeight() {
		return (int) height;
	}

	public int getWidth() {
		return (int) width;
	}

	public String toString() {
		return "(" + width + ", " + height + ")";
	}

	public void setWidth(int width) {
		this.width = width;
		this.dirty = true;
	}

	public void setSize(int width, int height) {
		this.width = width;
		this.height = height;
		this.dirty = true;
	}

	public void setSize(Dimension d) {
		this.width = d.getWidth();
		this.height = d.getHeight();
		this.dirty = true;
	}

	public void setHeight(int height) {
		this.height = height;
		this.dirty = true;
	}

	public Dimension cpy() {
		return new Dimension(width, height);
	}
}