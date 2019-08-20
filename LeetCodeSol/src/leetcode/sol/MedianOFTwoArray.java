package Array;

public class MedianOFTwoArray {
	
	public static void main(String[] a) {
		new MedianOFTwoArray().run();
	}

	private void run() {
		int[] a = {1,2,3};
		int[] b = {4,5,6};
		
		System.out.println(moftwo(a,b));
		
	}

	private double moftwo(int[] a, int[] b) {
		int m = a.length;
		int n = b.length;
		
		if((m+n)%2!=0) {
			return moftwo(a,b,(m+n)/2,0,m-1,0,n-1);
		}else {
			return (moftwo(a,b,(m+n)/2,0,m-1,0,n-1)+moftwo(a,b,(m+n)/2-1,0,m-1,0,n-1))*0.5;
		}
		
	}

	private int moftwo(int[] a, int[] b, int k, int aStart, int aEnd, int bStart, int bEnd) {
		int alen = aEnd - aStart + 1;
		int blen = bEnd - bStart + 1;
		
		if(alen==0) {
			return b[bStart+k];
		}else if(blen==0) {
			return a[aStart+k];
		}else if(k==0) {
			return a[aStart]<b[bStart] ? a[aStart]:b[bStart];
		}
		
		int amid = k * alen / (alen+blen);
		int bmid = k - amid - 1;
		
		amid = amid + aStart;
		bmid = bmid + bStart;
		
		if(a[amid]>b[bmid]) {
			k = k - (bmid - bStart + 1);
			aEnd = amid;
			bStart = bmid+1;
		}else{
			k = k - (amid - aStart + 1);
			bEnd = bmid;
			aStart = amid+1;
		}
		
		return moftwo(a, b, k, aStart, aEnd, bStart, bEnd);
	}

}
