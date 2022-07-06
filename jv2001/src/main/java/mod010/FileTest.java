package mod010;

import java.io.File;

public class FileTest {
	private static final String SAVE_DIR = "C:\\temp";
	public static void main(String[] args) {
		File savaDir = new File(SAVE_DIR);
		System.out.println(savaDir.getPath());
		System.out.println("Window : " + File.separator);
		//OS마다 파일 구분자가 달라서 File.separator 쓰면 알아서 해준다.
	}
}
