package projekt.My_BB_world.lodout;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AttachmentRepository extends JpaRepository<Attachment,Long> {
    Optional<Attachment> findAttachmentById(Long attachmentId);
}
