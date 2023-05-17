import java.util.HashMap;

public class Passwords {

    HashMap<String,String> loginInfo = new HashMap<>();

    Passwords(){

        loginInfo.put("ahmed","ahmed");
        loginInfo.put("zeyad","zeyad");
        loginInfo.put("abdullah","abdullah");
        loginInfo.put("youssef","youssef");
        loginInfo.put("omar","omar");
    }

    public HashMap getLoginInfo(){
        return loginInfo;
    }
}