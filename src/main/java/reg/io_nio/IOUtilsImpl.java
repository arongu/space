package reg.io_nio;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.GZIPOutputStream;

public class IOUtilsImpl implements IOUtils {
    @Override
    public String gzip( String fileName, String folder )
    throws IllegalArgumentException {
        final Path pathFile     = Paths.get(fileName);
        final Path pathFileGzip = Paths.get(folder).resolve(pathFile.getFileName() + ".gzip");

        try ( final FileInputStream fileInputStream = new FileInputStream(pathFile.toFile()) ) {
            try ( final FileOutputStream fileOutputStream = new FileOutputStream(pathFileGzip.toFile());
                  final GZIPOutputStream gzipOutputStream = new GZIPOutputStream(fileOutputStream) ) {
                byte[] buffer = new byte[2048];
                int    len;

                while ( ( len = fileInputStream.read(buffer) ) != -1 ) {
                    gzipOutputStream.write(buffer, 0, len);
                }

                gzipOutputStream.flush();
            }

        } catch ( final IOException ioException ) {
            throw new IllegalArgumentException(ioException.getMessage());
        }

        return pathFile + ".gzip";
    }

    @Override
    public Integer searchText( String fileName, String mark )
    throws IllegalArgumentException {
        try ( BufferedReader bufferedReader = new BufferedReader(new FileReader(Paths.get(fileName).toFile())) ) {
            int occurs = 0;
            while ( bufferedReader.ready() ) {
                if ( bufferedReader.readLine().contains(mark) ) {
                    occurs++;
                }
            }

            return occurs;
        } catch ( IOException e ) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    public String[] search( File folder, String ext )
    throws IllegalArgumentException {
        Set <String> asbolutePaths = new HashSet <>();
        try {
            Files.walkFileTree(Paths.get(folder.toURI()), new SimpleFileVisitor <>() {
                public FileVisitResult visitFile( Path file, BasicFileAttributes attrs ) {
                    if ( !Files.isDirectory(file) ) {
                        String fileName = file.getFileName().toString();
                        if ( ext.isEmpty() ) {
                            asbolutePaths.add(file.toAbsolutePath().toString());
                        } else if ( fileName.endsWith(ext) ) {
                            asbolutePaths.add(file.toAbsolutePath().toString());
                        }
                    }

                    return FileVisitResult.CONTINUE;
                }
            });
        } catch ( final IOException e ) {
            throw new IllegalArgumentException(e.getMessage());
        }

        return asbolutePaths.toArray(new String[0]);
    }
}
