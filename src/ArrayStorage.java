import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    int size = 0;
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < size; i++) {
            if (!Objects.isNull(storage[i])) {
                storage[i] = null;
            }
        }
        size = 0;
    }

    void save(Resume r) {
        int j = 0;
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        int j = -1;
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                j = i;
                break;
            }
        }
        if (j==-1) return null;
        return storage[j];
    }

    void delete(String uuid) {
        int j = -1;
        for (int i = 0; i < size; i++) {
            if (j==-1 && storage[i].getUuid().equals(uuid)) {
                j = i;
            }
            if (j != -1) {
                storage[i] = storage[i + 1];
            }
        }
        if (j!=-1) {
            storage[storage.length - 1] = null;
            if (size>0) size--;
        } else {
            System.out.println("Резюме "+uuid+ " нет в базе");
        }
    }
    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = new Resume[size];
        for (int i = 0; i < size; i++) {
            resumes[i] = storage[i];
        }
        return resumes;
    }
    int size() {
        return size;
    }
}
