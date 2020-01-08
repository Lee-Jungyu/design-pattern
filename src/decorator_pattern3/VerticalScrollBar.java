package decorator_pattern3;

public class VerticalScrollBar extends WindowDecorator{
	public VerticalScrollBar(Window w)
	{
		super(w);
	}
	public void draw()
	{
		super.draw();
		System.out.println("draw vertical scroll bar");
	}
}
