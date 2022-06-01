import java.io.File;
import java.text.NumberFormat;

/**
 * A simple java program to view the CPU and memory usage of the current app
 * and also some other details of the host machine
 * 
 * 
 * @author Er. Abraham Bisrat
 *
 */

public class SystemInfo {
	
	public static void main(String[] args) {
		
		simpleSystemInfo();
		System.out.println(info());
	}
	
	private static Runtime runtime = Runtime.getRuntime();
	
    public static String info() {
        StringBuilder sb = new StringBuilder();
        sb.append(osInfo());
        sb.append(memInfo());
        sb.append(diskInfo());
        return sb.toString();
    }

    public static String osName() { return System.getProperty("os.name"); }

    public static String osVersion() { return System.getProperty("os.version"); }

    public static String osArch() { return System.getProperty("os.arch"); }

    public long totalMem() { return Runtime.getRuntime().totalMemory(); }

    public long usedMem() { return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory(); }

    public static String memInfo() {
        NumberFormat format = NumberFormat.getInstance();
        StringBuilder sb = new StringBuilder();
        long maxMemory = runtime.maxMemory();
        long allocatedMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        sb.append("Free memory: ");
        sb.append(format.format(freeMemory / 1024));
        sb.append("\n\n");
        sb.append("Allocated memory: ");
        sb.append(format.format(allocatedMemory / 1024));
        sb.append("\n\n");
        sb.append("Max memory: ");
        sb.append(format.format(maxMemory / 1024));
        sb.append("\n\n");
        sb.append("Total free memory: ");
        sb.append(format.format((freeMemory + (maxMemory - allocatedMemory)) / 1024));
        sb.append("\n\n");
        return sb.toString();

    }

    public static String osInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("OS: ");
        sb.append(osName());
        sb.append("\n\n");
        sb.append("Version: ");
        sb.append(osVersion());
        sb.append("\n\n");
        sb.append("Architecture: ");
        sb.append(osArch());
        sb.append("\n\n");
        sb.append("Available processors (cores): ");
        sb.append(runtime.availableProcessors());
        sb.append("\n\n");
        return sb.toString();
    }

    public static String diskInfo() {
        /* Get a list of all filesystem roots on this system */
        File[] roots = File.listRoots();
        StringBuilder sb = new StringBuilder();

        /* For each filesystem root, print some info */
        for (File root : roots) {
        	sb.append("\n");
            sb.append("File system root: ");
            sb.append(root.getAbsolutePath());
            sb.append("\n\n");
            sb.append("Total space (bytes): ");
            sb.append(root.getTotalSpace());
            sb.append("\n\n");
            sb.append("Free space (bytes): ");
            sb.append(root.getFreeSpace());
            sb.append("\n\n");
            sb.append("Usable space (bytes): ");
            sb.append(root.getUsableSpace());
            sb.append("\n\n");
        }
        return sb.toString();
    }
	
	private static void simpleSystemInfo() {
		Runtime runtime = Runtime.getRuntime();

		NumberFormat format = NumberFormat.getInstance();

		StringBuilder sb = new StringBuilder();
		long maxMemory = runtime.maxMemory();
		long allocatedMemory = runtime.totalMemory();
		long freeMemory = runtime.freeMemory();

		sb.append("free memory: " + format.format(freeMemory / 1024) + "<br/>");
		sb.append("allocated memory: " + format.format(allocatedMemory / 1024) + "<br/>");
		sb.append("max memory: " + format.format(maxMemory / 1024) + "<br/>");
		sb.append("total free memory: " + format.format((freeMemory + (maxMemory - allocatedMemory)) / 1024) + "<br/>");
	}
}
