package JavaCodePractice;

public class ReadExelMain {

	public static void main(String[] args) {
		ExcelReadMethod read=new ExcelReadMethod();
		read.readExcel("E:\\ExcelFilesReadWrite", "ReadData.xlsx", "data");
	}

}
