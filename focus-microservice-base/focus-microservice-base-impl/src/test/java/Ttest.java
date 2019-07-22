import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;

/**
 * @Description
 * @Author Melo
 * @Date 2019/6/7 0007 下午 6:50
 */
public class Ttest {

    @Test
    public void test(){
        String password = new SimpleHash("md5","123456", "123", 2).toString();
        System.out.println(password);
    }
}
