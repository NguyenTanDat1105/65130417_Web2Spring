package thiGK.ntu65130417.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import thiGK.ntu65130417.Models.Student;
import thiGK.ntu65130417.Services.DataService;

@Controller
public class StudentController {

    @Autowired
    DataService dataService;

    // 8a. Hiển thị danh sách Student
    @GetMapping("/student/all")
    public String getAllStudent(ModelMap m) {
        List<Student> dsStudent = dataService.getAllStudents();
        m.addAttribute("students", dsStudent);
        return "student/all";
    }

    // 8b. Mở form thêm mới Student
    @GetMapping("/student/new")
    public String openAddNewStudent() {
        return "student/add";
    }

    // Xử lý dữ liệu từ form thêm mới Student
    @PostMapping("/savestudent")
    public String addNewStudent(
            @RequestParam("id") String id,
            @RequestParam("name") String name,
            @RequestParam("groupId") String groupId,
            ModelMap m) {
        
        // Kiểm tra trùng ID
        for(Student s : dataService.getAllStudents()) {
             if(s.getId().equals(id)) {
                 m.addAttribute("err", "Lỗi: ID Sinh viên đã tồn tại!");
                 return "student/add";
             }
        }
        
        // Kiểm tra tên trống
        if(name == null || name.trim().isEmpty()) {
            m.addAttribute("err", "Lỗi: Không được để tên sinh viên trống!");
            return "student/add";
        }
        
        // Lưu dữ liệu
        Student newStudent = new Student(id, name, groupId);
        dataService.addStudent(newStudent);
        
        return "redirect:/student/all";
    }

    // 8c. Xem chi tiết Student
    @GetMapping("/student/view/{id}")
    public String viewStudent(@PathVariable("id") String id, ModelMap m) {
        Student studentDetail = dataService.getStudentById(id);
        m.addAttribute("student", studentDetail);
        return "student/view";
    }

    // 8d. Xóa Student
    @GetMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable("id") String id) {
        dataService.deleteStudent(id);
        return "redirect:/student/all";
    }
}