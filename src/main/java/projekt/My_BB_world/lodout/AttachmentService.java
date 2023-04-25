package projekt.My_BB_world.lodout;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.NoSuchElementException;

@Service

public class AttachmentService {

    private final AttachmentRepository attachmentRepository;

    public AttachmentService(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }
    Attachment addAttachment(Attachment attachment){
        return attachmentRepository.save(attachment);
    }
    List<Attachment> showAttachment(){
        return attachmentRepository.findAll();
    }
    Attachment getAttachment(Long id){
        return attachmentRepository.findAttachmentById(id)
                .orElseThrow(()-> new NoSuchElementException("Attachment not exist"));

    }
    Attachment updateAttachment(Long id, @RequestBody Attachment attachmentToUpdate){
        return attachmentRepository.findAttachmentById(id)
                .map(attachment ->{attachment.setAttachmentType(attachment.getAttachmentType());
                    return attachmentRepository.save(attachment);})
                .orElseThrow(()-> new NoSuchElementException("Attachment not exist"));
    }
    Attachment deleteAttachment(Long id){
        Attachment attachment = attachmentRepository.findAttachmentById(id)
                .orElseThrow(()-> new NoSuchElementException("Attachment not exist"));
        attachmentRepository.deleteById(id);
        return attachment;
    }
}
