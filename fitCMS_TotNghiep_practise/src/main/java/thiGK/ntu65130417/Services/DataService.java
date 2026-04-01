package thiGK.ntu65130417.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import thiGK.ntu65130417.Models.Student;
import thiGK.ntu65130417.Models.Topic;

@Service
public class DataService {
    private List<Topic> dsTopic = new ArrayList<>();
    private List<Student> dsStudent = new ArrayList<>();

    public DataService() {
        dsTopic.add(new Topic("T01", "Web Spring Boot", "Làm web bán hàng", "GV01", "Đồ án"));
        dsStudent.add(new Student("SV01", "Nguyễn Văn A", "Nhóm 1"));
    }

    // --- Xử lý Topic ---
    public List<Topic> getAllTopics() { return dsTopic; }
    public Topic getTopicById(String id) {
        for (Topic t : dsTopic) { if (t.getId().equals(id)) return t; }
        return null;
    }
    public void addTopic(Topic topic) { dsTopic.add(topic); }
    public void deleteTopic(String id) {
        for (int i = 0; i < dsTopic.size(); i++) {
            if (dsTopic.get(i).getId().equals(id)) { dsTopic.remove(i); break; }
        }
    }

    // --- Xử lý Student ---
    public List<Student> getAllStudents() { return dsStudent; }
    public Student getStudentById(String id) {
        for (Student s : dsStudent) { if (s.getId().equals(id)) return s; }
        return null;
    }
    public void addStudent(Student student) { dsStudent.add(student); }
    public void deleteStudent(String id) {
        for (int i = 0; i < dsStudent.size(); i++) {
            if (dsStudent.get(i).getId().equals(id)) { dsStudent.remove(i); break; }
        }
    }
}
