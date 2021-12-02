
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

@ManagedBean					
@SessionScoped	
public class JSF_ExamleTest implements Serializable  {

String name;
String phone;

private int adultNumber;
private int childrenNumber;

private int sum;

private String view;

public void setAdult(Integer peopleNumber)
{
    this.adultNumber=peopleNumber;
}
public void setChild(Integer childrenNumber)
{
    this.childrenNumber=childrenNumber;
}
public void setSum(int adultNumber, int childrenNumber)
{
    this.sum=adultNumber+childrenNumber;
}

public void setView(String chossing)
{
    this.view=chossing;
}

public int getAdult()
{
    return adultNumber;
}
public int getChild()
{
    return childrenNumber;
}

public void sumOfPeople () {
    setSum(adultNumber , childrenNumber);
}

public String getViewResult () {
    return "Your choose: "+view;
}

    
}
