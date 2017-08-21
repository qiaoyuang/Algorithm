package offer;

//实现单例模式

public class Questions02 {
	
	private Questions02() {}
	
	private static Questions02 sInstance;
	
	public static Questions02 getQuestions2() {
		if (sInstance == null) {
			synchronized (Questions02.class) {
				if (sInstance == null) {
					sInstance = new Questions02();
				}
			}
		}
		return sInstance;
	}

}