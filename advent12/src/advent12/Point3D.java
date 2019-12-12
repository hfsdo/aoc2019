package advent12;

public class Point3D {
	private long _x;
	private long _y;
	private long _z;
	
	
	public Point3D(long x, long y, long z) {
		// TODO Auto-generated constructor stub
		this._x = x;
		this._y = y;
		this._z = z;
	}


	public long x() {
		return _x;
	}


	public void x(long x) {
		this._x = x;
	}


	public long y() {
		return _y;
	}


	public void y(long y) {
		this._y = y;
	}


	public long z() {
		return _z;
	}


	public void z(long z) {
		this._z = z;
	}
	
	public String getCompareValue() {
		return ""+_x+":"+_y+":"+_z;
	}
	
	public void printPoint3D(String prefix) {
		System.out.printf("%s=<x=%d, y=%d, z=%d>", prefix, _x, _y, _z);
	}
}
