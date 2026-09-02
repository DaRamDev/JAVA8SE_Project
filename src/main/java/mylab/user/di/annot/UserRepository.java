package main.java.mylab.user.di.annot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository // 빈 등록
public class UserRepository {
    
    @Value("MySQL") // dbType에 "MySQL" 값 자동 주입
    private String dbType;
    
    public UserRepository() {}
    
    public String getDbType() { return dbType; }
    
    public void setDbType(String dbType) { this.dbType = dbType; }
    
    public boolean saveUser(String userId, String name) {
        System.out.println("사용자 저장: " + userId + ", " + name + " (DB: " + dbType + ")");
        return true;
    }
    
    @Override
    public String toString() {
        return "UserRepository [dbType=" + dbType + "]";
    }
}