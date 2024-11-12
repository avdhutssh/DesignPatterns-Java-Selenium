package com.example.compositepattern;

// Client Code
public class FileSystem {
    public static void main(String[] args) {
        // Leaf nodes
        File file1 = new File("ImageFile1.png");
        File file2 = new File("AudioFile2.mp3");
        File file3 = new File("TextFile3.txt");

        // Composite nodes
        Directory dir1 = new Directory("Dir1");
        Directory dir2 = new Directory("Dir2");
        Directory rootDir = new Directory("RootDir");

        // Building the tree structure
        dir1.addComponent(file1);
        dir1.addComponent(file2);

        dir2.addComponent(file3);

        rootDir.addComponent(dir1);
        rootDir.addComponent(dir2);

        // Displaying the file system structure
        rootDir.showDetails();

        System.out.println("---------------------");
        rootDir.removeComponent(dir1);
        rootDir.removeComponent(dir2);

        rootDir.showDetails();
    }
}
