import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Getcount {
	static String name = null;
	static List<String> mReClashList;

	public static void main(String[] args) throws IOException {
		mReClashList = new ArrayList<>();

		try {

			BufferedReader firstAD;
			firstAD = new BufferedReader(new FileReader("E:\\Desktop\\asa\\AD"));

			String line;
			while ((line = firstAD.readLine()) != null) {
				if (!(line.contains("#") || line.equals(""))) {
					mReClashList.add(line.replace("127.0.0.1 ", ""));
				}
			}
			firstAD.close();

			BufferedReader re = new BufferedReader(new FileReader("E:\\Desktop\\asa\\RRe"));

			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("E:\\Desktop\\asa\\newRE")));
			boolean flag = false;

			while ((line = re.readLine()) != null) {
				for (String tmp : mReClashList) {
					if (line.contains(tmp)) {
						flag = true;
						break;
					}
				}
				if (!flag) {
					out.print(line + "\n");
				} else {
					flag = false;
				}

			}
			out.close();

			System.out.print("ok");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
