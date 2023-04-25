package projekt.My_BB_world.lodout;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AttachmentController {
    private final AttachmentService attachmentService;

    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }
    @PostMapping("/loadout/{id}/new")
    public Attachment createAttachment(@RequestBody Attachment attachment){
        return attachmentService.addAttachment(attachment);
    }
    @GetMapping("/loadout/{id}/attachment")
    List<Attachment> GetAllAttachment(){
        return attachmentService.showAttachment();
    }
    @GetMapping("loadout/{id}/attachment/{attachmentId}")
    Attachment getSingleAttachment(Long attachmentId){
        return attachmentService.getAttachment(attachmentId);
    }
    @PutMapping("loadout/{id}/attachment/{attachmentId}")
    Attachment modifyAttachment(@PathVariable Long attachmentId, @RequestBody Attachment attachment){
        return attachmentService.updateAttachment(attachmentId,attachment);
    }
    @DeleteMapping("loadout/{id}/attachment/{attachmentId}")
    Attachment removeAttachment(@PathVariable Long attachmentId){
        return attachmentService.deleteAttachment(attachmentId);
    }
}
