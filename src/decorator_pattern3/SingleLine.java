package decorator_pattern3;

public class SingleLine extends WindowDecorator{
	public SingleLine(Window w)
	{
		super(w);
	}
	public void draw()
	{
		super.draw();
		System.out.println("draw single line");
	}
}
