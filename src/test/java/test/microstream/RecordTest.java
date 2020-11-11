package test.microstream;

import one.microstream.storage.types.EmbeddedStorage;
import one.microstream.storage.types.EmbeddedStorageManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import test.microstream.data.PersonRecord;

import java.nio.file.Path;

public class RecordTest {

    @TempDir
    Path location;


    @Test
    public void saveRecordTest() {
        PersonRecord personRecord = new PersonRecord("Maria", "Lukasova");

        EmbeddedStorageManager storage = EmbeddedStorage.start(personRecord, location);
        storage.shutdown();

        PersonRecord secondRecord = new PersonRecord("Kamila", "Pazourkova");
        storage = EmbeddedStorage.start(secondRecord, location);

        Assertions.assertEquals("Maria", secondRecord.firstName());

    }

}
