package runtime;

/**
 * Wrapper class fo the runtime. Receives a file path, then loads and executes the
 * instructions in the file.
 */
public class Executor {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please run as java -jar GFRuntime.jar example.inter");
            return;
        }

        String filePath = args[0];
        if (!isValidFile(filePath)) {
            return;
        }

        VirtualMachine vm = new VirtualMachine();
        vm.loadProgramFromFile(filePath);
        vm.executeProgram();
    }

    private static boolean isValidFile(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            System.err.println("File name cannot be emptied");
            return false;
        }

        int pos = fileName.lastIndexOf('.');
        if (pos < 0) {
            System.err.println("Please provide a file with '.inter' extension");
            return false;
        }

        String extension = fileName.substring(pos + 1);
        if (!extension.equals("inter")) {
            System.err.println("Please provide a file with '.inter' extension");
            return false;
        }

        return true;
    }
}
