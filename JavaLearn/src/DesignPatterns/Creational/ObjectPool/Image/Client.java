package DesignPatterns.Creational.ObjectPool.Image;


public class Client {

	public static final ObjectPool<Bitmap> bitmapPool = new ObjectPool<>(()->new Bitmap("Logo.bmp"), 5);
	
    public static void main(String[] args) {
    	Bitmap b1 = bitmapPool.get();
    	b1.setLocation(new Point2D(10, 10));
    	Bitmap b2 = bitmapPool.get();
    	b2.setLocation(new Point2D(-10, 0));

//		Bitmap b3 = bitmapPool.get();
//		Bitmap b4 = bitmapPool.get();
//		Bitmap b5 = bitmapPool.get();
//		Bitmap b6 = bitmapPool.get();
//		Bitmap b7 = bitmapPool.get();

    	b1.draw();
    	b2.draw();

    	bitmapPool.release(b1);
    	bitmapPool.release(b2);
    }
}
