package reg.io_nio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.Set;

public class NIOUtilsImpl implements NIOUtils {
    @Override
    public String searchText( Path file, int offset )
    throws IllegalArgumentException {
        StringBuilder stringBuilder = new StringBuilder();
        try ( BufferedReader bufferedReader = new BufferedReader(new FileReader(file.toFile())) ) {
            while ( bufferedReader.ready() ) {
                stringBuilder.append(bufferedReader.readLine());
            }

            final String[] split = stringBuilder.toString().split(" ");
//            for ( String s : split ) {
//                System.out.printf("'%s' ", s );
//            }
//            System.out.println();

            if ( offset > split.length ) {
                throw new IllegalArgumentException("offset is out of range");
            }

            // set offset if grater than 0
            int offsetIndex = 0;
            if ( split.length > 0 && offset > 0 ) {
                offsetIndex = offset - 1;
            }

            for ( int i = offsetIndex; i < split.length; i++ ) {
                try {
                    //System.out.println("index: " + i + ", character: " + split[i]);

                    int asNumber = Integer.parseInt(split[i]);
                    int newIndex = i + asNumber;

                    //System.out.println("newIndex: " + newIndex + "\n");

                    if ( newIndex > split.length || newIndex < 0 ) {
                        return split[i];
                    } else {
                        i = newIndex;
                    }

                } catch ( NumberFormatException e ) {
                    return split[i];
                }
            }

        } catch ( final FileNotFoundException e ) {
            throw new IllegalArgumentException("No such file! Bad filename: " + file.getFileName().toString());
        } catch ( IOException e ) {
            throw new IllegalArgumentException(e.getMessage());
        }

        return "";
    }

    @Override
    public String[] search( Path folder, String ext )
    throws IllegalArgumentException {
        final Set <String> fileList = new HashSet <>();
        try {
            Files.walkFileTree(Paths.get(folder.toUri()), new SimpleFileVisitor <>() {
                public FileVisitResult visitFile( Path file, BasicFileAttributes attrs ) {
                    if ( !Files.isDirectory(file) ) {
                        String fileName = file.getFileName().toString();
                        if ( fileName.endsWith(ext) ) {
                            fileList.add(fileName);
                        }
                    }

                    return FileVisitResult.CONTINUE;
                }
            });
        } catch ( final IOException e ) {
            throw new IllegalArgumentException(e.getMessage());
        }

        return fileList.toArray(new String[0]);
    }
}

