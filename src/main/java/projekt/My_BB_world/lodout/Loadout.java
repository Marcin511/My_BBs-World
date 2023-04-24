package projekt.My_BB_world.lodout;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Loadout {
    @Id
    private Long loadoutId;
    private String type;
    private int fps;
    @OneToMany
    private Attachment attachment;
}
