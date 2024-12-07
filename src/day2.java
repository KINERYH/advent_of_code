import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("inputs\\day2"));

        int numSafeReports = 0;

        while(s.hasNextLine()){
            String line = s.nextLine();
            String[] inputs = line.split(" ");
            int[] report = new int[inputs.length];
            for(int i = 0; i < inputs.length; i++) report[i] = Integer.parseInt(inputs[i]);

            // Part one
            // if(isReportSafe(report)) numSafeReports++;

            // Part two
            if(isReportSafeWithDampener(report)) numSafeReports++;
        }

        System.out.println("The number of safe report is " + numSafeReports);
    }

    public static boolean isReportSafe(int[] report){
        boolean increasingOrder = report[0] < report[report.length - 1];
        for(int i = 1; i < report.length; i++){
            int slope = report[i] - report[i-1];
            if ((increasingOrder && slope <= 0) || (!increasingOrder && slope >= 0) || Math.abs(slope) > 3) {
                return false;
            }
        }
        return true;
    }

    public static boolean isReportSafeWithDampener(int[] report){
        if(isReportSafe(report)) return true;
        for(int i = 0; i < report.length; i++) if(isReportSafeSkippingLevel(report, i)) return true;
        return false;
    }

    public static boolean isReportSafeSkippingLevel(int[] report, int skipIndex){
        boolean increasingOrder = report[0] < report[report.length - 1];
        int prev = -1;

        for(int i = 0; i < report.length; i++){
            if(i == skipIndex) continue;

            if(prev != -1) {
                int slope = report[i] - prev;
                if ((increasingOrder && slope <= 0) || (!increasingOrder && slope >= 0) || Math.abs(slope) > 3) {
                    return false;
                }
            }
            prev = report[i];
        }
        return true;
    }






}
