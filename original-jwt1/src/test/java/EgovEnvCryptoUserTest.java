import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import egovframework.rte.fdl.cryptography.EgovEnvCryptoService;
import egovframework.rte.fdl.cryptography.impl.EgovEnvCryptoServiceImpl;

/**
 * 데이터베이스 연결 항목(Url, UserName, Password) 인코딩 값 생성 JAVA
 */
public class EgovEnvCryptoUserTest {

    public static void main(String[] args) {

        String[] arrCryptoString = {
                "사용자 아이디",         //데이터베이스 접속 계정 설정
                "사용자 비밀번호",   //데이터베이스 접속 패드워드 설정
                "접속 주소",            //데이터베이스 접속 주소 설정
                "데이터 베이스 드라이버"  //데이터베이스 드라이버
        };


        System.out.println("------------------------------------------------------");
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:/context-crypto-test.xml"});
        EgovEnvCryptoService cryptoService = context.getBean(EgovEnvCryptoServiceImpl.class);
        System.out.println("------------------------------------------------------");

        String label = "";
        try {
            for(int i=0; i < arrCryptoString.length; i++) {
                if(i==0)label = "사용자 아이디";
                if(i==1)label = "사용자 비밀번호";
                if(i==2)label = "접속 주소";
                if(i==3)label = "데이터 베이스 드라이버";
                System.out.println(label+" 원본(orignal):" + arrCryptoString[i]);
                System.out.println(label+" 인코딩(encrypted):" + cryptoService.encrypt(arrCryptoString[i]));
                System.out.println("------------------------------------------------------");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("["+e.getClass()+"] IllegalArgumentException : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("["+e.getClass()+"] Exception : " + e.getMessage());
        }

    }

}