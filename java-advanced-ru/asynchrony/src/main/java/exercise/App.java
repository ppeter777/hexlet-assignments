package exercise;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String file1Path, String file2Path, String resultPath) throws ExecutionException, InterruptedException {
        Path path1 = Paths.get(file1Path).toAbsolutePath().normalize();
        Path path2 = Paths.get(file2Path).toAbsolutePath().normalize();
        Path pathRes = Paths.get(resultPath).toAbsolutePath().normalize();

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("reading file1");
                System.out.println("finished reading file1");
                return Files.readString(path1);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("reading file2");
                System.out.println("finished reading file2");
                return Files.readString(path2);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        CompletableFuture<String> res = future1.thenCombine(future2, (a, b) -> {
            System.out.println("build output");
            String output = a + b;
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(resultPath, true);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            try {
                fos.write(output.getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(output);
            try {
                Files.createFile(Paths.get(resultPath));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return output;
        }).exceptionally(ex -> {
            System.out.println("Oops! We have an exception - " + ex.getMessage());
            return null;
        });
        return res;
    }

    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        String filePath1 = "src/main/resources/file1.txt";
        String filePath2 = "src/main/resources/file2.txt";
        String filePath3  = "src/main/resources/file3.txt";

        unionFiles(filePath1, filePath2, filePath3);
        // END
    }
}

