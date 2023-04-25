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
    Attachment getAttachment(Long attachmentId){
        return attachmentRepository.findAttachmentById(attachmentId)
                .orElseThrow(()-> new NoSuchElementException("Attachment not exist"));

    }
    Attachment updateAttachment(Long attachmentId, @RequestBody Attachment attachmentToUpdate){
        return attachmentRepository.findAttachmentById(attachmentId)
                .map(attachment ->{attachmentToUpdate.setAttachmentType(attachment.getAttachmentType());
                    return attachmentRepository.save(attachment);})
                .orElseThrow(()-> new NoSuchElementException("Attachment not exist"));
    }
    Attachment deleteAttachment(Long attachmentId){
        Attachment attachment = attachmentRepository.findAttachmentById(attachmentId)
                .orElseThrow(()-> new NoSuchElementException("Attachment not exist"));
        attachmentRepository.deleteById(attachmentId);
        return attachment;
    }
}
