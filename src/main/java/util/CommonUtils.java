package util;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Random;

public class CommonUtils {
    public static final String GITHUB_ROOT = "https://raw.githubusercontent.com/yudong80/reactivejava/master/";

    public static final String API_KEY =
            "5712cae3137a8f6bcbebe4fb35dfb434";
//	"e7681f2ac93cbdf1bc3952e30ab80533";
//	"fe6edeb30e2b9ee7848e4ded0491d8d1";

    public static final String ERROR_CODE = "-500";

    public static long startTime;

    public static void exampleStart() {
        startTime = System.currentTimeMillis();
    }

    public static void exampleStart(Object obj) {
        startTime = System.currentTimeMillis();
        Log.it(obj);
    }

    public static void exampleComplete() {
        System.out.println("-----------------------");
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void doSomething() {
        try {
            Thread.sleep(new Random().nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String numberToAlphabet(long x) {
        return Character.toString(ALPHABET.charAt((int) x % ALPHABET.length()));
    }

    public static boolean isNetworkAvailable() {
        try {
            return InetAddress.getByName("www.google.com").isReachable(1000);
        } catch (IOException e) {
            Log.v("Network is not available");
        }
        return false;
    }

    public static int toInt(String val) {
        return Integer.parseInt(val);
    }

    public static final String HEXAGON = "HEXAGON";
    public static final String OCTAGON = "OCTAGON";
    public static final String RECTANGLE = "RECTANGLE";
    public static final String TRIANGLE = "TRIANGLE";
    public static final String DIAMOND = "DIAMOND";
    public static final String PENTAGON = "PENTAGON";
    public static final String BALL = "BALL";
    public static final String STAR = "STAR";
    public static final String NO_SHAPE = "NO_SHAPE";
    public static final String FLIPPED = "(flipped)";

    //Colors for shape
    public static final String RED = "1";
    public static final String YELLOW = "2";
    public static final String GREEN = "3";
    public static final String SKY = "4";
    public static final String BLUE = "5";
    public static final String PUPPLE = "6";
    public static final String ORANGE = "7";

    public static String getColor(String shape) {
        if (shape.endsWith("<>")) //diamond
            return shape.replace("<>", "").trim();

        int hyphen = shape.indexOf("-");
        if (hyphen > 0) {
            return shape.substring(0, hyphen);
        }

        return shape; //for ball
    }

    public static String getSuffix(String shape) {
        if (HEXAGON.equals(shape)) return "-H";
        if (OCTAGON.equals(shape)) return "-O";
        if (RECTANGLE.equals(shape)) return "-R";
        if (TRIANGLE.equals(shape)) return "-T";
        if (DIAMOND.equals(shape)) return "<>";
        if (PENTAGON.equals(shape)) return "-P";
        if (STAR.equals(shape)) return "-S";
        return ""; //for BALL
    }

    public static String getShape(String obj) {
        if (obj == null || obj.equals("")) return NO_SHAPE;
        if (obj.endsWith("-H")) return HEXAGON;
        if (obj.endsWith("-O")) return OCTAGON;
        if (obj.endsWith("-R")) return RECTANGLE;
        if (obj.endsWith("-T")) return TRIANGLE;
        if (obj.endsWith("<>")) return DIAMOND;
        if (obj.endsWith("-P")) return PENTAGON;
        if (obj.endsWith("-S")) return STAR;
        return "BALL";
    }

    public static String getString(String color, String shape) {
        return color + getSuffix(shape);
    }

    public static String flip(String item) throws ShapeCannotFlipException {
        if(item.startsWith(FLIPPED)) {
            return item.replace(FLIPPED, "");
        }

        String shape = getShape(item);
        switch(shape) {
            case BALL:
            case RECTANGLE:
            case DIAMOND:
            case NO_SHAPE:
                throw new ShapeCannotFlipException();
                //return "throw new ShapeCannotFlipException()";
        };

        return FLIPPED + item;
    }

    public static String triangle(String color) {
        return color + "-T";
    }

    public static String rectangle(String color) {
        return color + "-R";
    }

    public static String star(String color) {
        return color + "-S";
    }

    public static String pentagon(String color) {
        return color + "-P";
    }
}
