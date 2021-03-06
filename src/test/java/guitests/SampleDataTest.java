package guitests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

import seedu.room.model.ResidentBook;
import seedu.room.model.person.Person;
import seedu.room.model.util.SampleDataUtil;
import seedu.room.testutil.TestUtil;

public class SampleDataTest extends ResidentBookGuiTest {
    @Override
    protected ResidentBook getInitialData() {
        // return null to force test app to load data from file only
        return null;
    }

    @Override
    protected String getDataFileLocation() {
        // return a non-existent file location to force test app to load sample data
        String filePath = TestUtil.getFilePathInSandboxFolder("SomeFileThatDoesNotExist1234567890.xml");
        deleteFileIfExists(filePath);
        return filePath;
    }

    /**
     * Deletes the file at {@code filePath} if it exists.
     */
    private void deleteFileIfExists(String filePath) {
        try {
            Files.deleteIfExists(Paths.get(filePath));
        } catch (IOException ioe) {
            throw new AssertionError(ioe);
        }
    }

    @Test
    public void residentBook_dataFileDoesNotExist_loadSampleData() {
        Person[] expectedList = SampleDataUtil.getSamplePersons();
        // assertListMatching(getPersonListPanel(), expectedList);
    }
}
