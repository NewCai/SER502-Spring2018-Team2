package runtime;

import org.antlr.v4.runtime.tree.ParseTree;

import java.io.BufferedReader;
import java.io.FileReader;

public class Executor {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please run as java -jar GFRuntime.jar example.inter");
            return;
        }

        String fileName = args[0];
        if (!isValidFile(fileName)) {
            return;
        }

        VirtualMachine vm = new VirtualMachine();
        try {
           BufferedReader in = new BufferedReader(new FileReader(fileName));
           String line;
           while ((line = in.readLine()) != null) {
               vm.addInstruction(line);
           }

           in.close();
        } catch (Exception e) {
            System.out.println("Error occur when executing the intermediate code");
            System.out.println(e.getMessage());
        }

        System.out.print(vm.getInstructionsString());
        System.out.print(vm.getLabelTableString());
        System.out.print(vm.getSymbolTabelString());
    }

    private static boolean isValidFile(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            System.out.println("File name cannot be emptied");
            return false;
        }

        int pos = fileName.lastIndexOf('.');
        if (pos < 0) {
            System.out.println("Please provide a file with '.inter' extension");
            return false;
        }

        String extension = fileName.substring(pos + 1);
        if (!extension.equals("inter")) {
            System.out.println("Please provide a file with '.inter' extension");
            return false;
        }

        return true;
    }

}
