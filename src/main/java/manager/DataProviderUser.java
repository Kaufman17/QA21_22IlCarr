package manager;
import models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class DataProviderUser {
    @DataProvider
    public Iterator<Object[]> loginData() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"chara@gmail.com", "Chara12345$"});
        list.add(new Object[]{"chara@gmail.com", "Chara12345$"});
       // list.add(new Object[]{"sonya@gmail.com", "Ss12345$"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> example(){
        List<Object[]> list = new ArrayList<>();

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginFile(){
        List<Object[]> list = new ArrayList<>();

        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> loginModels(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().setEmail("chara@gmail.com").setPassword("Chara12345$")});
        list.add(new Object[]{new User().setEmail("chara@gmail.com").setPassword("Chara12345$")});
       // list.add(new Object[]{new User().setEmail("sonya@gmail.com").setPassword("Ss12345$")});

        return list.iterator();
    }

}
