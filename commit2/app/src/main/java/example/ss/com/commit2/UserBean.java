package example.ss.com.commit2;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class UserBean {
    @Id
    private Long lId;
    private String name;
    private int image;
    @Generated(hash = 1757881045)
    public UserBean(Long lId, String name, int image) {
        this.lId = lId;
        this.name = name;
        this.image = image;
    }
    @Generated(hash = 1203313951)
    public UserBean() {
    }
    public Long getLId() {
        return this.lId;
    }
    public void setLId(Long lId) {
        this.lId = lId;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getImage() {
        return this.image;
    }
    public void setImage(int image) {
        this.image = image;
    }
}
