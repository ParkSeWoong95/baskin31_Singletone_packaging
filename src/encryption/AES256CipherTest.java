package encryption;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
 
public class AES256CipherTest {
	String userPw = null;
	public AES256CipherTest(String userPw){
		this.userPw = userPw;
	}
 @Test public String encDesTest() throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException{
     AES256Cipher a256 = AES256Cipher.getInstance();
 
     String aesPw = a256.AES_Encode(userPw);
     return aesPw;
 }
}