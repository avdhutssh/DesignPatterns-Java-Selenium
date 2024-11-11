package company.factory;


import company.adapter.ArrayStore;
import company.adapter.Store;
import company.directory.Directory;
import company.directory.Monitor;
import company.directory.SimpleDirectory;

public class SimpleFactory extends Factory {

    @Override
    public Directory getDirectory() {
        Store store = ArrayStore.getInstance();  // Singleton instance of ArrayStore
        Directory simpleDirectory = new SimpleDirectory(store);
        return new Monitor(simpleDirectory);  // Wrap SimpleDirectory with Monitor
    }
}
