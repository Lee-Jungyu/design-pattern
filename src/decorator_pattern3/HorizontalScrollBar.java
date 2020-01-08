package decorator_pattern3;

public class HorizontalScrollBar extends WindowDecorator{
	public HorizontalScrollBar(Window w)
	{
		super(w);
	}
	public void draw()
	{
		super.draw();
		System.out.println("draw horizontal scroll bar");
	}
}
