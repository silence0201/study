package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.LoginService;
import service.impl.LoginServiceImpl;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Description: LoginAction
 * Author: silence
 * Update: silence(2016-06-30 07:57)
 */
public class LoginAction extends ActionSupport {
    private Integer account;
    private String password;

    public String login(){
        LoginService ls = new LoginServiceImpl();
        if (ls.getUserInfo(account,password)){
            HttpSession session = ServletActionContext.getRequest().getSession();
            session.setAttribute("account",account);
            return SUCCESS;
        }
        return ERROR;
    }

    public String logout(){
        Map session = ActionContext.getContext().getSession();
        session.remove("account");
        return SUCCESS;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
