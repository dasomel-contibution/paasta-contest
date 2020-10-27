import egovframework.rte.fdl.cryptography.EgovPasswordEncoder;

/**
 * Crypto Config 설정에 algorithmKey, algorithmKeyHash 인코딩 키 생성 방법을 제공한다
 * 하단 코드에서 계정암호화키 키 값을 원하는 값으로 설정한다.
 */
public class EgovEnvCryptoAlgorithmCreateTest {

    //계정암호화키 키
    public String algorithmKey = "계정 암호화키 키";

    //계정암호화 알고리즘(MD5, SHA-1, SHA-256)
    public String algorithm = "SHA-256";

    //계정암호화키 블럭사이즈
    public int algorithmBlockSize = 1024;

    public static void main(String[] args) {
        EgovEnvCryptoAlgorithmCreateTest cryptoTest = new EgovEnvCryptoAlgorithmCreateTest();

        EgovPasswordEncoder egovPasswordEncoder = new EgovPasswordEncoder();
        egovPasswordEncoder.setAlgorithm(cryptoTest.algorithm);

        System.out.println("------------------------------------------------------");
        System.out.println("알고리즘(algorithm) : "+cryptoTest.algorithm);
        System.out.println("알고리즘 키(algorithmKey) : "+cryptoTest.algorithmKey);
        System.out.println("알고리즘 키 Hash(algorithmKeyHash) : "+egovPasswordEncoder.encryptPassword(cryptoTest.algorithmKey));
        System.out.println("알고리즘 블럭사이즈(algorithmBlockSize)  :"+cryptoTest.algorithmBlockSize);
        System.out.println("암호화  :"+cryptoTest.algorithmBlockSize);

    }
}