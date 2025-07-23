package reg.io_nio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void nioPart1_searchText()
    throws IOException {
        final FileWriter     fileWriter     = new FileWriter("file.txt");
        final BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("1 7 -2 a -2");
        bufferedWriter.newLine();
        bufferedWriter.close();


        final NIOUtils nioUtils = new NIOUtilsImpl();
        final Path     path     = Paths.get("file.txt");
        final String   result   = nioUtils.searchText(path, 4);
        System.out.println(result);
    }

    public static void nioPart2_search() {
        final NIOUtils nioUtils = new NIOUtilsImpl();
        final String[] filesGot = nioUtils.search(Paths.get("./"), "java");
        for ( final String file : filesGot ) {
            System.out.println(file);
        }
    }

    public static void ioPart1_gzip() {
        final IOUtils ioUtils = new IOUtilsImpl();
        final String created = ioUtils.gzip("file.txt", "");
        System.out.printf("gzip created: %s\n", created);
    }

    public static void ioPart2_searchText() {
        final IOUtils ioUtils    = new IOUtilsImpl();
        final String  searchText = "Humpty";
        final int     n          = ioUtils.searchText("humpty.txt", searchText);
        System.out.printf("searchText: '%s', occurrences: %d\n", searchText, n);
    }

    public static void ioPart3_searchForJavaFiles() {
        final IOUtils  ioUtils       = new IOUtilsImpl();
        final String[] absolutePaths = ioUtils.search(Paths.get("").toFile(), "java");
        for ( final String absolutePath : absolutePaths ) {
            System.out.println(absolutePath);
        }
    }

    public static void main( String[] args )
    throws IOException {
        System.out.println("NIO1----------------------");
        nioPart1_searchText();
        System.out.println("NIO2----------------------");
        nioPart2_search();

        System.out.println("\nIO1 ----------------------");
        ioPart1_gzip();
        System.out.println("IO2 ----------------------");
        ioPart2_searchText();
        System.out.println("IO3 ----------------------");
        ioPart3_searchForJavaFiles();
    }
}
