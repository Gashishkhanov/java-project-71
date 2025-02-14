package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "1.0",
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<String> {

    @Parameters(index = "0", description = "Path to first file")
    private String filePath1;

    @Parameters(index = "1", description = "Path to second file")
    private String filePath2;

    @Option(names = {"-f", "--format"}, description = "Output format [stylish, plain, json]", defaultValue = "stylish")
    private String format;

    @Override
    public String call() {
        try {
            String result = Differ.generate(filePath1, filePath2, format);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
