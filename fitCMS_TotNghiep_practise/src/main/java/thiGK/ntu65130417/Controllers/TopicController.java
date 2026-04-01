package thiGK.ntu65130417.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import thiGK.ntu65130417.Models.Topic;
import thiGK.ntu65130417.Services.DataService;

@Controller
public class TopicController {

    @Autowired
    DataService dataService;

    // 7a. Hiển thị danh sách Topic
    @GetMapping("/topic/all")
    public String getAllTopic(ModelMap m) {
        List<Topic> dsTopic = dataService.getAllTopics();
        m.addAttribute("topics", dsTopic);
        return "topic/all";
    }

    // 7b. Mở form thêm mới Topic
    @GetMapping("/topic/new")
    public String openAddNewTopic() {
        return "topic/add";
    }

    // Xử lý dữ liệu từ form thêm mới Topic
    @PostMapping("/savetopic")
    public String addNewTopic(
            @RequestParam("id") String id,
            @RequestParam("topicName") String topicName,
            @RequestParam(value = "topicDescription", required = false) String topicDescription,
            @RequestParam("supervisorId") String supervisorId,
            @RequestParam("topicType") String topicType,
            ModelMap m) {
        
        // Kiểm tra trùng ID
        for(Topic t : dataService.getAllTopics()) {
             if(t.getId().equals(id)) {
                 m.addAttribute("err", "Lỗi: ID này đã tồn tại!");
                 return "topic/add";
             }
        }
        
        // Kiểm tra tên trống
        if(topicName == null || topicName.trim().isEmpty()) {
            m.addAttribute("err", "Lỗi: Không được để tên Topic trống!");
            return "topic/add";
        }
        
        // Lưu dữ liệu
        Topic newTopic = new Topic(id, topicName, topicDescription, supervisorId, topicType);
        dataService.addTopic(newTopic);
        
        return "redirect:/topic/all";
    }

    // 7c. Xem chi tiết Topic
    @GetMapping("/topic/view/{id}")
    public String viewTopic(@PathVariable("id") String id, ModelMap m) {
        Topic topicDetail = dataService.getTopicById(id);
        m.addAttribute("topic", topicDetail);
        return "topic/view";
    }

    // 7d. Xóa Topic
    @GetMapping("/topic/delete/{id}")
    public String deleteTopic(@PathVariable("id") String id) {
        dataService.deleteTopic(id);
        return "redirect:/topic/all";
    }
}
