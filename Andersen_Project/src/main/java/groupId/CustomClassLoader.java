package groupId;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class CustomClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classBytes = loadClassFromFile(name);
        if (classBytes == null) {
            throw new ClassNotFoundException("Class " + name + " could not be loaded!");
        }
        return defineClass(name, classBytes, 0, classBytes.length);
    }

    private byte[] loadClassFromFile(String fileName) {
        InputStream inputStream = null;
        ByteArrayOutputStream byteStream = null;

        try {
            String filePath = fileName.replace('.', File.separatorChar) + ".class";
            inputStream = getClass().getClassLoader().getResourceAsStream(filePath);
            if (inputStream == null) {
                System.out.println("File not found for class: " + fileName);
                return null;
            }

            byteStream = new ByteArrayOutputStream();
            int nextValue;

            while ((nextValue = inputStream.read()) != -1) {
                byteStream.write(nextValue);
            }

            return byteStream.toByteArray();
        } catch (IOException e) {
            System.err.println("Error loading class file: " + e.getMessage());
            return null;
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (byteStream != null) {
                    byteStream.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing streams: " + e.getMessage());
            }
        }
    }
}
