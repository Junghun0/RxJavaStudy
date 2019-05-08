package util;

public class CommonUtils {
    //실행 시간을 표기하기 위한 정적 변수.
    public static long startTime;

    public static void exampleStart() {
        startTime = System.currentTimeMillis();
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getShape(String obj){
        if (obj == null || obj.equals("")) return "No-Shape";
        if (obj.endsWith("-H")) return "Hexagon";
        if (obj.endsWith("-O")) return "Octagon";
        if (obj.endsWith("-R")) return "Rectangle";
        if (obj.endsWith("-T")) return "Triangle";
        if (obj.endsWith("#")) return "Custom";
        return "BALL";
    }
}
