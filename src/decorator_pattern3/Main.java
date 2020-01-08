package decorator_pattern3;

public class Main {
	public static void main(String[] args)
	{
		Window w;
		w = new SimpleWindow();
		w = new VerticalScrollBar(w);
		w = new HorizontalScrollBar(w);
		w = new SingleLine(w);
		w = new MultiLine(w);
		
		w.draw();
	}
}
