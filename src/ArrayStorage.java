import java.util.Objects;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    void clear() {
        for (int i = 0; i < storage.length; i++) {
            if (!Objects.isNull(storage[i])) {
                storage[i] = null;
            }
        }
        storage.toString();
    }
    void save(Resume r) {
        int j = 0;
        if (Objects.isNull(r) || Objects.isNull(r.getUuid())) {
            System.out.println("Нет резюме для сохранения");
            return;
        }
        if (!Objects.isNull(storage[storage.length - 1])) {
            System.out.println("База данных реюме переполнена");
            return;
        }
        for (int i = 0; i < storage.length; i++) {
            if (Objects.isNull(storage[i])) {
                j = i;
                break;
            } else {
                if (storage[i].equals(r)) {
                    System.out.println("Данное резюме уже есть в базе");
                    return;
                }
            }
        }
        storage[j] = r;
    }
    Resume get(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (!Objects.isNull(storage[i])) {
                if (storage[i].getUuid().equals(uuid)) {
                    return storage[i];
                }
            }
        }
        return new Resume("Резюме "+uuid+ " не зарегистрировано в базе");
    }

    Integer getI(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (!Objects.isNull(storage[i])) {
                if (storage[i].getUuid().equals(uuid)) {
                    return i;
                }
            }
        }
        return -1;
    }
    void delete(String uuid) {
        int lng = getI(uuid);
        if (lng != -1) {
            for (int i = lng; i < storage.length - 1; i++) {
                 storage[i] = storage[i + 1];
            }
            storage[storage.length - 1] = null;
        } else {
            System.out.println("Резюме "+uuid+ " нет в базе");
        }
    }
    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = new Resume[size()];
        for (int i = 0; i < size(); i++) {
            resumes[i] = storage[i];
        }
        return resumes;
    }
    int size() {
        int i = 0;
        while ((storage.length > i) && !Objects.isNull(storage[i])) {
            i++;
        }
        return i;
    }
}
