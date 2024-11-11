
package company.factory;


import company.adapter.ArrayStore;
import company.adapter.Store;
import company.directory.Directory;
import company.directory.SimpleDirectory;

public class SimpleFactory extends Factory {

    @Override
    public Directory getDirectory() {
        Store store = new ArrayStore();
        return new SimpleDirectory(store);
    }
}
        