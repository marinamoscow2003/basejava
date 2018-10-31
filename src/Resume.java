/**
 * Initial resume class
 */
public class Resume {

    // Unique identifier
    String uuid;

    public Resume() {
    }

    public Resume(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return uuid;
    }

    public boolean equals(Resume obj) {
        return this.uuid.equals(obj.uuid);
    }
}
