package decorator_pattern3;

public class MultiLine extends WindowDecorator{
	public MultiLine(Window w)
	{
		super(w);
	}
	public void draw()
	{
		super.draw();
		System.out.println("draw multi line");
	}
}
