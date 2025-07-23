package reg.io_nio;

import java.nio.file.Path;

/**
 * I/O utility methods need to be implemented using Non-Blocking I/O
 * 
 * @author yura
 * 
 */
public interface NIOUtils {
    /**
     * Looks for text in a file using following rules:
     * 
     *     The file contains text and integers (both positive and
     *     negative).
     *     Space is used as a delimiter.
     *     There are no more than 10 bytes between delimiters.
     *     If the method reads an integer number N (not a digit, a whole
     *     number) then the next read occurs after N bytes relative to
     *     the current position.
     *     The position is moved forward for positive numbers and
     *     backward for negative numbers.
     *     If the method reads some text then this text is returned
     *     as a result of the method call.
     * 
     * <p>For example, for the file with the following content the call to
     * {@code searchText(path, 4)} will return "a":<br/>
     * {@code 1 7 -2 a -2}
     *
     * @param file path to the file
     * @param offset initial offset, measured from the beginning of the file,
     *               at which the first read occurs
     * @return text found in the file
     * @throws IllegalArgumentException if {@code file} doesn't exist
     */
    String searchText(Path file, int offset) throws IllegalArgumentException;

    /**
     * Looks for all files with {@code ext} extension in {@code folder}
     * directory as well as in its subdirectories and then returns files'
     * absolute paths as a string array. If {@code ext == null} then the method
     * treats it as an empty string and looks for all files.
     *
     * @param folder root directory to search for files in
     * @param ext file extension
     * @return list of absolute paths of the files that were found
     * @throws IllegalArgumentException if {@code folder} doesn't exist
     */
    String[] search(Path folder, String ext) throws IllegalArgumentException;

}
