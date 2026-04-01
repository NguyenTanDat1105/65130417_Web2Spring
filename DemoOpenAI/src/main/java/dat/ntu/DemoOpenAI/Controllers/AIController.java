package dat.ntu.DemoOpenAI.Controllers;

import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/chat")
public class AIController {
	private final ChatClient chatClient;
	
    public AIController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/ask")
    public Map<String, String> generate(@RequestParam(value = "message") String message) {
        // Gửi prompt tới Groq và lấy nội dung phản hồi
        String response = chatClient.prompt()
                .user(message)
                .call()
                .content();
                
        // Trả về định dạng JSON
        return Map.of("reply", response);
    }
}
