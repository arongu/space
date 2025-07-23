package reg.io_nio;

import java.io.File;

/**
 * I/O utility methods need to be implemented using standard Java I/O
 *
 * @author yura
 *
 */
public interface IOUtils {
    /**
     * Compresses {@code fileName} file and saves the result with ".gzip" extension
     * to {@code folder} directory.
     * {@link java.util.zip.GZIPOutputStream GZIPOutputStream} is used
     * to compress the stream.
     *
     * @param fileName path to the file
     * @param folder folder to save the compressed file
     * @return absolute path to the new file including filename
     * @throws IllegalArgumentException if {@code fileName} cannot be created or
     *                                  if {@code folder} doesn't exist
     */
    String gzip(String fileName, String folder) throws IllegalArgumentException;

    /**
     * Searches for all {@code mark} occurrences in text file {@code fileName}
     * and returns the number of lines that {@code mark} is present in.
     *
     * @param fileName path to the file
     * @param mark text to search for
     * @return number of rows that {@code mark} is present in
     * @throws IllegalArgumentException if {@code file} doesn't exist
     */
    Integer searchText(String fileName, String mark)
        throws IllegalArgumentException;

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
    String[] search(File folder, String ext) throws IllegalArgumentException;
}
